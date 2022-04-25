package com.loreal.automation.utilities;

import java.io.IOException;
import java.sql.SQLException;
import jxl.read.biff.BiffException;
import org.testng.annotations.DataProvider;

import com.loreal.automation.base.BaseTest;
import com.loreal.automation.exceptions.DataSheetException;
import com.loreal.automation.exceptions.DatabaseConnectivityException;
import com.loreal.automation.exceptions.InvalidBrowserException;

/**
 * @author TCS
 * 
 */
public class TestDataProvider {

	/**
	 * @param tableName
	 *            - name of the database tableName from which data needs to be
	 *            fetched
	 * @param testCaseName
	 *            - name of the test case
	 * @return Object Array of HashMap which contains key value as column
	 *         heading and its corresponding value as value pair
	 * @throws DatabaseConnectivityException
	 * @throws SQLException
	 * @throws InvalidBrowserException 
	 */
	@DataProvider(name = "dataBase")
	public Object[][] getDatabaseData(String tableName, String testCaseName)
			throws DatabaseConnectivityException, SQLException, InvalidBrowserException {

		DatabaseConnection dbConnection = new DatabaseConnection(
				BaseTest.databaseType, BaseTest.databaseName,
				BaseTest.databaseUserName, BaseTest.databasePassword,BaseTest.databaseServerIP);
		dbConnection.getConnection();
		Object[][] dataMap = (Object[][]) null;

		// DatabaseConnection dbConnection = new DatabaseConnection();
		dataMap = dbConnection.getDataFromDatabase(tableName, testCaseName);
		return dataMap;
	}

	
	@DataProvider(name = "dataBase")
	public Object[][] getDataFromSingleRow(String tableName, String testCaseName, int rowNo)
			throws DatabaseConnectivityException, SQLException, InvalidBrowserException {

		DatabaseConnection dbConnection = new DatabaseConnection(
				BaseTest.databaseType, BaseTest.databaseName,
				BaseTest.databaseUserName, BaseTest.databasePassword,BaseTest.databaseServerIP);
		dbConnection.getConnection();
		Object[][] dataMap = (Object[][]) null;

		// DatabaseConnection dbConnection = new DatabaseConnection();
		dataMap = dbConnection.getDataFromSingleRow(tableName, testCaseName,rowNo);

		return dataMap;
	}

	
	/**
	 * This method will return a 2-dimensional object array with hashmap data in
	 * each object. The data fetched is from specified column name of a
	 * table,where test case name is that of class name for a specific row
	 * 
	 * @param tableName
	 * @param testCaseName
	 * @param rowNo
	 * @param columnHeading
	 * @return
	 * @throws DatabaseConnectivityException
	 * @throws SQLException
	 * @throws InvalidBrowserException 
	 */
	@DataProvider(name = "dataBase")
	public Object[][] getDataFromColumnRow(String tableName,
			String testCaseName, int rowNo, String columnHeading)
			throws DatabaseConnectivityException, SQLException, InvalidBrowserException {

		DatabaseConnection dbConnection = new DatabaseConnection(
				BaseTest.databaseType, BaseTest.databaseName,
				BaseTest.databaseUserName, BaseTest.databasePassword,BaseTest.databaseServerIP);
		dbConnection.getConnection();
		Object[][] dataMap = (Object[][]) null;

		// DatabaseConnection dbConnection = new DatabaseConnection();
		dataMap = dbConnection.getDataFromColumnRow(tableName, testCaseName, rowNo,
				columnHeading);
		return dataMap;
	}

	/**
	 * This method will return a 2-dimensional object array with hashmap data in
	 * each object. The data fetched is from specified column name of a database
	 * table.
	 * 
	 * @param tableName
	 * @param testCaseName
	 * @param columnHeading
	 * @return
	 * @throws DatabaseConnectivityException
	 * @throws SQLException
	 * @throws InvalidBrowserException 
	 */
	@DataProvider(name = "dataBase")
	public Object[][] getDataFromColumnHeading(String tableName,
			String testCaseName, String columnHeading)
			throws DatabaseConnectivityException, SQLException, InvalidBrowserException {

		DatabaseConnection dbConnection = new DatabaseConnection(
				BaseTest.databaseType, BaseTest.databaseName,
				BaseTest.databaseUserName, BaseTest.databasePassword,BaseTest.databaseServerIP);
		dbConnection.getConnection();
		Object[][] dataMap = (Object[][]) null;

		// DatabaseConnection dbConnection = new DatabaseConnection();
		dataMap = dbConnection.getColumnDataFromDatabase(tableName,
				testCaseName, columnHeading);
		return dataMap;
	}

	/**
	 * This method will return a 2-dimensional object array with hashmap data in
	 * each object. The data is fetched for a test case name from row values
	 * specified between from row no and to row now. Both row numbers are
	 * inclusive.
	 * 
	 * @param tableName
	 * @param testCaseName
	 * @param fromRowNo
	 * @param toRowNo
	 * @return
	 * @throws DatabaseConnectivityException
	 * @throws SQLException
	 * @throws InvalidBrowserException 
	 */
	@DataProvider(name = "dataBase")
	public Object[][] getDataFromRows(String tableName, String testCaseName,
			int fromRowNo, int toRowNo) throws DatabaseConnectivityException,
			SQLException, InvalidBrowserException {

		DatabaseConnection dbConnection = new DatabaseConnection(
				BaseTest.databaseType, BaseTest.databaseName,
				BaseTest.databaseUserName, BaseTest.databasePassword,BaseTest.databaseServerIP);
		dbConnection.getConnection();
		Object[][] dataMap = (Object[][]) null;

		// DatabaseConnection dbConnection = new DatabaseConnection();
		dataMap = dbConnection.getDataFromRows(tableName, testCaseName,
				fromRowNo, toRowNo);
		return dataMap;
	}

	/**
	 * This function returns the data from excel sheet for the specified class
	 * 
	 * @param externalSheetPath
	 * @param sheetName
	 * @return object array
	 * @throws NoDataInInputSheetException
	 * @throws IncorrectSheetPathException
	 * @throws InvalidSheetHeadingException
	 * @throws InvalidBrowserException
	 * @throws IOException
	 * @throws BiffException
	 * @throws DataSheetException
	 * @throws InvalidExecutionStatusException
	 */

	@DataProvider(name = "dataSheet")
	public Object[][] getTestDataFromExcel(String externalSheetPath,
			String sheetName) throws BiffException, IOException,
			 DataSheetException {

		Object[][] dataMap = (Object[][]) null;

		DataSheet dataSheetObj = new DataSheet();
		dataMap = dataSheetObj.readFromSheet(externalSheetPath, sheetName);

		return dataMap;
	}
	
	@DataProvider(name = "propertiesFile")
	public Object[][] getTestDataFromPropertiesFile(String externalSheetPath) throws IOException {
		Object[][] dataMap = (Object[][]) null;
		DataFile dataFile = new DataFile();
		dataMap = dataFile.readFromFile(externalSheetPath);
		return dataMap;
	}
	

}
