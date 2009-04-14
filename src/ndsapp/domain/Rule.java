/**
 A <code>Rule</code> object represents a rule.
 @author      Badri Adhikari
 @since       1.0 (24th December 2008)
 @version     1.0
 */
package ndsapp.domain;

public class Rule {

	private Integer ruleId;
	private boolean rootnode;
	private Integer ifcode;
	private String iftext;
	private Integer thencode;
	private String thentext;
	private boolean leafnode;
	
	public Rule() {
		super();
	}
	
	public boolean isRootnode() {
		return rootnode;
	}

	public void setRootnode(boolean rootnode) {
		this.rootnode = rootnode;
	}

	public Integer getIfcode() {
		return ifcode;
	}

	public void setIfcode(Integer ifcode) {
		this.ifcode = ifcode;
	}

	public String getIftext() {
		return iftext;
	}

	public void setIftext(String iftext) {
		this.iftext = iftext;
	}

	public Integer getThencode() {
		return thencode;
	}

	public void setThencode(Integer thencode) {
		this.thencode = thencode;
	}

	public String getThentext() {
		return thentext;
	}

	public void setThentext(String thentext) {
		this.thentext = thentext;
	}

	public boolean isThenPartLeafnode() {
		return leafnode;
	}

	public void setLeafnode(boolean leafnode) {
		this.leafnode = leafnode;
	}

	public Rule(boolean rootnode, Integer ifcode, String iftext,
			Integer thencode, String thentext, boolean leafnode) {
		super();
		this.rootnode = rootnode;
		this.ifcode = ifcode;
		this.iftext = iftext;
		this.thencode = thencode;
		this.thentext = thentext;
		this.leafnode = leafnode;
	}
	public Integer getRuleId() {
		return ruleId;
	}
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	public Rule(Integer ruleId, boolean rootnode, Integer ifcode,
			Integer thencode, boolean leafnode) {
		super();
		this.ruleId = ruleId;
		this.rootnode = rootnode;
		this.ifcode = ifcode;
		this.thencode = thencode;
		this.leafnode = leafnode;
	}

	public Rule(Integer ruleId, boolean rootnode, Integer ifcode,
			String iftext, Integer thencode, String thentext, boolean leafnode) {
		super();
		this.ruleId = ruleId;
		this.rootnode = rootnode;
		this.ifcode = ifcode;
		this.iftext = iftext;
		this.thencode = thencode;
		this.thentext = thentext;
		this.leafnode = leafnode;
	}

	public boolean isLeafnode() {
		return leafnode;
	}
}
