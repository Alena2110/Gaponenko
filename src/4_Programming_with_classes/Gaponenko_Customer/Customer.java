/*8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и метод
toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами. Задать
 критерии выбора данных и вывести эти данные на консоль.
        Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счёта.
        Найти и вывести:
        а) список покупателей в алфавитном порядке;
        b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
*/
public class Customer {
    private static int ID = 1; //для инициализации id клиента уникальными значениями
    private final int id; //id клиента
    private String surname; //фамилия
    private String firstName; //имя
    private String patronymic; //отчество
    private String ccNumber; //номер кредитной карты
    String bankAccountNumber; //номер банковского счета

    public Customer(String surname, String firstName, String patronymic, String ccNumber, String bankAccountNumber) {
        this.id = ID++;
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.ccNumber = ccNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Покупатель " +
                id +
                " " + surname +
                " " + firstName +
                " " + patronymic + ". " +
                " Номер кредитной карты: " + ccNumber + ". " +
                " Номер банковского счета: " + bankAccountNumber + ".";
    }


}

