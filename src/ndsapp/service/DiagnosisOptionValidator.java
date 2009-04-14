/**
 A <code>DiagnosisOptionValidator</code> object validates the case 
 received as the form data.
  
 @author      NDS Team
 @since       1.0 (24th December 2008)
 @version     1.0
 */

package ndsapp.service;

import ndsapp.domain.DiagnosisOption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DiagnosisOptionValidator implements Validator {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return DiagnosisOption.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {

		DiagnosisOption doption = (DiagnosisOption) obj;
		if (doption == null) {
			errors.rejectValue("optionCode", "error.not-specified", null,
					"Value required.");
		}
	}
}