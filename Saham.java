class Saham {
    String kode, namaPerusahaan;
    double harga;

    public Saham(String kode, String nama, double harga) {
        this.kode = kode;
        this.namaPerusahaan = nama;
        this.harga = harga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Saham)) return false;
        Saham s = (Saham) o;
        return kode.equals(s.kode);
    }

    @Override
    public int hashCode() {
        return kode.hashCode();
    }
}