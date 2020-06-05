
import java.io.*;

public class Coder {
    public static String input;

    static public void decode(String inputRoute, String key, String outputRoute) throws IOException {
        if (!key.matches("[a-f\\d]*")) {
            throw new IllegalArgumentException("Wrong key: "+key);
        } else {
            BufferedReader in
                    = new BufferedReader(new FileReader(inputRoute));
            PrintWriter out
                    = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputRoute))));
            String inputLine = in.readLine();
            do {
                StringBuilder outputLine = new StringBuilder();
                for (int j = 0; j < inputLine.length(); j++)
                    outputLine.append(Character.toString((char) (inputLine.charAt(j) ^ key.charAt(j % key.length()))));
                out.println(outputLine.toString());
            } while ((inputLine = in.readLine()) != null);
            out.close();
            in.close();
        }


    }
}

