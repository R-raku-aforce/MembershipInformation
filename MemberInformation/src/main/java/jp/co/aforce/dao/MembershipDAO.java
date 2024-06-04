package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jp.co.aforce.bean.MemberShip;

public class MembershipDAO extends DAO{

	public MemberShip search(int MEMBER_ID, String PASSWORD) throws Exception {
	    MemberShip membership = null;
	    Connection con = getConnection();
	    PreparedStatement st;

	    // 打印查询语句和参数
	    System.out.println("Executing query: SELECT * FROM login WHERE MEMBER_ID = " + MEMBER_ID + " AND PASSWORD = " + PASSWORD);

	    // 创建 SQL 查询语句，使用 ? 占位符表示参数
	    st = con.prepareStatement("SELECT * FROM login WHERE MEMBER_ID = ? AND PASSWORD = ?");
	    st.setInt(1, MEMBER_ID);  // 设置查询语句中的参数，第一个 ? 用 MEMBER_ID 替换
	    st.setString(2, PASSWORD); // 第二个 ? 用 PASSWORD 替换

	    // 执行查询
	    ResultSet rs = st.executeQuery();

	    // 遍历结果集
	    if (rs.next()) { // 使用 if 而不是 while，确保只获取一个结果
	        membership = new MemberShip(MEMBER_ID, PASSWORD);
	        membership.setMEMBER_ID(rs.getInt("MEMBER_ID"));
	        membership.setPASSWORD(rs.getString("PASSWORD"));
	    }

	    // 关闭 PreparedStatement 和数据库连接
	    rs.close();
	    st.close();
	    con.close();

	    return membership;
	}

		
		 public void addMemberShip(int memberId, String password) throws Exception {
			 
			  // 获取数据库连接
			 	Connection con = null;
		        PreparedStatement st = null;
		        try {
		        	con = getConnection();
		            // 编写 SQL 插入语句   // 编写 SQL 插入语句，使用 ? 占位符表示参数
		            String sql = "INSERT INTO login (MEMBER_ID, PASSWORD) VALUES (?, ?)";
		            st = con.prepareStatement(sql);
		            // 设置参数
		            st.setInt(1, memberId);
		            st.setString(2, password);
		            // 执行插入操作
		            st.executeUpdate();
		        } finally {
		            // 关闭资源
		            if (st != null) {
		                st.close();
		            }
		            if (con != null) {
		                con.close();
		            }
		        }
		    }
		 
		 public boolean isAddressEmpty(int MEMBER_ID) throws Exception {
		        boolean isEmpty = false;
		        
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;

		        try {
		            // 获取数据库连接
		            con = getConnection();

		            // 创建 SQL 查询语句
		            String sql = "SELECT Address FROM membership WHERE MEMBER_ID = ?";
		            ps = con.prepareStatement(sql);
		            ps.setInt(1, MEMBER_ID);

		            // 执行查询
		            rs = ps.executeQuery();

		            // 检查是否有结果
		            if (rs.next()) {
		                // 获取客户的地址
		                String address = rs.getString("Address");

		                // 检查地址是否为空
		                isEmpty = (address == null || address.isEmpty());
		            }
		        } finally {
		            // 关闭资源
		            if (rs != null) {
		                rs.close();
		            }
		            if (ps != null) {
		                ps.close();
		            }
		            if (con != null) {
		                con.close();
		            }
		        }

		        return isEmpty;
		    }
		 
		   // 将新用户填写的信息存储到 SQL 表格中
//		 public void saveMemberInfo(String firstName, String lastName, String sex, long phoneNumber, int postNum, String address, String job, String emailAddress) throws SQLException, ServletException {
//			    DAO dao = new DAO();
//			    try (Connection connection = dao.getConnection()) {
//			        String sql = "INSERT INTO membership (FIRST_NAME, LAST_NAME, SEX, PHONE_NUMBER, Post_num, Address, JOB, MAIL_ADDRESS) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
//			            statement.setString(1, firstName);
//			            statement.setString(2, lastName);
//			            statement.setString(3, sex);
//			         
//			            statement.setLong(4, postNum);
//			            statement.setInt(5, postNum);
//			            statement.setString(6, address);
//			            statement.setString(7, job);
//			            statement.setString(8, emailAddress);
//
//			            statement.executeUpdate();
//			        }
//			    } catch (Exception e) {
//			        throw new ServletException(e);
//			    }
//			}

		 public void saveMemberInfo(String firstName, String lastName, String sex, long phoneNumber, int postNum, String address, String job, String emailAddress, int memberId) throws SQLException, ServletException {
			    DAO dao = new DAO();
			    try (Connection connection = dao.getConnection()) {
			        String sql = "INSERT INTO membership (MEMBER_ID, FIRST_NAME, LAST_NAME, SEX, PHONE_NUMBER, Post_num, Address, JOB, MAIL_ADDRESS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setInt(1, memberId);
			            statement.setString(2, firstName);
			            statement.setString(3, lastName);
			            statement.setString(4, sex);
			            statement.setLong(5, phoneNumber);
			            statement.setInt(6, postNum);
			            statement.setString(7, address);
			            statement.setString(8, job);
			            statement.setString(9, emailAddress);

			            statement.executeUpdate();
			        }
			    } catch (Exception e) {
			        throw new ServletException(e);
			    }
			}

}
