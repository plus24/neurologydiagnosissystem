/**
 A <code>CaseFormController</code> object represents a page controller
 that handles the form to insert or modify a case.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ndsapp.domain.Rule;
import ndsapp.repository.RuleDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AddRuleFormController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private RuleDao rd;

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws ServletException {

		// logger.info(" add rule form controller called.");
		Rule newrule = (Rule) command;
		Map<String, String> model = new HashMap<String, String>();
		if (newrule != null) {
			rd.putRule(newrule);
			model.put("MessageToAdmin", "New Rule added successfully.");
		}
		return new ModelAndView("home", "model", model);
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {

		Rule newrule = new Rule();
		String nodeid = request.getParameter("nodeid");
		if (nodeid != null && nodeid.length() > 0) {
			int nodeId = Integer.parseInt(nodeid);
			if (nodeId > -1) {
				String nodeinfo = rd.codeResolver(nodeId);
				newrule.setIfcode(nodeId);
				newrule.setIftext(nodeinfo);
			}
		}
		return newrule;
	}

	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		logger.info(" reference data.");
		Map<String, Object> referenceDataMap = new LinkedHashMap<String, Object>();
		return referenceDataMap;
	}

	public RuleDao getRd() {
		return rd;
	}

	public void setRd(RuleDao rd) {
		this.rd = rd;
	}
}
