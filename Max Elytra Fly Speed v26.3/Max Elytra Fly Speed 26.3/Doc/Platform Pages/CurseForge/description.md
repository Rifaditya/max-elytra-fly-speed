<p align="center">
    <a href="https://www.curseforge.com/minecraft/mc-mods/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft">
</p>

# 🚀 Max Elytra Fly Speed

**1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.

<blockquote><strong>Break the Sound Barrier. Limitless Velocity. Instant Flight.</strong></blockquote>

Every Minecraft player knows the limitation of vanilla Elytra flight: no matter how hard you dive or how many firework rockets you use, you are capped. **Max Elytra Fly Speed** removes these restrictions, allowing customizable speed and a gradual acceleration curve powered by native GameRules.

Part of the **Instant Gratification Collection** — mods that speed up and enhance vanilla mechanics.

---

## 🎥 Showcase Video

<p align="center">
    <a href="https://youtu.be/Oz8NTfX0YmE"><img src="https://img.youtube.com/vi/Oz8NTfX0YmE/maxresdefault.jpg" alt="Mod Showcase Video" width="560"></a>
</p>

*Click the image above to watch the mod showcase in action!*

---

## ✨ Features

*   **Custom Max Velocity Cap**: Clamp maximum speed to any value (default: `50` blocks/sec). Set it to high limits like 100, 200, or 3000 blocks/sec for extreme speed!
*   **Proportional Rocket Boost Acceleration**: Rockets smoothly accelerate your flight trajectory toward your target maximum speed across 2–3 boosts using proportional vector convergence.
*   **Dual-Phase Speed Scaling**:
    *   **Phase 1 (Initial Boost)**: Snappy vanilla launch mechanics up to the configurable threshold (default: `30` blocks/sec).
    *   **Phase 2 (High Speed Glide)**: Proportional acceleration convergence pulling velocity smoothly toward your max flight speed ceiling.
*   **Dynamic Aerodynamic Drag Dives**: Aerodynamic drag relaxes dynamically at higher speed settings, allowing pitch dives to build up and sustain high-speed momentum.
*   **Client Settings Integration**: Singleplayer configuration GUI support via **ModMenu** + **Cloth Config**.

---

## ⚙️ Configuration (Native Game Rules)

<blockquote>
    <strong>⚠️ Config vs. In-Game GameRules:</strong><br>
    The global configuration file only defines <strong>default values for new worlds</strong> at creation time. If you have <strong>already created/opened a world</strong>, changing the config file will have no effect. You must change the settings in-game using the <strong>Edit Game Rules</strong> UI screen or the /gamerule command.
</blockquote>

No messy config files. Max Elytra Fly Speed uses the **Native Minecraft Game Rules** system. All mod parameters are grouped into a dedicated **"Max Elytra Fly Speed"** category in the official UI.

### Sovereign GameRules
*   `max-elytra-fly-speed:max_elytra_fly_speed` (Default: `50`): The absolute maximum velocity (Blocks/Second) of Elytra flight.
*   `max-elytra-fly-speed:elytra_initial_boost_speed` (Default: `30`): Speed threshold (Blocks/Second) up to which snappy vanilla rocket boost is applied.
*   `max-elytra-fly-speed:elytra_high_speed_acceleration` (Default: `15`): High-speed acceleration rate percentage (15% per tick) above the initial boost speed threshold.

---

## ☕ Support

If you enjoy the **Instant Gratification** collection, consider fueling the next update!

<p align="center">
  <a href="https://ko-fi.com/dasikigaijin/tip"><img src="https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Ko-fi"></a>
  <a href="https://sociabuzz.com/dasikigaijin/tribe"><img src="https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge" alt="SocioBuzz"></a>
  <a href="https://saweria.co/DasikIgaijinn"><img src="https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge" alt="Saweria"></a>
</p>

<blockquote><strong>🇮🇩 Indonesian Users:</strong> SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!</blockquote>

---

## 📜 Credits

| Role | Author |
| :--- | :--- |
| **Creator** | **Dasik** (Rifaditya) |
| **Collection** | Instant Gratification |
| **License** | GPLv3 |

<blockquote>
    <strong>📦 Modpack Permissions & Distribution:</strong><br>
    You are free to include this mod in any modpack on any platform. However, the mod itself must be downloaded from its official distribution pages on <strong>Modrinth</strong> or <strong>CurseForge</strong>. Re-uploading or redistributing the mod jar file to third-party sites is strictly prohibited unless explicitly permitted by the creator.
    <br><br>
    <strong>License & Forks:</strong><br>
    Since the source code is licensed under <strong>GNU GPLv3</strong>, you are fully permitted to fork the repository, make modifications, build your own versions, and distribute them under the terms of the GPLv3. The prohibition on third-party redistribution applies exclusively to the official compiled releases/jars published by the original creator (Dasik/Rifaditya). Forks must be published as distinct projects, not direct re-uploads of official builds.
</blockquote>


---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
