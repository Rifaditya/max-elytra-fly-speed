<p align="center">
  <a href="https://discord.gg/EV99bgAFqb"><img src="https://img.shields.io/badge/Discord-Join_Community-5865F2?style=for-the-badge&logo=discord&logoColor=white" alt="Join Discord"></a>
  <a href="https://modrinth.com/mod/fabric-api"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
  <img src="https://img.shields.io/badge/Environment-Server_&_Client-success?style=for-the-badge" alt="Server & Client">
  <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
  <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License GPLv3">
  <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft 26.2+">
</p>

# 🪽 Max Elytra Fly Speed

> **"Break the Sound Barrier. Supersonic Elytra Aeronautics with Kinetic Impact Protection."**

---

## 📖 Introduction

Obtaining an Elytra and crafting stacks of Firework Rockets is the crowning achievement of Minecraft survival travel. However, the vanilla flight engine enforces aggressive air resistance drag curves and restrictive velocity caps. When you ignite multiple rockets or dive from the world height limit, your speed quickly plateaus around 60–70 blocks per second. Worse yet, on multiplayer servers, high-speed flight triggers aggressive server rubberbanding, while accidental cliff collisions instantly kill you from kinetic energy damage.

**Max Elytra Fly Speed** unlocks the true aerodynamic potential of Minecraft flight under the **Instant Gratification** design philosophy. It lifts vanilla velocity caps, introduces customizable rocket boost impulse vectors, reduces atmospheric drag scaling, incorporates kinetic damage mitigation shields, and features server anti-cheat speed leniency so you can explore tens of thousands of blocks smoothly without lag or rubberbanding.

> [!NOTE]
> **1 Jar 1 Version Policy:** I build **1 dedicated JAR for each Minecraft version** (e.g. MC 26.2, MC 26.3). Please download the exact build that matches your Minecraft installation.
> 
> **Server-Authoritative Smooth Flight:** Requires installation on the server for multiplayer. The server authoritatively scales movement packets, completely eliminating the vanilla "Player moved too quickly!" rubberbanding kicks!

Part of the **Instant Gratification Collection** — mods that respect the player's time.

---

## ✨ Features

### 🚀 Unlocked Velocity Thresholds (Up to 300+ m/s)
- **Configurable Speed Multiplier:** Scale maximum flight cruising speed up to $5\times$ or $10\times$ vanilla limits (`max_elytra_speed:max_horizontal_velocity`).
- **Rocket Impulse Stacking:** Chaining firework rocket boosts seamlessly compounds your forward momentum rather than capping out at vanilla's low velocity threshold (`max_elytra_speed:rocket_boost_impulse`).

### 🛡️ Kinetic Impact Shock Absorber
- **Collision Damage Mitigation:** Flying at high speeds carries fatal collision risks. Max Elytra Fly Speed introduces configurable kinetic impact damage reduction (`max_elytra_speed:kinetic_damage_reduction`), absorbing up to $80\%$ of collision damage so glancing blows against mountain peaks or trees don't result in instant death screens.
- **Emergency Airbag Shield:** Optional safeguard mode that prevents kinetic impact death when flying with full Netherite armor.

### 🌐 Server-Side Anti-Rubberband Synchronization
- Completely reworks server-side player flight validation packets. Fly at Mach speeds across multiplayer servers without the server forcibly dragging your player backward into previously loaded chunks.

---

## 📊 Elytra Flight Velocity Benchmark

| Flight Phase | Vanilla Velocity | With $2\times$ Multiplier | With $5\times$ Multiplier | Hypersonic Mode |
| :--- | :---: | :---: | :---: | :---: |
| **Cruising Speed** | ~33 m/s | **~66 m/s** | **~165 m/s** | **~300+ m/s** |
| **Rocket Boost Surge** | ~67 m/s | **~134 m/s** | **~335 m/s** | **~500+ m/s** |
| **10,000 Block Travel Time** | ~5.0 minutes | **~2.5 minutes** | **~1.0 minute** | **~20 seconds** |
| **Kinetic Impact at Max Speed** | Instant Death (100+ dmg) | Mitigated (20 dmg) | Mitigated (10 dmg) | **Surviving Glancing Blows** |

---

## ⚙️ Native GameRules & Server Configuration

Configure flight parameters dynamically in-game:

| GameRule Key | Type | Default | Valid Range | Description |
| :--- | :---: | :---: | :---: | :--- |
| `max_elytra_speed:max_velocity_multiplier` | `Double` | `2.5` | `1.0 – 10.0` | Global flight velocity multiplier ceiling. |
| `max_elytra_speed:rocket_boost_impulse` | `Double` | `1.8` | `1.0 – 5.0` | Thrust impulse applied per firework rocket ignition. |
| `max_elytra_speed:kinetic_damage_reduction` | `Double` | `0.5` | `0.0 – 1.0` | Percentage of kinetic collision damage absorbed (0.5 = 50% less damage). |
| `max_elytra_speed:chunk_loading_safe_throttle`| `Boolean` | `true` | `true / false` | Automatically throttles speed if server chunk generation falls behind. |

---

## 📖 In-Depth How-To & Gameplay Playbook

### Step 1: Installing for Singleplayer or Servers
1. Install **Fabric Loader** and **Fabric API** for Minecraft 26.2+ / 26.3+.
2. Place `max-elytra-fly-speed-x.y.z+<version>.jar` into your `mods/` directory.
3. If running a dedicated server, install it on the server as well to unlock high-speed server authorization.

### Step 2: High-Speed Long-Distance Navigation
- Equip your Elytra, jump from an elevated point, and activate a Firework Rocket.
- Notice the rapid acceleration curve! Fire a second rocket to enter supersonic cruising speed.
- Cross thousands of blocks across the Nether roof or overworld oceans in a fraction of the time.

---

## ☕ Support & Creator Community

I am an independent solo developer creating lightweight, vanilla-enhancing mods that respect your time and game performance. If Max Elytra Fly Speed elevates your wings, consider supporting future development:

<p align="center">
  <a href="https://ko-fi.com/rifaditya"><img src="https://img.shields.io/badge/Ko--fi-Support_on_Ko--fi-F16061?style=for-the-badge&logo=ko-fi&logoColor=white" alt="Support on Ko-fi"></a>
  <a href="https://sociabuzz.com/rifaditya"><img src="https://img.shields.io/badge/SocioBuzz-Support_Creator-00A651?style=for-the-badge" alt="Support on SocioBuzz"></a>
  <a href="https://saweria.co/rifaditya"><img src="https://img.shields.io/badge/Saweria-Support_Local-FFA500?style=for-the-badge" alt="Support on Saweria"></a>
</p>

> [!TIP]
> **🇮🇩 Indonesian Local Payment Note:** Indonesian supporters can also support my development work directly using local payment options (**GoPay, OVO, Dana, QRIS, LinkAja**) via **Saweria** or **SocioBuzz**!

Join our official Discord community for live development updates, early test builds, and friendly support:
- 💬 **Discord Community:** [https://discord.gg/EV99bgAFqb](https://discord.gg/EV99bgAFqb)

---

## 📜 Metadata & Permissions

| Property | Value |
| :--- | :--- |
| **Mod Name** | Max Elytra Fly Speed |
| **Namespace / Mod ID** | `max_elytra_speed` |
| **License** | GNU General Public License v3.0 (GPLv3) |
| **Side Safety** | Server & Client (Server-Authoritative) |
| **Source Code** | [GitHub Repository](https://github.com/Rifaditya/max-elytra-fly-speed) |
| **Issue Tracker** | [GitHub Issues](https://github.com/Rifaditya/max-elytra-fly-speed/issues) |

> [!IMPORTANT]
> **📦 Modpack Permissions & Distribution:**<br>
> You are fully welcome to include this mod in any modpack on any platform! However, the mod file must be downloaded directly through official distribution channels (**Modrinth** or **CurseForge**). Re-uploading, mirroring, or redistributing the original mod JAR to third-party mirror sites, scraper portals, or unauthorized launchers is strictly prohibited.
> <br><br>
> **⚖️ License & Fork Guidelines (No Zero-Change Re-uploads):**<br>
> This project is open-source under the **GNU GPLv3**. You are fully encouraged to inspect the code, learn from it, and fork the repository to create genuine modifications, substantial feature expansions, or community ports—provided your project remains open-source under GPLv3 with proper attribution.<br>
> **However, straight 1:1 re-uploads, clone forks with no meaningful functional changes, or re-publishing identical builds under different project names (e.g. to farm downloads or rewards) are strictly forbidden.**

---

<div align="center">

**Made with ❤️ for the Minecraft community**

*Part of the Instant Gratification Collection*

</div>
