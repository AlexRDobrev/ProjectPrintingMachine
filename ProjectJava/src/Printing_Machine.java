import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Printing_Machine implements Serializable {
    private int max_load;
    private int paper_loaded;
    private int pages_per_minute;
    private boolean colored;
    private boolean black_and_white;
    private ArrayList<Edition> editions_to_print;

    Printing_Machine() {
    }

    Printing_Machine(int max_load,int paper_loaded, int pages_per_minute) {
        this.max_load=max_load;
        this.paper_loaded = paper_loaded;
        this.pages_per_minute = pages_per_minute;
        this.editions_to_print = new ArrayList<>();
    }
    public void Editions_Set_To_Print(ArrayList<Edition> editions){
            this.editions_to_print.addAll(editions);
    }
    public void Save_Editions_In_File(String FileOutput){

        for(Edition edition:editions_to_print){

            try(FileOutputStream fos=new FileOutputStream(FileOutput);
                ObjectOutputStream outputStream=new ObjectOutputStream(fos)
                ){

                outputStream.writeObject(edition);
            }catch(IOException ex){
                System.err.println(ex);
            }
        }
    }
    public void Read_Editions_In_File(String FileInput){

        for(Edition edition:editions_to_print){

            try (FileInputStream fis = new FileInputStream(FileInput);
                 ObjectInputStream inputStream = new ObjectInputStream(fis)) {

                edition = (Edition) inputStream.readObject();

            System.out.println(edition.getTitle() + ", Pages:" + edition.getPages_count() + ", Size of paper:" + edition.getSize_paper() + ", Type of paper:" + edition.getType_paper()+", Color:"+edition.getColor_paper());
            }catch(ClassNotFoundException ex){
                System.err.println("Class not found: "+ex);
            }catch(IOException ex){
                System.out.println("IO error:"+ex);
            }
        }
    }
    public void Add_Extra(Edition edition){
        this.editions_to_print.add(edition);
    }
    public synchronized void Print_Book(Edition edition) {
        if ((this.paper_loaded -= edition.getPages_count()) > 0) {
            System.out.println(Thread.currentThread().getName() + " printed " + edition.getTitle() + ", Pages:" + edition.getPages_count() + ", Size of paper:" + edition.getSize_paper() + ", Type of paper:" + edition.getType_paper()
                    +", Color:"+edition.getColor_paper());

        } else {

            throw new ArithmeticException("Not enough paper in machine! Please load this amount of paper: " + this.max_load);
        }
    }
    public synchronized ArrayList<Edition> getEditions_to_print(){return editions_to_print;}

}