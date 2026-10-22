# 🎫 [BL-MEFS-006] Multi-Era Anchor Porting (Phase 2A): Transitional Port Max Elytra Fly Speed v1.21.11

- **Ticket ID**: `[BL-MEFS-006]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 1.21.11` (Java 21, Fabric Loom 1.15-SNAPSHOT remap)
- **Status**: `📌 DEFERRED`
- **Target Repository / Root**: `Instant Gratification Collection/Max Elytra Fly Speed`
- **Parent Ticket**: [`BL-MEFS-001`](BL-MEFS-001.md)

---

## 🎯 1. Problem Statement & Player Impact
Players running on transitional anchor MC 1.21.11 cannot use `Max Elytra Fly Speed`. Porting to 1.21.11 bridges modern sovereign anchors to legacy LTS releases, fulfilling the Multi-Era Anchor Parity Law.

In-game behavior before vs. after:
- **Before**: Mod is unavailable on MC 1.21.11.
- **After**: Players on MC 1.21.11 experience 100% feature parity with sovereign leads: uncapped max elytra velocity, dynamic GameRules, and high-speed rocket boost scaling.

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory: `Max Elytra Fly Speed v1.21.11/max-elytra-fly-speed/`
- Build Configuration:
  - `gradle.properties`: `minecraft_version=1.21.11`, `fabric_version=0.141.6+1.21.11`, `loader_version=0.19.3`, `java_version=21`, `dasik_library_version=1.4.0+1.21.11`, `mod_version=1.0.26+1.21.11`
  - `build.gradle`: Fabric Loom 1.15-SNAPSHOT (`fabric-loom-remap`), official Mojang mappings (`loom.officialMojangMappings()`), 4-point distribution copy tasks.
- Core Classes:
  - `MaxElytraFlySpeedFabric.java`: ModInitializer registering `max-elytra-fly-speed` category and GameRules via `DynamicGameRuleManager`.
  - `MaxElytraConfig.java`: ConfigOption declarative specification.
  - `ModMenuIntegration.java`: UniversalConfigScreen integration.
  - Mixins: `LivingEntityMixin.java` (`updateFallFlyingMovement` & `travelFallFlying`) and `FireworkRocketEntityMixin.java` (`tick`). Note: 1.21.11 has extracted `travelFallFlying` and `updateFallFlyingMovement` in Mojmap.
  - 5-Pillar Test Suite: `src/test/java/net/instantgratification/maxelytraflyspeed/test/`.

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Java Toolchain**: Java 21 (`E:/JDK25` running in Java 21 compliance mode).
- **Identifier API**: `ResourceLocation.fromNamespaceAndPath(MOD_ID, MOD_ID)` / `Identifier.of`.
- **GameRules**: `GameRules.Key<GameRules.IntegerValue>` return type from `DynamicGameRuleManager.integerRule().register()`.
- **DasikLibrary Contract**: `dasik-library` 1.4.0+1.21.11.

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- RemapJar Requirement: Transitional anchor requires `:remapJar` execution.
- Knot Runtime Safety: Zero client classes in common sources.

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold `Max Elytra Fly Speed v1.21.11/max-elytra-fly-speed/`.
2. Configure Loom 1.15-SNAPSHOT, Mojang mappings, and dependencies.
3. Adapt source code to 1.21.11 API signatures (`GameRules.Key`, `ResourceLocation`).
4. Implement 5-Pillar test suite.
5. Execute `./gradlew test build remapJar` cleanly.
6. Deploy JAR across 4-point distribution and record in `RELEASE_QUEUE.md`.

## 🏁 6. 5-Pillar Verification Checklist
- [ ] **Pillar 1 (Chaos Fuzzing)**: Chaos property fuzzing passes 10k-50k iterations.
- [ ] **Pillar 2 (Concurrency Load)**: Multi-threaded state stress test across 50 virtual threads.
- [ ] **Pillar 3 (Brigadier AST)**: Brigadier command tree AST validated headlessly.
- [ ] **Pillar 4 (GameTest)**: In-engine headless assertions pass cleanly.
- [ ] **Pillar 5 (Sidedness & Hygiene)**: 0 client imports; single-line GPLv3 headers verified.
- [ ] **Anchor Compilation**: Clean build producing `max-elytra-fly-speed-1.0.26+1.21.11.jar`.
