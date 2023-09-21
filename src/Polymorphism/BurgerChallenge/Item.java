package Polymorphism.BurgerChallenge;

public class Item {

    private String type;
    private String name;
    private double price;
    private String size = "MEDIUM";
    private final double MINPRICE = 3;

    public Item() {
        this("ITEM", "MENU ITEM", 0);
    }

    public Item(String type, String name, double price) {
        this.type = type.toUpperCase();
        this.name = name.toUpperCase();
        this.price = Math.max(price, MINPRICE);
    }

    public void printItem(){
        printItem(getName(), price);
    }

    public void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public double getPrice() {
        if(getClass() == Item.class){
            return switch (size.toUpperCase()){
                case "SMALL" -> price - 1;
                case "LARGE" -> price + 2;
                case "XL" -> price + 3;
                default -> price;
            };
        }
        return price;
    }

    protected void changeSize(String size) {
        if(!(this instanceof Burger)) {
            switch(size){
                case "SMALL", "LARGE", "XL" -> this.size = size;
                default -> this.size = "MEDIUM";
            }
        }
    }

    public String getSize() {
        return size;
    }

    private String getName(){
        if(getClass() != Burger.class) return String.format("%s %s", size, name);
        return name;
//        String based check
//        return switch (type.toUpperCase()){
//            case "SIDE", "DRINK" -> String.format("%s %s", size, name);
//            default -> name;
//        };
    }

    public void printItemDescription(){
        String description = getClass() == Item.class ? "This is a default item description." :
                String.format("%s is a type of %s. A %s costs %.2f.", name, type, getName(), price);
        System.out.println(description);
    }

}
