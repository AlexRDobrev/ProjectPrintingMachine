import java.math.BigDecimal;

public class MachineOperator extends Company{
    private String name;
    private BigDecimal salary;
    MachineOperator(){}
    MachineOperator(String name,BigDecimal salary){
        this.name=name;
        this.salary=salary;

    }
    public BigDecimal getSalary(){return salary;}
}
