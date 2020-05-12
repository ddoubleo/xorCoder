
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {
    public static String input;

    /*static public void decode(String key, String filename) throws IOException {
        int nextBit = 0;
        int decimalKey = Integer.parseInt(key,16);
        FileInputStream inputStream = new FileInputStream("C:\\Projects\\Coder\\src\\Resources\\InputText");
        FileOutputStream outputStream = new FileOutputStream("C:\\Projects\\Coder\\src\\Resources\\OutputText");
        while (nextBit != -1) {
            nextBit = inputStream.read();
            outputStream.write(nextBit^decimalKey);
        }
        outputStream.close();
        inputStream.close();
    }*/
    static public void decode2() throws IOException {
        String inputPath = "";
        String outputPath = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify the input path:");
        inputPath = sc.nextLine();
        System.out.println("Specify the output path:");
        outputPath = sc.nextLine();
        do {
            input = sc.nextLine();
            String[] splitted = input.split(" ");
            if (splitted[0].equals("ciphxor")) {
                int decimalKey = Integer.parseInt(splitted[2], 16);
                //splitted[3] = splitted[3].substring(0,splitted[3].length()-4);
                if (splitted.length != 6) {
                    splitted = Arrays.copyOf(splitted, 6);
                    splitted[5] = splitted[3];
                }
                File output = new File(outputPath + "\\" + splitted[5]);
                BufferedReader in
                        = new BufferedReader(new FileReader(
                        inputPath + "\\" + splitted[3]));
                PrintWriter out
                        = new PrintWriter(new BufferedWriter(new FileWriter(
                        output)));
                String inputLine = in.readLine();
                String outputLine = "";
                do {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < inputLine.length(); j++)
                        sb.append(Character.toString((char) (inputLine.charAt(j) ^ decimalKey)));
                    out.println(sb.toString());
                } while ((inputLine = in.readLine()) != null);
                out.close();
                in.close();
            }
        } while (!input.equals("exit"));

    }


}
