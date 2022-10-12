/*4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета.
 Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, имеющим
 положительный и отрицательный балансы отдельно.
*/
public class Account {

    private String accountNumber;//номер счета
    private double amount;//сумма по счета
    private boolean status;//статус счета

    public Account(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = true;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return " Счет номер: " + accountNumber + "; сумма счета: " + amount + "; счет " +
                ((status) ? "действующий" : "заблокирован");
    }
}
