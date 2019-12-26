package onlineCoaching.course3.JDBC;

import static onlineCoaching.course3.JDBC.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedRemove {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn =  getConnection(DBType.MYSQLDB);
		
		String sql = "Delete from newemployees where employee_id = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Employee ID");
		int empId = scanner.nextInt();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
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
