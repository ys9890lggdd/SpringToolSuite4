<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>사원 등록</title>
<script type="text/javascript">
//<![CDATA[
function SawonSubmit() {
	var f = document.sawonForm;
	if(f.sabun.value == "") {
		alert("사번을 입력해주세요.");
		return;
	}
	if(f.name.value == "") {
		alert("이름을 입력해주세요.");
		return;
	}
	f.submit();
}
//]]>
</script>
</head>
<body>
	<h1>사원 등록</h1>
	<c:url value="/sawon_regnextform.do" var="actionUrl" />
	<form:form id="sawonForm" name="sawonForm" modelAttribute="sawon" method="post" action="${actionUrl}">
	<table border="1">
	<tr>
		<th><label for="sabun">사번</label></th>
		<td><form:input path="sabun" /></td>
	</tr>
    <tr>
        <th><label for="name">이름</label></th>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <th><label for="phone">전화번호</label></th>
        <td><form:input path="phone" /></td>
    </tr>
    <tr>
        <th><label for="email">이메일</label></th>
        <td><form:input path="email" /></td>
    </tr>
	</table>
	</form:form>
	   <div>
    [<a href="<c:url value='/sawon_list.do' />">목록</a>]
    [<a href="#" onclick="SawonSubmit();">다음</a>]
    </div>
</body>
</html>
