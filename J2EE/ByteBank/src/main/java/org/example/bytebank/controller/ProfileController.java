package org.example.bytebank.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.bytebank.dao.ProfileDao;
import org.example.bytebank.model.Customer;


@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		String auth = (String)ses.getAttribute("login");
		System.out.println("on profile " + auth);
		ProfileDao pd = new ProfileDao();
        List<Customer> clst = null;
        try {
            clst = pd.getUser(auth);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(clst != null)
		{
			request.setAttribute("cust",clst);
			RequestDispatcher view = request.getRequestDispatcher("profile.jsp");
			view.forward(request, response);				
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
