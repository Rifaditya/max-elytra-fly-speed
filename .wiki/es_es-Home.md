# Max Elytra Fly Speed Wiki (Español)

Bienvenido a la documentación técnica oficial de **Max Elytra Fly Speed** (Velocidad máxima de vuelo con élitros).

> 📌 **Aviso sobre el estado del repositorio**: Esta documentación refleja el **estado actual del código fuente en el repositorio**, incluyendo características en desarrollo.

---

🌐 **Idiomas**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

---

## 🧭 Selector de Versión

Max Elytra Fly Speed sigue estrictamente la política de **1 Jar 1 Versión**:

| Versión de Minecraft | Estado | Subproyecto | Documentación |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 Activo | `Max Elytra Fly Speed v26.2` | [[👉 Entrar a MC 26.2 Wiki|26.2-Home]] |
| **Minecraft 26.3** | 🟢 Activo | `Max Elytra Fly Speed v26.3` | [[👉 Entrar a MC 26.3 Wiki|26.3-Home]] |

---

## ⚡ Aspectos Destacados del Motor de Vuelo

* **Escalado Dinámico de Resistencia Aerodinámica**: Al aumentar el límite de velocidad por encima de 50 Bloques/Seg, la pérdida por fricción se relaja de forma inversamente proporcional.
* **Propulsión con Cohetes de Dos Niveles**: Despegue ágil tradicional a baja velocidad (< 30 Bloques/Seg) y convergencia vectorial proporcional suave a alta velocidad.
* **GameRules Nativas**: Ajuste en tiempo real con comandos `/gamerule` sin necesidad de dependencias de configuración en servidores.
* **Rendimiento $\mathcal{O}(1)$**: Cero asignaciones de memoria en el bucle de actualización por tick.

---

## 📑 Tabla de Referencia de GameRules

| Regla | Por defecto | Rango | Nombre Localizado | Descripción |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **Velocidad máxima (Bloques/Seg)** | Límite máximo de velocidad de vuelo con élitros en Bloques/Segundo. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **Velocidad de impulso inicial** | Umbral de velocidad para la propulsión ágil tradicional de cohetes. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **Aceleración a alta velocidad** | Porcentaje de aceleración por tick hacia la velocidad objetivo (15 = 15%/tick). |

---

## 📜 Autoría y Licencia

* **Autor**: **Dasik (Rifaditya)**
* **Licencia**: **GNU General Public License v3.0 (GPLv3)**
