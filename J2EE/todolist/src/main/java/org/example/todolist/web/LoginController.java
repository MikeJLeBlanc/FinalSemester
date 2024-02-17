package org.example.todolist.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.example.todolist.dao.loginDAO;
import org.example.todolist.model.LoginBean;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController {
    private loginDAO login;

    public void initialize() {
        login = new loginDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect("login/login.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        authenticate(req, res);
    }

    protected void authenticate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("usermame");
        String password = req.getParameter("password");
        LoginBean bean = new LoginBean();
        bean.setUsername(username);
        bean.setPassword(password);

        try {
            if (login.validate(bean)) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("todo/todo-list.jsp");
                dispatcher.forward(req, res);
            } else {
                HttpSession session = req.getSession();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
