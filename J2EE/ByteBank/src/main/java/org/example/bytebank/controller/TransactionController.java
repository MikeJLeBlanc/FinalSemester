package org.example.bytebank.controller;
import org.example.bytebank.dao.TransactionDao;
import org.example.bytebank.dao.RechargeDao;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransactionController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		String str = (String)ses.getAttribute("login");
		System.out.println(str);
		String ch = request.getParameter("choice");
		System.out.println(ch);
		RechargeDao dao = new RechargeDao();
        int bal = 0;

        try {
            bal = dao.returnbal(str);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String amt = request.getParameter("amount");

		if (ch.equals("withdrawl")) {
			TransactionDao td = new TransactionDao();
			int amt2 = Integer.parseInt(amt);

			if(amt2 > bal) {
				String amtw = "Amount Withdraw failed";
				ses.setAttribute("with2", amtw);
				response.sendRedirect("Transaction.jsp");
			} else {
                int i = 0;

				try {
                    i = td.withdraw(str, amt);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                if (i == 1) {
					String amtw = "Amount Withdraw Successfully";
					ses.setAttribute("with", amtw);
					response.sendRedirect("Transaction.jsp");
				} else {
					String amtw = "Amount Withdraw UnSuccessfully";
					ses.setAttribute("with", amtw);
					response.sendRedirect("Transaction.jsp");
				}
			}
		} else {
			TransactionDao td = new TransactionDao();
            int i = 0;

            try {
                i = td.deposit(str, amt);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

			if (i == 1) {
				String amtw="Amount Deposit  Successfully";
				ses.setAttribute("with", amtw);
				response.sendRedirect("Transaction.jsp");
			} else {
				String amtw="Amount Deposit UnSuccessfully";
				ses.setAttribute("with", amtw);
				response.sendRedirect("Transaction.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
