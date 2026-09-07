🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Двухступенчатое ракетное ускорение и схождение векторов — MC 26.2

This page details the mathematical propulsion algorithms, state transitions, and vector difference convergence powering firework rocket boosting in **Max Elytra Fly Speed (MC 26.2)**.

> 📌 **Отказ от ответственности за источник репозитория**: Данная вики-документация отражает **текущее состояние исходного кода в репозитории**, которое может содержать новейшие неопубликованные коммиты или функции в разработке до публичных релизов на CurseForge и Modrinth.

---

## 📋 Официальная техническая информация

| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Two-Tier Firework Rocket Propulsion & Vector Convergence |
| **Java Implementation** | `net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper` |
| **Bytecode Mixin** | `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` |
| **Target Method** | `FireworkRocketEntity.tick` |
| **Controlling GameRules** | `elytra_initial_boost_speed` (Default: `30`), `elytra_high_speed_acceleration` (Default: `15`) |
| **Algorithmic Complexity** | $\mathcal{O}(1)$ time complexity, zero memory allocations per tick |
| **Convergence Rate** | $15\%\text{ vector difference per tick}$ ($f_{\text{acc}} = 0.15$) |

---

## 🎮 Пошаговый процесс полета для игрока

**Max Elytra Fly Speed** introduces a **Two-Tier Propulsion Engine**:
1. **Tier 1 — Snappy Launch Boost ($v < 30\text{ BPS}$)**: When launching from a standstill or slow glide, the rocket delivers instant, snappy vanilla acceleration ($50\%$ convergence per tick) to quickly reach cruising velocity.
2. **Tier 2 — High-Speed Vector Convergence ($v \ge 30\text{ BPS}$)**: Above $30\text{ BPS}$, the rocket transitions to proportional vector difference convergence, pulling the flight vector smoothly towards the camera look angle.
3. **Continuous Re-Orientation**: As the player turns their camera, high-speed convergence factors align momentum with the new look direction.

---

## 📐 Математические модели ускорения ракет

### 1. Tier 1: Snappy Initial Acceleration
$$\vec{b}_{\text{initial}} = \vec{u}_{\text{look}} \times 0.1 + \left(\vec{u}_{\text{look}} \times v_{\text{initial\_ticks}} - \vec{v}_{\text{old}}\right) \times 0.5$$

### 2. Tier 2: Proportional High-Speed Vector Convergence
$$\vec{b}_{\text{high}} = \vec{u}_{\text{look}} \times 0.1 + \left(\vec{u}_{\text{look}} \times v_{\text{max\_ticks}} - \vec{v}_{\text{old}}\right) \times f_{\text{acc}}$$

where $f_{\text{acc}}$ is:
$$f_{\text{acc}} = \max\left(0.05, \frac{\text{highAccPermille}}{100.0}\right)$$

---

## 🧭 Главные разделы
* [[📖 26.2 Обзор портала|Home]]
* [[🌀 26.2 Кинетика и аэродинамика|Kinetic-Physics-and-Drag]]
* [[⚙️ 26.2 Игровые правила и настройки|GameRules-and-Configuration]]
* [[🧩 26.2 Архитектура и миксины|Architecture-and-Mixins]]
* [[🏠 Главная страница|Home]]
