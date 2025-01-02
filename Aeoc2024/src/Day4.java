import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Daniel Solis Alfonso
 */

public class Day4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("inputs" + File.separator + "04" + File.separator + "input.txt"));
        String linea;
        List<String> sopaLetras = new ArrayList<>();

        while ((linea = bf.readLine()) != null) {
            sopaLetras.add(linea);
        }
        getXMASDiagonales(sopaLetras);

        System.out.println("Total: " + (nXMASAdyacentes(sopaLetras) + getXMASVerticales(sopaLetras) + getXMASDiagonales(sopaLetras)));
        System.out.println("Adyacentes: " + nXMASAdyacentes(sopaLetras));
        System.out.println("Verticales: " + getXMASVerticales(sopaLetras));
        System.out.println("Diagonales: " + getXMASDiagonales(sopaLetras));

    }

    public static int nXMASAdyacentes(List<String> sopaLetras) {
        String xmas;
        int cont = 0;
        for (int i = 0; i < sopaLetras.size(); i++) {
            for (int j = 0; j < sopaLetras.get(i).length(); j++) {
                if (j < sopaLetras.get(i).length() - 4) {
                    xmas = sopaLetras.get(i).substring(j, j + 4);
                    if (xmas.contains("XMAS") || xmas.contains("SAMX")) {
                        cont++;
                    }
                } else if (j == sopaLetras.get(i).length() - 4) {
                    xmas = sopaLetras.get(i).substring(j, j + 4);
                    if (xmas.contains("XMAS") || xmas.contains("SAMX")) {
                        cont++;
                    } else {
                        xmas = xmas.substring(1);
                        xmas = xmas + sopaLetras.get(i).charAt(sopaLetras.get(i).length() - 1);
                        if (xmas.contains("XMAS") || xmas.contains("SAMX")) {
                            cont++;
                        }
                    }
                }
            }
        }
        return cont;
    }
    public static int getXMASVerticales(List<String> sopaLetras) {
        List<String> letras = new ArrayList<>();
        String string = "";
        for (int i = 0; i < sopaLetras.size(); i++) {
            for (int j = 0; j < sopaLetras.size(); j++) {
                string += sopaLetras.get(j).charAt(i);
            }
            letras.add(string);
            string = "";
        }
        //System.out.println(letras);
        return nXMASAdyacentes(letras);
    }

    public static int getXMASDiagonales(List<String> sopaLetras) {
        int rows = sopaLetras.size();
        int cols = sopaLetras.get(0).length();
        List<String> diagonales = new ArrayList<>();

        // Extraer diagonales de izquierda a derecha (parte superior de la matriz)
        for (int startCol = 0; startCol < cols; startCol++) {
            StringBuilder diagonal = new StringBuilder();
            int row = 0, col = startCol;
            while (row < rows && col < cols) {
                diagonal.append(sopaLetras.get(row).charAt(col));
                row++;
                col++;
            }
            diagonales.add(diagonal.toString());
        }

        // Extraer diagonales de izquierda a derecha (parte izquierda de la matriz)
        for (int startRow = 1; startRow < rows; startRow++) {
            StringBuilder diagonal = new StringBuilder();
            int row = startRow, col = 0;
            while (row < rows && col < cols) {
                diagonal.append(sopaLetras.get(row).charAt(col));
                row++;
                col++;
            }
            diagonales.add(diagonal.toString());
        }

        // Extraer diagonales de derecha a izquierda (parte superior de la matriz)
        for (int startCol = 0; startCol < cols; startCol++) {
            StringBuilder diagonal = new StringBuilder();
            int row = 0, col = startCol;
            while (row < rows && col >= 0) {
                diagonal.append(sopaLetras.get(row).charAt(col));
                row++;
                col--;
            }
            diagonales.add(diagonal.toString());
        }

        // Extraer diagonales de derecha a izquierda (parte derecha de la matriz)
        for (int startRow = 1; startRow < rows; startRow++) {
            StringBuilder diagonal = new StringBuilder();
            int row = startRow, col = cols - 1;
            while (row < rows && col >= 0) {
                diagonal.append(sopaLetras.get(row).charAt(col));
                row++;
                col--;
            }
            diagonales.add(diagonal.toString());
        }
        return nXMASAdyacentes(diagonales);
    }

}