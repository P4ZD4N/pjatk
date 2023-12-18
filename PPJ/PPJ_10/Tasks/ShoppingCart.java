public class ShoppingCart {
    private String customerName;
    private Product[] products = new Product[0];
    private int productCount;

    public ShoppingCart(String customerName) {
        this.customerName = customerName;
    }

    public void addProduct(Product product) {
        Product[] productsWithOneMoreProduct = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++)
            productsWithOneMoreProduct[i] = products[i];
        productsWithOneMoreProduct[productsWithOneMoreProduct.length - 1] = product;
        products = productsWithOneMoreProduct;
        productCount = products.length;
    }

    public void displayProducts() {
        System.out.println("Products in " + customerName + "'s shopping cart:");
        for (Product product : products)
            System.out.println(product.toString());
        System.out.println(productCount == 1 ? productCount + " product" : productCount + " products");
    }
}
