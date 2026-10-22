# Architecture & Symbol Index: Max Elytra Fly Speed (MC 26.1.2)

## 1. Mod Metadata & Entrypoint
- **Mod ID**: `max-elytra-fly-speed`
- **Main Entrypoint**: `net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric` (`net.fabricmc.api.ModInitializer`)
- **Client Entrypoint**: `net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabricClient` (`net.fabricmc.api.ClientModInitializer`)
- **ModMenu Entrypoint**: `net.instantgratification.maxelytraflyspeed.config.ModMenuIntegration`

## 2. Bytecode Mixin Target Registry
| Target Vanilla Class | Mixin Class | Purpose |
| :--- | :--- | :--- |
| `net.minecraft.world.entity.LivingEntity` | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` | Aerodynamic drag redirect (`updateFallFlyingMovement`) & velocity clamping (`travelFallFlying`) |
| `net.minecraft.world.entity.projectile.FireworkRocketEntity` | `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` | Dual-phase rocket boost acceleration scaling (`tick`) |

## 3. Core Mechanics & Subsystems
- **Dynamic Aerodynamic Drag**: `net.instantgratification.maxelytraflyspeed.util.ElytraDragHelper`
- **Proportional Rocket Boost**: `net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper`
- **Config & GUI**: `net.instantgratification.maxelytraflyspeed.config.MaxElytraConfig`
- **Source Root**: `src/main/java/`
- **Resource Root**: `src/main/resources/`
- **Test Root**: `src/test/java/` (5-Pillar automated suite)

## 4. Dynamic GameRules & Commands
- `max-elytra-fly-speed:max_elytra_fly_speed`: Flight speed cap in Blocks/Second (default: 50)
- `max-elytra-fly-speed:elytra_initial_boost_speed`: Threshold for snappy boost in Blocks/Second (default: 30)
- `max-elytra-fly-speed:elytra_high_speed_acceleration`: High speed acceleration percentage (default: 15)

## 5. Configuration & Sidedness Isolation
- **Sidedness**: Server-safe logic in main, client isolated in `config.ModMenuIntegration` and client entrypoint. Zero client imports in common code.
