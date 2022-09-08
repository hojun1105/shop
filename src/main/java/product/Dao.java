package product;

import conn.MysqlConnect;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    private MysqlConnect dbconn;

    public Dao() {
        dbconn = MysqlConnect.getInstance();

    }

    public void insert(Product p) {
        Connection conn = dbconn.getConn();
        String sql = "insert into product(name,info,price,amount,seller,img1,img2,img3) values(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getInfo());
            pstmt.setInt(3, p.getPrice());
            pstmt.setInt(4, p.getAmount());
            pstmt.setString(5, p.getSeller());
            pstmt.setString(6, p.getImg1());
            pstmt.setString(7, p.getImg2());
            pstmt.setString(8, p.getImg3());

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

    public ArrayList<Product> selectBySeller(String seller) {
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from product where seller like ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+seller+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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


    public void update(Product p) {
        Connection conn = dbconn.getConn();

        String sql = "update product set name=?,info=?,price=?,amount=? where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getInfo());
            pstmt.setInt(3, p.getPrice());
            pstmt.setInt(4, p.getAmount());
            pstmt.setInt(5, p.getNum());

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

    public void updateImgs(Product p) {
        Connection conn = dbconn.getConn();
        String sql = "update product set img1=?, img2=?, img3=? where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getImg1());
            pstmt.setString(2, p.getImg2());
            pstmt.setString(3, p.getImg3());
            pstmt.setInt(4, p.getNum());
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

    public void delete(int num) {

        Connection conn = dbconn.getConn();


        String sql = "delete from product where num=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setInt(1, num);

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


    //상품번호로 검색
    public Product selectByNum(int num) {
        Product p = null;
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from product where num = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
                String name = rs.getString(2);
                String info = rs.getString(3);
                int price = rs.getInt(4);
                int amount = rs.getInt(5);
                String seller = rs.getString(6);
                String img1 = rs.getString(7);
                String img2 = rs.getString(8);
                String img3 = rs.getString(9);

                p = new Product(num, name, info, price, amount, seller, img1, img2, img3);
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
        return p;
    }

    //상품명으로 검색
    public ArrayList<Product> selectByName(String name) {//sql like 사용
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from product where name like ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+name+"%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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

    //가격대로 검색
    public ArrayList<Product> selectByPrice(int price1, int price2) {
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from product where price between ? and ? order by price";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, price1);
            pstmt.setInt(2, price2);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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

    //전체검색
    public ArrayList<Product> selectAll() {
        ArrayList<Product> list = new ArrayList<Product>();
        ResultSet rs = null;
        Connection conn = dbconn.getConn();
        String sql = "select * from product order by num desc";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
}
