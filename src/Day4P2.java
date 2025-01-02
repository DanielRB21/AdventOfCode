import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
    @author Daniel Solis Alfonso
 */
public class Day4P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("inputs" + File.separator + "04" + File.separator + "input.txt"));
        String linea;
        int cont = 0;
        final String[] posibilidades={"MSAMS","SMASM","SSAMM","MMASS"};
        List<String> sopaLetras = new ArrayList<>();

        while ((linea = bf.readLine()) != null) {
            sopaLetras.add(linea);
        }
        for(int i=1;i<sopaLetras.size()-1;i++){
            String[] copia=new String[3];
            copia[0]=sopaLetras.get(i-1);
            copia[1]=sopaLetras.get(i);
            copia[2]=sopaLetras.get(i+1);

            while(copia[1].contains("A") && copia[1].indexOf("A")!=copia[1].length()-1) {
                if (copia[1].indexOf("A") != 0) {
                    String str = "";
                    str = str + copia[0].charAt(copia[1].indexOf("A") - 1) + copia[0].charAt(copia[1].indexOf("A") + 1)
                            + "A" + copia[2].charAt(copia[1].indexOf("A") - 1) + copia[2].charAt(copia[1].indexOf("A") + 1);

                    for (int k = 0; k < posibilidades.length; k++) {
                        if (str.equals(posibilidades[k])) {
                            cont++;
                        }
                    }
                    copia[1]=copia[1].replaceFirst("A","X");
                } else {
                    copia[1]=copia[1].replaceFirst("A","X");
                }
            }
        }
        System.out.println(cont);
    }
}
