# Evaluasi Tengah Semester - Pemrograman Berorientasi Objek B

## Deskripsi
Assalamualaikum Warahamatullahi Wabarakatuh, 

Pada Evaluasi Tengah Semester dalam kelas Pemrograman Berorientasi Objek kelas B tanggal 14 Oktober 2025. 
Saya ditugaskan untuk mengimplementasikan pembuatan sistem vending machine `MonsterMart` dengan bahasa `JAVA` dan compiler `BlueJ`.

- Untuk deskripsi dan instruksi tugas dapat diakses melalui link [berikut](https://fajarbaskoro.blogspot.com/2025/10/monster-mart.html)

Aplikasi ini merupakan program **berbasis konsol** berbasis **Object-Oriented Programming (OOP)**. Yang meniru cara kerja mesin penjual otomatis.  
Pengguna dapat memilih produk, menentukan jumlah pembelian, melakukan pembayaran, dan sistem akan menghitung total harga, stok, serta mencatat transaksi.  

## Preview dan penjelasan

### Penjelasan
Untuk project kali ini diperlukan 4 class, yaitu [`Main`](code/Main.java), [`MonsterMart`](code/MonsterMart.java), [`Produk`](code/Prduk.java) dan [`Transaksi](code/Transaksi.java).

### a. Main Class
Kode lengkap dapat diakses [di sini](code/Main.java)

#### Penjelasan Main
Class `Main` berfungsi sebagai **entry point** dari program.  
Di dalamnya dilakukan inisialisasi daftar produk dan pemanggilan class utama `MonsterMart`.

Langkah utama di dalam `Main`:
- Membuat `ArrayList<Produk>` berisi beberapa produk awal (snack dan minuman).
- Membuat objek `MonsterMart` dengan daftar produk tersebut.
- Menjalankan program dengan memanggil method `mulai()`.

### b. MonsterMart Class
Kode lengkap dapat diakses [di sini](code/MonsterMart.java)

#### Penjelasan MonsterMart
Class `MonsterMart` berfungsi sebagai **controller utama** yang menangani seluruh alur logika program.  
Semua interaksi dengan pengguna dilakukan lewat konsol.

Fitur-fitur penting:
- **Menampilkan daftar produk** lengkap dengan harga dan stok.
- **Memproses pembelian**: pengguna memilih produk dan jumlah, kemudian melakukan pembayaran.
- **Mengecek stok otomatis** agar pembelian tidak melebihi ketersediaan barang.
- **Menghitung total harga dan kembalian** setelah pembayaran.
- **Menyimpan log transaksi** menggunakan `ArrayList<Transaksi>`.
- **Menu admin** untuk melakukan refill stok.

Menu program:
1. Pilih nomor produk untuk membeli.  
2. Ketik `99` untuk melihat log transaksi.  
3. Ketik `77` untuk refill stok (mode admin).  
4. Ketik `88` untuk melihat bantuan.  
5. Ketik `0` untuk keluar dari program.---

### c. Produk Class
Kode lengkap dapat diakses [di sini](code/Produk.java)

#### Penjelasan Produk
Class `Produk` berfungsi sebagai **template dari setiap barang** yang dijual dalam Monster Mart.

Atribut:
- `nama` → nama produk (misal: “Keripik Kentang”)  
- `kategori` → jenis produk (Snack / Minuman)  
- `harga` → harga satuan produk  
- `stok` → jumlah stok tersedia  

Fitur:
- Konstruktor untuk inisialisasi produk baru.  
- Getter untuk membaca atribut produk.  
- `kurangiStok()` dan `tambahStok()` untuk memperbarui stok.  
- `toString()` agar data produk ditampilkan dengan format yang mudah dibaca.

Contoh hasil cetak:
```
[Snack] Keripik Kentang - Rp12000 (stok: 10)
```

### d. Transaksi Class
Kode lengkap dapat diakses [di sini](code/Transaksi.java)

#### Penjelasan Transaksi
Class `Transaksi` digunakan untuk **mencatat seluruh pembelian** yang terjadi di Monster Mart.

Atribut:
- `produk` → nama produk yang dibeli  
- `qty` → jumlah pembelian  
- `totalHarga` → total harga dari pembelian  
- `waktu` → waktu transaksi (menggunakan `LocalDateTime`)

`toString()` akan menampilkan ringkasan transaksi seperti berikut:
```
2025-10-14T12:45:32 | Teh Botol x2 | Total: Rp18000
```


## Cara Menjalankan Program di BlueJ

1. Buka **BlueJ**, buat project baru bernama `MonsterMart`.
2. Tambahkan empat class berikut:
   - `Main`
   - `MonsterMart`
   - `Produk`
   - `Transaksi`
3. Salin kode ke masing-masing class.
4. Klik **Compile** hingga tidak ada error.
5. Klik kanan pada class `Main`, pilih **void main(String[] args)**, lalu tekan **OK**.
6. Program akan menampilkan tampilan seperti berikut:
<img width="719" height="687" alt="image" src="https://github.com/user-attachments/assets/60a23333-ed8f-4ccc-b2e1-12de33b14971" />


### Preview

a. Tampilan di `BlueJ`
<img width="1919" height="1078" alt="image" src="https://github.com/user-attachments/assets/10778176-960b-46e0-b58e-ce02654535df" />

b. Proses pembelian produk
<img width="1483" height="998" alt="image" src="https://github.com/user-attachments/assets/82832e3d-7b0d-4950-9427-1fe7992f4765" />

c. Log transaksi yang tersimpan
<img width="860" height="577" alt="image" src="https://github.com/user-attachments/assets/17174766-e9e8-447c-a56d-fb9b249ff6c8" />

---

## Identitas
- **Nama**   : A. Wildan Kevin Assyauqi  
- **NRP**    : 5025241265  
- **Kelas**  : Pemrograman Berorientasi Objek - B
