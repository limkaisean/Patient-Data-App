package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/runsearch.html")
public class SearchServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    Model model = ModelFactory.getModel();
    String value = request.getParameter("searchOption");
    String keyword = request.getParameter("searchstring");
    String minAge = request.getParameter("minAge");
    String maxAge = request.getParameter("maxAge");
    String gender = request.getParameter("gender");
    List<Patient> filterResult;
    int page = 1;
    int recordsPerPage = 100;
    if(request.getParameter("page") != null){
      page = Integer.parseInt(request.getParameter("page"));
    }

    List<Patient> searchResult = model.search(keyword, value);
    filterResult = model.filterByAge(searchResult, Integer.parseInt(minAge), Integer.parseInt(maxAge));
    filterResult = model.filterByGender(filterResult, gender);

    List<Patient> results = model.getPatientsbyPages(filterResult, (page-1)*recordsPerPage, recordsPerPage);
    int noOfPatients = filterResult.size();
    int noOfPages = (int) Math.ceil(noOfPatients * 1.0 / recordsPerPage);
    request.setAttribute("result", results);
    request.setAttribute("noOfPages", noOfPages);
    request.setAttribute("currentPage", page);
    request.setAttribute("keyword", keyword);
    request.setAttribute("minAge", minAge);
    request.setAttribute("maxAge", maxAge);
    request.setAttribute("value", value);
    request.setAttribute("gender", gender);

    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
    dispatch.forward(request, response);
  }
}
