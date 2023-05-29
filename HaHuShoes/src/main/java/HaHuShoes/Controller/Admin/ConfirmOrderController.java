package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iOrderService;
import HaHuShoes.Service.Impl.OrderServiceImpl;

@WebServlet(urlPatterns ={ "/admin/confirm" })
public class ConfirmOrderController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	iOrderService orderService=new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		orderService.ConfirmOrderAdmin(orderId);
		HttpSession session=req.getSession();
		UserModel u=(UserModel)session.getAttribute("account");
		String username = u.getUserName();
		resp.sendRedirect(req.getContextPath() + "/admin/dashboard?username="+username+"");
	}

}
