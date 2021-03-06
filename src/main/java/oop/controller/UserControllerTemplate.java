package oop.controller;

import oop.controller.enums.UserField;
import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Interfejs -> czyli szablon wymagań dla klasy go implementującej
public interface UserControllerTemplate {
    // pole statyczne finalne
    List<User> users = new ArrayList<>(
//            Arrays.asList(
//                    new User("Adam", "Kowalski", "ak@ak.pl", "ak", "123-123-123", Gender.MAN),
//                    new User("Jan", "Nowak", "jn@jn.pl", "jn", "333-123-123", Gender.MAN),
//                    new User("Anna", "Lis", "al@al.pl", "al", "444-231-823", Gender.WOMAN)
//            )
    );

    // metoda abstrakcyjna -> metoda nie posiadająca ciała - implementacji -> sygnatura metody
    // [typ zwrcanej wartości / void] [nazwa metody] ( [argument-y / bez argumentów] );
    // rejestracja
    void registerUser(User user);

    // logowanie
    boolean loginUser(String email, String password);

    // wyszukiwanie
    User findUserById(int userId);

    // zmiana hasła
    void updateUserPassword(int userId, String newPassword);

    // usunięcie użytkownika
    void deleteUserById(int userId);

    // zmiana ról
    void updateRole(int userId, Set<Role> newRoles);

    // wypisanie wszystkich użytkowników
    List<User> findAllUsers();

    // wypisanie użytkowników posortowanych po adresie email
    List<User> findAllUsersOrderByEmail( boolean asc);
}