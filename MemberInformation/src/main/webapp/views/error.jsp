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
</head>

<body>
	<header>
		<h2>Error</h2>
	</header>
	
	<div class="content">	
		失敗しました、もう一度やり直してください。
 		<p>An error occurred: <%= request.getAttribute("errorMessage") %></p>
	</div>
</body>	

<%@include file="footer.html" %>