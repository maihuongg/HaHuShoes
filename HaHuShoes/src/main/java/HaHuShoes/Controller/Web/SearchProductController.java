package HaHuShoes.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ItemModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/searchproduct"})
public class SearchProductController  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	iProductService productService= new ProductServiceImpl();
	iCategoryService categoryService=new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		List<CategoryModel> cate3List = categoryService.findAll();
		req.setAttribute("cate3List", cate3List);
		
		List<ProductModel> products = null;
		String txtsearch = req.getParameter("txtsearch");
		String indexPage = req.getParameter("index");
		
		if (indexPage == null)
		{
			indexPage = "1";
		}
		
		int index = Integer.parseInt(indexPage);
		
		int	count = productService.countSearchProduct(txtsearch);
		products = productService.SearchProduct(txtsearch, index);
		int endP = count/3;
		if(count % 3 != 0)
		{
			endP++;
		}
		req.setAttribute("products", products);
		req.setAttribute("tag", index);
		req.setAttribute("endP", endP);
		req.setAttribute("txtsearch", txtsearch);

		// findAll product
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
		req.getRequestDispatcher("/views/web/searchproduct.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		// findAll product
		List<ProductModel> productList = productService.findAll();

		// Cookie giỏ hàng
		Cookie[] arr = req.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("cart")) {
					txt += o.getValue();
					o.setMaxAge(0);
					resp.addCookie(o);
				}
			}
		}

		String num = "1";
		String id = req.getParameter("id");
		if (txt.isEmpty()) {
			txt = id + ":" + num;
		} else {
			txt = txt + "-" + id + ":" + num;
		}
		Cookie c = new Cookie("cart", txt);
		c.setMaxAge(1 * 24 * 60 * 60);
		resp.addCookie(c);
		resp.sendRedirect(req.getContextPath() + "/shop");
	}

}
