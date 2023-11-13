package Adapter;

import FileFormat.CSV;
import Interface.Actions;

public class AdapterCSV extends CSV implements Actions {
    @Override
    public void read() {
        readFile();
    }

    @Override
    public void write() {
        writeFile();
    }
}
