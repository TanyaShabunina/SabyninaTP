import java.util.List;

public class PrintCheck {
    public void check(List<Product> check, double discount, double sum){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Чек");
        for (Product product : check) {
            System.out.println(product.getName() + " " + product.getАmountity() + " шт " + product.getPrice() + " руб");
        }
        System.out.println("Сумма заказа = " + sum);
        System.out.println("Скидка = " + discount);

    }
}
