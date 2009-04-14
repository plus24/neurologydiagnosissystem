/**
 A <code>CaseFormController</code> object represents a page controller
 that handles the form to insert or modify a case.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ndsapp.domain.AdminFormData;
import ndsapp.domain.Case;
import ndsapp.repository.CaseDao;
import ndsapp.repository.RuleDao;
import ndsapp.service.NearestNeighborRetrieveSimilarCases;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class AdminFormController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private CaseDao cd;
	private RuleDao rd;
	private NearestNeighborRetrieveSimilarCases rc;

	@SuppressWarnings("unchecked")
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws ServletException {

		// logger.info(" admin for controller called.");
		AdminFormData admin = (AdminFormData) command;
		Map model = new HashMap();
		String returnurl = "adminview";

		Integer recentCaseId = new Integer(cd.getMaxCaseId());
		model.put("MostRecentCaseId", recentCaseId.toString());

		if (admin.getCaseId()!=null && admin.getCaseId() > 0) {
			ArrayList<Case> caserequested = null;
			if (cd.getCase(admin.getCaseId()) == null) {
				System.out.println("no case found.");
				returnurl = "home";
				model.put("MessageToAdmin", "Sorry, no such case was found.");
			} else {
				caserequested = new ArrayList<Case>();
				caserequested.add(cd.getCase(admin.getCaseId()));
			}
			model.put("casesToBeDisplayed", caserequested);
		}

		else if (admin.getNumberOfSimilarCasesToDisplay()!=null && admin.getNumberOfSimilarCasesToDisplay() > 0) {
			rc.setNumberOfSimilarCasesToBeReturned(admin.getNumberOfSimilarCasesToDisplay());
			returnurl = "home";
			model.put("MessageToAdmin", "Now "+admin.getNumberOfSimilarCasesToDisplay()+" cases will be displayed as similar cases.");			
		}

		else if(admin.getRuleId()!=null && admin.getRuleId() > -1){
			model.put("allRules", rd.getRules(admin.getRuleId(),true));
			returnurl = "showrules";			
		}
		
		else if (admin.getNodeId() > 0) {
			model.put("instruction", rd.getInstruction(admin.getNodeId()));
		}

		return new ModelAndView(returnurl, "model", model);
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {
		logger.info(" form backing");
		AdminFormData backupadminactivities = new AdminFormData();
		backupadminactivities.setUsername("username");
		backupadminactivities.setPassword("password");

		return backupadminactivities;
	}

	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {
		logger.info(" reference data.");
		Map<String, Object> referenceDataMap = new LinkedHashMap<String, Object>();
		referenceDataMap.put("recentcaseid", cd.getMaxCaseId());
		return referenceDataMap;
	}

	public CaseDao getCd() {
		return cd;
	}

	public void setCd(CaseDao cd) {
		this.cd = cd;
	}

	public RuleDao getRd() {
		return rd;
	}

	public void setRd(RuleDao rd) {
		this.rd = rd;
	}

	public NearestNeighborRetrieveSimilarCases getRc() {
		return rc;
	}

	public void setRc(NearestNeighborRetrieveSimilarCases rc) {
		this.rc = rc;
	}
}

