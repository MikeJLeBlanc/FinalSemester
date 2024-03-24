package org.example.bytebank.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.bytebank.dao.ProfileDao;
import org.example.bytebank.model.Customer;

@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = null;
		
		HttpSession ses = request.getSession(true);
		String user = (String)ses.getAttribute("login");
		System.out.println("on edit " + user);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String balance = request.getParameter("balance");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Customer customer = new Customer(name, email, balance, username, password);
		ProfileDao pd = new ProfileDao();
        int k = 0;

        try {
            k = pd.UpdateProfile(customer, user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(k > 0) {
			msg = "completed profile";
			ses.setAttribute("profiles", msg);
			response.sendRedirect("profile.jsp");
		} else {
			response.sendRedirect("EditProfile.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
