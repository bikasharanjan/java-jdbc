package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	static Connection connection;

	public static boolean addToDataBase(Student s1) {
		boolean isSaved=false;
		
		try {
			connection = JdbcConnectionGet.createConnection();
			String query="insert into students (sname , sphone ,scity) values(?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, s1.getsName());
			prepareStatement.setInt(2, s1.getsPhone());
			prepareStatement.setString(3, s1.getsCity());
			
			// execute query
			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println(executeUpdate);
			isSaved=true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return isSaved;
		
	}

	public static boolean deleteStudent(int userId) {
		
		boolean isDeleted=false;
		
		try {
			connection = JdbcConnectionGet.createConnection();
			String query="delete from students where sid=?";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setInt(1, userId);
			// execute query
			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println(executeUpdate);
			isDeleted=true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return isDeleted;
	}

	public static void getAllStudents() {
		try {
			connection = JdbcConnectionGet.createConnection();
			String query="select * from students";
			Statement createStatement = connection.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(query);
			
			while (executeQuery.next()) {
				int id =executeQuery.getInt(1);
				String name=executeQuery.getString(2);
				int phone =executeQuery.getInt(3);
				String city=executeQuery.getString(4);
				
				System.out.println("ID :" +id);
				System.out.println("Name :"+ name) ;
				System.out.println(" phone :"+ phone) ;
				System.out.println(" city :"+city);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static boolean deleteStudentByName(String name) {
		boolean isDeleted=false;
		try {
			connection = JdbcConnectionGet.createConnection();
			String query="delete from students where sname=?";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setString(1, query);
			// execute query
			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println(executeUpdate);
			isDeleted=true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		return isDeleted;
		
	}

}
