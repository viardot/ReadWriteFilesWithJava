import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.IOException;

public class WriteFromBuffer {

  private static final Charset charset = Charset.forName("US-ASCII");

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage: WriteFromBuffer <filename>");
      return;
    }
    String str = "Hello World!";
    Path file =Paths.get(args[0]);
    try (BufferedWriter writer = Files.newBufferedWriter(file, charset, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
      writer.write(str, 0, str.length());
    } catch (IOException e) {
      System.err.println("Error writing to file");
      e.printStackTrace();
    }
  }
}
