class Admin extends User {
    public Admin(String u, String p, String n) {
        super(u, p, n);
    }

    @Override
    public void menu() {
        while (true) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Hapus Saham");
            System.out.println("4. Tambah SBN");
            System.out.println("5. Logout");
            System.out.print("Pilih: ");

            int pilih = Dummy.sc.nextInt(); Dummy.sc.nextLine();
            switch (pilih) {
                case 1 -> AdminFeatures.inputSaham();
                case 2 -> AdminFeatures.ubahHargaSaham();
                case 3 -> AdminFeatures.hapusSaham();
                case 4 -> AdminFeatures.inputSBN();
                case 5 -> {
                    System.out.println("Logout admin.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
