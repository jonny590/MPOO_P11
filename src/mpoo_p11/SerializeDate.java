package mpoo_p11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
    /**
     * @author Brigada A
     */
public class SerializeDate {
    SerializeDate(){
        Date d = new Date();
        System.out.println(d);
        try{
            FileOutputStream f = new FileOutputStream("date.ser");
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(d);
            s.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
