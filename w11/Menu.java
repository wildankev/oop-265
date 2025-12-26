import java.util.Scanner;

public class Menu {
    private Kendaraan[] daftarKendaraan;

    public Menu() {
        daftarKendaraan = new Kendaraan[] {
                new Sepeda("Sepeda Polygon", 50000, true),
                new SepedahMotor("Honda Vario", 100000, 125),
                new Mobil("Toyota Avanza", 300000, 7)
        };
    }

    public void tampilkanMenu() {
        System.out.println("=== MENU KENDARAAN ===");
        for (int i = 0; i < daftarKendaraan.length; i++) {
            System.out.println((i + 1) + ". " + daftarKendaraan[i].getNama());
        }
    }

    public Kendaraan pilihKendaraan(int pilihan) {
        if (pilihan > 0 && pilihan <= daftarKendaraan.length) {
            return daftarKendaraan[pilihan - 1];
        }
        return null;
    }
}