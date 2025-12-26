import java.util.Scanner;

public class SewaKendaraan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();

        menu.tampilkanMenu();
        System.out.print("Pilih kendaraan (1-3): ");
        int pilihan = input.nextInt();

        Kendaraan kendaraan = menu.pilihKendaraan(pilihan);
        if (kendaraan == null) {
            System.out.println("Pilihan tidak valid!");
            return;
        }

        System.out.print("Masukkan lama sewa (hari): ");
        int lama = input.nextInt();

        Transaksi trx = new Transaksi(kendaraan, lama);
        trx.cetakTransaksi();
    }
}