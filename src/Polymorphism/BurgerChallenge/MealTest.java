package Polymorphism.BurgerChallenge;

public class MealTest {

    public static void test(){
        testMeal();

    }

    private static void testAddTopping(){
        Burger b = new Burger();
        String[] toppings = {"salad","seaweed", "exotic", "bacon"};
        System.out.println("Standard meal price: " + b.getPrice());
        for (String topping : toppings) {
            b.addTopping(topping);
            System.out.println("Total: " + b.getPrice());
        }
    }

    private static void testAddToppings(){
        Burger b = new Burger();
        b.printAddedToppings(); // ignored because empty
        b.printAddedToppings();
    }

    private static void testDefault(Item item){
        String[] sizes = {"SMALL","MEDIUM","LARGE","XL", "do"};
        System.out.printf("Minimal price is %.2f.%n", item.getPrice());
        for (String size : sizes) {
            System.out.printf("Current size %s costs %.2f.\n", item.getSize(), item.getPrice());
            item.changeSize(size);
        }
    }

    private static void testItem(){
        Item item = new Burger();
        if(item instanceof Burger b){

        }
    }

    private static void testMeal(){
        Meal m = new Meal();
        m.printAllItems();
    }
}
