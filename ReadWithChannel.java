import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.channels.SeekableByteChannel;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.io.IOException;

public class ReadWithChannel {

  public static void main(String[] args) {

    if (args.length != 1) { 
      System.out.println("Usage: ReadWriteChannl <filename>");
      return;
    }

    Path file = Paths.get(args[0]);

    try (SeekableByteChannel sbc = Files.newByteChannel(file)){
      ByteBuffer buffer = ByteBuffer.allocate(1024);
      String encoding = System.getProperty("file.encoding");
      while (sbc.read(buffer) > 0) {
        buffer.flip();
	System.out.println(Charset.forName(encoding).decode(buffer));
	buffer.clear();
      }
    } catch (IOException e) {
      System.err.println("Error reading file");
      e.printStackTrace();
    }
  }
}
