<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
		<tr><th>Student Id</TH></tr>
		<c:forEach var="stu" items="${student}"> 
			<tr>
				<td><c:out value="${stu.student_Id}"></c:out></td>
				<td><a href="studentupdate?code=${stu.student_Id}">VIEW DETAILS</a></td>
			</tr>
		</c:forEach>
	</table><br>

</body>
</html>