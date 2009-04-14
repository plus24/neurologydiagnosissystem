/**
 A <code>CaseValidator</code> object validates the case 
 received as the form data.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.service;

import ndsapp.domain.Instruction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class InstructionValidator implements Validator {

	protected final Log logger = LogFactory.getLog(getClass());

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Instruction.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {

		logger.info("NDS: validate method of admin data validator invoked.");
		Instruction c = (Instruction) obj;

		if (c.getInstruction() == null) {
			errors.rejectValue("instruction", "error.not-specified", null,
					"Value required.");
		}			
	}
}