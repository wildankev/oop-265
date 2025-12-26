import java.util.ArrayList;

public class ManajemenBuku {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Data buku kosong.");
            return;
        }

        for (Buku b : daftarBuku) {
            System.out.println(b);
        }
    }

    public void ubahBuku(int id, String judul, String penulis, int tahun) {
        for (Buku b : daftarBuku) {
            if (b.getId() == id) {
                b.setJudul(judul);
                b.setPenulis(penulis);
                b.setTahun(tahun);
                System.out.println("Data buku berhasil diubah.");
                return;
            }
        }
        System.out.println("ID buku tidak ditemukan.");
    }

    public void hapusBuku(int id) {
        for (Buku b : daftarBuku) {
            if (b.getId() == id) {
                daftarBuku.remove(b);
                System.out.println("Data buku berhasil dihapus.");
                return;
            }
        }
        System.out.println("ID buku tidak ditemukan.");
    }
}