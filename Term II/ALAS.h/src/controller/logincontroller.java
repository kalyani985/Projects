package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.UserManager;
import biz.hTranManager;
import model.onloanitems;
import model.studtranhist;
import model.user;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/login/*")
public class logincontroller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5045678916273114707L;

	public logincontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		try {
			doProcess(req,resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		try {
			doProcess(req,resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String path = request.getPathInfo();
		System.out.println("PATH is " + path);
//		String message;
		ArrayList<onloanitems> tlist = new ArrayList<>();
		ArrayList<studtranhist> hlist = new ArrayList<>();
		hTranManager mgr = new hTranManager();
		HttpSession session = request.getSession();

		switch (path) {
		case "/validateuser": // check login validity of user name & password
			validateUser(request, response);	
			break;
		case "/logoutuser": // process logout of current user
			RequestDispatcher rd = processUserLogout(request, "Thank you for using ALAS");				
			rd.forward(request, response);
			break;
		case "/listonloanitems":
			if(session.getAttribute("loginUserID") != null) { // user logged in
				tlist = mgr.getOnLoanItems((String) session.getAttribute("loginUserID"));
				int tSize = tlist.size();
				request.setAttribute("tlist", tlist);
				request.setAttribute("tSize", tSize);
				rd = request.getRequestDispatcher("/studentviews/studentWelcomeScreen.jsp");	// H: done
			} else { // user not logged in
				rd = processUserLogout(request, "Please Login");
			}
			rd.forward(request, response);
			break;
		case "/studtranhist":
			if(session.getAttribute("loginUserID") != null) { // user logged in
				hlist = mgr.getStudTranHist((String) session.getAttribute("loginUserID"));
				request.setAttribute("hlist", hlist);
				rd = request.getRequestDispatcher("/studentviews/studentTransactionHistory.jsp");	// H: 
			} else { // user not logged in
				rd = processUserLogout(request, "Please Login");
			}
			rd.forward(request, response);
			break;
		case "/processUserLogout":
			rd = processUserLogout(request, (String) request.getAttribute("message"));
			rd.forward(request, response);
			break;
		default:
			break;
		} // switch (path)

	} // doProcess

	private void validateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		String id, password;
		
		id = request.getParameter("username");
		password = request.getParameter("password");
		
		UserManager mgr = new UserManager();
		user aUser = null;
		
		if(!id.isEmpty()) {
			aUser = mgr.retrieveOneUser(id);
			
			HttpSession session = request.getSession();
			
				if(aUser.getUser_password().matches(password)) { // user logged in
					if(aUser.getUser_status().matches("Inactive")) {
						rd = processUserLogout(request, "Inactive User. Please see the Librarian.");				
					} else {
						session.setAttribute("loginUserID", aUser.getUser_id());
						session.setAttribute("loginUserName", aUser.getUser_name());
						session.setAttribute("loginUserType", aUser.getUser_type());
									
						if(aUser.getUser_type().matches("Librarian")) { // Librarian User
							System.out.println("Librarian user id="+id);
							rd = request.getRequestDispatcher("/views/itemsearch.jsp");					
						} else { // Student User
							System.out.println("Student user id="+id);
							rd = request.getRequestDispatcher("/login/listonloanitems");	// H: done
						}
					}
				} else { // user not logged in
					rd = processUserLogout(request, "Login Failed");				
				}
			
		} else {
			rd = processUserLogout(request, "Please fill in a valid UserID");							
		}

		rd.forward(request, response);
	}

	private RequestDispatcher processUserLogout(HttpServletRequest request, String message) {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		session.setAttribute("loginUserID", null);
		session.setAttribute("loginUserName", null);
		session.setAttribute("loginUserType", null);
		request.setAttribute("message", message);
		rd = request.getRequestDispatcher("/Login.jsp");
		return rd;
	}

}
