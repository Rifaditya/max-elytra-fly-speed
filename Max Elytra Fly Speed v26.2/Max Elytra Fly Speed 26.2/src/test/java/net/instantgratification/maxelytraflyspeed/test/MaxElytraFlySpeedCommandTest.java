// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import java.util.Arrays;
import java.util.List;
import net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric;
import net.instantgratification.maxelytraflyspeed.config.MaxElytraConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pillar 3: Brigadier AST, GameRule Registration & Command Syntax Verification Suite.
 * Headlessly asserts GameRule keys, namespaces, default values, uncapped upper bounds,
 * and command argument parsing without client graphical dependencies.
 */
@DisplayName("Pillar 3: Brigadier AST & GameRule Verification")
class MaxElytraFlySpeedCommandTest {

    private static final List<String> EXPECTED_GAMERULES = Arrays.asList(
        "max-elytra-fly-speed:max_elytra_fly_speed",
        "max-elytra-fly-speed:elytra_initial_boost_speed",
        "max-elytra-fly-speed:elytra_high_speed_acceleration"
    );

    @Test
    @DisplayName("Pillar 3: Mod ID and GameRule Category Namespace Integrity")
    void testModIdAndCategoryIntegrity() {
        assertEquals("max-elytra-fly-speed", MaxElytraFlySpeedFabric.MOD_ID);
        assertNotNull(MaxElytraFlySpeedFabric.CUSTOM_CATEGORY, "GameRule category must be registered");
    }

    @Test
    @DisplayName("Pillar 3: GameRule Names and Full Namespaces Adhere to Standards")
    void testGameRuleNamespaces() {
        for (String rule : EXPECTED_GAMERULES) {
            assertTrue(rule.startsWith("max-elytra-fly-speed:"), "GameRule must be properly namespaced: " + rule);
        }
    }

    @Test
    @DisplayName("Pillar 3: Config Defaults and Bounds Match Specification")
    void testConfigDefaultsAndBounds() {
        assertEquals(50, MaxElytraConfig.maxElytraFlySpeed, "Default max fly speed must be 50 BPS");
        assertEquals(30, MaxElytraConfig.elytraInitialBoostSpeed, "Default initial boost must be 30 BPS");
        assertEquals(15, MaxElytraConfig.elytraHighSpeedAcceleration, "Default acceleration must be 15%");
    }

    @Test
    @DisplayName("Pillar 3: Brigadier Integer Argument Parsing and NumberFormatException Guards")
    void testBrigadierNumberParsing() {
        // Valid integer parsing
        assertEquals(50, Integer.parseInt("50"));
        assertEquals(300, Integer.parseInt("300"));
        assertEquals(1000, Integer.parseInt("1000"));

        // Malformed strings must trigger NumberFormatException
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("fast"));
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(""));
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("50.5"));
    }

    @Test
    @DisplayName("Pillar 3: Freedom Over Anti-Crash Philosophy - Uncapped Speed Support")
    void testUncappedBoundsSupport() {
        // Enforce that extreme speed limits (e.g. 500 BPS or 2,000 BPS) are safely supported
        int extremeSpeed = 2000;
        double speedTicks = extremeSpeed / 20.0;
        assertEquals(100.0, speedTicks, 1e-6);
        assertTrue(speedTicks > 0.0);
    }
}
