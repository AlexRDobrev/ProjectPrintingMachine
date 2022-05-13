import java.math.BigDecimal;

public enum Color_Paper {
    BlackAndWhite(BigDecimal.valueOf(1.99)),Colored(BigDecimal.valueOf(5.99));
    private BigDecimal price;
    Color_Paper(BigDecimal price) {
        setPrice(price);
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) > 0) {
            this.price = price;
        } else {
            this.price = BigDecimal.ZERO;
        }
    }
}
