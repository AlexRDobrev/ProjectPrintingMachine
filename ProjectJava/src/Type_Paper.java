import java.math.BigDecimal;

public enum Type_Paper {
    Normal(BigDecimal.valueOf(1.99)),Glance(BigDecimal.valueOf(5.99)),NewsPaper(BigDecimal.valueOf(0.99));
    private BigDecimal price;
    Type_Paper(BigDecimal price) {
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
