package com.evry.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evry.dao.UserDAO;
import com.evry.dto.User;
@WebServlet("/transfer")
public class TransferMoneyServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	  System.out.println("Hello you entered into WalletCreation servlet post method");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		int id1 = Integer.parseInt(req.getParameter("uid"));
		int id2 = Integer.parseInt(req.getParameter("bid"));
		double amt = Double.parseDouble(req.getParameter("amt"));
		
		
		UserDAO dao = new UserDAO();
		User money = dao.transferMoney(id1,id2,amt);
		

	    
		
		if(money !=null)
		{
			
			req.getRequestDispatcher("/views/loginsuccess.jsp").include(req, res);
			pw.println("Beneficiary Account has been credited with RS: "+amt+" and your current balance is:"+money.getBalance());
		
		}
		
		else {
			
			req.getRequestDispatcher("/views/loginsuccess.jsp").include(req, res);
			pw.println("Something went wrong . please try again");
		}
	       
	}
}
