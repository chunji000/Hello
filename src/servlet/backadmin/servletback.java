package servlet.backadmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import model.BackAdmin;
import model.authMsg;
import dao.admin.AdminDaoImpl;
import dao.backadmin.BackAdminDaoImpl;

public class servletback extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
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
		if (method.equals("bk")) {
			bk(request, response);
		}
		if (method.equals("tz")) {
			tz(request, response);
		}
		if (method.equals("hf")) {
			hf(request, response);
		}
		if (method.equals("yh")) {
			yh(request, response);
		}
		if (method.equals("xz")) {
			xz(request, response);
		}
		if (method.equals("sel")) {
			sel(request, response);
		}if (method.equals("toupdate")) {
			toupdate(request, response);
		}if (method.equals("update")) {
			update(request, response);
		}if (method.equals("del")) {
			del(request, response);
		}if (method.equals("getauthMsg")) {
			getauthMsg(request, response);
		}
	}
	private void getauthMsg(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<authMsg> list=new ArrayList<authMsg>();
		BackAdminDaoImpl dao=new BackAdminDaoImpl();
		PrintWriter out = response.getWriter();
		list=dao.getauthMsg();
		System.out.println(list);
		String json = JSON.toJSONString(list);
		out.write(json);
		out.close();
		
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int uid=Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);
		BackAdminDaoImpl dao=new BackAdminDaoImpl();
		PrintWriter out = response.getWriter();		
		boolean flag=false;
		try {
			flag=dao.del(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			out.write("{\"flag\":true}");
		}else{
			out.write("{\"flag\":false}");
		}
		out.close();
		
	}
	private void toupdate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int uid=Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);
		BackAdminDaoImpl dao=new BackAdminDaoImpl();
		PrintWriter out = response.getWriter();		
		BackAdmin bAdmin=null;
		try {
			bAdmin=dao.getlist(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (bAdmin!=null) {
			String json = JSON.toJSONString(bAdmin);
			System.out.println(json);
			out.write(json);
		}else{
			out.write("{\"flag\":false}");
		}
		out.close();
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		BackAdminDaoImpl dao=new BackAdminDaoImpl();
		int uid=Integer.parseInt(request.getParameter("id1"));
		System.out.println(uid);
		String uname=request.getParameter("uname1");
		String upwd=request.getParameter("upwd1");
		String sex=request.getParameter("sex1");
		String picture=request.getParameter("picture1");
		String birth=request.getParameter("birth1");
		int exp=Integer.parseInt(request.getParameter("exp1"));
		int money=Integer.parseInt(request.getParameter("money1"));
		String spe=request.getParameter("spe1");
		String authMsg=request.getParameter("authId1");
		System.out.println(authMsg);
		BackAdmin backAdmin=new BackAdmin(uid, uname, upwd, birth, sex, picture, exp, money, spe, authMsg);	
		boolean flag=false;
		try {
			flag=dao.update(backAdmin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag) {
			out.write("{\"flag\":true}");
		}else{
			out.write("{\"flag\":false}");
		}
		out.close();
	}
	private void sel(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		PrintWriter out = response.getWriter();	
		//rows和page参数由前台easyui组件datagrid的分页工具栏自动向后台提供
		System.out.println(123);
		int page=Integer.valueOf(request.getParameter("page"));
		int rows=Integer.valueOf(request.getParameter("rows"));	
		System.out.println("分页信息：rows="+rows+",page="+page);
		BackAdminDaoImpl dao=new BackAdminDaoImpl();	
		int uid = 0;
		String name = "";
		String spe = "";
		List<BackAdmin> list= null;
		int total = 0;//总记录数
		try {
			uid=Integer.parseInt(request.getParameter("id3"));
		} catch (Exception e) {
			
		}
		try {
			name=request.getParameter("name3");
		} catch (Exception e) {
		}try {
			spe=request.getParameter("work3");
		} catch (Exception e) {

		}
		try {
			list=dao.getbackadmin(uid, name, spe);
			total=dao.getcount();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		if(list.size()>0){
			//编辑带分页信息的数据
			JSONObject json=new JSONObject();
			json.put("total", total);
			json.put("rows", list);			
			out.write(json.toString());
		}		
		out.close();
		
	}
	private void xz(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("mainPage", "xz.jsp");
		response.sendRedirect("back/main.jsp");	
	}
	private void yh(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("mainPage", "yh.jsp");
		response.sendRedirect("back/main.jsp");
		
	}
	private void hf(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("mainPage", "hf.jsp");
		response.sendRedirect("back/main.jsp");
		
	}
	private void tz(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("mainPage", "tz.jsp");
		response.sendRedirect("back/main.jsp");
		
	}
	private void bk(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("mainPage", "bk.jsp");
		response.sendRedirect("back/main.jsp");
		
	}
	private void admininfo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		BackAdminDaoImpl dao=new BackAdminDaoImpl();
		String name=request.getParameter("name");
		String pwd=request.getParameter("password");
		int count=dao.getcount(name, pwd);	
		if (count>0) {
			try {
				response.sendRedirect("back/main.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else {
			try {
				response.sendRedirect("back/login-error.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		
	}

}
