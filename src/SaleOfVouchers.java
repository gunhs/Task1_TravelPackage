public interface SaleOfVouchers {
    String addTour(String name, Tour tour);
    String getVoucher(String name);
    String bayTour(String name, Voucher voucher);
    String cancelTour(String name, String nameOfTraveler);
    String getInformation(String name);
}