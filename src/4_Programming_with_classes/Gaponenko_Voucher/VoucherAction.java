import java.util.ArrayList;
import java.util.Comparator;

public class VoucherAction {

    public boolean foodTypeChoice(Voucher voucher, FoodType foodType) {//выбор типа питания
        for (FoodType type : voucher.getFoodTypes()) {
            if (type.equals(foodType)) {
                return true;
            }
        }
        return false;
    }

    public void choiceOfVouchers(ArrayList<Voucher> vouchers, VoucherType voucherType, int numberOfDays, FoodType foodType,
                                 TransportType transportType) {//выбор путевок по критериям
        ArrayList<Voucher> choice = new ArrayList<>();
        for (Voucher voucher : vouchers) {
            if (voucher.getVoucherType().equals(voucherType) && voucher.getTransportType().equals(transportType) &&
                    voucher.getNumberOfDays() == numberOfDays && foodTypeChoice(voucher, foodType)) {
                choice.add(voucher);
            }
        }
        System.out.println("\nВыбор путевок\n");
        for (Voucher voucher : choice) {
            System.out.println(voucher);
        }

    }

    public void sortingTypeVoucher(ArrayList<Voucher> vouchers) {//сортировка по типу путевок
        vouchers.sort(Comparator.comparing(Voucher::getVoucherType, Comparator.naturalOrder()));
        System.out.println("\nСортировка путевок по типу\n");
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
        }
    }

    public void sortingNumberOfDays(ArrayList<Voucher> vouchers) {//сортировка по количеству дней
        vouchers.sort(Comparator.comparing(Voucher::getNumberOfDays, Comparator.naturalOrder()));
        System.out.println("\nСортировка путевок по количеству дней\n");
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
        }
    }

    public void sortingTransportType(ArrayList<Voucher> vouchers) {//сортировка по типу транспорта
        vouchers.sort(Comparator.comparing(Voucher::getTransportType, Comparator.naturalOrder()));
        System.out.println("\nСортировка путевок по типу транспорта\n");
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
        }
    }

    public void sortingCity(ArrayList<Voucher> vouchers) {//сортировка по городу
        vouchers.sort(Comparator.comparing(Voucher::getCity, Comparator.naturalOrder()));
        System.out.println("\nСортировка путевок городу\n");
        for (Voucher voucher : vouchers) {
            System.out.println(voucher);
        }
    }
}

