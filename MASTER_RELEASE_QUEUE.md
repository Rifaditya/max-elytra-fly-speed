# 🎛️ Master Release Queue: Instant Gratification — Max Elytra Fly Speed

> **Mod Project Master Ground-Truth Document**  
> *Last Synchronized: 2026-09-05*  
> **Modrinth ID**: `x8quK158` | **CurseForge ID**: `1617614` | **Lead SemVer**: `1.0.23`

---

## 📊 Multi-Version Release Matrix & Queue Status

| Target MC | Generational Era | Live on Platforms | Next Queued Version | Status & Cadence Action | Feature Highlights / Notes |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **MC 26.3** | Modern Lead | `1.0.6` | `1.0.8+26.3` | 🟢 **Ready to Publish** | Next release: `1.0.8+26.3`. Initial port and release targeting Minecraft 26.3. |
| **MC 26.2** | Modern Predecessor | `1.0.8+26.2` | `1.0.9+26.2` | 🟢 **Ready to Publish** | Next release: `1.0.9+26.2`. Rocket Boost Proportional Acceleration Scaling ([BL-MEFS-001]). |

---

## 🏛️ Project Operating Rules & Architectural Invariants

1. **🔢 Universal Direct SemVer Inheritance**:
   - Modern subprojects share unified SemVer milestone lineage targeting `1.0.22`.
   - Each Minecraft version anchor manages its own organic progression to ensure 100% clean, verified parity.

2. **📅 Daily Update Guard**:
   - Strict maximum of 1 release per day per targeted Minecraft version anchor across Modrinth and CurseForge.

---

## 🛠️ CLI Publisher Commands for Max Elytra Fly Speed

```powershell
# 1. Check current status across all targeted Minecraft versions
python ".agents/skills/platform-publisher/scripts/platform_publisher.py" --mod "Max Elytra Fly Speed" --status

# 2. Publish next sequential batch across all active versions
python ".agents/skills/platform-publisher/scripts/platform_publisher.py" --mod "Max Elytra Fly Speed" --publish-next --yes

# 3. Publish for a specific version anchor only (e.g. MC 26.3)
python ".agents/skills/platform-publisher/scripts/platform_publisher.py" --mod "Max Elytra Fly Speed" --mc 26.3 --publish-next --yes
```
