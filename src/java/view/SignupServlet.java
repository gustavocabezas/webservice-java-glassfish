/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.HibernateUtil;
import dao.PersonsDAO;
import dao.UsersDAO;
import entity.Persons;
import entity.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contentPage", "signup.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String identification = request.getParameter("identification");
        String password = request.getParameter("password");

        if (email == null || password == null || email.trim().isEmpty() || password.trim().isEmpty() || identification.trim().isEmpty()) {
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
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(user);
            System.out.println("User: " + user);
            if (user.getId() != 0) {

                Persons person = new Persons(0, user.getId(), identification, new Date(), user.getId());
                session.save(person);
                System.out.println("Person: " + person);
                if (person.getId() != 0) {
                    session.flush();
                    transaction.commit();
                    session.close();
                    request.setAttribute("contentPage", "login.jsp");
                    request.getRequestDispatcher("layout.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            request.setAttribute("error", "Error while registering the user. Please try again.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
