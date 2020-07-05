package oop.controller;

import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Interfejs -> czyli szablon wymagań dla klasy implementującej
public interface UserControllerTemplate {

    //pole statyczne finalne
    List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User("Adam", "Kowalski", "ak@ak.pl", "ak", "123-456-123", Gender.MAN),
                    new User("Jan", "Nowak", "jn@jn.pl", "jn", "111-111-111", Gender.MAN),
                    new User("Anna", "Lis", "al@al.pl", "al", "123-234-345", Gender.WOMAN)
            )
    );
    // metoda abstrakcyjna - metoda nie posiadająca ciała - implementacji -> sygnatura metody
    // [typ zwracanej wartości / void] [nazwa etody] ([argumenty / bez argumentów]);

    // rejestracja
    void registerUser(User user);

    // logowanie
    boolean loginUser(String email, String password);

    // wyszukiwanie użytkownika
    User findUserByID(int userId);

    // update password
    void updateUserPassword(int UresId, String newPassword);

    // usunięcie użytkownika
    void deleteUserById(int userId);

    // zmiana ról
    void updateRole(int userId, Set<Role> newRoles);

    // wypisywanie wszystkich użytkowników
    List<User> findAllUsers();

    //wypisanie użytkowników posortowanych po argumencie
    List<User> findAllUsersOrderByArg(UserField userField, boolean asc);

}
