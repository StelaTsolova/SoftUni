import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class AddMinion_4 {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = getConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionData = reader.readLine().split(" ");
        String minionName = minionData[1];
        int age = Integer.parseInt(minionData[2]);
        String town = minionData[3];

        addTownIfNotExist(connection, town);

        addMinion(connection, minionName, age, town);

        String[] villainData = reader.readLine().split(" ");
        String villainName = villainData[1];

        addVillainIfNotExist(connection, villainName);

        setNewMinion(connection, minionName, villainName);

        printResult(minionName, villainName);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
    }

    private static void addTownIfNotExist(Connection connection, String town) throws SQLException {
        boolean townExistInDB = checkTownExistInDB(connection, town);

        if (!townExistInDB) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO towns (name) VALUES " + "('" + town + "')");
            ps.executeUpdate();

            System.out.printf("Town %s was added to the database.%n", town);
        }
    }

    private static boolean checkTownExistInDB(Connection connection, String town) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name FROM towns;");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            if (town.equals(rs.getString("name"))) {
                return true;
            }
        }

        return false;
    }

    private static void addMinion(Connection connection, String name, int age, String town) throws SQLException {
        int town_id = getTownId(connection, town);

        String sql = String.format("('%s', %d, %d);", name, age, town_id);
        PreparedStatement ps = connection.prepareStatement("INSERT INTO minions (name, age, town_id) VALUES " + sql);
        ps.executeUpdate();
    }

    private static int getTownId(Connection connection, String town) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT id FROM towns WHERE name = ?;");

        ps.setString(1, town);
        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getInt("id");
    }

    private static void addVillainIfNotExist(Connection connection, String name) throws SQLException {
        boolean villainExistInDB = checkVillainExistInDB(connection, name);

        if (!villainExistInDB) {
            String sql = String.format("('%s', '%s')", name, "evil");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO villains (name, evilness_factor) " +
                    "VALUES " + sql);
            ps.executeUpdate();

            System.out.printf("Villain %s was added to the database.%n", name);
        }
    }

    private static boolean checkVillainExistInDB(Connection connection, String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT name FROM villains;");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            if (name.equals(rs.getString("name"))) {
                return true;
            }
        }

        return false;
    }

    private static void setNewMinion(Connection connection, String minionName, String villainName) throws SQLException {
        int minionId = getMinionId(connection, minionName);
        int villainId = getVillainId(connection, villainName);

        String sql = String.format("(%d, %d)", minionId, villainId);
        PreparedStatement ps = connection.prepareStatement("INSERT minions_villains VALUES " + sql);
        ps.executeUpdate();
    }

    private static int getMinionId(Connection connection, String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT id FROM minions WHERE name = ?;");
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getInt("id");
    }

    private static int getVillainId(Connection connection, String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT id FROM villains WHERE name = ?;");
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getInt("id");
    }

    private static void printResult(String minionName, String villainName) {
        System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
    }
}
