//DB관리하는 클래스
package day0107db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class FoodModel {
	MysqlConnect mysqlConnect = new MysqlConnect();
	
	//메뉴등록 insert하는 메서드
	public void foodMenuInsert(String foodName, int foodPrice, String foodSize) {
		//Connection conn = mysqlConnect.getConnection();
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		String sql = "insert into foodrest (foodName,foodPrice,foodSize) values (?,?,?)";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, foodName);
			pstmt.setInt(2,  foodPrice);
			pstmt.setString(3, foodSize);
			
			//실행
			pstmt.execute(); //반환값 받을필요 없으니까 execute()
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}
	
	//전체 메뉴 반환하는 메서드
	public List<Vector<String>> getAllMenus(){ //Vector로 묶고 그 안에 데이터 타입을 String으로 통일
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql  ="select * from foodrest order by num";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));
				
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
		//예약등록 insert하는 메서드
		public void foodOrderInsert(FoodOrderDto dto) {
			//Connection conn = mysqlConnect.getConnection();
			Connection conn = null;
			
			PreparedStatement pstmt = null;
			String sql = "insert into foodorder (num,ordername,ordercnt,bookingday) values (?,?,?,?)";
			
			conn = mysqlConnect.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				
				//바인딩
				pstmt.setInt(1, dto.getNum());
				pstmt.setString(2, dto.getOrderName());
				pstmt.setInt(3,  dto.getOrderCnt());
				pstmt.setString(4, dto.getBookingDay());
				
				//실행
				pstmt.execute(); //반환값 받을필요 없으니까 execute()
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				mysqlConnect.dbClose(pstmt, conn);
			}
		}
		
		//전체 예약데이터 반환하는 메서드
		public List<Vector<String>> getAllOrders(){ //Vector로 묶고 그 안에 데이터 타입을 String으로 통일
			List<Vector<String>> list = new Vector<Vector<String>>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql  ="""
					SELECT
					idx, ordername, foodname, foodprice, foodsize, ordercnt, bookingday
					FROM foodrest fr, foodorder fo
					WHERE fr.num = fo.num
					""";
			
			conn = mysqlConnect.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Vector<String> data = new Vector<String>();
					data.add(rs.getString("idx"));
					data.add(rs.getString("ordername"));
					data.add(rs.getString("foodname"));
					data.add(rs.getString("foodprice"));
					data.add(rs.getString("foodsize"));
					data.add(rs.getString("ordercnt"));
					data.add(rs.getString("bookingday"));
					
					list.add(data);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				mysqlConnect.dbClose(rs, pstmt, conn);
			}
			
			return list;
		}
		
		//등록메뉴 삭제
		public void deleteFoodMenu(int num) {
			Connection conn = null;
			
			PreparedStatement pstmt = null;
			String sql = "delete from foodrest where num = ?";
			
			conn = mysqlConnect.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				
				//바인딩
				pstmt.setInt(1, num);
				
				//실행
				pstmt.execute(); //반환값 받을필요 없으니까 execute()
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				mysqlConnect.dbClose(pstmt, conn);
			}
		}
		
		//예약자 삭제
		public void deleteOrder(int idx) {
			Connection conn = null;
			
			PreparedStatement pstmt = null;
			String sql = "delete from foodorder where idx = ?";
			
			conn = mysqlConnect.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				
				//바인딩
				pstmt.setInt(1, idx);
				
				//실행
				pstmt.execute(); //반환값 받을필요 없으니까 execute()
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				mysqlConnect.dbClose(pstmt, conn);
			}
		}
		
		//등록 메뉴를 예약한건수를 반환
		public int getOrderMenuCount(int num) {
			int cnt = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select count(*) count from foodorder where num=?";
			
			conn = mysqlConnect.getConnection();
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1,  num);
				rs = pstmt.executeQuery();
				
				if(rs.next()) //num으로만 돌리기 때문에 while문 필요 없음
					cnt = rs.getInt("count");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				mysqlConnect.dbClose(rs, pstmt, conn);
			}
			
			
			
			return cnt;
		}
}
