import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class WriteUnbufferedStream {

  public static void main(String[] args){

    if (args.length != 1){
      System.out.println("Usage: WriteUnbufferedStream");
      return;
    }
    Path file = Paths.get(args[0]);

    String str = "Hello World!";
    byte data[] = str.getBytes();

    try (OutputStream out = Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
         BufferedOutputStream writer = new BufferedOutputStream(out)) {
         
      writer.write(data, 0, data.length);   
    } catch (IOException e) {
      System.err.println("Error writing file");
      e.printStackTrace();
   }
  }
}
