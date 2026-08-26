# Max Elytra Fly Speed Wiki (Bahasa Indonesia)

Selamat datang di dokumentasi teknis resmi dan panduan pemain untuk **Max Elytra Fly Speed** (Kecepatan Terbang Elitra Maksimal).

> 📌 **Penafian Status Repositori**: Dokumentasi dalam Wiki ini mencerminkan **status kode sumber terbaru di repositori**, yang mungkin mencakup fitur pengembangan terkini.

---

🌐 **Navigasi Bahasa**: [[🇺🇸 English|Home]] | [[🇨🇳 简体中文|zh_cn-Home]] | [[🇷🇺 Русский|ru_ru-Home]] | [[🇪🇸 Español|es_es-Home]] | [[🇩🇪 Deutsch|de_de-Home]] | [[🇯🇵 日本語|ja_jp-Home]] | [[🇮🇩 Bahasa Indonesia|id_id-Home]] | [[🇭🇰 繁體中文|zh_tw-Home]]

---

## 🧭 Pemilihan Versi

Max Elytra Fly Speed mematuhi kebijakan **1 Jar 1 Version**:

| Versi Minecraft | Status | Subproyek | Dokumentasi |
| :--- | :---: | :--- | :---: |
| **Minecraft 26.2** | 🟢 Aktif | `Max Elytra Fly Speed v26.2` | [[👉 Masuk Wiki MC 26.2|26.2-Home]] |
| **Minecraft 26.3** | 🟢 Aktif | `Max Elytra Fly Speed v26.3` | [[👉 Masuk Wiki MC 26.3|26.3-Home]] |

---

## ⚡ Fitur Utama Fisika Terbang

* **Penskalaan Hambatan Udara Dinamis**: Mengatur batas kecepatan di atas 50 Blok/Detik secara otomatis meredakan hambatan udara agar pemain dapat meluncur dengan kecepatan tinggi tanpa deselerasi mendadak.
* **Mesin Pendorong Roket Dua Tingkat**: Dorongan awal instan seperti vanilla di bawah 30 Blok/Detik, dan konvergensi vektor proporsional yang mulus menuju kecepatan maksimal di atas 30 Blok/Detik.
* **GameRules Dinamis Asli**: Dikonfigurasi langsung menggunakan perintah `/gamerule` tanpa memerlukan pustaka konfigurasi tambahan di server.
* **Performa Tinggi $\mathcal{O}(1)$**: Tanpa alokasi memori objek baru dalam perulangan tick entitas.

---

## 📑 Tabel Referensi GameRules

| Pengenal GameRule | Bawaan | Rentang | Nama Terjemahan | Deskripsi Fungsi |
| :--- | :---: | :---: | :--- | :--- |
| `max-elytra-fly-speed:max_elytra_fly_speed` | `50` | $1 \sim 2^{31}-1$ | **Kecepatan Maks (Blok/Detik)** | Batas kecepatan tertinggi penerbangan Elitra dalam Blok/Detik. |
| `max-elytra-fly-speed:elytra_initial_boost_speed` | `30` | $1 \sim 2^{31}-1$ | **Kecepatan Dorongan Awal** | Ambang kecepatan untuk dorongan roket cepat bawaan vanilla. |
| `max-elytra-fly-speed:elytra_high_speed_acceleration` | `15` | $1 \sim 1000$ | **Akselerasi Kecepatan Tinggi** | Persentase akselerasi per tick di atas kecepatan dorongan awal (15 = 15%/tick). |

---

## 📜 Lisensi & Pengembang

* **Pengembang**: **Dasik (Rifaditya)**
* **Lisensi**: **GNU General Public License v3.0 (GPLv3)**
