🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Configuração de Desenvolvedor, Compilação e Testes

This guide provides complete instructions for setting up the developer environment, compiling release JARs, running automated JUnit reality tests, and contributing to **Max Elytra Fly Speed**.

> 📌 **Aviso Legal da Fonte do Repositório**: Esta documentação wiki reflete o **estado atual do código-fonte no repositório**, podendo incluir os commits mais recentes não lançados ou recursos em desenvolvimento antes dos lançamentos públicos no CurseForge e Modrinth.

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

## 🧭 Navegação Geral
* [[🏠 Portal Principal|pt_br-Home]]
* [[📋 Matriz de Compatibilidade|pt_br-Version-Compatibility]]
* [[📖 26.2 Visão Geral do Portal|pt_br-26.2-Home]]
* [[📖 26.3 Visão Geral do Portal|pt_br-26.3-Home]]
