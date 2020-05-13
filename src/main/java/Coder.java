
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {
    public static String input;

    static public void decode() throws IOException {
        String inputPath = "";
        String outputPath = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify the input path:");
        inputPath = sc.nextLine().replace("\\", "\\\\");
        System.out.println(inputPath);
        System.out.println("Specify the output path:");
        outputPath = sc.nextLine().replace("\\", "\\\\");
        do {
            input = sc.nextLine();
            String[] splitted = input.split(" ");
            if (splitted[0].equals("ciphxor")) {
                int decimalKey = Integer.parseInt(splitted[2], 16);
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
                do {
                    StringBuilder outputLine = new StringBuilder();
                    for (int j = 0; j < inputLine.length(); j++)
                        outputLine.append(Character.toString((char) (inputLine.charAt(j) ^ decimalKey)));
                    out.println(outputLine.toString());
                } while ((inputLine = in.readLine()) != null);
                out.close();
                in.close();
            }
        } while (!input.equals("exit"));

    }


}
