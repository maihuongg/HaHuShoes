package HaHuShoes.Controller.Admin;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.Impl.AccountServiceImpl;

@WebServlet(urlPatterns = {"/login_cu"} )
public class LoginController_Cu extends HttpServlet {

	

	iAccountService accountService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		Cookie arrCookie[] = req.getCookies();
		if(arrCookie != null)
		{
			for(Cookie cookie : arrCookie)
			{
				if(cookie.getName().equals("username"))
				{
					req.setAttribute("username", cookie.getValue());
				}
				if (cookie.getName().equals("password"))
				{
					req.setAttribute("password", cookie.getValue());
				}
			}
		}
		
		req.setAttribute("check", "login");
		req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String rmb = req.getParameter("remember");
		
		Cookie tkCookie = new Cookie("username", username);
		Cookie pwCookie = new Cookie("password", password);
		tkCookie.setMaxAge(10);
		resp.addCookie(tkCookie);
		if(rmb!=null)
		{
			pwCookie.setMaxAge(10);
			resp.addCookie(pwCookie);
		}
		else 
		{
			pwCookie.setMaxAge(0);
		}
		UserModel userLogin = accountService.login_cu(username, password);
		if(userLogin == null)
		{
			req.setAttribute("alert", "Account is not exist!");
			doGet(req, resp);
		}
		else 
		{
			HttpSession session = req.getSession();
			session.setAttribute("acc", userLogin);
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}

}
