import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();

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
        ArrayList<String> lista2 = new ArrayList<>();
        for(int i = 0; i<lista.size();i++){
            if(lista.get(i).charAt(0) != '0'){
                System.out.println("ok");
                lista2.add(lista.get(i));
            }
        }

        System.out.println(lista2.toString());

    }
}
