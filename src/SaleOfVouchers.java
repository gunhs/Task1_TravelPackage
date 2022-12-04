public interface SaleOfVouchers {
    void addTour(String name, Tour tour);
    void getVoucher(String name);
    void bayTour(String name, Voucher voucher);
    void cancelTour(String name, String nameOfTraveler);
    void getInformation(String name);
}