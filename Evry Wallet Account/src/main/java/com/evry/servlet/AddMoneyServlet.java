package com.evry.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.dao.UserDAO;
import com.evry.dto.User;
@WebServlet("/addMoney")
public class AddMoneyServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("uid"));
		double bal = Double.parseDouble(req.getParameter("balance"));

		UserDAO dao = new UserDAO();
		
		
		User addMoney = dao.addMoney(id,bal);
		if(addMoney!=null) {
			req.getRequestDispatcher("/views/checkbalance.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/views/addmoney.jsp").forward(req, resp);
			
		}
		
	}
}
