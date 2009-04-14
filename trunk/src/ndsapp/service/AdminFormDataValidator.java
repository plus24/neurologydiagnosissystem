/**
 A <code>CaseValidator</code> object validates the case 
 received as the form data.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.service;

import ndsapp.domain.AdminFormData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AdminFormDataValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return AdminFormData.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {

		logger.info("NDS: validate method of admin data validator invoked.");
		AdminFormData c = (AdminFormData) obj;

		if (c != null) {
			if (c.getCaseId() == null
					&& c.getNumberOfSimilarCasesToDisplay() == null) {
				errors.rejectValue("numberOfSimilarCasesToDisplay",
						"error.invalid-input", null, "Please enter a value.");
			} else {
				if(c.getCaseId() != null && c.getCaseId() < 1) {
					errors.rejectValue("numberOfSimilarCasesToDisplay",
							"error.invalid-input", null, "Invalid case id."); 
				
				} else if(c.getNumberOfSimilarCasesToDisplay() != null
						&& c.getNumberOfSimilarCasesToDisplay() < 1) {
					errors.rejectValue("numberOfSimilarCasesToDisplay",
							"error.invalid-input", null, "Invalid number of similar cases.");
				}
			}
		}
	}
}