public class Transaksi {
    private Kendaraan kendaraan;
    private int lamaSewa;
    private int totalBayar;

    public Transaksi(Kendaraan kendaraan, int lamaSewa) {
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
        this.totalBayar = kendaraan.hitungSewa(lamaSewa);
    }

    public void cetakTransaksi() {
        System.out.println("\n=== DETAIL TRANSAKSI ===");
        kendaraan.infoKendaraan();
        System.out.println("Lama Sewa: " + lamaSewa + " hari");
        System.out.println("Total Bayar: Rp " + totalBayar);
    }
}