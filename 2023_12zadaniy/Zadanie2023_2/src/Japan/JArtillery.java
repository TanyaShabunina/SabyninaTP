package Japan;

import Interface.Artillery;

public class JArtillery implements Artillery {

    @Override
    public void create() {
        System.out.println("Поставка артиллерии в Японию");
    }
}
