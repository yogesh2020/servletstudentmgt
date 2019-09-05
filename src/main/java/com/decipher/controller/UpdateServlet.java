package com.decipher.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connObj = new Connection();
        DBCollection collection = connObj.getCollection();
        
        if(request.getParameter("button").equals("update")) {
	        int roll = Integer.parseInt(request.getParameter("roll"));  
	
			DBObject query = new BasicDBObject("Roll", roll);
			int count = collection.find(query).count(); 
			if(count==0){
				 response.sendRedirect("noresult.jsp");
			} else {
				HttpSession session = request.getSession();
	//	        session.setAttribute("MyAttribute", "test value");
				session.setAttribute("roll",roll);
				response.sendRedirect("updateform.jsp");
			}
        } else {
			HttpSession session = request.getSession();
        	DBObject query = new BasicDBObject("Roll", session.getAttribute("roll"));		
        	BasicDBObject document = new BasicDBObject();
        	document.put("Username", request.getParameter("username"));
        	document.put("Address",request.getParameter("address"));	
        	DBObject update = new BasicDBObject();
        	update.put("$set", document);	
        	collection.update(query, update);
        	response.sendRedirect("updated.jsp");
        }
//		doGet(request, response);
	}

}
