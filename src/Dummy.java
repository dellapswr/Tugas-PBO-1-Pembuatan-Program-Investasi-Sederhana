import java.util.*;

class Dummy {
    static List<User> users = new ArrayList<>();
    static List<Saham> listSaham = new ArrayList<>();
    static List<SuratBerhargaNegara> listSBN = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void initUsers() {
        users.add(new Admin("admin", "aaa", "Della"));
        users.add(new Customer("cust", "bbb", "Dayu"));
    }

    public static void mainMenu() {
        while (true) {
            printLoginBox();
            System.out.print("Pilih Role [1.Admin | 2.Customer | 0.Exit] : ");
            int pilih = sc.nextInt(); sc.nextLine();

            if (pilih == 0) {
                System.out.println("Program selesai. Terima kasih!");
                break;
            }

            System.out.print("Username: ");
            String u = sc.nextLine();
            System.out.print("Password: ");
            String p = sc.nextLine();

            boolean ditemukan = false;
            for (User user : users) {
                if (user.username.equals(u) && user.password.equals(p)) {
                    System.out.println("Login berhasil!");
                    user.menu();
                    ditemukan = true;
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Login gagal!");
            }
        }
    }

    public static void printLoginBox() {
        System.out.println("==============================");
        System.out.println("||      SISTEM INVESTASI     ||");
        System.out.println("==============================");
    }
}
