# Max Elytra Fly Speed Wiki (日本語)

**Max Elytra Fly Speed (エリトラ飛行の最高速度)** の公式ドキュメントへようこそ。

> 📌 **リポジトリ状態の注記**: このWikiは**リポジトリ内の最新ソースコード状態**を反映しています。

---

🌐 **言語ナビゲーション**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

---

## 🧭 バージョン選択

Max Elytra Fly Speed は **1 Jar 1 Version（1バージョン1JAR）** ポリシーに従っています：

| Minecraftバージョン | ステータス | サブプロジェクト | ドキュメント |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 開発中・提供中 | `Max Elytra Fly Speed v26.2` | [[👉 MC 26.2 Wiki を開く|26.2-Home]] |
| **Minecraft 26.3** | 🟢 開発中・提供中 | `Max Elytra Fly Speed v26.3` | [[👉 MC 26.3 Wiki を開く|26.3-Home]] |

---

## ⚡ 飛行エンジンの主な特徴

* **動的な空気抵抗下限スケーリング**: 最大速度制限を50ブロック/秒以上に設定すると、空気抵抗による減速が自動的に緩和され、スムーズな超高速滑空が可能になります。
* **2段階ロケット推進システム**: 低速（30ブロック/秒未満）ではバニラ通りの瞬発的な加速を行い、高速域では視線方向への滑らかな比例収束加速を行います。
* **ネイティブ GameRules**: サーバーに余計な設定ライブラリを導入することなく、バニラの `/gamerule` コマンドで設定可能です。
* **$\mathcal{O}(1)$ 高パフォーマンス設計**: チック処理ループ内での新規オブジェクト生成を完全に排除。

---

## 📑 ゲームルール（GameRules）一覧

| ルール識別子 | デフォルト | 有効範囲 | 表示名 | 説明 |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **最高速度 (ブロック/秒)** | エリトラ飛行の最高速度上限（ブロック/秒）。 |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **初期加速速度** | バニラ同等の即時ロケット加速が適用される速度閾値。 |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **高速時加速度** | 初期速度以上での1チックあたりの加速パーセンテージ（15 = 15%/tick）。 |

---

## 📜 ライセンス・著作権

* **作者**: **Dasik (Rifaditya)**
* **ライセンス**: **GNU General Public License v3.0 (GPLv3)**
