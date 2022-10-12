public enum CapacityShip { //грузоподъемность корабля(количество контейнеров)
    ONE(1),
    TWO(2),
    THREE(3),
    FOR(4),
    FIFE(5);
    int numberOfContainers;

    CapacityShip(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }
}
