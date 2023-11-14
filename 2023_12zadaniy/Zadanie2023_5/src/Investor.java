import Interface.Observer;

import java.util.List;

public class Investor implements Observer {
    String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void handEvent(List<String> stock) {
        System.out.println(name + ". У нас новые цены на акции для вас:\n" + stock + "\n");
    }
}
