package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import pojos.Simple;

public class SimpleModel {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	
	public SimpleModel(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	
	public void fetchValues(){
		
	session = request.getSession(true);
	//String message = request.getParameter("message");
	String firstName = request.getParameter("first_name");
	String lastName = request.getParameter("last_name");
	String instId = request.getParameter("instrument_id");
	String dob = request.getParameter("dob");
	//String sessEx = request.getParameter("first_name");
	Simple simple = (Simple)session.getAttribute("simple");
	
	System.out.println(simple);
	System.out.println("firstName -- "+firstName);
	
		if(simple == null) {
			simple = new Simple(1, "NEW" );
			//simple.setSessEx(firstName);
		}
		//simple.setMessage(message);
		simple.setFirstName(firstName);
		simple.setLastName(lastName);
		simple.setInstId(instId);
		simple.setDob(dob);
		session.setAttribute("simple", simple);
		writeToDB();
	
	}
	
	public void writeToDB(){
		System.out.println("Inside writeToDB -- "+request.getParameter("first_name"));
		Simple simple = (Simple) session.getAttribute("simple");
		String firstName=simple.getFirstName();
		String lastName=simple.getLastName();
		String instId=simple.getInstId();
		String dob=simple.getDob();
		DataSource ds = null;
		Context ctx = null;
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
		        String strDSName = "java:jboss/datasources/MySqlDS";
		        ctx = new InitialContext();
		        ds = (javax.sql.DataSource) ctx.lookup(strDSName);
		        conn = ds.getConnection();
		        conn.setAutoCommit(false);
		        stmt = conn.createStatement();
		        
		        sql = "insert into account_detail "
		        		+ "(first_name, last_name, instrument_id, dob) "
		        		+ " values "
		        		+ "('"+firstName+"','"+lastName+"','"+instId+"','"+dob+"')";
		        stmt.executeUpdate(sql);
		        System.out.println("Inserted records into the table...");
		        System.out.println("Commiting data here....");
		        conn.commit();

		        
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		
	}

}
