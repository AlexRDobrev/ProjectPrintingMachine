import java.math.BigDecimal;

public enum Size_Paper {
    A1(BigDecimal.valueOf(1.99)),A2(BigDecimal.valueOf(1.59)),A3(BigDecimal.valueOf(1.29)),
    A4(BigDecimal.valueOf(1.09)),A5(BigDecimal.valueOf(0.99));
    private BigDecimal price;
    Size_Paper(BigDecimal price) {
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
