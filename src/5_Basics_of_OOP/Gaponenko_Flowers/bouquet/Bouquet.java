package bouquet;

import flowers.*;
import packaging.TypePackaging;

import java.util.ArrayList;
import java.util.Objects;

public class Bouquet {//класс букет
    private ArrayList<Flowers> flowers; //список цветов
    private TypePackaging typePackaging;//тип упаковки
    double cost = 0;//цена букета

    public Bouquet(TypePackaging typePackaging) {
        flowers = new ArrayList<>();
        this.typePackaging = typePackaging;
    }

    public Bouquet(TypePackaging typePackaging, ArrayList<Flowers> flowers) {
        this.flowers = new ArrayList<>();
        this.flowers.addAll(flowers);
        this.typePackaging = typePackaging;
        for (Flowers flower : flowers) {
            cost += flower.getTypeFlower().getPrice();
        }
    }

    public void addFlower(Flowers flower) {
        flowers.add(flower);
        cost += flower.getTypeFlower().getPrice();
    }

    public void addFlowers(ArrayList<Flowers> flowers) {
        this.flowers.addAll(flowers);
        for (Flowers flower : flowers) {
            cost += flower.getTypeFlower().getPrice();
        }

    }

    public double getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bouquet bouquet = (Bouquet) o;
        return Double.compare(bouquet.cost, cost) == 0 && Objects.equals(flowers, bouquet.flowers)
                && Objects.equals(typePackaging, bouquet.typePackaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowers, typePackaging, getCost());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Flowers flower : flowers) {
            result.append("\n").append(flower).append(";");
        }
        return "Букет упакован в " + typePackaging.getName() + " и состоит из: " + result + "\nЦена букета: " + cost;
    }
}