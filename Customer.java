import java.util.*;

class Customer extends User {
    Map<Saham, Integer> portofolioSaham = new HashMap<>();
    Map<SuratBerhargaNegara, Double> portofolioSBN = new HashMap<>();

    public Customer(String u, String p, String n) {
        super(u, p, n);
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("\n--- Menu Customer ---");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Lihat Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilih: ");

            int pilih = Dummy.sc.nextInt(); Dummy.sc.nextLine();
            switch (pilih) {
                case 1 -> CustomerFeatures.beliSaham(this);
                case 2 -> CustomerFeatures.jualSaham(this);
                case 3 -> CustomerFeatures.beliSBN(this);
                case 4 -> CustomerFeatures.simulasiSBN(this);
                case 5 -> CustomerFeatures.tampilkanPortofolio(this);
                case 6 -> {
                    System.out.println("Logout customer.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}