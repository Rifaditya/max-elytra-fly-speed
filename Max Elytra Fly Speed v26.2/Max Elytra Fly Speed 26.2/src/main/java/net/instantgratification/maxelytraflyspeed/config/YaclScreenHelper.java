// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import net.dasik.social.api.config.DasikSupportHelper;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.gamerules.GameRule;

public class YaclScreenHelper {
    public static ConfigScreenFactory<?> createScreen() {
        return YaclScreenHelper::buildScreen;
    }

    private static Screen buildScreen(Screen parent) {
        Minecraft client = Minecraft.getInstance();

        int initialMaxSpeed = 50;
        int initialInitialBoost = 30;
        int initialHighSpeedAcc = 15;

        if (client.level != null) {
            initialMaxSpeed = DynamicGameRuleManager.getInt(client.level, MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED);
            initialInitialBoost = DynamicGameRuleManager.getInt(client.level, MaxElytraFlySpeedFabric.ELYTRA_INITIAL_BOOST_SPEED);
            initialHighSpeedAcc = DynamicGameRuleManager.getInt(client.level, MaxElytraFlySpeedFabric.ELYTRA_HIGH_SPEED_ACCELERATION);
        }

        int[] state = new int[] { initialMaxSpeed, initialInitialBoost, initialHighSpeedAcc };

        var generalCategory = ConfigCategory.createBuilder()
            .name(Component.translatable("gamerule.category.max-elytra-fly-speed.max-elytra-fly-speed"));

        // Top-pinned Creator Support Button
        Option<?> kofiButton = (Option<?>) DasikSupportHelper.createYaclButton();
        if (kofiButton != null) {
            generalCategory.option(kofiButton);
        }

        // Max Speed (Blocks/Sec)
        generalCategory.option(Option.<Integer>createBuilder()
            .name(Component.translatable("gamerule.max-elytra-fly-speed.max_elytra_fly_speed"))
            .description(OptionDescription.of(Component.translatable("gamerule.max-elytra-fly-speed.max_elytra_fly_speed.description")))
            .binding(
                50,
                () -> state[0],
                val -> {
                    state[0] = val;
                    applyRule(client, MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED, val);
                }
            )
            .controller(opt -> IntegerFieldControllerBuilder.create(opt).min(1))
            .build());

        // Initial Boost Speed
        generalCategory.option(Option.<Integer>createBuilder()
            .name(Component.translatable("gamerule.max-elytra-fly-speed.elytra_initial_boost_speed"))
            .description(OptionDescription.of(Component.translatable("gamerule.max-elytra-fly-speed.elytra_initial_boost_speed.description")))
            .binding(
                30,
                () -> state[1],
                val -> {
                    state[1] = val;
                    applyRule(client, MaxElytraFlySpeedFabric.ELYTRA_INITIAL_BOOST_SPEED, val);
                }
            )
            .controller(opt -> IntegerFieldControllerBuilder.create(opt).min(1))
            .build());

        // High Speed Acceleration
        generalCategory.option(Option.<Integer>createBuilder()
            .name(Component.translatable("gamerule.max-elytra-fly-speed.elytra_high_speed_acceleration"))
            .description(OptionDescription.of(Component.translatable("gamerule.max-elytra-fly-speed.elytra_high_speed_acceleration.description")))
            .binding(
                15,
                () -> state[2],
                val -> {
                    state[2] = val;
                    applyRule(client, MaxElytraFlySpeedFabric.ELYTRA_HIGH_SPEED_ACCELERATION, val);
                }
            )
            .controller(opt -> IntegerFieldControllerBuilder.create(opt).min(1).max(1000))
            .build());

        return YetAnotherConfigLib.createBuilder()
            .title(Component.translatable("gamerule.category.max-elytra-fly-speed.max-elytra-fly-speed"))
            .category(generalCategory.build())
            .save(() -> {
                applyRule(client, MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED, state[0]);
                applyRule(client, MaxElytraFlySpeedFabric.ELYTRA_INITIAL_BOOST_SPEED, state[1]);
                applyRule(client, MaxElytraFlySpeedFabric.ELYTRA_HIGH_SPEED_ACCELERATION, state[2]);
            })
            .build()
            .generateScreen(parent);
    }

    private static void applyRule(Minecraft client, GameRule<Integer> rule, int value) {
        if (client.getSingleplayerServer() != null && rule != null) {
            ServerLevel overworld = client.getSingleplayerServer().overworld();
            if (overworld != null) {
                overworld.getGameRules().set(rule, value, client.getSingleplayerServer());
            }
        }
    }
}
