package product.controller;

import product.Product;
import product.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductGetByPrice", value = "/product/ProdGetByPrice")
public class ProductGetByPrice extends HttpServlet {

    //가격으로 검색한 결과를 request에 담아 /product/list.jsp로
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int price1 = Integer.parseInt(request.getParameter("val1"));
        int price2 = Integer.parseInt(request.getParameter("val2"));
        Service service = new Service();
        ArrayList<Product> p= service.getByPrice(price1, price2);
        request.setAttribute("products" , p);
        request.setAttribute("path", "/product/list.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
