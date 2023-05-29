package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.OrderModel;
import HaHuShoes.Service.iOrderService;
import HaHuShoes.Service.Impl.OrderServiceImpl;

@WebServlet(urlPatterns = {"/admin/order-management"})
public class OrderManagementController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	iOrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		super.doGet(req, resp);
		
		int count = orderService.countAllOrderConfirm();
		
		String indexString = req.getParameter("index");
		int index;
		if (indexString == null) {
			index = 1;
		} else {
			index = Integer.parseInt(req.getParameter("index"));
		}

		int endP = count / 3;
		if (count % 3 != 0) {
			endP++;
		}
		List<OrderModel> orderList= orderService.findOrderConfirm(index);
		
		req.setAttribute("tag", index);
		req.setAttribute("endP", endP);
		req.setAttribute("orderList", orderList);
		req.getRequestDispatcher("/views/admin/order-management.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
//		do post đẩy dữ liệu về
	}
	
}
