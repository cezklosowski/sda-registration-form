import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Jeśli użytkownik wprowadzi niepoprawne dane powinniśmy wyświetlić "Niepoprawne dane" i zapytać ponownie co chce zrobić? - zwróć uwagę na komentarze przy poszczególnych nextLine
        // 2. Jeśli wszystkie wprowadzone przez użytkownika dane będą prawidłowe należy dodać go do tablicy uczestników, żeby to zrobić najpierw musimy taką stworzyć!
        //   a. Utwórz klasę Student mającą prywatne pola o nazwach odpowiadających temu co wprowadził użytkownik (imie, nazwisko, pesel, numer telefonu, jezyk, czy oplacony)
        //   b. W klasie Student utwórz gettery i settery
        //   c. W klasie Main w metodzie main na samym początku utwórz tablicę typu Student mającą pojemność 20 elementów (tyle maksymalnie będzie liczyła grupa)
        //   d. W tym samym miejscu utwórz zmienną, która będzie przechowywała wartość liczbową o ostatniej zapełnionej pozycji
        //   e. Po wprowadzeniu wszystkich poprawnych danych utwórz obiekt klasy Student i ustaw za pomocą setterów poszczególne pola na właściwe wartości
        //   f. Dodaj element do tablicy na jej następnej niezapełnionej pozycji
        // 3. Dodaj metodę toString() do klasy Student
        // 4. Dodaj obsługę wyświetlania wszystkich studentów zapisanych w liście (opcja 2)
        // 5. Dodaj obsługę wyświetlania tylko studentów, którzy opłacili kurs (dodaj opcję 3)

        ArrayList<Student> studentList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Zapisać się na kurs");
            System.out.println("2. Wyświetlić listę uczestników");
            System.out.println("q. Zakończyć");

            option = scanner.nextLine();

            if ("1".equals(option)) {
                System.out.println("Witaj!\nSłyszałem, że chcesz się zapisać na kurs!\nPodaj swoje dane i preferencje");

                String nameAndSurname = "";
                boolean nameAndSurnameCorrect = false;
                while (!nameAndSurnameCorrect) {
                    System.out.println("Imię i nazwisko"); // nie powinno zawierać żadnych znaków specjalnych, ANI _
                    String nameAndSurnameInput = scanner.nextLine();
                    if (nameAndSurnameInput.matches("[a-zA-z ]+")) {
                        nameAndSurname = nameAndSurnameInput;
                        nameAndSurnameCorrect = true;
                    } else {
                        System.out.println("Wprowadzono niepoprawne dane. Spróbuj ponownie.");
                        System.out.println();
                    }
                }

                String pesel = "";
                boolean peselCorrect = false;
                while (!peselCorrect) {
                    System.out.println("PESEL"); // powinien składać się z 11 cyfr - nic więcej nie sprawdzamy
                    //* zaawansowane wersja - sprawdzamy czy jest poprawny
                    String peselInput = scanner.nextLine();
                    if (peselInput.matches("[0-9]{11}")) {
                        // poprawnośc peselu
                        boolean isPeselCorrect = false;
                        char[] peselCharArray = peselInput.toCharArray();
                        Integer[] peselIntArray = new Integer[11];
                        for (int i = 0; i < peselCharArray.length; i++) {
                            peselIntArray[i] = Character.getNumericValue(peselCharArray[i]);
                        }
                        int result = peselIntArray[0] * 1 + peselIntArray[1] * 3 + peselIntArray[2] * 7 + peselIntArray[3] * 9 + peselIntArray[4] * 1 + peselIntArray[5] * 3 + peselIntArray[6] * 7 + peselIntArray[7] * 9 + peselIntArray[8] * 1 + peselIntArray[9] * 3 + peselIntArray[10] * 1;
                        if (result % 10 == 0) isPeselCorrect = true;

                        if (isPeselCorrect) {
                            pesel = peselInput;
                            peselCorrect = true;
                        }
                        else {
                            System.out.println("Wprowadzono niepoprawne dane. Spróbuj ponownie.");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Wprowadzono niepoprawne dane. Spróbuj ponownie.");
                        System.out.println();
                    }
                }

                String phoneNumber = "";
                boolean phoneNumberCorrect = false;
                while(!phoneNumberCorrect){
                    System.out.println("Numer telefonu"); // powinien składać się w sumie z 9 cyfr, może być rozdzielony w dowolnych miejscach spacją lub myślnikiem. Bez numeru kierunkowego
                    String phoneNumberInput = scanner.nextLine();
                    if (phoneNumberInput.matches("((\\d[ -]?){8})\\d")){
                        phoneNumber = phoneNumberInput;
                        phoneNumberCorrect = true;
                    } else{
                        System.out.println("Wprowadzono niepoprawne dane. Spróbuj ponownie.");
                        System.out.println();
                    }
                }

                String language = "";
                boolean languageCorrect = false;
                while (!languageCorrect) {
                    System.out.println("Wybrany język (Java, Python lub C++"); // możliwe wpisanie "Java" lub "Python" lub "C++"
                    String languageInput = scanner.nextLine();
                    if(languageInput.matches("Java|Python|C++")){
                        language = languageInput;
                        languageCorrect = true;
                    } else{
                        System.out.println("Wprowadzono niepoprawne dane. Spróbuj ponownie.");
                        System.out.println();
                    }
                }

                String paid = "";
                boolean paidCorrect = false;
                while (!paidCorrect) {
                    System.out.println("Czy opłaciłeś już kurs?(tak/nie)"); // możliwe wpisanie "tak" lub "nie"
                    String paidInput = scanner.nextLine();
                    if (paidInput.matches("tak|nie")){
                        paid = paidInput;
                        paidCorrect = true;
                    } else{
                        System.out.println("Wprowadzono niepoprawne dane. Spróbuj ponownie.");
                        System.out.println();
                    }
                }

                studentList.add(new Student(nameAndSurname,pesel,phoneNumber,language,paid));

            } else if ("2".equals(option)) {
                System.out.println("Oto wszyscy studenci:");
                System.out.println();
                //tutaj wypisz całą zawartość tablicy
                for (Student student:studentList) {
                    System.out.println(student);
                }
            }

        } while (!"q".equals(option));
    }
}
