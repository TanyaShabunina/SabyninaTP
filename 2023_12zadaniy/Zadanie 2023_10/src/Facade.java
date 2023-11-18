import Actions.MakeAnOrder;
import Actions.PayTheBill;
import Actions.ViewMenu;

public class Facade {
    MakeAnOrder makeAnOrder = new MakeAnOrder();
    ViewMenu viewMenu = new ViewMenu();
    PayTheBill payTheBill = new PayTheBill();
    public void setMakeAnOrder(){
        makeAnOrder.makeAnOrder();
    }
    public void setViewMenu(){
        viewMenu.viewMenu();
    }
    public void setPayTheBill(){
        payTheBill.payTheBill();
    }

}
