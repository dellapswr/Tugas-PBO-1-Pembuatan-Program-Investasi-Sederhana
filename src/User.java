public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username tidak boleh kosong.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password tidak boleh kosong.");
        }
        
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter untuk password dengan validasi
    public void setPassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("Password baru tidak boleh kosong.");
        }
        if (newPassword.length() < 6) {
            throw new IllegalArgumentException("Password baru harus terdiri dari minimal 6 karakter.");
        }
        this.password = newPassword;
    }

    public abstract void menu();
}
