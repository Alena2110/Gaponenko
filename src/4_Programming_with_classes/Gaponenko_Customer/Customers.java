import java.util.ArrayList;

public class Customers {
    private ArrayList<Customer> customers = new ArrayList<>();//список клиентов

    public void customerAdd(Customer customer) {//добавление нового клиента
        customers.add(customer);
    }

    public ArrayList<Customer> customersSorting() { //сортировка клиентов по алфавиту
        customers.sort((one, two) -> {
            if (one.getSurname().compareToIgnoreCase(two.getSurname()) != 0) {
                return one.getSurname().compareToIgnoreCase(two.getSurname());
            } else if (one.getFirstName().compareToIgnoreCase(two.getFirstName()) != 0) {
                return one.getFirstName().compareToIgnoreCase(two.getFirstName());
            } else return one.getPatronymic().compareToIgnoreCase(two.getPatronymic());
        });
        return customers;
    }

    public ArrayList<Customer> creditCardRange(String lowerRangeLimit, String upperRangeLimit) {
        //получение списка клиентов с номерами кредитных карт в заданном диапазоне
        ArrayList<Customer> customersRange = new ArrayList<>();
        for (Customer customer : customers)
            if (customer.getCcNumber().compareToIgnoreCase(upperRangeLimit) < 0 && customer.getCcNumber().compareToIgnoreCase(lowerRangeLimit) > 0) {
                customersRange.add(customer);
            }
        return customersRange;
    }

}