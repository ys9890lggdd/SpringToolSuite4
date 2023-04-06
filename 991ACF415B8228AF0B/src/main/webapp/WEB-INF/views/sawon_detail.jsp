<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>사원 상세보기</title>
<script type="text/javascript">
//<![CDATA[
function SawonDelete() {
    var f = document.delForm;
    if(!confirm("삭제하시겠습니까?")) return;
    f.submit();
}
//]]>
</script>
</head>
<body>
	<h1>사원 상세보기</h1>
	<table border="1">
	<tr>
		<th>사번</th>
		<td><c:out value="${sawonDetail.sabun}" /></td>
	</tr>
    <tr>
        <th>이름</th>
        <td><c:out value="${sawonDetail.name}" /></td>
    </tr>
    <tr>
        <th>전화번호</th>
        <td><c:out value="${sawonDetail.phone}" /></td>
    </tr>
    <tr>
        <th>이메일</th>
        <td><c:out value="${sawonDetail.email}" /></td>
    </tr>
    <tr>
        <th>포상이력</th>
        <td>
            <table border="1">
              <tr>
                  <th>포상 명칭</th>
                  <th>수여 기관</th>
              </tr>
              <c:forEach  var="prize" items="${sawonDetail.prizes}">
              <tr>
                <td><c:out value="${prize.prizeName}" /></td>
                <td><c:out value="${prize.prizeOrg}" /></td>
              </tr>
              </c:forEach>
            </table>
        </td>
    </tr>
	</table>
	<div>
	[<a href="<c:url value='/sawon_list.do' />">목록</a>]
	[<a href="<c:url value='/sawon_updateform.do' />">수정</a>]
	[<a href="#" onclick="SawonDelete();">삭제</a>]
	</div>
	<form id="delForm" name="delForm" action="<c:url value='/sawon_delete.do' />" method="post"></form>
</body>
</html>
