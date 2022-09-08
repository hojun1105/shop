package ordering.controller;

import ordering.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderPay", value = "/ordering/OrderPay")
public class OrderPay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        int num = Integer.parseInt(request.getParameter("num"));
        service.editPay(num);

        request.setAttribute("path", "/ordering/OrderList?ispay=true");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
