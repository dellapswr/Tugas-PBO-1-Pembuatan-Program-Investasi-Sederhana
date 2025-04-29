public class SuratBerhargaNegara extends Product {
    private double bunga;
    private int jangkaWaktu;
    private String tanggalJatuhTempo;
    private double kuotaNasional;

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        super("SBN-" + nama, nama); // Pastikan kode tidak null, menggunakan nama sebagai kode dengan awalan "SBN-"
        if (nama == null || nama.isEmpty()) {
            throw new IllegalArgumentException("Nama SBN tidak boleh kosong.");
        }
        if (bunga <= 0) {
            throw new IllegalArgumentException("Bunga harus lebih besar dari 0.");
        }
        if (jangkaWaktu <= 0) {
            throw new IllegalArgumentException("Jangka waktu harus lebih besar dari 0.");
        }
        if (kuotaNasional <= 0) {
            throw new IllegalArgumentException("Kuota Nasional harus lebih besar dari 0.");
        }

        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    public double getBunga() {
        return bunga;
    }

    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

    public String getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public double getKuotaNasional() {
        return kuotaNasional;
    }

    public void kurangiKuota(double nominal) {
        if (nominal <= 0) {
            throw new IllegalArgumentException("Nominal yang dikurangi harus lebih besar dari 0.");
        }
        if (nominal > kuotaNasional) {
            throw new IllegalArgumentException("Kuota yang dikurangi melebihi kuota nasional yang tersedia.");
        }
        this.kuotaNasional -= nominal;
    }
}
