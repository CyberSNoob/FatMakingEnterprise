package Polymorphism.BurgerChallenge;

public class Meal {

    private Burger burger;
    private Item drink;
    private SideDish side;

    public Meal() {
        this(new Burger(), new Drink(), new SideDish());
    }

    public Meal(Burger burger, Drink drink, SideDish side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    protected double getTotalPrice() {
        return burger.getPrice() +
                burger.getAddedToppings().values().stream().mapToDouble(Double::doubleValue).sum() +
                drink.getPrice() + side.getPrice();
    }

    public void printAllItems(){
//        either list of items or one by one
        burger.printItem();
        System.out.println("-".repeat(30));
        burger.addToppings(new String[]{"what is this", "cheese", "bacon", "nuggets"});
        burger.printAddedToppings();
        drink.printItem();
        side.printItem();
        System.out.println("-".repeat(30));
        System.out.printf("%20s:%6.2f%n", "TOTAL PRICE", getTotalPrice());
    }

    public void changeDrinkSize(String drinkSize){
        drink.changeSize(drinkSize);
    }
}
