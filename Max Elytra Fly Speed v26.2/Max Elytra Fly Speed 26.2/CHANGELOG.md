# Changelog: Instant Gratification — Max Elytra Fly Speed (MC 26.2)

## [1.0.26+26.2] - 2026-10-17

### Changed
- **Universal Configuration Screen**: Migrated configuration GUI to DasikLibrary's centralized UniversalConfigScreen generator.
- **Creator Support Touchpoints**: Injected automated Ko-fi and Discord creator community action buttons into the configuration screen.
- **Sidedness & Classloading Safety**: Zero client class dependencies in common configuration declarations, ensuring dedicated server stability.

## [1.0.25+26.2] - 2026-09-05

### Added
- **YACL v3 Migration**: Replaced Cloth Config screen with YetAnotherConfigLib v3.
- **Ko-fi Support Integration**: Added top-pinned solo developer support button linking directly to Ko-fi in config screen.

## [1.0.24+26.2] - 2026-09-05

### Fixed
- Shielded ModMenu with Deferred Reflection Classloading.

## [1.0.23+26.2] - 2026-09-05

### Fixed
- Fixed Cloth Config NPE & added category with Ko-fi support banner.

## [1.0.22+26.2] - 2026-08-26

### Added
- Korean (`ko_kr`) localization.

## [1.0.21+26.2] - 2026-08-26

### Added
- French (`fr_fr`, `fr_ca`) localization.

## [1.0.20+26.2] - 2026-08-26

### Added
- Portuguese (`pt_br`, `pt_pt`) localization.

## [1.0.19+26.2] - 2026-08-26

### Added
- Japanese (`ja_jp`) localization.

## [1.0.18+26.2] - 2026-08-26

### Added
- Indonesian (`id_id`) localization.

## [1.0.17+26.2] - 2026-08-26

### Added
- German (`de_de`) localization.

## [1.0.16+26.2] - 2026-08-26

### Added
- Spanish (`es_es`, `es_mx`) localization.

## [1.0.15+26.2] - 2026-08-26

### Added
- Russian (`ru_ru`) localization.

## [1.0.14+26.2] - 2026-08-26

### Added
- Traditional Chinese (`zh_tw`, `zh_hk`) localization.

## [1.0.13+26.2] - 2026-08-26

### Added
- Simplified Chinese (`zh_cn`) localization.

## [1.0.12+26.2] - 2026-08-26

### Changed
- Backlog pruning and platform documentation synchronization.

## [1.0.11+26.2] - 2026-08-26

### Added
- Headless JUnit reality test suite.

## [1.0.10+26.2] - 2026-08-26

### Changed
- Dynamic drag floor scaling and high speed glide physics.

## [1.0.9+26.2] - 2026-08-26

### Changed
- Rocket boost proportional acceleration scaling.

## [1.0.8+26.2] - 2026-07-22

### Fixed
- ModVersionGuard Knot ClassLoader resolution fix.

## [1.0.7+26.2] - 2026-07-22

### Added
- Forward compatibility and open-ended version guard.

## [1.0.6] - 2026-07-20

### Changed
- Increased default max speed limit to 50 blocks/sec and added vanilla equipped Elytra icon.

## [1.0.5] - 2026-07-16

### Changed
- Split firework boost logic: vanilla math up to 30 blocks/sec, gradual drag-compensated math above.

## [1.0.4] - 2026-07-16

### Changed
- Dynamic drag coefficient and smoother firework boost acceleration. Allows diving down to build speed.

## [1.0.3] - 2026-07-16

### Changed
- Gradual Elytra acceleration curve with drag compensation matching powered rails (0.06 blocks/tick acceleration).

## [1.0.2] - 2026-07-16

### Changed
- Gradual Elytra acceleration curve for rocket boosts. Prevents jarring instant acceleration at high speed caps.

## [1.0.1] - 2026-07-16

### Changed
- Fixed category header color, renamed rule label, and scaled thrust force by limit ratio.

## [1.0.0] - 2026-07-16

### Added
- Initial release targeting Minecraft 26.2 stable. Includes sovereign GameRule for Elytra speed clamping.
