package onlineCoaching.course3.JDBC;

import static onlineCoaching.course3.JDBC.DBUtil.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TestCallableBatchProcessing {

	public static void main(String[] args) {
		try(
				Connection conn =  getConnection(DBType.MYSQLDB);
				CallableStatement cstmt = conn.prepareCall("call addNewEmployee(?,?,?)");
				
				){
			
			String option;
			
			do {
				@SuppressWarnings("resource")
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
				
				cstmt.addBatch();
				
				System.out.println("Do you want to add another Record (yes/no) :");
				option = scanner.nextLine();
			}while(option.equals("yes"));
			
			int [] updateCounts = cstmt.executeBatch();
			
			System.out.println("Total Records Inserted are : "+updateCounts.length);
			
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}










