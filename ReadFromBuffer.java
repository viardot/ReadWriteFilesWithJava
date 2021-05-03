import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFromBuffer {
  
  private static final Charset charset = Charset.forName("US-ASCII");

  public static void main(String[] args) {
  
    if (args.length != 1) {
      System.out.println("Usage: ReadFromBuffer <filename>");
      return;
    }
    Path file = Paths.get(args[0]);
    try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println("Error reading file");
      e.printStackTrace();
    }
  }
}


