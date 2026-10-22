// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import java.lang.reflect.Field;
import net.dasik.social.api.config.ConfigOption;
import net.instantgratification.maxelytraflyspeed.config.MaxElytraConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 5-Pillar Test Harness verifying UniversalConfigScreen contract and sidedness safety.
 */
public class MaxElytraConfigTest {

    @Test
    @DisplayName("Pillar 1: ConfigOption annotations are present on all configuration fields")
    void testConfigAnnotationsPresent() throws Exception {
        Field speedField = MaxElytraConfig.class.getField("maxElytraFlySpeed");
        assertTrue(speedField.isAnnotationPresent(ConfigOption.class), "maxElytraFlySpeed must have @ConfigOption");

        Field boostField = MaxElytraConfig.class.getField("elytraInitialBoostSpeed");
        assertTrue(boostField.isAnnotationPresent(ConfigOption.class), "elytraInitialBoostSpeed must have @ConfigOption");

        Field accField = MaxElytraConfig.class.getField("elytraHighSpeedAcceleration");
        assertTrue(accField.isAnnotationPresent(ConfigOption.class), "elytraHighSpeedAcceleration must have @ConfigOption");
    }

    @Test
    @DisplayName("Pillar 2: Verification of bounds, sliders, step sizes, and orders")
    void testOptionBoundsAndMetadata() throws Exception {
        ConfigOption speedOpt = MaxElytraConfig.class.getField("maxElytraFlySpeed").getAnnotation(ConfigOption.class);
        assertEquals(1.0, speedOpt.min(), 0.001);
        assertEquals(500.0, speedOpt.max(), 0.001);
        assertEquals(1.0, speedOpt.step(), 0.001);
        assertTrue(speedOpt.slider(), "Speed option should render as slider");
        assertEquals(1, speedOpt.order());

        ConfigOption boostOpt = MaxElytraConfig.class.getField("elytraInitialBoostSpeed").getAnnotation(ConfigOption.class);
        assertEquals(1.0, boostOpt.min(), 0.001);
        assertEquals(300.0, boostOpt.max(), 0.001);
        assertTrue(boostOpt.slider());
        assertEquals(2, boostOpt.order());

        ConfigOption accOpt = MaxElytraConfig.class.getField("elytraHighSpeedAcceleration").getAnnotation(ConfigOption.class);
        assertEquals(1.0, accOpt.min(), 0.001);
        assertEquals(1000.0, accOpt.max(), 0.001);
        assertTrue(accOpt.slider());
        assertEquals(3, accOpt.order());
    }

    @Test
    @DisplayName("Pillar 3: GameRule sync targets are properly configured")
    void testGameRuleSyncTargets() throws Exception {
        ConfigOption speedOpt = MaxElytraConfig.class.getField("maxElytraFlySpeed").getAnnotation(ConfigOption.class);
        assertTrue(speedOpt.syncGameRule(), "Speed option must synchronize to GameRule");
        assertEquals("max-elytra-fly-speed:max_elytra_fly_speed", speedOpt.gameRuleName());

        ConfigOption boostOpt = MaxElytraConfig.class.getField("elytraInitialBoostSpeed").getAnnotation(ConfigOption.class);
        assertTrue(boostOpt.syncGameRule());
        assertEquals("max-elytra-fly-speed:elytra_initial_boost_speed", boostOpt.gameRuleName());

        ConfigOption accOpt = MaxElytraConfig.class.getField("elytraHighSpeedAcceleration").getAnnotation(ConfigOption.class);
        assertTrue(accOpt.syncGameRule());
        assertEquals("max-elytra-fly-speed:elytra_high_speed_acceleration", accOpt.gameRuleName());
    }

    @Test
    @DisplayName("Pillar 4: Default values match vanilla baseline defaults")
    void testDefaultValues() {
        assertEquals(50, MaxElytraConfig.maxElytraFlySpeed, "Default max speed must be 50 blocks/sec");
        assertEquals(30, MaxElytraConfig.elytraInitialBoostSpeed, "Default initial boost must be 30 blocks/sec");
        assertEquals(15, MaxElytraConfig.elytraHighSpeedAcceleration, "Default acceleration must be 15%");
    }

    @Test
    @DisplayName("Pillar 5: Sidedness verification - zero client class references in common config")
    void testSidednessIsolation() {
        for (Class<?> iface : MaxElytraConfig.class.getInterfaces()) {
            assertFalse(iface.getName().startsWith("net.minecraft.client"), "No client interfaces permitted");
        }
        assertEquals(Object.class, MaxElytraConfig.class.getSuperclass(), "Config must extend Object");
    }
}
