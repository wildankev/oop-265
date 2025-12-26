public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String nama, int hargaSewaPerHari, int jumlahKursi) {
        super(nama, hargaSewaPerHari);
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public void infoKendaraan() {
        super.infoKendaraan();
        System.out.println("Jumlah Kursi: " + jumlahKursi);
    }

    @Override
    public int hitungSewa(int hari) {
        // Tambah biaya sopir Rp100.000 per hari jika jumlah kursi > 5
        int total = super.hitungSewa(hari);
        if (jumlahKursi > 5) {
            total += 100000 * hari;
        }
        return total;
    }
}