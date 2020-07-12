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


    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println("\nCena: " + pc.calculatePizzaPrice(Pizza.MARGHERITA));
        System.out.println("\nOstre: ");
        pc.getAllSpice().forEach(System.out::println);
        System.out.println("\nNajtańsza pizza ostra: ");
        System.out.println(pc.findCheapestSpicy());
    }
}
