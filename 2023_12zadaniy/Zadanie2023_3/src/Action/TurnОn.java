package Action;

import Other.Command;

public class TurnОn implements Command {
    @Override
    public void action(String str) {
        System.out.println(str + "включиться");
    }
}
