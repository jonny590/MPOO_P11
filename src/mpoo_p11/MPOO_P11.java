package mpoo_p11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Brigada A
 */
public class MPOO_P11 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        System.out.println("******* Ejercicio 1 *******");
        System.out.println("******* File *******");
        try {
            File archivo = new File("archivo.txt");
            System.out.println(archivo.exists());
            boolean seCreo = archivo.createNewFile();
            System.out.println(seCreo);
            System.out.println(archivo.exists());
        } catch (IOException ex) {
            System.out.println("ERROR. Archivo no creado");
        }
        
        System.out.println("\n******* Ejercicio 2 *******");
        System.out.println("******* FileOutputStream ********");
        FileOutputStream fos = null;
        byte [] buffer = new byte [150];
        int nBytes;
        try{
            System.out.println("Escribir el texto a guardar en el archivo");
            nBytes = System.in.read(buffer);
            fos = new FileOutputStream("fos.txt");
            fos.write(buffer, 0, nBytes);
        }catch(IOException ex){
            System.out.println("Error: "+ex.toString());
        }finally{
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException ex) {
                    System.out.println("ERROR. No se cerró correctamente el archivo");
                }
            }
        }
        
        System.out.println("\n******* Ejercicio 3 *******");
        System.out.println("******* FileInputStream ********");
        FileInputStream fis = null;
        String texto;
        try {
            fis = new FileInputStream("fos.txt");
            nBytes = fis.read(buffer, 0, 150);
            
            texto = new String(buffer, 0, nBytes); 
            System.out.println(texto);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOO_P11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOO_P11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n******* Ejercicio 4 *******");
        System.out.println("******* FileWriter *******");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribir texto a guardar: ");
        try {
            texto = br.readLine();
            FileWriter fw = new FileWriter("fw.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.println(texto);
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(MPOO_P11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n******* Ejercicio 5 *******");
        System.out.println("******* FileReader *******");
        try {
            FileReader fr = new FileReader("fw.txt");
            br = new BufferedReader(fr);
            System.out.println("El texto contenido en el archivo es: ");
            String linea = br.readLine();
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOO_P11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOO_P11.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n******* Ejercicio 6 *******");
        System.out.println("******* BufferedReader *******");
        try{
            String texto1 = "";
            BufferedReader br1;
            br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribir el texto deseado");
            texto1 = br1.readLine();
            System.out.println("El texto escrito fue: "+texto1);
        }catch(IOException ioe){
            System.out.println("Error al leer caracteres: \n"+ioe);
        }
        
        System.out.println("\n******* Ejercicio 7 *******");
        System.out.println("******* StringTokenizer *******");
        String texto2 = "";
        try{
            BufferedReader br2;
            br2 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribir texto: ");
            texto2 = br2.readLine();
            
            System.out.println("\n\n El texto separado por espacios es:");
            StringTokenizer st = new StringTokenizer(texto2);
            while(st.hasMoreElements()){
                System.out.println(st.nextToken());
            }
        }catch(Exception e){
            System.out.println("\n\nError al leer el teclado");
            e.printStackTrace();
        }
        
        System.out.println("\n******* Ejercicio 8 *******");
        System.out.println("******* Serializar *******");
        new SerializeDate();
        
        System.out.println("\n******* Ejercicio 9 *******");
        System.out.println("******* Deserializar *******");
        new DeSerializeDate();
    }
}
