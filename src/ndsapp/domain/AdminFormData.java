/**
 A <code>Case</code> object represents a patient's case
 which holds all the information of the patient including all the symptoms.

 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     3.0
 */

package ndsapp.domain;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AdminFormData implements Serializable {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	private Integer caseId;
	private Integer ruleId;
	private Integer nodeId;
	private String username;
	private String password;
	private Integer numberOfSimilarCasesToDisplay;
	
	
	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getNumberOfSimilarCasesToDisplay() {
		return numberOfSimilarCasesToDisplay;
	}
	public void setNumberOfSimilarCasesToDisplay(
			Integer numberOfSimilarCasesToDisplay) {
		this.numberOfSimilarCasesToDisplay = numberOfSimilarCasesToDisplay;
	}
}