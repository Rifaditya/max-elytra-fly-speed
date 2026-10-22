# 🎫 [BL-MEFS-001] Multi-Era Anchor Porting: Max Elytra Fly Speed (Umbrella)

- **Ticket ID**: `[BL-MEFS-001]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `All Anchors` (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`)
- **Status**: `📌 DEFERRED`
- **Target Repository / Root**: `Instant Gratification Collection/Max Elytra Fly Speed`

---

## 🎯 1. Problem Statement & Player Impact
Currently, **Max Elytra Fly Speed** only exists on modern baseline anchors (MC 26.2 and MC 26.3). Players playing on legacy long-term support versions (MC 1.20.1, MC 1.21.1, and MC 1.21.11) or modern transitional releases (MC 26.1.2) cannot use this mod. In accordance with the studio's "1 Jar 1 Version Policy" and Multi-Era Anchor Parity Law, this mod must be ported across all missing anchors to ensure zero orphaned ports.

In-game behavior before vs. after:
- **Before**: Mod is unavailable on MC 1.20.1, MC 1.21.1, MC 1.21.11, and MC 26.1.2.
- **After**: Players on all 6 version anchors experience 100% identical uncapped elytra flight speed velocity clamping and kinematic acceleration, dynamic GameRule synchronization, and configuration controls.

## 🔬 2. Architectural Blueprint & Target Classes
- **Subproject Directory Structure**:
  - `Max Elytra Fly Speed v26.1.2/` (targeting Minecraft 26.1.2, Java 25, Fabric Loom 1.15.5) -> Companion [`[BL-MEFS-005]`](BL-MEFS-005.md)
  - `Max Elytra Fly Speed v1.21.11/` (targeting Minecraft 1.21.11, Java 21, Fabric Loom 1.15-SNAPSHOT remap) -> Companion [`[BL-MEFS-006]`](BL-MEFS-006.md)
  - `Max Elytra Fly Speed v1.21.1/` (targeting Minecraft 1.21.1, Java 21, Fabric Loom 1.10.2 Mojmap) -> Companion [`[BL-MEFS-007]`](BL-MEFS-007.md)
  - `Max Elytra Fly Speed v1.20.1/` (targeting Minecraft 1.20.1, Java 17, Fabric Loom 1.10.2 Mojmap) -> Companion [`[BL-MEFS-008]`](BL-MEFS-008.md)
- **Core Classes to Port & Adapt**:
  - `MaxElytraFlySpeedFabric.java` (ModInitializer, GameRule registration, server lifecycle events)
  - `MaxElytraConfig.java` (UniversalConfigScreen @ConfigOption declarative annotations)
  - `ElytraDragHelper.java` (Dynamic aerodynamic drag calculation)
  - `RocketBoostHelper.java` (Proportional convergence vector math)
  - `ModMenuIntegration.java` (UniversalConfigScreen GUI factory)
  - Mixins: `LivingEntityMixin.java` and `FireworkRocketEntityMixin.java`
- **Build Toolchain Scaffolding per Anchor**:
  - `build.gradle` (Loom configuration, dependencies, archive distribution tasks)
  - `gradle.properties` (exact version tags, `archives_base_name`, `mod_version = 1.0.26+<anchor>`)
  - `settings.gradle` and `fabric.mod.json`

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Modern Sovereign Anchors (Java 25, Loom 1.15+, No Mappings Block)**:
  - `MC 26.1.2`: Java 25, Loom 1.15.5, `Identifier.fromNamespaceAndPath`, `dasik-library` 1.11.2, v26.2 mixin variant.
  - `MC 26.2`: Active sovereign baseline (Lead version: 1.0.26+26.2).
  - `MC 26.3`: Active sovereign snapshot (Lead version: 1.0.26+26.3).
- **Older Anchors (Mojang Mappings, Java 21 / 17)**:
  - `MC 1.21.11`: Java 21, Loom 1.15-SNAPSHOT (`fabric-loom-remap`), Mojang mappings, `ResourceLocation`, `dasik-library` 1.4.0+1.21.11.
  - `MC 1.21.1`: Java 21, Loom 1.10.2, Mojang mappings, `ResourceLocation`, `LivingEntity.travel` mixin hook, `dasik-library` 1.4.0+1.21.1.
  - `MC 1.20.1`: Java 17, Loom 1.10.2, Mojang mappings, `ResourceLocation`, `LivingEntity.travel` mixin hook, `GameRules.Key<IntegerValue>`, `dasik-library` 1.4.0+1.20.1.

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- **Knot ClassLoader Runtime Safety**: Never call deobfuscated reflection; purge all traces of `ModVersionGuard`.
- **Vanilla API Shift Radar**: `LivingEntity` in 1.20.1 and 1.21.1 inlines fall-flying inside `travel(Vec3)`, while 1.21.11 and 26.x isolate it in `travelFallFlying(Vec3)` and `updateFallFlyingMovement(Vec3)`.
- **Dedicated Server Crash Prevention**: 0 client classes (`net.minecraft.client.*`) in common code. Verified via `MaxElytraFlySpeedSidednessContractTest`.
- **Zero-Allocation Hot Path**: Drag and rocket boost calculations execute at 0B heap allocation beyond returned primitives/vectors.

## 🚀 5. Implementation Roadmap
- **Step 0**: Quarantine Gate — Baseline Hygiene, ModVersionGuard Purge, License Header Compliance & 5-Pillar Testing Harness Adoption (`[BL-MEFS-003]`) on Sovereign Leads (`v26.2` & `v26.3`).
- **Step 1**: Modern Sovereign Anchor Port: MC 26.1.2 ([`BL-MEFS-005`](BL-MEFS-005.md)).
- **Step 2**: Transitional Anchor Port: MC 1.21.11 ([`BL-MEFS-006`](BL-MEFS-006.md)).
- **Step 3**: Modern Era Anchor Port: MC 1.21.1 ([`BL-MEFS-007`](BL-MEFS-007.md)).
- **Step 4**: Long-Term Support Anchor Port: MC 1.20.1 ([`BL-MEFS-008`](BL-MEFS-008.md)).
- **Step 5**: Studio Governance, Ecosystem Sync, Bot Delivery & Master Backlog Closure.

## 🏁 6. 5-Pillar Verification Checklist
- [ ] **Pillar 1 (Chaos Fuzzing)**: Chaos property fuzzing passes 10k-50k iterations.
- [ ] **Pillar 2 (Concurrency Load)**: Multi-threaded state stress test across 50 virtual threads.
- [ ] **Pillar 3 (Brigadier AST)**: Brigadier command tree AST and permissions validated headlessly.
- [ ] **Pillar 4 (GameTest)**: In-engine headless assertions pass cleanly.
- [ ] **Pillar 5 (Sidedness & Hygiene)**: Sidedness contract asserts 0 client imports in common code; single-line GPLv3 headers.
- [ ] **Anchor Compilation**: Clean `./gradlew test build` across all 6 anchors (`1.20.1`, `1.21.1`, `1.21.11`, `26.1.2`, `26.2`, `26.3`).
