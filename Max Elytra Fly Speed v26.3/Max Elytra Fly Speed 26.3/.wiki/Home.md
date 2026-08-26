# Max Elytra Fly Speed — Minecraft 26.3 Edition

Welcome to the local technical documentation and player guide for **Max Elytra Fly Speed** (Minecraft 26.3 Edition).

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

## ⚡ Quick Start & Key Metrics

Max Elytra Fly Speed unchains Elytra flight physics, replacing vanilla hard speed clamps with configurable dynamic drag floor scaling and two-tier vector convergence rocket propulsion:

| Metric / Property | Default Value | Configurable Range | Controlling GameRule |
| :--- | :---: | :---: | :--- |
| **Max Flight Speed Ceiling** | **50 Blocks/Sec** ($2.5\text{ blocks/tick}$) | $1\text{ to }\infty\text{ BPS}$ | `max-elytra-fly-speed:max_elytra_fly_speed` |
| **Initial Boost Speed Threshold** | **30 Blocks/Sec** ($1.5\text{ blocks/tick}$) | $1\text{ to }\infty\text{ BPS}$ | `max-elytra-fly-speed:elytra_initial_boost_speed` |
| **High Speed Acceleration Rate** | **15% per tick** ($f = 0.15$) | $1\%\text{ to }1000\%\text{ per tick}$ | `max-elytra-fly-speed:elytra_high_speed_acceleration` |
| **Vanilla Horizontal Drag Loss** | $1.0\%\text{ per tick}$ ($0.99\times$) | Scaled dynamically $\le 50\text{ BPS}$ | Scaled inversely with max speed |
| **Vanilla Vertical Drag Loss** | $2.0\%\text{ per tick}$ ($0.98\times$) | Scaled dynamically $\le 50\text{ BPS}$ | Scaled inversely with max speed |

---

## 🧭 Subsystem Documentation

* [[🌀 Kinetic Physics & Drag|Kinetic-Physics-and-Drag]]: Dynamic drag floor scaling equations, dive momentum accumulation, and fall-flying vector damping.
* [[🚀 Rocket Propulsion & Acceleration|Rocket-Propulsion-and-Acceleration]]: Two-tier firework rocket propulsion, snappy boost vs proportional vector convergence.
* [[⚙️ GameRules & Configuration|GameRules-and-Configuration]]: Dynamic GameRules reference table, vanilla `/gamerule` commands, and Cloth Config GUI.
* [[🧩 Architecture & Mixins|Architecture-and-Mixins]]: Bytecode mixin analysis, $O(1)$ zero-allocation tick loops, and automated JUnit reality tests.
* [[🛠️ Developer Setup & Testing|Developer-Setup-and-Building]]: JDK 25 environment, Loom build commands, and test verification.

---

## 📜 Copyright & License

* **Author**: **Dasik (Rifaditya)**
* **License**: **GNU General Public License v3.0 (GPLv3)**
