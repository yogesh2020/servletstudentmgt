package com.decipher.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;


/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {

        super();
		System.out.println("Continous");

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("this is Get method");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	//	System.out.println("Post");
	//	System.out.println("In Add Servlet");
   			String username= request.getParameter("username");  
	        String address = request.getParameter("address");  
	        int roll = Integer.parseInt(request.getParameter("roll"));  

	        Connection connObj = new Connection();
	        DBCollection collection = connObj.getCollection();
	        
	        BasicDBObject document = new BasicDBObject();
	    	document.put("Username", username);
	    	document.put("Address", address);
	    	document.put("Roll",roll);
	    	
	    	DBObject query = new BasicDBObject("Roll", roll);
			int count = collection.find(query).count();
			if(count>0){
				 response.sendRedirect("idexists.jsp");
			} else {
				collection.insert(document);
				 response.sendRedirect("datainsert.jsp");
			}
	}

}
