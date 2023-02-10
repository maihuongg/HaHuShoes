package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HaHuShoes.Util.cookie;
@WebServlet(urlPatterns = { "/logout" })

public class LogOutController extends HttpServlet {

	private static final String CookieUtils = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		resp.setContentType("text/html;charset=UTF-8");
		
        HttpSession session = req.getSession();
        session.removeAttribute("account");
//        Cookie[] cookie = null;
//         cookie =req.getCookies();
         cookie.add("account",null,0, resp);
        resp.sendRedirect(req.getContextPath() + "/home");
//        resp.sendRedirect("home");
//        req.getRequestDispatcher("/views/web/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
