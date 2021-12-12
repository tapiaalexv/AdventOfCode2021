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

        System.out.println(auxCartillas.size());

        ArrayList<int[][]> cartillas = new ArrayList<>();

        int[][] aux = new int[5][5];
        int flag = 0;
        int fila = 0;
        for(String s : auxCartillas){
            String cad = s.trim();
            String[] tokens = cad.split("\s{1,}");
            for (int col = 0; col < tokens.length; col++) {
                System.out.println("-->"+tokens[col]);
                aux[fila][col]=Integer.parseInt(tokens[col]);
            }
            fila++;
            flag++;
            if (flag == 5){
                cartillas.add(aux);
                aux = new int[5][5];
                fila=0;
                flag=0;
            }

        }


    }
}


