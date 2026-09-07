🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Max Elytra Fly Speed — Minecraft 26.2 Edition

Welcome to the local technical documentation and player guide for **Max Elytra Fly Speed** (Minecraft 26.2 Edition).

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

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

## 🧭 기본 내비게이션

* [[🌀 26.2 운동 물리학 및 공기 저항|ko_kr-26.2-Kinetic-Physics-and-Drag]]: Dynamic drag floor scaling equations, dive momentum accumulation, and fall-flying vector damping.
* [[🚀 26.2 로켓 추진 및 벡터 수렴|ko_kr-26.2-Rocket-Propulsion-and-Acceleration]]: Two-tier firework rocket propulsion, snappy boost vs proportional vector convergence.
* [[⚙️ 26.2 게임 규칙 및 구성|ko_kr-26.2-GameRules-and-Configuration]]: Dynamic GameRules reference table, vanilla `/gamerule` commands, and Cloth Config GUI.
* [[🧩 26.2 아키텍처 및 믹스인 분석|ko_kr-26.2-Architecture-and-Mixins]]: Bytecode mixin analysis, $O(1)$ zero-allocation tick loops, and automated JUnit reality tests.
* [[🛠️ 개발자 환경 설정 및 테스트|ko_kr-Developer-Setup-and-Building]]: JDK 25 environment, Loom build commands, and test verification.

---

## 📜 저작권 및 라이선스
* **Author**: **Dasik (Rifaditya)**
* **License**: **GNU General Public License v3.0 (GPLv3)**
