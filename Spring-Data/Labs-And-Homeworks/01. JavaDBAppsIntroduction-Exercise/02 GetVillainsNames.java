import java.sql.*;
import java.util.Properties;

public class GetVillainsNames_2 {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", "");
        props.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT v.name, COUNT(DISTINCT mv.minion_id) AS m_count " +
                "FROM villains AS v JOIN minions_villains AS mv ON v.id = mv.villain_id " +
                "GROUP BY mv.villain_id HAVING m_count > 15 ORDER BY m_count DESC;");

        while (rs.next()){
            System.out.printf("%s %d%n", rs.getString("name"), rs.getInt("m_count"));
        }
    }
}
