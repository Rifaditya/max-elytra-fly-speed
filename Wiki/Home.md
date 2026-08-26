# Max Elytra Fly Speed Wiki

Welcome to the official technical documentation and player guide for **Max Elytra Fly Speed**, an ultra-lightweight, high-performance flight physics and speed uncapping engine for Minecraft Fabric.

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]]

---

## 🧭 Multi-Version Documentation Portal

Max Elytra Fly Speed is maintained in full lockstep parity across all active Minecraft release anchors under the **1 Jar 1 Version Policy**. Select your target version below to access its dedicated, isolated documentation tree:

| Minecraft Version | Release Status | Target Branch / Subproject | Dedicated Documentation Tree |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 Active Standard | `Max Elytra Fly Speed v26.2` | [[👉 Enter MC 26.2 Wiki|26.2-Home]] |
| **Minecraft 26.3** | 🟢 Active Standard | `Max Elytra Fly Speed v26.3` | [[👉 Enter MC 26.3 Wiki|26.3-Home]] |

---

## ⚡ Core Flight Engine Highlights

* **Dynamic Aerodynamic Drag Floor Scaling**: Automatically scales fall-flying drag resistance inversely with higher configured velocity ceilings, allowing natural high-speed diving, sustained momentum, and high-velocity gliding without abrupt deceleration walls.
* **Two-Tier Firework Rocket Propulsion**: Seamlessly transitions between snappy vanilla rocket boost (up to 30 Blocks/Sec) and smooth proportional vector difference convergence towards the target maximum speed limit.
* **Namespaced Dynamic GameRules**: Fully data-driven in-game runtime administration using standard vanilla `/gamerule` commands powered by `DynamicGameRuleManager` without requiring external configuration libraries on dedicated servers.
* **Zero-Allocation Hot Path Engine**: Built with strict $O(1)$ algorithmic time complexity and zero memory allocations in the entity tick loop (`LivingEntity.updateFallFlyingMovement`, `LivingEntity.travelFallFlying`, `FireworkRocketEntity.tick`), guaranteeing smooth server TPS and zero client micro-stutters.
* **Optional Client GUI Integration**: Out-of-the-box configuration screen support with ModMenu and Cloth Config when installed, while remaining 100% crash-free on headless servers.

---

## 📚 Wiki Navigation Structure

* **🎮 Player & Administrator Manuals**:
  * **MC 26.2 Edition**: [[26.2 Overview|26.2-Home]] • [[Kinetic Physics & Drag|26.2-Kinetic-Physics-and-Drag]] • [[Rocket Propulsion & Vector Convergence|26.2-Rocket-Propulsion-and-Acceleration]] • [[GameRules & Configuration|26.2-GameRules-and-Configuration]] • [[Architecture & Mixins|26.2-Architecture-and-Mixins]]
  * **MC 26.3 Edition**: [[26.3 Overview|26.3-Home]] • [[Kinetic Physics & Drag|26.3-Kinetic-Physics-and-Drag]] • [[Rocket Propulsion & Vector Convergence|26.3-Rocket-Propulsion-and-Acceleration]] • [[GameRules & Configuration|26.3-GameRules-and-Configuration]] • [[Architecture & Mixins|26.3-Architecture-and-Mixins]]
* **💻 Developer & Technical Specifications**:
  * [[Version Compatibility & Lifecycle Matrix|Version-Compatibility]]
  * [[Developer Setup, Building & Automated Tests|Developer-Setup-and-Building]]

---

## 📜 Copyright & License

* **Author**: **Dasik (Rifaditya)**
* **License**: **GNU General Public License v3.0 (GPLv3)**
* **Repository**: [GitHub Source Code](https://github.com/Rifaditya/max-elytra-fly-speed) | [Issue Tracker](https://github.com/Rifaditya/max-elytra-fly-speed/issues)
