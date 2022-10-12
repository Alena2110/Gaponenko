import bouquet.Bouquet;
import creator.CreatorFlower;
import flowers.*;
import packaging.TypePackaging;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainFlowers {
    public static void main(String[] args) {
        String s = "2 красные розы желтый тюльпан оранжевая альстромерия 3 желтых ромашки";
        String s1 = "2 красные розы желтый тюльпан оранжевая альстромерия 3 желтых ромашки";
        ArrayList<Flowers> flowers = new ArrayList<>(generateListFlower(s));
        ArrayList<Flowers> flowers1 = new ArrayList<>(generateListFlower(s1));
        Bouquet bouquetOne = new Bouquet(TypePackaging.KROCHET, flowers);
        Bouquet bouquetTwo = new Bouquet(TypePackaging.KROCHET, flowers1);
        System.out.println("Первый букет");
        System.out.println(bouquetOne);
        System.out.println("\nВторой букет");
        System.out.println(bouquetTwo);
        System.out.println("\nСравнение букетов: ");
        System.out.println((bouquetTwo.equals(bouquetOne)) ? "Букеты одинаковые." : "Букеты разные.");
    }

    public static ArrayList<Flowers> generateListFlower(String data) {//формирование списка цветов на основании строки
        int amount;//количество одинаковых цветков
        ArrayList<Flowers> flowers = new ArrayList<>();
        ColorFlower colorFlower; //расцветка
        TypeFlower typeFlower;//тип цветка
        CreatorFlower creatorFlower = new CreatorFlower();
        String regexp = "((\\d*)\\s*(красн|желт|син|оранжев|бордов|розов).*?\\s*(лили|тюльпан|альстромери|ромаш|роз|хризантем))";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {//определение количества одинаковых цветов
            if (!Objects.equals(matcher.group(2), "")) {
                amount = Integer.parseInt(matcher.group(2));
            } else {
                amount = 1;
            }
            switch (matcher.group(3)) {//определение расцветки цветка
                case "красн":
                    colorFlower = ColorFlower.RED;
                    break;
                case "желт":
                    colorFlower = ColorFlower.YELLOW;
                    break;
                case "син":
                    colorFlower = ColorFlower.BLUE;
                    break;
                case "оранжев":
                    colorFlower = ColorFlower.ORANGE;
                    break;
                case "бордов":
                    colorFlower = ColorFlower.BURGUNDY;
                    break;
                case "розов":
                    colorFlower = ColorFlower.PINK;
                    break;
                default:
                    colorFlower = ColorFlower.PINK;
                    break;
            }
            switch (matcher.group(4)) {//определение разновидности цветка
                case "лили":
                    typeFlower = TypeFlower.LILY;
                    break;
                case "тюльпан":
                    typeFlower = TypeFlower.TULIP;
                    break;
                case "альстромери":
                    typeFlower = TypeFlower.ALSTROEMERIA;
                    break;
                case "ромаш":
                    typeFlower = TypeFlower.CHAMOMILE;
                    break;
                case "роз":
                    typeFlower = TypeFlower.ROSE;
                    break;
                case "хризантем":
                    typeFlower = TypeFlower.CHRYSANTHEMUM;
                    break;
                default:
                    typeFlower = TypeFlower.ROSE;
                    break;
            }
            for (int i = 0; i < amount; i++) {//создание цветка по типу и цвету
                flowers.add(creatorFlower.createFlower(typeFlower, colorFlower));
            }
        }
        return flowers;
    }
}
