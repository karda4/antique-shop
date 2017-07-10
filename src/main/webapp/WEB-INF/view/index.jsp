<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="include/head.jsp" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css"/>"/>
<body>
	<table width=1000>
		<tr>
			<td colspan=5><img src="<c:url value="/resources/images/antiqueshop_main_page_01.gif"/>" width=1000 height=241 alt=""/></td>
		</tr>
		<tr>
			<td rowspan=3><img src="<c:url value="/resources/images/antiqueshop_main_page_02.gif"/>" width=397 height=519 alt=""></td>
			<td><a href="./shop"><img src="<c:url value="/resources/images/shop_btn.gif"/>" width=87 height=54 alt=""></a></td>
			<td><img src="<c:url value="/resources/images/antiqueshop_main_page_04.gif"/>" width=35 height=54 alt=""></td>
			<td><a href="./about"><img src="<c:url value="/resources/images/about_btn.gif"/>" width=89 height=54 alt=""></a></td>
			<td rowspan=3><img src="<c:url value="/resources/images/antiqueshop_main_page_06.gif"/>" width=392 height=519 alt=""></td>
		</tr>
		<tr>
			<td colspan=3><a href="./estimation"><img src="<c:url value="/resources/images/estimate_btn.gif"/>" width=211 height=270 alt=""></a></td>
		</tr>
		<tr>
			<td colspan=3><img src="<c:url value="/resources/images/antiqueshop_main_page_08.gif"/>" width=211 height=195 alt=""></td>
		</tr>
	</table>
</body>
</html>