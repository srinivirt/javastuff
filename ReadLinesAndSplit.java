import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * Split the lines using a regex
 */
public class ReadLinesAndSplit {

    public static void main(String[] args) {
        Charset charset = Charset.forName("US-ASCII");
        // use Paths to create the file object to read from
        Path file = Paths.get("readlines.input"); // local readlines.input file
        String regex = "[ \t\r\n]+"; /* one or more whitespace */

        // use Files.newBufferedReader to 
        //     create a BufferedReader object to read line
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.format("%s%n", line); // add %n as readline truncates end of line char
                String[] tokens = line.split(regex, 0); /* split as many times */
                for (String s : tokens)
                    System.out.println(s);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
