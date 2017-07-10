<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="include/head.jsp" />
<body>
	<jsp:include page="include/top.jsp" />
	<jsp:include page="include/menu.jsp" />

<div class="container">
	<c:forEach var="product" items="${products}" varStatus="loop">
		<c:if test="${(loop.count mod 4) == 0}">
			<div class="row">
		</c:if>
		<div class="col-sm-3">
      		<div class="panel panel-primary">
        		<div class="panel-heading"><c:out value='${product.name}'/></div>
        		<div class="panel-body"><img src="image/<c:out value='${product.imagePath}'/>" /></div>
        		<div class="panel-footer"><c:out value='${product.description}'/></div>
      		</div>
    	</div>
  		<c:if test="${(loop.count mod 4) == 0}">
			</div>
		</c:if>
	</c:forEach>
</div>

</body>
</html>