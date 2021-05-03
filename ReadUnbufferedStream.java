import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadUnbufferedStream {

  public static void main(String[] args) {
    
    if (args.length != 1) {
      System.out.println("Usage: ReadUnbufferStream <filename>");
      return;
    }

    Path file = Paths.get(args[0]);
    
    // InputStream read byte by byte from file.
    // InputStreamReader converts bytes to Char.
    // BufferedReader reads char input stream and buffers them.
    try (InputStream in        = Files.newInputStream(file);
	 InputStreamReader ins = new InputStreamReader(in);	    
         BufferedReader reader = new BufferedReader(ins)) {
      String line = null;
      while ((line = reader.readLine()) != null) {
	      System.out.println(line);
      }
    } catch (IOException e) { 
      System.err.println("Error Reading file");
      e.printStackTrace();
    }
  }
}
