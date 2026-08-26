# Max Elytra Fly Speed Wiki (简体中文)

欢迎查阅 **Max Elytra Fly Speed (鞘翅最大飞行速度)** 的官方技术文档与玩家指南。

> 📌 **版本状态提示**: 本 Wiki 中的文档反映了**仓库中的最新源代码状态**，可能包含领先于 CurseForge 和 Modrinth 上公开发布版本的开发中特性。

---

🌐 **语言导航**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]]

---

## 🧭 版本选择

Max Elytra Fly Speed 严格遵循 **1 Jar 1 Version（单一 Jar 对应单一版本）** 政策进行跨版本维护：

| 游戏版本 | 状态 | 目标子项目 | 专用文档入口 |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 活跃维护 | `Max Elytra Fly Speed v26.2` | [[👉 进入 MC 26.2 Wiki|26.2-Home]] |
| **Minecraft 26.3** | 🟢 活跃维护 | `Max Elytra Fly Speed v26.3` | [[👉 进入 MC 26.3 Wiki|26.3-Home]] |

---

## ⚡ 核心机制与特性

* **动态空气阻力下限缩放**: 当管理员将最大速度阈值调高时，滑翔阻力损失率会自动反比例降低，避免高速俯冲和长途滑翔时产生骤降的减速感。
* **双阶烟花火箭推进机制**: 低速（< 30 方块/秒）时提供原汁原味的即时推进；高速（$\ge 30$ 方块/秒）时平滑按比例向准星方向收敛加速。
* **原生动态 GameRules 游戏规则**: 借助 `DynamicGameRuleManager`，无需在服务器上安装外部配置文件库即可直接使用原版 `/gamerule` 命令进行实时调控。
* **零分配高性能热路径**: 实体滑翔更新与火箭推进计算具备严格的 $\mathcal{O}(1)$ 时间复杂度，热循环内零对象分配，保障服务器 TPS 平稳。

---

## 📑 游戏规则参考表

| 规则标识符 | 默认值 | 范围 | 本地化名称 | 功能说明 |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **最大速度 (方块/秒)** | 鞘翅滑翔飞行的最大速度上限（方块/秒）。 |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **初始推进速度** | 烟花火箭应用即时原版加速（50% 收敛率）的速度阈值。 |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **高速加速度** | 高速飞行时每刻（tick）向准星目标速度收敛的加速度百分比（15 表示 15%/tick）。 |

---

## 📜 版权与开源许可

* **作者**: **Dasik (Rifaditya)**
* **开源协议**: **GNU General Public License v3.0 (GPLv3)**
* **源码仓库**: [GitHub Source Code](https://github.com/Rifaditya/max-elytra-fly-speed)
