package product.controller;

import product.Service;
import product.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProdGetByName", value = "/product/ProdGetByName")
public class ProdGetByName extends HttpServlet {
    //이름으로 검색한 결과를 request에 담아 /product/list.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path", "/product/search.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("val1");
        Service service = new Service();
        ArrayList<Product> p= service.getByName(name);
        request.setAttribute("products" , p);
        request.setAttribute("path", "/product/list.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }
}
