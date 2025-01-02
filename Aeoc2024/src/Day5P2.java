import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
   @author Daniel Solis Alfonso
 */
// 5035 too low
public class Day5P2 {
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
           Integer[] order=getOrdenamientoIncorrectoOrdenado(ordenamientoPag,act);
            if(order!=null) {
                acum += order[Math.abs(order.length / 2)];
            }

        }
        System.out.println(acum);


    }
    public static Integer[] getOrdenamientoIncorrectoOrdenado(List<String> orden,int[] actualizaciones) {
        int num, num1=0;
        int j = 0;
        Integer[] array = null;
        boolean bol = true;
        List<Integer> nums = new LinkedList<>();
        int i = 0;
        List<Integer> indices;
        while (i < actualizaciones.length) {
            LinkedList<Integer> indexs=new LinkedList<Integer>();
            nums.add(actualizaciones[i]);
            if (!getMatchingIndices(orden, "^" + actualizaciones[i] + "\\|").isEmpty()) {
                if (i != 0) {
                    indices = getMatchingIndices(orden, actualizaciones[i] + "\\|");
                    for (Integer index : indices) {
                        num = Integer.parseInt(orden.get(index).split("\\|")[1]);
                        if (nums.contains(num)) {
                            bol = false;
                            indexs.add(nums.indexOf(num));
                            nums.set(nums.indexOf(num), actualizaciones[i]);
                            //if (!index.equals(indices.size()-1)){
                            //nums.set(nums.size() - 1, num);
                            nums.set(nums.lastIndexOf(actualizaciones[i]),num);
                            //}else{
                            // nums.set()
                        }
                    }
                    //Esta parte es mas chunga hay que revisar cada vez que cambias si se valida o no.
                }
            }
            i++;
        }
        if(!bol) {
            System.out.println(nums);
            array = new Integer[nums.size()];
            nums.toArray(array);
        }
        return array;

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
    public static List<Integer> findOccurrences(List<Integer> list, int target) {
        List<Integer> indices = new LinkedList<>(); // Lista para almacenar los índices
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                indices.add(i);
            }
        }

        return indices;
    }
}
