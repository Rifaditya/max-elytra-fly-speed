# Max Elytra Fly Speed Wiki (Français)

Bienvenue sur la documentation technique officielle et le guide du joueur pour **Max Elytra Fly Speed** (Vitesse de Vol Maximale des Élytres).

> 📌 **Avertissement sur l'état du dépôt** : Cette documentation reflète **l'état actuel du code source dans le dépôt**, incluant les fonctionnalités en cours de développement.

---

🌐 **Langues** : [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

---

## 🧭 Sélection de la Version

Max Elytra Fly Speed respecte rigoureusement la politique **1 Jar 1 Version** :

| Version de Minecraft | Statut | Sous-projet | Documentation |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 Actif | `Max Elytra Fly Speed v26.2` | [[👉 Ouvrir le Wiki MC 26.2|26.2-Home]] |
| **Minecraft 26.3** | 🟢 Actif | `Max Elytra Fly Speed v26.3` | [[👉 Ouvrir le Wiki MC 26.3|26.3-Home]] |

---

## ⚡ Points Clés de la Physique de Vol

* **Mise à l'échelle dynamique de la traînée aérodynamique** : Lorsque la limite de vitesse est configurée au-delà de 50 Blocs/Seconde, la perte par traînée diminue automatiquement de manière inversement proportionnelle pour un vol plané fluide et rapide.
* **Propulsion de fusée d'artifice à deux paliers** : Accélération initiale instantanée vanilla (< 30 Blocs/Sec) et convergence vectorielle proportionnelle fluide vers la vitesse maximale.
* **GameRules dynamiques natives** : Configuration en temps réel via la commande `/gamerule` sans bibliothèque de configuration externe sur serveurs dédiés.
* **Haute performance $\mathcal{O}(1)$** : Aucune allocation d'objet dans la boucle de tick des entités.

---

## 📑 Tableau de Référence des GameRules

| Identifiant | Défaut | Plage | Nom Localisé | Description |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **Vitesse Maximale (Blocs/Sec)** | Vitesse maximale absolue du vol en élytres en Blocs/Seconde. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **Vitesse de Propulsion Initiale** | Seuil de vitesse pour l'accélération vive standard vanilla. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **Accélération Haute Vitesse** | Pourcentage d'accélération par tick au-dessus de la vitesse initiale (15 = 15%/tick). |

---

## 📜 Auteur & Licence

* **Auteur** : **Dasik (Rifaditya)**
* **Licence** : **GNU General Public License v3.0 (GPLv3)**
* **Dépôt** : [Code Source GitHub](https://github.com/Rifaditya/max-elytra-fly-speed)
