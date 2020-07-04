package collections;

import java.util.*;

public class JavaCollectionsExample {

    private List<String> names = new ArrayList<>(Arrays.asList("Jan", "Ala","Ola","Ela","Ala"));

    private Set<String> roles1 = new HashSet<>(Arrays.asList("Admin", "User"));
    private Set<String> roles2 = new HashSet<>(Arrays.asList("User", "Viewer", "Moderator"));

    //jakie mamy wszystkie role w serwisie www

    public  Set<String> getAllRoles () {
        //utworzenie pustego podręcznego zbioru z widocznością tylko w obrębie metody
        Set<String> allRoles = new TreeSet<>();
        // dodanie ról do tego zbioru pochodzących ze zbioru roles1 i roles2
        allRoles.addAll(roles1);
        allRoles.addAll(roles2);
        return allRoles;
    }
    // część wspólna zbiorów

    public Set<String> getNonUniqueRoles() {
        Set<String> nonUniqueRoles = new TreeSet<>();
        nonUniqueRoles.addAll(roles1);
        nonUniqueRoles.retainAll(roles2);
        return nonUniqueRoles;
    }
    // odwrotność części wspólnej
    public Set<String> getUniqueRoles() {
        Set<String> uniqueRoles = getAllRoles();
        uniqueRoles.removeAll(getNonUniqueRoles());
        return uniqueRoles;
    }

    private Map<Integer, String> decimalToRoman = new HashMap<>();
    private Map<String, Integer> romanToDecimal = new HashMap<>();
    public void generateValuesToMap() {
        decimalToRoman.put(0, "0");
        decimalToRoman.put(1, "I");
        decimalToRoman.put(2, "II");
        decimalToRoman.put(3, "III");
        decimalToRoman.put(4, "IV");
        decimalToRoman.put(5, "V");
        System.out.println(decimalToRoman);
    }

    public void generateMapRomanToDecimal() {
        for (Integer key : decimalToRoman.keySet()) {
            romanToDecimal.put(decimalToRoman.get(key), key);
        }
        System.out.println(romanToDecimal);
    }
    private Deque<String> messages = new ArrayDeque<>();

    public void sendMessage(String message) {
        messages.addLast(message);
        System.out.println(message);
    }
    private void receiveMessage() {
        try {
        while (!messages.isEmpty()) {
            System.out.println("Odebrano wiadomość: " + messages.removeFirst());
            System.out.println("Pozostałe wiadomości: " + messages);
            Thread.currentThread().sleep(2000);  //uśpienie programu na 2000ms
        }
    }catch (InterruptedException e) {
            e.printStackTrace();
        }


  //  public void communicationService() {


    }
    public void arrayOperations () {
        try {       // między nawaiasami wprowadzamy kod który moze generować wyjętek
            //utworzenie tablicy 10-cio elem.
            String[] names = new String[10];
            int[] numbers = {1, 2, 3, 4};

            System.out.println("Tablica nazw:");
            Arrays.stream(names)  //zamiana tablicy na stream
                    .forEach(s -> System.out.print(s + ",")); //da każdego elementu wykonaj predykat (CTRL + space)

            System.out.println("\nTablica liczb:");
            Arrays.stream(numbers).forEach(n -> System.out.print(n + ","));
            System.out.println("Modyfikacja wartości na indeksie");
            names[5] = "Anna";
            Arrays.stream(names).forEach(s -> System.out.print(s + ","));
            names[names.length - 1] = "Adam";
            //names[100] = "Jan";
            Arrays.stream(names).forEach(s -> System.out.print(s + ","));
        } catch (ArrayIndexOutOfBoundsException e) {         //obsługa wyjątku włączona gdy wyjątek danego typu
            System.out.println("Błąd indexowania tablicy");
        }
        System.out.println("\nPoza try-catch");

    }
    public void listOperations() {
        //utworzenie pustej listy
        List<String> names = new ArrayList<>();
        //utworzenie listy zainicjowanej wartościami
        List<Double> params = new ArrayList<>(Arrays.asList(1.2,1.4,1.11,4.));
        System.out.println(names);
        System.out.println(params);

    }

    public boolean findElement (List<String> names, String name) {
        return names.contains(name);

    }
    public void removeElement(String name) {
        System.out.println(names);
        names.remove(name); //usunięcie obiektu o wartości name podanej w argumencie metody
        System.out.println(names);
    }
    public void removeAllTheSameElement(String name) {
       System.out.println(names);
        names.removeAll(Arrays.asList(name)); //usunięcie obiektu o wartości name podanej w argumencie metody
        System.out.println(names);
    }
    public void setElement(String name) {
        System.out.println(names);
        names.set(0,name);
        names.set(names.size()-1,name);
        System.out.println(names);
    }
    public void getAllElements() {
        for (int i = 1; i < names.size(); i = i + 2) {
            System.out.println(names.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        JavaCollectionsExample ex = new JavaCollectionsExample();
   //   ex.arrayOperations();
        ex.listOperations();
        System.out.println("Wynik: " + ex.findElement(new ArrayList<>(Arrays.asList("Jan", "Ala","Ola","Ela","Ala")),"Ala"));
        ex.removeElement("Ala");
        ex.removeAllTheSameElement("Ala");
        ex.setElement("Adam");
        ex.getAllElements();
        System.out.println("\nAll roles: " + ex.getAllRoles());
        System.out.println("\nUnique roles: " + ex.getUniqueRoles());
        System.out.println();
        ex.generateValuesToMap();
        ex.generateMapRomanToDecimal();
        System.out.println("5 dziesietnie to: " + ex.decimalToRoman.get(5));
        ex.sendMessage("A");
        ex.sendMessage("B");
        ex.sendMessage("C");
        ex.receiveMessage();
    }

}
