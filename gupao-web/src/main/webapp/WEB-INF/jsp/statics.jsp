<%--
  Created by IntelliJ IDEA.
  User: wac
  Date: 16/8/16
  Time: 上午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>URL=${uri}统计情况</title>
</head>
<body>
URL=${uri} 统计情况
<table border="1" style="font-family: 'DejaVu Sans Mono', monospace">
        <tr>
            <th> 时间 </th>
            <th>调用次数</th>
        </tr>
        <c:forEach items="${dataMap}" var="data">
            <tr>
                <th> <fmt:formatDate value="${data.date}" pattern="yyyy-MM-dd HH:mm:ss" /></th>
                <th>${data.count}</th>
            </tr>
        </c:forEach>

</table>
</body>
</html>
