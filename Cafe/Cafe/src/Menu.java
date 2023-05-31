import java.util.ArrayList;
import java.util.List;

public class Menu {
    public void menu(){
        Order order = new Order();

        List<Product> products =new ArrayList<>();

        products.add(new Pizza(1, "Куба", 3,1));
        products.add(new Pizza(2, "Пепперони", 5,1));
        products.add(new Pizza(3, "Мясная", 4,1));
        products.add(new Pizza(4, "Маргарита", 6,1));
        products.add(new Pizza(5, "4 сыра", 7,1));
        products.add(new Drinkables(6, "Чай зеленый", 1,1));
        products.add(new Drinkables(7, "Чай черный", 7,1));
        products.add(new Drinkables(8, "Сок", 1,1));
        products.add(new Drinkables(9,"Смузи",2,1));

        order.order(products);

    }

}
