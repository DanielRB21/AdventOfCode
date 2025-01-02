
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Daniel Solis Alfonso
 */
public class Day1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String linea;
        int acum=0;
        List<Integer> numerosA=new ArrayList();
        List<Integer> numerosB=new ArrayList();
        
        try {
            BufferedReader bf= new BufferedReader(new FileReader("inputs"+ File.separator+"01"+File.separator+"input.txt"));
            linea=bf.readLine();
            while(linea!=null){
                linea=linea.trim();
                linea=linea.replaceAll("   ", " ");
                String[] numeros=linea.split(" ");
                numerosA.add(Integer.parseInt(numeros[0]));
                numerosB.add(Integer.parseInt(numeros[1]));
                linea=bf.readLine();
            }
          Collections.sort(numerosA);
          Collections.sort(numerosB);
          for(int i=0;i<numerosA.size();i++){
              acum=acum+Math.abs(numerosA.get(i)-numerosB.get(i));
          }
            System.out.println(acum);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
