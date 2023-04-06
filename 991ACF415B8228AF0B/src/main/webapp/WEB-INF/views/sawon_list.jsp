<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>사원 목록</title>
</head>
<body>
	<h1>사원 목록</h1>
	<table border="1">
	<thead>
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>이메일</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${list}">
		<tr>
			<td><a href="<c:url value='/sawon_detail.do?sabun=${item.sabun}' />"><c:out value="${item.sabun}" /></a></td>
			<td><a href="<c:url value='/sawon_detail.do?sabun=${item.sabun}' />"><c:out value="${item.name}" /></a></td>
			<td><c:out value="${item.phone}" /></td>
			<td><c:out value="${item.email}" /></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<div>
	  <!-- [<a href="#" onclick="document.regForm.submit();">입력</a>] -->
	  [<a href="<c:url value='/sawon_regform.do' />">입력</a>]
	</div>
	<form name="regForm" method="post" action="<c:url value='/sawon_regform.do' />"></form>
</body>
</html>
