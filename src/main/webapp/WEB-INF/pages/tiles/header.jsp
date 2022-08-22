<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="wrapper">
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
	<fmt:message bundle="${loc}" key="local.loctitle.name.newsManagement" var="news_management" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.signIn" var="sign_in" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.signOut" var="sign_out" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.enterLogin" var="enter_login" />
	<fmt:message bundle="${loc}" key="local.locbutton.name.enterPassword" var="enter_password" />
	<fmt:message bundle="${loc}" key="local.loclclink.name.registration" var="registration" />
	<div class="newstitle">News management</div>
	<div class="local-link">	
		<div align="right">	    
			<a href="${sessionScope.url}&local=en">${en_button}</a>&nbsp;&nbsp;
			<a href="${sessionScope.url}&local=ru">${ru_button}</a><br /><br />
		</div>		
		<c:if test="${not (sessionScope.user_status eq 'active')}">
			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" />
					${enter_login}:<input type="text" name="login" value="" required pattern="^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$"/><br />
					${enter_password}:<input type="password" name="password" value="" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\w\s]).{6,}"/><br />
					<c:if test="${not (param.AuthenticationError eq null)}">					
						<font color="red">
						   <c:out value="${param.AuthenticationError}" />
						</font> 
					</c:if>
					<input type="hidden" name="command" value="do_registration" />
					<a href="controller?command=go_to_registration_page">Registration</a>
					<input type="submit" value="Sign In" /><br />
				</form>
			</div>
		</c:if>			
		<c:if test="${sessionScope.user_status eq 'active'}">
			<div align="right">
			<center><font color="blue">${user.userName}</font>&nbsp;&nbsp;<font color="blue">${user.userSurname}</font></center>
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" />
					<input type="submit" value="Sign Out" /><br />
				</form>
			</div>
		</c:if>		
	</div>
</div>
</body>
</html>