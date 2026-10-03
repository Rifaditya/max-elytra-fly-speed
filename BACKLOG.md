# 📌 Max Elytra Fly Speed Backlog

This file tracks planned features, technical refinements, performance optimizations, and deferred improvements for **Max Elytra Fly Speed**.

---

## 📊 Backlog Summary

| ID | Category | Title | Priority | Target Version | Status |
| :--- | :--- | :--- | :--- | :--- | :--- |
| `[BL-MEFS-001]` | `[FEATURE]` | Multi-Era Anchor Porting: Max Elytra Fly Speed | `[HIGH]` | `Multi-Era` | `📌 DEFERRED` |
| `[BL-MEFS-002]` | `[TECH_DEBT]` | Downstream Ecosystem & Toolchain Alignment | `[HIGH]` | All Anchors | `✅ RESOLVED` |

---

## 🏷 Legend & Status Tags
- **Categories**: `[FEATURE]`, `[REFINEMENT]`, `[BUGFIX]`, `[PERF]`, `[TECH_DEBT]`
- **Priorities**: `[HIGH]` (Critical logic/porting task), `[MEDIUM]` (Quality of life), `[LOW]` (Minor polish)
- **Statuses**: `📌 DEFERRED` (Queued for future work), `🚧 IN_PROGRESS` (Active development), `✅ RESOLVED` (Implemented and verified)

---

## 📝 Detailed Backlog Entries

### [BL-MEFS-001] Multi-Era Anchor Porting: Max Elytra Fly Speed
- **Category**: `[FEATURE]`
- **Priority**: `[HIGH]`
- **Status**: `📌 DEFERRED`
- **Target Component(s)**: Multi-subproject directories, `ElytraMovementMixin.java`, `FlySpeedGameRules.java`, `MaxElytraFlySpeedConfig.java`, `build.gradle`, `fabric.mod.json`, `RELEASE_QUEUE.md`
- **Date Added**: 2026-09-25

#### ❓ Problem / Context
Existing versions: `26.2`, `26.3`. Missing anchors: Modern `26.1 / 26.1.2`; Older `1.21.11`, `1.21.1`, `1.20.1`.
Per Multi-Era Version Matrix and 1 Jar 1 Version Policy, port mod across all missing anchors (Modern first, Older second).

#### 💡 Architectural Specifications & Toolchain Anchors
- **Phase 1: Modern Sovereign Anchors (Java 25+, Loom 1.15+, No Mappings Block)**:
  - `MC 26.1 / 26.1.2`: Java 25, Fabric Loom 1.15+, `Identifier.fromNamespaceAndPath`, `EntityTypes`, `dasik-library` 26.1.
  - `MC 26.2`: Java 25, Fabric Loom 1.15+, `Identifier.fromNamespaceAndPath`, `DynamicGameRuleManager` (already active baseline).
  - `MC 26.3`: Java 25, Fabric Loom 1.15+, `minecraft_version=26.3-snapshot-6`, `fabric_version=0.156.1+26.3` (already active baseline).
- **Phase 2: Older Anchors (Mojang Mappings, Java 21 / 17)**:
  - `MC 1.21.11`: Java 21, Loom 1.15-SNAPSHOT (`fabric-loom-remap`), Mojang mappings, `Identifier.of`, `Optional<T>` CompoundTag, relocated entity packages.
  - `MC 1.21.1`: Java 21, Loom 1.10+, Mojang mappings, `Identifier.of`, `DataComponents`, native `Attributes.SCALE`.
  - `MC 1.20.1`: Java 17, Loom 1.4–1.10, Mojang mappings, `new Identifier`, primitive NBT CompoundTag, `FabricItemSettings`, `GameRules.Category` enum.

#### 🧪 Verification & Acceptance Criteria

##### Phase 1: Modern Sovereign Anchors (Priority 1)
- [ ] **Anchor: MC 26.1 / 26.1.2**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry
- [x] **Anchor: MC 26.2 - Already established baseline** (Subproject: `Max Elytra Fly Speed v26.2`)
- [x] **Anchor: MC 26.3 - Already established baseline** (Subproject: `Max Elytra Fly Speed v26.3`)

##### Phase 2: Older Anchors (Priority 2)
- [ ] **Anchor: MC 1.21.11 (Java 21, Loom 1.15-SNAPSHOT `fabric-loom-remap`, Mojang mappings, `Identifier.of`, `Optional<T>` CompoundTag, relocated entity packages)**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry
- [ ] **Anchor: MC 1.21.1 (Java 21, Loom 1.10+, Mojang mappings, `Identifier.of`, `DataComponents`, native `Attributes.SCALE`)**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry
- [ ] **Anchor: MC 1.20.1 (Java 17, Loom 1.4-1.10, Mojang mappings, `new Identifier`, primitive NBT CompoundTag, `FabricItemSettings`, `GameRules.Category` enum)**
  - [ ] Subproject directory & build script scaffolding (`build.gradle`, `gradle.properties`, `settings.gradle`)
  - [ ] Source adaptation, API/mixin relocation, and dasik-library wiring for target version
  - [ ] Headless unit & integration test suite pass (`./gradlew test --no-daemon`)
  - [ ] Clean binary compilation (`./gradlew build --no-daemon`)
  - [ ] Mandatory Universal 4-Point Distribution (Local Archive, Hub Archive, External Vault `D:\`, Launcher Test Profile)
  - [ ] Release queue registration in `RELEASE_QUEUE.md` (`- [ ]`) and `CHANGELOG.md` entry

### [BL-MEFS-002] Downstream Ecosystem & Toolchain Alignment: watched_projects, fabric.mod.json, Queue Segregation & Archive Hierarchy
- **Category**: `[TECH_DEBT]`
- **Priority**: `[HIGH]`
- **Target Version**: All Anchors
- **Status**: `✅ RESOLVED`
- **Date Added**: 2026-10-01
- **Date Resolved**: 2026-10-03
- **Problem / Context**:
  Across the studio release pipeline and downstream automation tools, systemic inconsistencies exist:
  1. `dasik-mod-sync/watched_projects.json`: Many mods contain broken `icon_path` mappings (non-existent nested folder references) or stale `versions` arrays that omit active anchors.
  2. `fabric.mod.json`: Platform metadata (`custom.modrinth.projectId`, `slug`, repository URLs) occasionally drifts from authoritative entries in `minecraft-mod-release-hub/config/platform_projects.json`.
  3. `RELEASE_QUEUE.md`: Multi-version subproject directories often retain predecessor anchor changelog headers, violating the Subproject Queue Segregation Law.
  4. Archive Structure: Collection roots lack standardized `Archive Jar of all versions/` hierarchies (`MC <Version>/`), preventing `sync_archives.py` from auto-discovering compiled builds for release hub and external vault distribution.
- **Proposed Solution & Technical Specifications**:
  1. Audit and correct `icon_path` and `versions` array in `dasik-mod-sync/watched_projects.json` for Max Elytra Fly Speed.
  2. Align `fabric.mod.json` across all active subprojects with official `platform_projects.json` metadata.
  3. Purge predecessor version headers from subproject `RELEASE_QUEUE.md` and `CHANGELOG.md` files (strict Version Anchor Exclusivity).
  4. Scaffold/verify collection root `Archive Jar of all versions/` containing dedicated `MC <Version>/` folders with existing release JARs mirrored.
  5. Scaffold root `MASTER_RELEASE_QUEUE.md` multi-anchor dashboard where absent.
- **Verification & Acceptance Criteria**:
  - [x] `watched_projects.json` icon path physically exists on disk and `versions` matches active anchors.
  - [x] `fabric.mod.json` metadata strictly aligns with `platform_projects.json`.
  - [x] Subproject `RELEASE_QUEUE.md` files contain strictly target-anchor release entries.
  - [x] Root `Archive Jar of all versions/` exists and contains release JARs discoverable by `sync_archives.py`.

