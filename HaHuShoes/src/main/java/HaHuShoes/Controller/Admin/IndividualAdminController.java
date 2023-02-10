package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.Impl.AccountServiceImpl;

@WebServlet(urlPatterns = {"/admin/individual"})
@MultipartConfig()
public class IndividualAdminController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	iAccountService accountService=new AccountServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		UserModel userModel = accountService.findbyUsername(username);
		req.setAttribute("userModel", userModel);
		req.getRequestDispatcher("/views/admin/individual.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		UserModel userModel = new UserModel();
		try {
			String username = req.getParameter("username");
			String fullname = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			userModel.setUserName(username);
			userModel.setFullName(fullname);
			userModel.setEmail(email);
			userModel.setPassword(password);
			accountService.editindividual(userModel);
			resp.sendRedirect(req.getContextPath() + "/admin/individual?username="+username+"");
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
