package treasure;

public enum TreasureType {//виды сокровищ
    RING("кольцо"),
    BRACELET("браслет"),
    PENDANT("кулон"),
    EARRINGS("серьги"),
    CHAIN("цепочка");
    private String name;

    TreasureType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
