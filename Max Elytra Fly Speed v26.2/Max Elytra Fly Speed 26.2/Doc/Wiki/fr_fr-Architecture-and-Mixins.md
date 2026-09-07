🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Architecture, Mixins Bytecode & Performances — MC 26.2

This page details the internal software architecture, bytecode mixin injection targets, performance guardrails, and automated testing suites for **Max Elytra Fly Speed (MC 26.2)**.

> 📌 **Avertissement relatif à la source du dépôt** : Cette documentation wiki reflète **l'état actuel du code source dans le dépôt**, qui peut inclure les derniers commits non publiés ou des fonctionnalités en cours de développement avant les versions publiques sur CurseForge et Modrinth.

---

## 📋 Fiche Technique Officielle

| Parameter | Technical Details |
| :--- | :--- |
| **Java Package Namespace** | `net.instantgratification.maxelytraflyspeed` |
| **Mixin Configuration** | `max-elytra-fly-speed.mixins.json` |
| **Primary Physics Injector** | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` |
| **Rocket Propulsion Injector**| `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` |
| **Dynamic GameRule Provider** | `net.instantgratification.maxelytraflyspeed.config.MaxSpeedRules` |
| **Library Dependencies** | `dasik-library >= 1.8.2` (MC 26.2) / `>= 1.8.24` (MC 26.3) |

---

## 🧩 Analyse d'Injection Bytecode des Mixins

1. **`LivingEntityMixin`**:
   - Injects into `LivingEntity.updateFallFlyingMovement` and `LivingEntity.travelFallFlying`.
   - Modifies horizontal and vertical drag decay factors inversely scaled with `max_elytra_fly_speed`.
2. **`FireworkRocketEntityMixin`**:
   - Injects into `FireworkRocketEntity.tick`.
   - Replaces vanilla deceleration clamp with two-tier vector difference convergence.

---

## 🛡️ Garanties de Performance & Mémoire
- **Zero Allocations in Hot Paths**: Pre-calculated scalars and reusable primitive math methods.
- **Safety Clamping**: Upper bounds enforce sanity checks up to `Integer.MAX_VALUE`.

---

## 🧭 Navigation Générale
* [[📖 26.2 Vue d'ensemble du Portail|Home]]
* [[🌀 26.2 Physique Cinétique & Traînée|Kinetic-Physics-and-Drag]]
* [[🚀 26.2 Propulsion par Fusées & Vecteurs|Rocket-Propulsion-and-Acceleration]]
* [[⚙️ 26.2 GameRules & Configuration|GameRules-and-Configuration]]
* [[🏠 Portail Principal|Home]]
