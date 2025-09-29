public class Dosen {
    private String id;
    private String nama;

    public Dosen(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }

    @Override
    public String toString() {
        return nama + " (ID: " + id + ")";
    }
}
