🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Max Elytra Fly Speed — Minecraft 26.3 Edition

Welcome to the local technical documentation and player guide for **Max Elytra Fly Speed** (Minecraft 26.3 Edition).

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.

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

## 🧭 Navigation Générale

* [[🌀 26.3 Physique Cinétique & Traînée|fr_fr-26.3-Kinetic-Physics-and-Drag]]: Dynamic drag floor scaling equations, dive momentum accumulation, and fall-flying vector damping.
* [[🚀 26.3 Propulsion par Fusées & Vecteurs|fr_fr-26.3-Rocket-Propulsion-and-Acceleration]]: Two-tier firework rocket propulsion, snappy boost vs proportional vector convergence.
* [[⚙️ 26.3 GameRules & Configuration|fr_fr-26.3-GameRules-and-Configuration]]: Dynamic GameRules reference table, vanilla `/gamerule` commands, and Cloth Config GUI.
* [[🧩 26.3 Architecture & Mixins|fr_fr-26.3-Architecture-and-Mixins]]: Bytecode mixin analysis, $O(1)$ zero-allocation tick loops, and automated JUnit reality tests.
* [[🛠️ Environnement Développeur & Tests|fr_fr-Developer-Setup-and-Building]]: JDK 25 environment, Loom build commands, and test verification.

---

## 📜 Droits d'Auteur & Licence
* **Author**: **Dasik (Rifaditya)**
* **License**: **GNU General Public License v3.0 (GPLv3)**
