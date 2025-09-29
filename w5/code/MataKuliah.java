public class MataKuliah {
    private String kode;
    private String nama;
    private int sks;
    private Dosen dosenPengampu;

    public MataKuliah(String kode, String nama, int sks, Dosen dosen) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.dosenPengampu = dosen;
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getSks() { return sks; }
    public Dosen getDosenPengampu() { return dosenPengampu; }

    @Override
    public String toString() {
        return kode + " - " + nama + " (" + sks + " SKS, " + dosenPengampu.getNama() + ")";
    }

    // Penting agar ArrayList.contains() di Mahasiswa bekerja berdasar KODE MK
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MataKuliah)) return false;
        MataKuliah mk = (MataKuliah) o;
        return kode != null && kode.equalsIgnoreCase(mk.kode);
    }

    @Override
    public int hashCode() {
        return kode == null ? 0 : kode.toLowerCase().hashCode();
    }
}
