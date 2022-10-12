package treasure;

public enum TreasureMaterial {//материалы сокровищ
    SILVER("серебро"),
    GOLD("золото"),
    WHITE_GOLD("белое золото"),
    PLATINUM("платина");
    private String name;

    TreasureMaterial(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
