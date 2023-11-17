import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String products;
    private String deliveryAddress;
    private int price;

    public void setId(int id) {
        this.id = id;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", price=" + price +
                '}';
    }
}
