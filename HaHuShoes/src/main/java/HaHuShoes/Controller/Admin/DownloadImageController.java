package HaHuShoes.Controller.Admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet(urlPatterns = {"/image"})
public class DownloadImageController {
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
		{
			String fileName = req.getParameter("fname");
			File file = new File("uploads" + "/" + fileName);
			resp.setContentType("image/jpeg");
			if (file.exists())
			{
				IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
			}
		}

	

}
