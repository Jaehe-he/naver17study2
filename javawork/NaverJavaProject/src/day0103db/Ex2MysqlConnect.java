package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2MysqlConnect {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul"; // 추후에 프로젝트 땐 localhost가 클라우드 주소로 들어갈 것
	String username = "root";
	String password = "1234";
	
	public Ex2MysqlConnect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패 : "+e.getMessage());
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Mysql 접속 성공");
		} catch (SQLException e) {
			System.out.println("Mysql 접속 실패 : " +e.getMessage());
		}
		return conn;
	}
	
	public void personWriteData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//방법 1 - 큰 "" 안에 중간 ""는 \ 같이 적어주기
//		String sql = "select name, age, blood, hp, date_format(today, \"%Y-%m-%d %H:%i\") today from person";
		//방법 2 - jdk17에서 추가된 기능 - 멀티라인 테스트 """ """ 안에 넣기 (마지막 ;은 빼야함)
		String sql = """
				select name, age, blood, hp, date_format(today, "%Y-%m-%d %H:%i") today from person
				""";

		conn = this.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("이름\t나이\t혈액형\t   전화번호\t\t날짜");
			System.out.println("=".repeat(58));
			
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String blood = rs.getString("blood");
				String phonenumber = rs.getString("hp");
				String date = rs.getString("today");
				
				System.out.println(name+"\t"+age+"\t"+blood+"\t"+phonenumber+"\t"+date+"\t");
			}
		} catch (SQLException e) {
			System.out.println("sql문 오류 : " + e.getMessage());
		}finally {
			try {
				rs.close();
			} catch (SQLException|NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2MysqlConnect ex2 = new Ex2MysqlConnect();
		ex2.personWriteData();
	}

}
