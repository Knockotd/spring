package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.GoodVO;

public class GoodDao {
	// GoodDao(){}
	public GoodDao(){}

	// 전체 데이터를 가져오는 메소드
	// 파라미터를 만들 때는 insert 나 update는 VO
	// delete는 primary key
	// select는 where 절에 대입되어야 하는데이터
	// select * from goods
	public List<GoodVO> getGood() {
		// List를리턴할 때는 객체를 생성하고 리턴하도록 생성
		List<GoodVO> list = new ArrayList<GoodVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//오라클 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user05", "user05");
			ps = con.prepareStatement("select * from goods");
			rs = ps.executeQuery();
			while(rs.next()) {
				GoodVO vo = new GoodVO();
				vo.setCode(rs.getInt("code"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setDescription(rs.getString("description"));
				list.add(vo);
			}

		} catch (Exception e) {
			System.out.println("DB 데이터 읽기 오류 : " + e.getMessage());
			e.printStackTrace();

		} finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e) {
				
			}
		}

		return list;
	}
}
