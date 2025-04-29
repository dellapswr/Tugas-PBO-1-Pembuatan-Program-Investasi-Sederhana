public class Product {
    private String kode; // Kode unik untuk produk
    private String nama; // Nama produk

    // Konstruktor untuk membuat objek Product dengan validasi input kode dan nama
    public Product(String kode, String nama) {
        // Validasi: Kode produk tidak boleh kosong
        if (kode == null || kode.isEmpty()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        // Validasi: Nama produk tidak boleh kosong
        if (nama == null || nama.isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }

        this.kode = kode;
        this.nama = nama;
    }

    // Getter untuk kode produk
    public String getKode() {
        return kode;
    }

    // Getter untuk nama produk
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
