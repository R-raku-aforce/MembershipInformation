package jp.co.aforce;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.MembershipDAO;

@WebServlet("/jp/co/aforce/Register.action")
public class RegisterAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            execute(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        
        // 从表单获取用户输入的信息
        int memberId = Integer.parseInt(request.getParameter("MEMBER_ID"));
        String password = request.getParameter("PASSWORD");
        
        // 创建 DAO 实例
        MembershipDAO dao = new MembershipDAO();
        
        try {
            // 将用户信息插入到登录表格中
            dao.addMemberShip(memberId, password);
            
            // 重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/views/loginPersonalInfo.jsp");
        } catch (Exception e) {
            // 处理异常情况
            e.printStackTrace();
            session.setAttribute("errorMessage", e.getMessage());
            // 返回错误页面或其他适当的响应
            response.sendRedirect(request.getContextPath() + "/views/error.jsp");
        }
    }
}


