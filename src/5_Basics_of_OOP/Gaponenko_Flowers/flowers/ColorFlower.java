package flowers;

public enum ColorFlower {//возможные вариации расцветок у цветов
    YELLOW("желтый"),
    BLUE("синий"),
    RED("красный"),
    PINK("розовый"),
    ORANGE("оранжевый"),
    BURGUNDY("бордовый");
    private String name;

    ColorFlower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
