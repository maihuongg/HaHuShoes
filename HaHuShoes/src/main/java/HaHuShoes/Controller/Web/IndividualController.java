package HaHuShoes.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ItemModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/individual"})
@MultipartConfig()
public class IndividualController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	iCategoryService categoryService=new CategoryServiceImpl();
	iProductService productService=new ProductServiceImpl();
	iAccountService accountService=new AccountServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CategoryModel> cate3List = categoryService.findAll();
		req.setAttribute("cate3List", cate3List);
		
		String username=req.getParameter("username");
		UserModel userModel = accountService.findbyUsername(username);
		req.setAttribute("userModel", userModel);
		
		List<ProductModel> productList = productService.findAll();

		// Cookie giỏ hàng
		Cookie[] arr = req.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("cart")) {
					txt += o.getValue();
				}
			}
		}
		CartModel cart = new CartModel(txt, productList);
		List<ItemModel> listitem = cart.getItems();
		int n;
		if (listitem != null) {
			n = listitem.size();
		} else
			n = 0;
		req.setAttribute("size", n);
		req.getRequestDispatcher("/views/web/individual.jsp").forward(req, resp);
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
			resp.sendRedirect(req.getContextPath() + "/individual?username="+username+"");
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
