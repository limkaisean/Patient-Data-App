<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
  <link rel="stylesheet" href="css/styles.css" type="text/css">
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h3>Search Result</h3>
  <h3>Page <%=request.getAttribute("currentPage")%></h3>
    <ul>
      <%
        List<Patient> patients = (List<Patient>) request.getAttribute("result");
        for (Patient patient : patients)
        {
          String href = "patientInfo.html?id=" + patient.getId();
      %>
      <li><a href="<%=href%>"><%=patient.getFirst() + " " + patient.getLast()%></a>
      </li>
      <% } %>
  </ul>
  <table class="center">
    <tr>
      <c:forEach begin="1" end="${noOfPages}" var="i">
        <c:choose>
          <c:when test="${currentPage eq i}">
            <td>${i}</td>
          </c:when>
          <c:otherwise>
            <td><a href="runsearch.html?searchstring=${keyword}&searchOption=${value}&gender=${gender}&minAge=${minAge}&maxAge=${maxAge}&page=${i}">${i}</a></td>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </tr>
  </table>
</div>
<jsp:include page="/footer.jsp"/>
<div class="footer1">
  <a href="search.html" class="back">Back</a>
</div>
</body>
</html>