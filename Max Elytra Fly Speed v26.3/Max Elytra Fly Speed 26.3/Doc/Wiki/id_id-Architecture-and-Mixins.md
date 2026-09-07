🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Arsitektur, Mixin Bytecode & Kinerja — MC 26.3

This page details the internal software architecture, bytecode mixin injection targets, performance guardrails, and automated testing suites for **Max Elytra Fly Speed (MC 26.3)**.

> 📌 **Penafian Sumber Kode Repositori**: Dokumentasi di Wiki ini mencerminkan **kondisi kode sumber terkini dalam repositori**, yang mungkin mencakup commit terbaru yang belum dirilis atau fitur eksperimental sebelum rilis publik di CurseForge dan Modrinth.

---

## 📋 Informasi Teknis Resmi

| Parameter | Technical Details |
| :--- | :--- |
| **Java Package Namespace** | `net.instantgratification.maxelytraflyspeed` |
| **Mixin Configuration** | `max-elytra-fly-speed.mixins.json` |
| **Primary Physics Injector** | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` |
| **Rocket Propulsion Injector**| `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` |
| **Dynamic GameRule Provider** | `net.instantgratification.maxelytraflyspeed.config.MaxSpeedRules` |
| **Library Dependencies** | `dasik-library >= 1.8.2` (MC 26.2) / `>= 1.8.24` (MC 26.3) |

---

## 🧩 Analisis Injeksi Bytecode Mixin

1. **`LivingEntityMixin`**:
   - Injects into `LivingEntity.updateFallFlyingMovement` and `LivingEntity.travelFallFlying`.
   - Modifies horizontal and vertical drag decay factors inversely scaled with `max_elytra_fly_speed`.
2. **`FireworkRocketEntityMixin`**:
   - Injects into `FireworkRocketEntity.tick`.
   - Replaces vanilla deceleration clamp with two-tier vector difference convergence.

---

## 🛡️ Jaminan Kinerja & Efisiensi Memori
- **Zero Allocations in Hot Paths**: Pre-calculated scalars and reusable primitive math methods.
- **Safety Clamping**: Upper bounds enforce sanity checks up to `Integer.MAX_VALUE`.

---

## 🧭 Navigasi Utama
* [[📖 26.3 Ringkasan Portal|Home]]
* [[🌀 26.3 Fisika Kinetik & Hambatan Udara|Kinetic-Physics-and-Drag]]
* [[🚀 26.3 Propulsi Roket & Konvergensi Vektor|Rocket-Propulsion-and-Acceleration]]
* [[⚙️ 26.3 GameRules & Konfigurasi|GameRules-and-Configuration]]
* [[🏠 Portal Utama|Home]]
