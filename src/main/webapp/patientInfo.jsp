<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24-Mar-19
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
<h2>Patient Info</h2>
    <%String info = (String) request.getAttribute("patientInfo");%>
<pre>
    <div id="wrap">
   <div id="content">
    <%=info%>
   </div>
    </div>
</pre>
</div>
<jsp:include page="/footer.jsp"/>
<div class="footer1">
<a href="patientList.html" class="back">Back</a>
</div>
</body>
</html>
