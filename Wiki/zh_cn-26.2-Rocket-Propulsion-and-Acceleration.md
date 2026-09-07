🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 双阶烟花火箭推进与向量收敛 — MC 26.2

This page details the mathematical propulsion algorithms, state transitions, and vector difference convergence powering firework rocket boosting in **Max Elytra Fly Speed (MC 26.2)**.

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

---

## 📋 官方技术规格

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

## 🎮 生存操作流程与玩法指南

**Max Elytra Fly Speed** introduces a **Two-Tier Propulsion Engine**:
1. **Tier 1 — Snappy Launch Boost ($v < 30\text{ BPS}$)**: When launching from a standstill or slow glide, the rocket delivers instant, snappy vanilla acceleration ($50\%$ convergence per tick) to quickly reach cruising velocity.
2. **Tier 2 — High-Speed Vector Convergence ($v \ge 30\text{ BPS}$)**: Above $30\text{ BPS}$, the rocket transitions to proportional vector difference convergence, pulling the flight vector smoothly towards the camera look angle.
3. **Continuous Re-Orientation**: As the player turns their camera, high-speed convergence factors align momentum with the new look direction.

---

## 📐 推进动力学数学模型

### 1. Tier 1: Snappy Initial Acceleration
$$\vec{b}_{\text{initial}} = \vec{u}_{\text{look}} \times 0.1 + \left(\vec{u}_{\text{look}} \times v_{\text{initial\_ticks}} - \vec{v}_{\text{old}}\right) \times 0.5$$

### 2. Tier 2: Proportional High-Speed Vector Convergence
$$\vec{b}_{\text{high}} = \vec{u}_{\text{look}} \times 0.1 + \left(\vec{u}_{\text{look}} \times v_{\text{max\_ticks}} - \vec{v}_{\text{old}}\right) \times f_{\text{acc}}$$

where $f_{\text{acc}}$ is:
$$f_{\text{acc}} = \max\left(0.05, \frac{\text{highAccPermille}}{100.0}\right)$$

---

## 🧭 核心入口
* [[📖 26.2 门户概览|zh_cn-26.2-Home]]
* [[🌀 26.2 动能物理与动态阻力|zh_cn-26.2-Kinetic-Physics-and-Drag]]
* [[⚙️ 26.2 游戏规则与配置|zh_cn-26.2-GameRules-and-Configuration]]
* [[🧩 26.2 架构设计与 Mixin 解析|zh_cn-26.2-Architecture-and-Mixins]]
* [[🏠 中央门户|zh_cn-Home]]
