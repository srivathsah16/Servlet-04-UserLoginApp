package in.srivath.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FacultyDashboard")
public class FacultyDashboard extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter pWriter = resp.getWriter();
		pWriter.append("<h1>Welcome This is FacultyDashboard Under construction! </h1>\"");
	}
}
