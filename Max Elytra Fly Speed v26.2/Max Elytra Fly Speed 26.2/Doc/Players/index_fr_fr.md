# 🚀 Vitesse de Vol Maximale des Élytres (Max Elytra Fly Speed) - Guide du Joueur

Bienvenue dans **Max Elytra Fly Speed** ! Ce mod supprime totalement les restrictions de vitesse du vol en élytres de Minecraft vanilla, offrant une limite de vitesse maximale personnalisable, une accélération proportionnelle et fluide avec les fusées d'artifice, ainsi qu'une aérodynamique de piqué avancée.

---

## ⚡ Fonctionnalités Principales & Dynamique de Vol

1. **Vitesse Maximale Personnalisable** :
   - Le plafond de vitesse de Minecraft vanilla est très restrictif. Ce mod vous permet de configurer la vitesse maximale à n'importe quelle valeur (par défaut : `50` blocs/seconde, extensible à `100`, `200` ou même `3000` blocs/sec).
2. **Échelonnement de la Vitesse en Deux Phases (Dual-Phase Scaling)** :
   - **Phase 1 (Propulsion Initiale)** : En dessous du seuil de vitesse (par défaut : `30` blocs/sec), vous profitez de la propulsion vive et rapide des fusées vanilla.
   - **Phase 2 (Vol Plané Haute Vitesse)** : Au-dessus du seuil, les fusées accélèrent proportionnellement vers le plafond configuré, atteignant facilement plus de 100 blocs/sec en seulement 2 à 3 fusées.
3. **Réduction Dynamique de la Traînée d'Air en Piqué** :
   - À haute vitesse, la traînée de l'air est réduite dynamiquement lors des piqués, permettant d'accumuler et de maintenir des vitesses extrêmes lors des manœuvres.

---

## ⚙️ Configuration via les Règles de Jeu (GameRules) Natives

Le mod utilise le système natif de règles de jeu de Minecraft, rendant les changements immédiatement effectifs sans redémarrage :

| Règle de Jeu (GameRule) | Par Défaut | Description |
| :--- | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | Vitesse maximale absolue du vol en élytres (blocs/seconde). |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | Seuil de vitesse (blocs/sec) pour la propulsion vive vanilla. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | Taux d'accélération en pourcentage par tick au-dessus du seuil initial (15% par tick). |

> [!TIP]
> Vous pouvez modifier ces paramètres dans l'écran **« Modifier les règles du jeu »** ou avec la commande `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <valeur>`.

---

## ☕ Support & Crédits

- **Auteur** : Dasik (Rifaditya)
- **Licence** : GNU GPLv3
- **Collection** : Instant Gratification Collection
