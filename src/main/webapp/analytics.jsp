<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26-Mar-19
  Time: 5:51 PM
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
<div>
    <h2>Basic Analytics</h2>
    <h3>Youngest:</h3>
    <ul>
        <%
            List<Patient> youngest = (List<Patient>) request.getAttribute("youngest");
            for (Patient patient : youngest)
            {
                String href = "patientInfo.html?id=" + patient.getId();
        %>
        <li><a href="<%=href%>"><%=patient.getName()+ ", " + patient.getAge()%></a>
        </li>
        <% } %>
    </ul>
    <h3>Oldest:</h3>
    <ul>
        <%
            List<Patient> oldest = (List<Patient>) request.getAttribute("oldest");
            for (Patient patient : oldest)
            {
                String href = "patientInfo.html?id=" + patient.getId();
        %>
        <li><a href="<%=href%>"><%=patient.getName()+ ", " + patient.getAge()%></a>
        </li>
        <% } %>
    </ul>
    <%String averageAge = (String) request.getAttribute("averageAge");%>
    <%int children = (int) request.getAttribute("children");%>
    <%int teenagers = (int) request.getAttribute("teenagers");%>
    <%int adults = (int) request.getAttribute("adults");%>
    <%int elders = (int) request.getAttribute("elders");%>
    <pre><span id="analytics">
     Average Age: <%=averageAge%>

     Number of Children(0 - 12): <%=children%>

     Number of Teenagers(13 - 17): <%=teenagers%>

     Number of Adults(18 - 59): <%=adults%>

     Number of Elders(>= 60): <%=elders%>
    </span></pre>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
