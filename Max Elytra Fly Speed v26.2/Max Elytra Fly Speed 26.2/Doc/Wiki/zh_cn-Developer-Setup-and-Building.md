🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 开发者环境配置、构建与自动化测试

This guide provides complete instructions for setting up the developer environment, compiling release JARs, running automated JUnit reality tests, and contributing to **Max Elytra Fly Speed**.

> 📌 **代码仓库来源免责声明**：本维基文档反映了**代码仓库中的当前源码状态**，可能包含领先于 CurseForge 和 Modrinth 平台公开发布版本的最新未发布提交或开发中功能。

---

## 💻 Prerequisites & Toolchain Setup

| Tool / Requirement | Minimum Version | Recommended / Configured Path | Purpose |
| :--- | :---: | :--- | :--- |
| **Java Development Kit (JDK)** | Java 25 (`release = 25`) | `E:/JDK25` / `JAVA_HOME` | Modern sovereign compiler |
| **Gradle** | 9.3+ | Bundled `gradlew` wrapper | Build automation system |
| **Fabric Loom** | 1.15+ | `net.fabricmc.fabric-loom` | Mod compilation and remapping |
| **Git** | 2.40+ | System PATH | Version control & Wiki sync |

---

## 📂 Repository Architecture

```
Max Elytra Fly Speed/
├── .wiki/                                     # GitHub Wiki documentation tree
├── Archive Jar of all versions/               # Permanent archive of all built release JARs
│   ├── MC 26.2/                               # Compiled JARs for MC 26.2
│   └── MC 26.3/                               # Compiled JARs for MC 26.3
├── Max Elytra Fly Speed v26.2/                # MC 26.2 Workspace
│   └── Max Elytra Fly Speed 26.2/             # Active Loom subproject root
└── Max Elytra Fly Speed v26.3/                # MC 26.3 Workspace
    └── Max Elytra Fly Speed 26.3/             # Active Loom subproject root
```

---

## 🛠️ Build Commands

### 1. Compile Release JAR
```bash
# Navigate to the target subproject directory
cd "Max Elytra Fly Speed v26.2/Max Elytra Fly Speed 26.2"

# Compile release JAR (with Loom optimizations)
./gradlew build --no-daemon
```

### 2. Run Automated Headless Tests
```bash
./gradlew test --no-daemon
```

---

## 🧭 核心入口
* [[🏠 中央门户|zh_cn-Home]]
* [[📋 版本兼容性矩阵|zh_cn-Version-Compatibility]]
* [[📖 26.2 门户概览|zh_cn-26.2-Home]]
* [[📖 26.3 门户概览|zh_cn-26.3-Home]]
