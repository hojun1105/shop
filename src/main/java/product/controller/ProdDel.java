package product.controller;

import product.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProdDel", value = "/product/ProdDel")
public class ProdDel extends HttpServlet {
    //삭제 완료(번호 기준.) 내 등록 상품 목록으로 이동
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        Service service = new Service();
        service.delProduct(num);
        request.setAttribute("path" , "/product/ProdList");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    //삭제 완료(번호 기준)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
