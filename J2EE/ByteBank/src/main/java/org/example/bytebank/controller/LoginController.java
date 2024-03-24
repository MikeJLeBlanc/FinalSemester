package org.example.bytebank.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.bytebank.dao.RegisterDao;
import org.example.bytebank.model.Logins;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses=request.getSession(true);
		HttpSession ses2=request.getSession(true);

		String m=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Logins l = new Logins();
		l.setUsername(username);
		l.setPassword(password);
		RegisterDao rdao = new RegisterDao();
        int b = 0;

        try {
            b = rdao.validateUser(l);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(b == 1) {
			ses.setAttribute("login", username);
			response.sendRedirect("Dashboard.jsp");
		} else {
			m = "Not registered";
			ses2.setAttribute("log", m);
			response.sendRedirect("Login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
