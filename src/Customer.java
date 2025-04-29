import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends User {
    private double saldo; // Saldo milik customer
    private HashMap<String, Integer> sahamDimiliki; // Menyimpan saham yang dimiliki customer, dengan kode saham sebagai key dan jumlah lot sebagai value
    private HashMap<String, Double> sbnDimiliki; // Menyimpan SBN yang dimiliki customer, dengan nama SBN sebagai key dan jumlah dana sebagai value

    // Constructor untuk membuat customer baru dengan username, password, dan saldo awal
    public Customer(String username, String password, double saldo) {
        super(username, password);
        this.saldo = saldo;
        this.sahamDimiliki = new HashMap<>();
        this.sbnDimiliki = new HashMap<>();
    }

    // Method menu() kosong, mungkin untuk diimplementasikan di masa depan
    @Override
    public void menu() {}

    // Getter untuk saldo
    public double getSaldo() {
        return saldo;
    }

    // Method untuk menambah saldo
    public void tambahSaldo(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Saldo berhasil ditambahkan!");
        } else {
            System.out.println("Jumlah saldo harus lebih besar dari 0.");
        }
    }

    // Method untuk membeli saham
    public void beliSaham(Saham saham, int jumlahLot) {
        if (jumlahLot <= 0) {
            System.out.println("Jumlah lot harus lebih besar dari 0.");
            return;
        }
        double totalHarga = saham.getHargaPerLot() * jumlahLot;
        if (saldo >= totalHarga) {
            saldo -= totalHarga;
            // Menambahkan saham yang dibeli ke dalam sahamDimiliki
            sahamDimiliki.put(saham.getKode(), sahamDimiliki.getOrDefault(saham.getKode(), 0) + jumlahLot);
            System.out.println("Pembelian saham berhasil!");
        } else {
            System.out.println("Saldo tidak cukup.");
        }
    }

    // Method untuk menjual saham
    public void jualSaham(Saham saham, int jumlahLot) {
        String kode = saham.getKode();
        if (jumlahLot <= 0) {
            System.out.println("Jumlah lot harus lebih besar dari 0.");
            return;
        }
        // Mengecek apakah customer memiliki cukup saham untuk dijual
        if (sahamDimiliki.containsKey(kode) && sahamDimiliki.get(kode) >= jumlahLot) {
            double totalHarga = saham.getHargaPerLot() * jumlahLot;
            saldo += totalHarga;
            // Mengurangi jumlah saham yang dimiliki
            sahamDimiliki.put(kode, sahamDimiliki.get(kode) - jumlahLot);
            // Menghapus saham jika jumlah saham yang dimiliki menjadi 0
            if (sahamDimiliki.get(kode) == 0) {
                sahamDimiliki.remove(kode);
            }
            System.out.println("Penjualan saham berhasil!");
        } else {
            System.out.println("Lot saham tidak mencukupi.");
        }
    }

    // Method untuk membeli Surat Berharga Negara (SBN)
    public void beliSBN(SuratBerhargaNegara sbn, double jumlahDana) {
        if (jumlahDana <= 0) {
            System.out.println("Jumlah dana harus lebih besar dari 0.");
            return;
        }
        // Mengecek apakah saldo dan kuota SBN cukup
        if (saldo >= jumlahDana && sbn.getKuotaNasional() >= jumlahDana) {
            saldo -= jumlahDana;
            // Menambahkan SBN yang dibeli ke dalam sbnDimiliki
            sbnDimiliki.put(sbn.getNama(), sbnDimiliki.getOrDefault(sbn.getNama(), 0.0) + jumlahDana);
            sbn.kurangiKuota(jumlahDana); // Mengurangi kuota SBN
            System.out.println("Pembelian SBN berhasil!");
        } else {
            System.out.println("Saldo tidak cukup atau kuota tidak mencukupi.");
        }
    }

    // Method untuk melihat portofolio saham dan SBN
    public void lihatPortofolio(ArrayList<Product> products) {
        lihatPortofolioSaham(products);
        System.out.println();
        lihatPortofolioSBN();
    }

    // Method untuk melihat portofolio saham
    private void lihatPortofolioSaham(ArrayList<Product> products) {
        String garis = "=".repeat(62);
        System.out.println(garis);
        System.out.printf("|| %-56s ||%n", centerTextInside("PORTOFOLIO SAHAM", 56));
        System.out.println(garis);
        System.out.printf("|| %-6s || %-20s || %-20s ||%n", "KODE", "JUMLAH LOT", "NILAI (Rp)");
        System.out.println(garis.replace('=', '-'));

        if (sahamDimiliki.isEmpty()) {
            System.out.printf("|| %-56s ||%n", centerTextInside("(Kosong)", 56));
        } else {
            for (String kode : sahamDimiliki.keySet()) {
                int jumlah = sahamDimiliki.get(kode);
                double hargaPerLot = 0;
                // Menyusun harga saham yang dimiliki
                for (Product p : products) {
                    if (p instanceof Saham && p.getKode().equalsIgnoreCase(kode)) {
                        hargaPerLot = ((Saham) p).getHargaPerLot();
                        break;
                    }
                }
                double nilai = hargaPerLot * jumlah;
                System.out.printf("|| %-6s || %-20d || Rp%-18.0f ||%n", kode, jumlah, nilai);
            }
        }
        System.out.println(garis);
    }

    // Method untuk melihat portofolio Surat Berharga Negara (SBN)
    private void lihatPortofolioSBN() {
        String garis = "=".repeat(62);
        System.out.println(garis);
        System.out.printf("|| %-56s ||%n", centerTextInside("PORTOFOLIO SBN", 56));
        System.out.println(garis);
        System.out.printf("|| %-30s || %-20s ||%n", "NAMA SBN", "NILAI (Rp)");
        System.out.println(garis.replace('=', '-'));

        if (sbnDimiliki.isEmpty()) {
            System.out.printf("|| %-56s ||%n", centerTextInside("(Kosong)", 56));
        } else {
            for (String nama : sbnDimiliki.keySet()) {
                System.out.printf("|| %-30s || Rp%-18.0f ||%n", nama, sbnDimiliki.get(nama));
            }
        }
        System.out.println(garis);
    }

    // Method untuk menyusun teks di tengah
    private String centerTextInside(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }
}
