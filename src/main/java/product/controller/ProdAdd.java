package product.controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import product.Product;
import product.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ProdAdd", value = "/product/ProdAdd")
public class ProdAdd extends HttpServlet {
    //상품등록 페이지 /product/addForm.jsp이동
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path", "/product/addForm.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    //등록완료. 내 상품 목록으로 이동
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service =new Service();
        String path="/Users/jeonghojun/IdeaProjects/shop/src/main/webapp/imgs";
        MultipartRequest req = new MultipartRequest(request,path,100*1024*1024,"utf-8",new DefaultFileRenamePolicy());

        File im1 = req.getFile("img1");
        File im2 = req.getFile("img2");
        File im3 = req.getFile("img3");
        String img1 = "/imgs/"+im1.getName();
        String img2 = "/imgs/"+im2.getName();
        String img3 = "/imgs/"+im3.getName();

        String name = req.getParameter("name");
        String info = req.getParameter("info");
        int price = Integer.parseInt(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String seller = req.getParameter("seller");


        Product p = new Product(0,name,info,price,amount,seller,img1,img2,img3);
        service.addProduct(p);
        response.sendRedirect(request.getContextPath()+"/product/ProdList");

    }
}
