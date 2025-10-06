# Tugas 6 - Pemrograman Berorientasi Objek B

## Deskripsi
Assalamualaikum Warahamatullahi Wabarakatuh, 

Pada kuliah pertemuan keenam dalam kelas Pemrograman Berorientasi Objek kelas B tanggal 30 September 2025. 
Saya ditugaskan untuk mengimplementasikan pembuaatan grouping sederhana dengan bahasa `JAVA` dan compiler `BlueJ`. Di mana saya ditugaskan untuk meembuat `semacam task organizer`

- untuk materi dapat diakses melalui link [berikut](https://fajarbaskoro.blogspot.com/2025/09/latihan-groupint-object.html)
- referensi dapat diakses melalui link [berikut](https://drive.google.com/file/d/1no2zBqxF7NMQcoSl-wuLF9JrS3-0-rqe/view)


Program ini merupakan aplikasi konsol sederhana berbasis **Object-Oriented Programming (OOP)** untuk mengelola daftar tugas pribadi.  
Pengguna dapat menambahkan, melihat, dan menghapus tugas melalui menu interaktif di terminal.  
Struktur program dibagi menjadi dua class: `Task` dan `Organizer`.

## Preview dan penjelasan

### Penjelasan
Untuk project kali ini diperlukan 2 class, yaitu [`Task`](Task.java), dan [`Organizer`](Organizer.java).

### a. Task Class
untuk kode dari `Task` class dapat diakses [di sini](Task.java)

#### Penjelasan Task
Class `Task` berfungsi sebagai **template** untuk satu tugas.  
Setiap tugas memiliki dua atribut utama:
- `title`: judul tugas
- `description`: deskripsi tugas

Fitur-fitur dalam class ini:
- **Konstruktor** digunakan untuk menginisialisasi objek tugas baru saat dibuat.
- **Getter** (`getTitle`, `getDescription`) memberikan akses membaca data tugas.
- **Method toString()** menentukan bagaimana objek ditampilkan dalam teks agar mudah dibaca saat ditampilkan ke terminal.

Contoh hasil cetak objek `Task`:
```
Judul: Belajar Java | Deskripsi: Kerjakan latihan ArrayList
```

### b. Organizer Class
untuk kode dari `Organizer` class dapat diakses [di sini](Organizer.java)

#### Penjelasan Organizer
Class `Organizer` merupakan **class utama** yang berfungsi menjalankan program.  
Semua interaksi dengan pengguna dilakukan melalui menu berbasis teks.

Bagian penting:
- `ArrayList<Task>` menyimpan seluruh daftar tugas secara dinamis.
- `Scanner` digunakan untuk menerima input dari pengguna.
- Struktur **do-while** memastikan menu tetap muncul hingga pengguna memilih keluar.

Menu program:
1. **Tambah Tugas** → membuat objek `Task` baru dan menambahkannya ke daftar.
2. **Lihat Semua Tugas** → menampilkan seluruh tugas dalam daftar.
3. **Hapus Tugas** → menghapus tugas berdasarkan nomor urut.
4. **Keluar** → menghentikan program.

Validasi input memastikan agar nomor tugas yang dimasukkan benar-benar ada dalam daftar.

---

### Cara Menjalankan Program di BlueJ

1. Buka **BlueJ**, buat project baru bernama `PersonalOrganizer`.
2. Tambahkan dua class:
   - `Task`
   - `Organizer`
3. Salin kode sesuai yang ada di file ke masing-masing class.
4. Compile kedua class hingga tidak ada error.
5. Klik kanan pada class `Organizer`, pilih **void main(String[] args)**, lalu tekan **OK** untuk menjalankan program.
6. Program akan menampilkan menu utama di terminal BlueJ seperti berikut:

```
=== Personal Organizer ===
1. Tambah Tugas
2. Lihat Semua Tugas
3. Hapus Tugas
4. Keluar
Pilih menu:
```

### Preview

a. Tampilan di `BlueJ`
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/f0f34aa0-ba98-4072-b9cb-277aae5d6f5d" />

b. Pengguna menambahkan tugas
<img width="914" height="649" alt="image" src="https://github.com/user-attachments/assets/4a93cb8c-d1a1-43a2-98dc-c86558ff46c8" />

c. Pengguna melihat dan menghapus tugas
<img width="1919" height="951" alt="image" src="https://github.com/user-attachments/assets/63d2cd93-52f7-4dc3-aa00-3be16cd97cb1" />

## Kesimpulan

Program ini menerapkan beberapa konsep dasar OOP, yaitu:
- **Encapsulation** melalui penggunaan atribut `private` dan akses dengan method `getter`.
- **Instantiation** dengan membuat objek `Task` baru menggunakan konstruktor.
- **Modularisasi** dengan memisahkan logika program ke dalam dua class berbeda.
- **Dynamic Data Management** menggunakan `ArrayList` untuk menyimpan objek secara fleksibel.

---

## Identitas
- **Nama**   : A. Wildan Kevin Assyauqi  
- **NRP**    : 5025241265  
- **Kelas**  : Pemrograman Berorientasi Objek - B
