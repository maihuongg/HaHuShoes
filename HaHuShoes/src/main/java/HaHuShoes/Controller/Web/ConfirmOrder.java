package HaHuShoes.Controller.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Service.iOrderService;
import HaHuShoes.Service.Impl.OrderServiceImpl;

@WebServlet(urlPatterns ={ "/confirm" })
public class ConfirmOrder extends HttpServlet {

	private static final long serialVersionUID = 1L;
	iOrderService orderService=new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		orderService.ConfirmOrder(orderId);
		resp.sendRedirect(req.getContextPath() + "/order");
	}
}
