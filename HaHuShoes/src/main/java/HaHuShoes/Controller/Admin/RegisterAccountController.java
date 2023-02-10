package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.Impl.AccountServiceImpl;

@WebServlet(urlPatterns = "/register")
public class RegisterAccountController extends HttpServlet {
	iAccountService accountService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.getRequestDispatcher("/views/web/register.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String pw = req.getParameter("password");
		UserModel account = new UserModel();
		
		UserModel findUserModel = new UserModel();
		findUserModel = accountService.findbyUsername(username);

		if (findUserModel == null) {
			if (pw.equals(req.getParameter("repeatpw"))) {

				account.setUserName(username);
				account.setPassword(pw);
				account.setEmail(req.getParameter("email"));

				boolean check = accountService.insertUser(account);
				System.out.println(check);
				if (check) {
					req.setAttribute("alert", "Successfully !");
					doGet(req, resp);
				}
			}
			else {
				req.setAttribute("alert","password not match" );
				doGet(req, resp);
			}
		} 
		else {
			req.setAttribute("alert", "Username is existed" );
			doGet(req, resp);
		}
	}

}
