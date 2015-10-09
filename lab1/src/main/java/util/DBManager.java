package util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {
    static DBManager instance;

    public String DB_URL;
    public String DB_TYPE;
    public String HOST;
    public String USER;
    public String DB_NAME;
    public String PORT;
    public String PASS;

    private DBManager() {
        final Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(
                DBManager.class.getClassLoader().getResource("database.properties").getPath())) {
            properties.load(fileReader);

            DB_TYPE = properties.getProperty("dbtype");
            HOST = properties.getProperty("host");
            USER = properties.getProperty("user");
            DB_NAME = properties.getProperty("dbname");
            PORT = properties.getProperty("port");
            PASS = properties.getProperty("password");
            DB_URL = String.format("jdbc:%s://%s:%s/", DB_TYPE, HOST, PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized static public DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return getConnection(true);
    }

    public Connection getConnection(boolean setCatalog) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to the database server...");

            try {
                Connection connection = DriverManager.getConnection(
                        DB_URL, USER, PASS);

                if (setCatalog) {
                    connection.setCatalog(DB_NAME);
                }
                return connection;
            } catch (final SQLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }


    public void initializeDatabase() {
        Connection connection = getConnection(false);
        // 1. Create db
        try (Statement stmt = connection.createStatement()) {
            final String sql = String.format("CREATE DATABASE %s", DB_NAME);
            stmt.executeUpdate(sql);
            System.out.println("Create database...");
        } catch (final SQLException e) {
            // database already exists
        }

        try {
            connection.setCatalog(DB_NAME);
            System.out.println("Set database...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // 2. Create table COMPANY
        try (final Statement stmt = connection.createStatement()) {
            final String sql = "CREATE TABLE company (" +
                    "id INT not NULL AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "description VARCHAR(1023), " +
                    "PRIMARY KEY (id)" +
                    ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table COMPANY...");
        } catch (final SQLException e) {
            // table already exists
        }

        // 3. Create table POSITION
        try (final Statement stmt = connection.createStatement()) {
            final String sql = "CREATE TABLE `position` (" +
                    "id INT not NULL AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "description VARCHAR(1023), " +
                    "company_id INT, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE CASCADE" +
                    ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table POSITION...");
        } catch (final SQLException e) {
            // table already exists
        }

        // 4. Create table WORKER
        try (final Statement stmt = connection.createStatement()) {
            final String sql = "CREATE TABLE worker (" +
                    "id INT not NULL AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "position_id INT, " +
                    "salary INT, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (position_id) REFERENCES `position`(id) ON DELETE CASCADE " +
                    ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table WORKER...");
        } catch (final SQLException e) {
            // table already exists
        }

        // 5. Create table VACANCY
        try (final Statement stmt = connection.createStatement()) {
            final String sql = "CREATE TABLE vacancy (" +
                    "id INT not NULL AUTO_INCREMENT, " +
                    "description VARCHAR(1023), " +
                    "position_id INT, " +
                    "salary INT, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (position_id) REFERENCES `position`(id) ON DELETE CASCADE" +
                    ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table VACANCY...");
        } catch (final SQLException e) {
            // table already exists
        }

        // 6. Create table CANDIDATE
        try (final Statement stmt = connection.createStatement()) {
            final String sql = "CREATE TABLE candidate (" +
                    "id INT not NULL AUTO_INCREMENT, " +
                    "name VARCHAR(255), " +
                    "resume VARCHAR(1023), " +
                    "vacancy_id INT, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (vacancy_id) REFERENCES vacancy(id) ON DELETE CASCADE" +
                    ")";

            stmt.executeUpdate(sql);
            System.out.println("Created table CANDIDATE...");
        } catch (final SQLException e) {
            // table already exists
        }
    }

    public void deleteDatabase() {
        Connection connection = getConnection();

        try (Statement stmt = connection.createStatement()) {
            final String sql = String.format("DROP DATABASE %s", DB_NAME);
            stmt.executeUpdate(sql);
            System.out.println("Drop database...");
        } catch (final SQLException e) {
            // database doesn't exist.
        }
    }
}
