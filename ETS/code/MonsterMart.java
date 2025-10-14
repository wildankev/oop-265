import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class MonsterMart {
    private ArrayList<Produk> daftarProduk;
    private ArrayList<Transaksi> logTransaksi;
    private Scanner sc;

    public MonsterMart(ArrayList<Produk> daftarProduk) {
        this.daftarProduk = daftarProduk;
        this.logTransaksi = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void mulai() {
        tampilkanHeader();
        tampilkanBantuan();
        while (true) {
            tampilkanStokRingkas();
            tampilkanMenuProduk();

            System.out.print("Pilih nomor (0=keluar, 99=log, 77=refill, 88=bantuan): ");
            int pilih = bacaIntAman();

            if (pilih == 0) {
                System.out.println("\nTerima kasih telah berbelanja di Monster Mart!");
                tampilkanLog();
                System.out.println("Sampai jumpa.\n");
                break;
            } else if (pilih == 88) {
                tampilkanBantuan();
                continue;
            } else if (pilih == 99) {
                tampilkanLog();
                continue;
            } else if (pilih == 77) {
                prosesRefillAdmin();
                continue;
            }

            Produk p = ambilProdukByNomor(pilih);
            if (p == null) {
                System.out.println("Nomor produk tidak valid.\n");
                continue;
            }
            prosesBeli(p);
        }
    }

    private void prosesBeli(Produk p) {
        System.out.println("\nAnda memilih: " + p.getNama() + " [Rp" + p.getHarga() + "] (stok: " + p.getStok() + ")");
        System.out.print("Jumlah yang dibeli: ");
        int qty = bacaIntAman();
        if (qty <= 0) {
            System.out.println("Jumlah harus lebih dari 0.\n");
            return;
        }

        if (p.getStok() < qty) {
            System.out.println("Maaf, stok tidak mencukupi. Stok tersedia: " + p.getStok() + "\n");
            return;
        }

        int totalHarga = p.getHarga() * qty;
        System.out.println("Total harga: Rp" + totalHarga);

        int bayar = mintaPembayaran(totalHarga);
        if (bayar < 0) {
            System.out.println("Transaksi dibatalkan.\n");
            return;
        }

        p.kurangiStok(qty);
        int kembalian = bayar - totalHarga;
        System.out.println("Pembelian berhasil. Kembalian: Rp" + kembalian);
        System.out.println("Produk dikeluarkan: " + p.getNama() + " x" + qty + "\n");

        logTransaksi.add(new Transaksi(p.getNama(), qty, totalHarga, LocalDateTime.now()));
    }

    private int mintaPembayaran(int totalHarga) {
        while (true) {
            System.out.print("Masukkan uang (rupiah) atau -1 untuk batal: ");
            int bayar = bacaIntAman();
            if (bayar == -1) return -1;
            if (bayar < totalHarga) {
                System.out.println("Uang kurang. Perlu: Rp" + totalHarga + ", Anda: Rp" + bayar + ".");
                continue;
            }
            return bayar;
        }
    }

    private void prosesRefillAdmin() {
        System.out.println("\n=== Menu Admin: Refill Stok ===");
        tampilkanMenuProduk();
        System.out.print("Pilih nomor produk untuk di-refill (0=batal): ");
        int pilih = bacaIntAman();
        if (pilih == 0) {
            System.out.println("Batal refill.\n");
            return;
        }
        Produk p = ambilProdukByNomor(pilih);
        if (p == null) {
            System.out.println("Nomor produk tidak valid.\n");
            return;
        }
        System.out.print("Tambah stok sebanyak: ");
        int tambah = bacaIntAman();
        if (tambah <= 0) {
            System.out.println("Jumlah refill harus > 0.\n");
            return;
        }
        p.tambahStok(tambah);
        System.out.println("Stok " + p.getNama() + " sekarang: " + p.getStok() + "\n");
    }

    private void tampilkanHeader() {
        System.out.println("=================================");
        System.out.println("           MONSTER MART          ");
        System.out.println("     Snack & Minuman Otomatis    ");
        System.out.println("=================================\n");
    }

    private void tampilkanBantuan() {
        System.out.println("Perintah:");
        System.out.println("- Pilih nomor produk untuk membeli");
        System.out.println("- 99 untuk melihat log transaksi");
        System.out.println("- 77 untuk refill stok (admin)");
        System.out.println("- 88 untuk menampilkan bantuan");
        System.out.println("- 0 untuk keluar\n");
    }

    private void tampilkanMenuProduk() {
        System.out.println("--- Daftar Produk ---");
        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk p = daftarProduk.get(i);
            System.out.printf("%d) [%s] %s - Rp%d (stok: %d)%n",
                    (i + 1), p.getKategori(), p.getNama(), p.getHarga(), p.getStok());
        }
        System.out.println("---------------------");
    }

    private void tampilkanStokRingkas() {
        int snack = 0, minuman = 0;
        for (Produk p : daftarProduk) {
            if ("Snack".equalsIgnoreCase(p.getKategori())) snack += p.getStok();
            else if ("Minuman".equalsIgnoreCase(p.getKategori())) minuman += p.getStok();
        }
        System.out.println("[Status Stok] Snack: " + snack + " | Minuman: " + minuman);
    }

    private Produk ambilProdukByNomor(int nomor) {
        int idx = nomor - 1;
        if (idx < 0 || idx >= daftarProduk.size()) return null;
        return daftarProduk.get(idx);
    }

    private void tampilkanLog() {
        if (logTransaksi.isEmpty()) {
            System.out.println("\n[Log Transaksi] (kosong)\n");
            return;
        }
        System.out.println("\n=== Log Transaksi ===");
        for (Transaksi t : logTransaksi) {
            System.out.println(t);
        }
        System.out.println("=====================\n");
    }

    private int bacaIntAman() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Masukan angka yang valid: ");
            }
        }
    }
}