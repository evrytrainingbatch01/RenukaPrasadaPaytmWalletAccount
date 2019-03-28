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
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("username");
		String pwd = req.getParameter("password");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobilenumber"));
		
		User user = new User();
		user.setUid(user.getUid());
		user.setuUserName(uname);
		user.setuPassword(pwd);
		user.setEmailId(email);
		user.setMobileNumber(mobile);
		
	
		UserDAO dao= new UserDAO();
		
		boolean addUser = dao.addUser(user);
		if(addUser==true) {
			req.getRequestDispatcher("views/index.jsp").forward(req, resp);
			req.getRequestDispatcher("views/success.jsp").include(req, resp);
		}
		else {
			req.getRequestDispatcher("views/failure.jsp").forward(req, resp);
			req.getRequestDispatcher("views/index.jsp").include(req, resp);
		}
	}

}
