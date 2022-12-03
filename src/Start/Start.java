package Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Student.Student;
import Student.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		
		while(true) {
			System.out.println("press 1 : Add Student");
			System.out.println("press 2 : Delete Student");
			System.out.println("press 3 : Display Student");
			System.out.println("press 4 : exit");
			
			//read from console as per your choice 
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			// taking an integer for perform operation
			int readLine =Integer.parseInt(br.readLine());
			
			if(readLine==1) {
				//add student
				
				System.out.println("enetr student name");
				String name = br.readLine();
				
				System.out.println("enetr student phone");
				int phone = Integer.parseInt(br.readLine());
				
				System.out.println("enetr student city");
				String city = br.readLine();
				
				Student s1 = new Student(name,phone ,city);
				boolean added = StudentDao.addToDataBase(s1);
				if(added) {
					System.out.println("data added successfully");
				}
				else {
					System.out.println("data not addd to db");
				}
			}
			else if(readLine==2) {
				//delete stdent
				
				System.out.println("enter student id to delete");
				int userId = Integer.parseInt(br.readLine());
				boolean deleted = StudentDao.deleteStudent(userId);
				if(deleted) {
					System.out.println("deleted successfully");
				}
				else {
					System.out.println("delete failed");
				}
			}
			else if(readLine==3) {
				//display studnet
				System.out.println("displaying all students");
				StudentDao.getAllStudents();
			}
			
			else if(readLine==5) {
				// delete student by name
				String name = br.readLine();
				boolean deleted = StudentDao.deleteStudentByName(name);
				if(deleted) {
					System.out.println("deleted successfully by name");
				}
				else {
					System.out.println("delete failed");
				}
			}
			else if(readLine==4) {
				//exit
				break;
			}
			else {
				
			}
		}
		
		System.out.println("thank you .....");

	}

}
