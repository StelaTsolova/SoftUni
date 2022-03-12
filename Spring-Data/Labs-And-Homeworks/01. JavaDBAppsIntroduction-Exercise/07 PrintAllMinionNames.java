import java.sql.*;
import java.util.ArrayDeque;
import java.util.Properties;

public class PrintAllMinionNames_7 {
    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();

        ArrayDeque<String> minionNames = getMinionNames(connection);

        printResult(minionNames);
    }

    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);
    }

    private static ArrayDeque<String> getMinionNames(Connection connection) throws SQLException {
        ArrayDeque<String> minionNames = new ArrayDeque<>();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT name FROM minions;");

        while (rs.next()) {
            minionNames.offer(rs.getString("name"));
        }

        return minionNames;
    }

    private static void printResult(ArrayDeque<String> minionNames) {
        int i = 0;
        while (!minionNames.isEmpty()) {
            if (i++ % 2 == 0) {
                System.out.println(minionNames.pop());
            } else {
                System.out.println(minionNames.pollLast());
            }
        }
    }
}
