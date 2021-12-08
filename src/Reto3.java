import java.io.*;
import java.util.ArrayList;

public class Reto3 {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        String gamma = "", epsilon = "";

        FileReader fr = null;
        BufferedReader br;
        try {
            fr = new FileReader("dia3.txt");
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        int temp = 0;
        while (temp != lista.get(0).length()) {
            int cero = 0, uno = 0;
            for (String s : lista) {
                if (s.charAt(temp) == '0') {
                    cero++;
                } else {
                    uno++;
                }
            }
            if (cero > uno) {
                gamma += "0";
                epsilon += "1";
            } else {
                gamma += "1";
                epsilon += "0";
            }
            temp++;
        }

        long decimalGamma = binarioADecimal(Long.parseLong(gamma));
        long decimalEpsilon = binarioADecimal(Long.parseLong(epsilon));

        System.out.println("*** RETO 3 ***\nGamma = " + decimalGamma + "\nEpsilon = " +
                decimalEpsilon + "\nRespuesta 1er parte-> " + decimalGamma * decimalEpsilon);

        ArrayList<String> oxygen = (ArrayList<String>) lista.clone();
        ArrayList<String> co2 = (ArrayList<String>) lista.clone();

        int index = 0;
        while (oxygen.size() != 1) {
            int cero = 0, uno = 0;
            for (String s : oxygen) {
                if (s.charAt(index) == '0') {
                    cero++;
                } else {
                    uno++;
                }
            }
            if (cero > uno) {
                oxygen = calcularOxygen(oxygen, '1', index);
            } else if (uno >= cero) {
                oxygen = calcularOxygen(oxygen, '0', index);
            }
            index++;
        }

        int index2 = 0;
        while (co2.size() != 1) {
            int cero = 0, uno = 0;
            for (String s : co2) {
                if (s.charAt(index2) == '0') {
                    cero++;
                } else {
                    uno++;
                }
            }
            if (uno >= cero) {
                co2 = calcularCo2(co2, '1', index2);
            } else if (cero > uno) {
                co2 = calcularCo2(co2, '0', index2);
            }
            index2++;
        }

        long decimalOxygen = binarioADecimal(Long.parseLong(oxygen.get(0)));
        long decimalc02 = binarioADecimal(Long.parseLong(co2.get(0)));

        System.out.println("\nOxygen = " + decimalOxygen + "\nCO2 = " + decimalc02 +
                "\nRespuesta 2da parte-> " + decimalOxygen * decimalc02);
    }

    public static int binarioADecimal(long binario) {
        int decimal = 0;
        int digito;
        final long DIVISOR = 10;
        for (long i = binario, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = (int) (i % DIVISOR);
            if (digito != 0 && digito != 1) {
                return -1;
            }
            decimal += digito * Math.pow(2, j);
        }
        return decimal;
    }

    public static ArrayList<String> calcularOxygen(ArrayList<String> list, char condicion, int index) {
        ArrayList<String> lista2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(index) != condicion) {
                lista2.add(list.get(i));
            }
        }
        return lista2;
    }

    public static ArrayList<String> calcularCo2(ArrayList<String> list, char condicion, int index) {
        ArrayList<String> lista2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(index) != condicion) {
                lista2.add(list.get(i));
            }
        }
        return lista2;
    }
}