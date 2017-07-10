<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<spring:message code="menu" />
	| user: 
	<c:choose>
		<c:when test="${user.registered}">${user.name}</c:when>
		<c:otherwise><spring:message code="anonymous"/></c:otherwise>
	</c:choose>
</div>
<hr />