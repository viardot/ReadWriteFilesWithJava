import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class ReadAllBytes {

  public static void main(String[] args) {
    if (args.length !=  1) {
      System.out.println("Usage: ReadAllBytes <filename>");
      return; 
    }
    Path file  = Paths.get(args[0]);
    System.out.println(file.toAbsolutePath()); 
    byte[] fileByteArray;
    try {
      fileByteArray = Files.readAllBytes(file);

      for (int i = 0; i < fileByteArray.length; i++) {
        System.out.print((char)fileByteArray[i]);
      }

    } catch (IOException e) {
      System.err.println("Error reading file" );
      e.printStackTrace();
    }
  }
}
