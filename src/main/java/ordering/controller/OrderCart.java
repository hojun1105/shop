package ordering.controller;

import ordering.Ordering;
import ordering.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderCart", value = "/ordering/OrderCart")
public class OrderCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();

        Service  service= new Service();
        String id = (String)session.getAttribute("id");
        ArrayList<Ordering> lista=service.getByPay(false, id);
        request.setAttribute("lista", lista);
        request.setAttribute("path", "/ordering/cart.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        int num = Integer.parseInt(request.getParameter("num"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        int payment = Integer.parseInt(request.getParameter("payment"));
        String addr = request.getParameter("addr");
        Ordering o = new Ordering(num,0,amount,payment,null,null,addr,false);
        service.editOrder(o);
        request.setAttribute("path", "/ordering/cart.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request, response);
    }
}
