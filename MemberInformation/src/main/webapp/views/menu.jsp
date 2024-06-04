<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Page</title>
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
    	<h2>Menu</h2>    	
    </header>
    
    <!-- 其他菜单内容 -->
    <div class="content">	
    <p>ようこそ</p>
    <!-- 返回按钮 -->
    <form action="<%= request.getContextPath() %>/views/loginout.jsp" method="get">
        <button type="submit">戻る</button>
    </form>
    </div>
</body>
</html>
