package HaHuShoes.Controller.Seller;

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

@WebServlet(urlPatterns = {"/seller/dashboard"})
//day la trang index
public class HomeSellerController extends HttpServlet{
	iCategoryService categoryService=new CategoryServiceImpl();
	iProductService productService=new ProductServiceImpl();
	iAccountService userService = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
		String username= req.getParameter("username");
		req.setAttribute("username", username);
		req.getRequestDispatcher("/views/seller/index.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
