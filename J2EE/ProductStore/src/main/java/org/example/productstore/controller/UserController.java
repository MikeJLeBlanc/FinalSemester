package org.example.productstore.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.productstore.dao.UserDao;
import org.example.productstore.modal.User;

import java.io.IOException;

public class UserController {
    private UserDao userDao;

    public void init() {userDao = new UserDao();}
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
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User();
        user.setfName(firstName);
        user.setlName(lastName);
        user.setEmail(email);
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
