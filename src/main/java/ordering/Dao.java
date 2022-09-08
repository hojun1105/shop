package ordering;

import conn.MysqlConnect;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;

public class Dao {
    private MysqlConnect dbconn;
    public Dao(){
        dbconn = MysqlConnect.getInstance();
    }

    public void insert(Ordering o){
        Connection conn = dbconn.getConn();
        String sql = "insert into ordering(prod_num,amount,payment,w_date,consumer,addr,ispay) values(?,?,?,now(),?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, o.getProd_num());
            pstmt.setInt(2, o.getAmount());
            pstmt.setInt(3, o.getPayment());
            pstmt.setString(4, o.getConsumer());
            pstmt.setString(5, o.getAddr());
            pstmt.setBoolean(6, o.isIspay());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public Ordering select(int num){
        ResultSet rs;
        Ordering o = null;

        Connection conn = dbconn.getConn();
        String sql = "select * from ordering where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            rs=pstmt.executeQuery();

            if(rs.next()){
                num = rs.getInt(1);
                int prod_num = rs.getInt(2);
                int amount = rs.getInt(3);
                int payment = rs.getInt(4);
                Date w_date = rs.getDate(5);
                String consumer = rs.getString(6);
                String addr = rs.getString(7);
                Boolean ispay = rs.getBoolean(8);

                o=new Ordering(num,prod_num,amount,payment,w_date,consumer,addr,ispay);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return o;
    }


    //구매자별 구매목록 검색
    public ArrayList<Ordering> selectByConsumer(String consumer){
        ArrayList<Ordering> list = new ArrayList<Ordering>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from ordering where consumer like ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+consumer+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Ordering(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getBoolean(8)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;

    }

    //ispay:true(결제한 주문만 검색), ispay:false(결제대상, 취소대상)
    public ArrayList<Ordering> selectByPay(boolean ispay, String consumer){
        ArrayList<Ordering> list =new ArrayList<Ordering>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from ordering where ispay=? and consumer=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, ispay);
            pstmt.setString(2, consumer);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int num = rs.getInt(1);
                int prod_num = rs.getInt(2);
                int amount = rs.getInt(3);
                int payment = rs.getInt(4);
                Date w_date = rs.getDate(5);
                consumer = rs.getString(6);
                String addr = rs.getString(7);
                ispay = rs.getBoolean(8);
                list.add(new Ordering(num, prod_num, amount, payment, w_date, consumer, addr, ispay));
            }
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
        return list;
    }
    //결제안된것만 주문 번호 기준으로 주문수량, 배송지 수정
    public void update(Ordering o){
        Connection conn = dbconn.getConn();

        String sql = "update product set amount=?,addr=? where num=? and ispay =? ";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,o.getAmount());
            pstmt.setString(2,o.getAddr());
            pstmt.setInt(3,o.getNum());
            pstmt.setBoolean(4,o.isIspay());

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
    //결제안된것만 결제. ispay 만 true로 수정
    public void updatePay(int num){
        Connection conn = dbconn.getConn();

        String sql = "update ordering set ispay=true where num=? and ispay is false ";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,num);
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

    public void delete(int num){
        Connection conn = dbconn.getConn();
        String sql = "delete from ordering where num=?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,num);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
