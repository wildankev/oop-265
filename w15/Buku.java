public class Buku {
    private int id;
    private String judul;
    private String penulis;
    private int tahun;

    public Buku(int id, String judul, String penulis, int tahun) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    public int getId() {
        return id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    @Override
    public String toString() {
        return id + " | " + judul + " | " + penulis + " | " + tahun;
    }
}