package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Dao.iCategoryDao;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product-management")
public class ProductManagementController extends HttpServlet {
	iProductService productService = new ProductServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bat dau phantrang
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
//		List<ProductModel> productList = productService.findAll();
//		req.setAttribute("productList", productList);
//		
		int count= productService.countAll();
		String indexString = req.getParameter("index");
		int index;
		if(indexString==null)
		{
			index = 1;
		}
		else 
		{
			index = Integer.parseInt(req.getParameter("index"));
		}
		
		int endP = count/5;
		if (count % 5 != 0)
		{
			endP++;
		}
		List<ProductModel> productList = productService.pagingProductManagement(index);
		req.setAttribute("tag", index);
		req.setAttribute("endP", endP);
		req.setAttribute("productList", productList);
		

		req.getRequestDispatcher("/views/admin/product-management.jsp").forward(req, resp);
	}
}
