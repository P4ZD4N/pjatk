public class Product {
    private String name;
    private double price;
    private ShoppingCart shoppingCart;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addToShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
