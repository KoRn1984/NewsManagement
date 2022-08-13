<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="body-title">
	<a href="">News >> </a>News List
</div>
<form action="" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">			
				<div class="news-title">
				<strong>				
					<c:out value="${news.titleNews}" />
				</strong>			
				</div>							
				<div class="news-date">
					<c:out value="${news.dateNews}" />
				</div>
				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
						      <a href="">Edit</a> 
						</c:if>						
						<a href="controller?command=go_to_view_news&id=${news.idNews}">View</a>   					    
   					    <c:if test="${sessionScope.role eq 'admin'}">
   					         <input type="checkbox" name="idNews" value="${news.idNews}" />
   					    </c:if>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	<!-- <logic:notEmpty name="newsForm" property="newsList">
		<div class="delete-button-position">
			<html:submit>
				<bean:message key="locale.newslink.deletebutton" />
			</html:submit>
		</div>
	</logic:notEmpty> -->
	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        No news.
	    </c:if>
	</div>
</form>