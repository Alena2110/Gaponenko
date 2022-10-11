import java.util.ArrayList;
import java.util.Comparator;

public class Bank {
    private String bankName;//название банка
    private ArrayList<Client> clients = new ArrayList<>();//клиенты банка

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public Bank(String bankName, ArrayList<Client> clients) {
        this.bankName = bankName;
        this.clients = clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public String findAccount(String number) {//поиск счета
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getAccountNumber().compareToIgnoreCase(number) == 0)
                    return account.toString() + " принадлежит клиенту: " + client.getFullName();
            }
        }
        return "Счет не найден";
    }

    public double allSum() {//определение всей суммы по счетам
        double sum = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                sum += account.getAmount();
            }
        }
        return Math.round(sum * 100.00) / 100.0;
    }

    public double positiveBalanceSum() {//определение суммы по счетам с положительным балансом
        double sum = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getAmount() > 0) {
                    sum += account.getAmount();
                }
            }
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    public double negativeBalanceSum() {//определение суммы по счетам с отрицательным балансом
        double sum = 0;
        for (Client client : clients) {
            for (Account account : client.getAccounts()) {
                if (account.getAmount() < 0) {
                    sum += account.getAmount();
                }
            }
        }
        return Math.round(sum * 100.000) / 100.00;
    }

    public ArrayList<Account> accountSortingAmount() { //сортировка счетов по сумме
        ArrayList<Account> allAccounts = new ArrayList<>();
        for (Client client : clients) {
            allAccounts.addAll(client.getAccounts());
        }
        allAccounts.sort(Comparator.comparingDouble(Account::getAmount));
        return allAccounts;
    }

    public ArrayList<Account> accountSortingNumber() { //сортировка счетов по номеру
        ArrayList<Account> allAccounts = new ArrayList<>();
        for (Client client : clients) {
            allAccounts.addAll(client.getAccounts());
        }
        allAccounts.sort(Comparator.comparing(Account::getAccountNumber, Comparator.naturalOrder()));
        return allAccounts;
    }

    public void accountBlock(Account account) {//блокировка счета
        if (account.isStatus()) {
            account.setStatus(false);
        }
    }

    public void accountUnblock(Account account) {//разблокировка счета
        if (!account.isStatus()) {
            account.setStatus(true);
        }
    }
}
