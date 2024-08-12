package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product;

    public OrderItem() {
    }
    public OrderItem(Product product, Double price, Integer quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double subTotal(){
        price = product.getPrice() * quantity;
        return price;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(product.getName()).append(",").append(product.getPrice()).append(",").append(quantity).append(",").
                append(subTotal());
        return sb.toString();
    }
}
