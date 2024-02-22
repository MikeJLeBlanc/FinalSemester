package org.example.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.example.demo.dao.LoginDAO;
import org.example.demo.model.LoginBean;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private LoginDAO login;

    public void init() {login = new LoginDAO();}

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        authenticate(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        authenticate(req, res);
    }

    protected void authenticate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginBean bean = new LoginBean();
        bean.setUsername(username);
        bean.setPassword(password);

        try {
            if (login.validate(bean)) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/todo-list.jsp");
                req.getSession().setAttribute("username", username);
                dispatcher.include(req, res);
                dispatcher.forward(req, res);
            } else {
                res.sendRedirect("index.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
