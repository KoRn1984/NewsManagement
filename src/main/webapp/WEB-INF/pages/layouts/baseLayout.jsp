<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/validation.js"></script>
<title>News Management<!-- <bean:message key="locale.linkname.headertitle" /> --></title>
<link rel="stylesheet" type="text/css" href="styles/newsStyle.css">
</head>
<body>
	<div class="page">
	
		<div class="header">
			<c:import url="/WEB-INF/pages/tiles/header.jsp" />
		</div>
				
		<div class="base-layout-wrapper">
			<div class="menu">
				<c:if test="${not (sessionScope.user eq 'active')}">				
				    <center><h1>Welcome to the news portal!</h1></center>
					<%-- <c:import url=""></c:import> --%>
				</c:if>
				<c:if test="${sessionScope.user eq 'active'}">
					<c:import url="/WEB-INF/pages/tiles/menu.jsp" />
				</c:if>
			</div>
			
		    <div class="content">
				<c:if test="${not (sessionScope.user eq 'active')}">
				<c:if test="${not (sessionScope.registered_user eq 'registered')}">														
				     <c:import url="/WEB-INF/pages/tiles/guestInfo.jsp" />
				</c:if>							
				<c:if test="${(sessionScope.registered_user eq 'not_registered')}">
				     <c:import url="/WEB-INF/jsp/registration.jsp" />
				</c:if>
    			</c:if>	
				<c:if test="${sessionScope.user eq 'active'}">
					<c:import url="/WEB-INF/pages/tiles/body.jsp" />
				</c:if>					
	        </div>

		<div class="footer">
			<c:import url="/WEB-INF/pages/tiles/footer.jsp" />
		</div>
		
	</div>
</body>
</html>