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

        /***  PARTE UNO ***/
        ArrayList<int[][]> cartillas = new ArrayList<int[][]>();

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
                aux = new int[5][5];
                fila = 0;
                flag = 0;
            }

        }
        System.out.println("*** RETO 3 ***");
        int ultNum = 0;
        for (int num : numeros) {
            ultNum = num;
            for (int[][] cart : cartillas) {
                for (int fil = 0; fil < 5; fil++) {
                    for (int col = 0; col < 5; col++) {
                        if (cart[fil][col] == num) {
                            cart[fil][col] = -1;
                        }
                    }
                }
            }

            boolean bingo = false;
            int[][] ganador = null;
            long suma = 0;
            for (int[][] cart : cartillas) {
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

            if (bingo) {
                for (int f = 0; f < 5; f++) {
                    for (int c = 0; c < 5; c++) {
                        if(ganador[f][c] != -1){
                            suma += ganador[f][c];
                        }
                    }
                }
                System.out.println("Num Ganador -> "+ultNum + " - Sum Cartón -> " + suma);
                System.out.println("PARTE 1 --> "+ultNum*suma);
                break;
            }

            for (int[][] cart : cartillas) {
                for (int fil = 0; fil < 5; fil++) {
                    bingo = true;
                    for (int col = 0; col < 5; col++) {
                        if (cart[col][fil] != -1) {
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

            if (bingo) {
                for (int f = 0; f < 5; f++) {
                    for (int c = 0; c < 5; c++) {
                        if(ganador[f][c] != -1){
                            suma += ganador[f][c];
                        }
                    }
                }
                System.out.println("Num Ganador -> "+ultNum + " - Sum Cartón -> " + suma);
                System.out.println("PARTE 1 --> "+ultNum*suma);
                break;
            }
        }

        /***  PARTE DOS ***/
        ArrayList<int[][]> cartillas2 = new ArrayList<int[][]>();

        int[][] aux2 = new int[5][5];
        int flag2 = 0;
        int fila2 = 0;
        for (String s : auxCartillas) {
            String cad = s.trim();
            String[] tokens = cad.split("\s{1,}");
            for (int col = 0; col < tokens.length; col++) {
                aux2[fila2][col] = Integer.parseInt(tokens[col]);
            }
            fila2++;
            flag2++;
            if (flag2 == 5) {
                cartillas2.add(aux2);
                aux2 = new int[5][5];
                fila2 = 0;
                flag2 = 0;
            }

        }

        int ultNum2 = 0;
        for (int num : numeros) {
            ultNum2 = num;
            for (int[][] cart : cartillas2) {
                for (int fil = 0; fil < 5; fil++) {
                    for (int col = 0; col < 5; col++) {
                        if (cart[fil][col] == num) {
                            cart[fil][col] = -1;
                        }
                    }
                }
            }

            boolean bingo = false;
            int[][] ganador = null;
            long suma = 0;
            for (int[][] cart : cartillas) {
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

            if (bingo) {
                for (int f = 0; f < 5; f++) {
                    for (int c = 0; c < 5; c++) {
                        if(ganador[f][c] != -1){
                            suma += ganador[f][c];
                        }
                    }
                }
                System.out.println("Num Ganador -> "+ultNum2 + " - Sum Cartón -> " + suma);
                System.out.println("PARTE 1 --> "+ultNum2*suma);
                break;
            }

            for (int[][] cart : cartillas2) {
                for (int fil = 0; fil < 5; fil++) {
                    bingo = true;
                    for (int col = 0; col < 5; col++) {
                        if (cart[col][fil] != -1) {
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

            if (bingo) {
                for (int f = 0; f < 5; f++) {
                    for (int c = 0; c < 5; c++) {
                        if(ganador[f][c] != -1){
                            suma += ganador[f][c];
                        }
                    }
                }
                System.out.println("Num Ganador -> "+ultNum2 + " - Sum Cartón -> " + suma);
                System.out.println("PARTE 1 --> "+ultNum2*suma);
                break;
            }
        }

    }
}
