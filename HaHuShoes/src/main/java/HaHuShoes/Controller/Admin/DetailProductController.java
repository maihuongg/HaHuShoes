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

import HaHuShoes.Model.CategoryModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iCategoryService;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.CategoryServiceImpl;
import HaHuShoes.Service.Impl.ProductServiceImpl;


@WebServlet(urlPatterns = { "/admin/product-management/edit" })
@MultipartConfig()
public class DetailProductController extends HttpServlet {
	iProductService productService = new ProductServiceImpl();
	iCategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		List<CategoryModel> cateList = categoryService.findAll();
	
		String proId = req.getParameter("productId");
		ProductModel oneUser = productService.findoneId(Integer.parseInt(proId));
		req.setAttribute("cateList", cateList);
		req.setAttribute("oneUser", oneUser);
		req.getRequestDispatcher("/views/admin/product-detail.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		ProductModel product = new ProductModel();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
//		LocalDate curDate=LocalDate.now();
//		String date=curDate.toString();
		try {
			String productId= req.getParameter("productId");
			String productName = req.getParameter("productName");
			String productCode = req.getParameter("productCode");
			String categoryId = req.getParameter("categoryId");
			String description = req.getParameter("descriptions");
			String price = req.getParameter("price");

			String amount = req.getParameter("amount");

			String stock = req.getParameter("stock");


			/*
			 * Part part = req.getPart("images"); // int status =
			 * Integer.parseInt(req.getParameter("status")); String realPath =
			 * req.getServletContext().getRealPath("/HaHuShoes_Images"); String filename =
			 * Paths.get(part.getSubmittedFileName()).getFileName().toString(); if
			 * (!Files.exists(Paths.get(realPath))) {
			 * Files.createDirectory(Paths.get(realPath)); } part.write(realPath + "/" +
			 * filename);
			 */
			
//			int categoryId = Integer.parseInt(idString);
//			List<CategoryModel> cateList = categoryService.findAll();		
//			req.setAttribute("cateList", cateList);
			// set
			String image = req.getParameter("images");
			product.setProductName(productName);
			product.setProductCode(productCode);
			product.setCategoryId(Integer.parseInt(categoryId));
			
			product.setDescription(description);
			product.setPrice(Double.parseDouble(price));
			product.setAmount(Integer.parseInt(amount));
			product.setStock(Integer.parseInt(stock));
//			product.setImages(filename);
			product.setImages(image);
			product.setProductId(Integer.parseInt(productId));
//			product.setStatus(status);
			productService.edit(product);
//			resp.sendRedirect(req.getContextPath() + "/admin/product-management");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		resp.sendRedirect(req.getContextPath() + "/admin/product-management");
	}

}
