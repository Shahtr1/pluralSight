package onlineCoaching.course3.JDBC;

import static onlineCoaching.course3.JDBC.DBUtil.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestCallableIn {

	public static void main(String[] args) {
		try(
				Connection conn =  getConnection(DBType.MYSQLDB);
				CallableStatement cstmt = conn.prepareCall("call addNewEmployee(?,?,?)");
				
				){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Employee ID: ");
			int empId = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter Employee Name: ");
			String ename = scanner.nextLine();
			System.out.println("Enter email: ");
			String email = scanner.nextLine();
			
			cstmt.setInt(1, empId);
			cstmt.setString(2, ename);
			cstmt.setString(3, email);
			
			cstmt.execute();
			
			System.out.println("Added successfully");
			
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}










