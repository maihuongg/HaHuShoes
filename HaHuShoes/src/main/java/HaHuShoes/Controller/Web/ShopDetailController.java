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
import HaHuShoes.Model.CommentModel;
import HaHuShoes.Model.ItemModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iCommentService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.CommentServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;



@WebServlet(urlPatterns = {"/shop-detail"})
public class ShopDetailController  extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	
	iCategoryService categoryService=new CategoryServiceImpl();
	iProductService productService = new ProductServiceImpl();
	iCommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CategoryModel> cateList = categoryService.findAll();		
		req.setAttribute("cateList", cateList);
		
		List<CommentModel> commentList = commentService.findTop3();
		req.setAttribute("commentList", commentList);
		
		int count=commentService.countAll();
		req.setAttribute("count", count);
		
		// TODO Auto-generated method stub
		String id = req.getParameter("productId");
		String amount = req.getParameter("amount");
		ProductModel productoneId = productService.findoneId(Integer.parseInt(id));
		req.setAttribute("productoneId", productoneId);
		req.setAttribute("amount", amount);
		ProductModel cateId = productService.findCateIdByProductId(Integer.parseInt(id));
		int CategoryId = cateId.getCategoryId();
		List<ProductModel> productTop4ByCateId = productService.findProductbyCateIdTop4(CategoryId);
		req.setAttribute("productTop4ByCateId", productTop4ByCateId);
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
		req.getRequestDispatcher("/views/web/shop-detail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
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

		String amount = req.getParameter("amount");
		String id = req.getParameter("id");
		if (txt.isEmpty()) {
			txt = id + ":" + amount;
		} else {
			txt = txt + "-" + id + ":" + amount;
		}
		Cookie c = new Cookie("cart", txt);
		c.setMaxAge(1 * 24 * 60 * 60);
		resp.addCookie(c);
		resp.sendRedirect(req.getContextPath() + "/shop-detail?productId="+id+"");
	}

}
