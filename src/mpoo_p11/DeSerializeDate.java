package mpoo_p11;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
    /**
     * @author Brigada A
     */ 
public class DeSerializeDate {
    DeSerializeDate(){
        Date d = null;
        try{
            FileInputStream f = new FileInputStream("date.ser");
            ObjectInputStream s = new ObjectInputStream(f);
            d = (Date) s.readObject();
            s.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Deserialized Date object from date.ser");
        System.out.println("Date "+d);
    }
}
