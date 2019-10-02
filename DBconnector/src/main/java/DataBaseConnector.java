import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class DataBaseConnector implements AutoCloseable{
    Statement statement;
    Connection connection;
    private String salesforceUser = "user@test.com";
    private String  salesforcePassword = "password";

    DataBaseConnector() throws ClassNotFoundException {
        try {

            Class.forName("com.reliersoft.sforce.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:sforce://test.salesforce.com",salesforceUser,salesforcePassword);
            statement = connection.createStatement();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
