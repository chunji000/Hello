package servlet.bclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BackAdmin;
import model.Bclass;
import model.authMsg;
import model.moderator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import dao.backadmin.BackAdminDaoImpl;
import dao.backbclass.BackBclassDaoImpl;

public class servletbclass extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method=request.getParameter("method");
		System.out.println(method);
		if (method.equals("getbname")) {
			getbname(request, response);
		}
		if (method.equals("sel")) {
			sel(request, response);
		}
		if (method.equals("toupdate")) {
			toupdate(request, response);
		}
		if (method.equals("update")) {
			update(request, response);
		}
		if (method.equals("del")) {
			del(request, response);
		}
		if (method.equals("add")) {
			add(request, response);
		}
		if (method.equals("xz")) {
			getbname(request, response);
		}
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BackBclassDaoImpl bDaoImpl=new BackBclassDaoImpl();
		PrintWriter out = response.getWriter();
		String className=request.getParameter("bname2");
		String classMsg=request.getParameter("info2");
		String classPicture=request.getParameter("picture2");
		String userName=request.getParameter("uname2");
		int userId=bDaoImpl.getuid(userName);
		System.out.println(userId);
		
		Bclass bclass=new Bclass(className, classMsg, classPicture, userName);
		boolean flag=false;
		try {
			flag=bDaoImpl.add(bclass);
			int classId=bDaoImpl.getbid();
			moderator moder=new moderator(userId, classId);
			bDaoImpl.addbname(moder);
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


	private void del(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void toupdate(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void sel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();	
		//rows和page参数由前台easyui组件datagrid的分页工具栏自动向后台提供
		System.out.println(123);
		int page=Integer.valueOf(request.getParameter("page"));
		int rows=Integer.valueOf(request.getParameter("rows"));	
		System.out.println("分页信息：rows="+rows+",page="+page);
		BackBclassDaoImpl bDaoImpl=new BackBclassDaoImpl();
		int bid = 0;
		String classname = "";
		List<Bclass> list= null;
		int total = 0;//总记录数
		try {
			bid=Integer.parseInt(request.getParameter("bid3"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			classname=request.getParameter("name3");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			list=bDaoImpl.getbclass(classname, bid);
			total=bDaoImpl.getcount();
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


	private void getbname(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<BackAdmin> list=new ArrayList<BackAdmin>();
		BackBclassDaoImpl bDaoImpl=new BackBclassDaoImpl();
		PrintWriter out = response.getWriter();
		list=bDaoImpl.getbclassname();
		System.out.println(list);
		String json = JSON.toJSONString(list);
		System.out.println("===="+json);
		out.write(json);
		out.close();
		
	}

}
