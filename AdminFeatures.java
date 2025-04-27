   import java.util.*;
   
   public class AdminFeatures {
    static Scanner sc = new Scanner(System.in);
    static List<Saham> listSaham = Dummy.listSaham;
    static List<SuratBerhargaNegara> listSBN = Dummy.listSBN;

    public static void inputSaham() {
        System.out.print("Kode Saham: ");
        String kode = sc.nextLine();
        System.out.print("Nama Perusahaan: ");
        String nama = sc.nextLine();
        System.out.print("Harga: ");
        double harga = sc.nextDouble(); sc.nextLine();
        listSaham.add(new Saham(kode, nama, harga));
        System.out.println("Saham berhasil ditambahkan!");
    }

    public static void ubahHargaSaham() {
        System.out.print("Kode Saham: ");
        String kode = sc.nextLine();
        for (Saham s : listSaham) {
            if (s.kode.equals(kode)) {
                System.out.print("Harga Baru: ");
                s.harga = sc.nextDouble(); sc.nextLine();
                System.out.println("Harga diperbarui!");
                return;
            }
        }
        System.out.println("Saham tidak ditemukan!");
    }

    public static void hapusSaham() {
        System.out.print("Kode Saham yang ingin dihapus: ");
        String kode = sc.nextLine();
        listSaham.removeIf(s -> s.kode.equals(kode));
        System.out.println("Saham berhasil dihapus!");
    }

    public static void inputSBN() {
        System.out.print("Nama SBN: ");
        String nama = sc.nextLine();
        System.out.print("Bunga (%): ");
        double bunga = sc.nextDouble();
        System.out.print("Jangka Waktu (tahun): ");
        int waktu = sc.nextInt(); sc.nextLine();
        System.out.print("Tanggal Jatuh Tempo: ");
        String tempo = sc.nextLine();
        System.out.print("Kuota Nasional: ");
        double kuota = sc.nextDouble(); sc.nextLine();
        listSBN.add(new SuratBerhargaNegara(nama, bunga, waktu, tempo, kuota));
        System.out.println("SBN berhasil ditambahkan!");
    }
}