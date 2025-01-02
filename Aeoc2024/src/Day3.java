import java.io.*;
import java.util.regex.*;

public class Day3 {
    /**
     * @author Daniel Solís Alfonso
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader bf = new BufferedReader(new FileReader("inputs"+File.separator+"03"+File.separator+"input.txt"));
        String linea;
        long acum = 0;
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");

        while ((linea = bf.readLine()) != null) {
            Matcher matcher = pattern.matcher(linea);
            while (matcher.find()) {
                // Extraer los números x e y
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                // Realizar la operación y acumular el resultado
                acum += x * y;
            }
        }
        System.out.println(acum);
    }
}