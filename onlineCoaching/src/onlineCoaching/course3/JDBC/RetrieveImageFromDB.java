package onlineCoaching.course3.JDBC;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveImageFromDB {
	public static void main(String[] args) throws SQLException, IOException {
		Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
		String sql = "select photo from newemployees3 where employee_id = 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			Blob imgBlob = rs.getBlob("photo");
			FileOutputStream fos = new FileOutputStream("D:/resume/pic.jpeg");
			
			fos.write(imgBlob.getBytes(1, (int)imgBlob.length()));
			
			fos.flush();
			fos.close();
			
			System.out.println("Downloaded successfully!!");
		}else {
			System.err.println("Employee Record not found");
		}
		rs.close();
		pstmt.close();
		conn.close();
	}
}






