package pizzaExercises;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {
    // metoda zwracająca cenę pizzy na podstawie cen składowych wszystkich jej składników
    public int calculatePizzaPrice(Pizza pizza) {
       return pizza.getIngredients().stream()
                .mapToInt(p -> p.getPrice()).sum();
    }

    // metoda zwracająca tylko pizze ostre
    public List<Pizza> getAllSpice() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .collect(Collectors.toList());
    }

    // metoda zwracająca najtańszą ostrą pizzę
    public Pizza findCheapestSpicy() {
        Optional<Pizza> pizzaOpt = Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .sorted(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))
                .findFirst();
        if (pizzaOpt.isPresent()) {
            return pizzaOpt.get();
        }
        System.out.println("Brak danych do pobrania.");
        return null;
    }

    // metoda wypisująca pizze wraz z cenami
    public void getAllPizzaWithPrices() {
        Arrays.stream(Pizza.values())
                .forEach(pizza -> System.out.println(pizza.getName() + " - " + calculatePizzaPrice(pizza) + " PLN"));
    }

    // metoda zwracająca najdroższą pizzę wegetariańską
    Pizza findMostExpensiveVegetarian() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().noneMatch(ingredient -> ingredient.isMeat()))
                .sorted(Comparator.comparing(this::calculatePizzaPrice).reversed())
                .findFirst().get();

    }
    public long countMeatIngredients (Pizza pizza) {
        return pizza.getIngredients().stream().filter(Ingredient::isMeat).count();
    }

    // metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.
    public List<Pizza> iLikeMeat() {
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isMeat()))
                .sorted(Comparator.comparing(this::countMeatIngredients).reversed()).collect(Collectors.toList());


    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("\nCena: " + pc.calculatePizzaPrice(Pizza.MARGHERITA));
        System.out.println("\nOstre: ");
        pc.getAllSpice().forEach(System.out::println);
        pc.getAllPizzaWithPrices();
        System.out.println("\nNajtańsza pizza ostra: ");
        System.out.println(pc.findCheapestSpicy());
        System.out.println("Najdroższa pizza wegetariańska: ");
        System.out.println(pc.findMostExpensiveVegetarian());
        System.out.println("Pizze mięsne z posortowaną liczbą składników: ");
        pc.iLikeMeat().forEach(pizza -> System.out.println(pizza + " " + pc.countMeatIngredients(pizza)));
    }
}
