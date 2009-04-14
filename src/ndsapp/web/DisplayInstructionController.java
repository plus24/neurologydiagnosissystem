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
import ndsapp.service.HybridExpertSystem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DisplayInstructionController implements Controller {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private HybridExpertSystem es;
	private RuleDao rd;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String instructionId = request.getParameter("instructionid");
		Map<String, Object> model = new LinkedHashMap<String, Object>();
		if(instructionId != null){
			int instructionid = Integer.parseInt(instructionId);
			model.put("instructioninfo", rd.getInstruction(instructionid));
			model.put("instructionid", instructionid);
		}		
		return new ModelAndView("showinstruction", "model", model);
	}

	public HybridExpertSystem getEs() {
		return es;
	}

	public void setEs(HybridExpertSystem es) {
		this.es = es;
	}

	public RuleDao getRd() {
		return rd;
	}

	public void setRd(RuleDao rd) {
		this.rd = rd;
	}
}