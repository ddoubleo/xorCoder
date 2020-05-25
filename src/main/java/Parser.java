

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    @Option(name = "-c", usage = "encoding file with following key", forbids = "-d")
    private String encodingKey;
    @Option(name = "-d", usage = "decoding file with following key", forbids = "-c")
    private String decodingKey;
    @Option(name = "-o", usage = "declaring output file name (default: inputname.txt)")
    private String outputRoute;
    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String args[]) throws IOException {
        new Parser().parseArgs(args);

    }

    public void parseArgs(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            if (arguments.isEmpty()) throw new IllegalArgumentException("");
        } catch (CmdLineException e) {
            e.printStackTrace();
            throw  new IllegalArgumentException("");

        }
        String inputRoute = arguments.get(1);

        if (encodingKey!=null) Coder.decode(inputRoute,encodingKey,outputRoute);
        else Coder.decode(inputRoute,decodingKey,outputRoute);

    }
}
