import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class WritingYourOwnDataRetrievalApplication_2 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement ps = connection.prepareStatement("SELECT u.`first_name`, u.`last_name`," +
                " COUNT(g.`duration`) AS `count` FROM `games` AS g JOIN `users_games` AS ug ON g.`id` = ug.`game_id` " +
                "JOIN users AS u ON u.`id` = ug.`user_id` WHERE u.`user_name` = ?;");

        System.out.println("Enter user:");
        String user = scanner.nextLine();

        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();

        rs.next();

        if (rs.getString("count").equals("0")) {
            System.out.println("No such user exists");
        } else {
            System.out.printf("User: %s%n%s %s has played %d games", user, rs.getString("first_name"),
                    rs.getString("last_name"), rs.getInt("count"));
        }

        connection.close();
    }
}