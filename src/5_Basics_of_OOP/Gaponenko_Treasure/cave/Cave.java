package cave;

import treasure.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Cave {//пещера дракона
    private ArrayList<Treasure> treasureList;//список сокровищ

    public Cave() {
        treasureList = new ArrayList<>();
        generateTreasureList();
    }

    public ArrayList<Treasure> getTreasureList() {
        return treasureList;
    }

    public void generateTreasureList() {//генерация 100 сокровищ
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    treasureList.add(new TreasureSilver(i, TreasureType.values()[(random.nextInt(TreasureType.values().length))],
                            Math.round((Math.random() * 50 + 1) * 100.0) / 100.0));
                    break;
                case 1:
                    treasureList.add(new TreasureGold(i, TreasureType.values()[(random.nextInt(TreasureType.values().length))],
                            Math.round((Math.random() * 50 + 1) * 100.0) / 100.0));
                    break;
                case 2:
                    treasureList.add(new TreasureWhiteGold(i, TreasureType.values()[(random.nextInt(TreasureType.values().length))],
                            Math.round((Math.random() * 50 + 1) * 100.0) / 100.0));
                    break;
                case 3:
                    treasureList.add(new TreasurePlatinum(i, TreasureType.values()[(random.nextInt(TreasureType.values().length))],
                            Math.round((Math.random() * 50 + 1) * 100.0) / 100.0));
                    break;
            }
        }
    }

    public StringBuilder showTreasureList(ArrayList<Treasure> treasureList) {//вывод информации о сокровищах
        StringBuilder result = new StringBuilder();
        for (Treasure treasure : treasureList) {
            result.append("\n").append(treasure);
        }
        return result;
    }

    public StringBuilder maxCost() {//поиск сокровища с максимальной стоимостью
        int maxNumber = 0;
        for (int i = 1; i < 100; i++) {
            if (treasureList.get(maxNumber).getCost() < treasureList.get(i).getCost()) {
                maxNumber = i;
            }
        }
        return new StringBuilder().append("Максимальная стоимость: ").append(treasureList.get(maxNumber).getCost()).
                append(" у сокровища ").append(treasureList.get(maxNumber));
    }

    public StringBuilder buyTreasure(double sum) {//выбор сокровищ на сумму
        ArrayList<Treasure> buyTreasure = new ArrayList<>();
        treasureList.sort(Comparator.comparing(Treasure::getCost));
        double amount = 0;
        int i = 0;
        while ((treasureList.get(i).getCost() + amount) <= sum) {
            amount += treasureList.get(i).getCost();
            buyTreasure.add(treasureList.get(i));
            i++;
        }
        if (buyTreasure.size() != 0) {
            return new StringBuilder().append("На сумму ").append(sum).append(" (сумма покупки составит: ").
                    append(Math.round(amount * 10.0) / 10.0).append("; сдача: ").append(Math.round((sum - amount) * 10.0) / 10.0).
                    append(") можно купить следующие сокровища: ").append(this.showTreasureList(buyTreasure));
        } else {
            return new StringBuilder().append("\nСумма слишком мала, купить ничего нельзя.");
        }
    }
}



