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

public class DeleteRuleController implements Controller {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private RuleDao rd;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nodeid = request.getParameter("nodeid");
		Map<String, Object> model = new LinkedHashMap<String, Object>();
		if(nodeid != null){
			int ruletobedeleted = Integer.parseInt(nodeid);
			
			if(ruletobedeleted <= 10){
				model.put("MessageToAdmin","Sorry, these are basic rules." );
				model.put("allRules", rd.getAllRules());
			}
			else if(rd.deleteRule(ruletobedeleted)){
				model.put("MessageToAdmin","Rule deleted." );
				model.put("allRules", rd.getAllRules());
			}
			else{
				model.put("MessageToAdmin","Rule could not be deleted." );
				model.put("allRules", rd.getAllRules());
			}
			
		}		
		return new ModelAndView("showrules", "model", model);
	}

	public RuleDao getRd() {
		return rd;
	}

	public void setRd(RuleDao rd) {
		this.rd = rd;
	}
}