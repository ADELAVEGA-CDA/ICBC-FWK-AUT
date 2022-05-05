package managers;

import dataProviders.ConfigReader;
import dataProviders.DataReader;

public class FileReaderMng {

	private static FileReaderMng fileReader=new FileReaderMng();
	private static ConfigReader configReader;
	private static DataReader dataReader;
	
	private FileReaderMng() {}

	// GET DATA 
	public static FileReaderMng getInstance() {
		return fileReader;}
	public ConfigReader getConfigReader() {
		return(configReader==null)?new ConfigReader():configReader;}
	public DataReader getDataReader() {
		return(dataReader==null)?new DataReader():dataReader;}
	
}
