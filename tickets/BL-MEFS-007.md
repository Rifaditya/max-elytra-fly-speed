# 🎫 [BL-MEFS-007] Multi-Era Anchor Porting (Phase 2B): Modern Era Port Max Elytra Fly Speed v1.21.1

- **Ticket ID**: `[BL-MEFS-007]`
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Scope**: `MC 1.21.1` (Java 21, Fabric Loom 1.10.2 Mojmap)
- **Status**: `📌 DEFERRED`
- **Target Repository / Root**: `Instant Gratification Collection/Max Elytra Fly Speed`
- **Parent Ticket**: [`BL-MEFS-001`](BL-MEFS-001.md)

---

## 🎯 1. Problem Statement & Player Impact
Players on Minecraft 1.21.1 cannot use `Max Elytra Fly Speed`. Porting to 1.21.1 ensures the modern long-term support release enjoys identical flight velocity capabilities.

In-game behavior before vs. after:
- **Before**: Mod is unavailable on MC 1.21.1.
- **After**: Full elytra flight speed customization, dynamic GameRules, and high-speed rocket propulsion on MC 1.21.1.

## 🔬 2. Architectural Blueprint & Target Classes
- Subproject Directory: `Max Elytra Fly Speed v1.21.1/max-elytra-fly-speed/`
- Build Configuration:
  - `gradle.properties`: `minecraft_version=1.21.1`, `fabric_version=0.102.0+1.21.1`, `loader_version=0.16.0`, `java_version=21`, `dasik_library_version=1.4.0+1.21.1`, `mod_version=1.0.26+1.21.1`
  - `build.gradle`: Fabric Loom 1.10.2, official Mojang mappings (`loom.officialMojangMappings()`), 4-point distribution copy tasks.
- Core Classes & Mixins:
  - `MaxElytraFlySpeedFabric.java`: Initializer using `DynamicGameRuleManager` with `GameRules.Key<GameRules.IntegerValue>`.
  - Mixins: `LivingEntityMixin.java` targeting `travel(Vec3)` (as `updateFallFlyingMovement` does not exist in 1.21.1; fall flying is inlined inside `travel`).
    - Drag redirect at `Vec3.multiply(DDD)` with `this.isFallFlying()` guard.
    - Clamp inject at `LivingEntity.move(MoverType, Vec3)` with `this.isFallFlying()` guard.
  - `FireworkRocketEntityMixin.java`: Targeting `tick` at `LivingEntity.setDeltaMovement(Vec3)`.
  - 5-Pillar Test Suite: `src/test/java/net/instantgratification/maxelytraflyspeed/test/`.

## ⚓ 3. Multi-Era Anchor Parity Specifications
- **Java Toolchain**: Java 21 (`E:/JDK25` in Java 21 mode).
- **Mappings**: Official Mojang mappings (`loom.officialMojangMappings()`).
- **Identifiers**: `ResourceLocation`.
- **GameRules**: `GameRules.Key<GameRules.IntegerValue>`.

## 🛡️ 4. Edge Cases, Collisions & Failure Modes
- Inlined Fall Flying in `LivingEntity.travel`: Must gate `@Redirect` and `@Inject` behind `this.isFallFlying()` to prevent mutating normal swimming, walking, or falling physics.
- Knot Runtime Safety: 0 client classes in common sources.

## 🚀 5. Implementation Steps (Code-Level Plan)
1. Scaffold `Max Elytra Fly Speed v1.21.1/max-elytra-fly-speed/`.
2. Configure Loom 1.10.2, Mojmap, and 1.21.1 dependencies.
3. Author anchor-adapted `LivingEntityMixin.java` hooking into `travel(Vec3)`.
4. Implement 5-Pillar test suite.
5. Execute `./gradlew test build remapJar`.
6. Deploy JAR across 4-point distribution and record in `RELEASE_QUEUE.md`.

## 🏁 6. 5-Pillar Verification Checklist
- [ ] **Pillar 1 (Chaos Fuzzing)**: Chaos property fuzzing passes 10k-50k iterations.
- [ ] **Pillar 2 (Concurrency Load)**: Multi-threaded state stress test across 50 virtual threads.
- [ ] **Pillar 3 (Brigadier AST)**: Brigadier command tree AST validated headlessly.
- [ ] **Pillar 4 (GameTest)**: In-engine headless assertions pass cleanly.
- [ ] **Pillar 5 (Sidedness & Hygiene)**: 0 client imports; single-line GPLv3 headers verified.
- [ ] **Anchor Compilation**: Clean build producing `max-elytra-fly-speed-1.0.26+1.21.1.jar`.
