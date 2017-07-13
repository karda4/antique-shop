<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
	<c:choose>
		<c:when test="${user.registered}">
			${user.name} <a href="${pageContext.request.contextPath}/logout"><spring:message code="logout"/></a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/login"><spring:message code="shapka.login"/></a>
		</c:otherwise>
	</c:choose>
	| 
	<c:choose>
		<c:when test="${fn:length(order.orderLines) gt 0}">
			<a href="${pageContext.request.contextPath}/cart">
				<spring:message code="cart" />:
				+${fn:length(order.orderLines)}
			</a>
		</c:when>	
		<c:otherwise>
			<spring:message code="cart" />: 0
		</c:otherwise>
	</c:choose>
</div>
<hr />