import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            FactoryTools factoryTools = null;
            System.out.println("""
                    Какой инструмент вы хотите выбрать?
                    1. кисть
                    2. ластик
                    3. карандаш
                    0. Выход
                    """);
            switch (scanner.nextInt()) {
                case 1 -> factoryTools = new FactoryBrush();
                case 2 -> factoryTools = new FactoryEraser();
                case 3 -> factoryTools = new FactoryPencil();
                case 0 -> System.exit(0);
            }
            factoryTools.print();
        } while (true);


    }
}