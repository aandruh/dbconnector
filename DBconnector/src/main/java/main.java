
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main  {
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        if (statement == null) {
            try {
                statement = new DataBaseConnector().statement;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ResultSet rs = statement.executeQuery("SELECT Id FROM Account LIMIT 3");
        while (rs.next()) {
                    System.out.println(rs.getString(1));
                }


    }

}
