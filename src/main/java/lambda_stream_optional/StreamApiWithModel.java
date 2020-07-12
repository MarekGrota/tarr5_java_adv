package lambda_stream_optional;

import oop.model.User;
import oop.model.enums.Gender;
import oop.model.enums.Role;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiWithModel {
    //metoda wypisująca zawartość listy users z InMemoryData
    public void getAllUsers() {
        InMemoryData.users.forEach(System.out::println);
    }

    // metoda wypisująca użytkowników posortowanych po dacie rejestracji malejąco
    public void getAllUsersOrderByRegistrationDateDecs() {
        InMemoryData.users.stream().sorted(Comparator.comparing(User::getRegistrationDateTime).reversed()).forEach(System.out::println);
    }

    // metoda do logowania -> loguje gdy email password zgadza się oraz status jest true i removed jest false
    public boolean loginUser(String email, String password) {
        return InMemoryData.users.stream().anyMatch(user -> user.getEmail().equals(email) &&
                user.getPassword().equals(password) && user.isStatus() && !user.isRemoved());
    }

    //metoda zwracająca liczbę kobiet
    public long countAllWomen() {
        return InMemoryData.users.stream().filter(user -> user.getGender().equals(Gender.WOMAN)).count();
    }


    // metoda zwracająca listę użytkowników zawierajacą rolę podaną w argumencie metody
    public List<User> getAllUsersContainsRole(Role role) {
        return InMemoryData.users.stream().
                filter(user -> user.getRoles().contains(role))
                .collect(Collectors.toList());

    }
    // metoda grupująca użytkowników po zbiorach ról
    public Map<Set<Role>, List<User>> grupUsersByRoleSet() {
        return InMemoryData.users.stream().collect(Collectors.groupingBy(User::getRoles));
    }

    // metoda do grupowania po płci
    public Map<Gender, List<User>> groupUsersByGender() {
        return InMemoryData.users.stream().collect(Collectors.groupingBy(o -> o.getGender()));
    }


    // metoda grupująca użytkowników po rolach występujących w zbiorach ról
    public Map<Role, List<User>> userRoleMapper() {
        Map<Role, List<User>> userRoleMap = new HashMap<>();
        for (Role role : Role.values()) {
            List<User> groupingUsers = new ArrayList<>();
            for (User user : InMemoryData.users) {
                if (user.getRoles().contains(role)) {
                    groupingUsers.add(user);
                    userRoleMap.put(role, groupingUsers);
                }
            }
        }
        return userRoleMap;
    }

    // metoda grupująca użytkowników po rolach występujących w zbiorach ról
//    public Map<Set<Role>, List<User>> grupUsersByRole() {
//        return InMemoryData.users.stream().collect(Collectors.groupingBy(o ->o.getRoles().));
//
//    }




    public static void main(String[] args) {
        StreamApiWithModel sapi = new StreamApiWithModel();
//        sapi.getAllUsers();
//        sapi.getAllUsersOrderByRegistrationDateDecs();
//        System.out.println("Logowanie: " + sapi.loginUser("hl@hl.pl", "hl"));
//        System.out.println("Liczba kobiet: " + sapi.countAllWomen());
//        sapi.getAllUsersContainsRole(Role.ROLE_ADMIN).forEach(System.out::println);
//        sapi.grupUsersByRoleSet().forEach((roles, users) -> System.out.printf("%30s | %30s\n", roles, users));
        sapi.userRoleMapper();
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_ADMIN));
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_USER));
        System.out.println(sapi.userRoleMapper().get(Role.ROLE_VIEWER));

    }
}
