# Version Compatibility & Lifecycle Matrix

This document outlines the complete compatibility matrix, toolchain dependencies, build environments, and release lifecycles for **Max Elytra Fly Speed** across all targeted Minecraft versions.

> 📌 **Repository Source Disclaimer**: The documentation in this Wiki reflects the **current source code state in the repository**, which may include recent unreleased commits or developmental features ahead of public release builds on CurseForge and Modrinth.

---

## 🏛️ 1 Jar 1 Version Policy

Max Elytra Fly Speed adheres strictly to the **1 Jar 1 Version Policy**:
* A dedicated, independently compiled JAR is engineered for each targeted Minecraft version anchor (e.g. `max-elytra-fly-speed-1.0.19+26.2.jar` and `max-elytra-fly-speed-1.0.19+26.3.jar`).
* Each version is maintained in lockstep with 100% feature parity, performance optimizations, and zero-defect quality.
* No version is deprecated, retired, or abandoned unless explicitly announced.

---

## 📊 Complete Target Matrix

| Minecraft Version | Release Status | Mod Version | Java Target | Fabric Loader | Fabric API | DasikLibrary | Subproject Path | Archive Directory |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :--- | :--- |
| **MC 26.2** | 🟢 Active Standard | `1.0.19+26.2` | Java 25 (`release = 25`) | `>=0.19.1` | `0.150.1+26.2` | `>=1.8.2` | `Max Elytra Fly Speed v26.2` | `Archive Jar of all versions/MC 26.2/` |
| **MC 26.3** | 🟢 Active Standard | `1.0.19+26.3` | Java 25 (`release = 25`) | `>=0.19.3` | `0.156.1+26.3` | `>=1.8.24` | `Max Elytra Fly Speed v26.3` | `Archive Jar of all versions/MC 26.3/` |

---

## 🛠️ Build Toolchain Specifications

### Modern Sovereign Era (MC 26.2 & MC 26.3)
* **Java Development Kit**: JDK 25+ (LTS / Sovereign Era).
* **Build System**: Gradle 9.3+ (`--no-daemon`).
* **Fabric Loom**: Loom `1.15+` (`id 'net.fabricmc.fabric-loom'`).
* **Non-Obfuscated Mojang Runtime**: Loom handles mappings natively in modern versions; custom `mappings` blocks in `build.gradle` are omitted.
* **Bytecode Safety**: Zero-dependency class validation via `ModVersionGuard.checkClass` in `onInitialize` to safeguard against classloader mismatches across Knot/Fabric environments.

---

## 🔗 Dedicated Version Wikis

* [[👉 Open Minecraft 26.2 Wiki|26.2-Home]]
* [[👉 Open Minecraft 26.3 Wiki|26.3-Home]]

---

## 🧭 Navigation

* [[🏠 Wiki Home|Home]]
* [[🛠️ Developer Setup & Testing|Developer-Setup-and-Building]]
