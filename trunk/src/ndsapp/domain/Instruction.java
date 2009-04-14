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

public class Instruction implements Serializable {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	private Integer nodeId;
	private String instruction;
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
}