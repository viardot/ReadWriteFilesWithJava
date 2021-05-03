import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.channels.SeekableByteChannel;
import java.nio.ByteBuffer;
import java.io.IOException;

public class WriteWithChannel {

  public static void main (String[] args){

    if (args.length != 1) {
      System.out.println("Usage: WriteWithChannel filename>");
      return;
    }

    Path file = Paths.get(args[0]);
    String str = "Hello World!";
    byte[] data = str.getBytes();
    ByteBuffer buffer = ByteBuffer.wrap(data);
    
    try (SeekableByteChannel sbc = Files.newByteChannel(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
      sbc.write(buffer);
    } catch (IOException e) {
      System.out.println("Error writing file");
      e.printStackTrace();
    }
  }
}
