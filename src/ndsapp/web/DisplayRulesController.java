/**
 A <code>CaseFormController</code> object represents a page controller
 that handles the form to insert or modify a case.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.web;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ndsapp.repository.RuleDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DisplayRulesController implements Controller {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private RuleDao rd;
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> model = new LinkedHashMap<String, Object>();
		
		String showAllRules = request.getParameter("allrules");
						
		if(showAllRules!=null && showAllRules.equals("true")){
			model.put("allRules", rd.getAllRules());
		}
		
		return new ModelAndView("showrules", "model", model);
	}

	public void setRd(RuleDao rd) {
		this.rd = rd;
	}
}