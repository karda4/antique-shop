<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<body>
	<jsp:include page="/WEB-INF/views/include/shapka.jsp" />

	<div class="shopping-cart">
		<!-- Title -->
		<div class="title">
			<spring:message code="cart" />
		</div>
		<table>
			<c:forEach items="${order.orderLines}" var="orderLine">
				<tr>
					<td><img class="img-responsive" width="50px" height="50px" src="<c:url value="/resources/img/${orderLine.product.image.path}"/>" alt="" /></td>
					<td>
						<div>${orderLine.product.name}</div>
						<div>
							<font color="gray">${orderLine.product.category.name}</font>
						</div>
					</td>
					<td>
						<div class="total-price">$${orderLine.product.price}</div>
					</td>
					<td><a href="${pageContext.request.contextPath}/order/${orderLine.id}/delete"><spring:message code="delete" /></a></td>
				</tr>
			</c:forEach>
			<c:if test="${fn:length(order.orderLines) gt 0}">
				<tr>
					<td></td>
					<td><spring:message code="total" /></td>
					<td>$${order.totalPrice}</td>
					<td><a href="${pageContext.request.contextPath}/order/buy"><spring:message code="buy" /></a></td>
				</tr>
			</c:if>
		</table>

	</div>
</body>
</html>