package library_management_system;
import databasePackage.*;


public class MainClass {

	public static void main(String[] args) {
		IDatabase idatabase = new JdbcClass();
		idatabase.initializeDB();

	}

}
