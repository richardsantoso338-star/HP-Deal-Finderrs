# HP Deal Finder

Android app sederhana untuk membuka pencarian HP bekas di Facebook Marketplace.

## Build APK
GitHub Actions akan membangun APK debug setiap ada push ke branch `main` atau saat workflow dijalankan manual. Buka tab Actions, pilih "Build HP Deal Finder APK", lalu unduh artifact `HP-Deal-Finder-debug`.

## Batasan penting
Aplikasi ini membuka pencarian resmi Marketplace di browser. Aplikasi tidak mengakses akun, tidak mengambil/scrape listing secara otomatis, tidak memverifikasi harga pasar, dan tidak mengirim notifikasi listing. Login tetap dilakukan langsung oleh pengguna di Facebook. Jangan memasukkan kata sandi Facebook ke aplikasi.

APK debug cocok untuk uji coba pribadi; belum ditandatangani sebagai rilis Play Store.
