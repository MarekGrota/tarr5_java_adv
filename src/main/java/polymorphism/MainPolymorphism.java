package polymorphism;

import oop.controller.UserController;
import oop.controller.UserControllerTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainPolymorphism {
    public static void hasMoreRooms(Company c1, Company c2) {
        if (c1.getRoomsQuantity() > c2.getRoomsQuantity()) {
            System.out.println("Firma: " + c1.getCompanyName() + " posiada więcej pokoi");

        } else if (c1.getRoomsQuantity() == c2.getRoomsQuantity()) {
            System.out.println("Obie firmy mają tyle samo pokoi.");
        } else {
            System.out.println("Firma " + c2.getCompanyName() + " posiada więcej pokoi.");
        }
    }

    public static void main(String[] args) {
        // polimorfizm -> przypisanie typu nadrzędnego pocjhodzącego z klasy potomnej
        Object openSpaceObject = new OpenSpace("O1", 5, 1, "XXX", 10);
        Company openSpace1 = new OpenSpace("X", 3, 1, "XXX", 10);
        System.out.println(" obiekt openSpaceObject jest reprezentantem klasy: " + openSpaceObject.getClass().getName());
        System.out.println(openSpaceObject);
        System.out.println(" obiekt openSpaceObject jest reprezentantem klasy: " + openSpace1.getClass().getName());
        System.out.println(openSpace1);
        //===================================
        hasMoreRooms(openSpace1, (Company) openSpaceObject);    // castowanie -> konwersja na typ Company
        hasMoreRooms(new Company("TTT", 3), openSpace1);

        // to też jest polimorfizm
        List<String> name = new ArrayList<>();
        UserControllerTemplate example = new UserController();
    }
}
