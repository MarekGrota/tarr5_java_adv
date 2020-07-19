package anonymousClasses;

// KLASA ANOMINOWA
// 1. nie posiada nazwy
// 2. można utorzyć dokłądnie jedną instancję tej klasy
public class Main {
    public static void main(String[] args) {
        Object object = new EventController() {     // utworzenie obiektu poprzez wywołanie konstruktora EventController
            @Override
            public void printEvent() {
                System.out.println("Nowe wydarzenie.");
                EventController.formattedEventDate();

            }
        };
        ((EventController)object).printEvent();
    }
}
