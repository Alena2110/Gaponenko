import java.util.ArrayList;

public class Payment {
    ArrayList<Product> products = new ArrayList<>();//покупка из товаров
    String paymentName;//название покупки

    public Payment(String paymentName) {
        this.paymentName = paymentName;
    }

    public void addProduct(String productName, double price, Unit unit, double amount) {//добавление товара к покупке
        products.add(new Product(productName, price, unit, amount));
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        double sumProducts = 0;//общая сумма покупки
        for (Product product : products) {
            result.append(product).append("\n");
            sumProducts += product.sum;
        }
        return "Покупка " + paymentName + " на сумму " + Math.round(sumProducts*10.0)/10.0+ " включает следующие товары:\n" + result;
    }

    private class Product {
        String productName;//название товара
        double price;//цена за единицу
        Unit unit;//единица измерения
        double amount;//количество
        double sum;//общая сумма


        public Product(String productName, double price, Unit unit, double amount) {
            this.productName = productName;
            this.price = price;
            this.unit = unit;
            this.amount = amount;
            sum = price * amount;
        }

        @Override
        public String toString() {
            String unit;
            if (this.unit == Unit.KG) {
                unit = " кг.";
            } else {
                unit = " шт.";
            }
            return productName + " " + amount + unit + " по цене " + price + " на сумму " + Math.round(sum*10.0)/10.0;
        }
    }
}
