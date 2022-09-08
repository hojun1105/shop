package ordering.controller;

import ordering.Ordering;
import ordering.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderAdd", value = "/ordering/OrderAdd")
public class OrderAdd extends HttpServlet {

    @Override
    //구매자가 상품 목록에서 상품명 클릭하면 상품을 검색해서 주문 수량 입력 받아서 주문/장바구니 폼으로 이동
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path", "/ordering/addForm.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    @Override
    //구매완료.상품번호, 수량, 결제금액, 구매자id파람으로 받아 order 테이블에 추가하고 상품목록으로 이동
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Service service = new Service();
        int prod_num = Integer.parseInt(request.getParameter("prod_num"));
        int amount = Integer.parseInt(request.getParameter("order_amount"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        String consumer = request.getParameter("consumer");
        String addr = request.getParameter("addr");

        Ordering o = new Ordering( 0,  prod_num,  amount,  payment, null, consumer, addr, false);

        service.addOrder(o);
        response.sendRedirect(request.getContextPath()+"/ordering/OrderCart");
    }
}
