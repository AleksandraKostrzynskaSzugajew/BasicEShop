public class Product {

    private int id;
    private String name;
    private static int nextId = 1;
    private double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static int getNextId() {
        return nextId;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, double price) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        try {
            if (price > 0.01) {
                this.price = price;
            }
        } catch (Exception e) {
            System.out.println("Try again");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
