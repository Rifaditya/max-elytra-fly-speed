🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# GameRules Dinámicas y Configuración — MC 26.3

This page provides the exhaustive configuration reference, GameRule commands, permissions, and client GUI integration for **Max Elytra Fly Speed (MC 26.3)**.

> 📌 **Descargo de responsabilidad de fuente de repositorio**: Esta documentación de wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de los lanzamientos públicos en CurseForge y Modrinth.

---

## 📋 Ficha Técnica Oficial

| Parameter | Technical Details |
| :--- | :--- |
| **Configuration Engine** | Namespaced Dynamic GameRules via `DynamicGameRuleManager` (DasikLibrary) |
| **GameRule Category** | `max-elytra-fly-speed:max-elytra-fly-speed` |
| **Storage Mechanism** | World Save Data (`level.dat` / vanilla GameRules system) |
| **Dedicated Server Dependency** | Zero external config libraries required on servers |
| **Optional Client GUI** | ModMenu (`>=0.19.1`) + Cloth Config (`me.shedaniel.clothconfig2`) |
| **Permission Requirement** | Operator Level 2 (`requires(source -> source.hasPermission(2))`) |

---

## 🎮 Flujo de Administrador y Comandos

### 1. View Current GameRule Values
```mcfunction
/gamerule max-elytra-fly-speed:max_elytra_fly_speed
/gamerule max-elytra-fly-speed:elytra_initial_boost_speed
/gamerule max-elytra-fly-speed:elytra_high_speed_acceleration
```

### 2. Set Custom Flight Speed Limits
```mcfunction
# Set maximum Elytra flight speed ceiling to 150 Blocks/Second
/gamerule max-elytra-fly-speed:max_elytra_fly_speed 150

# Set initial snappy rocket boost speed to 40 Blocks/Second
/gamerule max-elytra-fly-speed:elytra_initial_boost_speed 40

# Set high-speed rocket acceleration rate to 25% per tick
/gamerule max-elytra-fly-speed:elytra_high_speed_acceleration 25
```

---

## 📑 Tabla Completa de Reglas de Juego

| GameRule Identifier | Data Type | Default Value | Valid Range | Localized Name | Functional Description |
| :--- | :---: | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `Integer` | `50` | `1` to `2147483647` | **Max Speed (Blocks/Sec)** | Hard ceiling for Elytra fall-flying velocity in Blocks/Second. Relaxed drag applies above 50 BPS. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `Integer` | `30` | `1` to `2147483647` | **Initial Boost Speed** | Velocity threshold up to which snappy vanilla boost is applied. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `Integer` | `15` | `1` to `1000` | **High Speed Acceleration** | High-speed rocket acceleration percentage applied above initial boost speed. |

---

## 🧭 Navegación General
* [[📖 26.3 Portal General|Home]]
* [[🌀 26.3 Física Cinética y Resistencia|Kinetic-Physics-and-Drag]]
* [[🚀 26.3 Propulsión de Cohetes y Vectores|Rocket-Propulsion-and-Acceleration]]
* [[🧩 26.3 Arquitectura y Mixins|Architecture-and-Mixins]]
* [[🏠 Portal Principal|Home]]
