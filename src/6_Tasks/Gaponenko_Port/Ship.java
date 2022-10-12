
public class Ship extends Thread {
    private Port port;//порт
    private int capacityShip;//грузоподъемность корабля
    private boolean isUnloading;//true-разгрузка, false-загрузка корабля
    private String nameShip;//название корабля

    Ship(Port port, CapacityShip capacity, boolean isUnloading, String nameShip) {
        super(nameShip);
        this.nameShip = nameShip;
        this.port = port;
        this.capacityShip = capacity.getNumberOfContainers();
        this.isUnloading = isUnloading;
    }

    public int getCapacityShip() {
        return capacityShip;
    }

    public void run() {
        System.out.println(this.nameShip + " ожидает порт");
        try {
            port.getControlNumberPier().acquire();//корабль ожидает разгрузки/погрузки
            if (isUnloading) {//разгрузка корабля
                for (int i = 0; i < this.getCapacityShip(); i++) {
                    port.unloading();
                    sleep(10);
                }
            } else {//загрузка корабля
                for (int i = 0; i < this.getCapacityShip(); i++) {
                    port.loading();
                    sleep(10);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.nameShip + " освободил порт");
        port.getControlNumberPier().release();//корабль разгрузился/загрузился и освободил порт
    }

    @Override
    public String toString() {
        return "\n" + nameShip + " с грузоподъемностью " + capacityShip + " конт. в порту для " + (isUnloading ? "разгрузки" : "загрузки");
    }
}
