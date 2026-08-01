<p align="center">
    <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft">
</p>

# 🚀 Max Elytra Fly Speed

**Active Version Policy:** I build **1 JAR for 1 Version**. I only update and maintain the latest active Minecraft version (e.g. when 26.3 is released, 26.2 is retired). No backports or legacy version maintenance. Please do not ask.

> **Break the Sound Barrier. Limitless Velocity. Instant Flight.**

Every Minecraft player knows the limitation of vanilla Elytra flight: no matter how hard you dive or how many firework rockets you use, you are capped. **Max Elytra Fly Speed** removes these restrictions, allowing customizable speed and a gradual acceleration curve powered by native GameRules.

Part of the **Instant Gratification Collection** — mods that speed up and enhance vanilla mechanics.

---

## 🎥 Showcase Video

<iframe width="560" height="315" src="https://www.youtube-nocookie.com/embed/Oz8NTfX0YmE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>

*Click the player above to watch the mod showcase in action!*

---

## ✨ Features

*   **Custom Max Velocity Cap**: Clamp maximum speed to any value (default is vanilla 30 blocks/sec). Set it to high limits like 3000 blocks/sec for extreme speed!
*   **Gradual Acceleration Curve**: Integrates smooth, powered-rail-like acceleration when boosting. Prevents jarring, instant thrust acceleration.
*   **Dual-Phase Speed Scaling**:
    *   **Phase 1 (Initial Boost)**: Utilizes vanilla snappy launch mechanics up to a configurable speed threshold.
    *   **Phase 2 (High Speed Glide)**: Shifts to smooth, drag-compensated acceleration above the threshold.
*   **Gravity Dives**: Dynamically scales drag down at higher limits, allowing you to build up speed gradually by diving down and pulling up.
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
*   `max-elytra-fly-speed:elytra_high_speed_acceleration` (Default: `15`): Gradual acceleration rate (permille) above the initial boost speed threshold.

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

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:** You are free to include this mod in any modpack on any platform. However, the mod itself must be downloaded from its official distribution pages on **Modrinth** or **CurseForge**. Re-uploading or redistributing the mod jar file to third-party sites is strictly prohibited unless explicitly permitted by the creator.
> 
> **License & Forks:** Since the source code is licensed under **GNU GPLv3**, you are fully permitted to fork the repository, make modifications, build your own versions, and distribute them under the terms of the GPLv3. The prohibition on third-party redistribution applies exclusively to the official compiled releases/jars published by the original creator (Dasik/Rifaditya). Forks must be published as distinct projects, not direct re-uploads of official builds.


---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
