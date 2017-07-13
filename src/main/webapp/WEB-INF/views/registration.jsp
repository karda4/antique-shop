<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<body>
	<div>
		<spring:message code="registration" />
	</div>
	<hr />
	<font color="#ff0000">${registrationError}</font>	
	<form:form name="form2" method="post" action="registration" commandName="userForm">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><font color="#ff0000">*</font>
				<spring:message code="name" /></td>
				<td><form:input path="name" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="name"/></td>
			</tr>
			<tr>
				<td><font color="#ff0000">*</font>
				<spring:message code="password" /></td>
				<td><form:input path="password" type="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:errors path="password"/></td>
			</tr>
		</table>
		<div align="left">
			<font color="#ff0000"><spring:message code="reg_necessarily" /></font>
		</div>
		<br />
		<input class="enter" type="submit" name="Submit" value="<spring:message code='registration'/>" />
	</form:form>
</body>
</html>