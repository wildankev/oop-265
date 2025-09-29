import java.util.ArrayList;

public class Mahasiswa {
    private String nrp;
    private String nama;
    private ArrayList<MataKuliah> daftarMataKuliah;

    public Mahasiswa(String nrp, String nama) {
        this.nrp = nrp;
        this.nama = nama;
        this.daftarMataKuliah = new ArrayList<>();
    }

    public String getNrp() { return nrp; }
    public String getNama() { return nama; }

    private int hitungTotalSKS() {
        int total = 0;
        for (MataKuliah mk : daftarMataKuliah) total += mk.getSks();
        return total;
    }

    public void ambilMataKuliah(MataKuliah mk) {
        if (daftarMataKuliah.contains(mk)) {
            System.out.println("MK sudah diambil: " + mk.getKode());
            return;
        }
        int sksSesudah = hitungTotalSKS() + mk.getSks();
        if (sksSesudah > 21) {
            System.out.println("Gagal ambil: melebihi batas 21 SKS. (Saat ini: " + hitungTotalSKS() + ")");
            return;
        }
        daftarMataKuliah.add(mk);
        System.out.println("Berhasil ambil: " + mk.getNama());
    }

    public void dropMataKuliah(MataKuliah mk) {
        if (daftarMataKuliah.remove(mk)) {
            System.out.println("Berhasil drop: " + mk.getNama());
        } else {
            System.out.println("MK tidak ditemukan di KRS Anda.");
        }
    }

    public void tampilkanMataKuliah() {
        if (daftarMataKuliah.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            System.out.println("Daftar mata kuliah " + nama + " (" + nrp + "):");
            for (MataKuliah mk : daftarMataKuliah) System.out.println("- " + mk);
            System.out.println("Total SKS: " + hitungTotalSKS() + " / 21");
        }
    }
}