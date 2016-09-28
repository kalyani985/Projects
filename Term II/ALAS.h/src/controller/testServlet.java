package controller;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StudentController
 */
@WebServlet("/student/*")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public testServlet() {
        // TODO Auto-generated constructor stub
    	System.out.println("hi hi");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		System.out.println("PATH is" + path);
		//PrintWriter out = response.getWriter();
		//out.println("HHHHH");
		RequestDispatcher rd = null;
		switch (path) {
		case "/list":
			rd = request.getRequestDispatcher("/CRUDStudents.jsp");
			rd.forward(request, response);	
			break;
		case "/add":
			rd = request.getRequestDispatcher("/student/list");
			rd.forward(request, response);	
			break;
		case "/show":
			rd = request.getRequestDispatcher("/SetupStudent.jsp");
			rd.forward(request, response);	
			break;
		case "/delete":
			rd = request.getRequestDispatcher("/student/list");
			rd.forward(request, response);	
			break;	
	
		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doProcess(request, response);
	}
	
	 

}
