package oop;

import oop.controler.UserController;
import oop.controler.UserControllerTemplate;
import oop.model.User;
import oop.model.enums.Gender;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Run {
    public static void main(String[] args) {

        // for (User user : UserControllerTemplate.users) {
        //    System.out.println(user);


        // 1. Wywołanie obiektu klasy UserController
        UserController uc = new UserController();
        Scanner scanner = new Scanner(System.in);
        List<User> users = UserControllerTemplate.users;
        while (true) {
            System.out.println("Co chcesz zrobić? \n1. Rejestracja \n2. Lista użytkowników \nQ. Wyjście");
            String chioce = scanner.nextLine().toUpperCase();
            if (chioce.equals("1")) {
                System.out.println("Podaj imię: ");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko: ");
                String lastName = scanner.nextLine();
                System.out.println("Podaj email: ");
                String email = scanner.nextLine();
                String emailPattern = "^\\S{1,}[@]\\S{1,}$";    // s - non-whitespace character
                if (!Pattern.matches(emailPattern, email)) {
                    System.out.println("Błędny email");
                    continue;
                }
                System.out.println("Podaj hasło: ");
                String password = scanner.nextLine();
                System.out.println("Podaj płeć (M/K): ");
                String genderInput = scanner.nextLine().toUpperCase();
                String genderPattern = "^[MK]{1}$";

                if (!Pattern.matches(genderPattern,genderInput)) {
                    System.out.println("Błednie wprowadzona płeć!");
                    continue;
                }
                Gender gender = genderInput.equals("M") ? Gender.MAN : Gender.WOMAN;
                System.out.println("Podaj telefon (000-000-000): ");
                String phone = scanner.nextLine();

                // walicacja na podstawie regex-ów
                String phonePattern = "^[0-9]{3}(-[0-9]{3}){2}$";
                if (!Pattern.matches(phonePattern, phone)) {
                    System.out.println("Błędny numer telefonu!");
                    continue;
                }

                uc.registerUser(new User(name, lastName, email, password, phone, gender));

            } else if (chioce.equals("2")) {
                uc.findAllUsers().forEach(user -> System.out.println(user));

            } else if (chioce.equals("Q")) {
                System.out.println("Wyjście");
                break;
            } else {
                System.out.println("Blędny wybór.");
            }
        }
    }
}
