# Architecture & Symbol Index: Max Elytra Fly Speed

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `max-elytra-fly-speed`
- **Main Entrypoint**: `net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric` (`net.fabricmc.api.ModInitializer`)
- **Client Entrypoint**: `net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabricClient`

## 2. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Purpose |
| :--- | :--- | :--- |
| `Vanilla Class` | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` | Core mixin hook |
| `Vanilla Class` | `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` | Core mixin hook |

## 3. Core Mechanics & Subsystems
- **Source Root**: `src/main/java/`
- **Resource Root**: `src/main/resources/`

## 4. Dynamic GameRules & Commands
- **GameRules / Commands**: Configured dynamically via namespaced keys (`max-elytra-fly-speed:*`).

## 5. Configuration & Sidedness Isolation
- **Sidedness**: Server-safe logic in main, client isolated in `src/client/java` or client entrypoint.
