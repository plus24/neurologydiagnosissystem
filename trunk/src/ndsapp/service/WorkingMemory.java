/**
 A <code>WorkingMemory</code> object represents a working 
 memory for a rule engine.
   
 @author      NDS Team
 @since       1.0 (24th December 2008)
 @version     1.0
 */
package ndsapp.service;

import java.util.ArrayList;

import ndsapp.domain.DiagnosisOption;

public class WorkingMemory {

	ArrayList<DiagnosisOption> facts;

	public WorkingMemory() {
		super();
		facts = new ArrayList<DiagnosisOption>();
	}
	public void addFact(DiagnosisOption sss){
		facts.add(sss);
	}
	public ArrayList<DiagnosisOption> getFacts() {
		return facts;
	}

	public void setFacts(ArrayList<DiagnosisOption> facts) {
		this.facts = facts;
	} 
}
