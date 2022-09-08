package ordering;

import java.util.ArrayList;

public class Service {
    private Dao dao;

    public Service(){
        dao=new Dao();
    }
    public void addOrder(Ordering o){
        dao.insert(o);
    }

    public ArrayList<Ordering> myOrderList(String consumer){
        return dao.selectByConsumer(consumer);}
    //ispay:true(결제한 주문만 검색), ispay:false(결제대상, 취소대상)

    public ArrayList<Ordering> getByPay(boolean ispay, String consumer){
        return dao.selectByPay(ispay, consumer);}

    public  Ordering getByNum(int num){
        return dao.select(num);
    }

    //결제안된것만 주문 번호 기준으로 주문수량, 배송지 수정

    public void editPay(int num){
        dao.updatePay(num);
    }
    //결제안된것만 결제. ispay 만 true로 수정

    public void editOrder(Ordering o){
        dao.update(o);
    }

    public void delOrder(int num){
        dao.delete(num);
    }
}
