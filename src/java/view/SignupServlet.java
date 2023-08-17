/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.UsersDAO;
import entity.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;

public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contentPage", "signup.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Email or password is invalid.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if (UsersDAO.emailExists(email)) {
            request.setAttribute("error", "Email already registered.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        Users user = new Users(0, 1, email, email, password, 1, new Date(), 0);
        try {
            UsersDAO.insert(user);
        } catch (Exception e) {
            // Log the exception using a logging framework
            request.setAttribute("error", "Error while registering the user. Please try again.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        request.setAttribute("contentPage", "login.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }
}
