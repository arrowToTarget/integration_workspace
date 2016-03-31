<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .trclass{
            background-color: #009f95 ;
        }
    </style>
</head>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath",basePath);
%>
<body>
   用户：
   用户名： <input type="text" value="" id="searchName" name="name"/>
   <input type="button" value="搜索" class="search"/> &nbsp;&nbsp;&nbsp;
   <input type="button" name="add" value="新增用户" class="add"/>

   <table >
           <tr>
                   <th>Id</th>
                   <th>name</th>
                   <th>brithday</th>
                   <th>hobby</th>
           </tr>
           <c:forEach items="${users}" var="user" >
                <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.birthday}</td>
                        <td>${user.hobby}</td>
                </tr>
           </c:forEach>
   </table>
    <br/>
   人物：
   <table >
       <tr>
           <th>Id</th>
           <th>name</th>
           <th>sex</th>
       </tr>
       <c:forEach items="${personList}" var="person">
           <tr>
               <td>${person.id}</td>
               <td>${person.name}</td>
               <td>${person.sex}</td>
           </tr>
       </c:forEach>
   </table>
    <br/>
   旅游记录：
   <table >
       <tr>
           <th>Id</th>
           <th>userId</th>
           <th>travelDate</th>
           <th>fee</th>
           <th>days</th>
       </tr>
           <tr>
               <td>${travelRecord.id}</td>
               <td>${travelRecord.userId}</td>
               <td>${travelRecord.travelDate}</td>
               <td>${travelRecord.fee}</td>
               <td>${travelRecord.days}</td>
           </tr>
   </table>
   <br/>
   Map:
   <br/>
   <c:forEach items="${map}" var="entry">
       ${entry.key} : ${entry.value}  <br/>
   </c:forEach>
    <input type="hidden" id="ctx" value="<%=basePath%>"/>
    <script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/list.js"></script>
    <script type="text/javascript" src="<%=basePath%>/js/update.js"></script>
</body>
</html>
