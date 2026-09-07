🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# 아키텍처, 바이트코드 믹스인 및 성능 — MC 26.3

This page details the internal software architecture, bytecode mixin injection targets, performance guardrails, and automated testing suites for **Max Elytra Fly Speed (MC 26.3)**.

> 📌 **저장소 소스 고지사항**: 본 위키 문서는 **저장소 내의 현재 소스 코드 상태**를 반영하며, CurseForge 및 Modrinth의 공개 릴리스 이전의 최신 커밋 또는 개발 중인 기능이 포함될 수 있습니다.

---

## 📋 공식 기술 정보

| Parameter | Technical Details |
| :--- | :--- |
| **Java Package Namespace** | `net.instantgratification.maxelytraflyspeed` |
| **Mixin Configuration** | `max-elytra-fly-speed.mixins.json` |
| **Primary Physics Injector** | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` |
| **Rocket Propulsion Injector**| `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` |
| **Dynamic GameRule Provider** | `net.instantgratification.maxelytraflyspeed.config.MaxSpeedRules` |
| **Library Dependencies** | `dasik-library >= 1.8.2` (MC 26.2) / `>= 1.8.24` (MC 26.3) |

---

## 🧩 바이트코드 믹스인 주입 분석

1. **`LivingEntityMixin`**:
   - Injects into `LivingEntity.updateFallFlyingMovement` and `LivingEntity.travelFallFlying`.
   - Modifies horizontal and vertical drag decay factors inversely scaled with `max_elytra_fly_speed`.
2. **`FireworkRocketEntityMixin`**:
   - Injects into `FireworkRocketEntity.tick`.
   - Replaces vanilla deceleration clamp with two-tier vector difference convergence.

---

## 🛡️ 성능 및 메모리 안전성 보장
- **Zero Allocations in Hot Paths**: Pre-calculated scalars and reusable primitive math methods.
- **Safety Clamping**: Upper bounds enforce sanity checks up to `Integer.MAX_VALUE`.

---

## 🧭 기본 내비게이션
* [[📖 26.3 포털 개요|Home]]
* [[🌀 26.3 운동 물리학 및 공기 저항|Kinetic-Physics-and-Drag]]
* [[🚀 26.3 로켓 추진 및 벡터 수렴|Rocket-Propulsion-and-Acceleration]]
* [[⚙️ 26.3 게임 규칙 및 구성|GameRules-and-Configuration]]
* [[🏠 중앙 포털|Home]]
