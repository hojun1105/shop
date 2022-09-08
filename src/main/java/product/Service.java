package product;

import java.util.ArrayList;

public class Service {
    private Dao dao;

    public Service(){
        dao=new Dao();
    }
    public void addProduct(Product p){
        dao.insert(p);
    }
    public ArrayList<Product> getBySeller(String seller){
        return dao.selectBySeller(seller);
    }
    public void editProduct(Product p){
        dao.update(p);
    }
    public void editProductImg(Product p){
        dao.update(p);
    }
    public void delProduct(int num){
        dao.delete(num);
    }
    //상품번호로 검색
    public Product getByNum(int num){
        return dao.selectByNum(num);
    }
    //상품명으로 검색
    public ArrayList<Product> getByName(String name){
        return dao.selectByName(name);
    }
    //가격대로 검색
    public ArrayList<Product> getByPrice(int price1,int price2){
        return dao.selectByPrice(price1,price2);
    }
    //전체검색
    public ArrayList<Product> selectAll(){
        return dao.selectAll();
    }
}
