# Concept: Max Elytra Fly Speed

## 1. Objective
Provide a lightweight, high-performance solution for modifying the maximum flight speed of Elytras using native Minecraft mechanics. This mod allows server administrators to set a hard limit or scale Elytra velocity without introducing external configuration libraries.

## 2. Core Features
- **Max Speed Cap**: A native `GameRule` (`maxElytraFlySpeed`) to enforce a hard limit on velocity (Blocks/Second).

## 3. Technical Constraints (Standard Core Compliance)
- **Target**: Minecraft 26.2.
- **Language**: Java 25.
- **Config**: Implementation MUST use `GameRules`. No external config libs.
- **Performance**: 
    - Logic must be `O(1)` in the `LivingEntity` tick.
    - No object instantiation in the flight loop.
- **Mixins**:
    - Target `LivingEntity.travelFallFlying`.
    - All mixin members must be prefixed with `maxelytraflyspeed$`.

## 4. Feature Coverage (from concept_max_elytra_fly_speed.md)
| # | Feature | Description | Implemented? | Code Location |
|---|---------|-------------|--------------|---------------|
| 1 | `maxElytraFlySpeed` | GameRule (Integer) | [x] | `MaxElytraFlySpeedFabric.java` |
| 2 | TPS Guardrail | O(1) velocity clamping | [x] | `LivingEntityMixin.java` |

## 5. Metadata
- **Mod ID**: `max-elytra-fly-speed`
- **Dependencies**: `fabric-loader`, `minecraft (>=26.2-)`, `dasik-library (>=1.8.2)`
- **Namespace**: `net.instantgratification.maxelytraflyspeed`
