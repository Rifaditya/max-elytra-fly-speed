# 🚀 Maximale Elytren-Fluggeschwindigkeit (Max Elytra Fly Speed) - Spielerhandbuch

Willkommen bei **Max Elytra Fly Speed**! Diese Mod hebt die Geschwindigkeitsbegrenzungen des Vanilla-Elytrenflugs in Minecraft vollständig auf und bietet eine konfigurierbare Höchstgeschwindigkeit, eine geschmeidige proportionale Raketenbeschleunigung sowie Sturzflug-Gleitdynamik.

---

## ⚡ Hauptmerkmale & Flugmechanik

1. **Anpassbare Höchstgeschwindigkeit**:
   - Die Standardbegrenzung in Vanilla-Minecraft ist stark reglementiert. Diese Mod ermöglicht es, die maximale Fluggeschwindigkeit auf jeden beliebigen Wert festzulegen (Standard: `50` Blöcke/Sek., erweiterbar auf `100`, `200` oder `3000` Blöcke/Sek.).
2. **Zweistufige Geschwindigkeitsanpassung (Dual-Phase Scaling)**:
   - **Phase 1 (Anfänglicher Boost)**: Unterhalb des Schwellenwerts (Standard: `30` Blöcke/Sek.) greift der knackige Vanilla-Raketenstart.
   - **Phase 2 (Hochgeschwindigkeitsgleiten)**: Oberhalb der Schwelle beschleunigen Raketen proportional in Richtung des gesetzten Limits und ziehen den Spieler in nur 2–3 Raketen zügig auf 100+ Blöcke/Sek.
3. **Dynamische Luftwiderstandsreduktion bei Sturzflügen**:
   - Bei hohen Geschwindigkeitslimits verringert sich der Luftwiderstand dynamisch, sodass extreme Geschwindigkeiten durch Sturzflüge und Hochziehen aufgebaut und gehalten werden können.

---

## ⚙️ Konfiguration über native GameRules

Die Mod verwendet das native Minecraft-Gamerule-System, wodurch Änderungen sofort im Spiel ohne Dateineustart wirksam werden:

| Spielregel (GameRule) | Standard | Beschreibung |
| :--- | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | Absolute Höchstgeschwindigkeit des Elytrenflugs (Blöcke/Sekunde). |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | Geschwindigkeitsschwelle (Blöcke/Sek.) für den schnellen Vanilla-Boost. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | Prozentuale Beschleunigungsrate pro Tick oberhalb der Schwelle (15% pro Tick). |

> [!TIP]
> Die Parameter können im Menü **„Spielregeln bearbeiten“** oder per Befehl `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <Wert>` angepasst werden.

---

## ☕ Support & Danksagung

- **Autor**: Dasik (Rifaditya)
- **Lizenz**: GNU GPLv3
- **Kollektion**: Instant Gratification Collection
