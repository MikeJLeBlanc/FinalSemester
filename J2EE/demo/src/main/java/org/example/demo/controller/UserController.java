package org.example.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo.dao.UserDAO;
import org.example.demo.model.User;

import java.io.IOException;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private UserDAO userDao;

    public void init() {
        userDao = new UserDAO();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        register(req, res);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.sendRedirect("/register.jsp");
    }

    private void register(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setUsername(username);
        user.setPassword(password);

        try {
            int result = userDao.registerUser(user);
            if (result == 1) {
                req.setAttribute("NOTIFICATION", "User Registered Successfully!");
            }

        } catch (Exception e) {
            System.out.println("Error at register: " + e.getMessage());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/register");
        dispatcher.forward(req, res);
    }
}
