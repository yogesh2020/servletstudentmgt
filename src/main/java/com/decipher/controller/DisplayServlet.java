package com.decipher.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
/*import com.mongodb.DBObject;*/

/*import collectionpackage.Student;*/

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection connObj = new Connection();
		DBCollection collection = connObj.getCollection();

		DBCursor cursor = collection.find();
		ArrayList<Employee> emplist = new ArrayList<Employee>();

						
		while (cursor.hasNext()) {
			  DBObject empDBObject = cursor.next();	 
			  Employee employee = new Employee();			  
			  employee.setUsername(empDBObject.get("Username").toString());
			  employee.setAddress(empDBObject.get("Address").toString());
			  employee.setRollNumber(empDBObject.get("Roll").toString());
			  emplist.add(employee);
		}
		HttpSession session =  request.getSession();
		session.setAttribute("employeeList",emplist);
		response.sendRedirect("display.jsp");


		/*
		 * for(Employee empp: emplist) { System.out.println(empp); }
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
