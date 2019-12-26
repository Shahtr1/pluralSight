package onlineCoaching.course3.JDBC;

import static onlineCoaching.course3.JDBC.DBUtil.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class TestCallableOut {

	public static void main(String[] args) {
		try(
				Connection conn =  getConnection(DBType.MYSQLDB);
				CallableStatement cstmt = conn.prepareCall("call countEmployees(?,?)");
				
				){
			
			
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter Employee Name: ");
				String ename = scanner.nextLine();
				
				cstmt.setString(1, ename);
				
				cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
				
				cstmt.execute();
				
				int totalEmployees = cstmt.getInt(2);
				
				System.out.println("Total Employees with same name : " + totalEmployees);
				
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}
