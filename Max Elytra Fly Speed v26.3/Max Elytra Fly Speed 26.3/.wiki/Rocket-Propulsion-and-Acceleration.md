# Two-Tier Firework Rocket Propulsion & Vector Convergence — MC 26.3

This page details the mathematical propulsion algorithms, state transitions, and vector difference convergence powering firework rocket boosting in **Max Elytra Fly Speed (MC 26.3)**.

---

## 📋 Subsystem Infobox

| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Two-Tier Firework Rocket Propulsion & Vector Convergence |
| **Java Implementation** | `net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper` |
| **Bytecode Mixin** | `net.instantgratification.maxelytraflyspeed.mixin.FireworkRocketEntityMixin` |
| **Target Method** | `FireworkRocketEntity.tick` |
| **Controlling GameRules** | `elytra_initial_boost_speed` (Default: `30`), `elytra_high_speed_acceleration` (Default: `15`) |
| **Algorithmic Complexity** | $\mathcal{O}(1)$ time complexity, zero memory allocations per tick |
| **Convergence Rate** | $15\%\text{ vector difference per tick}$ ($f_{\text{acc}} = 0.15$) |

---

## 🎮 Step-by-Step Player Workflow

In vanilla Minecraft, firework rockets apply a fixed formula designed solely for low-speed flight:
$$\vec{b}_{\text{vanilla}} = \vec{u}_{\text{look}} \times 0.1 + \left(\vec{u}_{\text{look}} \times 1.5 - \vec{v}\right) \times 0.5$$
When flying above $30\text{ BPS}$ ($1.5\text{ blocks/tick}$), the vanilla formula actively decelerates the player!

**Max Elytra Fly Speed** introduces a **Two-Tier Propulsion Engine**:
1. **Tier 1 — Snappy Launch Boost ($v < 30\text{ BPS}$)**: When launching from a standstill or slow glide, the rocket delivers instant, snappy vanilla acceleration ($50\%$ convergence per tick) to quickly reach cruising velocity.
2. **Tier 2 — High-Speed Vector Convergence ($v \ge 30\text{ BPS}$)**: Above $30\text{ BPS}$, the rocket transitions to proportional vector difference convergence, pulling the flight vector smoothly towards the camera look angle scaled by the configured maximum speed ceiling.
3. **Continuous Re-Orientation**: As the player turns their camera, the high-speed convergence factor continuously aligns their momentum with the new look direction without jarring angular snapping.

---

## 📐 Mathematical Propulsion Models

### 1. Tier 1: Snappy Initial Acceleration
When the current velocity magnitude $v_{\text{current}} = \|\vec{v}_{\text{old}}\|$ is below the initial boost threshold ($v_{\text{initial\_ticks}} = \frac{\text{initialBoostSpeedBps}}{20.0}$):

$$\vec{b}_{\text{initial}} = \vec{u}_{\text{look}} \times 0.1 + \left(\vec{u}_{\text{look}} \times v_{\text{initial\_ticks}} - \vec{v}_{\text{old}}\right) \times 0.5$$

### 2. Tier 2: Proportional High-Speed Vector Convergence
When $v_{\text{current}} \ge v_{\text{initial\_ticks}}$, the boost vector calculates the difference between the target velocity $\vec{v}_{\text{target}} = \vec{u}_{\text{look}} \times v_{\text{max\_ticks}}$ and the current velocity:

$$\vec{b}_{\text{high}} = \vec{u}_{\text{look}} \times 0.1 + \left(\vec{u}_{\text{look}} \times v_{\text{max\_ticks}} - \vec{v}_{\text{old}}\right) \times f_{\text{acc}}$$

where $f_{\text{acc}}$ is the high-speed acceleration factor:
$$f_{\text{acc}} = \max\left(0.05, \frac{\text{highAccPermille}}{100.0}\right)$$

---

## 📊 Visual State Machine Flowchart

```
                 [ PLAYER USES FIREWORK ROCKET ]
                                |
                                v
               Is Current Velocity < 30 BPS?
                             /     \
                     (YES)  /       \  (NO)
                           v         v
             [ TIER 1: SNAPPY BOOST ]  [ TIER 2: HIGH-SPEED CONVERGENCE ]
             • 50% convergence         • 15% proportional convergence
             • Quick launch to 30 BPS  • Smooth pull toward look vector * maxSpeed
                           \         /
                            v       v
                 [ VECTOR SUM & SPEED CLAMP ]
                 • Add boost to deltaMovement
                 • Clamp magnitude <= maxSpeedBps / 20.0
```

---

## 🧭 Navigation

* [[🏠 Subproject Home|Home]]
* [[🌀 Kinetic Physics & Drag|Kinetic-Physics-and-Drag]]
* [[⚙️ GameRules & Configuration|GameRules-and-Configuration]]
* [[🧩 Architecture & Mixins|Architecture-and-Mixins]]
