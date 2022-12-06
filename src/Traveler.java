public class Traveler {
    private final String nameOfTheTraveler;
    private final String passportNumber;

    public Traveler(String nameOfTheTraveler, String passportNumber) {
        this.nameOfTheTraveler = nameOfTheTraveler;
        this.passportNumber = passportNumber;
    }

    public String getNameOfTheTraveler() {
        return nameOfTheTraveler;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "Имя путешественника: " + nameOfTheTraveler +
                ", номер паспорта: " + passportNumber;
    }
}
