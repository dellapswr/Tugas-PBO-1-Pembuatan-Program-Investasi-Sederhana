import java.util.*;

public class CustomerFeatures {
    static Scanner sc = new Scanner(System.in);
    static List<Saham> listSaham = Dummy.listSaham;
    static List<SuratBerhargaNegara> listSBN = Dummy.listSBN;

    public static void beliSaham(Customer c) {
        if (listSaham.isEmpty()) {
            System.out.println("Belum ada saham tersedia.");
            return;
        }
        for (Saham s : listSaham) {
            System.out.println(s.kode + " - " + s.namaPerusahaan + " - Rp" + s.harga);
        }
        System.out.print("Masukkan kode saham: ");
        String kode = sc.nextLine();
        for (Saham s : listSaham) {
            if (s.kode.equals(kode)) {
                System.out.print("Jumlah lembar: ");
                int jumlah = sc.nextInt(); sc.nextLine();
                c.portofolioSaham.put(s, c.portofolioSaham.getOrDefault(s, 0) + jumlah);
                System.out.println("Berhasil membeli saham!");
                return;
            }
        }
        System.out.println("Saham tidak ditemukan.");
    }

    public static void jualSaham(Customer c) {
        if (c.portofolioSaham.isEmpty()) {
            System.out.println("Tidak ada saham yang dimiliki.");
            return;
        }
        for (Saham s : c.portofolioSaham.keySet()) {
            System.out.println(s.kode + " - " + s.namaPerusahaan + " - " + c.portofolioSaham.get(s) + " lembar");
        }
        System.out.print("Kode saham yang ingin dijual: ");
        String kode = sc.nextLine();
        for (Saham s : c.portofolioSaham.keySet()) {
            if (s.kode.equals(kode)) {
                System.out.print("Jumlah: ");
                int jml = sc.nextInt(); sc.nextLine();
                int dimiliki = c.portofolioSaham.get(s);
                if (jml > dimiliki) {
                    System.out.println("Tidak cukup lembar saham.");
                } else {
                    c.portofolioSaham.put(s, dimiliki - jml);
                    System.out.println("Saham berhasil dijual.");
                }
                return;
            }
        }
        System.out.println("Saham tidak ditemukan di portofolio.");
    }

    public static void beliSBN(Customer c) {
        for (SuratBerhargaNegara sbn : listSBN) {
            System.out.println(sbn.nama + " - Bunga: " + sbn.bunga + "%");
        }
        System.out.print("Masukkan nama SBN: ");
        String nama = sc.nextLine();
        for (SuratBerhargaNegara s : listSBN) {
            if (s.nama.equals(nama)) {
                System.out.print("Nominal pembelian: ");
                double nominal = sc.nextDouble(); sc.nextLine();
                if (s.kuotaNasional >= nominal) {
                    s.kuotaNasional -= nominal;
                    c.portofolioSBN.put(s, c.portofolioSBN.getOrDefault(s, 0.0) + nominal);
                    System.out.println("Pembelian berhasil!");
                } else {
                    System.out.println("Kuota tidak mencukupi.");
                }
                return;
            }
        }
        System.out.println("SBN tidak ditemukan.");
    }

    public static void simulasiSBN(Customer c) {
        for (Map.Entry<SuratBerhargaNegara, Double> e : c.portofolioSBN.entrySet()) {
            double bungaBulanan = (e.getValue() * e.getKey().bunga / 100) / 12;
            System.out.println(e.getKey().nama + " → Bunga Bulanan: Rp " + bungaBulanan);
        }
    }

    public static void tampilkanPortofolio(Customer c) {
        System.out.println("Portofolio Saham:");
        for (Map.Entry<Saham, Integer> e : c.portofolioSaham.entrySet()) {
            System.out.println(e.getKey().namaPerusahaan + " - " + e.getValue() + " lembar");
        }
        System.out.println("Portofolio SBN:");
        for (Map.Entry<SuratBerhargaNegara, Double> e : c.portofolioSBN.entrySet()) {
            System.out.println(e.getKey().nama + " - Rp " + e.getValue());
        }
    }
}
