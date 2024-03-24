package org.example.bytebank.controller;

import java.sql.SQLException;
import java.util.Date;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.bytebank.dao.RechargeDao;
import org.example.bytebank.model.Recharge;

@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RechargeController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		RechargeDao dao = new RechargeDao();
		String amt = request.getParameter("amount");
		String operator = request.getParameter("service");
		HttpSession ses = request.getSession(true);
		String user = (String)ses.getAttribute("login");
		System.out.println("on recharge  " + user);
		Recharge rg = new Recharge(user, amt, operator, new Date());

		int amt2 = Integer.parseInt(amt);
        int oldbal = 0;
        try {
            oldbal = dao.returnbal(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int newbal = oldbal - amt2;

		if (amt2 > oldbal) {
			msg = "fail recharge";
			ses.setAttribute("rech", msg);
			response.sendRedirect("Recharge.jsp");
		}
		else {
			String upbal = String.valueOf(newbal);
            try {
                dao.updateBal(user, upbal);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            int i = 0;
            try {
                i = dao.recharge(rg);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if(i == 1) {
				msg = "Done recharge";
				ses.setAttribute("recharge", msg);
				response.sendRedirect("Recharge.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
