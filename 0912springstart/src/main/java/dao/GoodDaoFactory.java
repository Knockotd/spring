package dao;

public class GoodDaoFactory {
	//GoodDao 인스턴스를 생성해서 리턴하는 메소드
	public static GoodDao create() {
		return new GoodDao();
	}
}
