package net.instantgratification.maxelytraflyspeed.config;

// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3

// Verified against: ModMenuIntegration.java (26.2+)
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            if (FabricLoader.getInstance().isModLoaded("cloth-config") ||
                FabricLoader.getInstance().isModLoaded("cloth_config")) {
                try {
                    Class<?> helperClass = Class.forName("net.instantgratification.maxelytraflyspeed.config.ClothConfigScreenHelper");
                    return (Screen) helperClass.getMethod("createScreen", Screen.class).invoke(null, parent);
                } catch (Throwable t) {
                    // Fall back gracefully if helper fails to load
                }
            }
            return null;
        };
    }
}
