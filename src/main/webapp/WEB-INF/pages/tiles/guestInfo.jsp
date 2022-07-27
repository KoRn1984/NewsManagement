<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guest Info</title>
</head>
<body>
<div class="body-title">
	<a href="">News >></a> Latest News
</div>
<form action="command.do?method=delete" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>
				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
        No news.
	    </c:if>
	</div>
</form>
</body>
</html>