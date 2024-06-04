<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="header.html" %>

<head>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jacquard+12&family=Jersey+10+Charted&family=Jersey+20&family=Jersey+25+Charted&family=Josefin+Sans:wght@366&family=Josefin+Slab:ital,wght@0,100..700;1,100..700&family=Pacifico&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Jersey+10+Charted&family=Jersey+20&family=Jersey+25+Charted&family=Josefin+Sans:wght@366&family=Josefin+Slab:ital,wght@0,100..700;1,100..700&family=Pacifico&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<script type="text/javascript">
        var contextPath = '<%= request.getContextPath() %>';
    </script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/script.js"></script>

</head>

<body>
	<header>
		<h2>Membership Information Management</h2>
	</header>
	
	<div class="content_top">	
<%
jp.co.aforce.bean.MemberShip membership = (jp.co.aforce.bean.MemberShip) session.getAttribute("membership");


if(membership != null) {
%>
    <p>ログイン成功！</p>
    <p>ようこそ、<%= membership.getMEMBER_ID() %> さん。</p>
    
    <!-- 在 3 秒后重定向到 menu.jsp -->

<%
} else {
%>
    <p>ログインしていません。</p>
<%
}
%>
	<a href="<%= request.getContextPath() %>/jp/co/aforce/Logout.action">ログアウト</a>
</body>

<%@include file="footer.html" %>



