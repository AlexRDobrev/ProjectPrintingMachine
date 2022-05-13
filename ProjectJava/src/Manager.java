import java.math.BigDecimal;
import java.util.ArrayList;

public class Manager extends Client{
    private String name;
    private BigDecimal salary;
    private BigDecimal profit;

    Manager(){}
    Manager(String name,BigDecimal salary){
        this.name=name;
        this.salary=salary;
        this.profit=this.getMoney_spent();

    }
    public BigDecimal ExtraSalary(){
        int res;
        res=profit.add(BigDecimal.valueOf(10000)).compareTo(getMoney_spent());
        if(res==1){
            BigDecimal One_Hundred = new BigDecimal(100);
            BigDecimal percentage = new BigDecimal(15);
            BigDecimal extra_salary = new BigDecimal(0);
            extra_salary = this.salary.multiply(percentage).divide(One_Hundred);
            return extra_salary;
        }
        return BigDecimal.valueOf(0);
    }

    public BigDecimal getSalary(){return salary;}
}
