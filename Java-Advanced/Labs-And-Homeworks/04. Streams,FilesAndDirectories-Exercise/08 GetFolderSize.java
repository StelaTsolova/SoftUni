import java.io.File;

public class GetFolderSize_8 {
    public static void main(String[] args) {
        File folder = new File("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        int size = 0;
        for (File file : folder.listFiles()) {
            size += file.length();
        }
        System.out.println("Folder size: " + size);
    }
}