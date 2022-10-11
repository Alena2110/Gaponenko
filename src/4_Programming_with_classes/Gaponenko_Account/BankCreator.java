public class BankCreator {
    public static void main(String[] args) {
        Client clientOne = new Client("Заводевкин М. Н.");
        Account account1 = new Account("BY86AKBB10100000002966000000", 8765.99);
        clientOne.addAccount(account1);
        Account account2 = new Account("BY86AKBB10105609875966000000", -350);
        clientOne.addAccount(account2);
        Account account3 = new Account("BY86AKBB10105600002989000000", 155);
        clientOne.addAccount(account3);
        Client clientTwo = new Client("Акуленко З. Л.");
        Account account4 = new Account("BY86AKBB44100550002966000000", 123);
        clientTwo.addAccount(account4);
        Account account5 = new Account("BY86AKBB15505634002966000000", 456);
        clientTwo.addAccount(account5);
        Account account6 = new Account("BY86AKBB10105600005466000000", -1177.45);
        clientTwo.addAccount(account6);
        Client clientThree = new Client("Иванова М. К.");
        Account account7 = new Account("BY86AKBB10100600077966000000", 23.434);
        clientThree.addAccount(account7);
        Client clientFour = new Client("Филистович Ш. Л.");
        Account account8 = new Account("BY86AKBB45100000002966055000", 987.889);
        clientFour.addAccount(account8);
        Account account9 = new Account("BY86AKBB10165600002966780000", -675.88);
        clientFour.addAccount(account9);
        Bank bank = new Bank("Приорбанк");
        bank.addClient(clientOne);
        bank.addClient(clientTwo);
        bank.addClient(clientThree);
        bank.addClient(clientFour);
        System.out.println("\nПоиск счета\n");
        System.out.println(bank.findAccount("BY86AKBB10100600077966000000"));
        System.out.println("\nСортировка счетов по номеру счета\n");
        for (Account account : bank.accountSortingNumber()) {
            System.out.println(account);
        }
        System.out.println("\nСортировка счетов по сумме\n");
        for (Account account : bank.accountSortingAmount()) {
            System.out.println(account);
        }
        System.out.println("\nСумма по счетам с отрицательным балансом: " + bank.negativeBalanceSum());
        System.out.println("\nСумма по счетам с положительным балансом: " + bank.positiveBalanceSum());
        System.out.println("\nОбщая сумма по счетам: " + bank.allSum());
    }
}
