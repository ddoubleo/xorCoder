
import java.io.*;

public class Coder {
    public static String input;

    static public void decode(String inputRoute, String key, String outputRoute) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (char temp : key.toCharArray()
        ) {
            sb.append(Integer.toHexString((int) temp));
        }
        String hexKey = sb.toString();
        File output = new File(outputRoute);
        BufferedReader in
                = new BufferedReader(new FileReader(inputRoute));
        PrintWriter out
                = new PrintWriter(new BufferedWriter(new FileWriter(
                output)));
        String inputLine = in.readLine();
        do {
            StringBuilder outputLine = new StringBuilder();
            for (int j = 0; j < inputLine.length(); j++)
                outputLine.append(Character.toString((char) (inputLine.charAt(j) ^ hexKey.charAt(j%hexKey.length()))));
            out.println(outputLine.toString());
        } while ((inputLine = in.readLine()) != null);
        out.close();
        in.close();
    }


}

