import java.util.List;

public abstract class OrderBuilder {
    Order order;
    public void creatOrder(){
        order = new Order();
    }

    abstract public void buildId(int id);
    abstract public void buildPrice(int price);
    abstract public void buildProducts(String products);
    abstract public void buildDeliveryAddress(String deliveryAddress);

    Order getOrder(){
        return order;
    }
}

