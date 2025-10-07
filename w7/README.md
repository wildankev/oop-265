# Tugas 6 - Pemrograman Berorientasi Objek B

## Deskripsi
Assalamualaikum Warahamatullahi Wabarakatuh, 

Pada kuliah pertemuan keenam dalam kelas Pemrograman Berorientasi Objek kelas B tanggal 30 September 2025. 
Saya ditugaskan untuk mengimplementasikan pembuaatan grouping sederhana dengan bahasa `JAVA` dan compiler `BlueJ`. Di mana saya ditugaskan untuk meembuat `semacam task organizer`

- untuk materi dapat diakses melalui link [berikut](https://fajarbaskoro.blogspot.com/2025/10/moresophisticated-behavior.html)

Program ini merupakan aplikasi konsol sederhana berbasis **Object-Oriented Programming (OOP)** untuk penanganan masalaha technical support sederhana terutama pada perkuliahan.  
Pengguna dapat memasukkan pertanyaan yang dipermasalahkan, lalu program akan membaca kata kunci dari permsalahan tersebut dan menampilkan jawaban yang relevan.
Struktur program dibagi menjadi tiga class, yaitu: `SupportSystem`, `InputReader` dan `Responder`.

## Preview dan penjelasan

### Penjelasan
Untuk project kali ini diperlukan 3 class, yaitu [`SupoortSystem`](SupportSystem.java), [`InputReader`](InputReader.java), dan [`Responder`](Responder.java) 

### a. InputReader Class
untuk kode dari `InputReader` class dapat diakses [di sini](InputReader.java)

#### Penjelasan InputReader
Class `InputReader` berfungsi untuk membaca input teks dari pengguna.  
- Menggunakan `Scanner` untuk membaca baris teks dari terminal.  
- Method `getInput()` menampilkan simbol `>` sebagai prompt input dan mengembalikan hasil input dalam huruf kecil.  
- Class ini membantu pemisahan tanggung jawab agar pengelolaan input tidak tercampur dengan logika utama program.

### b. Responder Class
untuk kode dari `Responder` class dapat diakses [di sini](Responder.java)

#### Penjelasan Responder 
`Responder` bertugas menghasilkan respon otomatis berdasarkan isi input pengguna.  
- Menggunakan `HashMap` untuk menyimpan pasangan kata kunci dan respon.  
- Method `fillResponses()` mengisi daftar respon awal.  
- Method `generateResponse()` akan mencari kata kunci di input, dan jika cocok, mengembalikan respon yang relevan.  
- Jika tidak ada kata kunci yang cocok, sistem akan memilih respon acak dari daftar default.

### c. SystemSupport Class
untuk kode dari `SystemSupport` class dapat diakses [di sini](SystemSupport.java)

#### Penjelasan SystemSupport
Class `SystemSupport` merupakan pusat kendali program.  
- Membuat objek `InputReader` dan `Responder`.  
- Menampilkan pesan pembuka, lalu terus membaca input hingga pengguna mengetik `bye`.  
- Setiap input dikirim ke `Responder` untuk diproses dan menghasilkan jawaban yang sesuai.  
- Setelah pengguna keluar, program menampilkan pesan penutup.

### Cara Menjalankan Program di BlueJ

1. Buka **BlueJ**, buat project baru bernama `TechSupport`.
2. Tambahkan tiga file:
   - `InputReader.java`
   - `Responder.java`
   - `SystemSupport.java`
3. Salin kode dari masing-masing class sesuai penjelasan di atas.
4. Klik **Compile** untuk memastikan semua class bebas error.
5. Jalankan program dengan klik kanan pada `SystemSupport` → **void main(String[] args)** → tekan **OK**.


### Preview

a. Tampilan di `BlueJ`
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/a802ef6f-c745-412f-9d6a-0ad333b34167" />

b. Pengguna memasukkan kata kunci Tech Support
<img width="1919" height="345" alt="image" src="https://github.com/user-attachments/assets/b96cd666-4c5c-4cc4-b7c8-989585b0fa56" />

Untuk kataa kunci lengkap dapat dilihat [di sini](Responder.java)

---

## Identitas
- **Nama**   : A. Wildan Kevin Assyauqi  
- **NRP**    : 5025241265  
- **Kelas**  : Pemrograman Berorientasi Objek - B
