<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/views/include/head-include.jsp" />
<body>
	<jsp:include page="/WEB-INF/views/include/shapka.jsp" />

	<div class="products">
		<div class="container">
			<h2>Products</h2>
			<div class="col-md-9">
				<div class="content-top1">
					<c:forEach items="${products}" var="product">
						<div class="col-md-4 col-md4">
							<div class="col-md1 simpleCart_shelfItem">
								<a href="${pageContext.request.contextPath}/product/${product.id}"> <img class="img-responsive" src="<c:url value="/resources/img/${product.image.path}"/>" alt="" />
								</a>
								<h3>
									<a href="${pageContext.request.contextPath}/product/${product.id}"><c:out value="${product.name}" /></a>
								</h3>
								<div class="price">
									<h5 class="item_price">
										$<c:out value="${product.price}" />
									</h5>
									<form action="${pageContext.request.contextPath}/order/${product.id}" method="get">
										<button type="submit" formmethod="post" formaction="${pageContext.request.contextPath}/order/${product.id}"><spring:message code="add_to_cart" /></button>
									</form>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>