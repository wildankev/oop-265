// Responder.java
import java.util.*;

public class Responder {
    private final Map<String, String> responseMap = new LinkedHashMap<>();
    private final List<String> defaultResponses = new ArrayList<>();
    private final Random random = new Random();

    public Responder() {
        fillResponses();
        fillDefaults();
    }

    /** Menerima input mentah dan mencocokkan berbasis substring (case-insensitive) */
    public String generateResponse(String rawInput) {
        if (rawInput == null || rawInput.isBlank()) {
            return pickDefault();
        }
        String input = rawInput.toLowerCase(Locale.ROOT);

        for (Map.Entry<String, String> e : responseMap.entrySet()) {
            if (input.contains(e.getKey())) {
                return e.getValue();
            }
        }
        return pickDefault();
    }


    private String pickDefault() {
        return defaultResponses.get(random.nextInt(defaultResponses.size()));
    }

    private void putAll(String[] keys, String value) {
        for (String k : keys) responseMap.put(k, value);
    }

    private void fillDefaults() {
        defaultResponses.add("Maaf, saya kurang memahami masalah Anda. Bisakah Anda jelaskan lebih detail?");
        defaultResponses.add("Silakan jelaskan masalah Anda dengan lebih spesifik.");
        defaultResponses.add("Pastikan koneksi internet Anda stabil lalu coba lagi.");
        defaultResponses.add("Apakah Anda sudah mencoba logout lalu login ulang?");
        defaultResponses.add("Coba jelaskan situasinya dari awal agar saya bisa memberikan solusi yang tepat.");
    }

    private void fillResponses() {
        putAll(new String[]{"krs", "frs"},
                "Untuk KRS/FRS, pastikan syarat pembayaran UKT sudah terpenuhi dan tidak ada tunggakan. Periode pengisian dibuka awal semester. Cek portal akademik atau koordinasikan dengan dosen wali.");

        responseMap.put("nilai",
                "Jika ada masalah nilai, ajukan sanggahan maksimal 2 minggu setelah diumumkan. Hubungi dosen pengampu atau koordinator program studi.");

        putAll(new String[]{"wali", "dosen wali"},
                "Untuk konsultasi dengan dosen wali, buat janji via email atau datang pada jam konsultasi. Dosen wali membantu perwalian KRS dan isu akademik.");

        responseMap.put("jadwal bentrok",
                "Kelas ini bentrok dengan jadwal lain. Silakan pilih sesi/hari berbeda atau konsultasikan penyesuaian ke dosen wali/bagian akademik.");
        responseMap.put("jadwal",
                "Jadwal kuliah dapat dilihat di portal akademik. Jika ada bentrok saat KRS, segera koordinasikan dengan dosen wali atau bagian akademik.");

        responseMap.put("cuti",
                "Cuti akademik: isi formulir, butuh persetujuan dosen wali dan orang tua/wali. Maksimal 2 semester dan tetap terhitung masa studi. Prosedur lengkap di bagian akademik.");

        responseMap.put("sks melebihi",
                "Jumlah SKS yang Anda ambil melebihi batas semester ini. Kurangi mata kuliah agar sesuai aturan.");
        responseMap.put("ipk rendah",
                "IPK Anda belum memenuhi syarat untuk mengambil SKS yang diminta. Pertimbangkan pengurangan beban studi dan konsultasikan ke dosen wali.");
        responseMap.put("sks",
                "Beban SKS mengikuti IPS sebelumnya: IPS ≥ 3.00 boleh 24 SKS; 2.50–2.99 boleh 21 SKS; < 2.50 maksimal 18 SKS. Semester 1 umumnya maksimal 20–21 SKS.");

        putAll(new String[]{"ukt", "pembayaran", "belum bayar"},
                "Untuk pembayaran UKT, hubungi bagian keuangan/BAAK dan lakukan sesuai jadwal agar terhindar denda. Jika ada kendala finansial, ajukan keringanan sesuai prosedur.");

        putAll(new String[]{"skripsi", "tugas akhir", "ta", "tugas"},
                "Untuk mengambil skripsi/TA, pastikan syarat minimal SKS dan ketentuan IPK terpenuhi. Konsultasikan dengan koordinator TA dan tentukan dosen pembimbing.");

        responseMap.put("wisuda",
                "Syarat wisuda: lulus sidang akhir, administrasi selesai, tidak ada tunggakan, dan mendaftar sesuai periode. Cek pengumuman resmi kampus/bagian akademik.");

        putAll(new String[]{"absensi", "presensi", "kehadiran"},
                "Minimal kehadiran 80% untuk berhak ujian. Jika berhalangan karena sakit/alasan penting, segera informasikan ke dosen pengampu dan lampirkan bukti.");

        responseMap.put("kelas penuh",
                "Kelas yang Anda pilih sudah penuh. Cari kelas lain atau hubungi dosen pengampu untuk kemungkinan penambahan kuota.");
        responseMap.put("prasyarat",
                "Anda belum memenuhi prasyarat mata kuliah. Pastikan sudah lulus mata kuliah pendukungnya.");
        responseMap.put("nrp salah",
                "NRP tidak valid. Periksa kembali format dan panjang NRP sesuai ketentuan.");
        responseMap.put("kelas tidak tersedia",
                "Kelas tersebut tidak ditawarkan semester ini. Periksa daftar mata kuliah aktif di sistem.");
        responseMap.put("kelas tersedia tidak penuh",
                "Kelas belum penuh, namun pendaftaran gagal karena bentrok jadwal atau prasyarat belum terpenuhi.");
        responseMap.put("nama kelas tidak ditemukan",
                "Nama/kode kelas tidak dikenali. Pastikan ejaan dan kode sesuai data akademik.");
        responseMap.put("sistem error",
                "Server FRS mengalami gangguan sementara. Coba lagi beberapa saat kemudian.");
        responseMap.put("server sibuk",
                "Server sedang sibuk karena banyak pengguna. Mohon coba kembali beberapa menit lagi.");
        responseMap.put("mata kuliah sudah diambil",
                "Mata kuliah ini sudah pernah Anda ambil. Hanya dapat diulang apabila statusnya 'mengulang'.");
        responseMap.put("masa frs berakhir",
                "Periode pengisian FRS telah berakhir. Hubungi bagian akademik untuk opsi perpanjangan.");
        responseMap.put("akses ditolak",
                "Akses ditolak. Pastikan akun Anda aktif sebagai mahasiswa dan memiliki hak akses fitur terkait.");
    }
}