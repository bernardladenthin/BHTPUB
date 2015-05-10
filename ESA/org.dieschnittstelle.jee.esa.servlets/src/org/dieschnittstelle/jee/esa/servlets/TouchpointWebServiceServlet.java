package org.dieschnittstelle.jee.esa.servlets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;

public class TouchpointWebServiceServlet extends HttpServlet {

	protected static Logger logger = Logger.getLogger(TouchpointWebServiceServlet.class);
	
	public TouchpointWebServiceServlet() {
		System.err.println("TouchpointWebServiceServlet: constructor invoked\n");
	}
	
	/**
	 * Obtain the executor for reading out the touchpoints from the servlet context using the touchpointCRUD attribute
	 * @return
	 */
	private TouchpointCRUDExecutor getTouchpointCRUDExecutor() {
		return (TouchpointCRUDExecutor) getServletContext().getAttribute("touchpointCRUD");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		logger.info("doGet()");
		// assume GET will only be used to return the list of all touchpoints
		
		TouchpointCRUDExecutor exec = getTouchpointCRUDExecutor();
		
		// set the status
		response.setStatus(HttpServletResponse.SC_OK);
		
		// write the touchpoints
		try {
			// obtain the output stream from the response and write the list of touchpoints into the stream
			ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream());
			// write the object
			oos.writeObject(exec.readAllTouchpoints());
			oos.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Override	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.info("doPost()");
		// assume POST will only be used for touchpoint creation, i.e. there is no need to check the uri that has been used
		
		TouchpointCRUDExecutor exec = getTouchpointCRUDExecutor();
		
		try {
			// create an ObjectInputStream from the request's input stream
			ObjectInputStream ois = new ObjectInputStream(request.getInputStream());
			
			// read an AbstractTouchpoint object from the stream
			AbstractTouchpoint readTouchPoint = (AbstractTouchpoint)ois.readObject();
			
			// call the create method on the executor and take its return value
			AbstractTouchpoint createdTouchPoint = exec.createTouchpoint(readTouchPoint);
			
			// set the response status as successful, using the appropriate constant from HttpServletResponse
			response.setStatus(HttpServletResponse.SC_OK);
			
			// then write the object to the response's output stream, using a wrapping ObjectOutputStream
			ObjectOutputStream oos = new ObjectOutputStream(response.getOutputStream());
			
			// ... and write the object to the stream
			oos.writeObject(createdTouchPoint);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		logger.info("doDelete()");
		// assume DELETE will only be used for touchpoint deletion
		
		TouchpointCRUDExecutor exec = getTouchpointCRUDExecutor();
		
		// the id for the touchpoint which should be deleted
		int id;
		
		// parse the id from the url
		try {
			String pathInfo = request.getRequestURL().toString();
			id = Integer.parseInt(pathInfo.substring(pathInfo.lastIndexOf("/") + 1));
		} catch (NumberFormatException e) {
			throw new RuntimeException(e);
		}
		
		logger.info("delete touchpoint with id " + id);
		
		boolean deleteSuccess = exec.deleteTouchpoint(id);
		
		if (deleteSuccess) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
