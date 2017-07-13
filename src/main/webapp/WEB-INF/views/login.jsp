<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<body>
	<div>
		<spring:message code="shapka.login" />
	</div>
	<hr />
	<font color="#ff0000">${loginError}</font>
	<form name="form1" method="post" action="login">
		<table>
			<tr>
				<td><spring:message code="name"/></td>
				<td><input name="name" type="text" /></td>
			</tr>
			<tr>
				<td><spring:message code="password"/></td>
				<td><input name="password" type="password" /></td>
			</tr>
		</table>
		<br />
		<input class="enter" type="submit" value="<spring:message code='login'/>" />
	</form>
	<div class="but2">
		<a href="registration"><spring:message code="registration"/></a>
	</div>
</body>
</html>