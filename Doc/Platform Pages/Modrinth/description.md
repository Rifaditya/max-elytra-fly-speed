<p align="center">
  <a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Discord"></a>
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <a href="https://modrinth.com/mod/dasik-library"><img src="https://img.shields.io/badge/Requires-Dasik_Library-9B59B6?style=for-the-badge" alt="Requires Dasik Library"></a>
  <img src="https://img.shields.io/badge/Environment-Server_%26_Client-success?style=for-the-badge" alt="Server & Client">
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-1.20.1_|_1.21.x_|_26.x-brightgreen?style=for-the-badge" alt="Minecraft Versions">
</p>

# 🪽 Max Elytra Fly Speed

> **"Lift the vanilla flight ceiling — tune Elytra speed and rocket boost to exactly how you want to fly."**

---

## 📖 Introduction

Vanilla Minecraft's Elytra flight engine caps your speed aggressively. No matter how many Firework Rockets you fire or how steep your dive angle, the engine clamps momentum and imposes fixed drag curves that prevent you from ever going truly fast. This is vanilla's intentional design — but it is a design I built a configurable override for.

**Max Elytra Fly Speed** exposes three native GameRules that let you push the flight ceiling to wherever you want it. Set a higher maximum speed in Blocks/Second, tune the rocket launch threshold, and dial in the high-speed acceleration factor. The mod uses two targeted Mixins that replace the vanilla drag calculation and rocket boost vector with fully configurable equivalents — nothing else is touched.

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR per Minecraft version** (e.g. MC 26.2, MC 26.3). Download the build that matches your exact Minecraft installation.

> [!IMPORTANT]
> **Server + Client Installation Required:** Install the mod on both the server and the client for multiplayer. GameRules are server-authoritative — the configured speed ceiling applies to all players on the server.

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🚀 Configurable Maximum Flight Speed
The mod replaces the vanilla elytra drag multiplier with a dynamic calculation in `ElytraDragHelper`. At the default of 50 BPS the drag is identical to vanilla. Raise the limit and drag relaxes proportionally — allowing sustained higher-speed glide and diving momentum.

- Set your personal speed ceiling anywhere from **1 to 500 Blocks/Second** via GameRule.
- Velocity is hard-clamped each tick to ensure the configured ceiling is never exceeded.

### 🎆 Configurable Rocket Boost Engine
The mod redirects vanilla's firework `setDeltaMovement` call through `RocketBoostHelper`, which implements a two-phase boost model:

1. **Snappy Launch Phase** — below the `elytra_initial_boost_speed` threshold, rocket ignition applies fast 50% convergence acceleration toward that threshold.
2. **Proportional Convergence Phase** — above the threshold, each rocket fires a proportional pull toward the max speed ceiling controlled by the `elytra_high_speed_acceleration` factor.

This means chaining rockets provides meaningful acceleration all the way up to your configured ceiling, rather than plateauing at the vanilla rocket cap.

### 🎛️ Optional In-Game Configuration GUI
Install **ModMenu** + **YACL (YetAnotherConfigLib v3)** to access a client-side configuration screen. All three parameters are exposed as sliders with live-sync to the corresponding in-game GameRules when playing in singleplayer.

---

## ⚙️ Native GameRules & Server Configuration

All three GameRules are registered under the `max-elytra-fly-speed` namespace and appear in the in-game GameRule screen under their own category.

| GameRule Key | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `Integer` | `50` | `1 – 500` | Maximum Elytra flight speed ceiling in Blocks/Second. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `Integer` | `30` | `1 – 300` | Speed threshold (BPS) below which rocket ignition applies snappy launch acceleration. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `Integer` | `15` | `1 – 1000` | High-speed convergence rate (permille, i.e. 15 = 15%) toward max speed per rocket above threshold. |

> [!TIP]
> **Vanilla behaviour at defaults:** At `max_elytra_fly_speed = 50` and `elytra_initial_boost_speed = 30` and `elytra_high_speed_acceleration = 15`, flight physics are near-identical to unmodded Minecraft. Increase values gradually to find your preferred feel.

---

## 🏗️ How It Works (Technical)

Two Mixins are injected into vanilla classes:

| Mixin | Target | What It Does |
| :--- | :--- | :--- |
| `LivingEntityMixin` | `LivingEntity#updateFallFlyingMovement` | Redirects the drag `Vec3.multiply()` call through `ElytraDragHelper`, which relaxes horizontal and vertical drag proportionally as the configured max speed rises above 50 BPS. Also injects before `move()` to hard-clamp velocity to the configured ceiling. |
| `FireworkRocketEntityMixin` | `FireworkRocketEntity#tick` | Redirects `setDeltaMovement()` through `RocketBoostHelper` to implement two-phase snappy launch + proportional high-speed convergence. |

No packet manipulation. No command system. No damage modification. Strictly flight physics only.

---

## 📦 Installation & Requirements

### Required
- **Fabric Loader** `>= 0.19.5`
- **Fabric API** (any version matching your MC anchor)
- **[Dasik Library](https://modrinth.com/mod/dasik-library)** `>= 1.9.0`
- **Java 25**

### Optional
- **[ModMenu](https://modrinth.com/mod/modmenu)** — adds config screen entry
- **[YetAnotherConfigLib (YACL) v3](https://modrinth.com/mod/yacl)** — enables in-game configuration sliders

### Supported Minecraft Versions
`1.20.1` · `1.21.1` · `1.21.11` · `26.1.2` · `26.2` · `26.3+`

---

## ☕ Support & Community

I'm an independent solo developer building lightweight, vanilla-enhancing mods. If Max Elytra Fly Speed made your flights more satisfying, consider supporting my work:

<p align="center">
  <a href="https://ko-fi.com/dasikigaijin"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Support on Ko-fi"></a>
  <a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
  <a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>

> [!TIP]
> **🇮🇩 Indonesian supporters:** Local payment options (**GoPay, OVO, Dana, QRIS, LinkAja**) available via **Saweria** or **SocioBuzz**!

- 💬 **Discord:** [https://discord.gg/EV99bgAFqb](https://discord.gg/EV99bgAFqb)

---

## 📜 Metadata & Permissions

| Property | Value |
| :--- | :--- |
| **Mod Name** | Max Elytra Fly Speed |
| **Namespace / Mod ID** | `max-elytra-fly-speed` |
| **License** | GNU General Public License v3.0 (GPLv3) |
| **Environment** | Server & Client |
| **Source Code** | [GitHub Repository](https://github.com/Rifaditya/max-elytra-fly-speed) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/max-elytra-fly-speed/issues) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**
> You are welcome to include this mod in any modpack on any platform. The mod file must be downloaded through official channels (**Modrinth** or **CurseForge**). Re-uploading or mirroring the JAR to third-party sites is strictly prohibited.
>
> **⚖️ Fork Guidelines:**
> This project is open-source under **GNU GPLv3**. You may fork it for genuine modifications or ports — provided your project stays open-source under GPLv3 with attribution. Straight 1:1 re-uploads or clone forks with no meaningful changes are forbidden.

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
