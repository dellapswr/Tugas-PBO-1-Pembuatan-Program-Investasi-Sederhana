import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void menu() {}

    // Validasi input kosong
    private String getValidInput(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong. Silakan coba lagi.");
            } else {
                break;
            }
        }
        return input;
    }

    public void tambahSaham(Scanner scanner, ArrayList<Product> products) {
        String kode = getValidInput(scanner, "Kode Saham: ");
        String nama = getValidInput(scanner, "Nama Perusahaan: ");
        
        double harga = -1;
        while (harga <= 0) {
            System.out.print("Harga per lembar: ");
            if (scanner.hasNextDouble()) {
                harga = scanner.nextDouble();
                if (harga <= 0) {
                    System.out.println("Harga harus lebih besar dari 0.");
                }
            } else {
                System.out.println("Input harus berupa angka.");
                scanner.next(); // Menghapus input invalid
            }
        }
        scanner.nextLine(); 
        products.add(new Saham(kode, nama, harga));
        System.out.println("Saham berhasil ditambahkan!");
    }

    public void ubahHargaSaham(Scanner scanner, ArrayList<Product> products) {
        String kode = getValidInput(scanner, "Kode Saham yang ingin diubah: ");
        for (Product p : products) {
            if (p instanceof Saham && p.getKode().equalsIgnoreCase(kode)) {
                double hargaBaru = -1;
                while (hargaBaru <= 0) {
                    System.out.print("Harga baru per lembar: ");
                    if (scanner.hasNextDouble()) {
                        hargaBaru = scanner.nextDouble();
                        if (hargaBaru <= 0) {
                            System.out.println("Harga baru harus lebih besar dari 0.");
                        }
                    } else {
                        System.out.println("Input harus berupa angka.");
                        scanner.next(); 
                    }
                }
                scanner.nextLine();  
                ((Saham) p).setHarga(hargaBaru);
                System.out.println("Harga saham berhasil diubah!");
                return;
            }
        }
        System.out.println("Saham tidak ditemukan.");
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
        String kode = getValidInput(scanner, "Kode Saham yang ingin dihapus: ");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof Saham && products.get(i).getKode().equalsIgnoreCase(kode)) {
                products.remove(i);
                System.out.println("Saham berhasil dihapus!");
                return;
            }
        }
        System.out.println("Saham tidak ditemukan.");
    }

    public void tambahSBN(Scanner scanner, ArrayList<Product> products) {
        String nama = getValidInput(scanner, "Nama SBN: ");
        
        double bunga = -1;
        while (bunga <= 0) {
            System.out.print("Bunga (%): ");
            if (scanner.hasNextDouble()) {
                bunga = scanner.nextDouble();
                if (bunga <= 0) {
                    System.out.println("Bunga harus lebih besar dari 0.");
                }
            } else {
                System.out.println("Input harus berupa angka.");
                scanner.next(); 
            }
        }
        
        int jangka = -1;
        while (jangka <= 0) {
            System.out.print("Jangka waktu (tahun): ");
            if (scanner.hasNextInt()) {
                jangka = scanner.nextInt();
                if (jangka <= 0) {
                    System.out.println("Jangka waktu harus lebih besar dari 0.");
                }
            } else {
                System.out.println("Input harus berupa angka.");
                scanner.next(); 
            }
        }
        scanner.nextLine();  
        
        String jatuhTempo = getValidInput(scanner, "Jatuh Tempo (dd/mm/yyyy): ");
        
        double kuota = -1;
        while (kuota <= 0) {
            System.out.print("Kuota Nasional: ");
            if (scanner.hasNextDouble()) {
                kuota = scanner.nextDouble();
                if (kuota <= 0) {
                    System.out.println("Kuota harus lebih besar dari 0.");
                }
            } else {
                System.out.println("Input harus berupa angka.");
                scanner.next(); 
            }
        }
        scanner.nextLine();  
        products.add(new SuratBerhargaNegara(nama, bunga, jangka, jatuhTempo, kuota));
        System.out.println("SBN berhasil ditambahkan!");
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
        String nama = getValidInput(scanner, "Nama SBN yang ingin dihapus: ");
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) instanceof SuratBerhargaNegara) {
                SuratBerhargaNegara sbn = (SuratBerhargaNegara) products.get(i);
                if (sbn.getNama().equalsIgnoreCase(nama)) {
                    products.remove(i);
                    System.out.println("SBN berhasil dihapus!");
                    return;
                }
            }
        }
        System.out.println("SBN tidak ditemukan.");
    }

    private String centerTextInside(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }
}
