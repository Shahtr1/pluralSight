package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedInsert {
	public static void main(String[] args) throws SQLException {
		Connection conn =  DBUtil.getConnection(DBType.MYSQLDB);
		
		int employee_id;
		String employee_name, email;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Employee ID : ");
		employee_id = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter Employee Name : ");
		employee_name = scanner.nextLine();
		
		System.out.println("Enter Email : ");
		email = scanner.nextLine();
		
		String sql = "insert into newemployees values(?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, employee_id);
		pstmt.setString(2, employee_name);
		pstmt.setString(3, email);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("Record Inserted Successfully");
		}else {
			System.out.println("Error");
		}
		
		scanner.close();
		pstmt.close();
		conn.close();
	}
}







