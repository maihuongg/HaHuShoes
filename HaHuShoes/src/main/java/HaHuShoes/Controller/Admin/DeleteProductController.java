package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns =
{ "/admin/product-management/delete" })
public class DeleteProductController extends HttpServlet{
	iProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String productId = req.getParameter("productId");
		
		productService.delete(Integer.parseInt(productId));
		resp.sendRedirect(req.getContextPath() + "/admin/product-management");
	}
}
