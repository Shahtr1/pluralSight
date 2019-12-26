package onlineCoaching.course3.JDBC;

import static onlineCoaching.course3.JDBC.DBUtil.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class TestCallableResultsets {

	public static void main(String[] args) {
		try(
				Connection conn =  getConnection(DBType.MYSQLDB);
				CallableStatement cstmt = conn.prepareCall("Call callingResultsets(?);");
				
				){
			
			
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter Employee Name: ");
				String ename = scanner.nextLine();
				
				cstmt.setString(1, ename);
			
				boolean hasResults = cstmt.execute();
				
				while(hasResults) {
					ResultSet rs = cstmt.getResultSet();
					
					while(rs.next()) {
						int id = rs.getInt("employee_id");
						String name = rs.getString("employee_name");
						String email = rs.getString("email");
						
						System.out.print(id+"  "+name+"  "+email);
						System.out.println();
					}
					
					hasResults  = cstmt.getMoreResults();
				}
				
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}

