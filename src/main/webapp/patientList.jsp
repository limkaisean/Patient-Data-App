<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
  <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h2>Patients:</h2>
  <h3>Page <%=request.getAttribute("currentPage")%></h3>
  <ul>
    <%
      List<Patient> patients = (List<Patient>) request.getAttribute("patients");
      for (Patient patient : patients)
      {
        String href = "patientInfo.html?id=" + patient.getId();
    %>
    <li><a href="<%=href%>"><%=patient.getName()%></a>
    </li>
    <% } %>
  </ul>
  <%--For displaying Page numbers.
  The when condition does not display a link for the current page--%>
  <table class="center">
    <tr>
      <c:forEach begin="1" end="${noOfPages}" var="i">
        <c:choose>
          <c:when test="${currentPage eq i}">
            <td>${i}</td>
          </c:when>
          <c:otherwise>
            <td><a href="patientList.html?page=${i}">${i}</a></td>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </tr>
  </table>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
