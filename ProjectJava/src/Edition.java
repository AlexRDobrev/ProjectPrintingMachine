import java.io.Serializable;
import java.math.BigDecimal;

public class Edition implements Serializable {
    private String title = "";
    private int pages_count;
    private Size_Paper size_paper;
    private Type_Paper type_paper;
    private Color_Paper color_paper;

   Edition() {}

    Edition(String title, int pages_count, Size_Paper size_paper) {
        this.title = title;
        this.pages_count = pages_count;
        this.size_paper = size_paper;

    }
    public BigDecimal Price_Paper() {
        BigDecimal price_type;
        BigDecimal price_size;
        BigDecimal price_color;
        BigDecimal total_price;
        price_type=type_paper.getPrice();
        price_size=size_paper.getPrice();
        price_color=color_paper.getPrice();
        total_price=(price_type.add(price_size)).add(price_color);

        return total_price.multiply(BigDecimal.valueOf(pages_count));
    }
    public int getPages_count(){return pages_count;}
    public String getTitle(){return title;}
    public Size_Paper getSize_paper() {
        return size_paper;
    }
    public void setSize_paper(Size_Paper size_paper){this.size_paper = size_paper;}
    public Type_Paper getType_paper() {
        return type_paper;
    }
    public void setType_paper(Type_Paper type_paper){this.type_paper = type_paper;}
    public Color_Paper getColor_paper(){return color_paper;};
   public void setColor_paper(Color_Paper color_paper){this.color_paper=color_paper;}
}
