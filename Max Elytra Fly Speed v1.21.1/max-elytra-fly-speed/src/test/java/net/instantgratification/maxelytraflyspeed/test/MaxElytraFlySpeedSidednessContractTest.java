// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pillar 5: Bytecode Sidedness, Mixin Contract & GPLv3 License Header Verification Suite.
 * Automates the verification of:
 * - 0 client imports in common source code.
 * - 100% single-line GPLv3 license headers on Line 1.
 * - Absolute purge of obsolete version guard and 0 unremapped Class.forName() invocations.
 * - Integrity of max-elytra-fly-speed.mixins.json.
 */
@DisplayName("Pillar 5: Sidedness & Mixin Contract Verification")
class MaxElytraFlySpeedSidednessContractTest {

    private static final String REQUIRED_HEADER = "// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3";

    @Test
    @DisplayName("Pillar 5: Common Sources Contain Zero Client Imports")
    void testCommonSidednessIsolation() throws IOException {
        Path srcRoot = Paths.get("src/main/java");
        assertTrue(Files.exists(srcRoot), "src/main/java must exist");

        try (Stream<Path> stream = Files.walk(srcRoot)) {
            List<Path> javaFiles = stream.filter(p -> p.toString().endsWith(".java")).toList();
            assertFalse(javaFiles.isEmpty(), "Java source files must exist");

            for (Path file : javaFiles) {
                String normalized = file.toString().replace('\\', '/');
                String content = Files.readString(file, StandardCharsets.UTF_8);

                assertTrue(
                    content.startsWith(REQUIRED_HEADER),
                    "Missing single-line GPLv3 license header on line 1 in: " + normalized
                );

                // Skip client classes and client GUI integrations
                if (normalized.endsWith("Client.java") || normalized.contains("ModMenuIntegration")) {
                    continue;
                }

                assertFalse(
                    content.contains("import net.minecraft.client."),
                    "Forbidden client package reference in common source file: " + normalized
                );
                assertFalse(
                    content.contains("import com.mojang.blaze3d."),
                    "Forbidden Blaze3D reference in common source file: " + normalized
                );
            }
        }
    }

    @Test
    @DisplayName("Pillar 5: Test Sources Carry Standard GPLv3 License Header")
    void testTestSourcesLicenseHeader() throws IOException {
        Path testRoot = Paths.get("src/test/java");
        assertTrue(Files.exists(testRoot), "src/test/java must exist");

        try (Stream<Path> stream = Files.walk(testRoot)) {
            List<Path> javaFiles = stream.filter(p -> p.toString().endsWith(".java")).toList();
            assertFalse(javaFiles.isEmpty(), "Test Java files must exist");

            for (Path file : javaFiles) {
                String normalized = file.toString().replace('\\', '/');
                String content = Files.readString(file, StandardCharsets.UTF_8);
                assertTrue(
                    content.startsWith(REQUIRED_HEADER),
                    "Missing single-line GPLv3 license header on line 1 in test file: " + normalized
                );
            }
        }
    }

    @Test
    @DisplayName("Pillar 5: Obsolete Version Guard Permanently Purged and 0 Class.forName in Entrypoint")
    void testModVersionGuardPurged() throws IOException {
        String targetGuard = "Mod" + "VersionGuard";
        Path guardPath = Paths.get("src/main/java/net/instantgratification/maxelytraflyspeed/util/" + targetGuard + ".java");
        assertFalse(Files.exists(guardPath), "Obsolete version guard must not exist (purged for Knot safety)");

        Path entrypointPath = Paths.get("src/main/java/net/instantgratification/maxelytraflyspeed/MaxElytraFlySpeedFabric.java");
        assertTrue(Files.exists(entrypointPath), "MaxElytraFlySpeedFabric.java must exist");
        String content = Files.readString(entrypointPath, StandardCharsets.UTF_8);
        assertFalse(content.contains(targetGuard), "Entrypoint must not reference version guard");
        assertFalse(content.contains("Class.forName"), "Entrypoint must not invoke unremapped Class.forName()");
    }

    @Test
    @DisplayName("Pillar 5: Mixin Configuration Structural Integrity")
    void testMixinConfigIntegrity() throws IOException {
        Path mixinConfig = Paths.get("src/main/resources/max-elytra-fly-speed.mixins.json");
        assertTrue(Files.exists(mixinConfig), "max-elytra-fly-speed.mixins.json must exist");

        String content = Files.readString(mixinConfig, StandardCharsets.UTF_8);
        assertTrue(content.contains("LivingEntityMixin"), "LivingEntityMixin must be declared");
        assertTrue(content.contains("FireworkRocketEntityMixin"), "FireworkRocketEntityMixin must be declared");
    }
}
