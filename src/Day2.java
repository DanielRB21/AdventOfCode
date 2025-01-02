
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel Solis Alfonso
 */
public class Day2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
       // SegundoDia segundoDia = new SegundoDia();
      //  BufferedReader bf = new BufferedReader(new FileReader(segundoDia.getPath()));
        BufferedReader bf=new BufferedReader(new FileReader("inputs"+ File.separator+"02"+File.separator+"input.txt"));
       //System.out.println(segundoDia.getPath());
        String reporte;
        int nSeguro = 0;
        reporte = bf.readLine();
        while (reporte != null) {
            reporte = reporte.trim();
            String[] num = reporte.split(" ");
            int[] numeros = new int[num.length];
            for (int i = 0; i < num.length; i++) {
                numeros[i] = Integer.parseInt(num[i]);
            }
            if (esSeguro(numeros)) {
                nSeguro++;
            }
            reporte = bf.readLine();
        }
        System.out.println(nSeguro);

    }

    public static boolean esSeguro(int[] reporte) {
        boolean bol = false;
        boolean esDecreciente = false;
        boolean esCreciente = false;
        int num1;
        int i = 1;
        num1 = reporte[0];
        // Recapacitar.
        while (i < reporte.length - 1 && (!esDecreciente || !esCreciente) && Math.abs(num1 - reporte[i]) <= 3) {
            if (num1 - reporte[i] > 0) {
                esDecreciente = true;
            } else if (num1 - reporte[i] < 0) {
                esCreciente = true;
            } else {
                esCreciente = true;
                esDecreciente = true;
            }
            num1 = reporte[i];
            i++;
        }
        if (i == reporte.length - 1 /*&& (!esDecreciente || !esCreciente)*/) {
            if (num1 - reporte[i] > 0) {
                esDecreciente = true;
            } else if (num1 - reporte[i] < 0) {
                esCreciente = true;
            } else {
                esCreciente = true;
                esDecreciente = true;
            }
            if ((!esDecreciente || !esCreciente) && Math.abs(num1 - reporte[i]) <= 3) {
                bol = true;
            }
        }
        return bol;
    }
}
