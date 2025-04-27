abstract class User {
    String username, password, namaLengkap;
    public User(String u, String p, String n) {
        username = u; password = p; namaLengkap = n;
    }
    public abstract void menu();
}
