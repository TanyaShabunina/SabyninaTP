package Company;

import Interface.Observed;
import Interface.Observer;

import java.util.ArrayList;
import java.util.List;

public class Stitch implements Observed {
    List<String> stock = new ArrayList<>();
    List <Observer> investor = new ArrayList<>();
    @Override
    public void addStock(String stock) {
        this.stock.add(stock);
        notifyObserver();
    }

    @Override
    public void removeStock(String stock) {
        this.investor.remove(stock);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        this.investor.add(observer);

    }

    @Override
    public void notifyObserver() {
        for (Observer observer: investor){
            observer.handEvent(this.stock);
        }
    }
}
