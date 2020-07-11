package polymorphism;

public class MainPolymorphism {
    public static void main(String[] args) {
        // polimorfizm -> przypisanie typu nadrzędnego pocjhodzącego z klasy potomnej
        Object openSpaceObject = new OpenSpace("01", 3, 1, "XXX", 10);
        Company openSpace1 = new OpenSpace("01", 3, 1, "XXX", 10);
        System.out.println(" obiekt openSpaceObject jest reprezentantem klasy: " + openSpaceObject.getClass().getName());
        System.out.println(openSpaceObject);
        System.out.println(" obiekt openSpaceObject jest reprezentantem klasy: " + openSpace1.getClass().getName());
        System.out.println(openSpace1);
    }
}
