package product.controller;

import product.Product;
import product.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProdDetail", value = "/product/ProdDetail")
public class ProdDetail extends HttpServlet {

    //상품번호로 검색을 해서 상품 객체를 request에 담아 /product/detail.jsp로 이동 전체 데이터 출력.
    //prod/detail.jsp은 수정품 역할도 하므로 (상품이름, 설명, 가격, 수량)변경할 수 있도록 텍스트박스에 출력.수정
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int num = Integer.parseInt(request.getParameter("num"));
        Service service = new Service();
        Product p = service.getByNum(num);

        boolean mem_type = (boolean)session.getAttribute("mem_type");
        request.setAttribute("p", p );
        String path = "/product/detail.jsp";
        if (!mem_type){
            path="/ordering/addForm.jsp";
        }
        request.setAttribute("path", path);
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request, response);
    }

    //Product.detail.jsp 수정 버튼 클릭 처리. 수정 완료.
    //내 등록 상품 목록으로 이동
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Service service = new Service();
        int num = Integer.parseInt(request.getParameter("num"));
        String name= request.getParameter("name");
        String info = request.getParameter("info");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Product p = new Product(num,name,info,price,amount,null,null,null,null);
        service.editProduct(p);
        response.sendRedirect(request.getContextPath()+"/product/ProdList");
    }
}