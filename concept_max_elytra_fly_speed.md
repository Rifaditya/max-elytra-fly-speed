# Concept: Max Elytra Fly Speed

## 1. Objective
Provide a lightweight, high-performance solution for modifying the maximum flight speed of Elytras using native Minecraft mechanics. This mod allows server administrators to set a hard limit or scale Elytra velocity without introducing external configuration libraries.

## 2. Core Features
- **Max Speed Cap**: A native `GameRule` (`maxElytraFlySpeed`) to enforce a hard limit on velocity (Blocks/Tick).
- **Global Speed Multiplier**: A native `GameRule` (`elytraSpeedMultiplier`) to scale the base flight speed (Permille).

## 3. Technical Constraints (Standard Core Compliance)
- **Target**: Minecraft 26.1 Snapshot 8.
- **Language**: Java 25.
- **Config**: Implementation MUST use `GameRules`. No external config libs.
- **Performance**: 
    - Logic must be `O(1)` in the `LivingEntity` tick.
    - No object instantiation in the flight loop.
- **Mixins**:
    - Target `LivingEntity.travel` or `LocalPlayer.travel`.
    - All mixin members must be prefixed with `maxelytraflyspeed$`.

## 4. Feature Coverage (from concept_max_elytra_fly_speed.md)
| # | Feature | Description | Implemented? | Code Location |
|---|---------|-------------|--------------|---------------|
| 1 | `maxElytraFlySpeed` | GameRule (Integer) | [ ] | - |
| 2 | `elytraSpeedMultiplier` | GameRule (Integer) | [ ] | - |
| 3 | TPS Guardrail | O(1) velocity clamping | [ ] | - |

## 5. Metadata
- **Mod ID**: `max-elytra-fly-speed`
- **Dependencies**: `fabric-loader`, `minecraft (~26.1-)`, `dasik-library (*)`
- **Namespace**: `com.core.maxelytraflyspeed`
