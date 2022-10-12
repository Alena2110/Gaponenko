package treasure;

public class TreasureSilver extends Treasure {
    private final TreasureMaterial TREASURE_MATERIAL = TreasureMaterial.SILVER;
    private double cost;


    public TreasureSilver(int treasureNumber, TreasureType treasureType,
                          double weight) {
        super(treasureNumber, treasureType, weight);
        double PRICE = 100;
        this.cost = Math.round(PRICE * weight * 10.0) / 10.0;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return super.toString() + "; материал: " + TREASURE_MATERIAL.getName() +
                "; стоимость: " + this.cost;
    }
}
