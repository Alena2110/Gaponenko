import java.util.ArrayList;

public class VoucherCreator {
    public static void main(String[] args) {
        ArrayList<Voucher> vouchers = new ArrayList<>();
        vouchers.add(new Voucher("Стокгольм", VoucherType.CRUISE, 5, new FoodType[]{FoodType.AI, FoodType.BB},
                TransportType.SEA_TRANSPORT));
        vouchers.add(new Voucher("Стокгольм", VoucherType.CRUISE, 3, new FoodType[]{FoodType.HB, FoodType.BB, FoodType.UAI},
                TransportType.SEA_TRANSPORT));
        vouchers.add(new Voucher("Львов", VoucherType.EXCURSION, 6, new FoodType[]{FoodType.HB}, TransportType.TRAIN));
        vouchers.add(new Voucher("Париж", VoucherType.SHOPPING, 2, new FoodType[]{FoodType.RO},
                TransportType.BUS));
        vouchers.add(new Voucher("Карловы Вары", VoucherType.TREATMENT, 10, new FoodType[]{FoodType.HB, FoodType.BB, FoodType.UAI},
                TransportType.AIRPLANE));
        vouchers.add(new Voucher("Кемер", VoucherType.VACATION, 25, new FoodType[]{FoodType.HB, FoodType.BB, FoodType.UAI},
                TransportType.TRAIN));
        VoucherAction voucherAction = new VoucherAction();
        voucherAction.sortingTypeVoucher(vouchers);
        voucherAction.sortingNumberOfDays(vouchers);
        voucherAction.sortingTransportType(vouchers);
        voucherAction.sortingCity(vouchers);
        voucherAction.choiceOfVouchers(vouchers, VoucherType.CRUISE, 5, FoodType.AI, TransportType.SEA_TRANSPORT);
    }
}
