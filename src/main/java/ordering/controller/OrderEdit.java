package ordering.controller;

import ordering.Ordering;
import ordering.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderEdit", value = "/ordering/OrderEdit")
public class OrderEdit extends HttpServlet {

    //장바구니 목록에서 번호를 클릭하면 요청발생.클릭한 주문의 정보를 보여주는 상세페이지로 이동. 주문수량, 배송지를 입력받을 수 있게 폼에 출력
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        int num = Integer.parseInt(request.getParameter("num"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String addr = request.getParameter("addr");
        boolean ispay = Boolean.parseBoolean(request.getParameter("ispay"));
        Ordering o = new Ordering(num,0,amount,0,null,null,addr,ispay);
        service.editOrder(o);
        request.setAttribute("path", "/ordering/OrderList");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    //수정완료. 장바구니로 이동
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
