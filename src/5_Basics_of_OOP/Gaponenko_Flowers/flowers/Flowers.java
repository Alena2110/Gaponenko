package flowers;

import java.util.Objects;

public abstract class Flowers {//абстрактный класс "цветы"
    ColorFlower colorFlower;//цвет
    TypeFlower typeFlower;//разновидность цветка

    public Flowers(ColorFlower colorFlower) {
        this.colorFlower = colorFlower;
    }


    public TypeFlower getTypeFlower() {
        return typeFlower;
    }

    @Override
    public String toString() {
        return typeFlower.getName() + " цвет " + colorFlower.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flowers flowers = (Flowers) o;
        return colorFlower == flowers.colorFlower && typeFlower == flowers.typeFlower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorFlower, typeFlower);
    }
}