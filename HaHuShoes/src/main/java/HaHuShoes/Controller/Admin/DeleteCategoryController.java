package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.Impl.CategoryServiceImpl;

@WebServlet(urlPatterns =
{ "/admin/category-management/delete" })
public class DeleteCategoryController extends HttpServlet{
	iCategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String id = req.getParameter("categoryId");
		cateService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/category-management");
	}
}
