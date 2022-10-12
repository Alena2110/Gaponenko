package treasure;

public abstract class Treasure {
    int treasureNumber;//номер сокровища
    private TreasureType treasureType;//тип (кольцо, серьги и т.д.) сокровища
    private double weight;//вес сокровища

    public Treasure(int treasureNumber, TreasureType treasureType,
                    double weight) {
        this.treasureNumber = treasureNumber;
        this.treasureType = treasureType;
        this.weight = weight;

    }

    public abstract double getCost();

    @Override
    public String toString() {
        return "№" + treasureNumber + " " + treasureType.getName() +
                "; вес: " + weight;
    }
}
