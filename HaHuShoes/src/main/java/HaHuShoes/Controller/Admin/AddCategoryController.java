package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.batch.Main;

import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
@WebServlet(urlPatterns =  "/admin/category-management/add")
@MultipartConfig()
public class AddCategoryController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	iCategoryService userService= new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.getRequestDispatcher("/views/admin/add-category-management.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		CategoryModel category = new CategoryModel();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try
		{
			String name = req.getParameter("cateName");
			String code = req.getParameter("cateCode");
			int status = Integer.parseInt(req.getParameter("status"));
			/*
			 * Part part = req.getPart("images");  String realPath =
			 * req.getServletContext().getRealPath("/HaHuShoes_Images"); String filename =
			 * Paths.get(part.getSubmittedFileName()).getFileName().toString();
			 * if(!Files.exists(Paths.get(realPath))) {
			 * Files.createDirectory(Paths.get(realPath)); } part.write(realPath + "/" +
			 * filename);
			 */
			String image = req.getParameter("images");
//			set thuoc tinh
			category.setCategoryName(name);
			category.setCategoryCode(code);
			category.setStatus(status);
//			category.setImages(filename);
			category.setImages(image);
			userService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category-management");
		} 
		catch (Exception e)
		{
		}
	}
	
}
