import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniel Solis Alfonso
 */
public class Day6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("inputs" + File.separator + "06" + File.separator + "input.txt"));
        String linea;
        ArrayList<String> mapa = new ArrayList<>();
        char player = '^';
        int rotacion = 0; //0  para arriba, 1 para derecha,  2 para abajo, 3 izquierda
        int filaplayer = -1;
        linea = bf.readLine();
        while (linea != null) {
            mapa.add(linea);
            linea = bf.readLine();
        }
        for (int i = 0; i < mapa.size(); i++) {
            if (mapa.get(i).contains("^")) {
                filaplayer = i;
            }
        }
        Set<String> casillasVisitadas = new HashSet<>();
        try {
            while (true) {
                int indexPlayer = -1;
                if (mapa.get(filaplayer).contains("^")) {
                    indexPlayer = mapa.get(filaplayer).indexOf('^');
                    player = '^';
                } else if (mapa.get(filaplayer).contains(">")) {
                    indexPlayer = mapa.get(filaplayer).indexOf('>');
                    player = '>';
                } else if (mapa.get(filaplayer).contains("v")) {
                    indexPlayer = mapa.get(filaplayer).indexOf('v');
                    player = 'v';
                } else if (mapa.get(filaplayer).contains("<")) {
                    indexPlayer = mapa.get(filaplayer).indexOf("<");
                    player = '<';
                }
                casillasVisitadas.add(filaplayer + "," + indexPlayer);

                if (getGiro(player, mapa, indexPlayer, filaplayer) != null) {
                    rotacion = getGiro(player, mapa, indexPlayer, filaplayer);
                }
                String line = mapa.get(filaplayer);
                if (rotacion == 0) {
                    line = line.replace("^", ".").replace(">", ".").replace("<", ".");
                    mapa.set(filaplayer, line);
                    //line=mapa.get(filaplayer+1);
                    line = mapa.get(filaplayer - 1).substring(0, indexPlayer) + '^' + mapa.get(filaplayer - 1).substring(indexPlayer + 1); //Reemplaza la linea superior
                    mapa.set(filaplayer - 1, line);
                    filaplayer--;
                } else if (rotacion == 1) {
                    indexPlayer++;
                    line = line.substring(0, indexPlayer).replace("^", ".").replace(">", ".").replace("v", ".") + ">" + line.substring(indexPlayer + 1);
                    mapa.set(filaplayer, line);
                } else if (rotacion == 2) {
                    line = line.replace(">", ".").replace("v", ".");
                    mapa.set(filaplayer, line);
                    line = mapa.get(filaplayer + 1).substring(0, indexPlayer) + "v" + mapa.get(filaplayer + 1).substring(indexPlayer + 1);
                    mapa.set(filaplayer + 1, line);
                    filaplayer++;
                } else {
                    indexPlayer--;
                    line = line.substring(0, indexPlayer) + "<" + line.substring(indexPlayer + 1).replace("v", ".").replace("<", ".");
                    mapa.set(filaplayer, line);
                }
                casillasVisitadas.add(filaplayer + "," + indexPlayer);
                pintarMapa(mapa);
            }
        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("Ruta finalizada" + " Casillas: " + casillasVisitadas.size());
        }
    }

    public static Integer getGiro(char ch, ArrayList<String> mapa, int indice, int fila) {
        Integer integer = null;
        if (ch == '^') {
            if (mapa.get(fila - 1).charAt(indice) == '#') {
                integer = 1;
            }
        } else if (ch == '>') {
            if (mapa.get(fila).charAt(indice + 1) == '#') {
                integer = 2;
            }
        } else if (ch == 'v') {
            if (mapa.get(fila + 1).charAt(indice) == '#') {
                integer = 3;
            }
        } else if (ch == '<') {
            if (mapa.get(fila).charAt(indice - 1) == '#') {
                integer = 0;
            }
        }
        return integer;
    }

    public static void pintarMapa(ArrayList<String> mapa) {
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        for (String line : mapa) {
            System.out.println(line);
        }
    }
}
