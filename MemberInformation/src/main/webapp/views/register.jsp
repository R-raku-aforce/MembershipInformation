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
	
	<form action="<%= request.getContextPath() %>/jp/co/aforce/Register.action" method="post">
		<div class="content_top">
    		<label for="member-id">ID(数字のみ)：<input type="text" id="member-id" name="MEMBER_ID" required></label>
    		<p>パスワード：<input type="password" name="PASSWORD"></p>
    		<p><input type="submit" value="登録"></p>   
    	</div>	
	</form>

</body>
<%@include file="footer.html" %>
</html>
