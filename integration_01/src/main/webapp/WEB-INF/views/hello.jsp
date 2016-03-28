<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   列表
   <table >
           <tr>
                   <th>Id</th>
                   <th>UserID</th>
                   <th>TravelDate</th>
                   <th>fee</th>
                   <th>days</th>
           </tr>
           <c:forEach items="${list}" var="travelRecord" >
                <tr>
                        <td>${travelRecord.id}</td>
                        <td>${travelRecord.userId}</td>
                        <td>${travelRecord.travelDate}</td>
                        <td>${travelRecord.fee}</td>
                        <td>${travelRecord.days}</td>
                </tr>
           </c:forEach>
   </table>

</body>
</html>
