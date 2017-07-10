<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="include/head.jsp" />
<body>
	<jsp:include page="include/top.jsp" />
	<jsp:include page="include/menu.jsp" />

	<c:forEach var="category" items="${estimateCategories}" varStatus="loopCategory">
		<a href="#">
			<c:out value='${category.name}' />
		</a>
		<div class="container">
			<div class="row">
				<c:forEach var="product" items="${category.estimateProducts}" varStatus="loopProduct">
					<div class="col-sm-2">
    					<div class="thumbnail">
    						<a href="#">
    							<img src="image/<c:out value='${product.imagePath}' />" style="width:100%" />
    							<div class="caption">
    								<p><c:out value='${product.name}' /></p>
    							</div>
    						</a>
    					</div>
    				</div>
				</c:forEach>
			</div>
		</div>
	</c:forEach>

</body>
</html>