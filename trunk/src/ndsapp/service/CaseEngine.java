/**
 A <code>RetrieveSimilarCases</code> defines the standard for
 finding similar cases.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.service;

import java.io.Serializable;
import java.util.ArrayList;

import ndsapp.domain.Case;

public interface CaseEngine extends Serializable {

	public ArrayList<Case> getCases(int caseId);
	public ArrayList<Case> getCases(Case newCase);
}