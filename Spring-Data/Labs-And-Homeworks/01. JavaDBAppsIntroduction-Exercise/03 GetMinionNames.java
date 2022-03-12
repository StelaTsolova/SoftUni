import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

public class GetMinionNames_3 {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int villainId = Integer.parseInt(reader.readLine());

        boolean villainIdExistInDB = checkVillainIdExistInDB(connection, villainId);

        if (!villainIdExistInDB) {
            System.out.printf("No villain with ID %d exists in the database.", villainId);
            return;
        }

        String villainName = getVillainNameById(connection, villainId);

        Set<String> minions = getMinionsByVillainId(connection, villainId);

        printResult(villainName, minions);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
    }

    private static boolean checkVillainIdExistInDB(Connection connection, int villainId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT id FROM villains;");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            if (villainId == rs.getInt("id")) {
                return true;
            }
        }

        return false;
    }

    private static String getVillainNameById(Connection connection, int villainId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name FROM villains WHERE id = ?;");
        ps.setInt(1, villainId);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getString("name");
    }

    private static Set<String> getMinionsByVillainId(Connection connection, int villainId) throws SQLException {
        Set<String> minions = new LinkedHashSet<>();

        PreparedStatement ps = connection.prepareStatement("SELECT m.name, m.age FROM villains AS v " +
                "JOIN minions_villains AS mv ON v.id = mv.villain_id JOIN minions AS m ON m.id = mv.minion_id " +
                "WHERE v.id = ?");
        ps.setInt(1, villainId);

        ResultSet rs = ps.executeQuery();

        int counter = 1;
        while (rs.next()) {
            minions.add(String.format("%d. %s %d", counter++, rs.getString("name"),
                    rs.getInt("age")));
        }

        return minions;
    }

    private static void printResult(String villainName, Set<String> minions) {
        System.out.println("Villain: " + villainName);

        minions.forEach(System.out::println);
    }
}
