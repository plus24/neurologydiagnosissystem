/**
 A <code>CaseFormController</code> object represents a page controller
 that handles the form to insert or modify a case.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ndsapp.domain.Instruction;
import ndsapp.repository.RuleDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class UpdateInstructionFormController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private RuleDao rd;

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws ServletException {

		Instruction c = (Instruction) command;

		Map<String, Object> model = new LinkedHashMap<String, Object>();

		if (c != null) {
			rd.updateInstruction(c.getNodeId(), c.getInstruction());
			model.put("instructioninfo", rd.getInstruction(c.getNodeId()));
			model.put("instructionid", c.getNodeId());
		}
		return new ModelAndView("showinstruction","model",model);
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {

		Instruction newins = new Instruction();

		String instructionId = request.getParameter("instructionid");

		if (instructionId != null) {
			int instructionid = Integer.parseInt(instructionId);
			newins.setNodeId(instructionid);
			newins.setInstruction(rd.getInstruction(instructionid));
		}
		return newins;
	}

	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {

		return null;
	}

	public RuleDao getRd() {
		return rd;
	}

	public void setRd(RuleDao rd) {
		this.rd = rd;
	}

}