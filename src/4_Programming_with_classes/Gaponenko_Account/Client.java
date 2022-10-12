import java.util.ArrayList;

public class Client {
    private static int ID = 1;//для инициализации id клиента банка
    private int id;//id клиента
    private String fullName;//ФИО клиента
    ArrayList<Account> accounts = new ArrayList<>();//счета клиента

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Client(String fullName, ArrayList<Account> accounts) {
        ID++;
        this.id = ID;
        this.fullName = fullName;
        this.accounts = accounts;
    }

    public Client(String fullName) {
        ID++;
        this.id = ID;
        this.fullName = fullName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {//добавление счета клиенту
        accounts.add(account);
    }
}
