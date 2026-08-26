# Developer Setup, Building & Automated Testing — MC 26.3

This guide provides instructions for compiling release JARs and running automated JUnit tests for **Max Elytra Fly Speed (MC 26.3)**.

---

## 🛠️ Build Commands

```bash
# Compile release JAR
./gradlew build --no-daemon

# Run automated JUnit tests
./gradlew test --no-daemon
```

---

## 🧪 Test Verification

* `ElytraDragHelperTest`: Asserts vanilla drag parity and high-speed drag relaxation.
* `RocketBoostHelperTest`: Asserts snappy initial boost and proportional vector convergence.

---

## 🧭 Navigation

* [[🏠 Subproject Home|Home]]
* [[🧩 Architecture & Mixins|Architecture-and-Mixins]]
