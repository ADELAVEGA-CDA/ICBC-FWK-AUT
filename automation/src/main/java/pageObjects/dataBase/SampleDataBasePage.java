package pageObjects.dataBase;

import dataBase.DataBaseConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class SampleDataBasePage {
    protected Logger log = LogManager.getLogger(String.valueOf(this.getClass()));

    DataBaseConnection dbConnection;

    public SampleDataBasePage() {
        dbConnection = new DataBaseConnection();
    }

    public void selectExampleQuery() {
        String query = "Select id, name, lastname from students";
        List<Map<String, ?>> queryData = dbConnection.getDataFromDataBase(query);

        for (Map<String, ?> data : queryData) {
            for (Map.Entry<String, ?> entry : data.entrySet()) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            System.out.println("\n");
        }
    }

    private void insertExampleQuery() {
        String query = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
        dbConnection.modifyDataFromDataBase(query);
    }

    private void updateExampleQuery() {
        String query = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
        dbConnection.modifyDataFromDataBase(query);
    }

    private void deleteExampleQuery() {
        String query = "DELETE FROM Users WHERE username=?";
        dbConnection.modifyDataFromDataBase(query);
    }
}
