public class Product {
    private int id;
    private String name;
    private double price;
    private String view;
    private int amountity;

    public Product(int id, String name, double price, String view, int amountity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.view = view;
        this.amountity = amountity;
    }

    public int getАmountity() {
        return amountity;
    }

    public void setАmountity(int amountity) {
        if (amountity < 0){
            throw new IllegalArgumentException("Введено отрицательное число");
        }else {
            this.amountity = amountity;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getView() {
        return view;
    }

    public void setPrice(double price) {
        if (price < 0){
            throw new IllegalArgumentException("Введено отрицательное число");
        }else {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return id +" "+ name+ " - "+ price;
    }
}
