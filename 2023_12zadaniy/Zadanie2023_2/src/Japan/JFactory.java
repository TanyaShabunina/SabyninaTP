package Japan;

import Interface.Artillery;
import Interface.Infantry;
import Interface.Tank;
import Interface.UnitFactory;

public class JFactory implements UnitFactory {
    @Override
    public Artillery getArtillery() {
        return new JArtillery();
    }

    @Override
    public Infantry getInfantry() {
        return new JInfantry();
    }

    @Override
    public Tank getTank() {
        return new JTank();
    }
}
