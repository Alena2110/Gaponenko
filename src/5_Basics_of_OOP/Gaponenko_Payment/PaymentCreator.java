/*Задача 2. Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.
 */

public class PaymentCreator {
    public static void main(String[] args) {
        Payment onePayment = new Payment("onePayment");
        onePayment.addProduct("Яблоки", 45.23, Unit.KG, 2.56);
        onePayment.addProduct("Сникерс", 23, Unit.PCS, 4);
        onePayment.addProduct("Колбаса Альпийская", 123.45, Unit.KG, 4.3);
        Payment twoPayment = new Payment("twoPayment");
        twoPayment.addProduct("Молоко 3,2%", 34, Unit.PCS, 7);
        twoPayment.addProduct("Хлеб", 12, Unit.PCS, 2);
        twoPayment.addProduct("Сыр", 56.87, Unit.KG, 0.5);
        System.out.println(onePayment);
        System.out.println(twoPayment);
    }
}
