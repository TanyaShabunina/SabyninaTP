import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();
    public void order(List<Product> products){

        products.forEach(System.out::println);
        System.out.println("Выберите товар");
        execute(products);
    }
    private void  execute (List <Product> products){
        List <Product> listOrder = new ArrayList<>();
        int a= 0;
        do {
            a = scanner.nextInt();
            for (Product product : products) {
                    if (a == product.getId()) {
                        listOrder.add(new Product(product.getId(), product.getName(), product.getPrice(), product.getView(),1));
                    }
                }
            }
            while (a != 0);

        calculator.calc(listOrder);

    }








}
