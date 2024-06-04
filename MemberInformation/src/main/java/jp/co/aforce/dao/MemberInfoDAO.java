package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jp.co.aforce.bean.MemberInfo;

public class MemberInfoDAO extends DAO {
    public void saveMemberInfo(MemberInfo memberInfo) throws ServletException {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO membership (MEMBER_ID, LOGIN_ID, FIRST_NAME, LAST_NAME, SEX, Post_num, Address, JOB, PHONE_NUMBER, MAIL_ADDRESS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, memberInfo.getMEMBER_ID());
                statement.setString(3, memberInfo.getFIRST_NAME());
                statement.setString(4, memberInfo.getLAST_NAME());
                statement.setString(5, memberInfo.getSEX());
                statement.setInt(6, memberInfo.getPost_num());
                statement.setString(7, memberInfo.getAddress());
                statement.setString(8, memberInfo.getJOB());
                statement.setLong(9, memberInfo.getPHONE_NUMBER());
                statement.setString(10, memberInfo.getMAIL_ADDRESS());

                statement.executeUpdate();
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
