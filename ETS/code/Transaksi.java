import java.time.LocalDateTime;

public class Transaksi {
    private String produk;
    private int qty;
    private int totalHarga;
    private LocalDateTime waktu;

    public Transaksi(String produk, int qty, int totalHarga, LocalDateTime waktu) {
        this.produk = produk;
        this.qty = qty;
        this.totalHarga = totalHarga;
        this.waktu = waktu;
    }

    @Override
    public String toString() {
        return String.format("%s | %s x%d | Total: Rp%d",
                waktu, produk, qty, totalHarga);
    }
}