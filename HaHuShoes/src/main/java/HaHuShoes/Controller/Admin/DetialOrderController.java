package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.InformationModel;
import HaHuShoes.Model.OrderDetailModel;
import HaHuShoes.Service.iOrderService;
import HaHuShoes.Service.Impl.OrderServiceImpl;

@WebServlet(urlPatterns = { "/admin/orderdetail" })
public class DetialOrderController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	iOrderService orderService=new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		
		List<OrderDetailModel> orderdetailList = orderService.findOrderDetialByOrderId(orderId);
		
		List<InformationModel> inforList = orderService.findInformaionByOrderId(orderId);
		int totalmoney = orderService.TotalModeyByOrderId(orderId);

		req.setAttribute("orderdetailList", orderdetailList);
		req.setAttribute("inforList", inforList);
		req.setAttribute("totalmoney", totalmoney);
		req.getRequestDispatcher("/views/admin/order-detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}
}
