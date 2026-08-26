# Max Elytra Fly Speed Wiki (繁體中文)

歡迎查閱 **Max Elytra Fly Speed (鞘翅最大飛行速度)** 的官方技術文檔與玩家指南。

> 📌 **版本狀態提示**: 本 Wiki 中的文檔反映了**倉庫中的最新源代碼狀態**，可能包含領先於 CurseForge 和 Modrinth 上公開發布版本的開發中特性。

---

🌐 **語言導航**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

---

## 🧭 版本選擇

Max Elytra Fly Speed 嚴格遵循 **1 Jar 1 Version（單一 Jar 對應單一版本）** 政策進行跨版本維護：

| 遊戲版本 | 狀態 | 目標子項目 | 專用文檔入口 |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 活躍維護 | `Max Elytra Fly Speed v26.2` | [[👉 進入 MC 26.2 Wiki|26.2-Home]] |
| **Minecraft 26.3** | 🟢 活躍維護 | `Max Elytra Fly Speed v26.3` | [[👉 進入 MC 26.3 Wiki|26.3-Home]] |

---

## ⚡ 核心機制與特性

* **動態空氣阻力下限縮放**: 當管理員將最大速度閾值調高時，滑翔阻力損失率會自動反比例降低，避免高速俯衝和長途滑翔時產生驟降的減速感。
* **雙階煙花火箭推進機制**: 低速（< 30 方塊/秒）時提供原汁原味的即時推進；高速（$\ge 30$ 方塊/秒）時平滑按比例向準星方向收斂加速。
* **原生動態 GameRules 遊戲規則**: 藉助 `DynamicGameRuleManager`，無需在服務器上安裝外部配置文件庫即可直接使用原版 `/gamerule` 命令進行實時調控。
* **零分配高性能熱路徑**: 實體滑翔更新與火箭推進計算具備嚴格的 $\mathcal{O}(1)$ 時間複雜度，熱循環內零對象分配，保障服務器 TPS 平穩。

---

## 📑 遊戲規則參考表

| 規則標識符 | 默認值 | 範圍 | 本地化名稱 | 功能說明 |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **最大速度 (方塊/秒)** | 鞘翅滑翔飛行的最大速度上限（方塊/秒）。 |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **初始推進速度** | 煙花火箭應用即時原版加速（50% 收斂率）的速度閾值。 |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **高速加速度** | 高速飛行時每刻（tick）向準星目標速度收斂的加速度百分比（15 表示 15%/tick）。 |

---

## 📜 版權與開源許可

* **作者**: **Dasik (Rifaditya)**
* **開源協議**: **GNU General Public License v3.0 (GPLv3)**
* **源碼倉庫**: [GitHub Source Code](https://github.com/Rifaditya/max-elytra-fly-speed)
