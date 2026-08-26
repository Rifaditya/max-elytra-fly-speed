# 🚀 鞘翅最大飞行速度 (Max Elytra Fly Speed) - 玩家使用指南

欢迎使用 **Max Elytra Fly Speed**！本模组彻底突破了原版 Minecraft 鞘翅飞行速度限制，提供可深度自定义的最大速度上限、平滑的烟花火箭比例加速曲线以及高空俯冲滑翔动力学。

---

## ⚡ 核心功能与飞行力学

1. **自定义飞行限速**：
   - 原版 Minecraft 鞘翅飞行速度受限。本模组允许将最大速度设置为任何数值（默认值为 `50` 方块/秒，可设置为 `100`、`200` 甚至 `3000` 方块/秒）。
2. **双阶段速度缩放 (Dual-Phase Scaling)**：
   - **第一阶段（初始助推）**：当飞行速度低于初始阈值（默认 `30` 方块/秒）时，享受原版快速干脆的起飞加速。
   - **第二阶段（高速滑翔）**：当飞行速度达到初始阈值以上时，烟花火箭将根据加速度比例平滑推升速度至目标上限，2–3 个火箭即可流畅加速至 100+ 方块/秒。
3. **动态俯冲空气阻力衰减**：
   - 在高限速配置下，空气阻力系数会动态减弱，使玩家能够通过高空俯冲与拉升持续维持高速巡航。

---

## ⚙️ 原生游戏规则 (GameRules) 配置

本模组采用 Minecraft 原生游戏规则系统，无需修改繁琐的配置文件即可直接在游戏内生效：

| 游戏规则 (GameRule) | 默认值 | 说明 |
| :--- | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | 鞘翅飞行的绝对最大速度（方块/秒）。 |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | 应用原版快速烟花火箭助推的速度阈值（方块/秒）。 |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | 超过初始阈值后的高速加速百分比率（每刻 15%）。 |

> [!TIP]
> 您可以通过游戏内的 **“编辑游戏规则 (Edit Game Rules)”** 菜单或直接输入 `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <数值>` 实时调整参数。

---

## ☕ 支持与鸣谢

- **作者**：Dasik (Rifaditya)
- **协议**：GNU GPLv3
- **所属系列**：即时满足系列 (Instant Gratification Collection)
