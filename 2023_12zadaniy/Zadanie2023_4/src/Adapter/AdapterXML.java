package Adapter;

import FileFormat.XML;
import Interface.Actions;

public class AdapterXML extends XML implements Actions {
    @Override
    public void read() {
        readFile();
    }

    @Override
    public void write() {
        writeFile();
    }
}
