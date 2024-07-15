package in.srivath.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.srivath.dao.UserDao;
import in.srivath.dto.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserDao dao = new UserDao();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String email = req.getParameter("email");
		String password = req.getParameter("pwd");
		User user = dao.getUser(email);
		PrintWriter pWriter = resp.getWriter();
		if (user != null && user.getPwd().equals(password)) {
			if (user.getRole().equals("student")) {
				RequestDispatcher rd1 = req.getRequestDispatcher("StudentDashboard");
				rd1.forward(req, resp);
//				pWriter.append("<h1>Hello, Welcome to our application.</h1>");
//				pWriter.append("<a href=\"index.html\"> Logout </a>");
			} else if (user.getRole().equals("faculty")) {
				RequestDispatcher rd2 = req.getRequestDispatcher("FacultyDashboard");
				rd2.forward(req, resp);
//				pWriter.append("<h1>Invalid Credentials. Try Again!</h1>");
			}
		} else {
//			resp.sendRedirect("<h1>Invalid Credentials. Try Again!</h1>");
			pWriter.append("<h1>Invalid Credentials. Try Again!</h1>");
		}
	}
}
