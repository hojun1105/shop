package product.controller;

import product.Product;
import product.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductGetBySeller", value = "/product/ProdGetBySeller")
public class ProductGetBySeller extends HttpServlet {

    //seller로 검색한 결과를 리스트 출력. /product/list.jsp 로 이동하여 img1, name, price, seller 출력
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String seller = request.getParameter("val1");
        Service service = new Service();
        ArrayList<Product> p= service.getBySeller(seller);
        request.setAttribute("products" , p);
        request.setAttribute("path", "/product/list.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}