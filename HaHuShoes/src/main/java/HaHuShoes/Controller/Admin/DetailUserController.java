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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
import HaHuShoes.Model.UserModel;
import HaHuShoes.Service.iAccountService;
import HaHuShoes.Service.Impl.AccountServiceImpl;


@WebServlet(urlPatterns = { "/admin/user-management/edit" })
@MultipartConfig()
public class DetailUserController extends HttpServlet {
	iAccountService userService = new AccountServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("userName");
		UserModel oneUser = userService.findbyUsername(username);
		req.setAttribute("oneUser", oneUser);
		req.getRequestDispatcher("/views/admin/user-detail.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		UserModel userModel = new UserModel();
//		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//		servletFileUpload.setHeaderEncoding("UTF-8"); 
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			String username = req.getParameter("userName");
			String fullname = req.getParameter("fullName");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			/*
			 * Part part = req.getPart("images"); String realPath =
			 * req.getServletContext().getRealPath("/HaHuShoes_Images"); String filename =
			 * Paths.get(part.getSubmittedFileName()).getFileName().toString(); if
			 * (!Files.exists(Paths.get(realPath))) {
			 * Files.createDirectory(Paths.get(realPath)); } part.write(realPath + "/" +
			 * filename);
			 * 
			 * userModel.setImages(filename);
			 */
			String image = req.getParameter("images");
			userModel.setUserName(username);
			userModel.setFullName(fullname);
			userModel.setEmail(email);
			userModel.setPassword(password);
//			userModel.setImages(filename);
			userModel.setImages(image);
			String alertMsg = "";
			if (password.length()<8) {
//				alertMsg="please fill in the blanks";
				req.setAttribute("alert", "Password must be at least 8 characters");
				RequestDispatcher rd = req.getRequestDispatcher("/views/admin/user-detail.jsp");//chuyên trang mang theo dư lieu
				rd.forward(req, resp);
//				req.getRequestDispatcher("/views/admin/user-detail.jsp").forward(req, resp);
				return;
			} else {
				userService.edit(userModel);
				resp.sendRedirect(req.getContextPath() + "/admin/user-management");
			}

		} catch (Exception e) {
			System.out.print(e);
		}

	}

}