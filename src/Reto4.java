import java.io.*;
import java.util.ArrayList;

public class Reto4 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<String> auxCartillas = new ArrayList<>();
        FileReader fr = null;
        BufferedReader br;

        try {
            fr = new FileReader("test.txt");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            String[] tokens = linea.split(",");
            for (String s : tokens) {
                numeros.add(Integer.parseInt(s));
            }
            String aux;
            while ((aux = br.readLine()) != null) {
                if (!aux.equals(""))
                    auxCartillas.add(aux);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        ArrayList<int[][]> cartillas = new ArrayList<int[][]>();
        ArrayList<int[][]> cartillasCC = new ArrayList<int[][]>();

        int[][] aux = new int[5][5];
        int flag = 0;
        int fila = 0;
        for (String s : auxCartillas) {
            String cad = s.trim();
            String[] tokens = cad.split("\s{1,}");
            for (int col = 0; col < tokens.length; col++) {
                aux[fila][col] = Integer.parseInt(tokens[col]);
            }
            fila++;
            flag++;
            if (flag == 5) {
                cartillas.add(aux);
                cartillasCC.add(aux);
                aux = new int[5][5];
                fila = 0;
                flag = 0;
            }

        }

        int ultNum = 0;

        for (int num : numeros) {
            ultNum = num;
            for (int[][] cart : cartillasCC) {
                for (int fil = 0; fil < 5; fil++) {
                    for (int col = 0; col < 5; col++) {
                        if (cart[fil][col] == num) {
                            cart[fil][col] = -1;
                        }
                    }
                }
            }

            boolean bingo = true;
            int[][] ganador;
            for (int[][] cart : cartillasCC) {
                for (int fil = 0; fil < 5; fil++) {
                    bingo = true;
                    for (int col = 0; col < 5; col++) {
                        if (cart[fil][col] != -1) {
                            bingo = false;
                            break;
                        }
                    }
                    if (bingo) {
                        ganador = cart;
                        break;
                    }
                }
                if (bingo)
                    break;
            }

            if(bingo){
                System.out.println(ultNum+"---");
                break;
            }
        }
        /*for (int j = 0; j < cartillas.size(); j++) {
            for (int fil = 0; fil < 5; fil++) {
                for (int i = 0; i<1 ;i++) {
                }
                for (int col = 0; col < 5; col++) {
                    if (cartillas.get(j)[fil][col] == numeros.get(i)) {

                    }
                }
            }
        }*/


    }
}
