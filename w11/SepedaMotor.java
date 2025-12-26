public class SepedaMotor extends Kendaraan {
    private int kapasitasCC;

    public SepedaMotor(String nama, int hargaSewaPerHari, int kapasitasCC) {
        super(nama, hargaSewaPerHari);
        this.kapasitasCC = kapasitasCC;
    }

    @Override
    public void infoKendaraan() {
        super.infoKendaraan();
        System.out.println("Kapasitas Mesin: " + kapasitasCC + " cc");
    }

    @Override
    public int hitungSewa(int hari) {
        // Tambahan biaya servis Rp20.000 jika sewa lebih dari 5 hari
        int total = super.hitungSewa(hari);
        if (hari > 5) {
            total += 20000;
        }
        return total;
    }
}