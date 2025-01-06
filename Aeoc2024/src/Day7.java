import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Daniel Solis Alfonso
 */
public class Day7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader("inputs"+ File.separator+"07"+File.separator+"input.txt"));
        String linea;
        long testvalor;
        int[] valores;
        String[] valoreslinea;
        linea=bf.readLine();
        long acum=0;
        while(linea!=null){
            testvalor=Long.parseLong(linea.split(":")[0]);
            valoreslinea=linea.split(":")[1].replaceFirst(" ","").split(" ");
            valores=new int[valoreslinea.length];
            for(int i=0;i<valores.length;i++){
                valores[i]= Integer.parseInt(valoreslinea[i]);
            }
        if(esValida(testvalor,valores)){
            acum+=testvalor;
        }
        linea= bf.readLine();
        }
        System.out.println(acum);

    }
    public static boolean esValida(long testvalor, int[] valores){
        ArrayList<Long> resultados=new ArrayList<>();
        resultados.add((long) valores[0]);
        for(int i=1;i<valores.length;i++){
            List<Long> resultados1=new ArrayList<>();
            while(!resultados.isEmpty()){
                long num= resultados.remove(0);
                resultados1.add((long) (num * valores[i]));
                resultados1.add((long) (num+valores[i]));
            }
            resultados=new ArrayList<>(resultados1);
            System.out.println(resultados);
        }
        return resultados.contains(testvalor);
    }

}
