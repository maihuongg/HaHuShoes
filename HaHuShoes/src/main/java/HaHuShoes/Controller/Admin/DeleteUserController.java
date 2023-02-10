package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.CategoryServiceImpl;

@WebServlet(urlPatterns =
{ "/admin/user-management/delete" })
public class DeleteUserController extends HttpServlet{
	iAccountService userService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String username = req.getParameter("userName");
		userService.delete(username);
		resp.sendRedirect(req.getContextPath() + "/admin/user-management");
	}
}
