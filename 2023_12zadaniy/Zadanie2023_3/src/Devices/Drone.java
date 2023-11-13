package Devices;

import Other.Command;
import Other.Devices;

public class Drone extends Devices {

    public Drone(Command command) {
        super(command);
    }
    @Override
    public void action() {
        command.action("Дрон выполняет действие ");
    }
}
