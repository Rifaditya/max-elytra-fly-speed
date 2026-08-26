# Player Guide: Max Elytra Fly Speed

Welcome to the end-user documentation for **Max Elytra Fly Speed**!

## Overview
**Max Elytra Fly Speed** removes vanilla Minecraft's hard-coded velocity limitations on Elytra flight, allowing players and server owners to set custom speed caps via native in-game GameRules.

## GameRule Configuration

All configuration is performed directly inside Minecraft via `/gamerule` or the **Edit Game Rules** UI menu.

### Available Parameters
1. **`max-elytra-fly-speed:max_elytra_fly_speed`**
   - **Type**: Integer
   - **Default**: `50`
   - **Description**: Sets the maximum speed limit for Elytra gliding in Blocks per Second.
2. **`max-elytra-fly-speed:elytra_initial_boost_speed`**
   - **Type**: Integer
   - **Default**: `30`
   - **Description**: Speed threshold (Blocks/Second) up to which standard rocket boost is applied.
3. **`max-elytra-fly-speed:elytra_high_speed_acceleration`**
   - **Type**: Integer (1–1000)
   - **Default**: `15`
   - **Description**: Rate of gradual acceleration (in permille) above the initial boost speed threshold.

## Optional Client GUI
If **ModMenu** and **Cloth Config** are installed on the client, you can access the configuration screen directly from the in-game ModMenu interface in singleplayer worlds.
