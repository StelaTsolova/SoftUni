import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class IncreaseAgeStoredProcedure_9 {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minionId = Integer.parseInt(reader.readLine());

        CallableStatement cs = connection.prepareCall("CALL usp_get_older(?)");
        cs.setInt(1, minionId);

        cs.executeUpdate();

        printResult(connection, minionId);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
    }

    private static void printResult(Connection connection, int minionId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?;");
        ps.setInt(1, minionId);

        ResultSet rs = ps.executeQuery();
        rs.next();

        System.out.printf("%s %d", rs.getString("name"), rs.getInt("age"));
    }
}
