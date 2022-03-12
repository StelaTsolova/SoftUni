import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class RemoveVillain_6 {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int villainId = Integer.parseInt(reader.readLine());

        boolean villainExistInDB = checkVillainExistInDB(connection, villainId);

        if (!villainExistInDB) {
            System.out.println("No such villain was found");
            return;
        }

        int releaseMinions = releaseMinionsAndReturnHow(connection, villainId);

        String villainName = getVillainName(connection, villainId);

        deleteVillain(connection, villainId);

        printResult(connection, villainName, releaseMinions);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
    }

    private static boolean checkVillainExistInDB(Connection connection, int villainId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT COUNT(id) AS count FROM villains WHERE id = ?;");
        ps.setInt(1, villainId);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getInt("count") == 1;
    }

    private static int releaseMinionsAndReturnHow(Connection connection, int villainId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?;");
        ps.setInt(1, villainId);

        return ps.executeUpdate();
    }

    private static String getVillainName(Connection connection, int villainId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name FROM villains WHERE id = ?;");
        ps.setInt(1, villainId);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getString("name");
    }

    private static void deleteVillain(Connection connection, int villainId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM villains WHERE id = ?;");
        ps.setInt(1, villainId);
        ps.executeUpdate();
    }

    private static void printResult(Connection connection, String villainName, int releaseMinions) throws SQLException {
        System.out.println(villainName + " was deleted");
        System.out.println(releaseMinions + " minions released");
    }
}
