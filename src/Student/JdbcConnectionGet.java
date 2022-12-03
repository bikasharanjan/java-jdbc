package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionGet {
	
	static Connection conn;
	
	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		
		
		//load the driver
		
		Class.forName("com.mysql.jdbc.Driver");
		//create connection
		String url ="jdbc:mysql://localhost:3306/student_manage";
		String user="root";
		String password="root";
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}

}
