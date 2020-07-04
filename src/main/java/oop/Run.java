package oop;

import oop.model.User;
import oop.model.enums.Gender;

public class Run {
    public static void main(String[] args) {

        User u1 = new User("Adam","Kowalski","ak@ak.pl","ak","123456123", Gender.MAN);
        User u2 = new User("Jan","Nowak","jn@jn.pl","jn","111111111", Gender.MAN);
        User u3 = new User("Anna","Lis","al@al.pl","al","123234345", Gender.WOMAN);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }
}
