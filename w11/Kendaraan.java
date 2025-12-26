public class Kendaraan {
    protected String nama;
    protected int hargaSewaPerHari;

    public Kendaraan(String nama, int hargaSewaPerHari) {
        this.nama = nama;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public void infoKendaraan() {
        System.out.println("Nama Kendaraan: " + nama);
        System.out.println("Harga Sewa per Hari: Rp " + hargaSewaPerHari);
    }

    // Polymorphism: bisa dioverride di subclass
    public int hitungSewa(int hari) {
        return hargaSewaPerHari * hari;
    }

    public String getNama() {
        return nama;
    }
}