package dataBase;

import enums.SQLDriversType;
import managers.FileReaderMng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class DataBaseConnection {
    protected Logger log = LogManager.getLogger(String.valueOf(this.getClass()));

    static Connection con = null;
    private static Statement stmt;
    public static SQLDriversType DB_DRIVER;
    public static String DB_URL;
    public static String DB_USER;
    public static String DB_PASSWORD;

    public DataBaseConnection() {
        String className = "";
        DB_DRIVER = FileReaderMng.getInstance().getConfigReader().getDBDriver();
        switch (DB_DRIVER) {
            case MYSQL:
                className = "com.mysql.cj.jdbc.Driver";
                break;
            case SQLSERVER:
                className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                break;
            case POSTGRES:
                className = "org.postgresql.Driver";
                break;
            case ORACLE:
                className = "oracle.jdbc.driver.OracleDriver";
                break;
            default:
                className = "com.mysql.cj.jdbc.Driver";
        }
        
        DB_URL = FileReaderMng.getInstance().getConfigReader().getDBURL();
        DB_USER = FileReaderMng.getInstance().getConfigReader().getDBUser();
        DB_PASSWORD = FileReaderMng.getInstance().getConfigReader().getDBPassword();

        try {
            Class.forName(className);

            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, ?>> getDataFromDataBase(String query) {
        try {
            ResultSet res = stmt.executeQuery(query);
            List<Map<String, ?>> list = DataBaseUtils.rsToList(res);

            res.close();
            stmt.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyDataFromDataBase(String query) {
        try {
            int rowsUpdated = stmt.executeUpdate(query);
            if (rowsUpdated > 0) {
                log.info("DataBase was updated successfully!");
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
