package Devices;

import Other.Command;
import Other.Devices;

public class AutonomСar extends Devices {
    public AutonomСar(Command command) {
        super(command);
    }

    @Override
    public void action() {
        command.action("Автономная машина выполняет действие ");
    }
}
