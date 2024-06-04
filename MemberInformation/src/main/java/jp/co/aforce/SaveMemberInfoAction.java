package jp.co.aforce;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.MembershipDAO;

@WebServlet("/jp/co/aforce/SaveMemberInfo.action")
public class SaveMemberInfoAction extends HttpServlet {

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
        
        // 获取表单参数
        String firstName = request.getParameter("FIRST_NAME");
        String lastName = request.getParameter("LAST_NAME");
        String sex = request.getParameter("SEX");
        String postNumString = request.getParameter("Post_num");
        int postNum = 0; // 默认值
        if (postNumString != null && !postNumString.isEmpty()) {
            try {
                postNum = Integer.parseInt(postNumString);
            } catch (NumberFormatException e) {
                // 如果解析失败，设置错误消息并重定向到失败页面
                session.setAttribute("errorMessage", "郵便番号の形式が正しくありません。");
                response.sendRedirect(request.getContextPath() + "/views/failure.jsp");
                return;
            }
        }
        String address = request.getParameter("Address");
        String job = request.getParameter("JOB");
        long phoneNumber = 0; // 默认值
        String phoneNumberString = request.getParameter("PHONE_NUMBER");
        if (phoneNumberString != null && !phoneNumberString.isEmpty()) {
            try {
                phoneNumber = Long.parseLong(phoneNumberString);
            } catch (NumberFormatException e) {
                // 如果解析失败，设置错误消息并重定向到失败页面
                session.setAttribute("errorMessage", "电话号码的格式不正确。");
                response.sendRedirect(request.getContextPath() + "/views/failure.jsp");
                return;
            }
        }
        String emailAddress = request.getParameter("MAIL_ADDRESS");
        int memberId = 0; // 默认值
        String memberIdString = request.getParameter("MEMBER_ID");
        if (memberIdString != null && !memberIdString.isEmpty()) {
            memberId = Integer.parseInt(memberIdString);
        }

        // 打印日志
        System.out.println("Received form parameters:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Sex: " + sex);
        System.out.println("Post Number: " + postNum);
        System.out.println("Address: " + address);
        System.out.println("Job: " + job);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("MEMBER_ID: " + memberId);
        
        request.setAttribute("FIRST_NAME", firstName);
        request.setAttribute("LAST_NAME", lastName);
        request.setAttribute("SEX", sex);
        request.setAttribute("Post_num", postNum);
        request.setAttribute("Address", address);
        request.setAttribute("JOB", job);
        request.setAttribute("PHONE_NUMBER", phoneNumber);
        request.setAttribute("MAIL_ADDRESS", emailAddress);

        // 将新用户填写的信息存储到 SQL 表格中
        MembershipDAO dao = new MembershipDAO();
        try {
            dao.saveMemberInfo(firstName, lastName, sex, phoneNumber, postNum, address, job, emailAddress, memberId);

            // 重定向到会员登录页面
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMessage", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/views/failure.jsp");
        }
    }
}


