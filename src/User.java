public abstract class User {
    protected String username; // Username pengguna
    protected String password; // Password pengguna

    // Konstruktor untuk membuat objek User dengan validasi username dan password
    public User(String username, String password) {
        // Validasi Username tidak boleh kosong
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username tidak boleh kosong.");
        }
        // Validasi Password tidak boleh kosong
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password tidak boleh kosong.");
        }
        
        this.username = username;
        this.password = password;
    }

    // Getter untuk username
    public String getUsername() {
        return username;
    }

    // Getter untuk password
    public String getPassword() {
        return password;
    }

    // Setter untuk password 
    public void setPassword(String newPassword) {
        // Validasi: Password baru tidak boleh kosong
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("Password baru tidak boleh kosong.");
        }
        // Validasi: Password baru harus memiliki minimal 6 karakter
        if (newPassword.length() < 6) {
            throw new IllegalArgumentException("Password baru harus terdiri dari minimal 6 karakter.");
        }
        this.password = newPassword;
    }

    // Method abstrak dari kelas turunannya
    public abstract void menu();
}
