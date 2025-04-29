public class Product {
    private String kode;
    private String nama;

    public Product(String kode, String nama) {
        if (kode == null || kode.isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        if (nama == null || nama.isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }

        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    // Setter untuk kode produk
    public void setKode(String kode) {
        if (kode == null || kode.isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        this.kode = kode;
    }

    // Setter untuk nama produk
    public void setNama(String nama) {
        if (nama == null || nama.isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        this.nama = nama;
    }
}
