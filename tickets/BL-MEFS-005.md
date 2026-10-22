# 🎫 [BL-MEFS-005] Multi-Era Anchor Porting (Phase 1): Modern Sovereign Port Max Elytra Fly Speed v26.1.2

- **Ticket ID**: `[BL-MEFS-005]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 26.1.2` (Java 25, Fabric Loom 1.15.5)
- **Status**: `📌 DEFERRED`
- **Target Repository / Root**: `Instant Gratification Collection/Max Elytra Fly Speed`
- **Parent Ticket**: [`BL-MEFS-001`](BL-MEFS-001.md)

---

## 🎯 1. Problem Statement & Player Impact
Currently, `Max Elytra Fly Speed` is only available on MC 26.2 and 26.3. Players on Minecraft 26.1.2 lack access to customizable max elytra velocity and flight acceleration. Porting to 26.1.2 ensures modern sovereign anchor parity under the 1 Jar 1 Version Policy.

In-game behavior before vs. after:
- **Before**: Mod is unavailable on MC 26.1.2.
- **After**: Players on MC 26.1.2 experience full dynamic GameRule-driven speed clamping, smooth high-speed glide, and proportional rocket boost acceleration with 100% parity to 26.2/26.3.

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory: `Max Elytra Fly Speed v26.1.2/max-elytra-fly-speed/`
- Build Configuration:
  - `gradle.properties`: `minecraft_version=26.1.2`, `fabric_version=0.145.4+26.1.2`, `loader_version=0.19.5`, `java_version=25`, `dasik_library_version=1.11.2`, `mod_version=1.0.26+26.1.2`
  - `build.gradle`: Fabric Loom 1.15.5, official Mojang mappings, 4-point distribution copy tasks.
- Core Classes:
  - `MaxElytraFlySpeedFabric.java`: ModInitializer registering `max-elytra-fly-speed` GameRule category and integer rules via `DynamicGameRuleManager`.
  - `MaxElytraConfig.java`: Declarative configuration options using `@ConfigOption`.
  - `ModMenuIntegration.java`: `UniversalConfigScreen.createFactory(MaxElytraConfig.class)`.
  - `ElytraDragHelper.java` & `RocketBoostHelper.java`: Pure $O(1)$ physics calculators.
  - Mixins: `LivingEntityMixin.java` (`updateFallFlyingMovement` & `travelFallFlying`) and `FireworkRocketEntityMixin.java` (`tick`).
  - 5-Pillar Test Suite: `src/test/java/net/instantgratification/maxelytraflyspeed/test/`.

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Java Toolchain**: Java 25 (`E:/JDK25`).
- **Identifier API**: `Identifier.fromNamespaceAndPath(MOD_ID, MOD_ID)`.
- **DasikLibrary Contract**: `dasik-library` 1.11.2.
- **Mixins**: Identical to 26.2 sovereign lead (`updateFallFlyingMovement` Vec3 drag redirect, `travelFallFlying` move inject, `FireworkRocketEntity.tick` setDeltaMovement redirect).

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Knot ClassLoader Runtime Safety: Zero deobfuscated reflection; zero `ModVersionGuard`.
- Side Safety: Zero `net.minecraft.client.*` imports in common code; verified via Pillar 5 test.
- Headless Compilation: Clean `./gradlew test build --no-daemon --console=plain`.

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold `Max Elytra Fly Speed v26.1.2/max-elytra-fly-speed/` directory tree.
2. Configure `build.gradle`, `gradle.properties`, `settings.gradle`, and `fabric.mod.json`.
3. Port source classes, mixins, and assets (`icon.png`, 11 localization files).
4. Implement 5-Pillar test suite (`SidednessContractTest`, `StressFuzzTest`, `ConcurrencyLoadTest`, `CommandTest`, `GameTest`).
5. Execute `./gradlew test build` and verify clean headless assertions.
6. Deploy JAR across 4-point distribution and register in `RELEASE_QUEUE.md` and `CHANGELOG.md`.

## 🏁 6. 5-Pillar Verification Checklist
- [ ] **Pillar 1 (Chaos Fuzzing)**: Chaos property fuzzing passes 10k-50k iterations.
- [ ] **Pillar 2 (Concurrency Load)**: Multi-threaded state stress test across 50 virtual threads.
- [ ] **Pillar 3 (Brigadier AST)**: Brigadier command tree AST and permissions validated headlessly.
- [ ] **Pillar 4 (GameTest)**: In-engine headless assertions pass cleanly.
- [ ] **Pillar 5 (Sidedness & Hygiene)**: Sidedness contract asserts 0 client imports in common code; single-line GPLv3 headers.
- [ ] **Anchor Compilation**: Clean `./gradlew test build` producing `max-elytra-fly-speed-1.0.26+26.1.2.jar`.
