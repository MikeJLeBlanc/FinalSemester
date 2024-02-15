package org.example.todolist.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import org.example.todolist.model.User;
import org.example.todolist.dao.UserDAO;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1;
    private UserDAO userDao;

    public void init() {
        userDao = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register/register.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setUsername(username);
        user.setPassHash(password);

        try {
            int result = userDao.registerUser(user);
            if (result == 1) {
                request.setAttribute("NOTIFICATION", "User Registered Successfully!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
        dispatcher.forward(request, response);
    }
}