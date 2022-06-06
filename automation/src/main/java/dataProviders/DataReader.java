package dataProviders;

import com.google.gson.Gson;
import managers.FileReaderMng;
import testDataTypes.DataTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataReader {

    private final String dataFilePath = FileReaderMng.getInstance().getConfigReader().getTestDataPath() + "dataJson.json";
    private List<DataTypes> dataList;

    public DataReader() {
        dataList = getDataType();
    }

    private List<DataTypes> getDataType() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(dataFilePath));
            DataTypes[] dataTypes = gson.fromJson(bufferReader, DataTypes[].class);
            return Arrays.asList(dataTypes);
        } catch (FileNotFoundException o) {
            throw new RuntimeException("__Json_file_or_path_not_found__" + o);
        } finally {
            try {
                if (bufferReader != null) bufferReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final DataTypes getDataByLastName(String lastname) {
        return dataList.stream().filter(x -> x.firstName.equalsIgnoreCase(lastname)).findAny().get();
    }

    public final DataTypes getCustomerByFirstName(String firstname) {
        for (DataTypes dataInfo : dataList) {
            if (dataInfo.firstName.equalsIgnoreCase(firstname)) return dataInfo;
        }
        return null;
    }

    public final DataTypes getDataByPassport(String number) {
        return dataList.stream().filter(x -> x.passport.equalsIgnoreCase(number)).findAny().get();
    }
}
