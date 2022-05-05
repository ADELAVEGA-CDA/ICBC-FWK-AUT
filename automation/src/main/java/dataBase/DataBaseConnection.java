package dataBase;

import managers.FileReaderMng;
import org.junit.After;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class DataBaseConnection {
    // Connection object
    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL;
    // Constant for Database Username
    public static String DB_USER;
    // Constant for Database Password
    public static String DB_PASSWORD;

    public DataBaseConnection() {
        DB_URL = FileReaderMng.getInstance().getConfigReader().getDBURL();
        DB_USER = FileReaderMng.getInstance().getConfigReader().getDBUser();
        DB_PASSWORD = FileReaderMng.getInstance().getConfigReader().getDBPassword();

        try {
            // Make the database connection
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            // Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, ?>> getDataFromDataBase(String query) {
        try {
            // Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
            // Return the result in a list with all the records
            List<Map<String, ?>> lista = DataBaseUtils.rsToList(res);
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @After
    public void tearDown() throws Exception {
        // Close DB connection
        if (con != null) {
            con.close();
        }
    }
}
