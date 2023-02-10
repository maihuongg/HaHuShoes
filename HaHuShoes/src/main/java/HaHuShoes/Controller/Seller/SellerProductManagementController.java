package HaHuShoes.Controller.Seller;

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
import HaHuShoes.Model.SellerModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.iSellerService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;
import HaHuShoes.Service.Impl.SellerServiceImpl;

@WebServlet(urlPatterns = "/seller/product-management")
public class SellerProductManagementController extends HttpServlet{
	iProductService productService = new ProductServiceImpl();
	iAccountService accountService = new AccountServiceImpl();
	iSellerService sellerService =new SellerServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bat dau phantrang
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
//		List<ProductModel> productList = productService.findAll();
//		req.setAttribute("productList", productList);
//		
		String username = req.getParameter("username");
		UserModel getUidModel= accountService.findbyUsername(username);
		int userId= getUidModel.getUserId();
		
		SellerModel getSellerIdModel= sellerService.findSellerId(userId);
		int sellerId= getSellerIdModel.getSellerId();
		
		int count= productService.countProductBySellerId(sellerId);
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
		
//		int sellerId= Integer.parseInt(req.getParameter("sellerId"));
		List<ProductModel> productList = productService.findAllbySellerId(sellerId,index);
		req.setAttribute("username", username);
		req.setAttribute("tag", index);
		req.setAttribute("endP", endP);
		req.setAttribute("productList", productList);
		

		req.getRequestDispatcher("/views/seller/seller-product-management.jsp").forward(req, resp);
	}
}

