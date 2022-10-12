import java.io.Serializable;

public class User implements Serializable {
    private String login;//логин
    private String password;//пароль
    private String email;//электронная почта
    private boolean isAdmin;//true - администратор, false - пользователь

    public User(String login, String password, String email, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "Логин: " + login + "\nПароль " + password + "\ne-mail: " + email + "\n" + (isAdmin ? "Администратор" : "Пользователь");
    }
}


