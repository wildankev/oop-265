public class Sepeda extends Kendaraan {
    private boolean adaHelm;

    public Sepeda(String nama, int hargaSewaPerHari, boolean adaHelm) {
        super(nama, hargaSewaPerHari);
        this.adaHelm = adaHelm;
    }

    @Override
    public void infoKendaraan() {
        super.infoKendaraan();
        System.out.println("Fasilitas Helm: " + (adaHelm ? "Ada" : "Tidak Ada"));
    }

    @Override
    public int hitungSewa(int hari) {
        // Diskon 10% untuk sewa lebih dari 3 hari
        int total = super.hitungSewa(hari);
        if (hari > 3) {
            total *= 0.9;
        }
        return total;
    }
}