package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.jasper.tagplugins.jstl.core.Out;
import javax.servlet.http.HttpSession;

import biz.TransactionManager;
import biz.itemManager;
//import biz.UserManager;
//import model.user;
import model.Items;
import model.Transaction;
//import model.onloanitems;

/**
 * Servlet implementation class itemcontroller
 */
@WebServlet("/item/*")
public class itemcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public itemcontroller() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		try {
			doProcess(request, response);
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
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();
		RequestDispatcher rd = null;

		if (session.getAttribute("loginUserID") != null) { // user logged in
			String path = request.getPathInfo();
			System.out.println("PATH is " + path);
			// PrintWriter out = response.getWriter();
			// out.println("HHHHH");
			itemManager mgr = new itemManager();
			String str = request.getParameter("item_text"); // H: what is this
															// for?

			Items item = new Items();
			ArrayList<Items> list = new ArrayList<Items>();
			String studid, stid, itemid, str1, errorMsg = null;
			TransactionManager mgrt = new TransactionManager();
			Transaction trans = new Transaction();
			Calendar c = Calendar.getInstance();
			Date duedate, issuedate;
			ArrayList<Transaction> translist = new ArrayList<Transaction>();
			int transid;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			long fine = 0;
			int result;
			String fineMsg = null;

			switch (path) {
			case "/search":
				System.out.println("in /search");

				if ((request.getParameter("radioitem") != null) && (!str.isEmpty())) {
					System.out.println("1 if loop ");
					if ((request.getParameter("radioitem")).equals("category")) {
						// item.setItem_category(request.getParameter("item_text"));
						System.out.println("2 if loop");
						System.out.println(str);

						ArrayList<Items> itemlist = mgr.SearchByCategory(str);
						request.setAttribute("itemlist", itemlist);
						System.out.println(itemlist);
						if (itemlist.isEmpty()) {
							request.setAttribute("errMsg", "No items of this category is found");
							rd = request.getRequestDispatcher("/views/error.jsp");
							rd.forward(request, response);
						} else {
							rd = request.getRequestDispatcher("/views/sItemResult.jsp");
							rd.forward(request, response);
						}

					}

					else if ((request.getParameter("radioitem")).equals("item_id")) {
						System.out.println("id if loop");
						// String item_id=request.getParameter("item_text");
						item = (Items) mgr.getItem(str);

						list.add(item);
						System.out.println("after manager");
						request.setAttribute("itemlist", list);
						System.out.println(item);
						if (list.isEmpty()) {
							request.setAttribute("errMsg", "No items of this itemID is found");
							rd = request.getRequestDispatcher("/views/error.jsp");
							rd.forward(request, response);
						} else {
							rd = request.getRequestDispatcher("/views/sItemResult.jsp");
							rd.forward(request, response);
						}
					}

					else if ((request.getParameter("radioitem")).equals("title")) {
						item.setItem_title(request.getParameter("item_text"));
						ArrayList<Items> itemlist = mgr.SearchByItemTitle(str);
						request.setAttribute("itemlist", itemlist);
						if (itemlist.isEmpty()) {
							request.setAttribute("errMsg", "No items of this Title is found");
							rd = request.getRequestDispatcher("/views/error.jsp");
							rd.forward(request, response);

						} else {

							rd = request.getRequestDispatcher("/views/sItemResult.jsp");
							rd.forward(request, response);
						}

					} else if ((request.getParameter("radioitem")).equals("author")) {
						item.setItem_author(request.getParameter("item_text"));
						ArrayList<Items> itemlist = mgr.SearchByAuthor(str);
						request.setAttribute("itemlist", itemlist);
						if (itemlist.isEmpty()) {
							request.setAttribute("errMsg", "No items of this author is found");
							rd = request.getRequestDispatcher("/views/error.jsp");
							rd.forward(request, response);
						} else {
							rd = request.getRequestDispatcher("/views/sItemResult.jsp");
							rd.forward(request, response);
						}

					} else {
						System.out.println("hai error");
					}
				}
				break;
			case "/temp": // H: temporary only for testing
				System.out.println("in /temp");
				if (session.getAttribute("loginUserID") != null) {
					rd = request.getRequestDispatcher("/views/itemsearch.jsp");
				} else {
					request.setAttribute("message", "Please Login");
					rd = request.getRequestDispatcher("/Login.jsp");
				}
				rd.forward(request, response);
				break;
			case "/next":
				stid = request.getParameter("studentid");
				str1 = request.getParameter("brid");
				System.out.println("ssss" + stid);

				if ((!stid.isEmpty()) && (!str1.isEmpty())) {
					System.out.println("studid and brid ");
					item = mgr.getItem(str1);

					list.add(item);

//					if (!(list.contains(item))) {
						System.out.println("after manager");
						System.out.println(item);
						request.setAttribute("studentid", stid);

						request.setAttribute("itemid", item.getItem_id());
						request.setAttribute("itemtitle", item.getItem_title());
						request.setAttribute("itemcategory", item.getItem_category());
						request.setAttribute("itempublisher", item.getItem_publisher());
						request.setAttribute("itempublisheddate", item.getItem_date_of_purchase());
						request.setAttribute("isbn", item.getItem_ISBN());
						request.setAttribute("itemdescription", item.getItem_description());
						request.setAttribute("itemstatus", item.getItem_status());

						rd = request.getRequestDispatcher("/views/borrow1.jsp");
						rd.forward(request, response);
					//// } else {
					// System.out.println("RECORD NOT FOUND");
					// request.setAttribute("errMsg", "No Item Found");
					// rd = request.getRequestDispatcher("/views/error.jsp");
					// rd.forward(request, response);
					//// }
				} else
					System.out.println("DIDNT SELECT");
				request.setAttribute("errMsg", "Please enter Info requested");
				rd = request.getRequestDispatcher("/views/error.jsp");
				rd.forward(request, response);
				break;
			case "/inserttrans":

				studid = request.getParameter("studentid");
				// boritemid= request.getParameter("itemid");
				// System.out.println(boritemid);
				System.out.println(request.getParameter("itemid"));
				boolean t1 = mgrt.numberofRecord(studid);
				if (t1) {
					System.out.println(t1);

					System.out.println("trans insert");
					issuedate = c.getTime();
					c.add(Calendar.DATE, 29);
					duedate = c.getTime();

					System.out.println(duedate);
					trans.setUser_id(studid);
					System.out.println(studid);// studid;
					trans.setItem_id(request.getParameter("itemid"));
					// System.out.println(item1.getItem_id());
					trans.setTrans_details(request.getParameter("itemstatus"));
					trans.setItem_issue_date(issuedate);
					trans.setItem_due_date(duedate);

					// issuedate; c.setTime(issuedate);
					result = mgrt.createTransaction(trans);
					// mgrt.updateBStatus(boritemid);

					System.out.println(result);
					String output = "SUCCESSFULLY BORROWED";
					request.setAttribute("success", output);
					rd = request.getRequestDispatcher("/views/borrow1.jsp");
					rd.forward(request, response);

					// getItem(str1);
					// list.add(item);
					// System.out.println(str1);
					// System.out.println(item1);
					// request.setAttribute("blist", item1);
					// rd = request.getRequestDispatcher("/borrow1.jsp");
					// rd.forward(request, response);
				} else
					errorMsg = "ALREADY BORROWED 10 BOOKS";
				request.setAttribute("errorMsg", errorMsg);
				System.out.println("CANT BORROW ");
				rd = request.getRequestDispatcher("/views/borrow1.jsp");
				rd.forward(request, response);

				//
				// boolean t1 = mgrt.numberofRecord(studid);

				// Items item1 = mgr.getItem(str1);

				break;
			case "/nextcheck":
				stid = request.getParameter("studentid");
				System.out.println("ssss" + stid);
				if (!stid.isEmpty()) {
					translist = mgrt.selectOnloan(stid);
					System.out.println(translist);
					request.setAttribute("translist", translist);
					rd = request.getRequestDispatcher("/views/return.jsp");
					rd.forward(request, response);
				} else
					System.out.println("DIDNT GIVE USER ID");

				break;
			case "/return":
				transid = Integer.parseInt(request.getParameter("transid"));
				java.util.Date dueDate = null;
				System.out.println(transid);
				try {
					dueDate = sdf.parse(request.getParameter("transduedate"));
					System.out.println(dueDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("dueDate = " + dueDate);
				System.out.println(transid);

				java.util.Date date2 = new java.util.Date();
				java.sql.Date ReturnDate = new java.sql.Date(date2.getTime());
				java.util.Date actualReturnDate = new java.util.Date(date2.getTime());
				System.out.println(ReturnDate);
				System.out.println(actualReturnDate);
				if (ReturnDate.after(dueDate)) {
					System.out.println("Fine");

					long diff = actualReturnDate.getTime() - dueDate.getTime();
					fine = diff / (24 * 60 * 60 * 1000);
					fineMsg = "You have to pay $" + fine + " as fine!!!";
					System.out.println(fineMsg);
					System.out.println("Days = " + fine);

				} else {
					System.out.println("No Fine");
				}
				mgrt.returnItem(transid, actualReturnDate, fine);
				itemid = request.getParameter("itemid");
				System.out.println("Item id in controller->" + itemid);
				mgr.updateItemStatus(itemid);
				String successReturn = "Return Successfully";
				request.setAttribute("successReturn", successReturn);
				request.setAttribute("finemsg", fineMsg);
				rd = request.getRequestDispatcher("/views/returnSuccess.jsp");
				rd.forward(request, response);

				System.out.println("Return Successfully");

				break;
			case "/icreate":
				String new_id = mgr.generatedNewId();
				System.out.println(new_id);
				item.setItem_id(new_id);
				item.setItem_author(request.getParameter("author"));
				item.setItem_category(request.getParameter("category"));
				item.setItem_description(request.getParameter("description"));
				item.setItem_ISBN(request.getParameter("isbn"));
				item.setItem_published_year(Integer.parseInt(request.getParameter("published_year")));
				item.setItem_status("AVAILABLE");
				item.setItem_publisher(request.getParameter("publisher"));
				item.setItem_title(request.getParameter("title"));
				System.out.println("read JSP data");
				result = mgr.createItem1(item);
				System.out.println(result);
				ArrayList<Items> list2 = mgr.findAllItems1();
				request.setAttribute("ilist", list2);
				rd = request.getRequestDispatcher("/views/listItems.jsp");
				rd.forward(request, response);
				// rd = request.getRequestDispatcher("/item/idisplay");
				// rd.forward(request, response);
				break;
			case "/idisplay":
				rd = request.getRequestDispatcher("/views/listItems.jsp");
				rd.forward(request, response);
				break;
			case "/updateitem":
				rd = request.getRequestDispatcher("/views/updateItem.jsp");
				rd.forward(request, response);
				break;
			case "/iedit":
				if (request.getParameter("itemEdit").equals("UPDATE")) {
					item.setItem_id(request.getParameter("item_id"));
					item.setItem_author(request.getParameter("author"));
					item.setItem_category(request.getParameter("category"));
					item.setItem_title(request.getParameter("title"));
					item.setItem_publisher(request.getParameter("publisher"));
					item.setItem_ISBN(request.getParameter("isbn"));
					item.setItem_description(request.getParameter("description"));
					result = mgr.updateItems(item);
					System.out.println(result);
				} else if (request.getParameter("itemEdit").equals("DEACTIVATE")) {
					item.setItem_id(request.getParameter("item_id"));
					result = mgr.deactivateItem(item);
					System.out.println(result);
				}

				ArrayList<Items> list1 = mgr.findAllItems1();
				request.setAttribute("ilist", list1);
				rd = request.getRequestDispatcher("/item/idisplay");
				rd.forward(request, response);

				break;
			case "/show_ihistory":

				String item_id = request.getParameter("item_id");
				System.out.println("point 1");
				TransactionManager tmgr = new TransactionManager();
				ArrayList<Transaction> tlist = tmgr.TransactionByItem(item_id);
				System.out.println("point 2");
				request.setAttribute("translist", tlist);
				System.out.println(tlist);
				rd = request.getRequestDispatcher("/views/itemhistory.jsp");
				rd.forward(request, response);
				break;
			case "/usearch":
				System.out.println("in /usearch");

				if ((request.getParameter("radioitem") != null) && (!str.isEmpty())) {
					System.out.println("1 if loop ");
					if ((request.getParameter("radioitem")).equals("category")) {
						// item.setItem_category(request.getParameter("item_text"));
						System.out.println("2 if loop");
						System.out.println(str);

						ArrayList<Items> itemlist = mgr.SearchByCategory(str);
						request.setAttribute("itemlist", itemlist);
						System.out.println(itemlist);
						if (itemlist.isEmpty()) {
							request.setAttribute("errMsg", "No items of this category is found");
							rd = request.getRequestDispatcher("/studentviews/error.jsp");
							rd.forward(request, response);
						} else {
							rd = request.getRequestDispatcher("/studentviews/StudItemResult.jsp");
							rd.forward(request, response);
						}

					} else if ((request.getParameter("radioitem")).equals("item_id")) {
						System.out.println("id if loop");
						// String item_id=request.getParameter("item_text");
						item = (Items) mgr.getItem(str);

						list.add(item);
						System.out.println("after manager");
						request.setAttribute("itemlist", list);
						System.out.println(item);
						if (!list.contains(item)) {
							request.setAttribute("errMsg", "No items of this itemID is found");
							rd = request.getRequestDispatcher("/studentviews/error.jsp");
							rd.forward(request, response);
						} else {
							rd = request.getRequestDispatcher("/studentviews/StudItemResult.jsp");
							rd.forward(request, response);
						}
					} else if ((request.getParameter("radioitem")).equals("title")) {
						item.setItem_title(request.getParameter("item_text"));
						ArrayList<Items> itemlist = mgr.SearchByItemTitle(str);
						request.setAttribute("itemlist", itemlist);
						if (itemlist.isEmpty()) {
							request.setAttribute("errMsg", "No items of this Title is found");
							rd = request.getRequestDispatcher("/studentviews/error.jsp");
							rd.forward(request, response);
						} else {
							rd = request.getRequestDispatcher("/studentviews/StudItemResult.jsp");
							rd.forward(request, response);
						}

					} else if ((request.getParameter("radioitem")).equals("author")) {
						item.setItem_author(request.getParameter("item_text"));
						ArrayList<Items> itemlist = mgr.SearchByAuthor(str);
						request.setAttribute("itemlist", itemlist);
						if (itemlist.isEmpty()) {
							request.setAttribute("errMsg", "No items of this author is found");
							rd = request.getRequestDispatcher("/studentviews/error.jsp");
							rd.forward(request, response);
						} else {
							rd = request.getRequestDispatcher("/studentviews/StudItemResult.jsp");
							rd.forward(request, response);
						}

					}
				} else {
					System.out.println("hai error");
				}

				break;
			case "/uinserttrans":
				issuedate = c.getTime();
				// studid = request.getParameter("studentid"); //Hot Code
				studid = (String) session.getAttribute("loginUserID");
				System.out.println(request.getParameter("itemid"));
				boolean t2 = mgrt.numberofRecord(studid);
				if (t2) {
					System.out.println(t2);
					mgr.updateBStatus(request.getParameter("itemid"));

					System.out.println("trans insert");
					c.add(Calendar.DATE, 29);
					duedate = c.getTime();

					System.out.println(duedate);
					trans.setUser_id(studid);
					System.out.println(studid);
					trans.setItem_id(request.getParameter("itemid"));
					trans.setTrans_details(request.getParameter("itemstatus"));
					trans.setItem_issue_date(issuedate);
					trans.setItem_due_date(duedate);

					result = mgrt.createTransaction(trans);

					System.out.println(result);
					String output = "SUCCESSFULLY BORROWED";
					request.setAttribute("success", output);
					rd = request.getRequestDispatcher("/studentviews/StudItemResult.jsp");
					rd.forward(request, response);

				} else
					errorMsg = "ALREADY BORROWED 10 BOOKS";

				request.setAttribute("errorMsg", errorMsg);
				System.out.println("CANT BORROW ");
				rd = request.getRequestDispatcher("/studentviews/StudItemResult.jsp");
				rd.forward(request, response);

				break;
			case "/teststudentreturn":
				int aTransID = Integer.parseInt(request.getParameter("transid"));
				String aItemID = request.getParameter("itemid");
				String aTransDetails = request.getParameter("transdetails");
				String aTransDueDate = request.getParameter("transduedate");
				System.out.println("aTransID=" + aTransID + " aItemID=" + aItemID + " aTransDetails=" + aTransDetails
						+ " aTransDueDate=" + aTransDueDate);
			case "/stdreturn":
				transid = Integer.parseInt(request.getParameter("transid"));
				java.util.Date dueDate1 = null;
				System.out.println(transid);
				try {
					dueDate1 = sdf.parse(request.getParameter("transduedate"));
					System.out.println(dueDate1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("dueDate = " + dueDate1);
				System.out.println(transid);

				java.util.Date date3 = new java.util.Date();
				java.sql.Date ReturnDate1 = new java.sql.Date(date3.getTime());
				java.util.Date actualReturnDate1 = new java.util.Date(date3.getTime());
				System.out.println(ReturnDate1);
				System.out.println(actualReturnDate1);
				if (ReturnDate1.after(dueDate1)) {
					System.out.println("Fine");

					long diff = actualReturnDate1.getTime() - dueDate1.getTime();
					fine = diff / (24 * 60 * 60 * 1000);
					fineMsg = "You have to pay $" + fine + " as fine!!!";
					System.out.println(fineMsg);
					System.out.println("Days = " + fine);

				} else {
					System.out.println("No Fine");
				}
				mgrt.returnItem(transid, actualReturnDate1, fine);
				// trans=mgrt.getRecord(transid);
				itemid = request.getParameter("itemid");
				System.out.println("Item id in controller->" + itemid);
				// String userid=request.getParameter("studentid");
				// request.setAttribute("user", userid);
				// System.out.println("Second Time "+userid);
				trans.setItem_id(request.getParameter("item_id"));
				// trans.setItem_due_date(java.util.Date(request.getParameter("item_due_date")));
				mgr.updateItemStatus(itemid);
				String successReturn1 = "Return Successfully";

				request.setAttribute("fineamt", fineMsg);
				// request.setAttribute(arg0, arg1);

				request.setAttribute("successReturn", successReturn1);
				rd = request.getRequestDispatcher("/item/nextcheck1");
				rd.forward(request, response);

				System.out.println("Return Successfully");

				break;
			case "/nextcheck1":
				stid = (String) session.getAttribute("loginUserID");

				System.out.println("ssss" + stid);
				if (!stid.isEmpty()) {
					translist = mgrt.selectOnloan(stid);
					System.out.println(translist);
					request.setAttribute("translist", translist);
					rd = request.getRequestDispatcher("/studentviews/StudentReturn.jsp");
					rd.forward(request, response);
				} else
					System.out.println("DIDNT GIVE USER ID");

				break;
			default:
				break;
			}
		} else { // user not logged in
			request.setAttribute("message", "Please Login");
			rd = request.getRequestDispatcher("/login/processUserLogout");
			rd.forward(request, response);
		} // if(session.getAttribute("loginUserID") != null)
	}

}
