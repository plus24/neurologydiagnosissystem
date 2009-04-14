/**
 A <code>CaseValidator</code> object validates the case 
 received as the form data.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.service;

import ndsapp.domain.Case;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CaseValidator implements Validator {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private int minAge = 0;
	private int maxAge = 200;

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return Case.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {

		Case c = (Case) obj;

		if (c == null) {
			errors.rejectValue("firstName", "error.not-specified", null,
					"Case required.");
		} else {
			
			if (c.getCaseFirstName() == null) {
				errors.rejectValue("caseFirstName",
						"error.first-name-required", null,
						"First name required.");
			} else if (c.getCaseFirstName().length() < 2 ) {
				errors.rejectValue("caseFirstName", "error.invalid-first-name",
						null, "Invalid first name.");
			}
			else if (!validAlphabets(c.getCaseFirstName())) {
				errors.rejectValue("caseFirstName", "error.invalid-first-name",
						null, "Invalid first name.");
			}
			
			if (c.getCaseLastName() == null) {
				errors.rejectValue("caseLastName", "error.last-name-required",
						null, "Last name required.");
			} else if (c.getCaseLastName().length() < 2) {
				errors.rejectValue("caseLastName", "error.invalid-last-name",
						null, "Invalid last name.");
			}
			else if (!validAlphabets(c.getCaseLastName())) {
				errors.rejectValue("caseLastName", "error.invalid-last-name",
						null, "Invalid last name.");
			}
			
			if (c.getAddress() == null) {
				
			} else if (c.getAddress().length() < 2) {
				errors.rejectValue("address", "error.invalid-address", null,
						"Invalid address.");
			}
			
			if (c.getPhoneNo() == null) {

			} else if (!validPhoneNumber(c.getPhoneNo())) {
				errors.rejectValue("phoneNo", "error.invalid-phone", null,
						"Invalid phone number.");
			}
			
			if (!checkEmailFormat(c.getEmailId())) {
				errors.rejectValue("emailId", "error.email-invalid", null,
						"Invalid email address.");
			}
			
			if (c.getAge() == 0) {
				errors.rejectValue("age", "error.invalid-age", null,
						"Age can't be zero.");
			} else if (c.getAge() < minAge) {
				errors.rejectValue("age", "error.age-too-low",
						new Object[] { new Integer(minAge) }, "Age too low.");
			} else if (c.getAge() > maxAge) {
				errors.rejectValue("age", "error.age-too-high",
						new Object[] { new Integer(maxAge) }, "Age too high.");
			}
		}
	}

	private boolean validPhoneNumber(String phoneNo) {
		if (phoneNo.length() < 6) {
			return false;
		}
		for (int i = 0; i < phoneNo.length(); i++) {
			if (phoneNo.charAt(i) == '1' || phoneNo.charAt(i) == '2'
					|| phoneNo.charAt(i) == '3' || phoneNo.charAt(i) == '4'
					|| phoneNo.charAt(i) == '5' || phoneNo.charAt(i) == '6'
					|| phoneNo.charAt(i) == '7' || phoneNo.charAt(i) == '8'
					|| phoneNo.charAt(i) == '9' || phoneNo.charAt(i) == '-'
					|| phoneNo.charAt(i) == '0') {

			} else {
				return false;
			}
		}
		return true;
	}

	private boolean validAlphabets(String str) {
		if (str.length() < 2) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1' || str.charAt(i) == '2'
					|| str.charAt(i) == '3' || str.charAt(i) == '4'
					|| str.charAt(i) == '5' || str.charAt(i) == '6'
					|| str.charAt(i) == '7' || str.charAt(i) == '8'
					|| str.charAt(i) == '9' || str.charAt(i) == '-'
					|| str.charAt(i) == '0') {

				return false;
			}
		}
		return true;
	}

	public boolean checkEmailFormat(String email) {
		if (email == null)
			return false;
		if (email.equals(""))
			return false;
		if (email.contains("@") && email.contains("."))
			return true;
		return false;
	}
}