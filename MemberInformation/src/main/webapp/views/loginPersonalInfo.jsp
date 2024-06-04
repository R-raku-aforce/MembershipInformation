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
		<h2>Membership Information Management</h2>
	</header>
	
	<form action="<%= request.getContextPath() %>/jp/co/aforce/SaveMemberInfo.action" method="post">
	
	<div class="content_top1">
		
		<div class="ID">
		  <label for="MEMBER_ID">Member ID：</label><input type="number" id="MEMBER_ID" name="MEMBER_ID">
		</div>
		
		<div class="name">
    		<p class="item">First Name：<input type="text" name="FIRST_NAME" required></p>
    		<p class="item">Last Name：<input type="text" name="LAST_NAME" required></p>    		
    	</div>
    	
    	<% String sex = (String) request.getAttribute("SEX"); %>
    	
    	<div class="sex">Gender：  
			<select name="SEX">
    			<option value="M" <% if ("M".equals(sex)) { %> selected <% } %>>Male</option>
    			<option value="F" <% if ("F".equals(sex)) { %> selected <% } %>>Female</option>
			</select>
    	</div>
    	
    	<div class="address">
    		<p>〒　　　<input type="number" name="Post_num" required></p>
    		<p>Address：<textarea name="Address" rows="3" cols="30" required></textarea></p>
    	</div>
    	
    	<div class="job">
    		<p>Voaction：<input type="text" name="JOB" required></p>
    	</div>
    	
    	<div class="phone">
    		<p>Tel：<input type="number" name="PHONE_NUMBER" required></p>
    	</div>
    	
    	<div class="email">
    		<p>Email：<input type="text" name="MAIL_ADDRESS" required></p>
    	</div>
    	
    	<p><input type="submit" value="登録"></p>  
    </div> 
    	
	</form>	
</body>
<%@include file="footer.html" %>
</html>