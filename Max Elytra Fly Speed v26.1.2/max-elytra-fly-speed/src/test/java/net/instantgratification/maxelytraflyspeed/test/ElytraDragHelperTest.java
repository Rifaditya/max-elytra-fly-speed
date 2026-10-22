// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import net.instantgratification.maxelytraflyspeed.util.ElytraDragHelper;
import net.minecraft.world.phys.Vec3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("ElytraDragHelper Reality Tests")
class ElytraDragHelperTest {

    @Test
    @DisplayName("Assert vanilla 0.99H / 0.98V drag parity at or below 50 BPS")
    void testVanillaParityDragAtOrBelow50Bps() {
        Vec3 input = new Vec3(1.0, 1.0, 1.0);

        // At 30 BPS (vanilla setting)
        Vec3 drag30 = ElytraDragHelper.calculateFallFlyingDrag(input, 30);
        assertEquals(0.99, drag30.x, 1e-6);
        assertEquals(0.98, drag30.y, 1e-6);
        assertEquals(0.99, drag30.z, 1e-6);

        // At 50 BPS (mod default setting)
        Vec3 drag50 = ElytraDragHelper.calculateFallFlyingDrag(input, 50);
        assertEquals(0.99, drag50.x, 1e-6);
        assertEquals(0.98, drag50.y, 1e-6);
        assertEquals(0.99, drag50.z, 1e-6);
    }

    @Test
    @DisplayName("Assert relaxed aerodynamic drag floor scaling at high speeds (100 and 200 BPS)")
    void testDynamicDragReductionAbove50Bps() {
        Vec3 input = new Vec3(1.0, 1.0, 1.0);

        // At 100 BPS (speedRatio = 2.0 -> dragLossH = 0.005, dragLossV = 0.010)
        Vec3 drag100 = ElytraDragHelper.calculateFallFlyingDrag(input, 100);
        assertEquals(0.995, drag100.x, 1e-6);
        assertEquals(0.990, drag100.y, 1e-6);
        assertEquals(0.995, drag100.z, 1e-6);

        // At 200 BPS (speedRatio = 4.0 -> dragLossH = 0.0025, dragLossV = 0.0050)
        Vec3 drag200 = ElytraDragHelper.calculateFallFlyingDrag(input, 200);
        assertEquals(0.9975, drag200.x, 1e-6);
        assertEquals(0.9950, drag200.y, 1e-6);
        assertEquals(0.9975, drag200.z, 1e-6);
    }

    @Test
    @DisplayName("Assert strict null safety without throwing NullPointerException")
    void testNullVectorSafety() {
        Vec3 result = ElytraDragHelper.calculateFallFlyingDrag(null, 50);
        assertNotNull(result);
        assertEquals(0.0, result.length(), 1e-6);
    }
}
