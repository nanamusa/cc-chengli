package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;

/**
 * Servlet implementation class loginService
 */
@WebServlet("/back_end/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("承利保經後台 - 登入 Login Servlet ...");

		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String upwd = "";

		Admin _admin = new Admin();
		try {
			_admin = dao.AdminDAO.getByUid(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		upwd = _admin.getUpwd();

		if (upwd == null || !password.equals(upwd)) {
			// login error: can't find the user.
			response.sendRedirect("login.html");
			System.out.println("登入錯誤： Sorry, username or password error!");
		} else {
			// login success!
			System.out.println("get upwd: " + upwd);

			HttpSession session = request.getSession();
			session.setAttribute("name", name);

			response.sendRedirect("./admin.jsp");
			System.out.println("登入成功！ login successful. ");
		}
	}

}
