import Interface.Artillery;
import Interface.Infantry;
import Interface.Tank;
import Interface.UnitFactory;
import Japan.JFactory;
import Russia.RFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnitFactory unitFactory = null;
        do {
            System.out.println("""
                    Выберите фракцию:
                    1. Россия
                    2. Япония
                    0. Выход
                    """);
            switch (scanner.nextInt()){
                case 1 -> unitFactory = new RFactory();
                case 2 -> unitFactory = new JFactory();
                case 0 -> System.exit(0);
            }
            Artillery artillery = unitFactory.getArtillery();
            Tank tank = unitFactory.getTank();
            Infantry infantry = unitFactory.getInfantry();
            System.out.println("Начало поставок ...");
            artillery.create();
            tank.create();
            infantry.create();
        } while (true);
    }
}