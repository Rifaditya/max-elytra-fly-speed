🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Arquitectura, Mixins de Bytecode y Rendimiento — MC 26.3

This page details the internal software architecture, bytecode mixin injection targets, performance guardrails, and automated testing suites for **Max Elytra Fly Speed (MC 26.3)**.

> 📌 **Descargo de responsabilidad de fuente de repositorio**: Esta documentación de wiki refleja el **estado actual del código fuente en el repositorio**, que puede incluir confirmaciones recientes no publicadas o características en desarrollo antes de los lanzamientos públicos en CurseForge y Modrinth.

---

## 📋 Ficha Técnica Oficial

| Parameter | Technical Details |
| :--- | :--- |
| **Java Package Namespace** | `net.instantgratification.maxelytraflyspeed` |
| **Mixin Configuration** | `max-elytra-fly-speed.mixins.json` |
| **Primary Physics Injector** | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` |
| **Rocket Propulsion Injector**| `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` |
| **Dynamic GameRule Provider** | `net.instantgratification.maxelytraflyspeed.config.MaxSpeedRules` |
| **Library Dependencies** | `dasik-library >= 1.8.2` (MC 26.2) / `>= 1.8.24` (MC 26.3) |

---

## 🧩 Análisis de Mixins e Inyección de Bytecode

1. **`LivingEntityMixin`**:
   - Injects into `LivingEntity.updateFallFlyingMovement` and `LivingEntity.travelFallFlying`.
   - Modifies horizontal and vertical drag decay factors inversely scaled with `max_elytra_fly_speed`.
2. **`FireworkRocketEntityMixin`**:
   - Injects into `FireworkRocketEntity.tick`.
   - Replaces vanilla deceleration clamp with two-tier vector difference convergence.

---

## 🛡️ Garantías de Rendimiento y Memoria
- **Zero Allocations in Hot Paths**: Pre-calculated scalars and reusable primitive math methods.
- **Safety Clamping**: Upper bounds enforce sanity checks up to `Integer.MAX_VALUE`.

---

## 🧭 Navegación General
* [[📖 26.3 Portal General|Home]]
* [[🌀 26.3 Física Cinética y Resistencia|Kinetic-Physics-and-Drag]]
* [[🚀 26.3 Propulsión de Cohetes y Vectores|Rocket-Propulsion-and-Acceleration]]
* [[⚙️ 26.3 GameRules y Configuración|GameRules-and-Configuration]]
* [[🏠 Portal Principal|Home]]
