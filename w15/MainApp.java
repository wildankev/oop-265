import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManajemenBuku manager = new ManajemenBuku();
        boolean jalan = true;

        while (jalan) {
            System.out.println("\n=== MENU DATA BUKU ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Buku");
            System.out.println("3. Ubah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> {
                    System.out.print("ID Buku: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Judul: ");
                    String judul = input.nextLine();
                    System.out.print("Penulis: ");
                    String penulis = input.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int tahun = input.nextInt();

                    manager.tambahBuku(new Buku(id, judul, penulis, tahun));
                    System.out.println("Buku berhasil ditambahkan.");
                }
                case 2 -> manager.tampilBuku();
                case 3 -> {
                    System.out.print("ID Buku: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Judul baru: ");
                    String judul = input.nextLine();
                    System.out.print("Penulis baru: ");
                    String penulis = input.nextLine();
                    System.out.print("Tahun baru: ");
                    int tahun = input.nextInt();

                    manager.ubahBuku(id, judul, penulis, tahun);
                }
                case 4 -> {
                    System.out.print("ID Buku: ");
                    int id = input.nextInt();
                    manager.hapusBuku(id);
                }
                case 5 -> jalan = false;
                default -> System.out.println("Menu tidak valid.");
            }
        }

        System.out.println("Program selesai.");
    }
}