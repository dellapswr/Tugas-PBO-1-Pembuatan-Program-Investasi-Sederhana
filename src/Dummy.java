import java.util.ArrayList;
import java.util.Scanner;

public class Dummy {
    private static ArrayList<Product> products = new ArrayList<>(); // Daftar produk yang tersedia
    private static ArrayList<User> users = new ArrayList<>(); // Daftar pengguna (admin dan customer)

    // Method untuk memulai program
    public static void startProgram() {
        // Menambahkan Admin dan Customer awal
        users.add(new Admin("della", "admindella"));
        users.add(new Customer("dayra", "custdayra", 100_000_000));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=".repeat(40));
            System.out.println("||     SELAMAT DATANG DI INVESTASI    ||");
            System.out.println("=".repeat(40));
            System.out.println("=".repeat(40));
            System.out.println("|| 1. Login Admin   2. Login Customer ||");
            System.out.println("||                                    ||");
            System.out.println("||             3. Keluar              ||");
            System.out.println("=".repeat(40));
            System.out.print("Pilihan: ");
            String input = scanner.nextLine();

            // Validasi input kosong
            if (input.trim().isEmpty()) {
                System.out.println("Pilihan tidak boleh kosong. Silakan coba lagi.");
                continue;
            }

            int pilih;
            try {
                pilih = Integer.parseInt(input); // Mengkonversi input menjadi angka
            } catch (NumberFormatException e) {
                System.out.println("Pilihan harus berupa angka. Silakan coba lagi.");
                continue;
            }

            // Menangani pilihan menu
            if (pilih == 1) {
                loginAdmin(scanner);
            } else if (pilih == 2) {
                loginCustomer(scanner);
            } else if (pilih == 3) {
                System.out.println("=".repeat(45));
                System.out.println("|| Terima kasih Sudah Menggunakan Program! ||");
                System.out.println("=".repeat(45));
                break;
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        }
    }

    // Method untuk login sebagai Admin
    private static void loginAdmin(Scanner scanner) {
        System.out.println("=".repeat(41));
        System.out.println("||    SELAMAT DATANG DI LOGIN ADMIN    ||");
        System.out.println("=".repeat(41));
        System.out.print("Username Admin: ");
        String username = scanner.nextLine();
        if (username.trim().isEmpty()) {
            System.out.println("Username tidak boleh kosong.");
            return;
        }

        System.out.print("Password Admin: ");
        String password = scanner.nextLine();
        if (password.trim().isEmpty()) {
            System.out.println("Password tidak boleh kosong.");
            return;
        }

        // Mengecek apakah username dan password sesuai dengan yang terdaftar
        for (User user : users) {
            if (user instanceof Admin && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                adminMenu((Admin) user, scanner);
                return;
            }
        }
        System.out.println("Username atau password salah!");
    }

    // Method untuk login sebagai Customer
    private static void loginCustomer(Scanner scanner) {
        System.out.println("=".repeat(42));
        System.out.println("||   SELAMAT DATANG DI LOGIN CUSTOMER   ||");
        System.out.println("=".repeat(42));
        System.out.print("Username Customer: ");
        String username = scanner.nextLine();
        if (username.trim().isEmpty()) {
            System.out.println("Username tidak boleh kosong.");
            return;
        }

        System.out.print("Password Customer: ");
        String password = scanner.nextLine();
        if (password.trim().isEmpty()) {
            System.out.println("Password tidak boleh kosong.");
            return;
        }

        // Mengecek apakah username dan password sesuai dengan yang terdaftar
        for (User user : users) {
            if (user instanceof Customer && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                customerMenu((Customer) user, scanner);
                return;
            }
        }
        System.out.println("Username atau password salah!");
    }

    // Menu Admin yang dapat diakses setelah login Admin
    private static void adminMenu(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("=".repeat(40));
            System.out.println("||              MENU ADMIN            ||");
            System.out.println("=".repeat(40));
            System.out.println("||        1. Tambah Saham             ||");
            System.out.println("||        2. Ubah Harga Saham         ||");
            System.out.println("||        3. Lihat Daftar Saham       ||");
            System.out.println("||        4. Hapus Saham              ||");
            System.out.println("||        5. Tambah SBN               ||");
            System.out.println("||        6. Lihat Daftar SBN         ||");
            System.out.println("||        7. Hapus SBN                ||");
            System.out.println("||        0. Logout                   ||");
            System.out.println("=".repeat(40));
            System.out.print("Pilihan: ");
            String input = scanner.nextLine();

            // Validasi input kosong
            if (input.trim().isEmpty()) {
                System.out.println("Pilihan tidak boleh kosong. Silakan coba lagi.");
                continue;
            }

            int pilih;
            try {
                pilih = Integer.parseInt(input); 
            } catch (NumberFormatException e) {
                System.out.println("Pilihan harus berupa angka. Silakan coba lagi.");
                continue;
            }

            if (pilih == 1) {
                admin.tambahSaham(scanner, products);
            } else if (pilih == 2) {
                admin.ubahHargaSaham(scanner, products);
            } else if (pilih == 3) {
                admin.lihatSaham(products);
            } else if (pilih == 4) {
                admin.hapusSaham(scanner, products);
            } else if (pilih == 5) {
                admin.tambahSBN(scanner, products);
            } else if (pilih == 6) {
                admin.lihatSBN(products);
            } else if (pilih == 7) {
                admin.hapusSBN(scanner, products);
            } else if (pilih == 0) {
                break;
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        }
    }

    // Menu Customer yang dapat diakses setelah login Customer
    private static void customerMenu(Customer customer, Scanner scanner) {
        while (true) {
            System.out.println("=".repeat(40));
            System.out.println("||            MENU CUSTOMER           ||");
            System.out.println("=".repeat(40));
            System.out.println("||       1. Lihat Daftar Saham        ||");
            System.out.println("||       2. Beli Saham                ||");
            System.out.println("||       3. Jual Saham                ||");
            System.out.println("||       4. Lihat Daftar SBN          ||");
            System.out.println("||       5. Beli SBN                  ||");
            System.out.println("||       6. Lihat Portofolio          ||");
            System.out.println("||       0. Logout                    ||");
            System.out.println("=".repeat(40));
            System.out.print("Pilihan: ");
            String input = scanner.nextLine();

            // Validasi input kosong
            if (input.trim().isEmpty()) {
                System.out.println("Pilihan tidak boleh kosong. Silakan coba lagi.");
                continue;
            }

            int pilih;
            try {
                pilih = Integer.parseInt(input); 
            } catch (NumberFormatException e) {
                System.out.println("Pilihan harus berupa angka. Silakan coba lagi.");
                continue;
            }

            
            if (pilih == 1) {
                lihatSaham();
            } else if (pilih == 2) {
                beliSaham(customer, scanner);
            } else if (pilih == 3) {
                jualSaham(customer, scanner);
            } else if (pilih == 4) {
                lihatSBN();
            } else if (pilih == 5) {
                beliSBN(customer, scanner);
            } else if (pilih == 6) {
                customer.lihatPortofolio(products);
            } else if (pilih == 0) {
                break;
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        }
    }

    // Menampilkan daftar saham
    private static void lihatSaham() {
        for (User user : users) {
            if (user instanceof Admin) {
                ((Admin) user).lihatSaham(products);
                return;
            }
        }
    }

    // Menampilkan daftar SBN
    private static void lihatSBN() {
        for (User user : users) {
            if (user instanceof Admin) {
                ((Admin) user).lihatSBN(products);
                return;
            }
        }
    }

    // Membeli saham
    private static void beliSaham(Customer customer, Scanner scanner) {
        lihatSaham();
        System.out.print("Kode Saham: ");
        String kode = scanner.nextLine();
        if (kode.trim().isEmpty()) {
            System.out.println("Kode saham tidak boleh kosong.");
            return;
        }
        System.out.print("Jumlah Lot: ");
        int lot = scanner.nextInt();
        scanner.nextLine();

        if (lot <= 0) {
            System.out.println("Jumlah lot harus lebih besar dari 0.");
            return;
        }

        for (Product p : products) {
            if (p instanceof Saham && p.getKode().equalsIgnoreCase(kode)) {
                customer.beliSaham((Saham) p, lot);
                return;
            }
        }
        System.out.println("Saham tidak ditemukan!");
    }

    // Menjual saham
    private static void jualSaham(Customer customer, Scanner scanner) {
        System.out.print("Kode Saham: ");
        String kode = scanner.nextLine();
        if (kode.trim().isEmpty()) {
            System.out.println("Kode saham tidak boleh kosong.");
            return;
        }
        System.out.print("Jumlah Lot: ");
        int lot = scanner.nextInt();
        scanner.nextLine();

        if (lot <= 0) {
            System.out.println("Jumlah lot harus lebih besar dari 0.");
            return;
        }

        for (Product p : products) {
            if (p instanceof Saham && p.getKode().equalsIgnoreCase(kode)) {
                customer.jualSaham((Saham) p, lot);
                return;
            }
        }
        System.out.println("Saham tidak ditemukan!");
    }

    // Membeli SBN
    private static void beliSBN(Customer customer, Scanner scanner) {
        lihatSBN();
        System.out.print("Nama SBN: ");
        String nama = scanner.nextLine();
        if (nama.trim().isEmpty()) {
            System.out.println("Nama SBN tidak boleh kosong.");
            return;
        }
        System.out.print("Nominal: ");
        double nominal = scanner.nextDouble();
        scanner.nextLine();

        if (nominal <= 0) {
            System.out.println("Nominal harus lebih besar dari 0.");
            return;
        }

        for (Product p : products) {
            if (p instanceof SuratBerhargaNegara && ((SuratBerhargaNegara) p).getNama().equalsIgnoreCase(nama)) {
                customer.beliSBN((SuratBerhargaNegara) p, nominal);
                return;
            }
        }
        System.out.println("SBN tidak ditemukan!");
    }
}
