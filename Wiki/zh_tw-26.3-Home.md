🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Max Elytra Fly Speed — Minecraft 26.3 Edition

Welcome to the local technical documentation and player guide for **Max Elytra Fly Speed** (Minecraft 26.3 Edition).

> 📌 **代碼倉庫來源免責聲明**：本維基文件反映了**代碼倉庫中的當前源碼狀態**，可能包含領先於 CurseForge 和 Modrinth 平台公開發布版本的最新未發布提交或開發中功能。

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

## 🧭 核心入口

* [[🌀 26.3 動能物理與動態阻力|zh_tw-26.3-Kinetic-Physics-and-Drag]]: Dynamic drag floor scaling equations, dive momentum accumulation, and fall-flying vector damping.
* [[🚀 26.3 火箭推進與向量收斂|zh_tw-26.3-Rocket-Propulsion-and-Acceleration]]: Two-tier firework rocket propulsion, snappy boost vs proportional vector convergence.
* [[⚙️ 26.3 遊戲規則與配置|zh_tw-26.3-GameRules-and-Configuration]]: Dynamic GameRules reference table, vanilla `/gamerule` commands, and Cloth Config GUI.
* [[🧩 26.3 架構設計與 Mixin 解析|zh_tw-26.3-Architecture-and-Mixins]]: Bytecode mixin analysis, $O(1)$ zero-allocation tick loops, and automated JUnit reality tests.
* [[🛠️ 開發者建置與測試|zh_tw-Developer-Setup-and-Building]]: JDK 25 environment, Loom build commands, and test verification.

---

## 📜 版權與許可證
* **Author**: **Dasik (Rifaditya)**
* **License**: **GNU General Public License v3.0 (GPLv3)**
