<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
	<spring:message code="menu" />
	| user:
	<c:choose>
		<c:when test="${user.registered}">${user.name}</c:when>
		<c:otherwise>
			<spring:message code="anonymous" />
		</c:otherwise>
	</c:choose>
	| 
	<c:choose>
		<c:when test="${fn:length(order.orderLines) gt 0}">
			<a href="${pageContext.request.contextPath}/order/${order.id}">
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