package HaHuShoes.Controller.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/ValidateOtp")

public class ValidatePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int value = Integer.parseInt(request.getParameter("otp"));
		HttpSession session = request.getSession();
		int otp = (int) session.getAttribute("otp");

		RequestDispatcher dispatcher = null;

		if (value == otp) {

			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("/views/admin/new-password.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("message", "wrong otp");

			dispatcher = request.getRequestDispatcher("/views/admin/EnterOtp.jsp");
			dispatcher.forward(request, response);

		}

	}
}
