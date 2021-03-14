package databasePackage;
import java.sql.*;

public class JdbcClass implements IDatabase {
Connection con = null;
Statement st = null;
	
	public void initializeDB() {
		openConnection();
		createTables();
		insertUserTypes();
		closeConnection();
	}

	private void createTables()
	{
		createAdminTable();
		createAuthorTable();
		createBookTable();
		createUserTypeTable();
		createUserTable();
		createBookUserAssociationTable();
		
	}
	
	private boolean IfExists(String tableName) {
		try {
			String query = "SELECT * FROM information_schema.tables WHERE table_schema = 'librarymanagementsystem'  AND table_name = '"+tableName+"'";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			return  rs.next();
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	private void createTable(String tableName, String query) {
		if(!IfExists(tableName)) {
			executeUpdate(query);
		}	
	}
	
	private void executeUpdate(String query) {
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void executeQuery(String query) {
		try {
			st = con.createStatement();
			st.executeQuery(query);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void openConnection()
	{
		try {
			Class.forName(DBInfo.DRIVER);
			con = DriverManager.getConnection(DBInfo.DB_URL,DBInfo.DB_USERNAME,DBInfo.DB_PASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void closeConnection() {
		try
		{
			st.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	private void createAdminTable()
	{
		createTable(DBInfo.ADMIN_TABLE, DBInfo.CREATE_ADMIN_TABLE);
	}
	
	private void createAuthorTable()
	{
		createTable(DBInfo.AUTHOR_TABLE, DBInfo.CREATE_AUTHOR_TABLE);
	}
	
	private void createBookTable()
	{
		createTable(DBInfo.BOOK_TABLE, DBInfo.CREATE_BOOK_TABLE);
	}
	
	private void createUserTypeTable()
	{
		createTable(DBInfo.USER_TYPE, DBInfo.CREATE_USER_TYPE);
	}
	
	private void createUserTable() {
		createTable(DBInfo.USER_TABLE, DBInfo.CREATE_USER_TABLE);
	}
	
	private void createBookUserAssociationTable()
	{
		createTable(DBInfo.BOOK_USER_ASSOCIATION_TABLE, DBInfo.CREATE_BOOK_USER_ASSOCIATION_TABLE);
	}
	
	private boolean ifUserTypeExist(String userType)
	{
		try
		{
			String query = "Select * from UserType where Type = "+ userType;
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			return  rs.next();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	private void insertUserTypeTable(String userType)
	{
		if(!ifUserTypeExist(userType))
		try
		{
			String query = "insert into UserType(Type) values ('"+ userType+ "')";
			executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	private void insertUserTypes() {
		for (String userType : DBInfo.USER_TYPES) {
			insertUserTypeTable(userType);
		}
	}
	

}
