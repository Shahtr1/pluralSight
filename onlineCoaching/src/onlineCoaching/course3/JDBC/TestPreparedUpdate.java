package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedUpdate {
	public static void main(String[] args) throws SQLException {
		Connection conn =  DBUtil.getConnection(DBType.MYSQLDB);
		
		String sql = "update newemployees set employee_id = ? where employee_name = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Employee Name:");
		String empName = scanner.nextLine();
		
		System.out.println("Enter New Employee ID");
		int empId = scanner.nextInt();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(2, empName);
		pstmt.setInt(1, empId);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("Success");
		}else {
			System.err.println("Error");
		}
		
		scanner.close();
		pstmt.close();
		conn.close();
	}
}
