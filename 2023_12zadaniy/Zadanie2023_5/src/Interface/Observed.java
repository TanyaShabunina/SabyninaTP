package Interface;

public interface Observed {
void addStock (String stock);
void removeStock (String stock);
void addObserver(Observer observer);
void notifyObserver();
}
