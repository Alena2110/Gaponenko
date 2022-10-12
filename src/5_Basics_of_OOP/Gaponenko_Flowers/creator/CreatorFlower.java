package creator;

import flowers.*;

public class CreatorFlower {//класс для создания цветов по их типу

    public Flowers createFlower(TypeFlower typeFlower, ColorFlower colorFlower) {
        switch (typeFlower) {
            case TULIP:
                return new Tulip(colorFlower);
            case ROSE:
                return new Rose(colorFlower);
            case CHAMOMILE:
                return new Chamomile(colorFlower);
            case CHRYSANTHEMUM:
                return new Chrysanthemum(colorFlower);
            case ALSTROEMERIA:
                return new Alstroemeria(colorFlower);
            case LILY:
                return new Lily(colorFlower);
            default:
                return new Rose(colorFlower);
        }
    }
}
