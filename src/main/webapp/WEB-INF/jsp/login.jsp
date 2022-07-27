<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authorization</title>
</head>
<body>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_logination" />
		Enter login:<br />
		<input type="text" name="login" value="" /><br />
		Enter password:<br />
		<input type="password" name="password" value="" /><br />
		<input type="submit" value="Sing In" /><br />
	</form>
</body>
</html>