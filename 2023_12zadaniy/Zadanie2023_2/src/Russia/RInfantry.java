package Russia;

import Interface.Infantry;

public class RInfantry implements Infantry {
    @Override
    public void create() {
        System.out.println("Поставка пехоты в Россию");
    }
}
