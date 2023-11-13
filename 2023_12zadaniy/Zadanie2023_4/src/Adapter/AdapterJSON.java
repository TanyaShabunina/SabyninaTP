package Adapter;

import FileFormat.JSON;
import Interface.Actions;

public class AdapterJSON extends JSON implements Actions {
    @Override
    public void read() {
        readFile();
    }

    @Override
    public void write() {
        writeFile();
    }
}
