package testDB;
import java.sql.*;



public class testDBMain {
	public static final String DB_NAME = "school.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:C://sqlitedb/" + DB_NAME;
	public static final String TABLE_STUDENT = "student";
	public static final String COLUMN_NO = "no";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_SURNAME = "surname";

	public static void main(String[] args) throws SQLException {		
		
		try {
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			Statement statement = conn.createStatement();
			//statement.execute("INSERT INTO"+ TABLE_STUDENT "VALUES(4,'Burak','Padir')");		
			ResultSet results = statement.executeQuery("SELECT * FROM "+ TABLE_STUDENT);		
		
			while(results.next()) {
				System.out.println(
							   results.getInt(COLUMN_NO) 
						+ " "+ results.getString(COLUMN_NAME)
						+ " "+ results.getString(COLUMN_SURNAME));	
			}
			
			results.close();
			statement.close(); 
			conn.close();	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
