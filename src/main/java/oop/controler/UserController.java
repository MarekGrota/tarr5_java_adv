package oop.controler;

//klasa controllera - odpowiedzialna za obsługę i implementację logiki biznesowej aplikacji

import oop.model.User;
import oop.model.enums.Role;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

public class UserController implements UserControllerTemplate {
    private String passwordEncoder(String password) {
        try {
            // Obiekt do szyfrowania hasłą algorytmem MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Operacja szyfrowania zwraca tablicę liczb naturalnych
            byte[] passwordHash = md.digest(password.getBytes());

            // Zapisanie tablicy liczb w trybie String
            String passwordHashTxt = "";
            for (byte digit : passwordHash) {
                passwordHashTxt += String.format("%x", digit);
            }
            return passwordHashTxt;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override       // adnotacja - przysłanianie metody
    public void registerUser(User user) {
        // Aktualizacja hasła w modelu user
        user.setPassword(passwordEncoder(user.getPassword()));
        users.add(user);
        System.out.println("Dodano nowego użytkownika: " + user.getEmail());

    }


    @Override
    public List<User> findAllUsers() {
        return users;

    }

    @Override
    public boolean loginUser(String email, String password) {
        for (User user : users) {
            // porównanie email i hashów haseł
            if (user.getEmail().equals(email) && user.getPassword().equals(passwordEncoder(password))) {
                System.out.println("Zalogowano użytkownika: " + user.getEmail());
                return true;
            }
        }
        System.out.println("Błąd logowania!");
        return false;
    }


    @Override
    public User findUserByID(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                System.out.println("Znaleziono użytkownika: " + user);
                return user;

            }
        }
        System.out.println("Nie znaleziono użytkownika: " + userId);
        return null;
    }

    @Override
    public void updateUserPassword(int userId, String newPassword) {
        // 1. pobranie użytkownika z listy na podstawie userId
        User user = findUserByID(userId);
        // 2. Sprawdzenie czy użytkownik istnieje
        if(user != null) {
            // 3. zmiana hasła i zapisanie hash-u tego hasła
            user.setPassword(passwordEncoder(newPassword));
            System.out.println("Zmieniono hasło");
        } else {
            System.out.println("Nie zmieniono hasła");
        }
    }

    @Override
    public void deleteUserById(int userId) {

    }

    @Override
    public void updateRole(int userId, Set<Role> newRoles) {

    }


    @Override
    public List<User> findAllUsersOrderByArg(UserField userField, boolean asc) {
        return null;
    }
}
