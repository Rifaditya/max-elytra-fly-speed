<p align="center">
  <img src="https://raw.githubusercontent.com/Rifaditya/max-elytra-fly-speed/main/Doc/Media/icon.png" width="128" height="128" alt="Mod Icon">
</p>

# Max Elytra Fly Speed

🚀 **Take back control of your flight!**

A lightweight, server-side compatible Fabric mod that lets you configure the maximum Elytra flight speed and acceleration curve using native GameRules. No more hardcaps on your momentum.

---

## ⚡ Features

*   **Custom Max Velocity Cap**: Clamp maximum speed to any value (default is vanilla 30 blocks/sec). Set it to high limits like 3000 blocks/sec for extreme speed!
*   **Gradual Acceleration Curve**: Integrates smooth, powered-rail-like acceleration when boosting. Prevents jarring, instant thrust acceleration.
*   **Dual-Phase Speed Scaling**:
    *   **Phase 1 (Initial Boost)**: Utilizes vanilla snappy launch mechanics up to a configurable speed threshold.
    *   **Phase 2 (High Speed Glide)**: Shifts to smooth, drag-compensated acceleration above the threshold.
*   **Gravity Dives**: Dynamically scales drag down at higher limits, allowing you to build up speed gradually by diving down and pulling up.

---

## ⚙️ GameRules & Configuration

> [!WARNING]  
> Changing global configs only defines default values for **new worlds**. To edit existing worlds, use the `/gamerule` command or the in-game world configuration screen.

### Sovereign GameRules
*   `max-elytra-fly-speed:max_elytra_fly_speed` (Default: `30`): The absolute maximum velocity (Blocks/Second) of Elytra flight.
*   `max-elytra-fly-speed:elytra_initial_boost_speed` (Default: `30`): Speed threshold (Blocks/Second) up to which snappy vanilla rocket boost is applied.
*   `max-elytra-fly-speed:elytra_high_speed_acceleration` (Default: `15`): Gradual acceleration rate (permille) above the initial boost speed threshold.

---

## 📦 Modpack Integration & License

> [!IMPORTANT]  
> Redistribution of this mod jar file on external platforms outside of Modrinth and CurseForge is strictly prohibited. You are free to include this mod in any modpack hosted on CurseForge or Modrinth.

*   Licensed under the terms of the GNU GPLv3.

---

## 👥 Credits

| Role | Author |
| :--- | :--- |
| Lead Developer | **Dasik (Rifaditya)** |

---

<p align="center">Made with ❤️</p>
