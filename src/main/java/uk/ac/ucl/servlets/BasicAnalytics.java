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
import java.util.List;

@WebServlet("/analytics.html")
public class BasicAnalytics extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        List<Patient> youngest = model.getYoungest();
        List<Patient> oldest = model.getOldest();
        String averageAge = model.getAverageAge();
        int noOfChildren = model.getChildren();
        int noOfTeenagers = model.getTeenagers();
        int noOfAdults = model.getAdults();
        int noOfElders = model.getElders();
        request.setAttribute("youngest", youngest);
        request.setAttribute("oldest", oldest);
        request.setAttribute("averageAge", averageAge);
        request.setAttribute("children", noOfChildren);
        request.setAttribute("teenagers", noOfTeenagers);
        request.setAttribute("adults", noOfAdults);
        request.setAttribute("elders", noOfElders);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/analytics.jsp");
        dispatch.forward(request, response);
    }
}
