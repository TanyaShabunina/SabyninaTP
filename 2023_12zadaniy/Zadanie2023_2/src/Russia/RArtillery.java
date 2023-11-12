package Russia;

import Interface.Artillery;

public class RArtillery implements Artillery {
    @Override
    public void create() {
        System.out.println("Поставка артиллерии в Россию");
    }
}
