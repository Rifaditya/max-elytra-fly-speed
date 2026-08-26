# Architecture, Bytecode Mixins & Performance — MC 26.3

This page details the internal software architecture, bytecode mixin injection targets, performance guardrails, and automated testing suites for **Max Elytra Fly Speed (MC 26.3)**.

---

## 📋 Architecture Infobox

| Parameter | Technical Details |
| :--- | :--- |
| **Namespace Package** | `net.instantgratification.maxelytraflyspeed` |
| **Mod Initializer** | `net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric` |
| **Client Initializer** | `net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabricClient` |
| **Mixin Configuration** | `src/main/resources/max-elytra-fly-speed.mixins.json` |
| **Active Mixins** | `LivingEntityMixin`, `FireworkRocketEntityMixin` |
| **Hot Path Memory Profile** | Zero heap allocations ($\mathcal{O}(1)$ time complexity) |
| **Classloader Guard** | `ModVersionGuard.checkClass` in `onInitialize` |

---

## 🧩 Bytecode Mixin Breakdown

### 1. `LivingEntityMixin.java`
* **Target Class**: `net.minecraft.world.entity.LivingEntity`
* **Injection Points**:
  1. `@Redirect` in `updateFallFlyingMovement` -> `ElytraDragHelper.calculateFallFlyingDrag(movement, maxSpeedBps)`
  2. `@Inject` in `travelFallFlying` -> Clamps velocity to `maxSpeedTicks`.

### 2. `FireworkRocketEntityMixin.java`
* **Target Class**: `net.minecraft.world.entity.projectile.FireworkRocketEntity`
* **Injection Point**:
  * `@Redirect` in `tick()` -> `RocketBoostHelper.calculateBoostMovement()`.

---

## 🧪 Automated Reality Testing Suite

| Test Class | Test Case | Assertion Objective |
| :--- | :--- | :--- |
| `ElytraDragHelperTest` | `testVanillaParityDragAtOrBelow50Bps` | Asserts exact $0.99H / 0.98V$ multipliers at $\le 50\text{ BPS}$. |
| `ElytraDragHelperTest` | `testDynamicDragReductionAbove50Bps` | Asserts relaxed drag at $100\text{ BPS}$ ($0.9950H/0.9900V$) and $200\text{ BPS}$ ($0.9975H/0.9950V$). |
| `ElytraDragHelperTest` | `testNullVectorSafety` | Asserts strict null safety returning zero vector without throwing NPE. |
| `RocketBoostHelperTest` | `testInitialBoostSnappyAcceleration` | Asserts snappy $0.5$ convergence below $30\text{ BPS}$ threshold. |
| `RocketBoostHelperTest` | `testHighSpeedProportionalAcceleration` | Asserts proportional vector difference convergence above $30\text{ BPS}$. |
| `RocketBoostHelperTest` | `testMaxSpeedClamping` | Asserts vector clamping when rocket boost exceeds maximum flight ceiling. |
| `RocketBoostHelperTest` | `testNullVectorSafety` | Asserts strict null safety on movement and look angle parameters. |

---

## 🧭 Navigation

* [[🏠 Subproject Home|Home]]
* [[🌀 Kinetic Physics & Drag|Kinetic-Physics-and-Drag]]
* [[🚀 Rocket Propulsion & Acceleration|Rocket-Propulsion-and-Acceleration]]
* [[⚙️ GameRules & Configuration|GameRules-and-Configuration]]
