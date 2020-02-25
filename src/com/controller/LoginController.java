package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LoginBean;
import com.dao.LoginDao;
import com.daoimpl.LoginDaoImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 doPost(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginBean loginBean = new LoginBean();
		
		loginBean.setId(Integer.parseInt(request.getParameter("id")));
		loginBean.setName(request.getParameter("name"));
		loginBean.setMobile(request.getParameter("mobile"));
		
		LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
		
		String btn = request.getParameter("btname");		
		
		if("login".equals(btn)) {
			
			loginDaoImpl.insertv(loginBean);
			
			response.sendRedirect("index.jsp");
			
		}
		
		else if("update".equals(btn)) {
			
			loginDaoImpl.update(loginBean);
			
			response.sendRedirect("index.jsp");
			
		}
		
		else {
			
			loginDaoImpl.delete(loginBean);
			
			response.sendRedirect("index.jsp");
			
		}
	
	
	}

}
