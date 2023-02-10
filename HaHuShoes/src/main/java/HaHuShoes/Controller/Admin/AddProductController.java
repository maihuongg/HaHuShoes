package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
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

@WebServlet(urlPatterns =  "/admin/product-management/add")
@MultipartConfig()
public class AddProductController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	iProductService productService= new ProductServiceImpl();
	iCategoryService categoryService= new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		List<CategoryModel> cateList = categoryService.findAll();
		req.setAttribute("cateList", cateList);
		req.getRequestDispatcher("/views/admin/add-product-management.jsp").forward(req, resp);
		
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
			String productName=req.getParameter("productName");
			String productCode= req.getParameter("productCode");
			
			String description= req.getParameter("descriptions");
			String sprice=req.getParameter("price");
			double price= Double.parseDouble(sprice);
			String amountp=req.getParameter("amount");
			int amount= Integer.parseInt(amountp);
			String stockp=req.getParameter("stock");
			int stock= Integer.parseInt(stockp);
			int status = Integer.parseInt(req.getParameter("status"));
			
			/*
			 * Part part = req.getPart("images"); String realPath =
			 * req.getServletContext().getRealPath("/HaHuShoes_Images"); String filename =
			 * Paths.get(part.getSubmittedFileName()).getFileName().toString();
			 * if(!Files.exists(Paths.get(realPath))) {
			 * Files.createDirectory(Paths.get(realPath)); } part.write(realPath + "/" +
			 * filename);
			 */
			String image = req.getParameter("images");
			String createDatep = req.getParameter("createDate");
//			Date createDate= Date.valueOf(createDatep);
			String idString = req.getParameter("categoryId");
			int categoryId= Integer.parseInt(idString);
//			List<CategoryModel> cateList = categoryService.findAll();		
//			req.setAttribute("cateList", cateList);
			//set
//			product.setImages(filename);
			product.setImages(image);
			product.setProductName(productName);
			product.setProductCode(productCode);
//			product.setProductId(productId);
			product.setDescription(description);
			product.setPrice(price);
			product.setAmount(amount);
			product.setStock(stock);
//			product.setCreateDate(createDate);
			product.setCategoryId(categoryId);	
			product.setStatus(status);
			productService.insert(product);
			resp.sendRedirect(req.getContextPath()+"/admin/product-management");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
