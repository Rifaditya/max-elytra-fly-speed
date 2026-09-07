🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 系统架构、字节码 Mixin 与性能表现 — MC 26.3

This page details the internal software architecture, bytecode mixin injection targets, performance guardrails, and automated testing suites for **Max Elytra Fly Speed (MC 26.3)**.

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

---

## 📋 官方技术规格

| Parameter | Technical Details |
| :--- | :--- |
| **Java Package Namespace** | `net.instantgratification.maxelytraflyspeed` |
| **Mixin Configuration** | `max-elytra-fly-speed.mixins.json` |
| **Primary Physics Injector** | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` |
| **Rocket Propulsion Injector**| `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` |
| **Dynamic GameRule Provider** | `net.instantgratification.maxelytraflyspeed.config.MaxSpeedRules` |
| **Library Dependencies** | `dasik-library >= 1.8.2` (MC 26.2) / `>= 1.8.24` (MC 26.3) |

---

## 🧩 字节码 Mixin 注入剖析

1. **`LivingEntityMixin`**:
   - Injects into `LivingEntity.updateFallFlyingMovement` and `LivingEntity.travelFallFlying`.
   - Modifies horizontal and vertical drag decay factors inversely scaled with `max_elytra_fly_speed`.
2. **`FireworkRocketEntityMixin`**:
   - Injects into `FireworkRocketEntity.tick`.
   - Replaces vanilla deceleration clamp with two-tier vector difference convergence.

---

## 🛡️ 性能与内存保障
- **Zero Allocations in Hot Paths**: Pre-calculated scalars and reusable primitive math methods.
- **Safety Clamping**: Upper bounds enforce sanity checks up to `Integer.MAX_VALUE`.

---

## 🧭 核心入口
* [[📖 26.3 门户概览|Home]]
* [[🌀 26.3 动能物理与动态阻力|Kinetic-Physics-and-Drag]]
* [[🚀 26.3 火箭推进与向量收敛|Rocket-Propulsion-and-Acceleration]]
* [[⚙️ 26.3 游戏规则与配置|GameRules-and-Configuration]]
* [[🏠 中央门户|Home]]
