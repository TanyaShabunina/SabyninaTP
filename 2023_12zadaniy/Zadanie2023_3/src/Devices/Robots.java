package Devices;

import Other.Command;
import Other.Devices;

public class Robots extends Devices {
    public Robots(Command command) {
        super(command);
    }

    @Override
    public void action() {
        command.action("Робот выполняет действие ");
    }
}
