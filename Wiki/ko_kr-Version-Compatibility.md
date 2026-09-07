🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 버전 호환성 및 수명 주기 매트릭스

This document outlines the complete compatibility matrix, toolchain dependencies, build environments, and release lifecycles for **Max Elytra Fly Speed** across all targeted Minecraft versions.

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

---

## 🏛️ 1 Jar 1 Version Policy

Max Elytra Fly Speed adheres strictly to the **1 Jar 1 Version Policy**:
* A dedicated, independently compiled JAR is engineered for each targeted Minecraft version anchor (e.g. `max-elytra-fly-speed-1.0.19+26.2.jar` and `max-elytra-fly-speed-1.0.19+26.3.jar`).
* Each version is maintained in lockstep with 100% feature parity, performance optimizations, and zero-defect quality.
* No version is deprecated, retired, or abandoned unless explicitly announced.

---

## 📊 전체 타겟 호환성 매트릭스

| Minecraft Version | Release Status | Mod Version | Java Target | Fabric Loader | Fabric API | DasikLibrary | Subproject Path | Archive Directory |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :--- | :--- |
| **MC 26.2** | 🟢 Active Standard | `1.0.19+26.2` | Java 25 (`release = 25`) | `>=0.19.1` | `0.150.1+26.2` | `>=1.8.2` | `Max Elytra Fly Speed v26.2` | `Archive Jar of all versions/MC 26.2/` |
| **MC 26.3** | 🟢 Active Standard | `1.0.19+26.3` | Java 25 (`release = 25`) | `>=0.19.3` | `0.156.1+26.3` | `>=1.8.24` | `Max Elytra Fly Speed v26.3` | `Archive Jar of all versions/MC 26.3/` |

---

## 🛠️ 빌드 툴체인 사양

### Modern Sovereign Era (MC 26.2 & MC 26.3)
* **Java Development Kit**: JDK 25+ (LTS / Sovereign Era).
* **Build System**: Gradle 9.3+ (`--no-daemon`).
* **Fabric Loom**: Loom `1.15+` (`id 'net.fabricmc.fabric-loom'`).
* **Bytecode Safety**: Zero-dependency class validation via `ModVersionGuard.checkClass` in `onInitialize`.

---

## 🔗 Dedicated Version Wikis
* [[👉 26.2 포털 개요|ko_kr-26.2-Home]]
* [[👉 26.3 포털 개요|ko_kr-26.3-Home]]

---

## 🧭 기본 내비게이션
* [[🏠 중앙 포털|ko_kr-Home]]
* [[🛠️ 개발자 환경 설정 및 테스트|ko_kr-Developer-Setup-and-Building]]
