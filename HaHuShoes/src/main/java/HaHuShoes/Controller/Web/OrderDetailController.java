package HaHuShoes.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ItemModel;
import HaHuShoes.Model.OrderDetailModel;
import HaHuShoes.Model.OrderModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iOrderService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.OrderServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/orderdetail" })
public class OrderDetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	iProductService productService = new ProductServiceImpl();
	iCategoryService categoryService=new CategoryServiceImpl();
	iOrderService orderService=new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CategoryModel> cateList = categoryService.findAll();		
		req.setAttribute("cateList", cateList);
		// findAll product
		List<ProductModel> productList = productService.findAll();
		
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		
		List<OrderDetailModel> orderdetailList = orderService.findOrderDetialByOrderId(orderId);
		
		int totalmoney = orderService.TotalModeyByOrderId(orderId);

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
		req.setAttribute("orderdetailList", orderdetailList);
		req.setAttribute("totalmoney", totalmoney);
		req.getRequestDispatcher("/views/web/orderdetail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}
}
