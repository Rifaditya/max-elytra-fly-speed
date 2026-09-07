🌐 **Languages**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

# Kinetische Physik & Dynamische Widerstandsskalierung — MC 26.2

This page details the aerodynamic physics model, dynamic drag floor scaling equations, and bytecode integration powering Elytra fall-flying mechanics in **Max Elytra Fly Speed (MC 26.2)**.

> 📌 **Haftungsausschluss zur Repository-Quelle**: Diese Wiki-Dokumentation spiegelt den **aktuellen Quellcode-Zustand im Repository** wider, der möglicherweise die neuesten unveröffentlichten Commits oder in Entwicklung befindliche Funktionen vor den öffentlichen Versionen auf CurseForge und Modrinth enthält.

---

## 📋 Offizielle technische Informationen

| Parameter | Technical Details |
| :--- | :--- |
| **Subsystem Name** | Aerodynamic Drag Floor Scaling & Velocity Limiting |
| **Java Implementation** | `net.instantgratification.maxelytraflyspeed.util.ElytraDragHelper` |
| **Bytecode Mixin** | `net.instantgratification.maxelytraflyspeed.mixin.LivingEntityMixin` |
| **Target Methods** | `LivingEntity.updateFallFlyingMovement`, `LivingEntity.travelFallFlying` |
| **Controlling GameRule** | `max-elytra-fly-speed:max_elytra_fly_speed` (Default: `50`) |
| **Algorithmic Complexity** | $\mathcal{O}(1)$ time complexity, zero memory allocations per tick |
| **Parity Standard** | Exact Vanilla $0.99H / 0.98V$ drag at $\le 50\text{ Blocks/Sec}$ |

---

## 🎮 Schritt-für-Schritt-Flugablauf für Spieler

In vanilla Minecraft, players attempting high-speed Elytra flight experience an artificial "velocity wall": vanilla hardcoded drag factors bleed off speed rapidly.

With **Max Elytra Fly Speed**:
1. **Takeoff & Fall-Flying**: The player deploys Elytra wings by pressing `Jump` mid-air.
2. **Diving for Acceleration**: Pitching the camera downward converts gravitational potential energy into kinetic velocity.
3. **Dynamic Drag Relaxation**: As server administrators increase `max_elytra_fly_speed` above $50\text{ BPS}$, the aerodynamic drag loss smoothly decreases in inverse proportion.
4. **Sustained High-Speed Glide**: Pulling up into a horizontal glide preserves momentum across thousands of blocks without sudden velocity drops.
5. **Hard Velocity Clamping**: If external explosions or extreme dives accelerate the player beyond the ceiling, the velocity vector is smoothly scaled down without altering flight direction.

---

## 📐 Mathematische Aerodynamik-Modelle

### 1. Speed Ratio Scaling
$$\text{speedRatio} = \max\left(1.0, \frac{\text{maxSpeedBps}}{50.0}\right)$$

### 2. Inverse Drag Floor Equations
$$\text{dragLossH} = \frac{0.01}{\text{speedRatio}}, \quad \text{dragLossV} = \frac{0.02}{\text{speedRatio}}$$

### 3. Velocity Damping Transformation
$$\vec{v}_{t+1} = \vec{v}_t \odot \begin{pmatrix} 1.0 - \text{dragLossH} \\ 1.0 - \text{dragLossV} \\ 1.0 - \text{dragLossH} \end{pmatrix}$$

### 4. Hard Velocity Ceiling Clamping
If magnitude exceeds tick speed:
$$\vec{v}_{\text{clamped}} = \vec{v} \times \left(\frac{v_{\text{max\_ticks}}}{\|\vec{v}\|}\right)$$

---

## 🧭 Allgemeine Navigation
* [[📖 26.2 Portalübersicht|de_de-26.2-Home]]
* [[🚀 26.2 Raketenantrieb & Vektoren|de_de-26.2-Rocket-Propulsion-and-Acceleration]]
* [[⚙️ 26.2 GameRules & Konfiguration|de_de-26.2-GameRules-and-Configuration]]
* [[🧩 26.2 Architektur & Mixins|de_de-26.2-Architecture-and-Mixins]]
* [[🏠 Hauptportal|de_de-Home]]
