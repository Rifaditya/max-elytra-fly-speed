package net.instantgratification.maxelytraflyspeed.config;

// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3

// Verified against: ClothConfigScreenHelper.java (26.2+)
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;

import java.net.URI;

public class ClothConfigScreenHelper {
    public static ConfigScreenFactory<?> createFactory() {
        return ClothConfigScreenHelper::createScreen;
    }

    public static Screen createScreen(Screen parent) {
        Minecraft client = Minecraft.getInstance();

        ConfigBuilder builder = ConfigBuilder.create()
            .setParentScreen(parent)
            .setTitle(Component.translatable("gamerule.category.max-elytra-fly-speed.max-elytra-fly-speed"));

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory general = builder.getOrCreateCategory(
            Component.translatable("gamerule.category.max-elytra-fly-speed.max-elytra-fly-speed")
        );

        // Top-pinned Creator Support Banner (Constitution Standard)
        general.addEntry(entryBuilder.startTextDescription(
            Component.translatableWithFallback("dasiklibrary.support.kofi.button", "☕ Support Solo Dev on Ko-fi")
                .withStyle(style -> style
                    .withColor(ChatFormatting.GOLD)
                    .withUnderlined(true)
                    .withClickEvent(new ClickEvent.OpenUrl(URI.create("https://ko-fi.com/dasikigaijin")))
                )
        ).setTooltip(Component.translatableWithFallback(
            "dasiklibrary.support.kofi.tooltip",
            "Enjoying the mod? Leaving a tip or grabbing early access builds directly keeps updates rolling!"
        )).build());

        int currentMaxSpeed = 50;
        int currentInitialBoost = 30;
        int currentHighSpeedAcc = 15;

        if (client.level != null) {
            currentMaxSpeed = DynamicGameRuleManager.getInt(client.level, MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED);
            currentInitialBoost = DynamicGameRuleManager.getInt(client.level, MaxElytraFlySpeedFabric.ELYTRA_INITIAL_BOOST_SPEED);
            currentHighSpeedAcc = DynamicGameRuleManager.getInt(client.level, MaxElytraFlySpeedFabric.ELYTRA_HIGH_SPEED_ACCELERATION);
        }

        // Max Speed (Blocks/Sec)
        general.addEntry(entryBuilder.startIntField(
            Component.translatable("gamerule.max-elytra-fly-speed.max_elytra_fly_speed"),
            currentMaxSpeed
        )
        .setDefaultValue(50)
        .setMin(1)
        .setTooltip(Component.translatable("gamerule.max-elytra-fly-speed.max_elytra_fly_speed.description"))
        .setSaveConsumer(val -> {
            if (client.getSingleplayerServer() != null && MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED != null) {
                ServerLevel overworld = client.getSingleplayerServer().overworld();
                if (overworld != null) {
                    overworld.getGameRules().set(MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED, val, client.getSingleplayerServer());
                }
            }
        })
        .build());

        // Initial Boost Speed
        general.addEntry(entryBuilder.startIntField(
            Component.translatable("gamerule.max-elytra-fly-speed.elytra_initial_boost_speed"),
            currentInitialBoost
        )
        .setDefaultValue(30)
        .setMin(1)
        .setTooltip(Component.translatable("gamerule.max-elytra-fly-speed.elytra_initial_boost_speed.description"))
        .setSaveConsumer(val -> {
            if (client.getSingleplayerServer() != null && MaxElytraFlySpeedFabric.ELYTRA_INITIAL_BOOST_SPEED != null) {
                ServerLevel overworld = client.getSingleplayerServer().overworld();
                if (overworld != null) {
                    overworld.getGameRules().set(MaxElytraFlySpeedFabric.ELYTRA_INITIAL_BOOST_SPEED, val, client.getSingleplayerServer());
                }
            }
        })
        .build());

        // High Speed Acceleration
        general.addEntry(entryBuilder.startIntField(
            Component.translatable("gamerule.max-elytra-fly-speed.elytra_high_speed_acceleration"),
            currentHighSpeedAcc
        )
        .setDefaultValue(15)
        .setMin(1)
        .setMax(1000)
        .setTooltip(Component.translatable("gamerule.max-elytra-fly-speed.elytra_high_speed_acceleration.description"))
        .setSaveConsumer(val -> {
            if (client.getSingleplayerServer() != null && MaxElytraFlySpeedFabric.ELYTRA_HIGH_SPEED_ACCELERATION != null) {
                ServerLevel overworld = client.getSingleplayerServer().overworld();
                if (overworld != null) {
                    overworld.getGameRules().set(MaxElytraFlySpeedFabric.ELYTRA_HIGH_SPEED_ACCELERATION, val, client.getSingleplayerServer());
                }
            }
        })
        .build());

        return builder.build();
    }
}
