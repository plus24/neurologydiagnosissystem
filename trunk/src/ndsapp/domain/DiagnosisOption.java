/**
 A <code>DiagnosisOption</code> object represents an option for diagnosis.
 @author      Badri Adhikari
 @since       1.0 (24th December 2008)
 @version     1.0
 */
package ndsapp.domain;

import java.io.Serializable;

public class DiagnosisOption implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer optionCode;
	private String optionText;
	
	public DiagnosisOption(Integer optionCode, String optionText) {
		super();
		this.optionCode = optionCode;
		this.optionText = optionText;
	}
	public DiagnosisOption(Integer optionCode) {
		super();
		this.optionCode = optionCode;
	}
	public DiagnosisOption() {
		super();
	}
	public Integer getOptionCode() {
		return optionCode;
	}
	public void setOptionCode(Integer optionCode) {
		this.optionCode = optionCode;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	
}
