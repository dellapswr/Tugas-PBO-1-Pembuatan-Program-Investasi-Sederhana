public class Main {
    public static void main(String[] args) {
        try {
            Dummy.startProgram();
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
