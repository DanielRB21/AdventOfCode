import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Daniel Solis Alfonso
 */
// 6360094256423 answer
public class Day9 {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        BufferedReader bf = new BufferedReader(new FileReader("Inputs" + File.separator + "09" + File.separator + "input.txt"));
        String mapaDisco;
        List<Integer> listaNumeros = new ArrayList<>();
        int id = 0;
        int num = 0;
        mapaDisco = bf.readLine();
        StringBuilder primeraLinea = new StringBuilder();
        for (int i = 0; i < mapaDisco.length(); i++) {
            if (i % 2 == 0) {
                num = Integer.parseInt(String.valueOf(mapaDisco.charAt(i)));
                if (num > 0) {
                    for (int cont = num; cont > 0; cont--) {
                        primeraLinea.append(id);
                        listaNumeros.add(id);
                    }
                }
                id++;

            } else {
                int num1 = Integer.parseInt(String.valueOf(mapaDisco.charAt(i)));
                for (int j = num1; j > 0; j--) {
                    primeraLinea.append(".");
                }
            }
        }
        String linea = primeraLinea.toString();
        long acum = 0;
        int orden = 0;
        int index = linea.indexOf("."); // Encuentra la primera ocurrencia
        for (int cont = 0; cont < index; cont++) {
            acum += (long) orden * listaNumeros.remove(0);
            orden++;
        }
        acum += (long) orden * listaNumeros.get(listaNumeros.size()-1);
        linea=linea.substring(0,linea.lastIndexOf(""+listaNumeros.remove(listaNumeros.size()-1)));
        orden++;
        int distancia = index;
        int nDigito=0;
            while (linea.indexOf(".", index + 1) != -1) {
                index = linea.indexOf(".", index + 1);
                distancia = index-distancia;
                nDigito = countDigit(listaNumeros.get(0));
                distancia = distancia / nDigito;
                if(nDigito==1) {
                    if (distancia > 1) {
                        for (int i = 0; i < distancia - 1; i++) {
                            acum += (long) orden * listaNumeros.remove(0);
                            orden++;
                        }
                    }
                }else{
                    if (distancia >= 1) {
                        for (int i = 0; i < distancia; i++) {
                            acum += (long) orden * listaNumeros.remove(0);
                            orden++;
                        }
                    }
                }
                acum += (long) orden * listaNumeros.get(listaNumeros.size()-1);
                linea=linea.substring(0,linea.lastIndexOf(""+listaNumeros.remove(listaNumeros.size()-1)));
                orden++;
                distancia=index;
            }
        if(!listaNumeros.isEmpty()){
            acum+= (long) orden * listaNumeros.remove(0);
            orden++;
        }

        System.out.println(acum);
        long totalTime = (System.nanoTime()-startTime)/1000000;
        System.out.println(totalTime+" ms");
    }

    public static int countDigit(int n) {
        if (n == 0)
            return 1;

        int count = 0;
        while (n != 0) {
            n = n / 10;

            ++count;
        }
        return count;
    }
}
