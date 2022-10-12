import java.util.Arrays;

public class Voucher {//путевка
    private static int ID;
    private int id;//номер путевки
    private String city;//город
    private VoucherType voucherType;//тип путевки
    private int numberOfDays;//количество дней
    private FoodType[] foodTypes;//типы питания
    private TransportType transportType;//тип транспорта

    public Voucher(String city, VoucherType voucherType, int numberOfDays, FoodType[] foodTypes, TransportType transportType) {
        id = ++ID;
        this.city = city;
        this.voucherType = voucherType;
        this.numberOfDays = numberOfDays;
        this.foodTypes = foodTypes;
        this.transportType = transportType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(VoucherType voucherType) {
        this.voucherType= voucherType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public FoodType[] getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(FoodType[] foodTypes) {
        this.foodTypes = foodTypes;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    @Override
    public String toString() {
        return "Путевка № " + id + "; город: " + city + "; тип путевки: " + voucherType + "; количество дней: " + numberOfDays +
                "; варианты питания: " + Arrays.toString(foodTypes) + "; вид  транспорта: " + transportType;
    }

}
