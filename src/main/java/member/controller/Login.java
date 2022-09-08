package member.controller;

import member.Member;
import member.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/member/Login")
public class Login extends HttpServlet {

    //로그인 폼 실행
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("path","/member/loginForm.jsp");
        RequestDispatcher dis = request.getRequestDispatcher("/MainIndex.jsp");
        dis.forward(request,response);
    }

    //로그인 처리, 실패하면 로그인 폼, 성공하면 구매자(전체 상품 목록),판매자(자신이 등록한 상품 목록)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        Service service = new Service();
        String path = "/shop/member/loginForm.jsp";
        String msg="";

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        Member m = service.getMember(id);

        if(m == null) {
            request.setAttribute("msg","없는 아이디" );
        }else{
            if(pwd.equals(m.getPwd())) {
                session.setAttribute("id", id);
                session.setAttribute("mem_type",m.isMem_type());
                path="/shop/MainIndex.jsp";

            }else{
                request.setAttribute("msg", "패스워드 불일치");
            }
        }

        response.sendRedirect(path);
    }
}
