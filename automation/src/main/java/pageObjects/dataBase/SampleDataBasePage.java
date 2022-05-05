package pageObjects.dataBase;

import dataBase.DataBaseConnection;
import managers.FileReaderMng;

import java.util.List;
import java.util.Map;

public class SampleDataBasePage {
    DataBaseConnection dbConnection;

    public SampleDataBasePage() {
        dbConnection = new DataBaseConnection();
    }

    private Boolean _size = FileReaderMng.getInstance().getConfigReader().getBrowserSize();

    public void load_DataBase() {
        //if (_size) drv.manage().window().maximize();

        List<Map<String, ?>> queryData = dbConnection.getDataFromDataBase("Select id, name, lastname from students");

        for (Map<String, ?> data : queryData) {
            for (Map.Entry<String, ?> entry : data.entrySet()) {
                System.out.print(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            System.out.println("\n");
        }
    }

}
