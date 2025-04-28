import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void menu() {}

    public void tambahSaham(Scanner scanner, ArrayList<Product> products) {
        System.out.print("Kode Saham: ");
        String kode = scanner.nextLine();
        System.out.print("Nama Perusahaan: ");
        String nama = scanner.nextLine();
        System.out.print("Harga per lembar: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        products.add(new Saham(kode, nama, harga));
        System.out.println("✅ Saham berhasil ditambahkan!");
    }

    public void ubahHargaSaham(Scanner scanner, ArrayList<Product> products) {
        System.out.print("Kode Saham yang ingin diubah: ");
        String kode = scanner.nextLine();
        for (Product p : products) {
            if (p instanceof Saham && p.getKode().equalsIgnoreCase(kode)) {
                System.out.print("Harga baru per lembar: ");
                double hargaBaru = scanner.nextDouble();
                scanner.nextLine();
                ((Saham) p).setHarga(hargaBaru);
                System.out.println("✅ Harga saham berhasil diubah!");
                return;
            }
        }
        System.out.println("❌ Saham tidak ditemukan.");
    }

    public void lihatSaham(ArrayList<Product> products) {
        String garis = "=".repeat(62);
        System.out.println(garis);
        System.out.printf("|| %-56s ||%n", centerTextInside("DAFTAR SAHAM", 56));
        System.out.println(garis);
        System.out.printf("|| %-6s || %-20s || %-20s ||%n", "KODE", "NAMA", "HARGA (PER-LOT)");
        System.out.println(garis.replace('=', '-'));
        for (Product p : products) {
            if (p instanceof Saham) {
                Saham s = (Saham) p;
                System.out.printf("|| %-6s || %-20s || Rp%-18.0f ||%n",
                        s.getKode(), s.getNama(), s.getHargaPerLot());
            }
        }
        System.out.println(garis);
    }

    public void hapusSaham(Scanner scanner, ArrayList<Product> products) {
        System.out.print("Kode Saham yang ingin dihapus: ");
        String kode = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Saham && products.get(i).getKode().equalsIgnoreCase(kode)) {
                products.remove(i);
                System.out.println("✅ Saham berhasil dihapus!");
                return;
            }
        }
        System.out.println("❌ Saham tidak ditemukan.");
    }

    public void tambahSBN(Scanner scanner, ArrayList<Product> products) {
        System.out.print("Nama SBN: ");
        String nama = scanner.nextLine();
        System.out.print("Bunga (%): ");
        double bunga = scanner.nextDouble();
        System.out.print("Jangka waktu (tahun): ");
        int jangka = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tanggal Jatuh Tempo: ");
        String jatuhTempo = scanner.nextLine();
        System.out.print("Kuota Nasional: ");
        double kuota = scanner.nextDouble();
        scanner.nextLine();
        products.add(new SuratBerhargaNegara(nama, bunga, jangka, jatuhTempo, kuota));
        System.out.println("✅ SBN berhasil ditambahkan!");
    }

    public void lihatSBN(ArrayList<Product> products) {
        String garis = "=".repeat(98);
        System.out.println(garis);
        System.out.printf("|| %-92s ||%n", centerTextInside("DAFTAR SBN", 92));
        System.out.println(garis);
        System.out.printf("|| %-30s || %-6s || %-7s || %-15s || %-10s ||%n", 
                          "NAMA", "BUNGA", "JANGKA", "JATUH TEMPO", "KUOTA");
        System.out.println(garis.replace('=', '-'));
        for (Product p : products) {
            if (p instanceof SuratBerhargaNegara) {
                SuratBerhargaNegara sbn = (SuratBerhargaNegara) p;
                System.out.printf("|| %-30s || %-6.2f%% || %-7d || %-15s || %-10.1f ||%n",
                        sbn.getNama(), sbn.getBunga(), sbn.getJangkaWaktu(),
                        sbn.getTanggalJatuhTempo(), sbn.getKuotaNasional());
            }
        }
        System.out.println(garis);
    }

    public void hapusSBN(Scanner scanner, ArrayList<Product> products) {
        System.out.print("Nama SBN yang ingin dihapus: ");
        String nama = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof SuratBerhargaNegara) {
                SuratBerhargaNegara sbn = (SuratBerhargaNegara) products.get(i);
                if (sbn.getNama().equalsIgnoreCase(nama)) {
                    products.remove(i);
                    System.out.println("✅ SBN berhasil dihapus!");
                    return;
                }
            }
        }
        System.out.println("❌ SBN tidak ditemukan.");
    }

    private String centerTextInside(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }
}
