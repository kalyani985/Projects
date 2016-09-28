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
import model.studtranhist;
import model.user;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserDetails/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		

		if (session.getAttribute("loginUserID") != null) { // user logged in
			String path = request.getPathInfo();
			System.out.println("PATH is " + path);
			UserManager mgr = new UserManager();
			hTranManager hmgr = new hTranManager();
			String id = null;
			user result = new user();

			ArrayList<studtranhist> hlist = new ArrayList<>();
			ArrayList<user> userList = null;
			
			switch (path) {
			case "/list":
				userList = mgr.listAll();
				request.setAttribute("ulist", userList);
				rd = request.getRequestDispatcher("/views/list.jsp");
				rd.forward(request, response);
				break;

			case "/create":
				boolean boolCreateOK = false;

				String password = request.getParameter("password");
				int intPasswordLength = password.length();
				if (intPasswordLength > 6) {
					password = password.substring(0, 5);
				}

				result = new user();
				result.setUser_id(request.getParameter("id"));
				result.setUser_name(request.getParameter("name"));
				result.setUser_address(request.getParameter("address"));
				result.setUser_contact(Integer.parseInt(request.getParameter("contact")));
				result.setUser_gender(request.getParameter("gender"));
				result.setUser_password(password);
				result.setUser_type(request.getParameter("userType"));
				result.setUser_status("Active");

				try {
					boolCreateOK = mgr.createNewUser(result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (boolCreateOK) {
					request.setAttribute("newUser", result);
					request.setAttribute("message", "Creation of new user <strong>successful</strong>!");
					rd = request.getRequestDispatcher("/views/createNewUserConfirm.jsp");
				} else {
					request.setAttribute("newUserID", result.getUser_id());
					request.setAttribute("newUserType", result.getUser_type());
					request.setAttribute("message", "Creation of <strong>new</strong> user failed! Please try again.");
					rd = request.getRequestDispatcher("/views/createNewUser.jsp");
				}
				rd.forward(request, response);
				break;

			case "/edit":
				id = request.getParameter("id");
				result = mgr.retrieveOneUser(id);
				request.setAttribute("user", result);
				rd = request.getRequestDispatcher("/views/maintainstudentprofile.jsp");
				rd.forward(request, response);
				break;
				
			case "/update":
				
				user u1 = new user();
				if (request.getParameter ("button").equals ("Update"))
				{
				u1.setUser_id(request.getParameter("idhidden"));			
				u1.setUser_name(request.getParameter("name"));
				u1.setUser_address(request.getParameter("address"));

			
				String a = request.getParameter("contact");
						if (a.length() != 8){
				
					String path5 = "/views/searchError.jsp";
					request.setAttribute("message5", "Please key in a <strong>local</strong> number (8 digits)");
					rd = request.getRequestDispatcher(path5);
					rd.forward(request, response);				
				}
						
						else {
					u1.setUser_contact( Integer.parseInt(request.getParameter("contact")));
					u1.setUser_gender( request.getParameter("gender"));
					u1.setUser_status(request.getParameter("status"));
					int upd1 = mgr.updateUser(u1);
					request.setAttribute("user", upd1);
					rd = request.getRequestDispatcher("/UserDetails/list");
					rd.forward(request, response);	
					break;	
					

			
				} }
				else if (request.getParameter("button").equals("Delete")) {
					result.setUser_id(request.getParameter("idhidden"));
					int del = mgr.deactivateUser(result);
					request.setAttribute("user", del);
					
					
					if (request.getParameter("status").equals("Inactive")){
						String path7 = "/views/searchError.jsp";
						request.setAttribute("message5", "User is already <strong>inactive</strong>. Please try again.");
						rd = request.getRequestDispatcher(path7);
						rd.forward(request, response);	
					}
					else{
						
					rd = request.getRequestDispatcher("/UserDetails/list");
					rd.forward(request, response);
					
					break;
					}
				} 
				else {
					String path5 = "/views/searchError.jsp";
					request.setAttribute("message1", "Error. Please try again.");
					rd = request.getRequestDispatcher(path5);
					rd.forward(request,response);	
				}
			
				break;
			case "/searchuser":
				
			if (request.getParameter("radioitem").equals("user_id")){
				
				
				ArrayList<user> userList1 = new ArrayList<user>();
				String id1 = request.getParameter("item_text");
				user u2 = new user();
				u2.setUser_id(id1);
				user search = mgr.retrieveByUserID(u2);
				userList1.add(search);			
				
						if (id1.isEmpty()) 
						{
					String path2 = "/views/searchError.jsp";
					request.setAttribute("message", "Error. Please key in a <strong>a</strong> user id.");
					rd = request.getRequestDispatcher(path2);
					rd.forward(request, response);
						}			
					
			
						else if (search.getUser_id()== null)
					{
							String path3 = "/views/searchError.jsp";
							request.setAttribute("message1", "Error. Please key in a <strong>valid</strong> user id.");
							rd = request.getRequestDispatcher(path3);
							rd.forward(request, response);
					} 
						else {				
							
							request.setAttribute("ulist", userList1);
							rd = request.getRequestDispatcher("/views/list.jsp");
							rd.forward(request, response);	
					}
					break;
				}
				else if (request.getParameter("radioitem").equals("user_name")) {
						
						String name1 = request.getParameter("item_text");
						result = new user();
						result.setUser_name(name1);
						userList = mgr.retrieveByName(result);

						request.setAttribute("ulist", userList);
						
						if (name1.isEmpty()){
							String path2 = "/views/searchError.jsp";
							request.setAttribute("message", "Error. Please key in <strong>a</strong> user name.");
							rd = request.getRequestDispatcher(path2);
							rd.forward(request,response);
						}
						else if (userList.isEmpty()){

							String path4 = "/views/searchError.jsp";
							request.setAttribute("message1", "Error. Please key in a <strong>valid</strong> user name.");
							rd = request.getRequestDispatcher(path4);
							rd.forward(request,response);		
							
						}
						else
						{					
							rd = request.getRequestDispatcher("/views/list.jsp");
							rd.forward(request, response);			
							
						}		
							
						break;

						
					} else {
						
						String path5 = "/views/searchError.jsp";
						request.setAttribute("message6", "Error. Please try again.");
						rd = request.getRequestDispatcher(path5);
						
					} 
				rd.forward(request, response);
				break;
				
			case "/newStudent":
				session.setAttribute("newUserType", "Student");
				rd = request.getRequestDispatcher("/UserDetails/getNewUserID");
				rd.forward(request, response);
				break;
			case "/newLibrarian":
				session.setAttribute("newUserType", "Librarian");
				rd = request.getRequestDispatcher("/UserDetails/getNewUserID");
				rd.forward(request, response);
				break;
			case "/getNewUserID":
				String newUserType = (String) session.getAttribute("newUserType");
				String newUserID = mgr.getNewUserId(newUserType);
				System.out.println(newUserID);
				request.setAttribute("newUserID", newUserID);
				request.setAttribute("newUserType", newUserType);
				request.setAttribute("message", "");
				rd = request.getRequestDispatcher("/views/createNewUser.jsp");
				rd.forward(request, response);
				break;
			case "/studtranhist":
				id = request.getParameter("h_id");
				System.out.println("id=" + id);
				hlist = hmgr.getStudTranHist(id);
				request.setAttribute("hlist", hlist);
				rd = request.getRequestDispatcher("/views/studentTransactionHistory.jsp"); // H:
				rd.forward(request, response);
				break;
			default:
				break;
			} // end switch(path)
		} else { // user not logged in
			request.setAttribute("message", "Please Login");
			rd = request.getRequestDispatcher("/login/processUserLogout");
			rd.forward(request, response);
		} // if(session.getAttribute("loginUserID") != null)

	} 

} // end UserController class
