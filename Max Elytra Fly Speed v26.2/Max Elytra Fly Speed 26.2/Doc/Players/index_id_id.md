# 🚀 Kecepatan Terbang Elytra Maksimal (Max Elytra Fly Speed) - Panduan Pemain

Selamat datang di **Max Elytra Fly Speed**! Mod ini menghapus batasan kecepatan terbang Elytra bawaan Minecraft vanilla secara tuntas, menyediakan batas kecepatan maksimal yang dapat dikonfigurasi, kurva akselerasi roket kembang api proporsional yang mulus, serta aerodinamika luncuran menukik.

---

## ⚡ Fitur Utama & Dinamika Terbang

1. **Batas Kecepatan yang Dapat Disesuaikan**:
   - Batas vanilla di Minecraft sangat ketat. Mod ini memungkinkan Anda menyetel kecepatan terbang maksimal ke nilai berapa pun (default: `50` blok/detik, dapat ditingkatkan ke `100`, `200`, atau bahkan `3000` blok/detik).
2. **Skala Kecepatan Dua Fase (Dual-Phase Scaling)**:
   - **Fase 1 (Dorongan Awal)**: Di bawah ambang batas kecepatan (default: `30` blok/detik), Anda menikmati dorongan cepat dan lincah dari roket vanilla.
   - **Fase 2 (Meluncur Kecepatan Tinggi)**: Di atas ambang batas, roket kembang api berakselerasi secara proporsional menuju batas kecepatan yang Anda tentukan, melesat hingga 100+ blok/detik hanya dalam 2–3 roket.
3. **Peredaman Hambatan Udara Dinamis saat Menukik**:
   - Pada batas kecepatan tinggi, hambatan udara berkurang secara dinamis saat menukik, memungkinkan pemain mengumpulkan dan mempertahankan kecepatan ekstrem saat bermanuver tajam.

---

## ⚙️ Pengaturan via GameRules Bawaan

Mod ini menggunakan sistem aturan permainan (GameRules) bawaan Minecraft, sehingga perubahan langsung aktif seketika di dalam game tanpa perlu membuka file konfigurasi:

| Aturan Permainan (GameRule) | Default | Deskripsi |
| :--- | :---: | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | Batas kecepatan terbang Elytra maksimal absolut (blok/detik). |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | Ambang batas kecepatan (blok/detik) untuk dorongan roket cepat vanilla. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | Persentase laju akselerasi per tick di atas ambang batas awal (15% per tick). |

> [!TIP]
> Pengaturan dapat disesuaikan langsung di menu **"Edit Aturan Permainan"** atau melalui perintah `/gamerule max-elytra-fly-speed:max_elytra_fly_speed <nilai>`.

---

## ☕ Dukungan & Penghargaan

- **Pembuat**: Dasik (Rifaditya)
- **Lisensi**: GNU GPLv3
- **Koleksi**: Instant Gratification Collection
