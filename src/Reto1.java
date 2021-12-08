import java.io.*;
import java.util.ArrayList;

public class Reto1 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br;
        int cont=0 , cont2 = 0;

        try {
            fr = new FileReader("dia1.txt");
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                int aux = Integer.parseInt(linea);
                lista.add(aux);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        for (int i = 0; i <= (lista.size()-2); i++) {
            if(lista.get(i+1)> lista.get(i)){
                cont++;
            }
        }

        for (int i = 0; i <= (lista.size()-4); i++) {
            int num1 = lista.get(i+1)+lista.get(i+2)+lista.get(i+3);
            int num2 = lista.get(i)+lista.get(i+1)+lista.get(i+2);
            if(num1 > num2){
                cont2++;
            }
        }

        System.out.println("*** RETO 1 ***\nExisten -> " + cont + " medidas de incremento");
        System.out.println("\nExisten -> " + cont2 + " suma de medidas de incremento");
    }
}
