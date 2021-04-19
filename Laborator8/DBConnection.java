import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static final DBConnection connection = new DBConnection();
    String database = "java";
    String username = "postgres";
    String password = "gabriela";
    String url = "jdbc:postgresql://localhost/";
    Statement statement = null;
    ResultSet rset = null;
    boolean databaseListChanged = false;
    int result = -1;
    private Connection connectionDB;

    public void createDatabase() {
        try {
            connectionDB.close();
            String url = "jdbc:postgresql://localhost/postgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "gabriela");
            connectionDB = DriverManager.getConnection(url, props);
            statement = connectionDB.createStatement();
            System.out.println("List of databases accessible by user " + username + "\n");
            rset = statement.executeQuery("SELECT datname FROM pg_database;");
            while (rset.next()) {
                System.out.println(rset.getString(1));
            }
            rset.close();
            System.out.println();
            result = statement.executeUpdate("DROP DATABASE " + database);
//            System.out.println("result of 'DROP DATABASE' " + database + " is " + result);
            databaseListChanged = true;
            result = statement.executeUpdate("CREATE DATABASE " + database);
//            System.out.println("result of 'CREATE DATABASE' " + database + " is " + result);
            databaseListChanged = true;
            connectionDB.close();
            String urlConnect = "jdbc:postgresql://localhost/java";
            Properties properties = new Properties();
            properties.setProperty("user", "postgres");
            properties.setProperty("password", "gabriela");
            connectionDB = DriverManager.getConnection(urlConnect, properties);
            System.out.println("M-am conectat");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnectionDB() {
        try {
            connectionDB.close();
            System.out.println("\nM-am deconectat");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private DBConnection() {
        try {
            String url = "jdbc:postgresql://localhost/java";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "gabriela");
            connectionDB = DriverManager.getConnection(url, props);
            System.out.println("M-am conectat");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static DBConnection getConnection() {
        return connection;
    }

    public Connection getConnectionDB() {
        return connectionDB;
    }
}
