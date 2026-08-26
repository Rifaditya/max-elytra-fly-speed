# 🚀 鞘翅最大飛行速度 (Max Elytra Fly Speed) - 玩家使用指南

歡迎使用 **Max Elytra Fly Speed**！本模組徹底突破了原版 Minecraft 鞘翅飛行速度限制，提供可深度自訂的最大速度上限、平滑的煙火火箭比例加速曲線以及高空俯衝滑翔動力學。

---

## ⚡ 核心功能與飛行力學

1. **自訂飛行限速**：
   - 原版 Minecraft 鞘翅飛行速度受限。本模組允許將最大速度設定為任何數值（預設值為 `50` 方塊/秒，可設定為 `100`、`200` 甚至 `3000` 方塊/秒）。
2. **雙階段速度縮放 (Dual-Phase Scaling)**：
   - **第一階段（初始助推）**：當飛行速度低於初始閾值（預設 `30` 方塊/秒）時，享受原版快速俐落的起飛加速。
   - **第二階段（高速滑翔）**：當飛行速度達到初始閾值以上時，煙火火箭將根據加速度比例平滑推升速度至目標上限，2–3 個火箭即可流暢加速至 100+ 方塊/秒。
3. **動態俯衝空氣阻力衰減**：
   - 在高限速配置下，空氣阻力係數會動態減弱，使玩家能夠透過高空俯衝與拉升持續維持高速巡航。

---

## ⚙️ 原生遊戲規則 (GameRules) 配置

本模組採用 Minecraft 原生遊戲規則系統，無需修改繁瑣的設定檔即可直接在遊戲內生效：

| 遊戲規則 (GameRule) | 預設值 | 說明 |
| :--- | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | 鞘翅飛行的絕對最大速度（方塊/秒）。 |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | 應用原版快速煙火火箭助推的速度閾值（方塊/秒）。 |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | 超過初始閾值後的高速加速百分比率（每刻 15%）。 |

> [!TIP]
> 您可以透過遊戲內的 **「編輯遊戲規則 (Edit Game Rules)」** 選單或直接輸入 `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <數值>` 即時調整參數。

---

## ☕ 支援與鳴謝

- **作者**：Dasik (Rifaditya)
- **協議**：GNU GPLv3
- **所屬系列**：即時滿足系列 (Instant Gratification Collection)
