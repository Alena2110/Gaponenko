
public class CustomersCreator {
    public static void main(String[] args) {
        Customers customers = new Customers(); //создание списка клиентов
        customers.customerAdd(new Customer("Заводевкин", "Иван", "Васильевич",
                "7000000000000007", "BY86AKBB10100000002966000000"));
        customers.customerAdd(new Customer("Иванов", "Петр", "Васильевич",
                "4111101000000046", "AE460090000000123456789"));
        customers.customerAdd(new Customer("Гулько", "Алина", "Валерьевна",
                "7600000000000006", "CH5604835012345678009"));
        customers.customerAdd(new Customer("Хавротина", "Екатерина", "Игоревна",
                "5486732058864471", "CZ5508000000001234567899"));
        customers.customerAdd(new Customer("Заводевкин", "Петр", "Васильевич",
                "8000000000000008", "HR1723600001101234565"));
        customers.customerAdd(new Customer("Шостак", "Дарья", "Юрьевна",
                "1234561999999999", "IQ20CBIQ861800101010500"));
        customers.customerAdd(new Customer("Ниткин", "Петр", "Олегович",
                "4100401111103025", "KW81CBKU0000000000001234560101"));
        customers.customerAdd(new Customer("Шостак", "Дарья", "Григорьевна",
                "7800076500000006", "MK07200002785123453"));
        customers.customerAdd(new Customer("Лаппо", "Сабрина", "Вячеславовна",
                "4100401111100062", "SA4420000001234567891234"));
        System.out.println("Список покупателей в алфавитном порядке\n");
        for (Customer customer : customers.customersSorting()) {
            System.out.println(customer);
        }
        System.out.println("\nСписок покупателей с номером кредитной карты в диапазоне (7000000000000000:8000000000000000)\n");
        for (Customer customer : customers.creditCardRange("7000000000000000",
                "8000000000000000")) {
            System.out.println(customer);
        }
    }
}