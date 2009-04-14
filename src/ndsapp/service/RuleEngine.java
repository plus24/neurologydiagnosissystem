/**
 A <code>RuleEngine</code> defines standard for a rule engine.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.service;

import java.io.Serializable;
import java.util.ArrayList;

import ndsapp.domain.DiagnosisOption;

public interface RuleEngine extends Serializable {

	public void processSelectedSignAndSymptom(DiagnosisOption diagnosisOption);
	public ArrayList<DiagnosisOption> getDiagnosisOptions();
	public ArrayList<DiagnosisOption> getDecisionTreePath();
	public String getDiagnosisInstruction();
}
