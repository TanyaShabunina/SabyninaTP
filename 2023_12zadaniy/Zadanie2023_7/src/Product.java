import java.util.List;

public class Product extends OrderBuilder{
    @Override
    public void buildId(int id) {
        order.setId(id);
    }

    @Override
    public void buildPrice(int price) {
        order.setPrice(price);
    }

    @Override
    public void buildProducts(String products) {
        order.setProducts(products);
    }

    @Override
    public void buildDeliveryAddress(String deliveryAddress) {
        order.setDeliveryAddress(deliveryAddress);
    }
}
