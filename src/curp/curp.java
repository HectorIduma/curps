package curp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class curp {

    private static final String CURP_REGEX
            = "^[A-Z]{4}\\d{6}[H,M][A-Z]{5}\\d{2}$";

    public static void main(String[] args) {

        String nombreArchivo = "curps.txt";

        Pattern pattern = Pattern.compile(CURP_REGEX);

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int posicion = 1;

            while ((linea = br.readLine()) != null) {

                Matcher matcher = pattern.matcher(linea);
                if (!matcher.matches()) {
                    System.out.println("CURP invalida: " + linea + " en la posicion: " + posicion);
                }
                posicion++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
