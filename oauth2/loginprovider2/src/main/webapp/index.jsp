<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Sample OAtuh2 provider</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/style.css"/>" />
</head>
<body>

	<h1>OAuth2 sample provider home</h1>

	<div id="content">
		<h2>Home</h2>

		<p>Sample OAuth2 provider useful to test OAtuh2 pseudoauthentication.</p>

		<authz:authorize ifNotGranted="ROLE_USER">
			<h2>Login</h2>
			<form id="loginForm" name="loginForm" action="<c:url value="/login.do"/>" method="post">
				<p>
					<label>Username: <input type='text' name='j_username' value="marissa"></label>
				</p>
				<p>
					<label>Password: <input type='text' name='j_password' value="koala"></label>
				</p>

				<p>
					<input name="login" value="Login" type="submit">
				</p>
			</form>
		</authz:authorize>
		<authz:authorize ifAllGranted="ROLE_USER">
			<h2>You are authorized!</h2>
		</authz:authorize>
	</div>

	<%-- <div id="footer">Sample application for <a href="http://github.com/SpringSource/spring-security-oauth" target="_blank">Spring Security OAuth</a></div>--%>


</body>
</html>
