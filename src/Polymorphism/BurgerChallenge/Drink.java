package Polymorphism.BurgerChallenge;

public class Drink extends Item{

    private static final double MINPRICE = 4;
    public Drink() {
        this("Drink", 2);
    }

    public Drink(String type, double price) {
        super(type, "Coke", Math.max(price, MINPRICE));
    }

    @Override
    public double getPrice(){
// check price has a minimum
        return switch (super.getSize().toUpperCase()){
            case "SMALL" -> super.getPrice() - 1;
            case "LARGE" -> super.getPrice() + 2;
            case "XL" -> super.getPrice() + 3;
            default -> MINPRICE;
        };
    }
}
