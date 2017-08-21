package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class filter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest Request=(HttpServletRequest) ServletRequest;
		HttpServletResponse Response=(HttpServletResponse) ServletResponse;
		
		Request.setCharacterEncoding("utf-8");
		Response.setContentType("text/html;charset=utf-8");
		
		chain.doFilter(Request, Response);
		
		

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
