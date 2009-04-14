/**
 A <code>CaseFormController</code> object represents a page controller
 that handles the form to insert or modify a case.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ndsapp.domain.Case;
import ndsapp.repository.CaseDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DisplaySingleCaseController implements Controller {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private CaseDao cd;
	
	@SuppressWarnings("unchecked")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> model = new LinkedHashMap<String, Object>();
		String returnurl = "adminview";
		String caseid = request.getParameter("caseid");
						
		if(caseid!=null && caseid.length()>0){
			int caseId = Integer.parseInt(caseid);
			ArrayList<Case> caserequested = null;
			if (cd.getCase(caseId) == null) {
				System.out.println("no case found.");
				returnurl = "home";
				model.put("MessageToAdmin", "Sorry, no such case was found.");
			} else {
				caserequested = new ArrayList<Case>();
				caserequested.add(cd.getCase(caseId));
			}
			model.put("casesToBeDisplayed", caserequested);			
		}
		
		return new ModelAndView(returnurl, "model", model);
	}

	public CaseDao getCd() {
		return cd;
	}

	public void setCd(CaseDao cd) {
		this.cd = cd;
	}
}