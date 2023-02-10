package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns =  "/admin/user-management" )
public class UserManagementController extends HttpServlet{
	iAccountService userService=new AccountServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<UserModel> userList = userService.findAlL();		
//		req.setAttribute("userList", userList);
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		int count= userService.countAll();
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
		
		int endP = count/4;
		if (count % 4 != 0)
		{
			endP++;
		}
		List<UserModel> userList = userService.paging(index);
		req.setAttribute("tag", index);
		req.setAttribute("endP", endP);
		req.setAttribute("userList", userList);
		

		req.getRequestDispatcher("/views/admin/user-management.jsp").forward(req, resp);
	}
	
}
