# 🚀 Velocidade Máxima dos Élitros (Max Elytra Fly Speed) - Guia do Jogador

Bem-vindo ao **Max Elytra Fly Speed**! Este mod remove completamente as limitações padrão de velocidade de voo com élitros no Minecraft vanilla, oferecendo um limite de velocidade configurável, uma aceleração suave e proporcional com foguetes de fogos de artifício e física de planeio em mergulho.

---

## ⚡ Principais Recursos e Dinâmica de Voo

1. **Limite de Velocidade Customizável**:
   - O limite vanilla do Minecraft é altamente restritivo. Este mod permite que você configure a velocidade máxima de voo para qualquer valor (padrão: `50` blocos/seg, expansível para `100`, `200` ou até `3000` blocos/seg).
2. **Escala de Velocidade em Duas Fases (Dual-Phase Scaling)**:
   - **Fase 1 (Impulso Inicial)**: Abaixo do limite de velocidade (padrão: `30` blocos/seg), você desfruta do impulso ágil e rápido dos foguetes vanilla.
   - **Fase 2 (Planeio em Alta Velocidade)**: Acima do limite, os foguetes aceleram proporcionalmente em direção ao teto configurado, alcançando 100+ blocos/seg com apenas 2–3 foguetes.
3. **Redução Dinâmica do Arrasto do Ar em Mergulhos**:
   - Em configurações de alta velocidade, a resistência do ar é reduzida dinamicamente durante mergulhos acentuados, permitindo acumular e sustentar velocidades extremas ao puxar voo horizontal.

---

## ⚙️ Configuração via Regras de Jogo (GameRules) Nativas

O mod utiliza o sistema nativo de regras de jogo do Minecraft, aplicando alterações instantaneamente sem necessidade de reiniciar ou editar arquivos:

| Regra de Jogo (GameRule) | Padrão | Descrição |
| :--- | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | Velocidade máxima absoluta do voo com élitros (blocos/segundo). |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | Limite de velocidade (blocos/seg) para o impulso inicial rápido do vanilla. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | Taxa de aceleração percentual por tick acima do limite inicial (15% por tick). |

> [!TIP]
> Os parâmetros podem ser ajustados na tela **"Editar Regras do Jogo"** ou pelo comando `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <valor>`.

---

## ☕ Suporte & Agradecimentos

- **Autor**: Dasik (Rifaditya)
- **Licença**: GNU GPLv3
- **Coleção**: Instant Gratification Collection
