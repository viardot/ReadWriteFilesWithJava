import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

public class ReadAllLines {

  public static void main (String args[]){

    try {
      Path file = Paths.get(args[0]);
      List<String> lines = Files.readAllLines(file);
      for(String line : lines) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Error reading file");
      e.printStackTrace();
    }
  }
}
