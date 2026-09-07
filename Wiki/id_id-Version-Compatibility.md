🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Matriks Kompatibilitas Versi & Siklus Hidup

This document outlines the complete compatibility matrix, toolchain dependencies, build environments, and release lifecycles for **Max Elytra Fly Speed** across all targeted Minecraft versions.

> 📌 **Penafian Sumber Kode Repositori**: Dokumentasi di Wiki ini mencerminkan **kondisi kode sumber terkini dalam repositori**, yang mungkin mencakup commit terbaru yang belum dirilis atau fitur eksperimental sebelum rilis publik di CurseForge dan Modrinth.

---

## 🏛️ 1 Jar 1 Version Policy

Max Elytra Fly Speed adheres strictly to the **1 Jar 1 Version Policy**:
* A dedicated, independently compiled JAR is engineered for each targeted Minecraft version anchor (e.g. `max-elytra-fly-speed-1.0.19+26.2.jar` and `max-elytra-fly-speed-1.0.19+26.3.jar`).
* Each version is maintained in lockstep with 100% feature parity, performance optimizations, and zero-defect quality.
* No version is deprecated, retired, or abandoned unless explicitly announced.

---

## 📊 Matriks Target Versi Menyeluruh

| Minecraft Version | Release Status | Mod Version | Java Target | Fabric Loader | Fabric API | DasikLibrary | Subproject Path | Archive Directory |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :--- | :--- |
| **MC 26.2** | 🟢 Active Standard | `1.0.19+26.2` | Java 25 (`release = 25`) | `>=0.19.1` | `0.150.1+26.2` | `>=1.8.2` | `Max Elytra Fly Speed v26.2` | `Archive Jar of all versions/MC 26.2/` |
| **MC 26.3** | 🟢 Active Standard | `1.0.19+26.3` | Java 25 (`release = 25`) | `>=0.19.3` | `0.156.1+26.3` | `>=1.8.24` | `Max Elytra Fly Speed v26.3` | `Archive Jar of all versions/MC 26.3/` |

---

## 🛠️ Spesifikasi Toolchain Kompilasi

### Modern Sovereign Era (MC 26.2 & MC 26.3)
* **Java Development Kit**: JDK 25+ (LTS / Sovereign Era).
* **Build System**: Gradle 9.3+ (`--no-daemon`).
* **Fabric Loom**: Loom `1.15+` (`id 'net.fabricmc.fabric-loom'`).
* **Bytecode Safety**: Zero-dependency class validation via `ModVersionGuard.checkClass` in `onInitialize`.

---

## 🔗 Dedicated Version Wikis
* [[👉 26.2 Ringkasan Portal|id_id-26.2-Home]]
* [[👉 26.3 Ringkasan Portal|id_id-26.3-Home]]

---

## 🧭 Navigasi Utama
* [[🏠 Portal Utama|id_id-Home]]
* [[🛠️ Pengaturan Pengembang & Pengujian|id_id-Developer-Setup-and-Building]]
