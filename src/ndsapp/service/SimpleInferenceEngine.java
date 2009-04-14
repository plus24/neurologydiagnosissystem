/**
 A <code>SimpleInferenceEngine</code> object represents Rule Engine.
   
 @author      NDS Team
 @since       1.0 (24th December 2008)
 @version     1.0
 */
package ndsapp.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ndsapp.domain.DiagnosisOption;
import ndsapp.domain.Rule;
import ndsapp.repository.RuleDao;

public class SimpleInferenceEngine implements RuleEngine {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	
	//decision tree path upto the requested rule.
	private ArrayList<DiagnosisOption> decisionTreePath;
	//list of possible signs and symptoms.
	private ArrayList<DiagnosisOption> lpss = null;
	//diagnosis instruction for the options provided
	private String diagnosisInstruction = null;
	//data access object instance
	private RuleDao rd;
	
	public void processSelectedSignAndSymptom(DiagnosisOption diagnosisOption){
		
		decisionTreePath = rd.getAllNodesUptoThisNode(diagnosisOption.getOptionCode());
		lpss = new ArrayList<DiagnosisOption>();
						
		//core activities of the rule engine.
		WorkingMemory wm= new WorkingMemory();
		wm.addFact(diagnosisOption);		
		ArrayList<Rule> requiredRules = rd.getRules(diagnosisOption.getOptionCode(),false);
		if(requiredRules != null){
			inferenceEngine(wm,requiredRules);
			diagnosisInstruction = rd.getInstruction(diagnosisOption.getOptionCode());
		}
		else{
			if(rd.getInstruction(diagnosisOption.getOptionCode())!=null){
				// if the node is final leaf node	
				lpss = null;
				diagnosisInstruction = rd.getInstruction(diagnosisOption.getOptionCode());				
			}
			else{
				// no such node exists.
				logger.info("The requested node does not exist.");
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void inferenceEngine(WorkingMemory wm, ArrayList<Rule> requiredRules) {
		
		System.out.println(" ");
		System.out.println("INFERENCE ENGINE INVOKED.");
		
		ArrayList<DiagnosisOption> facts = wm.getFacts();
		DiagnosisOption fact = new DiagnosisOption();
		Rule singleRule = new Rule();
		
		//for each fact in the working memory
	    Iterator factsIterator = facts.iterator ();
		while(factsIterator.hasNext()){
			fact = ( DiagnosisOption ) factsIterator.next ();
			System.out.println(" ");
			System.out.println(" Fact found: "+fact.getOptionCode());
			System.out.println(" ");
			//process the facts with the available rules.
			Iterator ruleIterator = requiredRules.iterator ();
			while(ruleIterator.hasNext()){
				singleRule = ( Rule ) ruleIterator.next ();
				System.out.print(" Rule fired : IF "+singleRule.getIfcode()+" THEN "+singleRule.getThencode());
				lpss.add(new DiagnosisOption(singleRule.getThencode(),singleRule.getThentext()));
			}			
		}	
	}

	public ArrayList<DiagnosisOption> getDiagnosisOptions() {
		
		if (lpss==null || lpss.isEmpty()) {
			return null;
		} else {
			return lpss;
		}		
	}

	public String getDiagnosisInstruction() {
		return diagnosisInstruction;
	}

	public ArrayList<DiagnosisOption> getDecisionTreePath() {
		Iterator<DiagnosisOption> optionsIterator = decisionTreePath.iterator ();
		while(optionsIterator.hasNext()){
			DiagnosisOption doption = ( DiagnosisOption ) optionsIterator.next ();
			if(doption.getOptionText().length() > 5){	
				doption.setOptionText(doption.getOptionText().substring(0, 5)+"..");
			}
			else{
				doption.setOptionText(doption.getOptionText());
			}			
		}	
		return decisionTreePath;
	}

	public void setDiagnosisInstruction(String diagnosisInstruction) {
		this.diagnosisInstruction = diagnosisInstruction;
	}

	public void setRd(RuleDao rd) {
		this.rd = rd;
	}
}
