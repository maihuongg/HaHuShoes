package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.el.parser.BooleanNode;

import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Util.Constant;

@WebServlet(urlPatterns = { "/login" })
public class LoginController_New extends HttpServlet {

	iAccountService accountService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		// Check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue()); //day len views
					
					session.setAttribute("password", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		String userString = req.getParameter("username");
		req.setAttribute("username",userString);
		
		req.getRequestDispatcher("views/web/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember"); //lấy remember về
		if("on".equals(remember))
		{
			isRememberMe=true;
		}
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
			return;
		}
		iAccountService service = new AccountServiceImpl();
		UserModel user = service.login_new(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
//				Cookie cookie = new Cookie ("username",username);
//				cookie.setMaxAge(60);
//				resp.addCookie(cookie);
				saveRemeberMe(resp, username);
//				resp.sendRedirect(req.getContextPath() + "/waiting");
			}
			resp.sendRedirect(req.getContextPath() + "/waiting?username="+username+"");
			/*
			 * ?username="+username+""
			 */		
			} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/web/login.jsp").forward(req, resp);
		}
	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
//		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		Cookie cookie = new Cookie ("username",username);
		cookie.setMaxAge(20);
		response.addCookie(cookie);
	}

}
