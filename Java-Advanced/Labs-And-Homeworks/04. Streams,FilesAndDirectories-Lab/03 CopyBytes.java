import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes_3 {
    public static void main(String[] args) {
        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            PrintStream printStream = new PrintStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt");
            int readByte = inputStream.read();
            while (readByte != -1) {
                if (readByte != ' ' && readByte != '\n') {
                    printStream.print(readByte);
                } else {
                    printStream.print((char) readByte);
                }
                readByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
