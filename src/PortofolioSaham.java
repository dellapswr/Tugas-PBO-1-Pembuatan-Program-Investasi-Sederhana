public class PortofolioSaham {
    Saham saham;
    int jumlah;
    double hargaBeli;

    public PortofolioSaham(Saham saham, int jumlah, double hargaBeli) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah saham harus lebih besar dari 0.");
        }
        if (hargaBeli <= 0) {
            throw new IllegalArgumentException("Harga beli saham harus lebih besar dari 0.");
        }

        this.saham = saham;
        this.jumlah = jumlah;
        this.hargaBeli = hargaBeli;
    }

    // Method untuk menghitung total nilai portofolio saham berdasarkan harga beli dan jumlah
    public double hitungNilai() {
        return jumlah * hargaBeli;
    }

    // Getter untuk saham
    public Saham getSaham() {
        return saham;
    }

    // Getter untuk jumlah saham
    public int getJumlah() {
        return jumlah;
    }

    // Getter untuk harga beli saham
    public double getHargaBeli() {
        return hargaBeli;
    }

    // Setter untuk jumlah saham
    public void setJumlah(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah saham harus lebih besar dari 0.");
        }
        this.jumlah = jumlah;
    }

    // Setter untuk harga beli saham
    public void setHargaBeli(double hargaBeli) {
        if (hargaBeli <= 0) {
            throw new IllegalArgumentException("Harga beli saham harus lebih besar dari 0.");
        }
        this.hargaBeli = hargaBeli;
    }
}
