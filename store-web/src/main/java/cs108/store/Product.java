package cs108.store;

public class Product {
    private String productId;
    private String name;
    private String imageFile;
    private int price;

    public Product(String productId, String name, String imageFile, int price) {
        this.productId = productId;
        this.name = name;
        this.imageFile = imageFile;
        this.price = price;
    }

    public String getId() { return productId; }
    public String getName() { return name; }
    public String getImageFile() { return imageFile; }
    public double getPrice() { return price; }
}
