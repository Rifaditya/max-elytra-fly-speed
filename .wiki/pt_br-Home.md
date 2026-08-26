# Max Elytra Fly Speed Wiki (Português do Brasil)

Bem-vindo à documentação técnica oficial e guia do jogador do **Max Elytra Fly Speed** (Velocidade Máxima dos Élitros).

> 📌 **Aviso sobre o estado do repositório**: Esta documentação reflete o **estado atual do código-fonte no repositório**, incluindo recursos recentes em desenvolvimento.

---

🌐 **Idiomas**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

---

## 🧭 Seleção de Versão

O Max Elytra Fly Speed segue rigorosamente a política de **1 Jar 1 Versão**:

| Versão do Minecraft | Status | Subprojeto | Documentação |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 Ativo | `Max Elytra Fly Speed v26.2` | [[👉 Acessar Wiki MC 26.2|26.2-Home]] |
| **Minecraft 26.3** | 🟢 Ativo | `Max Elytra Fly Speed v26.3` | [[👉 Acessar Wiki MC 26.3|26.3-Home]] |

---

## ⚡ Destaques da Física de Voo

* **Escalonamento Dinâmico de Arrasto Aerodinâmico**: Ao definir limites de velocidade acima de 50 Blocos/Segundo, a resistência do ar é reduzida automaticamente de forma inversamente proporcional, permitindo voos suaves e duradouros em alta velocidade.
* **Sistema de Propulsão de Foguetes em Dois Níveis**: Impulso inicial ágil no padrão vanilla para velocidades baixas (< 30 Blocos/Seg) e convergência vetorial proporcional suave em altas velocidades.
* **GameRules Dinâmicas Nativas**: Configuração em tempo real no jogo via `/gamerule` sem necessidade de bibliotecas externas em servidores dedicados.
* **Alto Desempenho $\mathcal{O}(1)$**: Zero alocações de novos objetos no loop de tick das entidades.

---

## 📑 Tabela de Referência de GameRules

| Identificador | Padrão | Intervalo | Nome Localizado | Descrição |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **Velocidade Máxima (Blocos/Seg)** | Limite máximo absoluto de velocidade do voo com élitros em Blocos/Segundo. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **Velocidade de Impulso Inicial** | Limite de velocidade para o impulso rápido padrão vanilla de foguetes. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **Aceleração de Alta Velocidade** | Taxa percentual de aceleração por tick acima da velocidade inicial (15 = 15%/tick). |

---

## 📜 Autoria & Licença

* **Autor**: **Dasik (Rifaditya)**
* **Licença**: **GNU General Public License v3.0 (GPLv3)**
* **Repositório**: [GitHub Source Code](https://github.com/Rifaditya/max-elytra-fly-speed)
