package Polymorphism.BurgerChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Burger extends Item{

    private final int MAXTOPPINGSALLOWED = 3;
    private int toppingsLeft = MAXTOPPINGSALLOWED;
    private Map<String, Double> toppingsPrice;
    private String[] toppingList = {"tomatoes", "CHEESE", "BACON", "BACON", "SEAWEED", "LETTUCE", "NUGGETS"};


    public Burger() {
        this("BigMac", 10);
    }

    public Burger(String name, double price) {
        super("Burger", name, price);
        toppingsPrice = new HashMap<>();
        cleanToppingData();
    }

    private void cleanToppingData(){
        toppingList = Arrays.stream(toppingList).distinct().toArray(String[]::new);
        Arrays.setAll(toppingList, i -> toppingList[i].toUpperCase());
    }

    protected void addTopping(String topping){
//        check topping exists from a predefined set
        topping = topping.toUpperCase();
        if( toppingsLeft > 0 && toppingsLeft <= MAXTOPPINGSALLOWED){
            if(Arrays.asList(toppingList).contains(topping)){
                toppingsLeft--;
                toppingsPrice.put(topping, toppingPrice(topping));
            }
        }
    }

// TODO: next level, divide into different prices based on topping
//    if ABALONE not in toppingPrice, it can't be 2$
    private double toppingPrice(String toppingChoice){
        return switch (toppingChoice.toUpperCase()) {
            case "NUGGETS" -> 7;
            case "EXOTIC" -> 5;
            case "BACON", "CHEESE", "SEAWEED" -> 3;
            default -> 2;
        };
    }

    protected void addToppings(String[] toppings){
        for (String topping : toppings) {
            addTopping(topping);
        }
    }

    public Map<String, Double> getAddedToppings(){
        return toppingsPrice;
    }

    public void printAddedToppings(){
        System.out.printf("%20s%n", "TOPPINGS");
        toppingsPrice.forEach(this::printItem);
        System.out.println("-".repeat(30));
    }

    public void printToppingList(){
        Arrays.stream(toppingList).forEach(System.out::println);
    }

}
