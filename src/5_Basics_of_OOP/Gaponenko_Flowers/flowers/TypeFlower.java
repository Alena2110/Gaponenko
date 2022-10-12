package flowers;

public enum TypeFlower {//разновидности цветов
    ROSE("роза", 4),
    LILY("лилия", 3.2),
    ALSTROEMERIA("альстромерия", 7),
    CHRYSANTHEMUM("хризантема", 2.5),
    TULIP("тюльпан", 2),
    CHAMOMILE("ромашка", 1.5);
    private String name;
    double price;

    TypeFlower(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
