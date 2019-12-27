package onlineCoaching.course3.JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImageWithinDB {
	public static void main(String[] args) throws SQLException, IOException {
		Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
		
		String sql = "update newemployees3 set photo = ? where employee_id = 1";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		File file = new File("D:/resume/pic.jpeg");
		
		FileInputStream fis = new FileInputStream(file);
		
		pstmt.setBinaryStream(1, fis,fis.available());
		
		int count = pstmt.executeUpdate();
		
		System.out.println("Total Records Updated : " + count);
		pstmt.close();
		conn.close();
	}
}
