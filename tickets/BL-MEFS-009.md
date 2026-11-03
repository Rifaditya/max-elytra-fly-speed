# 🎫 [BL-MEFS-009] Storefront Reconciliation: Align Mod Pages with Current Public Release

- **Ticket ID**: `[BL-MEFS-009]`
- **Category**: `[GOVERNANCE]`
- **Priority**: `[HIGH]`
- **Scope**: `Platform Documentation & Metadata`
- **Status**: `✅ RESOLVED`
- **Target Repository / Root**: `Instant Gratification Collection/Max Elytra Fly Speed`

---

## 🎯 1. Goal & Definition of Done (The 4-Pillar Objective Architecture)

1. **North Star Objective**: Reconcile Modrinth and CurseForge storefront descriptions to reflect 100% ground-truth features of the current public release (Modrinth `1.0.26+26.3` / CurseForge `1.0.26+26.3`), strictly purging unreleased, in-development, or early-access mechanics.
2. **In-Game Experience (Before vs. After)**:
   - *Before*: Players reading Modrinth and CurseForge descriptions encounter advertised features, commands, or config parameters that only exist in unreleased repository branches or early-access builds, creating confusion and invalid bug reports.
   - *After*: Storefronts present 100% ground-truth features matching the published binary that players download from Modrinth and CurseForge.
3. **🚫 Anti-Goals (Off-Limits / Do Not Touch)**:
   - ❌ Do not document unreleased features from in-development or early-access builds; purge any unreleased claims.
   - ❌ Do not use corporate "we" voice in platform documentation; enforce the Solo Indie Voice ("I") invariant.
   - ❌ Do not modify Java source code or bump SemVer within this ticket.
4. **✅ Definition of Done (Binary Verification Checklist)**:
   - [x] Modrinth description (`Doc/Platform Pages/Modrinth/description.md`) aligned with public version.
   - [x] CurseForge markdown (`Doc/Platform Pages/CurseForge/description.md`) aligned with public version.
   - [x] CurseForge semantic HTML (`Doc/Platform Pages/CurseForge/description.html`) updated with valid semantic tags.
   - [x] Zero unreleased or hallucinated mechanics claimed in storefronts.

---

## ❓ 2. Problem Statement & Player Impact

Item 1.25 of the Studio Constitution (*Storefront Factual Accuracy & Anti-Hallucination Invariant*) establishes that storefronts (Modrinth/CurseForge) are binding representations. False advertising of unreleased or early-access mechanics erodes player trust, creates misleading gameplay expectations, and results in invalid bug reports from players who downloaded published releases.

---

## 🔬 3. Architectural Blueprint & Target Documentation Files

- **Target Documentation Files**:
- `Doc/Platform Pages/Modrinth/description.md`
- `Doc/Platform Pages/CurseForge/description.md`
- `Doc/Platform Pages/CurseForge/description.html`
- **Target Repository**: `Instant Gratification Collection/Max Elytra Fly Speed`
- **Live Public Releases**:
  - Modrinth: `1.0.26+26.3`
  - CurseForge: `1.0.26+26.3`

---

## ⚓ 4. Multi-Era Anchor Parity Specifications

- Storefront documentation uniformly reflects the supported public version anchors:
  - MC 1.20.1 (Legacy Immortal Anchor)
  - MC 1.21.1 (Tricky Trials Early Anchor)
  - MC 1.21.11 (Winter Drop Transitional Anchor)
  - MC 26.1.2, 26.2, 26.3+ (Modern Sovereign Anchors)

---

## 🛡️ 5. Edge Cases, Collisions & Failure Modes

- **CurseForge HTML Compatibility**: Storefront HTML must use valid semantic tags (`<h3>`, `<p>`, `<ul>`, `<code>`) without prohibited JavaScript or invalid inline styles.
- **Solo Indie Voice ("I" Voice)**: Ensure comms and descriptions use first-person singular ("I built this mod", "my mod"), never corporate "we".
- **Zero Unreleased Mechanics**: Explicitly verify all listed GameRules, commands, and options exist in the published release jar.

---

## 🚀 6. Implementation Steps (Execution Plan)

1. Audit existing `Doc/Platform Pages` documents against the public release binaries (MR `1.0.26+26.3` / CF `1.0.26+26.3`).
2. Purge any unreleased features, upcoming configuration options, or WIP commands.
3. Update Modrinth markdown documentation to match verified public release mechanics.
4. Update CurseForge markdown documentation and regenerate clean semantic CurseForge HTML.
5. Verify first-person indie voice ("I") across all storefront copy.
6. Verify clean synchronization with release hub and platform metadata.

---

## 🏁 7. 5-Pillar Verification Checklist

- [x] **Pillar 1 (Source & Binary Parity)**: 100% of features claimed in platform descriptions exist in public release binaries.
- [x] **Pillar 2 (Zero-Hallucination Guard)**: Zero unreleased, early-access, or phantom mechanics remain across storefront docs. Purged: Kinetic Impact Shock Absorber, Emergency Airbag Shield, Server Anti-Rubberband system, all 4 phantom GameRules (`max_elytra_speed:*`), wrong Mod ID `max_elytra_speed`.
- [x] **Pillar 3 (Brigadier AST Alignment)**: No command system exists in this mod — confirmed by source audit. Not documented.
- [x] **Pillar 4 (GameTest & Config Parity)**: Documented GameRules match source: `max-elytra-fly-speed:max_elytra_fly_speed` (50, 1–500), `max-elytra-fly-speed:elytra_initial_boost_speed` (30, 1–300), `max-elytra-fly-speed:elytra_high_speed_acceleration` (15, 1–1000).
- [x] **Pillar 5 (Sidedness & Platform Hygiene)**: Solo indie voice ("I") verified; CurseForge HTML uses pure semantic markup only.

---

## ✅ Resolution Notes

- **Resolved**: 2026-11-03
- **Modrinth** (`x8quK158`): Description pushed (HTTP 204 ✅). Links synced (wiki_url, source_url, issues_url ✅).
- **CurseForge** (`1617614`): HTML ready at `Doc/Platform Pages/CurseForge/description.html`. Edit at: https://authors.curseforge.com/projects/1617614/edit
- **Phantom purge**: Removed Kinetic Impact Shock Absorber, Emergency Airbag Shield, Server Anti-Rubberband, all 4 fake `max_elytra_speed:*` GameRules, wrong Mod ID namespace, LaTeX math in HTML, "our Discord" corporate voice.
- **Ground truth documented**: 3 GameRules (`max-elytra-fly-speed:max_elytra_fly_speed`, `elytra_initial_boost_speed`, `elytra_high_speed_acceleration`); 2 Mixins (`LivingEntityMixin`, `FireworkRocketEntityMixin`); Dasik Library >= 1.9.0 required.
