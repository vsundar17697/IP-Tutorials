
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tag Example</title>
    </head>
<body>
    <c:set var="name" scope="session" value="${param.uname}"/>
    <c:set var="age" scope="session" value="${param.uname1}"/>

    <c:choose>
        <c:when test = "${age<=14}">
            Welcome <c:out value="${name}"/>, you are a child !
        </c:when>
        <c:when test="${age<=35}">
            Welcome <c:out value="${name}"/>, you are an adult !
        </c:when>
        <c:otherwise>
            Welcome <c:out value="${name}"/>, No comments !!
        </c:otherwise>            
    </c:choose>    
        
</body>
</html>
