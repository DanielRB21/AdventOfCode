import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author Daniel Solis Alfonso
 */
public class Day5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader("inputs"+ File.separator+"05"+File.separator+"input.txt"));
        String linea;
        int acum=0;
        List<String> ordenamientoPag=new ArrayList<>();
        linea=bf.readLine();
        while(linea!=null && !linea.isEmpty()){
            ordenamientoPag.add(linea);
            linea=bf.readLine();
        }
        linea=bf.readLine();
        List<String> actualizaciones=new ArrayList<>();
        while(linea!=null){
            actualizaciones.add(linea);
            linea=bf.readLine();
        }
       for(int i=0;i<actualizaciones.size();i++) {
           String[] numeros = actualizaciones.get(i).split(",");
           int[] act = new int[numeros.length];
           for (int j = 0; j < numeros.length; j++) {
               act[j] = Integer.parseInt(numeros[j]);
           }
           if(estaOrdenCorrecto(ordenamientoPag,act)){
            acum+=act[Math.abs(act.length/2)];
           }
       }
        System.out.println(acum);


    }
    public static boolean estaOrdenCorrecto(List<String> orden,int[] actualizaciones){
        int num, num1;
        int j=0;
        boolean bol=true;
        List<Integer> nums=new LinkedList<>();
        int i=0;
        List<Integer> indices;
        while(i<actualizaciones.length && bol) {
            nums.add(actualizaciones[i]);
            if (!getMatchingIndices(orden, "^"+actualizaciones[i] + "\\|").isEmpty()) {
                if (i != 0) {
                    indices = getMatchingIndices(orden, actualizaciones[i] + "\\|");
                    for (Integer index : indices) {
                        num = Integer.parseInt(orden.get(index).split("\\|")[1]);
                        if (nums.contains(num)) {
                            bol = false;
                        }
                    }
                }
            }
            i++;
        }

        return bol;
    }
    public static List<Integer> getMatchingIndices(List<String> strings, String regex) {
        List<Integer> indices = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < strings.size(); i++) {
            Matcher matcher = pattern.matcher(strings.get(i));
            if (matcher.find()) {
                indices.add(i);
            }
        }

        return indices;
    }
}
