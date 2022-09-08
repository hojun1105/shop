package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//db ����. db������ �α����ؼ� ���� ����
public class MysqlConnect {
	private static MysqlConnect myconn = new MysqlConnect();
	//db���� �ּ�, ��Ʈ��ȣ /�����ͺ��̽���?����
	private String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
	//����̹� ��
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	//�̱���. �ڿ�����
	private MysqlConnect() {

	}
	
	public static MysqlConnect getInstance() {
		return myconn;
	}
	

	public Connection getConn() {
		try {

			Class.forName(driver);
			//�α���. ���� ����
			Connection conn = DriverManager.getConnection(url, "root", "00000000");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
