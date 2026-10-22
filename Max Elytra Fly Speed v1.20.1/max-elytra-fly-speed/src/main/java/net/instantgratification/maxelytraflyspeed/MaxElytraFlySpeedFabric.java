// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.CustomGameRuleCategory;
import net.minecraft.world.level.GameRules;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxElytraFlySpeedFabric implements ModInitializer {
    public static final String MOD_ID = "max-elytra-fly-speed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Sovereign GameRule Category (Core Standard)
    public static final CustomGameRuleCategory CUSTOM_CATEGORY = DynamicGameRuleManager.registerCategory(
        new ResourceLocation(MOD_ID, MOD_ID),
        Component.translatable("gamerule.category." + MOD_ID)
    );

    public static GameRules.Key<GameRules.IntegerValue> MAX_ELYTRA_FLY_SPEED;
    public static GameRules.Key<GameRules.IntegerValue> ELYTRA_INITIAL_BOOST_SPEED;
    public static GameRules.Key<GameRules.IntegerValue> ELYTRA_HIGH_SPEED_ACCELERATION;

    @Override
    public void onInitialize() {
        LOGGER.info("Instant Gratification: Max Elytra Fly Speed Initializing...");

        MAX_ELYTRA_FLY_SPEED = DynamicGameRuleManager.integerRule(MOD_ID + ":max_elytra_fly_speed", CUSTOM_CATEGORY, 50)
            .name("Max Elytra Fly Speed")
            .description("Maximum velocity of Elytra flight in Blocks/Second. Default: 50 blocks/sec.")
            .min(1)
            .register();

        ELYTRA_INITIAL_BOOST_SPEED = DynamicGameRuleManager.integerRule(MOD_ID + ":elytra_initial_boost_speed", CUSTOM_CATEGORY, 30)
            .name("Initial Boost Speed")
            .description("Speed threshold (Blocks/Second) up to which snappy vanilla rocket boost is applied. Default: 30.")
            .min(1)
            .register();

        ELYTRA_HIGH_SPEED_ACCELERATION = DynamicGameRuleManager.integerRule(MOD_ID + ":elytra_high_speed_acceleration", CUSTOM_CATEGORY, 15)
            .name("High Speed Acceleration")
            .description("High-speed acceleration rate percentage above initial speed. Default: 15 (15% per tick).")
            .range(1, 1000)
            .register();
    }
}
