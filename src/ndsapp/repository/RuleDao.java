/**
 A <code>RuleDao</code> object represents a data access object for 
 inserting and removing rules from the rule base.
 @author      Badri Adhikari
 @since       1.0 (24th December 2008)
 @version     1.0
 */
package ndsapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import ndsapp.domain.DiagnosisOption;
import ndsapp.domain.Rule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RuleDao {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	Statement statement;
	private MySQLConnection dbconn;

	/**
	 * Retrieves rules from the database with IFcode as the input. This IFcode
	 * determines the IF part of the rules to be retrieved. IFcode 0 means the
	 * request for root node rules.
	 * 
	 * @param IFcode
	 * @return list of Rules
	 */
	public ArrayList<Rule> getRules(int ifcode, boolean shortrules) {

		ArrayList<Rule> requiredRules = new ArrayList<Rule>();

		try {

			// check if connection is null or not.
			statement = dbconn.getConnection().createStatement();

			ResultSet r = statement
					.executeQuery("select * from rulebase where ifcode='"
							+ ifcode + "'");
			while (r.next()) {

				Rule singleRule = new Rule(r.getInt("ruleid"), r
						.getBoolean("rootnode"), r.getInt("ifcode"), r
						.getInt("thencode"), r.getBoolean("leafnode"));

				statement = dbconn.getConnection().createStatement();
				ResultSet r2 = statement
						.executeQuery("select text from coderesolver where code='"
								+ singleRule.getIfcode() + "'");
				if (r2.next()) {
					singleRule.setIftext(r2.getString("text"));
				}

				statement = dbconn.getConnection().createStatement();
				ResultSet r3 = statement
						.executeQuery("select text from coderesolver where code='"
								+ singleRule.getThencode() + "'");
				if (r3.next()) {
					singleRule.setThentext(r3.getString("text"));
				}

				requiredRules.add(singleRule);
			}

			statement.close();
			statement.close();
			statement.close();

		} catch (SQLException e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
		}
		if (requiredRules.isEmpty()) {
			requiredRules = null;
		}
		if (shortrules) {
			prepareRulesforDisplay(requiredRules);
		}
		return requiredRules;
	}
	public Rule getRulesWithThenCode(int thencode, boolean shortrules) {

		Rule singleRule = new Rule();
		try {

			// check if connection is null or not.
			statement = dbconn.getConnection().createStatement();

			ResultSet r = statement
					.executeQuery("select * from rulebase where thencode='"
							+ thencode + "'");
			while (r.next()) {

				singleRule = new Rule(r.getInt("ruleid"), r
						.getBoolean("rootnode"), r.getInt("ifcode"), r
						.getInt("thencode"), r.getBoolean("leafnode"));

				ResultSet r2 = statement
						.executeQuery("select text from coderesolver where code='"
								+ singleRule.getIfcode() + "'");
				if (r2.next()) {
					singleRule.setIftext(r2.getString("text"));
				}

				ResultSet r3 = statement
						.executeQuery("select text from coderesolver where code='"
								+ singleRule.getThencode() + "'");
				if (r3.next()) {
					singleRule.setThentext(r3.getString("text"));
				}
			}

			statement.close();
			statement.close();
			statement.close();

		} catch (SQLException e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
		}
		
		return singleRule;
	}
	/**
	 * Inserts a rule to the database.
	 * 
	 * @param Rule
	 *            object
	 * @return nothing
	 */
	public void putRule(Rule ruleToBeInserted) {
		try {
			Random randomNumbers = new Random();
			ruleToBeInserted.setThencode(randomNumbers.nextInt(999999999));

			statement = dbconn.getConnection().createStatement();
			String query = new String(
					"insert into coderesolver (code, text) values ('"
							+ ruleToBeInserted.getThencode() + "','"
							+ ruleToBeInserted.getThentext() + "')");
			int rowsAffected = statement.executeUpdate(query);
			if (rowsAffected > 0) {
				query = new String(
						"insert into rulebase (rootnode, ifcode, thencode, leafnode) values ('"
								+ 0 + "','" + ruleToBeInserted.getIfcode()
								+ "','" + ruleToBeInserted.getThencode()
								+ "','" + 0 + "')");
				rowsAffected = statement.executeUpdate(query);
				// logger.info("rule inserted. number of rows effected is "
				// + rowsAffected);
			}
		} catch (NullPointerException ex) {
			System.out.println(" Error updating instructions.");
		} catch (Exception e) {
			System.out.println("error updating instructions " + e);
			e.printStackTrace();
		}

	}

	public String getInstruction(int ifcode) {
		String instruction = null;
		try {
			statement = dbconn.getConnection().createStatement();
			// System.out.println("trying to get instruction for ifcode: " +
			// ifcode);

			ResultSet r = statement
					.executeQuery("select * from instruction where infocode='"
							+ ifcode + "'");
			while (r.next()) {
				instruction = new String(r.getString("infotext"));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error while extracting instruction: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while extracting instruction: "
					+ e.getMessage());
		}
		if (instruction == null) {
			instruction = new String(" ");
		}
		// System.out.println("instruction before returning is: " +
		// instruction);
		return instruction;
	}

	public ArrayList<DiagnosisOption> getAllNodesUptoThisNode(Integer optionCode) {

		Stack<Integer> treepath = new Stack<Integer>();
		try {
			statement = dbconn.getConnection().createStatement();
			treepath.push(optionCode);
			boolean reachedroot = false;
			do {
				ResultSet r = statement
						.executeQuery("select * from rulebase where thencode='"
								+ optionCode + "'");
				if (r.next()) {
					optionCode = r.getInt("ifcode");
					treepath.push(optionCode);
				} else {
					reachedroot = true;
				}
			} while (!reachedroot);
			statement.close();
		} catch (SQLException e) {
			System.out.println("Error while extracting instruction: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while extracting instruction: "
					+ e.getMessage());
		}

		ArrayList<DiagnosisOption> dtreepath = new ArrayList<DiagnosisOption>();
		while (!treepath.isEmpty()) {
			int code = treepath.pop();
			try {
				statement = dbconn.getConnection().createStatement();
				ResultSet r = statement
						.executeQuery("select text from coderesolver where code='"
								+ code + "'");
				if (r.next()) {
					dtreepath
							.add(new DiagnosisOption(code, r.getString("text")));
				}
				statement.close();
			} catch (SQLException e) {
				System.out.println("Error while extracting instruction: "
						+ e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Error while extracting instruction: "
						+ e.getMessage());
			}
		}
		return dtreepath;
	}

	public ArrayList<Rule> getAllRules() {
		ArrayList<Rule> requiredRules = new ArrayList<Rule>();
		try {
			statement = dbconn.getConnection().createStatement();
			ResultSet r = statement.executeQuery("select * from rulebase");
			while (r.next()) {

				Rule singleRule = new Rule(r.getInt("ruleid"), r
						.getBoolean("rootnode"), r.getInt("ifcode"), r
						.getInt("thencode"), r.getBoolean("leafnode"));

				statement = dbconn.getConnection().createStatement();
				ResultSet r2 = statement
						.executeQuery("select text from coderesolver where code='"
								+ singleRule.getIfcode() + "'");
				if (r2.next()) {
					singleRule.setIftext(r2.getString("text"));
				}

				statement = dbconn.getConnection().createStatement();
				ResultSet r3 = statement
						.executeQuery("select text from coderesolver where code='"
								+ singleRule.getThencode() + "'");
				if (r3.next()) {
					singleRule.setThentext(r3.getString("text"));
				}
				requiredRules.add(singleRule);
			}

			statement.close();
			statement.close();
			statement.close();

		} catch (SQLException e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
		}
		if (requiredRules.isEmpty()) {
			requiredRules = null;
		}
		sortRulesByIfCode(requiredRules);
		prepareRulesforDisplay(requiredRules);
		return requiredRules;
	}

	private void sortRulesByIfCode(ArrayList<Rule> requiredRules) {
		// TODO Auto-generated method stub
	}

	private void prepareRulesforDisplay(ArrayList<Rule> rules) {
		if (rules != null && !rules.isEmpty()) {
			Iterator<Rule> ruleiterator = rules.iterator();
			while (ruleiterator.hasNext()) {
				Rule r = (Rule) ruleiterator.next();
				if (r.getIftext()!=null && r.getIftext().length() > 20) {
					r.setIftext(r.getIftext().substring(0, 20) + "..");
				}
				if (r.getThentext()!=null && r.getThentext().length() > 20) {
					r.setThentext(r.getThentext().substring(0, 20) + "..");
				}
			}
		}
	}

	public void updateInstruction(Integer nodeId, String instruction) {
		Statement statement;
		try {
			statement = dbconn.getConnection().createStatement();
			String query1 = new String("update instruction set infotext = '"
					+ instruction + "' where infocode ='" + nodeId + "'");
			int rowsAffected = statement.executeUpdate(query1);
			if (rowsAffected == 0) {
				query1 = new String(
						"insert into instruction (infocode, infotext) values ('"
								+ nodeId + "','" + instruction + "')");
				rowsAffected = statement.executeUpdate(query1);
			}
			logger.info("instruction info updated. rows affrected is "
					+ rowsAffected);
		} catch (NullPointerException ex) {
			System.out.println(" Error updating instructions.");
		} catch (Exception e) {
			System.out.println("error updating instructions " + e);
			e.printStackTrace();
		}
	}

	public MySQLConnection getDbconn() {
		return dbconn;
	}

	public void setDbconn(MySQLConnection dbconn) {
		this.dbconn = dbconn;
	}

	public String codeResolver(int nodeId) {
		String resolution = new String();
		try {
			statement = dbconn.getConnection().createStatement();
			ResultSet r3 = statement
					.executeQuery("select text from coderesolver where code='"
							+ nodeId + "'");

			if (r3.next()) {
				resolution = r3.getString("text");
			} else {
				resolution = null;
			}

			statement.close();
		} catch (SQLException e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while extracting rules: "
					+ e.getMessage());
		}
		return resolution;
	}

	public boolean deleteRule(int nodetobedeleted) {
		boolean ruledeleted = false;
		Statement statement = null;
		try {
			statement = dbconn.getConnection().createStatement();
			if (statement == null) {
				logger.info("statement is null.");
			}
			ArrayList<Integer> nodelist = new ArrayList<Integer>(); 
			getAllNodesBelowThisNode(new Integer(nodetobedeleted),nodelist);
			Iterator<Integer> nodeiterat = nodelist.iterator();
			System.out.println("Nodes to be deleted are:");
			while (nodeiterat.hasNext()) {
				nodetobedeleted = nodeiterat.next().intValue();
				System.out.println(nodetobedeleted);
			}
			Iterator<Integer> nodeiterator = nodelist.iterator();
			while (nodeiterator.hasNext()) {
				nodetobedeleted = nodeiterator.next().intValue();
				statement.executeUpdate("delete from rulebase where thencode = '"+nodetobedeleted+"'");
				logger.info("node deleted " + nodetobedeleted);
				ruledeleted = true;
			}
			statement.executeUpdate("delete from coderesolver where code not in (select distinct thencode from rulebase)");
		} catch (SQLException e) {
			System.out.println("Error while deleting rules: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while deleting rules: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ruledeleted;
	}

	/*
	 * Recursive method to find all the nodes below a node.
	 */
	private void getAllNodesBelowThisNode(Integer nodetobedeleted, ArrayList<Integer> nodelist) {

		Statement statement = null;
		try {
			statement = dbconn.getConnection().createStatement();
			ResultSet r = statement
					.executeQuery("select * from rulebase where ifcode='"
							+ nodetobedeleted + "'");
			while (r.next()) {
				getAllNodesBelowThisNode(r.getInt("thencode"), nodelist);				
			}
		} catch (SQLException e) {
			System.out.println("Error while extracting instruction: "
					+ e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error while extracting instruction: "
					+ e.getMessage());
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		nodelist.add(new Integer(nodetobedeleted));		
		System.out.println("Node added: " + nodetobedeleted);		
	}
}