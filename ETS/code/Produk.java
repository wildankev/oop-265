public class Produk {
    private String nama;
    private String kategori; // "Snack" atau "Minuman"
    private int harga;
    private int stok;

    public Produk(String nama, String kategori, int harga, int stok) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() { return nama; }
    public String getKategori() { return kategori; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }

    public void kurangiStok(int qty) {
        if (qty <= 0) return;
        if (stok >= qty) stok -= qty;
    }

    public void tambahStok(int qty) {
        if (qty > 0) stok += qty;
    }

    @Override
    public String toString() {
        return "[" + kategori + "] " + nama + " - Rp" + harga + " (stok: " + stok + ")";
    }
}