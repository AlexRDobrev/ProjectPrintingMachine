import java.io.*;
import java.util.ArrayList;

public class Printing_Thread implements Runnable {
    private Printing_Machine machine;
    private ArrayList<Edition> edition_tread;

    Printing_Thread(Printing_Machine machine,ArrayList<Edition> edition_thread){
        this.machine=machine;
        this.edition_tread=edition_thread;
    }

    public ArrayList<Edition> getBook_tread(){return edition_tread;}
    @Override
    public void run(){
        for(Edition book:edition_tread) {
            machine.Print_Book(book);
        }
    }
}
