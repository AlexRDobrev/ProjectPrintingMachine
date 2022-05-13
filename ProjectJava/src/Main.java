import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void Save_Company_Data(String FileOutput,Company company){
        try(FileOutputStream fos=new FileOutputStream(FileOutput);
            ObjectOutputStream outputStream=new ObjectOutputStream(fos)
        ){

            outputStream.writeObject(company);
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
    public static void Read_Company_Data(String FileInput){

        try (FileInputStream fis = new FileInputStream(FileInput);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {

            Company company =(Company) inputStream.readObject();

            System.out.println(company.getProfit());
            System.out.println(company.getSalary_cost());
            System.out.println(company.getPaper_expenses());
        }catch(ClassNotFoundException ex){
            System.err.println("Class not found: "+ex);
        }catch(IOException ex){
            System.out.println("IO error:"+ex);
        }
    }
    public static void main(String[] args) {
        ArrayList<String>size_paper=new ArrayList<>();
        ArrayList<String>type_paper=new ArrayList<>();
        ArrayList<String>color_paper=new ArrayList<>();
        ArrayList<Double>price_size=new ArrayList<>();
        ArrayList<Double>price_type=new ArrayList<>();
        ArrayList<Double>price_color=new ArrayList<>();

        price_size.add(5.99);
        price_size.add(6.99);
        price_size.add(7.99);
        price_size.add(8.99);
        price_size.add(9.99);

        price_type.add(1.99);
        price_type.add(5.99);
        price_type.add(0.99);

        size_paper.add("A1");
        size_paper.add("A2");
        size_paper.add("A3");
        size_paper.add("A4");
        size_paper.add("A5");

        type_paper.add("Normal");
        type_paper.add("Glance");
        type_paper.add("NewsPaper");

        color_paper.add("BlackAndWhite");
        color_paper.add("Colored");

        price_color.add(0.99);
        price_color.add(2.99);

        Size_Paper.A1.setPrice(BigDecimal.valueOf(price_size.get(0)));
        Size_Paper.A2.setPrice(BigDecimal.valueOf(price_size.get(1)));
        Size_Paper.A3.setPrice(BigDecimal.valueOf(price_size.get(2)));
        Size_Paper.A4.setPrice(BigDecimal.valueOf(price_size.get(3)));
        Size_Paper.A5.setPrice(BigDecimal.valueOf(price_size.get(4)));

        Type_Paper.Normal.setPrice(BigDecimal.valueOf(price_type.get(0)));
        Type_Paper.Glance.setPrice(BigDecimal.valueOf(price_type.get(1)));
        Type_Paper.NewsPaper.setPrice(BigDecimal.valueOf(price_type.get(2)));

        Color_Paper.BlackAndWhite.setPrice(BigDecimal.valueOf(price_color.get(0)));
        Color_Paper.Colored.setPrice(BigDecimal.valueOf(price_color.get(1)));

        String FilePath="backup.ser";
        Company comp1=new Company("Papers Please!");
        Edition book1=new Edition("Black Death",120,Size_Paper.valueOf(size_paper.get(1)));
        Edition book2=new Edition("New Life",100,Size_Paper.valueOf(size_paper.get(4)));
        Edition book3=new Edition("Graveyard",100,Size_Paper.valueOf(size_paper.get(3)));
        Edition book4=new Edition("Ferrari",100,Size_Paper.valueOf(size_paper.get(2)));
        Edition book5=new Edition("Savior",100,Size_Paper.valueOf(size_paper.get(0)));
        MachineOperator mach_op1=new MachineOperator("Ivan",BigDecimal.valueOf(750));
        MachineOperator mach_op2=new MachineOperator("Alex",BigDecimal.valueOf(900));
        MachineOperator mach_op3=new MachineOperator("Alq",BigDecimal.valueOf(600));
        Manager manager1=new Manager("Georgi",BigDecimal.valueOf(1200));
        Manager manager2=new Manager("Sasha",BigDecimal.valueOf(1000));
        comp1.addMachineOperators(mach_op1);
        comp1.addMachineOperators(mach_op2);
        comp1.addMachineOperators(mach_op3);
        comp1.addManager(manager1);
        Client client1=new Client("Alex");
        Client client2=new Client("Ivan");
        client1.Make_Purchase(book1,4,Type_Paper.valueOf(type_paper.get(1)),Color_Paper.valueOf(color_paper.get(0)));
        client2.Make_Purchase(book2,6,Type_Paper.valueOf(type_paper.get(1)),Color_Paper.valueOf(color_paper.get(1)));
        comp1.addClient(client1);
        comp1.addClient(client2);
        Printing_Machine mach1=new Printing_Machine(500,500,10);
        Printing_Machine mach2=new Printing_Machine(400,400,30);
        Printing_Machine mach3=new Printing_Machine(700,700,15);
        Printing_Machine mach4=new Printing_Machine(200,200,20);
        mach1.Editions_Set_To_Print(client1.getPurchased_editions());
        mach2.Editions_Set_To_Print(client2.getPurchased_editions());
        mach1.Add_Extra(book1);
        client1.Check_Errors(mach1,book1);
        Thread machine1=new Thread(new Printing_Thread(mach1, mach1.getEditions_to_print()),"First_Machine");
        Thread machine2=new Thread(new Printing_Thread(mach2,mach2.getEditions_to_print()),"Second_Machine");
        machine1.start();
        machine2.start();
        mach1.Save_Editions_In_File(FilePath);
        mach1.Read_Editions_In_File(FilePath);
        mach2.Save_Editions_In_File(FilePath);
        mach2.Read_Editions_In_File(FilePath);
        System.out.println(comp1.Calculate_Profit());
        System.out.println(comp1.Salary_Expenses(FilePath));
        System.out.println(comp1.Paper_Expenses(2000,1000,800));
        Save_Company_Data(FilePath,comp1);
        Read_Company_Data(FilePath);

    }
}
