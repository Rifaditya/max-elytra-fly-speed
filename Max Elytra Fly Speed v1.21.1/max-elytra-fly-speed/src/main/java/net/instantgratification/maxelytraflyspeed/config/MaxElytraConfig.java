// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.config;

import net.dasik.social.api.config.ConfigOption;

/**
 * Declarative configuration for Max Elytra Fly Speed.
 * <p>
 * Automatically introspected by {@code UniversalConfigScreen} and synchronized to
 * in-game GameRules in singleplayer worlds. Strictly side-safe with 0 client imports.
 */
public class MaxElytraConfig {

    @ConfigOption(
        category = "gamerule.category.max-elytra-fly-speed.max-elytra-fly-speed",
        nameKey = "gamerule.max-elytra-fly-speed.max_elytra_fly_speed",
        descriptionKey = "gamerule.max-elytra-fly-speed.max_elytra_fly_speed.description",
        min = 1,
        max = 500,
        step = 1,
        slider = true,
        order = 1,
        syncGameRule = true,
        gameRuleName = "max-elytra-fly-speed:max_elytra_fly_speed"
    )
    public static int maxElytraFlySpeed = 50;

    @ConfigOption(
        category = "gamerule.category.max-elytra-fly-speed.max-elytra-fly-speed",
        nameKey = "gamerule.max-elytra-fly-speed.elytra_initial_boost_speed",
        descriptionKey = "gamerule.max-elytra-fly-speed.elytra_initial_boost_speed.description",
        min = 1,
        max = 300,
        step = 1,
        slider = true,
        order = 2,
        syncGameRule = true,
        gameRuleName = "max-elytra-fly-speed:elytra_initial_boost_speed"
    )
    public static int elytraInitialBoostSpeed = 30;

    @ConfigOption(
        category = "gamerule.category.max-elytra-fly-speed.max-elytra-fly-speed",
        nameKey = "gamerule.max-elytra-fly-speed.elytra_high_speed_acceleration",
        descriptionKey = "gamerule.max-elytra-fly-speed.elytra_high_speed_acceleration.description",
        min = 1,
        max = 1000,
        step = 1,
        slider = true,
        order = 3,
        syncGameRule = true,
        gameRuleName = "max-elytra-fly-speed:elytra_high_speed_acceleration"
    )
    public static int elytraHighSpeedAcceleration = 15;
}
