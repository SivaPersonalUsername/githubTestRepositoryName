package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LoginBean;
import com.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "LoginServlet- Des: used to login the user", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginBean loginBean=new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		System.out.println("username::" +username+"password::"+password);
		LoginDao loginDao=new LoginDao();
		if(loginDao.validate(loginBean)) {
			response.sendRedirect("loginSuccess.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
