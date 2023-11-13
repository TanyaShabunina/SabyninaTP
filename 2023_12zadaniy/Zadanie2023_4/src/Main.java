import Adapter.AdapterCSV;
import Adapter.AdapterJSON;
import Adapter.AdapterXML;
import Interface.Actions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Actions actions = null;
        do {
            System.out.println("""
                    Выберите формат:
                    1.CSV
                    2.JSON
                    3.XML
                    0.Выход
                    """);
            switch (scanner.nextInt()){
                case 1 -> actions = new AdapterCSV();
                case 2 -> actions = new AdapterJSON();
                case 3 -> actions = new AdapterXML();
                case 0 -> System.exit(0);
            }
            actions.read();
            actions.write();
        }while (true);
    }
}