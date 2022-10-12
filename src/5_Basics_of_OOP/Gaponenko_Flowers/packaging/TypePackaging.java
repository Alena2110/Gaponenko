package packaging;

public enum TypePackaging {//разновидности упаковки
    BOX("коробка"),
    PAPER("бумага"),
    FOAMIRAN("фоамиран"),
    PACKAGE("пакет"),
    SISAL("сизаль"),
    KROCHET("крошет");
    private String name;

    TypePackaging(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
