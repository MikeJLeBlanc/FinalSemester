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
import org.example.bytebank.dao.TransactionDao;
import org.example.bytebank.model.DepositWithdraw;
import org.example.bytebank.model.Recharge;

@WebServlet("/HistoryController")
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HistoryController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		String user = (String)ses.getAttribute("login");
		System.out.println("at history :" + user);
		
		TransactionDao td = new TransactionDao();

        List<Recharge> rlst = null;
        try {
            rlst = td.rhistory(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<DepositWithdraw> dlst = null;
        try {
            dlst = td.rechHistory(user);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if((rlst !=null) && (dlst != null)){
			request.setAttribute("rech",rlst);
			request.setAttribute("rech2", dlst);
			
		RequestDispatcher view = request.getRequestDispatcher("HistoryShow.jsp");
		view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
