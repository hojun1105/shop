package ordering.controller;

import ordering.Ordering;
import ordering.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "OrderList", value = "/ordering/OrderList")
public class OrderList extends HttpServlet {
    @Override
    //request.getParameter("ispay")=>true : 결제한 상품목록 출력, =>false:결제한 상품목록(장바구니)
    //로그인한 구매자의 주문 목록 출력. 주문번호(클릭 주문 상세페이지),상품명(클릭 상품상세페이지),수량,결제금액
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session= request.getSession();
        String id = (String)session.getAttribute("id");

        Service service = new Service();
        String path="/ordering/list.jsp";
        ArrayList<Ordering> list = null;

        boolean ispay=Boolean.parseBoolean(request.getParameter("ispay"));

        list=service.getByPay(ispay, id);
        request.setAttribute("list", list);
        if(!ispay){
            path="/ordering/cart.jsp";
        }
        RequestDispatcher dis = request.getRequestDispatcher(path);
        dis.forward(request,response);
    }


    @Override
    //
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
