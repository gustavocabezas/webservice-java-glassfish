/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.JobsDAO;
import dao.UsersDAO;
import entity.Jobs;
import entity.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import java.math.BigDecimal;

public class JobsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contentPage", "jobs.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id;
        BigDecimal salary = null;

        String action = request.getParameter("action");

        Users user = (Users) request.getSession().getAttribute("loggedUser");

        if (user == null) {
            request.setAttribute("contentPage", "login.jsp");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("id").isEmpty()) {
            id = 0;
        } else {
            id = Integer.parseInt(request.getParameter("id"));
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String location = request.getParameter("locationtext");
        String requirement = request.getParameter("requirements");

        String salaryString = request.getParameter("salary");
        if (salaryString != null && !salaryString.trim().isEmpty()) {
            try {
                salary = new BigDecimal(0);
                salary = new BigDecimal(salaryString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        Jobs job = new Jobs(id, title, description, location, requirement, salary, new Date(), user.getId());

        try {

            switch (action) {

                case "Get":
                    try {
                        Jobs jobTemp = JobsDAO.getById(id);
                        request.setAttribute("contentPage", "jobs.jsp");
                        request.setAttribute("id", jobTemp.getId());
                        request.setAttribute("title", jobTemp.getTitle());
                        request.setAttribute("description", jobTemp.getDescription());
                        request.setAttribute("locationtext", jobTemp.getLocationText());
                        request.setAttribute("requirements", jobTemp.getRequirements());
                        request.setAttribute("salary", jobTemp.getSalary());
                    } catch (Exception error) {
                    }
                    break;

                case "Create":
                    JobsDAO.insert(job);
                    break;

                case "Update":
                    JobsDAO.update(job);
                    break;

                case "Delete":
                    JobsDAO.delete(id);
                    break;

                default:
                    break;
            }

            request.getRequestDispatcher("layout.jsp").forward(request, response);

        } catch (Exception e) {
            // Log the exception using a logging framework
            request.setAttribute("error", "Error whith the job. Please try again.");
            request.setAttribute("contentPage", "login.jsp");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

    }
}
