public interface SaleOfVouchers {
    void addTour(String name, Tour tour);
    void getTour(String name);
    void bayTour(String name, Traveler traveler);
    void cancelTour(String name, String nameOfTraveler);
    void getInformation(String name);
}