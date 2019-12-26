package onlineCoaching.course3.JDBC;

import static onlineCoaching.course3.JDBC.DBUtil.getConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class TestCallableInOut {

	public static void main(String[] args) {
		try(
				Connection conn =  getConnection(DBType.MYSQLDB);
				CallableStatement cstmt = conn.prepareCall("call addToId(?);");
				
				){
			
			
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter Employee ID: ");
				int eid = scanner.nextInt();
				
				cstmt.setInt(1, eid);
				
				cstmt.registerOutParameter(1, eid);
				
				cstmt.execute();
				
				int newId = cstmt.getInt(1);
				
				System.out.println("New ID : " + newId);
				
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}

	}

}
