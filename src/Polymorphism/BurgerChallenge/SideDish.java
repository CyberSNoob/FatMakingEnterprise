package Polymorphism.BurgerChallenge;

public class SideDish extends Item{

    private static double MINPRICE = 5;
    public SideDish() {
        this("Side", 3);
    }
    public SideDish(String type, double price) {
        super(type, "Fries", Math.max(price, MINPRICE));
    }

    @Override
    public double getPrice() {
        return switch (super.getSize().toUpperCase()){
            case "SMALL" -> super.getPrice() - 2;
            case "LARGE" -> super.getPrice() + 5;
            case "XL" -> super.getPrice() + 10;
            default -> MINPRICE;
        };
    }
}
