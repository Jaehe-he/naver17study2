package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleJoin {
	
	static final String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	// db에 접근하려면 url과 id, password가 필요하다
	String url = "jdbc:oracle:thin:@localhost:1521/xe"; //127.0.0.1 (localhost) //Oracle은 1521 , MySQL은 3306
	String username = "angel";
	String password = "pw1234";
	
	public Ex3OracleJoin() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패 : " +e.getMessage());
		}
	}
	
	//db 연결 성공 후 Connection을 반환하는 메서드
	public Connection getConnection() {
		Connection conn = null; //try-catch 해야하기 때문에 변수 따로 선언
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("오라클 접속 성공");
		} catch (SQLException e) {
			System.out.println("오라클 접속 실패 : " +e.getMessage());
		}
		return conn;
	}
	
	public void joinDataWrite() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select\r\n"
				+ "s.sangcode, sangname, sangprice, cntnum, to_char(cartday, 'yyyy-mm-dd') cartday\r\n"
				+ "from shop s, cart c\r\n"
				+ "where s.sangcode = c.sangcode";
		
		conn = this.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); //select sql문은 ResultSet이 반환되는 executeQuery만 가능
			// 여러개인 경우 while문으로 rs.next()가 true인 동안만 반복
			System.out.println("상품코드  상품명\t상품단가\t수량\t등록일");
			System.out.println("=".repeat(60));
			
			while(rs.next()) {
				String code = rs.getString("sangcode");
				String sname = rs.getString("sangname");
				int sprice = rs.getInt("sangprice");
				int ctnum = rs.getInt("cntnum");
				String date = rs.getString("cartday");
				
				System.out.println(code+"\t"+sname+"\t"+sprice+"\t\t"+ctnum+"\t"+date);
			}
		} catch (SQLException e) {
			System.out.println("sql문 오류 : " + e.getMessage());
		}finally {
			try {
				rs.close();
	            stmt.close();
	            conn.close();
			} catch (SQLException|NullPointerException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Ex3OracleJoin ex3 = new Ex3OracleJoin();
		ex3.joinDataWrite();

	}

}
