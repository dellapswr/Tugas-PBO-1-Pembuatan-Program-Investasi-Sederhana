public class SuratBerhargaNegara extends Product {
    private double bunga; // Bunga yang diterima oleh investor
    private int jangkaWaktu; // Lama waktu SBN berlaku dalam tahun
    private String tanggalJatuhTempo; // Tanggal jatuh tempo SBN
    private double kuotaNasional; // Kuota total SBN yang tersedia

    // Konstruktor untuk membuat objek Surat Berharga Negara
    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        // Memastikan bahwa nama memiliki awalan "SBN-" dan menggunakan nama untuk kode
        super("SBN-" + nama, nama); 
        // Validasi input: Nama SBN tidak boleh kosong
        if (nama == null || nama.isEmpty()) {
            throw new IllegalArgumentException("Nama SBN tidak boleh kosong.");
        }
        // Validasi bunga, harus lebih besar dari 0
        if (bunga <= 0) {
            throw new IllegalArgumentException("Bunga harus lebih besar dari 0.");
        }
        // Validasi jangka waktu, harus lebih besar dari 0
        if (jangkaWaktu <= 0) {
            throw new IllegalArgumentException("Jangka waktu harus lebih besar dari 0.");
        }
        // Validasi kuota nasional, harus lebih besar dari 0
        if (kuotaNasional <= 0) {
            throw new IllegalArgumentException("Kuota Nasional harus lebih besar dari 0.");
        }

        // Menyimpan nilai-nilai yang telah tervalidasi ke dalam atribut objek
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    // Getter untuk bunga
    public double getBunga() {
        return bunga;
    }

    // Getter untuk jangka waktu
    public int getJangkaWaktu() {
        return jangkaWaktu;
    }

    // Getter untuk tanggal jatuh tempo
    public String getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    // Getter untuk kuota nasional
    public double getKuotaNasional() {
        return kuotaNasional;
    }

    // Method untuk mengurangi kuota nasional setelah pembelian SBN
    public void kurangiKuota(double nominal) {
        // Validasi nominal, harus lebih besar dari 0
        if (nominal <= 0) {
            throw new IllegalArgumentException("Nominal yang dikurangi harus lebih besar dari 0.");
        }
        // Validasi, jika nominal yang dikurangi melebihi kuota yang tersedia
        if (nominal > kuotaNasional) {
            throw new IllegalArgumentException("Kuota yang dikurangi melebihi kuota nasional yang tersedia.");
        }
        // Mengurangi kuota nasional
        this.kuotaNasional -= nominal;
    }
}
