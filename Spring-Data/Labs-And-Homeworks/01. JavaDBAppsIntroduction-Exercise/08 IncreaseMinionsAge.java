import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class IncreaseMinionsAge_8 {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] minionsIds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int id : minionsIds) {
            changeMinionName(connection, id);
            changeMinionAge(connection, id);
        }

        printResult(connection);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
    }

    private static void changeMinionName(Connection connection, int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE minions SET name = LOWER(name) WHERE id = ?;");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    private static void changeMinionAge(Connection connection, int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE minions SET age = age + 1 WHERE id = ?;");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    private static void printResult(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT name, age FROM minions;");

        while (rs.next()) {
            System.out.printf("%s %d%n", rs.getString("name"), rs.getInt("age"));
        }
    }
}
