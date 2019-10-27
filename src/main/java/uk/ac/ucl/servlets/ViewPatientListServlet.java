package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Patient;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patientList.html")
public class ViewPatientListServlet extends HttpServlet
{

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    Model model = ModelFactory.getModel();
    int page = 1;
    int recordsPerPage = 100;
    if(request.getParameter("page") != null){
      page = Integer.parseInt(request.getParameter("page"));
    }
    List<Patient> patientList = model.getPatients();
    List<Patient> patients = model.getPatientsbyPages(patientList, (page-1)*recordsPerPage, recordsPerPage);
    int noOfPatients = model.getNoOfPatients();
    int noOfPages = (int) Math.ceil(noOfPatients * 1.0 / recordsPerPage);
    request.setAttribute("patients", patients);
    request.setAttribute("noOfPages", noOfPages);
    request.setAttribute("currentPage", page);

    RequestDispatcher dispatch = request.getRequestDispatcher("/patientList.jsp");
    dispatch.forward(request, response);
  }
}
