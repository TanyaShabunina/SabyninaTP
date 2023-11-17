import java.util.Scanner;

public class Main {
    static OrderBuilder builder = new Product();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("""
                    1. Создать Order
                    0. Выход
                    """);
            switch (scanner.nextInt()){
                case 1 -> create();
                case 0 -> System.exit(0);
            }
        }while (true);
    }
    public static void create(){
        builder.creatOrder();
        System.out.println("Введите идентификатор заказа");
        builder.buildId(scanner.nextInt());
        System.out.println("Введите продукты");
        builder.buildProducts(scanner.next());
        System.out.println("Введите адрес доставки");
        builder.buildDeliveryAddress(scanner.next());
        System.out.println("Введите стоимость");
        builder.buildPrice(scanner.nextInt());

        Order order = builder.getOrder();
        System.out.println(order);
    }
}