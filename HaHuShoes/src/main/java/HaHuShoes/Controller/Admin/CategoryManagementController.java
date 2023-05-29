package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Dao.iCategoryDao;
import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns =  "/admin/category-management" )
public class CategoryManagementController extends HttpServlet{
	iCategoryService categoryService=new CategoryServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<CategoryModel> cateList = categoryService.findAll();		
//		req.setAttribute("cateList", cateList);
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");

		int count= categoryService.countAll();
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
		List<CategoryModel> cateList = categoryService.paging(index);
		req.setAttribute("tag", index);
		req.setAttribute("endP", endP);
		req.setAttribute("cateList", cateList);
		req.getRequestDispatcher("/views/admin/category-management.jsp").forward(req, resp);
	}
}
