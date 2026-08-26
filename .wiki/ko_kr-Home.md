# Max Elytra Fly Speed Wiki (한국어)

**Max Elytra Fly Speed (겉날개 최대 비행 속도)** 공식 기술 문서 및 플레이어 가이드에 오신 것을 환영합니다.

> 📌 **저장소 상태 안내**: 본 위키의 문서는 CurseForge 및 Modrinth에 공개 배포된 빌드보다 앞선 개발 중인 기능을 포함할 수 있는 **저장소의 최신 소스 코드 상태**를 반영합니다.

---

🌐 **언어 탐색**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇫🇷 Français|fr_fr-Home]] | [[🇧🇷 Português|pt_br-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇰🇷 한국어|ko_kr-Home]]

---

## 🧭 마인크래프트 버전 선택

Max Elytra Fly Speed는 **1 Jar 1 Version (1 버전 1 JAR)** 정책을 엄격히 준수합니다:

| 마인크래프트 버전 | 상태 | 대상 서브프로젝트 | 전용 문서 포털 |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 활성 유지 | `Max Elytra Fly Speed v26.2` | [[👉 MC 26.2 위키 열기|26.2-Home]] |
| **Minecraft 26.3** | 🟢 활성 유지 | `Max Elytra Fly Speed v26.3` | [[👉 MC 26.3 위키 열기|26.3-Home]] |

---

## ⚡ 비행 물리 엔진 핵심 기능

* **동적 공기 항력 하한 스케일링**: 최대 속도 제한을 50블록/초 이상으로 높이면 공기 항력 손실률이 역비례하여 자동으로 감소하므로, 감속 턱 없이 매끄럽고 지속적인 초고속 활공이 가능합니다.
* **2단계 폭죽 로켓 추진 시스템**: 저속(< 30블록/초)에서는 즉각적인 바닐라식 발사 추진을 제공하고, 고속($\ge 30$블록/초)에서는 시선 방향 목표 속도로 부드럽게 비례 수렴 가속합니다.
* **네이티브 동적 GameRules**: 전용 서버에 외부 설정 라이브러리를 설치할 필요 없이 바닐라 `/gamerule` 명령어로 실시간 제어할 수 있습니다.
* **$\mathcal{O}(1)$ 고성능 핫패스**: 엔티티 틱 루프 내에서 객체 할당을 완전히 배제하여 서버 TPS를 안정적으로 유지합니다.

---

## 📑 게임 규칙 (GameRules) 참조표

| 규칙 식별자 | 기본값 | 유효 범위 | 번역 이름 | 기능 설명 |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **최대 비행 속도 (블록/초)** | 겉날개 활공 비행의 절대 최대 속도 상한선 (블록/초). |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **초기 부스트 속도** | 바닐라 로켓의 빠른 가속이 적용되는 속도 임계값 (블록/초). |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **고속 가속도** | 초기 부스트 속도 초과 시 틱당 가속률 백분율 (15 = 틱당 15%). |

---

## 📜 개발자 및 라이선스

* **개발자**: **Dasik (Rifaditya)**
* **라이선스**: **GNU General Public License v3.0 (GPLv3)**
* **저장소**: [GitHub Source Code](https://github.com/Rifaditya/max-elytra-fly-speed)
