package org.example.bytebank.controller;

import org.example.bytebank.dao.RegisterDao;
import org.example.bytebank.model.Customer;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String msg = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String balance = request.getParameter("balance");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Customer customer = new Customer(name, email, balance, username, password);
		RegisterDao rdao=new RegisterDao();
        int i = 0;
        try {
            i = rdao.checkuser(customer);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

		if(i>0) {
			msg="Username & Password already Exist";
			session.setAttribute("reg2", msg);
			response.sendRedirect("Register.jsp");
		} else {
            int j= 0;
            try {
                j = rdao.create(customer);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if(j > 0) {
				session.setAttribute("reg", username);
				response.sendRedirect("Login.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
