package HaHuShoes.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.CommentModel;
import HaHuShoes.Service.iCommentService;
import HaHuShoes.Service.Impl.CommentServiceImpl;

@WebServlet(urlPatterns = {"/comment"})
@MultipartConfig()
public class CommentController  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	iCommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CommentModel comment = new CommentModel();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		try {
			String review= req.getParameter("review");
			String name = req.getParameter("name");
			String email= req.getParameter("email");
			
			comment.setReview(review);
			comment.setName(name);
			comment.setEmail(email);
			commentService.insert(comment);
			resp.sendRedirect(req.getContextPath() + "/shop-detail?productId="+id+"");
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		
	}

}

