<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath",basePath);
%>
<body>
   列表
   <table >
           <tr>
                   <th>Id</th>
                   <th>Name</th>
                   <th>sex</th>
           </tr>
           <c:forEach items="${personList}" var="person" >
                <tr>
                        <td>${person.id}</td>
                        <td>${person.name}</td>
                        <td>${person.sex}</td>
                </tr>
           </c:forEach>
   </table>
   <br/>
   <input type="button" value="newPerson" class="add"/>
   <input type="hidden" id="ctx" value="<%=basePath%>"/>
   <script type="text/javascript" src="<%=basePath%>/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".add").click(function(){
            var url =$("#ctx").val()+"/add";
            window.location.href=url;
        });
    });

</script>
</body>
</html>
