# Developer Setup, Building & Automated Testing

This guide provides complete instructions for setting up the developer environment, compiling release JARs, running automated JUnit reality tests, and contributing to **Max Elytra Fly Speed**.

---

## 💻 Prerequisites & Toolchain Setup

To build Max Elytra Fly Speed from source, ensure your development machine meets the following environment requirements:

| Tool / Requirement | Minimum Version | Recommended / Configured Path | Purpose |
| :--- | :---: | :--- | :--- |
| **Java Development Kit (JDK)** | Java 25 (`release = 25`) | `E:/JDK25` / `JAVA_HOME` | Modern sovereign compiler |
| **Gradle** | 9.3+ | Bundled `gradlew` wrapper | Build automation system |
| **Fabric Loom** | 1.15+ | `net.fabricmc.fabric-loom` | Mod compilation and remapping |
| **Git** | 2.40+ | System PATH | Version control & Wiki sync |

---

## 📂 Repository Architecture

The repository is organized into dedicated subproject directories under the **1 Jar 1 Version Policy**:

```
Max Elytra Fly Speed/
├── .wiki/                                     # GitHub Wiki documentation tree
├── Archive Jar of all versions/               # Permanent archive of all built release JARs
│   ├── MC 26.2/                               # Compiled JARs for MC 26.2
│   └── MC 26.3/                               # Compiled JARs for MC 26.3
├── Max Elytra Fly Speed v26.2/                # MC 26.2 Workspace
│   └── Max Elytra Fly Speed 26.2/             # Active Loom subproject root
│       ├── build.gradle                       # Subproject build configuration
│       ├── gradle.properties                  # Dependency versions (1.0.19+26.2)
│       └── src/                               # Java source, assets, and JUnit tests
└── Max Elytra Fly Speed v26.3/                # MC 26.3 Workspace
    └── Max Elytra Fly Speed 26.3/             # Active Loom subproject root
        ├── build.gradle                       # Subproject build configuration
        ├── gradle.properties                  # Dependency versions (1.0.19+26.3)
        └── src/                               # Java source, assets, and JUnit tests
```

---

## 🛠️ Build Commands

Execute Gradle commands from within the respective subproject folder:

### 1. Compile Release JAR
```bash
# Navigate to the target subproject directory
cd "Max Elytra Fly Speed v26.2/Max Elytra Fly Speed 26.2"

# Compile release JAR (with Loom optimizations)
./gradlew build --no-daemon
```
The compiled artifact will be located in `build/libs/max-elytra-fly-speed-1.0.19+26.2.jar`.

### 2. Run Automated Headless Tests
```bash
./gradlew test --no-daemon
```

---

## 🧪 Automated Reality Test Suites

Max Elytra Fly Speed implements automated headless JUnit reality test suites in `src/test/java/` verifying all mathematical algorithms, vector bounds, and null safety without launching heavy Minecraft client instances:

### 1. `ElytraDragHelperTest`
Located at `src/test/java/net/instantgratification/maxelytraflyspeed/test/ElytraDragHelperTest.java`:
* **Vanilla Drag Parity**: Asserts exact vanilla $0.99H / 0.98V$ drag multipliers when flight speed is at or below $50\text{ BPS}$.
* **Dynamic Drag Reduction**: Asserts relaxed drag floor scaling at $100\text{ BPS}$ ($\text{loss}_H = 0.005, \text{loss}_V = 0.010$) and $200\text{ BPS}$ ($\text{loss}_H = 0.0025, \text{loss}_V = 0.0050$).
* **Null Safety Guard**: Asserts that passing `null` velocity vectors returns `Vec3.ZERO` without throwing `NullPointerException`.

### 2. `RocketBoostHelperTest`
Located at `src/test/java/net/instantgratification/maxelytraflyspeed/test/RocketBoostHelperTest.java`:
* **Initial Snappy Boost**: Asserts vanilla $0.5$ convergence boost when flying below the $30\text{ BPS}$ initial boost threshold.
* **Proportional High-Speed Acceleration**: Asserts vector difference convergence towards target maximum speed when flying above $30\text{ BPS}$.
* **Velocity Ceiling Clamping**: Asserts strict mathematical clamping when rocket boost calculations exceed the configured maximum flight speed ceiling.
* **Null Vector Safety**: Asserts zero vector fallback when given `null` movement or `null` look angle vectors.

---

## 🚀 Launcher Deployment Workflow

To test builds directly in Minecraft:
1. Build the subproject JAR via `./gradlew build --no-daemon`.
2. Copy the resulting JAR to your active launcher profile `mods/` folder:
   * **MC 26.2 Profile**: `C:\Users\fmrif\AppData\Roaming\ModrinthApp\profiles\Fabric 26.2 (1)\mods`
   * **MC 26.3 Profile**: `C:\Users\fmrif\AppData\Roaming\ModrinthApp\profiles\Fabric 26.3ish\mods`
3. Purge any older version JARs to avoid Fabric Loader duplicate mod conflicts.

---

## 🧭 Navigation

* [[🏠 Wiki Home|Home]]
* [[📊 Version Compatibility Matrix|Version-Compatibility]]
* [[👉 Open MC 26.2 Wiki|26.2-Home]]
* [[👉 Open MC 26.3 Wiki|26.3-Home]]
