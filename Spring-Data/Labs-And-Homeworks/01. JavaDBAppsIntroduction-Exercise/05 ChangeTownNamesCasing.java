import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public class ChangeTownNamesCasing_5 {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();

        PreparedStatement ps = connection.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String county = reader.readLine();
        ps.setString(1, county);

        int changedTowns = ps.executeUpdate();

        printResult(connection, changedTowns, county);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
    }

    private static void printResult(Connection connection, int changedTowns, String county) throws SQLException {
        if (changedTowns == 0) {
            System.out.println("No town names were affected.");
            return;
        }

        Set<String> towns = getChangedTowns(connection, county);

        System.out.println(changedTowns + " town names were affected.");
        System.out.printf("[%s]", String.join(", ", towns));
    }

    private static Set<String> getChangedTowns(Connection connection, String county) throws SQLException {
        Set<String> towns = new LinkedHashSet<>();

        PreparedStatement ps = connection.prepareStatement("SELECT name FROM towns WHERE country = ?;");
        ps.setString(1, county);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            towns.add(rs.getString("name"));
        }

        return towns;
    }
}
