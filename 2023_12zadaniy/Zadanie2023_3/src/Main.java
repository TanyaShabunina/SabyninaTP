import Action.TurnOff;
import Action.TurnОn;
import Other.Command;
import Other.Devices;
import Devices.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {

            Devices devices = null;
            System.out.println("""
                    Выберите действие:
                    1.Включить
                    2.Выключить
                    0.Выход
                    """);
            Command command = null;
            switch (scanner.nextInt()) {
                case 1 -> command = new TurnОn ();
                case 2 -> command = new TurnOff();
                case 0 -> System.exit(0);
            }
            System.out.println("""
                    Выберите устройство:
                    1.Дрон
                    2.Робот
                    3.Автономная машина
                    """);
            switch (scanner.nextInt()){
                case 1 -> devices = new Drone(command);
                case 2 -> devices = new Robots(command);
                case 3 -> devices = new AutonomСar(command);
            }
            devices.action();
        }while (true);
    }
}