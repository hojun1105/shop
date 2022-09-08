package product.controller;

import product.Product;
import product.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProdList", value = "/product/ProdList")
public class ProdList extends HttpServlet {

    //전체 상품검색해서 list.jsp로 이동
    //name에 링크. 클릭하면 상세 페이지로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Service service = new Service();
        ArrayList<Product> products = service.selectAll();

        request.setAttribute("products", products);
        request.setAttribute("path", "/product/list.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    //
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
