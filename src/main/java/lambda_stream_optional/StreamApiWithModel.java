package lambda_stream_optional;

import oop.model.User;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
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

    public static void main(String[] args) {
        StreamApiWithModel sapi = new StreamApiWithModel();
//        sapi.getAllUsers();
        sapi.getAllUsersOrderByRegistrationDateDecs();
        System.out.println("Logowanie: " + sapi.loginUser("hl@hl.pl","hl" ));
    }
}
