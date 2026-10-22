// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper;
import net.minecraft.world.phys.Vec3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("RocketBoostHelper Reality Tests")
class RocketBoostHelperTest {

    @Test
    @DisplayName("Assert snappy vanilla boost when flying below initial boost threshold")
    void testInitialBoostSnappyAcceleration() {
        Vec3 oldMovement = new Vec3(0.5, 0.0, 0.0);
        Vec3 lookAngle = new Vec3(1.0, 0.0, 0.0);
        double initialBoostSpeedTicks = 1.5; // 30 BPS
        double maxSpeedTicks = 5.0;          // 100 BPS
        double highAccFactor = 0.15;

        Vec3 result = RocketBoostHelper.calculateBoostMovement(
            oldMovement, lookAngle, initialBoostSpeedTicks, maxSpeedTicks, highAccFactor
        );

        // Vanilla formula: targetBoost = look * 0.1 + (look * 1.5 - old) * 0.5
        // targetBoost.x = 0.1 + (1.5 - 0.5) * 0.5 = 0.1 + 0.5 = 0.6
        // targetMovement.x = 0.5 + 0.6 = 1.1
        assertEquals(1.1, result.x, 1e-6);
        assertEquals(0.0, result.y, 1e-6);
        assertEquals(0.0, result.z, 1e-6);
    }

    @Test
    @DisplayName("Assert proportional acceleration pulling toward max speed when above initial threshold")
    void testHighSpeedProportionalAcceleration() {
        Vec3 oldMovement = new Vec3(2.0, 0.0, 0.0); // 40 BPS (> 30 BPS threshold)
        Vec3 lookAngle = new Vec3(1.0, 0.0, 0.0);
        double initialBoostSpeedTicks = 1.5; // 30 BPS
        double maxSpeedTicks = 5.0;          // 100 BPS
        double highAccFactor = 0.15;         // 15% convergence

        Vec3 result = RocketBoostHelper.calculateBoostMovement(
            oldMovement, lookAngle, initialBoostSpeedTicks, maxSpeedTicks, highAccFactor
        );

        // Proportional formula: targetBoost = look * 0.1 + (look * 5.0 - old) * 0.15
        // targetBoost.x = 0.1 + (5.0 - 2.0) * 0.15 = 0.1 + 0.45 = 0.55
        // targetMovement.x = 2.0 + 0.55 = 2.55 (yields ~51 BPS after 1 tick)
        assertEquals(2.55, result.x, 1e-6);
        assertEquals(0.0, result.y, 1e-6);
        assertEquals(0.0, result.z, 1e-6);
    }

    @Test
    @DisplayName("Assert strict velocity clamping at configured max flight speed ceiling")
    void testMaxSpeedClamping() {
        Vec3 oldMovement = new Vec3(4.9, 0.0, 0.0);
        Vec3 lookAngle = new Vec3(1.0, 0.0, 0.0);
        double initialBoostSpeedTicks = 1.5;
        double maxSpeedTicks = 5.0;
        double highAccFactor = 0.50; // Fast acceleration pushing beyond ceiling

        Vec3 result = RocketBoostHelper.calculateBoostMovement(
            oldMovement, lookAngle, initialBoostSpeedTicks, maxSpeedTicks, highAccFactor
        );

        assertTrue(result.length() <= maxSpeedTicks + 1e-6, "Movement speed must not exceed max speed ceiling");
        assertEquals(maxSpeedTicks, result.length(), 1e-6);
    }

    @Test
    @DisplayName("Assert strict null safety without throwing NullPointerException")
    void testNullVectorSafety() {
        Vec3 result = RocketBoostHelper.calculateBoostMovement(null, null, 1.5, 5.0, 0.15);
        assertNotNull(result);
        assertEquals(0.0, result.length(), 1e-6);

        Vec3 resultWithNullLook = RocketBoostHelper.calculateBoostMovement(new Vec3(1.0, 0.0, 0.0), null, 1.5, 5.0, 0.15);
        assertNotNull(resultWithNullLook);
    }
}
