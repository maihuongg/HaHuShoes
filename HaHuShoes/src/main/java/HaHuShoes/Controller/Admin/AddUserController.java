package HaHuShoes.Controller.Admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.batch.Main;

import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.Impl.AccountServiceImpl;
@WebServlet(urlPatterns =  "/admin/user-management/add")
@MultipartConfig()
public class AddUserController extends HttpServlet{
	iAccountService userService= new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.getRequestDispatcher("/views/admin/add-user-management.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		UserModel userModel = new UserModel();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try
		{
			String username = req.getParameter("userName");
			String email= req.getParameter("email");
			String password = req.getParameter("password");
			String image = req.getParameter("images");
			/*
			 * Part part = req.getPart("images"); String realPath =
			 * req.getServletContext().getRealPath("/HaHuShoes_Images"); String filename =
			 * Paths.get(part.getSubmittedFileName()).getFileName().toString();
			 * if(!Files.exists(Paths.get(realPath))) {
			 * Files.createDirectory(Paths.get(realPath)); } part.write(realPath + "/" +
			 * filename);
			 * 
			 * userModel.setImages(filename);
			 */
			
			
			String roleString= req.getParameter("roleId");
			userModel.setUserName(username);
			userModel.setEmail(email);
			userModel.setPassword(password);
//			userModel.setImages(filename);		
			userModel.setImages(image);
			int roleId = Integer.parseInt(roleString);
			userModel.setRoleId(roleId);
			String alertMsg = "";
			userService.insert(userModel);
			resp.sendRedirect(req.getContextPath() + "/admin/user-management");
//			userService.insert(userModel);
//			if(username.isEmpty() || password.isEmpty())
//			{
//				alertMsg = "Fail to add ";
//				req.setAttribute("alert", alertMsg);
//				req.getRequestDispatcher("/views/admin/add-user-management.jsp").forward(req, resp);
//				return;
////				resp.sendRedirect(req.getContextPath() + "/admin/user-management/add");
//			}
//			else 
//			{
//				alertMsg = "Successfully! ";
//				req.setAttribute("alert", alertMsg);
//				userService.insert(userModel);
//				resp.sendRedirect(req.getContextPath() + "/admin/user-management");
//			}
			
		} 
		catch (Exception e)
		{
			System.out.print(e);
		}
		
	}
	
}
