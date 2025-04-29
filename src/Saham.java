public class Saham extends Product {
    private double harga; // harga per lembar

    public Saham(String kode, String nama, double harga) {
        super(kode, nama); // harus dua parameter
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga saham harus lebih besar dari 0.");
        }
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga saham harus lebih besar dari 0.");
        }
        this.harga = harga;
    }

    public double getHargaPerLot() {
        return harga * 100;
    }
}
