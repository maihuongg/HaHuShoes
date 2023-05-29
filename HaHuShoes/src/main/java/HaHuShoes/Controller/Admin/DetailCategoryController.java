package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.Impl.CategoryServiceImpl;


@WebServlet(urlPatterns = { "/admin/category-management/edit" })
@MultipartConfig()
public class DetailCategoryController extends HttpServlet{
	iCategoryService categoryService= new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cateId = req.getParameter("categoryId");
		CategoryModel oneUser = categoryService.get(Integer.parseInt(cateId));
		req.setAttribute("oneUser", oneUser);
		req.getRequestDispatcher("/views/admin/category-detail.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		CategoryModel categoryModel= new CategoryModel();
		try {
			String cateId= req.getParameter("categoryId");
			
			String cateName = req.getParameter("categoryName");
			String cateCode = req.getParameter("categoryCode");
//			Integer status =Integer.parseInt("status");
			
			/*
			 * Part part = req.getPart("images"); String realPath =
			 * req.getServletContext().getRealPath("/HaHuShoes_Images"); String filename =
			 * Paths.get(part.getSubmittedFileName()).getFileName().toString(); if
			 * (!Files.exists(Paths.get(realPath))) {
			 * Files.createDirectory(Paths.get(realPath)); } part.write(realPath + "/" +
			 * filename);
			 */
			String image = req.getParameter("images");
			
			categoryModel.setCategoryName(cateName);
			categoryModel.setCategoryCode(cateCode);
//			categoryModel.setImages(filename);
			categoryModel.setImages(image);
			
			
//			categoryModel.setStatus(1);
			String alertMsg = "";
			categoryModel.setCategoryId(Integer.parseInt(cateId));
			categoryService.edit(categoryModel);
			
//			

		} catch (Exception e) {
			System.out.print(e);
		}
		resp.sendRedirect(req.getContextPath() + "/admin/category-management");

	}

}
