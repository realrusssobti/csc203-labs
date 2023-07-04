public class Purchase {
    private final String product;
    private final int price;
    private final int quantity;
    public Purchase(String product, int price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }
    public String getProduct() {
        return product;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
