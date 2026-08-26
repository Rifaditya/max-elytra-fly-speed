package net.instantgratification.maxelytraflyspeed.config;

// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3

// Verified against: ClothConfigScreenHelper.java (26.2+)
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.network.chat.Component;

public class ClothConfigScreenHelper {
    public static ConfigScreenFactory<?> createFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("Max Elytra Fly Speed Configuration"));
            return builder.build();
        };
    }
}
