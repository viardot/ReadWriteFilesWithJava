import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.IOException;

public class writeByte {

  public static void main (String[] args){

    if (args.length != 1){
      System.out.println("Usage: writeByte <filename>");
      return;
    }
    Path file = Paths.get(args[0]); 	  
    byte[] content = {(byte)'H',(byte)'e',(byte)'l',(byte)'l',(byte)'o',(byte)'\n'};
    try {
      Files.write(file, content, StandardOpenOption.CREATE);
    } catch (IOException e) {
      System.err.println("Error creating file");
      e.printStackTrace();
    }
  }

}
