package ordering.controller;

import ordering.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderDel", value = "/ordering/OrderDel")
public class OrderDel extends HttpServlet {
    @Override
    //장바구니 목록에서 항목 선택 뒤 삭제버튼 누르면, 요청발생. 주문 번호로 삭제한 뒤 장바구니로 이동
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        int num = Integer.parseInt(request.getParameter("num"));
        service.delOrder(num);

        RequestDispatcher dis = request.getRequestDispatcher("/ordering/OrderCart");
        dis.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
