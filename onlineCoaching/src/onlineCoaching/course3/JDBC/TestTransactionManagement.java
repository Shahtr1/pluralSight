package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestTransactionManagement {
	public static void main(String[] args) {
		try {
			Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = null;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("PSBANK Transactions");
			System.out.println("----------------------");
			System.out.println("Enter From Account # :");
			int fromAcno = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter To Account # :");
			int toAcno = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter Amount To Transfer : ");
			double amount = Double.parseDouble(scanner.nextLine());
			
			String withdrawSQL = "update PSBANK set amount = amount - ? where acno = ?";
			pstmt = conn.prepareStatement(withdrawSQL);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, fromAcno);
			pstmt.executeUpdate();
			
			String depositSQL = "update PSBANK set amount = amount + ? where acno = ?";
			pstmt = conn.prepareStatement(depositSQL);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, toAcno);
			pstmt.executeUpdate();
			
			String sql = "Select amount from PSBANK where acno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fromAcno);
			ResultSet rs = pstmt.executeQuery();
			double balanceAmount = 0;
			if(rs.next()) {
				balanceAmount = rs.getDouble("amount");
			}
			
			if(balanceAmount >= 5000) {
				conn.commit();
				System.out.println("Amount transferred successfully...");
			}else {
				conn.rollback();
				System.out.println("Insufficient Funds : "+balanceAmount+" Transactions Rollbacked...");
			}
		}catch(SQLException e){
			DBUtil.showErrorMessage(e);
		}
	}
}



