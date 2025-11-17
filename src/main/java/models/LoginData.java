package models;

public class LoginData {
    private String username;
    private String password;

    public LoginData() {
        // Jackson sẽ gọi constructor này trước khi dùng setters/field access
    }
    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
