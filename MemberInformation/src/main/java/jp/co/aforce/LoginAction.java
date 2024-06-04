package jp.co.aforce;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.MemberShip;
import jp.co.aforce.dao.MembershipDAO;

@WebServlet("/jp/co/aforce/Login.action")
public class LoginAction extends HttpServlet {
	
	@Override
    protected void doPost(
    	HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
    	
        try {
            execute(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void execute(
    	HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
    	
        HttpSession session = request.getSession();
        
        int MEMBER_ID = Integer.parseInt(request.getParameter("MEMBER_ID"));
        String PASSWORD = request.getParameter("PASSWORD");

        // 处理登录操作
        String url = login(MEMBER_ID, PASSWORD, session);

        // 请求转发到相应的 JSP 页面
        request.getRequestDispatcher(url).forward(request, response);
    }

    // 处理登录操作的方法
    private String login(
    	int MEMBER_ID, String PASSWORD, HttpSession session
    ) throws Exception {
    	
    	MembershipDAO dao = new MembershipDAO();
    	MemberShip membership = dao.search(MEMBER_ID, PASSWORD);
        
        if (membership != null) {
            session.setAttribute("membership", membership );
            
            boolean isAddressEmpty = dao.isAddressEmpty(MEMBER_ID);

            if (isAddressEmpty) {
                // 如果地址为空，重定向到登录个人信息的网页
                return "/views/loginPersonalInfo.jsp";
            } else {
                // 如果地址不为空，重定向到登录成功的网页
                return "/views/loginout.jsp";
            }
            //return "/views/loginout.jsp"; // 登录成功，转到成功页面
        } else {
            // 登录失败，设置错误消息
            session.setAttribute("error", "IDもしくはパスワードが違います");
            return "/views/login.jsp"; // 登录失败，转到失败页面
        }
    }
}
