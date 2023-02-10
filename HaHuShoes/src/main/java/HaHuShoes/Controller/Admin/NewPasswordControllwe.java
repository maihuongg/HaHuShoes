package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.Impl.AccountServiceImpl;

@WebServlet(urlPatterns = "/newPassword")
public class NewPasswordControllwe extends HttpServlet {

	private static final long serialVersionUID = 1L;
	iAccountService accountService = new AccountServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		RequestDispatcher dispatcher = null;
		UserModel findUserModel = new UserModel();
		findUserModel = accountService.findbyUsername(username);

		if (findUserModel != null) {
			if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

				try {
					UserModel accountModel = new UserModel();
					accountModel.setUserName(username);
					accountModel.setPassword(confPassword);
					accountService.editPassword(accountModel);
					response.sendRedirect(request.getContextPath() + "/login");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				request.setAttribute("alert", "Reset Fail !");
				doGet(request, response);
			}
		} else {
			{
				request.setAttribute("alert", "Username is not existed !");
				doGet(request, response);
			}
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.getRequestDispatcher("/views/admin/new-password.jsp").forward(req, resp);

	}
}
