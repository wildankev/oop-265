import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Classroom.initData();

        Mahasiswa user = null;
        while (user == null) {
            System.out.println("\n=== Sistem FRS ===");
            System.out.println("1. Login");
            System.out.println("2. Registrasi Mahasiswa Baru");
            System.out.println("3. Exit");
            System.out.print("Pilih: ");
            int pilihAwal = safeInt(sc);

            if (pilihAwal == 1) {
                System.out.print("Masukkan NRP: ");
                String nrp = sc.nextLine().trim();
                user = Classroom.login(nrp);
                System.out.println(user == null ? "Mahasiswa tidak ditemukan!" : "Selamat datang, " + user.getNama());
            } else if (pilihAwal == 2) {
                System.out.print("NRP baru: ");
                String nrpBaru = sc.nextLine().trim();
                System.out.print("Nama: ");
                String namaBaru = sc.nextLine().trim();
                if (Classroom.login(nrpBaru) != null) {
                    System.out.println("Sudah terdaftar, silakan login.");
                } else {
                    Classroom.daftarMahasiswa.add(new Mahasiswa(nrpBaru, namaBaru));
                    System.out.println("Registrasi berhasil. Silakan login: " + nrpBaru);
                }
            } else if (pilihAwal == 3) {
                System.out.println("Keluar.");
                return;
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        int pilihan;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Informasi Mata Kuliah (KRS)");
            System.out.println("2. Ambil Mata Kuliah");
            System.out.println("3. Drop Mata Kuliah");
            System.out.println("4. Exit");
            System.out.print("Pilih: ");
            pilihan = safeInt(sc);

            if (pilihan == 1) {
                user.tampilkanMataKuliah();
            } else if (pilihan == 2) {
                System.out.println("Daftar MK tersedia:");
                for (int i = 0; i < Classroom.daftarMataKuliah.size(); i++) {
                    System.out.println((i + 1) + ". " + Classroom.daftarMataKuliah.get(i));
                }
                System.out.print("Pilih nomor MK: ");
                int idx = safeInt(sc);
                if (idx >= 1 && idx <= Classroom.daftarMataKuliah.size()) {
                    user.ambilMataKuliah(Classroom.daftarMataKuliah.get(idx - 1));
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } else if (pilihan == 3) {
                user.tampilkanMataKuliah();
                System.out.print("Masukkan KODE MK untuk drop: ");
                String kode = sc.nextLine().trim();
                MataKuliah target = null;
                for (MataKuliah mk : Classroom.daftarMataKuliah) {
                    if (mk.getKode().equalsIgnoreCase(kode)) { target = mk; break; }
                }
                if (target != null) user.dropMataKuliah(target);
                else System.out.println("MK tidak ditemukan.");
            } else if (pilihan == 4) {
                System.out.println("Selesai. Terima kasih!");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }

    private static int safeInt(Scanner sc) {
        while (!sc.hasNextInt()) { sc.nextLine(); System.out.print("Masukkan angka: "); }
        int x = sc.nextInt(); sc.nextLine(); return x;
    }
}