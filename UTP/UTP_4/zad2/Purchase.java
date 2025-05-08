/**
 *
 *  @author Chudy Wiktor S30359
 *
 */

package zad2;


public class Purchase {

    private final String id;
    private final String fullName;
    private final String item;
    private final String price;
    private final String quantity;

    public Purchase(
            String id,
            String fullName,
            String item,
            String price,
            String quantity
    ) {
        this.id = id;
        this.fullName = fullName;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getItem() {
        return item;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return id + ";" + fullName + ";" + item + ";" + price + ";" + quantity;
    }
}
