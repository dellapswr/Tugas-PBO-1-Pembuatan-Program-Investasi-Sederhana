public class Saham extends Product {
    private double harga; // harga per lembar

    public Saham(String kode, String nama, double harga) {
        super(kode, nama); // ✅ Ini dia! harus dua parameter
        this.harga = harga;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getHargaPerLot() {
        return harga * 100;
    }
}
