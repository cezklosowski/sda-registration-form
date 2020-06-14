public class Student {

    private String nameAndSurname;
    private String pesel;
    private String phoneNumber;
    private String language;
    private String paid;

    public Student(String nameAndSurname, String pesel, String phoneNumber, String language, String paid) {
        this.nameAndSurname = nameAndSurname;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.language = language;
        this.paid = paid;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Imię i nazwisko: "+ nameAndSurname + "\n" +
                "PESEL: " + pesel + "\n" +
                "Telefon: " + phoneNumber + "\n" +
                "Język: " + language + "\n" +
                "Opłacony: " + paid + "\n" + "\n";
    }
}
