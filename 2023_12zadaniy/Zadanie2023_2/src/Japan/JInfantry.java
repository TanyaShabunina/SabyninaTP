package Japan;

import Interface.Infantry;

public class JInfantry implements Infantry {
    @Override
    public void create() {
        System.out.println("Поставка пехоты в Японию");
    }
}
