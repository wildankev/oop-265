import java.util.ArrayList;

public class Classroom {
    public static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    public static ArrayList<Dosen> daftarDosen = new ArrayList<>();
    public static ArrayList<MataKuliah> daftarMataKuliah = new ArrayList<>();

    public static void initData() {
        Dosen d1 = new Dosen("D001", "Ainun Kusnul Khotimah, S.Si., M.Mat.");
        Dosen d2 = new Dosen("D002", "Dini Adni Navastara, S.Kom., M.Sc.");
        Dosen d3 = new Dosen("D003", "Baskoro Adi Pratomo, S.Kom., M.Kom., Ph.D.");
        Dosen d4 = new Dosen("D004", "Fajar Baskoro, S.Kom., M.T.");
        Dosen d5 = new Dosen("D005", "Muhammad Hilmil Muchtar Aditya Pradana, S.Kom., M.Sc., Ph.D.");

        daftarDosen.add(d1); daftarDosen.add(d2); daftarDosen.add(d3); daftarDosen.add(d4); daftarDosen.add(d5);

        daftarMataKuliah.add(new MataKuliah("Kalk49",   "Kalkulus 2",                     3, d1));
        daftarMataKuliah.add(new MataKuliah("KKAE",  "Konsep Kecerdasan Artifisial",   3, d2));
        daftarMataKuliah.add(new MataKuliah("JKA",   "Jaringan Komputer",              4, d3));
        daftarMataKuliah.add(new MataKuliah("PBOB",  "Pemrograman Berbasis Objek",     3, d4));
        daftarMataKuliah.add(new MataKuliah("PWEBB", "Pemrograman Web",                3, d4));
        daftarMataKuliah.add(new MataKuliah("MDB", "Matematika Diskrit",                3, d5));

        daftarMahasiswa.add(new Mahasiswa("5025241265", "A. Wildan Kevin Assyauqi"));
    }

    public static Mahasiswa login(String nrp) {
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getNrp().equals(nrp)) return m;
        }
        return null;
    }
}