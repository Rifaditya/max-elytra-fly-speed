# Changelog: Instant Gratification — Max Elytra Fly Speed (MC 26.1.2)

## [1.0.26+26.1.2] - 2026-10-22

### Added
- **Modern Sovereign Anchor Port (MC 26.1.2)**: Full port to Minecraft 26.1.2 with Java 25 and Fabric Loom 1.15.5.
- **Dynamic GameRule Flight Speed Clamping**: Customizable maximum velocity ceiling in Blocks/Second (`max-elytra-fly-speed:max_elytra_fly_speed`).
- **Aesthetic Dual-Phase Rocket Boost**: Smooth gradual acceleration curve above initial boost threshold (`max-elytra-fly-speed:elytra_initial_boost_speed` & `elytra_high_speed_acceleration`).
- **Aerodynamic Drag Floor Scaling**: Dynamic drag relaxation at high speeds for sustained glide momentum.
- **Universal Configuration Screen**: Centralized UniversalConfigScreen generator powered by DasikLibrary with Ko-fi and ModMenu integration.
- **Complete Global Localization**: Full translations across 11 languages (de_de, en_us, es_es, es_mx, fr_ca, fr_fr, id_id, ja_jp, ko_kr, pt_br, pt_pt, ru_ru, zh_cn, zh_hk, zh_tw).
- **5-Pillar Autonomous Test Suite**: Full headless verification encompassing chaos fuzzing, concurrency load, Brigadier AST, simulation GameTests, and sidedness contract checks.
