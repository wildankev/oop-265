import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Seed katalog awal
        ArrayList<Produk> katalog = new ArrayList<>();
        katalog.add(new Produk("Keripik Kentang", "Snack", 12000, 10));
        katalog.add(new Produk("Cokelat Bar", "Snack", 10000, 8));
        katalog.add(new Produk("Biskuit", "Snack", 8000, 12));
        katalog.add(new Produk("Air Mineral", "Minuman", 6000, 15));
        katalog.add(new Produk("Teh Botol", "Minuman", 9000, 10));
        katalog.add(new Produk("Soda", "Minuman", 11000, 7));

        // Controller utama
        MonsterMart app = new MonsterMart(katalog);
        app.mulai();
    }
}
