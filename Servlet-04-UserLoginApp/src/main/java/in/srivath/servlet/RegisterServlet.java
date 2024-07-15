package in.srivath.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.srivath.dao.UserDao;
import in.srivath.dto.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private User user = new User();
	private UserDao dao = new UserDao();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		user.setFname(req.getParameter("fname"));
		user.setLname(req.getParameter("lname"));
		user.setEmail(req.getParameter("email"));
		user.setPwd(req.getParameter("pwd"));
		user.setGender(req.getParameter("gender"));
		user.setRole(req.getParameter("role"));
		Boolean bool = dao.saveUser(user);
		PrintWriter writer = resp.getWriter();
		if (bool) {
			writer.append("<h1>Registration Successful</h1>");
			writer.append("<a href=\"index.html\">Click here to Login</a>");
		}else {
			writer.append("<h1>Registration Failed</h1>");
		}
	}
}
