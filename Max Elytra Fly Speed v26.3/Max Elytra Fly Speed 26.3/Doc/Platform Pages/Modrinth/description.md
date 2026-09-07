<p align="center">
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <a href="https://modrinth.com/mod/dasik-library"><img src="https://img.shields.io/badge/Requires-Dasik_Library-8A2BE2?style=for-the-badge" alt="Requires Dasik Library"></a>
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🚀 Max Elytra Fly Speed

> **"Break the Sound Barrier. Limitless Velocity. Instant Flight."**

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.
> <br><br>
> **Dependency Requirement:** For modern Minecraft 26.x releases (26.2, 26.3+), this mod requires both **Fabric API** and **Dasik Library** (`v1.8.2+`).

Every Minecraft player knows the limitation of vanilla Elytra flight: no matter how hard you dive or how many firework rockets you use, you hit an invisible terminal velocity wall. Exploring distant dimensions or traversing tens of thousands of blocks across multiplayer worlds takes agonizingly long, consuming stacks of rockets for sluggish momentum.

**Max Elytra Fly Speed** completely removes artificial speed ceilings. Powered by customizable GameRules and dynamic vector physics, it unlocks supersonic Elytra flight, multi-phase rocket boost acceleration, and silky-smooth aerodynamic gliding with zero server-flight kicks!

Part of the **Instant Gratification Collection** — mods that speed up and enhance vanilla mechanics.

---

## ✨ Features

<p align="center">
  <strong>🎬 Video Showcase: Supersonic Elytra Flight Demonstration</strong><br>
  <em>Click the preview below to watch the feature showcase on YouTube:</em><br><br>
  <a href="https://youtu.be/Oz8NTfX0YmE" target="_blank" rel="noopener">
    <img src="https://img.youtube.com/vi/Oz8NTfX0YmE/maxresdefault.jpg" alt="Video Tutorial Showcase" width="85%">
  </a>
  <br><br>
  <a href="https://youtu.be/Oz8NTfX0YmE" target="_blank" rel="noopener">
    <img src="https://img.shields.io/badge/▶_Watch_Video-Play_on_YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white" alt="▶ Play Video on YouTube">
  </a>
</p>

### 🏎️ Uncapped Velocity Ceiling
- **Configurable Speed Limit**: Clamp your maximum flight speed to any velocity (default: `50` blocks/sec). Set it to `100`, `200`, or even `500` blocks/sec for breathtaking supersonic travel!
- **Smooth Speed Clamping**: Safely scales entity delta movement on the fly without jitter, sudden stops, or camera snapping.

### 🚀 Dual-Phase Rocket Boost Acceleration
Vanilla rockets apply a fixed, flat impulse that quickly plateaus. Max Elytra Fly Speed introduces intelligent 2-phase rocket propulsion (`RocketBoostHelper`):
- **Phase 1 (Initial Boost)**: Delivers snappy, responsive vanilla launch acceleration up to a configurable baseline (default: `30` blocks/sec).
- **Phase 2 (High-Speed Glide Acceleration)**: Rocket thrust smoothly accelerates your velocity vector toward your configured maximum speed using proportional vector convergence (`elytra_high_speed_acceleration`, default: `15%` per tick).

### 🪂 Dynamic Aerodynamic Drag Damping
- In vanilla, steep dives bleed speed quickly due to harsh hardcoded aerodynamic drag (`0.99` horizontal, `0.98` vertical).
- Max Elytra Fly Speed relaxes aerodynamic drag dynamically at higher speed settings (`0.01 / (maxSpeed/50)`), allowing steep pitch dives to build up massive kinetic momentum and sustain long-distance high-speed glides without wasting fireworks!

### 🛡️ Server Flight Kick Tolerance
- Built to operate harmoniously with server movement checks:
- Intercepts and scales movement cleanly within native fall-flying physics routines (`LivingEntityMixin`), preventing false-positive "Flying is not enabled on this server" kicks during high-speed travel.

### 🧩 Compatibility & HUD Integration
- **Server-Side Compatible**: Works seamlessly on dedicated servers. Clients do not need the mod installed when connecting to a supported server!
- **ModMenu & Cloth Config / YACL**: Adjust baseline worldgen defaults directly from the main-menu graphical settings screen.
- **Speedometer Synergy**: Pair with Speedometer to watch your true blocks-per-second velocity climb in real time!

---

## 📊 Quick Reference & Mechanics Matrix

| Mechanic / Parameter | Vanilla Default | Max Elytra Fly Speed Default | Range / Limit | Mathematical Impact |
| :--- | :---: | :---: | :---: | :--- |
| **Max Flight Speed** | ~33.5 blocks/sec | **`50` blocks/sec** | `1` to `2147483647` | Maximum fall-flying velocity ceiling (`max_elytra_fly_speed`). |
| **Initial Boost Speed** | Fixed impulse | **`30` blocks/sec** | `1` to `2147483647` | Speed threshold for snappy launch boost (`elytra_initial_boost_speed`). |
| **High Speed Accel** | None (Caps out) | **`15%` per tick** | `1%` to `1000%` | Convergence rate toward max speed ceiling (`elytra_high_speed_acceleration`). |
| **Aerodynamic Drag** | Fixed 0.99H / 0.98V | **Dynamic Scaling** | Auto-calculated | Damping loss relaxes proportionally (`dragLoss / (maxSpeed / 50)`). |
| **Server Movement** | Strict kick checks | **Safe Parity** | Server-friendly | Operates inside native fall-flying delta movement. |

---

## 🚀 In-Game Commands & Quick Start

Tune flight parameters on the fly via Minecraft's native `/gamerule` command with full tab completion:

```text
/gamerule max-elytra-fly-speed:max_elytra_fly_speed <blocks_per_sec>       → Set maximum flight speed ceiling (e.g. 100, 150)
/gamerule max-elytra-fly-speed:elytra_initial_boost_speed <blocks_per_sec> → Set threshold for initial snappy rocket boost (e.g. 40)
/gamerule max-elytra-fly-speed:elytra_high_speed_acceleration <percent>    → Set high-speed acceleration rate (e.g. 20 for 20%/tick)
```

---

## ⚙️ Configuration (Native GameRules)

> [!IMPORTANT]
> **💡 Config vs. In-Game GameRules:** The global configuration file only defines default values for newly created worlds. In existing worlds, change settings in-game via the **Edit Game Rules** UI screen or the `/gamerule` command.

| GameRule Name | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `Integer` | `50` | `1` to `2147483647` | Maximum velocity of Elytra flight in Blocks/Second. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `Integer` | `30` | `1` to `2147483647` | Speed threshold (Blocks/Second) up to which snappy vanilla rocket boost applies. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `Integer` | `15` | `1` to `1000` | High-speed acceleration rate percentage per tick above the initial boost threshold. |

---

## 📖 In-Depth How-To & Flight Playbook

### 1. Drop-In Setup & Baseline Flight
1. Install **Fabric API**, **Dasik Library**, and **Max Elytra Fly Speed** into your `mods` folder.
2. Equip your Elytra, jump from a high ledge, and ignite a firework rocket to experience immediate, responsive flight.

### 2. Live In-Game Speed Adjustment
- Want casual cruising? Leave the default at `50` blocks/sec.
- Want high-speed transit? Type `/gamerule max-elytra-fly-speed:max_elytra_fly_speed 100`.
- Want to cross whole continents in seconds? Type `/gamerule max-elytra-fly-speed:max_elytra_fly_speed 250`. Changes apply immediately to all airborne players!

### 3. Mastering Multi-Phase Rocket Propulsion
- When launching from the ground, your first rocket kick delivers immediate vanilla thrust up to `30` blocks/sec.
- While maintaining your flight path, tap 1–2 additional fireworks to engage Phase 2 proportional acceleration, pulling your character smoothly up to your max speed ceiling.

### 4. Supersonic Diving & Momentum Gliding
- Pitch your crosshair downward into a steep 45° dive.
- Thanks to dynamic aerodynamic drag reduction, your momentum converts cleanly into forward velocity without bleeding off. Level out toward the horizon to glide at sustained high speeds without using extra fireworks!

### 5. Server Setup & Chunk Generation Tips
- When configuring high speeds on multiplayer servers (`>100 blocks/sec`), ensure your server has fast chunk generation or pre-generate terrain (using mods like Chunky) so the landscape keeps up with your supersonic gliders.

---

## 🧩 Recommended Sister Mods

If you enjoy **Max Elytra Fly Speed**, these companion mods from the **Instant Gratification** and **Vanilla Outsider** collections plug in seamlessly:

* ⏱️ [**Speedometer**](https://modrinth.com/mod/vo-speedometer): Display your live velocity in blocks/second on your HUD to track your supersonic flight speeds.
* ⚒️ [**Durability Multiplier**](https://modrinth.com/mod/instant-gratification-durability-multiplier): Make your Elytra unbreakable or multiply durability so you never suffer mid-air glider failures.
* 📦 [**Stack Size Adjuster**](https://modrinth.com/mod/ig-stack-size-adjuster): Stack firework rockets up to 64 or custom limits so you never run out of propellant.

> 🌟 *Explore the full [**Instant Gratification Collection**](https://modrinth.com/collection/instant-gratification) for more high-convenience enhancements.*

---

## ☕ Support

If you enjoy the **Instant Gratification Collection**, consider fueling future development!

<p align="center">
  <a href="https://ko-fi.com/dasikigaijin/tip"><img src="https://img.shields.io/badge/Ko--fi-Support%20Me-FF5E5B?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Ko-fi"></a>
  <a href="https://sociabuzz.com/dasikigaijin/tribe"><img src="https://img.shields.io/badge/SocioBuzz-Local_Support-7BB32E?style=for-the-badge" alt="SocioBuzz"></a>
  <a href="https://saweria.co/DasikIgaijinn"><img src="https://img.shields.io/badge/Saweria-Local_Support-FFA500?style=for-the-badge" alt="Saweria"></a>
</p>

> [!NOTE]
> **🇮🇩 Indonesian Users:** SocioBuzz and Saweria support local payment methods (Gopay, OVO, Dana, etc.) if you want to support me without using PayPal/Ko-fi!

> [!TIP]
> **Dedicated Server Hosting Partner:**
> Looking for a reliable server to play with friends? Check out **BisectHosting** for 1-click modpack installations, automated backups, and 24/7 dedicated customer support.

---

## 📜 Credits & Modpack Permissions

| Property | Information |
| :--- | :--- |
| **Creator / Author** | **Dasik** (Rifaditya) |
| **Collection** | Instant Gratification Collection |
| **License** | [GNU General Public License v3.0 (GPLv3)](https://www.gnu.org/licenses/gpl-3.0.html) |
| **Source Code** | [GitHub - Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed](https://github.com/Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed/issues) |
| **Documentation / Wiki** | [GitHub Wiki](https://github.com/Rifaditya/Instant-Gratification-Max-Elytra-Fly-Speed/wiki) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**<br>
> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (**Modrinth** or **CurseForge**). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.
> <br><br>
> **⚖️ License & Fork Guidelines (No Zero-Change Re-uploads):**<br>
> This project is open-source under the **GNU GPLv3**. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br>
> **However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.**

---

<p align="center">
  <strong>Made with ❤️ for the Minecraft community</strong><br>
  <em>Part of the Instant Gratification Collection</em>
</p>
