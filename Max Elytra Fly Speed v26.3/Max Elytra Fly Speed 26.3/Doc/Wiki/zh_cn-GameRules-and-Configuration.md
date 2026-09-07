🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 动态游戏规则与配置指南 — MC 26.3

This page provides the exhaustive configuration reference, GameRule commands, permissions, and client GUI integration for **Max Elytra Fly Speed (MC 26.3)**.

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

---

## 📋 官方技术规格

| Parameter | Technical Details |
| :--- | :--- |
| **Configuration Engine** | Namespaced Dynamic GameRules via `DynamicGameRuleManager` (DasikLibrary) |
| **GameRule Category** | `max-elytra-fly-speed:max-elytra-fly-speed` |
| **Storage Mechanism** | World Save Data (`level.dat` / vanilla GameRules system) |
| **Dedicated Server Dependency** | Zero external config libraries required on servers |
| **Optional Client GUI** | ModMenu (`>=0.19.1`) + Cloth Config (`me.shedaniel.clothconfig2`) |
| **Permission Requirement** | Operator Level 2 (`requires(source -> source.hasPermission(2))`) |

---

## 🎮 管理员操作流程与指令

### 1. View Current GameRule Values
```mcfunction
/gamerule max-elytra-fly-speed:max_elytra_fly_speed
/gamerule max-elytra-fly-speed:elytra_initial_boost_speed
/gamerule max-elytra-fly-speed:elytra_high_speed_acceleration
```

### 2. Set Custom Flight Speed Limits
```mcfunction
# Set maximum Elytra flight speed ceiling to 150 Blocks/Second
/gamerule max-elytra-fly-speed:max_elytra_fly_speed 150

# Set initial snappy rocket boost speed to 40 Blocks/Second
/gamerule max-elytra-fly-speed:elytra_initial_boost_speed 40

# Set high-speed rocket acceleration rate to 25% per tick
/gamerule max-elytra-fly-speed:elytra_high_speed_acceleration 25
```

---

## 📑 完整游戏规则参考表

| GameRule Identifier | Data Type | Default Value | Valid Range | Localized Name | Functional Description |
| :--- | :---: | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `Integer` | `50` | `1` to `2147483647` | **Max Speed (Blocks/Sec)** | Hard ceiling for Elytra fall-flying velocity in Blocks/Second. Relaxed drag applies above 50 BPS. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `Integer` | `30` | `1` to `2147483647` | **Initial Boost Speed** | Velocity threshold up to which snappy vanilla boost is applied. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `Integer` | `15` | `1` to `1000` | **High Speed Acceleration** | High-speed rocket acceleration percentage applied above initial boost speed. |

---

## 🧭 核心入口
* [[📖 26.3 门户概览|Home]]
* [[🌀 26.3 动能物理与动态阻力|Kinetic-Physics-and-Drag]]
* [[🚀 26.3 火箭推进与向量收敛|Rocket-Propulsion-and-Acceleration]]
* [[🧩 26.3 架构设计与 Mixin 解析|Architecture-and-Mixins]]
* [[🏠 中央门户|Home]]
