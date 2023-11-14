import Company.Lilo;
import Company.Stitch;
import Interface.Observed;
import Interface.Observer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Observer first = new Investor("Disney");
        Observer second = new Investor("Walt");
        Observed lilo = new Lilo();
        Observed stitch = new Stitch();
        lilo.addObserver(first);
        stitch.addObserver(second);
        do {
            System.out.println("""
                    1.Лило
                    2.Стич
                    0.Выход
                    """);
            switch (scanner.nextInt()){
                case 1 -> {
                    System.out.println("Напишите цену Акций");
                    lilo.addStock(scanner.next());
                }
                case 2 ->{
                    System.out.println("Напишите цену Акций");
                    stitch.addStock(scanner.next());
                }
                case 0 -> System.exit(0);
            }


        }while (true);
    }
}