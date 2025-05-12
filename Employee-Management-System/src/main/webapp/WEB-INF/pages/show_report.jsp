<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
			crossorigin="anonymous">

<c:choose>
 <c:when test="${!empty empInfo}">
 
 	<dev class="container">
 	
 		<table bgcolor="cyan" boarder="1" align="center"    class="table-sm table-bordered border-primary  " >
 		
 			<tr bgcolor="yellow" >
 				<th>EMPNO</th><th>ENAME</th><th>JOB</th><th>SALARY</th><th>OPERATIONS</th>
 			</tr>
 			<c:forEach var="emp"  items="${empInfo }">
 			<tr bgcolor="pink">
 				<td>${emp.empno}</td>
 				<td>${emp.ename}</td>
 				<td>${emp.job}</td>
 				<td>${emp.sal}</td>
 				<td><a href="edit?no=${emp.empno}"><img src="images/edit.png" width="30" height="30"></a>
 						<a href="delete?no=${emp.empno}"><img src="images/delete.png" width="30" height="30" onclick="return confirm('are you sure to delete the records?')"></a>
 				</td>
 			</tr>
 			</c:forEach>
 		</table>
</c:when>

<c:otherwise>

	<h1 style="color:red;text-align:center">Records Not Found</h1>

</c:otherwise>


</c:choose>
	<h2 style="text-align:center;color:green">${resultMsg}</h2>
<h1 style="color:red;text-align:center"><a href="register">Add Emp<img src="images/add.png" width="50"  height="50"></a> &nbsp;&nbsp;&nbsp;
<a href="./">HOME<img src="images/Home.png" width="50"  height="50"></a></h1>
</div>