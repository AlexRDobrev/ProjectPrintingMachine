import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Company implements Serializable {
    private String name;
    private BigDecimal salary_expenses;
    private BigDecimal paper_expenses;
    private BigDecimal profit;
    ArrayList<MachineOperator> machine_operators;
    ArrayList<Manager> managers;
    ArrayList<Client> clients;

    Company(){}
    Company(String name){
        this.name=name;
        this.salary_expenses=BigDecimal.ZERO;
        this.profit=BigDecimal.ZERO;
        this.paper_expenses=BigDecimal.ZERO;
        machine_operators=new ArrayList<MachineOperator>();
        managers=new ArrayList<Manager>();
        clients=new ArrayList<Client>();

    }
    public void addMachineOperators(MachineOperator machineOperator) {
        if ((!machine_operators.contains(machineOperator))){
            this.machine_operators.add(machineOperator);
        }
    }
    public void addManager(Manager manager) {
        if ((!managers.contains(manager))){
            this.managers.add(manager);
        }
    }
    public void addClient(Client client) {
            this.clients.add(client);
    }

    public void fireMachineOperators(MachineOperator machineOperator) {
        this.machine_operators.remove(machineOperator);
    }
    public void fireManager(Manager manager) {
        this.managers.remove(manager);
    }

    public BigDecimal Salary_Expenses(String FileOutput){
        for(MachineOperator machineOperator:machine_operators){

            this.salary_expenses=this.salary_expenses.add(machineOperator.getSalary());
        }
        for(Manager manager:managers){

            this.salary_expenses=this.salary_expenses.add((manager.getSalary()));
            BigDecimal usual_profit=BigDecimal.valueOf(10000);
            if(profit.compareTo(usual_profit)>0){
                BigDecimal One_Hundred = new BigDecimal(100);
                BigDecimal percentage = new BigDecimal(15);
                BigDecimal extra_salary = new BigDecimal(0);
                extra_salary = manager.getSalary().multiply(percentage).divide(One_Hundred);
                this.salary_expenses=this.salary_expenses.add(extra_salary);
            }
        }
        return this.salary_expenses;
    }
    public BigDecimal Paper_Expenses(int bought_normal_paper,int bought_glance_paper,int bought_newspaper_paper){
        paper_expenses=(Type_Paper.Normal.getPrice().multiply(BigDecimal.valueOf(bought_normal_paper))).add(Type_Paper.Glance.getPrice().multiply(BigDecimal.valueOf(bought_glance_paper))).add(Type_Paper.NewsPaper.getPrice().multiply(BigDecimal.valueOf(bought_newspaper_paper)));
        return paper_expenses;
    }
    public BigDecimal Calculate_Profit(){
        for(Client client:clients){
            profit=profit.add(client.getMoney_spent());

        }
        return this.profit;
    }

    public BigDecimal getProfit(){return profit;}
    public BigDecimal getSalary_cost(){return salary_expenses;}
    public BigDecimal getPaper_expenses(){return paper_expenses;}

}
