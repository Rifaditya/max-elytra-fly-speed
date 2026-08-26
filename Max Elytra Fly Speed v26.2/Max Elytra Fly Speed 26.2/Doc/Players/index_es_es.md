# 🚀 Velocidad Máxima de los Élitros (Max Elytra Fly Speed) - Guía del Jugador

¡Bienvenido a **Max Elytra Fly Speed**! Este mod elimina por completo los límites de velocidad de los élitros en Minecraft vanilla, ofreciendo un límite máximo configurable, una aceleración suave y proporcional con cohetes y física de planeo en picado.

---

## ⚡ Características Principales y Dinámica de Vuelo

1. **Límite de Velocidad Personalizable**:
   - El límite vanilla de Minecraft es muy restrictivo. Este mod te permite fijar la velocidad máxima en cualquier valor (por defecto `50` bloques/segundo, pudiendo elevarse a `100`, `200` o incluso `3000` bloques/seg).
2. **Escala de Velocidad en Dos Fases (Dual-Phase Scaling)**:
   - **Fase 1 (Impulso Inicial)**: Por debajo del umbral de velocidad (por defecto `30` bloques/seg), disfrutas del impulso inicial rápido y ágil de los cohetes vanilla.
   - **Fase 2 (Planeo a Alta Velocidad)**: Por encima del umbral, los cohetes aceleran proporcionalmente tirando de la velocidad hacia tu límite configurado, alcanzando 100+ bloques/seg en solo 2–3 cohetes.
3. **Reducción Dinámica de la Fricción en Picados**:
   - A velocidades altas, la fricción del aire se reduce automáticamente, permitiendo acumular y sostener velocidades extremas al realizar maniobras en picado.

---

## ⚙️ Configuración mediante GameRules Nativos

El mod utiliza el sistema de reglas de juego nativo de Minecraft, sin necesidad de editar archivos externos:

| Regla de Juego (GameRule) | Por Defecto | Descripción |
| :--- | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | Velocidad máxima absoluta del vuelo con élitros (bloques/segundo). |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | Umbral de velocidad (bloques/seg) para el impulso inicial vanilla. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | Porcentaje de aceleración por tick por encima del umbral inicial (15% por tick). |

> [!TIP]
> Puedes ajustar estos parámetros desde la pantalla de **«Editar Reglas del Juego»** o mediante el comando `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <valor>`.

---

## ☕ Soporte y Créditos

- **Autor**: Dasik (Rifaditya)
- **Licencia**: GNU GPLv3
- **Colección**: Instant Gratification Collection
