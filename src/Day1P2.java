
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Solís Alfonso
 */
public class Day1P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String linea;
        int acum = 0;
        int index;
        int j;
        List<Integer> numerosA = new ArrayList();
        List<Integer> numerosB = new ArrayList();

        try {
            BufferedReader bf = new BufferedReader(new FileReader("inputs"+ File.separator+"01"+File.separator+"input.txt"));
            linea = bf.readLine();
            while (linea != null) {
                linea = linea.trim();
                linea = linea.replaceAll("   ", " ");
                String[] numeros = linea.split(" ");
                numerosA.add(Integer.parseInt(numeros[0]));
                numerosB.add(Integer.parseInt(numeros[1]));
                linea = bf.readLine();
            }
            for (int i = 0; i < numerosA.size(); i++) {
                j=0;
                index = numerosB.indexOf(numerosA.get(i));
                if (index != -1) {
                    List<Integer> copiaNumerosB =new ArrayList<>(numerosB);
                    while (index != -1) {
                        j++;
                        //System.out.println("Posicion "+i+" Esta en "+index);
                        copiaNumerosB.remove(index);
                        index = copiaNumerosB.indexOf(numerosA.get(i));
                    }
                    acum+=numerosA.get(i)*j;
                }
            }
            System.out.println(acum);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Day1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
