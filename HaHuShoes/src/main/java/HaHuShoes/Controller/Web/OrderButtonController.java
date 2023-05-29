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
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iOrderService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.OrderServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/payment"})
public class OrderButtonController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	iProductService productService = new ProductServiceImpl();
	iOrderService orderService = new OrderServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
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
		String receiveName=req.getParameter("receiveName");
		String phone=req.getParameter("phone");
		String adress=req.getParameter("adress");
		CartModel cart = new CartModel(txt, productList);
		HttpSession session=req.getSession();
		UserModel u=(UserModel)session.getAttribute("account");
		if(u==null) {
			resp.sendRedirect(req.getContextPath() + "/login");
		}else {
			orderService.addOrder(u, cart, receiveName, phone, adress);
			Cookie c=new Cookie("cart","");
			c.setMaxAge(0);
			resp.addCookie(c);
			resp.sendRedirect(req.getContextPath() + "/order");
		}
	}

}
