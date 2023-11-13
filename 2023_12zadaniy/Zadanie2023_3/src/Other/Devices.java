package Other;

import Other.Command;

public abstract class Devices {
    public Command command;

    public Devices(Command command) {
        this.command = command;
    }
    public abstract void action();
}
