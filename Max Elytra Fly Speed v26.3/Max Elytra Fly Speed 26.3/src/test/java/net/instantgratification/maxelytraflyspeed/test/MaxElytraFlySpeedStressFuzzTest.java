// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import java.util.Random;
import net.instantgratification.maxelytraflyspeed.util.ElytraDragHelper;
import net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper;
import net.minecraft.world.phys.Vec3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pillar 1: Chaos Property Fuzzing Suite for Max Elytra Fly Speed.
 * Executes 10,000+ randomized iterations validating mathematical bounds,
 * aerodynamic drag calculations, rocket boost vectors, arithmetic saturation,
 * and NaN/Infinity guards under extreme stress.
 */
@DisplayName("Pillar 1: Chaos & Property Fuzzing Harness")
class MaxElytraFlySpeedStressFuzzTest {

    private static final long SEED = 0xDA51C263L;
    private static final int ITERATIONS = 15_000;

    private static final int[] EXTREME_SPEEDS = {
        Integer.MIN_VALUE, -1_000_000, -50, -1, 0, 1, 10, 30, 50, 100,
        200, 500, 1_000, 50_000, 1_000_000, Integer.MAX_VALUE - 1, Integer.MAX_VALUE
    };

    @Test
    @DisplayName("Pillar 1: 15,000 Iterations Chaos Fuzzing of ElytraDragHelper")
    void testElytraDragHelperChaosFuzzing() {
        Random rng = new Random(SEED);

        for (int i = 0; i < ITERATIONS; i++) {
            int maxSpeedBps;
            if (i < EXTREME_SPEEDS.length) {
                maxSpeedBps = EXTREME_SPEEDS[i];
            } else {
                maxSpeedBps = switch (rng.nextInt(4)) {
                    case 0 -> -rng.nextInt(10_000);
                    case 1 -> rng.nextInt(51);
                    case 2 -> 50 + rng.nextInt(500);
                    default -> 500 + rng.nextInt(1_000_000);
                };
            }

            double vx = (rng.nextDouble() - 0.5) * 200.0;
            double vy = (rng.nextDouble() - 0.5) * 200.0;
            double vz = (rng.nextDouble() - 0.5) * 200.0;
            Vec3 movement = new Vec3(vx, vy, vz);

            Vec3 result = ElytraDragHelper.calculateFallFlyingDrag(movement, maxSpeedBps);

            assertNotNull(result, "Drag result must never be null");
            assertFalse(Double.isNaN(result.x), "Drag x must never be NaN");
            assertFalse(Double.isNaN(result.y), "Drag y must never be NaN");
            assertFalse(Double.isNaN(result.z), "Drag z must never be NaN");
            assertFalse(Double.isInfinite(result.x), "Drag x must never be Infinite");
            assertFalse(Double.isInfinite(result.y), "Drag y must never be Infinite");
            assertFalse(Double.isInfinite(result.z), "Drag z must never be Infinite");

            // Aerodynamic drag damping should preserve vector sign (non-inverting)
            if (movement.x != 0.0) {
                assertTrue(Math.signum(result.x) == Math.signum(movement.x) || result.x == 0.0);
            }
            if (movement.y != 0.0) {
                assertTrue(Math.signum(result.y) == Math.signum(movement.y) || result.y == 0.0);
            }
            if (movement.z != 0.0) {
                assertTrue(Math.signum(result.z) == Math.signum(movement.z) || result.z == 0.0);
            }
        }
    }

    @Test
    @DisplayName("Pillar 1: 15,000 Iterations Chaos Fuzzing of RocketBoostHelper")
    void testRocketBoostHelperChaosFuzzing() {
        Random rng = new Random(SEED + 100);

        for (int i = 0; i < ITERATIONS; i++) {
            double initialBoostTicks = 0.5 + rng.nextDouble() * 5.0; // 10 to 110 BPS
            double maxSpeedTicks = initialBoostTicks + rng.nextDouble() * 20.0; // up to 500 BPS
            double highAccFactor = 0.01 + rng.nextDouble() * 0.99; // 1% to 100%

            double mx = (rng.nextDouble() - 0.5) * 100.0;
            double my = (rng.nextDouble() - 0.5) * 100.0;
            double mz = (rng.nextDouble() - 0.5) * 100.0;
            Vec3 oldMovement = new Vec3(mx, my, mz);

            double lx = (rng.nextDouble() - 0.5) * 2.0;
            double ly = (rng.nextDouble() - 0.5) * 2.0;
            double lz = (rng.nextDouble() - 0.5) * 2.0;
            Vec3 lookAngle = new Vec3(lx, ly, lz);
            if (lookAngle.lengthSqr() > 1e-4) {
                lookAngle = lookAngle.normalize();
            }

            Vec3 result = RocketBoostHelper.calculateBoostMovement(
                oldMovement, lookAngle, initialBoostTicks, maxSpeedTicks, highAccFactor
            );

            assertNotNull(result, "Rocket boost result must never be null");
            assertFalse(Double.isNaN(result.x), "Rocket boost x must not be NaN");
            assertFalse(Double.isNaN(result.y), "Rocket boost y must not be NaN");
            assertFalse(Double.isNaN(result.z), "Rocket boost z must not be NaN");
            assertFalse(Double.isInfinite(result.x), "Rocket boost x must not be Infinite");
            assertFalse(Double.isInfinite(result.y), "Rocket boost y must not be Infinite");
            assertFalse(Double.isInfinite(result.z), "Rocket boost z must not be Infinite");

            // Absolute clamping ceiling assertion
            assertTrue(
                result.length() <= maxSpeedTicks + 1e-5,
                "Result velocity must never exceed maxSpeedTicks ceiling: got " + result.length() + ", ceiling: " + maxSpeedTicks
            );
        }
    }
}
