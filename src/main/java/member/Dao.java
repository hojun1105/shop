package member;

import conn.MysqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
    private MysqlConnect dbconn;

    public Dao() {
        dbconn = MysqlConnect.getInstance();
    }

    public void insert(Member m){

        Connection conn = dbconn.getConn();

        String sql = "insert into member(id, pwd, mem_type, tel, addr) values(?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPwd());
            pstmt.setBoolean(3, m.isMem_type());
            pstmt.setString(4, m.getTel());
            pstmt.setString(5,m.getAddr());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();// db close
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public Member select(String id){
        ResultSet rs;
        Connection conn = dbconn.getConn();
        String sql = "select * from member where id = ?";
        Member m = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();

            if(rs.next()){
                id=rs.getString(1);
                String pwd=rs.getString(2);
                Boolean mem_type=rs.getBoolean(3);
                String tel = rs.getString(4);
                String addr = rs.getString(5);
                m = new Member(id,pwd,mem_type,tel,addr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return m;
    }
    public void update(Member m){
        Connection conn = dbconn.getConn();
        String sql ="update member set pwd=?,tel=?,addr=? where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,m.getPwd());
            pstmt.setString(2,m.getTel());
            pstmt.setString(3,m.getAddr());
            pstmt.setString(4,m.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();// db close
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void delete(String id){
        Connection conn = dbconn.getConn();
        String sql = "delete from member where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();// db close
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
