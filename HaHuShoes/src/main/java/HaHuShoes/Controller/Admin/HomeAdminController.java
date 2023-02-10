package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iOrderService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.OrderServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;


@WebServlet(urlPatterns = {"/admin/dashboard"})
//day la trang index
public class HomeAdminController extends HttpServlet{
	iCategoryService categoryService=new CategoryServiceImpl();
	iProductService productService=new ProductServiceImpl();
	iAccountService userService = new AccountServiceImpl();
	iOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		int totalProduct = productService.countAll();
		req.setAttribute("totalProduct", totalProduct);
		
		int totalCategory = categoryService.countAll();
		req.setAttribute("totalCategory", totalCategory);
		
		int totalUser = userService.countAll();
		req.setAttribute("totalUsers", totalUser);
		
		int totalMoney = orderService.TotalModey();
		req.setAttribute("totalMoney", totalMoney);
		
		req.getRequestDispatcher("/views/admin/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//		do post đẩy dữ liệu về
	}

}
