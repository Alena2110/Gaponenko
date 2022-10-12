package treasure;

public class TreasurePlatinum extends Treasure {
    private final TreasureMaterial TREASURE_MATERIAL = TreasureMaterial.PLATINUM;
    private double cost;

    public TreasurePlatinum(int treasureNumber, TreasureType treasureType,
                            double weight) {
        super(treasureNumber, treasureType, weight);
        double PRICE = 300;
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
