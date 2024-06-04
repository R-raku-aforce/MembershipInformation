<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="header.html" %>
<html>
<head>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jacquard+12&family=Jersey+10+Charted&family=Jersey+20&family=Jersey+25+Charted&family=Josefin+Sans:wght@366&family=Josefin+Slab:ital,wght@0,100..700;1,100..700&family=Pacifico&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jersey+10+Charted&family=Jersey+20&family=Jersey+25+Charted&family=Josefin+Sans:wght@366&family=Josefin+Slab:ital,wght@0,100..700;1,100..700&family=Pacifico&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
	<header>
		<h2>Member Registration</h2>
	</header>
	
	<form action="<%= request.getContextPath() %>/jp/co/aforce/Login.action" method="post">
	<div class="content_top">
    	<p>ID　　　　：<input type="number" name="MEMBER_ID" value="<%= (request.getParameter("MEMBER_ID") != null) ? request.getParameter("MEMBER_ID") : "" %>"></p>
    	<p>パスワード：<input type="password" name="PASSWORD"></p>
    	<p><input type="submit" value="ログイン"></p>
    <!-- 显示错误消息 -->
    <% 
        // 检查是否有错误消息
        String error = (String) request.getSession().getAttribute("error");
        if (error != null && !error.isEmpty()) {
    %>
        <p style="color: red;"><%= error %></p>
    <% } %>
		<div class="quiz">
    		<a href="<%= request.getContextPath() %>/views/register.jsp">会員登録が済んでいない人はこちら</a>
		</div>
	</div>
</form>	

<%@include file="footer.html" %>