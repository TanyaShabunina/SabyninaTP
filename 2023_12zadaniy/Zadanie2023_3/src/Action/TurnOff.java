package Action;

import Other.Command;

public class TurnOff implements Command {
    @Override
    public void action(String str) {
        System.out.println(str + "выключиться");
    }
}
