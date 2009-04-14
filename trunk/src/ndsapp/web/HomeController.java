/**
 A <code>HomeController</code> object is a page controller that
 delivers the home page of the web-site.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ndsapp.repository.MySQLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomeController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private MySQLConnection dbconn;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		Map<String, String> model = new HashMap<String, String>();
		logger.info("Request for home controller received. Establishing db connection...");
		if(dbconn.connection == null){
			dbconn.getDatabaseConnection();
			model.put("MessageToAdmin","Database connection established.");
		}
		if(dbconn.getConnection()==null){
			model.put("MessageToAdmin","Database connection could not be established.");
		}
		
		return new ModelAndView("home","model", model);
	}

	public MySQLConnection getDbconn() {
		return dbconn;
	}

	public void setDbconn(MySQLConnection dbconn) {
		this.dbconn = dbconn;
	}

}
