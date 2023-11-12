package Russia;

import Interface.Artillery;
import Interface.Infantry;
import Interface.Tank;
import Interface.UnitFactory;

public class RFactory implements UnitFactory {
    @Override
    public Artillery getArtillery() {
        return new RArtillery();
    }

    @Override
    public Infantry getInfantry() {
        return new RInfantry();
    }

    @Override
    public Tank getTank() {
        return new RTank();
    }
}
