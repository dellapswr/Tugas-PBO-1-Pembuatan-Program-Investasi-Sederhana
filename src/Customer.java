import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends User {
    private double saldo;
    private HashMap<String, Integer> sahamDimiliki;
    private HashMap<String, Double> sbnDimiliki;

    public Customer(String username, String password, double saldo) {
        super(username, password);
        this.saldo = saldo;
        this.sahamDimiliki = new HashMap<>();
        this.sbnDimiliki = new HashMap<>();
    }

    @Override
    public void menu() {}

    public double getSaldo() {
        return saldo;
    }

    public void tambahSaldo(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Saldo berhasil ditambahkan!");
        } else {
            System.out.println("Jumlah saldo harus lebih besar dari 0.");
        }
    }

    public void beliSaham(Saham saham, int jumlahLot) {
        if (jumlahLot <= 0) {
            System.out.println("Jumlah lot harus lebih besar dari 0.");
            return;
        }
        double totalHarga = saham.getHargaPerLot() * jumlahLot;
        if (saldo >= totalHarga) {
            saldo -= totalHarga;
            sahamDimiliki.put(saham.getKode(), sahamDimiliki.getOrDefault(saham.getKode(), 0) + jumlahLot);
            System.out.println("Pembelian saham berhasil!");
        } else {
            System.out.println("Saldo tidak cukup.");
        }
    }

    public void jualSaham(Saham saham, int jumlahLot) {
        String kode = saham.getKode();
        if (jumlahLot <= 0) {
            System.out.println("Jumlah lot harus lebih besar dari 0.");
            return;
        }
        if (sahamDimiliki.containsKey(kode) && sahamDimiliki.get(kode) >= jumlahLot) {
            double totalHarga = saham.getHargaPerLot() * jumlahLot;
            saldo += totalHarga;
            sahamDimiliki.put(kode, sahamDimiliki.get(kode) - jumlahLot);
            if (sahamDimiliki.get(kode) == 0) {
                sahamDimiliki.remove(kode);
            }
            System.out.println("Penjualan saham berhasil!");
        } else {
            System.out.println("Lot saham tidak mencukupi.");
        }
    }

    public void beliSBN(SuratBerhargaNegara sbn, double jumlahDana) {
        if (jumlahDana <= 0) {
            System.out.println("Jumlah dana harus lebih besar dari 0.");
            return;
        }
        if (saldo >= jumlahDana && sbn.getKuotaNasional() >= jumlahDana) {
            saldo -= jumlahDana;
            sbnDimiliki.put(sbn.getNama(), sbnDimiliki.getOrDefault(sbn.getNama(), 0.0) + jumlahDana);
            sbn.kurangiKuota(jumlahDana);
            System.out.println("Pembelian SBN berhasil!");
        } else {
            System.out.println("Saldo tidak cukup atau kuota tidak mencukupi.");
        }
    }

    public void lihatPortofolio(ArrayList<Product> products) {
        lihatPortofolioSaham(products);
        System.out.println();
        lihatPortofolioSBN();
    }

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

    private String centerTextInside(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }
}
