<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="header.html" %>

<%@taglib prefix="c" uri="jakarta.tags.core" %>
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
		<h2>Membership Information Management</h2>
	</header>
	
	<div class="content_top1">	
		<div class="inscribe">
			<h3>Entry Item：</h3>
			<p>First Name： ${FIRST_NAME }</p>
			<p>Last Name： ${LAST_NAME }</p>
			<p>Gender： ${SEX }</p>
			<p>〒　：${Post_num }</p>
			<p>Address： ${Address }</p>
			<p>Voaction： ${JOB }</p>
			<p>Tel： ${PHONE_NUMBER }</p>
			<p>Email： ${MAIL_ADDRESS }</p>
		</div>
						
		<div class="thanks">
			<h2>Thank you for your assistance.</h2>
		</div>		
	</div>		
</body>

<%@include file="footer.html" %>