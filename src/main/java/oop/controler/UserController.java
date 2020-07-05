package oop.controler;

//klasa controllera - odpowiedzialna za obsługę i implementację logiki biznesowej aplikacji

import oop.model.User;
import oop.model.enums.Role;

import java.util.List;
import java.util.Set;

public class UserController implements UserControllerTemplate {

    @Override       // adnotacja - przysłanianie metody
    public void registerUser(User user) {
        users.add(user);
        System.out.println("Dodano nowego użytkownika: " + user.getEmail());

    }
    @Override
    public List<User> findAllUsers() {
        return users;

    }
    @Override
    public boolean loginUser(String email, String password) {
        return false;
    }

    @Override
    public User findUserByID(int userId) {
        return null;
    }

    @Override
    public void updateUserPassword(int UresId, String newPassword) {

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
