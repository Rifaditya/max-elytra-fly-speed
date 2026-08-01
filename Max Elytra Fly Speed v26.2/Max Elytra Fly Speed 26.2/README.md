# 🚀 Max Elytra Fly Speed

<p align="center">
    <a href="https://modrinth.com/mod/max-elytra-fly-speed"><img src="https://img.shields.io/badge/Requires-Fabric_API-blue?style=for-the-badge&logo=fabric" alt="Requires Fabric API"></a>
    <img src="https://img.shields.io/badge/Language-Java_25-orange?style=for-the-badge&logo=java" alt="Java 25">
    <img src="https://img.shields.io/badge/License-GPLv3-green?style=for-the-badge" alt="License">
    <img src="https://img.shields.io/badge/Minecraft-26.2+-brightgreen?style=for-the-badge" alt="Minecraft">
</p>

A high-performance Fabric mod for Minecraft 26.2+ that allows server administrators and singleplayer worlds to adjust the maximum flight velocity cap of Elytras using native GameRules.

Part of the **Instant Gratification Collection** — mods designed to enhance and speed up vanilla mechanics.

---

## 🛠 Developer & Build Setup

### Prerequisites
- **JDK 25** (Ensure `JAVA_HOME` or `org.gradle.java.home` points to a valid JDK 25 installation).
- **Gradle 9.3+** (Handled via bundled `gradlew` wrapper, `--no-daemon` recommended on Windows).

### Clone & Build Instructions
```bash
# Clone the repository
git clone https://github.com/Rifaditya/max-elytra-fly-speed.git
cd max-elytra-fly-speed

# Build the release JAR
./gradlew build --no-daemon
```
The compiled output JAR will be generated in `build/libs/` (and archived under `Archive Jar of all versions/` in the parent directory).

### Running in IDE
```bash
# Launch Fabric Client
./gradlew runClient

# Launch Dedicated Server
./gradlew runServer
```

---

## ⚙️ Sovereign GameRules

This mod operates zero external config libraries and registers native Minecraft GameRules under the `max-elytra-fly-speed` namespace:

- `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <Integer>` (Default: `50`): Maximum flight velocity in Blocks/Second.
- `/gamerule max-elytra-fly-speed:elytra_initial_boost_speed <Integer>` (Default: `30`): Speed threshold (Blocks/Second) up to which snappy vanilla rocket boost is applied.
- `/gamerule max-elytra-fly-speed:elytra_high_speed_acceleration <Integer>` (Default: `15`): Gradual acceleration rate (permille) above initial boost threshold.

For detailed player features and in-game controls, see the [Player Documentation](Doc/Players/index.md).

---

## 📜 Credits & License

- **Creator**: **Dasik** (Rifaditya)
- **Collection**: Instant Gratification
- **License**: [GNU GPLv3](LICENSE)
