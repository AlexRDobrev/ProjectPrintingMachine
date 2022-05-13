import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Client implements Serializable {
    private String name;
    private int number_of_printed;
    private ArrayList<Edition> purchased_editions;
    private BigDecimal money_spent;

    Client(){}
    Client(String name){
        this.name=name;
        purchased_editions=new ArrayList<Edition>();
        this.money_spent=BigDecimal.ZERO;

    }
    public void add_Discounted_Book(Edition book) {
        BigDecimal discount = book.Price_Paper().multiply(BigDecimal.valueOf(10)).divide(BigDecimal.valueOf(100));
        BigDecimal total_price = book.Price_Paper().subtract(discount);
        money_spent = money_spent.add(total_price);
    }
            public void Make_Purchase(Edition purchased_edition,int copies,Type_Paper type_paper,Color_Paper color_paper) {
                for (int i = 0; i < copies; i++) {
                    purchased_edition.setType_paper(type_paper);
                    purchased_edition.setColor_paper(color_paper);
                    this.purchased_editions.add(purchased_edition);
                    BigDecimal total_price = purchased_edition.Price_Paper();
                    money_spent = money_spent.add(total_price);
                }
            }
    public void Check_Errors(Printing_Machine machine,Edition book){
        if(purchased_editions.size()<machine.getEditions_to_print().size()){
            int over_amount=machine.getEditions_to_print().size()-purchased_editions.size();
            for(int i=0;i<over_amount;i++){
                add_Discounted_Book(book);
            }
        }
    }
        public BigDecimal getMoney_spent(){return this.money_spent;}
        public synchronized ArrayList<Edition> getPurchased_editions(){return purchased_editions;}

}


