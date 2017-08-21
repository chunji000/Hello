package servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.admin;

import dao.admin.AdminDao;
import dao.admin.AdminDaoImpl;

public class servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String method=request.getParameter("method");
		System.out.println(method);
		if (method.equals("login")) {
			login(request, response);
		}
		if (method.equals("admininfo")) {
			admininfo(request, response);
		}
	}
	private void admininfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AdminDaoImpl dao=new AdminDaoImpl();
		String name=request.getParameter("hname");
		System.out.println(name);
		List<admin> list=dao.getadmininfo(name);	
		request.setAttribute("list", list);
		request.getRequestDispatcher("main/info.jsp").forward(request, response);
		
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		AdminDaoImpl dao=new AdminDaoImpl();
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		String pwd=request.getParameter("password");
		String code=(String)request.getSession().getAttribute("sRand");
		String imageCode=request.getParameter("imageCode");		
		int count=dao.getcount(name, pwd);	
		if (count>0&&code.equals(imageCode)) {
			request.getRequestDispatcher("pro/main.jsp").forward(request, response);
		}else {
			response.sendRedirect("pro/login-error.jsp");						
		}
		
	}
}
