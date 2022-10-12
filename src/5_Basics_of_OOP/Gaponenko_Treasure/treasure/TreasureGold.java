package treasure;

public class TreasureGold extends Treasure {
    private final TreasureMaterial TREASURE_MATERIAL = TreasureMaterial.GOLD;//материал
    private double cost;//стоимость

    public TreasureGold(int treasureNumber, TreasureType treasureType,
                        double weight) {
        super(treasureNumber, treasureType, weight);
        //цена
        double PRICE = 200;
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
