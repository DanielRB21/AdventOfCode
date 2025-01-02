import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Daniel Solís Alfonso
 */
public class Day3P2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader bf = new BufferedReader(new FileReader("inputs"+ File.separator+"03"+File.separator+"input.txt"));
        String texto = "";
        String linea;
        int indexDont = 0;
        int indexDo = 0;
        Matcher matcher;
        Matcher mDont;
        long acum = 0;
        Matcher mDo;
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Pattern patterndont = Pattern.compile("don't(\\(\\))");
        Pattern patterndo = Pattern.compile("do((\\(\\)))");
        linea = bf.readLine();
        while (linea != null) {
            texto += linea;
            linea = bf.readLine();
        }
        matcher = pattern.matcher(texto);
        mDont = patterndont.matcher(texto);
        mDo = patterndo.matcher(texto);
        if (mDont.find()) {
            indexDont = mDont.start();
        }
        if (mDo.find()) {
            indexDo = mDo.start();
        }
        while (matcher.find()) {

            if (matcher.start() - indexDont > 0 && indexDo - matcher.start() < 0 && indexDo > indexDont) {
                if (mDont.find()) {
                    indexDont = mDont.start();
                }
            }

            if (matcher.start() - indexDo > 0 && indexDont - matcher.start() < 0 && indexDont > indexDo) {
                if (mDo.find()) {
                    indexDo = mDo.start();
                }
            }

            if (matcher.start() - indexDont < 0 || (indexDo - indexDont > 0 && matcher.start() - indexDo > 0)) {
                acum = acum + (long) Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
            }
        }

        System.out.println(acum);
    }
}
