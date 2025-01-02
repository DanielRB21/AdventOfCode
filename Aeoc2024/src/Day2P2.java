
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel Solís Alfonso
 */
public class Day2P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader bf = new BufferedReader(new FileReader("inputs"+ File.separator+"02"+File.separator+"input.txt"));
        String reporte;
        int nSeguro = 0;
        boolean bol;
        reporte = bf.readLine();
        while (reporte != null) {
            bol = false;
            reporte = reporte.trim();
            String[] num = reporte.split(" ");
            List<Integer> numeros = new ArrayList<>();  
            for (int i = 0; i < num.length; i++) {
                numeros.add(Integer.parseInt(num[i]));
            }
            for (int i = 0; i < numeros.size(); i++) {
                List<Integer> numCopia = new ArrayList(numeros);
                numCopia.remove(i);
                if (esSeguro(numCopia)) {
                    bol = true;
                }
            }
            if (bol) {
                nSeguro++;
            }
            reporte = bf.readLine();
        }
        System.out.println(nSeguro);

    }

    public static boolean esSeguro(List<Integer> reporte) {
        boolean ok = true;
        boolean esDecreciente = true;
        boolean esCreciente = true;
        int num1;
        num1 = reporte.get(0);
        for (int i = 1; i < reporte.size(); i++) {
            if (num1 - reporte.get(i) > 0) {
                esDecreciente = false;
            } else if (num1 - reporte.get(i) < 0) {
                esCreciente = false;
            } else {
                esCreciente = false;
                esDecreciente = false;
            }
            if (Math.abs(num1 - reporte.get(i)) > 3) {
                ok = false;
            }
            num1 = reporte.get(i);
        }
        return ok && (esDecreciente || esCreciente);
    }
}
