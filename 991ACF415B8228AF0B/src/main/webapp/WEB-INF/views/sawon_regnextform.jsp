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
function PrevSubmit() {
	var f = document.sawonForm;
	f.action = "<c:url value='/sawon_regform.do' />";
	f.submit();
}
function SawonSubmit() {
	var f = document.sawonForm;
	f.action = "<c:url value='/sawon_register.do' />";
	f.submit();
}
//]]>
</script>
</head>
<body>
	<h1>사원 등록</h1>
	<c:url value="/sawon_register.do" var="actionUrl" />
	<form:form id="sawonForm" name="sawonForm" modelAttribute="sawon" method="post" action="${actionUrl}">
	<table border="1">
	<tr>
		<th>포상 이력</th>
		<td>
		    <table border="1">
		      <tr>
		        <th>상 이름</th>
		        <th>수여기관</th>
		      </tr>
		      <tr>
		        <td><form:input path="prizes[0].prizeName" /></td>
		        <td><form:input path="prizes[0].prizeOrg" /></td>
		      </tr>
              <tr>
                <td><form:input path="prizes[1].prizeName" /></td>
                <td><form:input path="prizes[1].prizeOrg" /></td>
              </tr>
              <tr>
                <td><form:input path="prizes[2].prizeName" /></td>
                <td><form:input path="prizes[2].prizeOrg" /></td>
              </tr>
		    </table>
		</td>
	</tr>
	</table>
	</form:form>
	<div>
    [<a href="<c:url value='/sawon_list.do' />">목록</a>]
    [<a href="#" onclick="PrevSubmit();">이전</a>]
    [<a href="#" onclick="SawonSubmit();">등록</a>]
    </div>
</body>
</html>
