# Max Elytra Fly Speed Wiki (Deutsch)

Willkommen in der offiziellen Dokumentation für **Max Elytra Fly Speed** (Maximale Elytren-Fluggeschwindigkeit).

> 📌 **Hinweis zum Repository-Status**: Diese Dokumentation spiegelt den **aktuellen Quellcode-Stand im Repository** wider.

---

🌐 **Sprachen**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

---

## 🧭 Versionsauswahl

Max Elytra Fly Speed folgt strikt der **1 Jar 1 Version** Richtlinie:

| Minecraft-Version | Status | Unterprojekt | Dokumentation |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 Aktiv | `Max Elytra Fly Speed v26.2` | [[👉 MC 26.2 Wiki öffnen|26.2-Home]] |
| **Minecraft 26.3** | 🟢 Aktiv | `Max Elytra Fly Speed v26.3` | [[👉 MC 26.3 Wiki öffnen|26.3-Home]] |

---

## ⚡ Kernfunktionen der Flugphysik

* **Dynamische Luftwiderstandsskalierung**: Beim Anheben des Geschwindigkeitslimits über 50 Blöcke/Sek wird der Luftwiderstand automatisch verringert, um langes und flüssiges Gleiten zu ermöglichen.
* **Zweistufiger Feuerwerksraketen-Antrieb**: Direkter Vanilla-Start unter 30 Blöcken/Sek und sanfte proportionale Vektorbeschleunigung bei hohen Geschwindigkeiten.
* **Native GameRules**: Konfiguration im Spiel über `/gamerule` ohne externe Bibliotheken auf dedizierten Servern.
* **$\mathcal{O}(1)$ Performance**: Keine Objektallokationen im Entity-Tick-Loop.

---

## 📑 GameRules-Referenztabelle

| GameRule-Schlüssel | Standard | Bereich | Lokalisierter Name | Beschreibung |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **Max. Geschwindigkeit (Blöcke/Sek)** | Höchstgrenze für Elytren-Fluggeschwindigkeit in Blöcken pro Sekunde. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **Initiale Boost-Geschwindigkeit** | Geschwindigkeitsschwelle für sofortigen Vanilla-Raketen-Boost. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **Hochgeschwindigkeits-Beschleunigung** | Beschleunigungsrate pro Tick oberhalb der Initialgeschwindigkeit (15 = 15%/Tick). |

---

## 📜 Lizenz & Urheberrecht

* **Autor**: **Dasik (Rifaditya)**
* **Lizenz**: **GNU General Public License v3.0 (GPLv3)**
