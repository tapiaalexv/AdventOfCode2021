import java.io.*;
import java.util.ArrayList;

public class Reto2 {
    public static void main(String[] args) {
        ArrayList<Integer> medida = new ArrayList<>();
        ArrayList<String> orden = new ArrayList<>();
        int horizontal = 0, depth = 0;

        FileReader fr = null;
        BufferedReader br;
        try {
            fr = new FileReader("dia2.txt");
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split(" ");
                int med = Integer.parseInt(tokens[1]);
                orden.add(tokens[0]);
                medida.add(med);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        for(int i=0; i <= medida.size()-1; i++){
            if(orden.get(i).equals("forward")){
               horizontal += medida.get(i);
            }else if(orden.get(i).equals("down")){
                depth += medida.get(i);
            }else{
                depth -= medida.get(i);
            }
        }

        int horizontal2 = 0, depth2 = 0, aim = 0;
        for(int i=0; i <= medida.size()-1; i++){
            if(orden.get(i).equals("forward")){
                horizontal2 += medida.get(i);
                depth2 += medida.get(i) * aim;
            }else if(orden.get(i).equals("down")){
                aim += medida.get(i);
            }else{
                aim -= medida.get(i);
            }
        }

        System.out.println("*** RETO 2 ***\nRespuesta 1er parte-> " + horizontal*depth);
        System.out.println("\nRespuesta 2da parte-> "+horizontal2*depth2);
    }
}
