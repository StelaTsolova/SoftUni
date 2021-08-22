package Articles_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] input = scanner.nextLine().split(",");
         String title = input[0];
         String content = input[1];
         String author = input[2];
         Article article = new Article(title, content, author);
         int lines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < lines; i++) {
            String[] command = scanner.nextLine().split(":");
            switch (command[0]){
                case "Edit":
                    article.edit(command[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(command[1]);
                    break;
                case "Rename":
                    article.rename(command[1]);
                    break;
            }
        }
        System.out.println(article);
    }
}
