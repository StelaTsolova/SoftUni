import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders_8 {
    public static void main(String[] args) {
        File file = new File("04. Java-Advanced-Files-and-Streams-Lab-Resources");
        ArrayDeque<File> files = new ArrayDeque<>();
        files.offer(file);
        int counter = 0;
        while (!files.isEmpty()){
            File innerFile = files.pop();
            for (File f : innerFile.listFiles()){
                if (f.isDirectory()){
                    System.out.println(f.getName());
                    files.offer(f);
                    counter++;
                }
            }
        }
        System.out.printf("%d folders", counter);
    }
}
