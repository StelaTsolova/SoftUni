import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class AccessingDatabaseViaSimpleJavaApplication_1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        double salary = Double.parseDouble(scanner.nextLine());

        // Load DB Driver (not mandatory)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to DB
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        // Create prepared statement
        PreparedStatement ps = connection.prepareStatement("SELECT `first_name`, `last_name` " +
                "FROM `employees` WHERE `salary` > ?;");

        // Execute prepared statement with parameter
        ps.setDouble(1, salary);
        ResultSet rs = ps.executeQuery();

        // Print
        while (rs.next()) {
            System.out.printf("%s %s%n", rs.getString("first_name"), rs.getString("last_name"));
        }

        connection.close();
    }
}
