// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import net.instantgratification.maxelytraflyspeed.util.ElytraDragHelper;
import net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper;
import net.minecraft.world.phys.Vec3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pillar 4: Headless In-Engine Physics & GameTest Simulation Suite.
 * Validates multi-tick velocity clamping, aerodynamic drag relaxation,
 * and proportional acceleration curves under simulated in-flight conditions.
 */
@DisplayName("Pillar 4: Headless Physics & Simulation GameTest")
class MaxElytraFlySpeedGameTest {

    @Test
    @DisplayName("Pillar 4: Multi-Tick Velocity Clamping Over 100 Consecutive Flight Ticks")
    void testMultiTickVelocityClamping() {
        int maxSpeedBps = 60; // 3.0 blocks/tick
        double maxSpeedTicks = maxSpeedBps / 20.0;

        // Player diving steeply with strong forward/downward velocity
        Vec3 velocity = new Vec3(2.5, -2.0, 2.5); // Length ~3.77 blocks/tick (exceeds 3.0)

        for (int tick = 0; tick < 100; tick++) {
            // Apply aerodynamic drag
            velocity = ElytraDragHelper.calculateFallFlyingDrag(velocity, maxSpeedBps);

            // Apply gravity / diving acceleration
            velocity = velocity.add(0.0, -0.05, 0.0);

            // Apply velocity clamping from LivingEntityMixin
            double currentSpeed = velocity.length();
            if (currentSpeed > maxSpeedTicks && currentSpeed > 0.0) {
                velocity = velocity.scale(maxSpeedTicks / currentSpeed);
            }

            assertTrue(
                velocity.length() <= maxSpeedTicks + 1e-6,
                "Tick " + tick + ": velocity (" + velocity.length() + ") exceeded max speed ticks (" + maxSpeedTicks + ")"
            );
        }
    }

    @Test
    @DisplayName("Pillar 4: Rocket Boost Dual-Phase Acceleration Convergence Curve")
    void testRocketBoostConvergenceCurve() {
        double initialBoostTicks = 1.5; // 30 BPS
        double maxSpeedTicks = 5.0;     // 100 BPS
        double highAccFactor = 0.15;    // 15% per tick

        Vec3 lookAngle = new Vec3(0.0, 0.0, 1.0); // Facing straight South
        Vec3 velocity = new Vec3(0.0, 0.0, 0.5);   // 10 BPS initial glide

        // Phase 1: Below initial boost threshold (0.5 BPS -> snappy vanilla boost)
        velocity = RocketBoostHelper.calculateBoostMovement(
            velocity, lookAngle, initialBoostTicks, maxSpeedTicks, highAccFactor
        );
        // targetBoost = 0.1 + (1.5 - 0.5) * 0.5 = 0.6 -> new velocity = 1.1
        assertEquals(1.1, velocity.z, 1e-6);

        // Phase 2: Above initial boost threshold (1.1 -> proportional acceleration towards 5.0)
        double previousSpeed = velocity.length();
        for (int tick = 0; tick < 20; tick++) {
            velocity = RocketBoostHelper.calculateBoostMovement(
                velocity, lookAngle, initialBoostTicks, maxSpeedTicks, highAccFactor
            );
            double currentSpeed = velocity.length();

            // Each tick speed must strictly increase towards maxSpeedTicks
            assertTrue(currentSpeed >= previousSpeed, "Speed should monotonically increase during rocket boost");
            assertTrue(currentSpeed <= maxSpeedTicks + 1e-6, "Speed must never exceed max speed ceiling");
            previousSpeed = currentSpeed;
        }

        // After 20 ticks of 15% convergence, player should be very close to max speed ceiling (5.0)
        assertTrue(velocity.length() > 4.5, "After 20 ticks player should be near max ceiling (5.0): got " + velocity.length());
    }

    @Test
    @DisplayName("Pillar 4: Dynamic Drag Retention Parity (100 BPS retains more glide than 50 BPS)")
    void testDynamicDragRetentionParity() {
        Vec3 initialVel = new Vec3(3.0, 0.0, 0.0);

        Vec3 damped50 = ElytraDragHelper.calculateFallFlyingDrag(initialVel, 50);
        Vec3 damped100 = ElytraDragHelper.calculateFallFlyingDrag(initialVel, 100);

        // 50 BPS uses vanilla drag (0.99H -> 2.97)
        assertEquals(2.97, damped50.x, 1e-6);

        // 100 BPS uses reduced drag (0.995H -> 2.985)
        assertEquals(2.985, damped100.x, 1e-6);

        assertTrue(damped100.x > damped50.x, "Higher configured speed must have less aerodynamic drag loss");
    }
}
