/**
 A <code>CaseDao</code> object represents a data access object 
 to insert, update and retrieve and delete cases.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.repository;

import java.sql.*;

import ndsapp.domain.Case;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CaseDao {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());
	private MySQLConnection dbconn;
	private ResultSet rs1;


	Statement statement = null;

	/**
	 * Retrieve maximum caseid from the database
	 * 
	 * @param none
	 * @return maxcaseid
	 */

	public int getMaxCaseId() {

		int maxcaseid = 0;
		try {
			statement = dbconn.getConnection().createStatement();

			String queryToSelectFromCase = new String(
					"select MAX(CaseId) as CaseId from NDS_CASE");
			rs1 = statement.executeQuery(queryToSelectFromCase);

			if (rs1.next()) {
				maxcaseid = rs1.getInt("CaseId");
			}
		} catch (NullPointerException ex) {
			System.out.println(" Error getting max cased id." + ex);
		} catch (Exception e) {
			System.out.println("error getting max case id. " + e);
			e.printStackTrace();
		}
		finally{
			
		}
		return maxcaseid;
	}

	/**
	 * Retrieves a case from the database with id of the case as the input.
	 * 
	 * @param caseId
	 * @return case object
	 */
	public Case getCase(int caseid) {

		Case c = new Case();
		try {

			if(dbconn.connection == null){
				return null;
			}
			statement = dbconn.getConnection().createStatement();

			String queryToSelectFromCase = new String(
					"select * from NDS_CASE where CaseId='" + caseid + "'");
			String queryToSelectFromHMF = new String(
					"select * from NDS_HMF where CaseId='" + caseid + "'");
			String queryToSelectFromCN = new String(
					"select * from NDS_CN where CaseId='" + caseid + "'");
			String queryToSelectFromLT = new String(
					"select * from NDS_LT where CaseId='" + caseid + "'");
			String queryToSelectFromGS = new String(
					"select * from NDS_GS where CaseId='" + caseid + "'");
			String queryToSelectFromANS = new String(
					"select * from NDS_ANS where CaseId='" + caseid + "'");
			String queryToSelectFromSolution = new String(
					"select * from NDS_SOLUTION where CaseId='" + caseid + "'");

			rs1 = statement.executeQuery(queryToSelectFromCase);

			if (rs1.next()) {

				c.setCaseId(rs1.getInt("CaseId"));
				c.setCaseFirstName(rs1.getString("CaseFirstName"));
				c.setCaseLastName(rs1.getString("CaseLastName"));
				c.setVisitDate(rs1.getString("VisitDate"));
				c.setAddress(rs1.getString("Address"));
				c.setPhoneNo(rs1.getString("PhoneNo"));
				c.setEmailId(rs1.getString("EmailId"));
				c.setAge(rs1.getInt("Age"));
				c.setOccupation(rs1.getString("Occupation"));
				c.setGender(rs1.getString("Gender"));
				c.setSmoking(rs1.getString("Smoking"));
				c.setDrinkingAlcohol(rs1.getString("DrinkingAlcohol"));

			} else {
				// if no such case if found then return null.
				return null;
			}

			rs1 = statement.executeQuery(queryToSelectFromHMF);

			if (rs1.next()) {

				c.setHmfId(rs1.getInt("HmfId"));
				c.setLevelOfConscious(rs1.getString("LevelOfConscious"));
				c.setBehaviorState(rs1.getString("BehaviorState"));
				c.setEmotionalState(rs1.getString("EmotionalState"));
				c.setEmotionalState(rs1.getString("EmotionalState"));
				c.setDysarthia(rs1.getString("Dysarthia"));
				c.setFluencyAndProsody(rs1.getString("FluencyAndProsody"));
				c.setRepetition(rs1.getString("Repetition"));
				c.setNaming(rs1.getString("Naming"));
				c.setReading(rs1.getString("Reading"));
				c.setWriting(rs1.getString("Writing"));
				c.setMemory(rs1.getString("Memory"));
				c.setAstereognosis(rs1.getString("Astereognosis"));
				c.setAgraphaesthesia(rs1.getString("Agraphaesthesia"));
				c.setVisualAnosognosia(rs1.getString("VisualAnosognosia"));
				c.setVisualIllusionsAndHallucinations(rs1
						.getString("VisualIllusionsAndHallucinations"));
				c.setProsopagnosia(rs1.getString("Prosopagnosia"));
				c.setColourAgnosia(rs1.getString("ColourAgnosia"));
				c.setBalintsSyndrome(rs1.getString("BalintsSyndrome"));
			}

			rs1 = statement.executeQuery(queryToSelectFromCN);

			if (rs1.next()) {

				c.setCnId(rs1.getInt("CnId"));
				c.setSmell(rs1.getString("Smell"));
				c.setVisualAcuity(rs1.getString("VisualAcuity"));
				c.setMovingFingerTest(rs1.getString("MovingFingerTest"));
				c.setRedPinConfrontation(rs1.getString("RedPinConfrontation"));
				c.setBinocularTesting(rs1.getString("BinocularTesting"));
				c.setColourVision(rs1.getString("ColourVision"));
				c.setFunduscopy(rs1.getString("Funduscopy"));
				c.setOcularMotilityTest(rs1.getString("OcularMotilityTest"));
				c.setPupilaryLightReaction(rs1
						.getString("PupilaryLightReaction"));
				c.setDiplopia(rs1.getString("Diplopia"));
				c.setOphthalmic(rs1.getString("Ophthalmic"));
				c.setMaxillary(rs1.getString("Maxillary"));
				c.setMandibular(rs1.getString("Mandibular"));
				c.setCornealReflexes(rs1.getString("CornealReflexes"));
				c.setClenchingOfTeeth(rs1.getString("ClenchingOfTeeth"));
				c.setJewJerk(rs1.getString("JewJerk"));
				c.setSensory(rs1.getString("Sensory"));
				c.setMotor(rs1.getString("Motor"));
				c.setTaste(rs1.getString("Taste"));
				c.setRinnesTest(rs1.getString("RinnesTest"));
				c.setWebersTest(rs1.getString("WebersTest"));
				c.setPharyngealReflex(rs1.getString("PharyngealReflex"));
				c.setNasalRegurgitation(rs1.getString("NasalRegurgitation"));
				c.setPalatalDysarthria(rs1.getString("PalatalDysarthria"));
				c.setPatalElevation(rs1.getString("PatalElevation"));
				c.setAssessmentOfLarynx(rs1.getString("AssessmentOfLarynx"));
				c.setShoulderShrugging(rs1.getString("ShoulderShrugging"));
				c.setHeadRotation(rs1.getString("HeadRotation"));
			}

			rs1 = statement.executeQuery(queryToSelectFromLT);

			if (rs1.next()) {

				c.setLtId(rs1.getInt("LtId"));
				c.setWasting(rs1.getString("Wasting"));
				c.setFasciculation(rs1.getString("Fasciculation"));
				c.setSkinLesions(rs1.getString("SkinLesions"));
				c.setToneAtWrist(rs1.getString("ToneAtWrist"));
				c.setToneAtElbows(rs1.getString("ToneAtElbows"));
				c.setToneAtKness(rs1.getString("ToneAtKness"));
				c.setToneAtAnkles(rs1.getString("ToneAtAnkles"));
				c.setAnkleClonus(rs1.getString("AnkleClonus"));
				c.setPower(rs1.getString("Power"));
				c.setJawJerk(rs1.getString("JawJerk"));
				c.setBicepsJerk(rs1.getString("BicepsJerk"));
				c.setSupinatorJerk(rs1.getString("SupinatorJerk"));
				c.setTricepsJerk(rs1.getString("TricepsJerk"));
				c.setKneeJerk(rs1.getString("KneeJerk"));
				c.setAnkleJerk(rs1.getString("AnkleJerk"));
				c.setGornealAndPalatalReflex(rs1
						.getString("GornealAndPalatalReflex"));
				c.setCremastericReflex(rs1.getString("CremastericReflex"));
				c.setPlantarReflex(rs1.getString("PlantarReflex"));
				c.setSphinctericReflex(rs1.getString("SphinctericReflex"));
				c.setSwallowing(rs1.getString("Swallowing"));
				c.setMicturition(rs1.getString("Micturition"));
				c.setDefecation(rs1.getString("Defecation"));
				c.setFingerNoseTest(rs1.getString("FingerNoseTest"));
				c.setDysdiadochokinesis(rs1.getString("Dysdiadochokinesis"));
				c.setFineMovements(rs1.getString("FineMovements"));
				c.setHeelShinTest(rs1.getString("HeelShinTest"));
				c.setPinprick(rs1.getString("Pinprick"));
				c.setTemperature(rs1.getString("Temperature"));
				c.setLightTouch(rs1.getString("LightTouch"));
				c.setVibrationSense(rs1.getString("VibrationSense"));
				c.setJointPositionSense(rs1.getString("JointPositionSense"));
				c.setTwoPointDiscrimination(rs1
						.getString("TwoPointDiscrimination"));

			}

			rs1 = statement.executeQuery(queryToSelectFromGS);

			if (rs1.next()) {

				c.setGsId(rs1.getInt("GsId"));
				c.setWalkingPattern(rs1.getString("WalkingPattern"));
				c.setStandingWFTAndEyesClosed(rs1
						.getString("StandingWFTAndEyesClosed"));
				c.setWalkingHeelToToe(rs1.getString("WalkingHeelToToe"));
				c.setJumpingAndHopping(rs1.getString("JumpingAndHopping"));

			}
			rs1 = statement.executeQuery(queryToSelectFromANS);

			if (rs1.next()) {

				c.setAnsId(rs1.getInt("AnsId"));
				c.setBloodPressure(rs1.getString("BloodPressure"));
				c.setPulse(rs1.getString("Pulse"));
				c.setDeepBreathsTest(rs1.getString("DeepBreathsTest"));
				c.setHandgripTest(rs1.getString("HandgripTest"));
				c.setValsalvaTest(rs1.getString("ValsalvaTest"));
			}

			rs1 = statement.executeQuery(queryToSelectFromSolution);
			if (rs1.next()) {
				c.setDescription(rs1.getString("Description"));
				c.setManagement(rs1.getString("Management"));
				c.setSolution(rs1.getString("Solution"));
			}

		} catch (NullPointerException ex) {
			System.out.println(" Error extracting case details. ");
		} catch (Exception e) {
			System.out.println("error extracting case details." + e);
			e.printStackTrace();
		}

		// System.out.println(" the case details of "+caseid+" was exracted
		// successfully.");

		polishCase(c);
		return c;
	}

	/**
	 * Retrieves a case from the database with id of the case as the input.
	 * 
	 * @param caseid
	 * @return Case
	 */
	public Case getCasesSequentially(int precaseid) {
		// System.out.println("getCasesSequentially called with precaseid
		// "+precaseid);
		return getCase(precaseid + 1);
	}

	/**
	 * Inserts a case to the database.
	 * 
	 * @param Case
	 *            object
	 * @return nothing
	 */
	public int putCase(Case casetobeinserted) {

		polishCase(casetobeinserted);

		try {
			statement = dbconn.getConnection().createStatement();
			int rowsaffected1 = statement
					.executeUpdate("insert into NDS_CASE (CaseFirstName, "
							+ " CaseLastName, VisitDate, Address, PhoneNo, EmailId, Gender, Age,"
							+ " Occupation, Smoking, DrinkingAlcohol) values ('"
							+ casetobeinserted.getCaseFirstName()
							+ "','"
							+ casetobeinserted.getCaseLastName()
							+ "','"
							+ casetobeinserted.getVisitDate()
							+ "','"
							+ casetobeinserted.getAddress()
							+ "','"
							+ casetobeinserted.getPhoneNo()
							+ "','"
							+ casetobeinserted.getEmailId()
							+ "','"
							+ casetobeinserted.getGender()
							+ "','"
							+ casetobeinserted.getAge()
							+ "','"
							+ casetobeinserted.getOccupation()
							+ "','"
							+ casetobeinserted.getSmoking()
							+ "','"
							+ casetobeinserted.getDrinkingAlcohol() + "')");
			// logger.info(" Case inserted. Number of rows affected is "
			// + rowsaffected1);

			int rowsaffected2 = statement
					.executeUpdate("insert into NDS_HMF (LevelOfConscious, BehaviorState, EmotionalState, "
							+ "Dysarthia, "
							+ "FluencyAndProsody, Repetition, Naming, Reading, Writing, Memory, "
							+ "Astereognosis, "
							+ "Agraphaesthesia, "
							+ "VisualAnosognosia, VisualIllusionsAndHallucinations, "
							+ "Prosopagnosia, ColourAgnosia, BalintsSyndrome, CaseId) values ('"
							+ casetobeinserted.getLevelOfConscious()
							+ "','"
							+ casetobeinserted.getBehaviorState()
							+ "','"
							+ casetobeinserted.getEmotionalState()
							+ "','"
							+ casetobeinserted.getDysarthia()
							+ "','"
							+ casetobeinserted.getFluencyAndProsody()
							+ "','"
							+ casetobeinserted.getRepetition()
							+ "','"
							+ casetobeinserted.getNaming()
							+ "','"
							+ casetobeinserted.getReading()
							+ "','"
							+ casetobeinserted.getWriting()
							+ "','"
							+ casetobeinserted.getMemory()
							+ "','"
							+ casetobeinserted.getAstereognosis()
							+ "','"
							+ casetobeinserted.getAgraphaesthesia()
							+ "','"
							+ casetobeinserted.getVisualAnosognosia()
							+ "','"
							+ casetobeinserted
									.getVisualIllusionsAndHallucinations()
							+ "','"
							+ casetobeinserted.getProsopagnosia()
							+ "','"
							+ casetobeinserted.getColourAgnosia()
							+ "','"
							+ casetobeinserted.getBalintsSyndrome()
							+ "','" + getMaxCaseId() + "')");
			// logger.info(" Case inserted. Number of rows affected is "
			// + rowsaffected2);

			int rowsaffected3 = statement
					.executeUpdate("insert into NDS_CN (Smell, VisualAcuity, MovingFingerTest, "
							+ "RedPinConfrontation, BinocularTesting, ColourVision, Funduscopy, "
							+ "OcularMotilityTest, Diplopia, PupilaryLightReaction, "
							+ "Ophthalmic, Maxillary, Mandibular, CornealReflexes, ClenchingOfTeeth, "
							+ "JewJerk, Sensory, Motor, RinnesTest, WebersTest, "
							+ "Taste, PharyngealReflex, NasalRegurgitation, PalatalDysarthria, "
							+ "PatalElevation, AssessmentOfLarynx, ShoulderShrugging, "
							+ "HeadRotation, Tongue, CaseId) values ('"
							+ casetobeinserted.getSmell()
							+ "','"
							+ casetobeinserted.getVisualAcuity()
							+ "','"
							+ casetobeinserted.getMovingFingerTest()
							+ "','"
							+ casetobeinserted.getRedPinConfrontation()
							+ "','"
							+ casetobeinserted.getBinocularTesting()
							+ "','"
							+ casetobeinserted.getColourVision()
							+ "','"
							+ casetobeinserted.getFunduscopy()
							+ "','"
							+ casetobeinserted.getOcularMotilityTest()
							+ "','"
							+ casetobeinserted.getDiplopia()
							+ "','"
							+ casetobeinserted.getPupilaryLightReaction()
							+ "','"
							+ casetobeinserted.getOphthalmic()
							+ "','"
							+ casetobeinserted.getMaxillary()
							+ "','"
							+ casetobeinserted.getMandibular()
							+ "','"
							+ casetobeinserted.getCornealReflexes()
							+ "','"
							+ casetobeinserted.getClenchingOfTeeth()
							+ "','"
							+ casetobeinserted.getJewJerk()
							+ "','"
							+ casetobeinserted.getSensory()
							+ "','"
							+ casetobeinserted.getMotor()
							+ "','"
							+ casetobeinserted.getRinnesTest()
							+ "','"
							+ casetobeinserted.getWebersTest()
							+ "','"
							+ casetobeinserted.getTaste()
							+ "','"
							+ casetobeinserted.getPharyngealReflex()
							+ "','"
							+ casetobeinserted.getNasalRegurgitation()
							+ "','"
							+ casetobeinserted.getPalatalDysarthria()
							+ "','"
							+ casetobeinserted.getPatalElevation()
							+ "','"
							+ casetobeinserted.getAssessmentOfLarynx()
							+ "','"
							+ casetobeinserted.getShoulderShrugging()
							+ "','"
							+ casetobeinserted.getHeadRotation()
							+ "','"
							+ casetobeinserted.getTongue()
							+ "','"
							+ getMaxCaseId() + "')");
			// logger.info(" Case inserted. Number of rows affected is "
			// + rowsaffected3);

			int rowsaffected4 = statement
					.executeUpdate("insert into NDS_LT (Wasting, Fasciculation, SkinLesions, "
							+ "ToneAtWrist, "
							+ "ToneAtElbows, ToneAtKness, ToneAtAnkles, AnkleClonus, Power, JawJerk, "
							+ "BicepsJerk, SupinatorJerk, TricepsJerk, KneeJerk, AnkleJerk, GornealAndPalatalReflex, "
							+ "CremastericReflex, PlantarReflex,"
							+ "SphinctericReflex, Swallowing, Micturition, Defecation, "
							+ "FingerNoseTest, Dysdiadochokinesis, FineMovements, HeelShinTest, "
							+ "Pinprick, Temperature, LightTouch, VibrationSense, "
							+ "JointPositionSense, TwoPointDiscrimination, CaseId) values ('"
							+ casetobeinserted.getWasting()
							+ "','"
							+ casetobeinserted.getFasciculation()
							+ "','"
							+ casetobeinserted.getSkinLesions()
							+ "','"
							+ casetobeinserted.getToneAtWrist()
							+ "','"
							+ casetobeinserted.getToneAtElbows()
							+ "','"
							+ casetobeinserted.getToneAtKness()
							+ "','"
							+ casetobeinserted.getToneAtAnkles()
							+ "','"
							+ casetobeinserted.getAnkleClonus()
							+ "','"
							+ casetobeinserted.getPower()
							+ "','"
							+ casetobeinserted.getJawJerk()
							+ "','"
							+ casetobeinserted.getBicepsJerk()
							+ "','"
							+ casetobeinserted.getSupinatorJerk()
							+ "','"
							+ casetobeinserted.getTricepsJerk()
							+ "','"
							+ casetobeinserted.getKneeJerk()
							+ "','"
							+ casetobeinserted.getAnkleJerk()
							+ "','"
							+ casetobeinserted.getGornealAndPalatalReflex()
							+ "','"
							+ casetobeinserted.getCremastericReflex()
							+ "','"
							+ casetobeinserted.getPlantarReflex()
							+ "','"
							+ casetobeinserted.getSphinctericReflex()
							+ "','"
							+ casetobeinserted.getSwallowing()
							+ "','"
							+ casetobeinserted.getMicturition()
							+ "','"
							+ casetobeinserted.getDefecation()
							+ "','"
							+ casetobeinserted.getFingerNoseTest()
							+ "','"
							+ casetobeinserted.getDysdiadochokinesis()
							+ "','"
							+ casetobeinserted.getFineMovements()
							+ "','"
							+ casetobeinserted.getHeelShinTest()
							+ "','"
							+ casetobeinserted.getPinprick()
							+ "','"
							+ casetobeinserted.getTemperature()
							+ "','"
							+ casetobeinserted.getLightTouch()
							+ "','"
							+ casetobeinserted.getVibrationSense()
							+ "','"
							+ casetobeinserted.getJointPositionSense()
							+ "','"
							+ casetobeinserted.getTwoPointDiscrimination()
							+ "','" + getMaxCaseId() + "')");
			// logger.info(" Case inserted. Number of rows affected is "
			// + rowsaffected4);

			int rowsaffected5 = statement
					.executeUpdate("insert into NDS_GS (WalkingPattern, StandingWFTAndEyesClosed,"
							+ " WalkingHeelToToe, JumpingAndHopping, CaseId) values ('"
							+ casetobeinserted.getWalkingPattern()
							+ "','"
							+ casetobeinserted.getStandingWFTAndEyesClosed()
							+ "','"
							+ casetobeinserted.getWalkingHeelToToe()
							+ "','"
							+ casetobeinserted.getJumpingAndHopping()
							+ "','" + getMaxCaseId() + "')");
			// logger.info(" Case inserted. Number of rows affected is "
			// + rowsaffected5);

			int rowsaffected6 = statement
					.executeUpdate("insert into NDS_ANS (BloodPressure, Pulse,"
							+ " DeepBreathsTest, HandgripTest, ValsalvaTest, CaseId) values ('"
							+ casetobeinserted.getBloodPressure() + "','"
							+ casetobeinserted.getPulse() + "','"
							+ casetobeinserted.getDeepBreathsTest() + "','"
							+ casetobeinserted.getHandgripTest() + "','"
							+ casetobeinserted.getValsalvaTest() + "','"
							+ getMaxCaseId() + "')");

			int rowsaffected7 = statement
					.executeUpdate("insert into NDS_SOLUTION (Description, Management, Solution, CaseId) values ('"
							+ casetobeinserted.getDescription()	+ "','"
							+ casetobeinserted.getManagement() + "','"
							+ casetobeinserted.getSolution() + "','"
							+ getMaxCaseId() + "')");

			logger.info("  Case inserted. Number of rows affected is "
					+ rowsaffected1 + ", " + rowsaffected2 + ", "
					+ rowsaffected3 + ", " + rowsaffected4 + ", "
					+ rowsaffected5 + ", " + rowsaffected6 + ", "
					+ rowsaffected7);

		} catch (NullPointerException ex) {
			System.out.println(" Error inserting case details.");
		} catch (Exception e) {
			System.out.println("error while inserting case " + e);
			e.printStackTrace();
		}
		return getMaxCaseId();
	}

	public void polishCase(Case casetobeinserted) {

		// change all unknowns to null
		if (casetobeinserted.getLevelOfConscious() != null
				&& (casetobeinserted.getLevelOfConscious().equals("unknown") || casetobeinserted
						.getLevelOfConscious().equals("null"))) {
			casetobeinserted.setLevelOfConscious(null);
		}
		if (casetobeinserted.getBehaviorState() != null
				&& (casetobeinserted.getBehaviorState().equals("unknown") || casetobeinserted
						.getBehaviorState().equals("null"))) {
			casetobeinserted.setBehaviorState(null);
		}
		if (casetobeinserted.getEmotionalState() != null
				&& (casetobeinserted.getEmotionalState().equals("unknown") || casetobeinserted
						.getEmotionalState().equals("null"))) {
			casetobeinserted.setEmotionalState(null);
		}
		if (casetobeinserted.getDysarthia() != null
				&& (casetobeinserted.getDysarthia().equals("unknown") || casetobeinserted
						.getDysarthia().equals("null"))) {
			casetobeinserted.setDysarthia(null);
		}
		if (casetobeinserted.getFluencyAndProsody() != null
				&& (casetobeinserted.getFluencyAndProsody().equals("unknown") || casetobeinserted
						.getFluencyAndProsody().equals("null"))) {
			casetobeinserted.setFluencyAndProsody(null);
		}
		if (casetobeinserted.getRepetition() != null
				&& (casetobeinserted.getRepetition().equals("unknown") || casetobeinserted
						.getRepetition().equals("null"))) {
			casetobeinserted.setRepetition(null);
		}
		if (casetobeinserted.getNaming() != null
				&& (casetobeinserted.getNaming().equals("unknown") || casetobeinserted
						.getNaming().equals("null"))) {
			casetobeinserted.setNaming(null);
		}
		if (casetobeinserted.getReading() != null
				&& (casetobeinserted.getReading().equals("unknown") || casetobeinserted
						.getReading().equals("null"))) {
			casetobeinserted.setReading(null);
		}
		if (casetobeinserted.getWriting() != null
				&& (casetobeinserted.getWriting().equals("unknown") || casetobeinserted
						.getWriting().equals("null"))) {
			casetobeinserted.setWriting(null);
		}
		if (casetobeinserted.getMemory() != null
				&& (casetobeinserted.getMemory().equals("unknown") || casetobeinserted
						.getMemory().equals("null"))) {
			casetobeinserted.setMemory(null);
		}
		if (casetobeinserted.getAstereognosis() != null
				&& (casetobeinserted.getAstereognosis().equals("unknown") || casetobeinserted
						.getAstereognosis().equals("null"))) {
			casetobeinserted.setAstereognosis(null);
		}
		if (casetobeinserted.getAgraphaesthesia() != null
				&& (casetobeinserted.getAgraphaesthesia().equals("unknown") || casetobeinserted
						.getAgraphaesthesia().equals("null"))) {
			casetobeinserted.setAgraphaesthesia(null);
		}
		if (casetobeinserted.getVisualAnosognosia() != null
				&& (casetobeinserted.getVisualAnosognosia().equals("unknown") || casetobeinserted
						.getVisualAnosognosia().equals("null"))) {
			casetobeinserted.setVisualAnosognosia(null);
		}
		if (casetobeinserted.getVisualIllusionsAndHallucinations() != null
				&& (casetobeinserted.getVisualIllusionsAndHallucinations()
						.equals("unknown") || casetobeinserted
						.getVisualIllusionsAndHallucinations().equals("null"))) {
			casetobeinserted.setVisualIllusionsAndHallucinations(null);
		}
		if (casetobeinserted.getProsopagnosia() != null
				&& (casetobeinserted.getProsopagnosia().equals("unknown") || casetobeinserted
						.getProsopagnosia().equals("null"))) {
			casetobeinserted.setProsopagnosia(null);
		}
		if (casetobeinserted.getColourAgnosia() != null
				&& (casetobeinserted.getColourAgnosia().equals("unknown") || casetobeinserted
						.getColourAgnosia().equals("null"))) {
			casetobeinserted.setColourAgnosia(null);
		}
		if (casetobeinserted.getBalintsSyndrome() != null
				&& (casetobeinserted.getBalintsSyndrome().equals("unknown") || casetobeinserted
						.getBalintsSyndrome().equals("null"))) {
			casetobeinserted.setBalintsSyndrome(null);
		}
		if (casetobeinserted.getSmell() != null
				&& (casetobeinserted.getSmell().equals("unknown") || casetobeinserted
						.getSmell().equals("null"))) {
			casetobeinserted.setSmell(null);
		}
		if (casetobeinserted.getVisualAcuity() != null
				&& (casetobeinserted.getVisualAcuity().equals("unknown") || casetobeinserted
						.getVisualAcuity().equals("null"))) {
			casetobeinserted.setVisualAcuity(null);
		}
		if (casetobeinserted.getMovingFingerTest() != null
				&& (casetobeinserted.getMovingFingerTest().equals("unknown") || casetobeinserted
						.getMovingFingerTest().equals("null"))) {
			casetobeinserted.setMovingFingerTest(null);
		}
		if (casetobeinserted.getRedPinConfrontation() != null
				&& (casetobeinserted.getRedPinConfrontation().equals("unknown") || casetobeinserted
						.getRedPinConfrontation().equals("null"))) {
			casetobeinserted.setRedPinConfrontation(null);
		}
		if (casetobeinserted.getBinocularTesting() != null
				&& (casetobeinserted.getBinocularTesting().equals("unknown") || casetobeinserted
						.getBinocularTesting().equals("null"))) {
			casetobeinserted.setBinocularTesting(null);
		}
		if (casetobeinserted.getColourVision() != null
				&& (casetobeinserted.getColourVision().equals("unknown") || casetobeinserted
						.getColourVision().equals("null"))) {
			casetobeinserted.setColourVision(null);
		}
		if (casetobeinserted.getFunduscopy() != null
				&& (casetobeinserted.getFunduscopy().equals("unknown") || casetobeinserted
						.getFunduscopy().equals("null"))) {
			casetobeinserted.setFunduscopy(null);
		}
		if (casetobeinserted.getOcularMotilityTest() != null
				&& (casetobeinserted.getOcularMotilityTest().equals("unknown") || casetobeinserted
						.getOcularMotilityTest().equals("null"))) {
			casetobeinserted.setOcularMotilityTest(null);
		}
		if (casetobeinserted.getDiplopia() != null
				&& (casetobeinserted.getDiplopia().equals("unknown") || casetobeinserted
						.getDiplopia().equals("null"))) {
			casetobeinserted.setDiplopia(null);
		}
		if (casetobeinserted.getPupilaryLightReaction() != null
				&& (casetobeinserted.getPupilaryLightReaction().equals(
						"unknown") || casetobeinserted
						.getPupilaryLightReaction().equals("null"))) {
			casetobeinserted.setPupilaryLightReaction(null);
		}
		if (casetobeinserted.getOphthalmic() != null
				&& (casetobeinserted.getOphthalmic().equals("unknown") || casetobeinserted
						.getOphthalmic().equals("null"))) {
			casetobeinserted.setOphthalmic(null);
		}
		if (casetobeinserted.getMaxillary() != null
				&& (casetobeinserted.getMaxillary().equals("unknown") || casetobeinserted
						.getMaxillary().equals("null"))) {
			casetobeinserted.setMaxillary(null);
		}
		if (casetobeinserted.getMandibular() != null
				&& (casetobeinserted.getMandibular().equals("unknown") || casetobeinserted
						.getMandibular().equals("null"))) {
			casetobeinserted.setMandibular(null);
		}
		if (casetobeinserted.getCornealReflexes() != null
				&& (casetobeinserted.getCornealReflexes().equals("unknown") || casetobeinserted
						.getCornealReflexes().equals("null"))) {
			casetobeinserted.setCornealReflexes(null);
		}
		if (casetobeinserted.getClenchingOfTeeth() != null
				&& (casetobeinserted.getClenchingOfTeeth().equals("unknown") || casetobeinserted
						.getClenchingOfTeeth().equals("null"))) {
			casetobeinserted.setClenchingOfTeeth(null);
		}
		if (casetobeinserted.getJewJerk() != null
				&& (casetobeinserted.getJewJerk().equals("unknown") || casetobeinserted
						.getJewJerk().equals("null"))) {
			casetobeinserted.setJewJerk(null);
		}
		if (casetobeinserted.getSensory() != null
				&& (casetobeinserted.getSensory().equals("unknown") || casetobeinserted
						.getSensory().equals("null"))) {
			casetobeinserted.setSensory(null);
		}
		if (casetobeinserted.getMotor() != null
				&& (casetobeinserted.getMotor().equals("unknown") || casetobeinserted
						.getMotor().equals("null"))) {
			casetobeinserted.setMotor(null);
		}
		if (casetobeinserted.getTaste() != null
				&& (casetobeinserted.getTaste().equals("unknown") || casetobeinserted
						.getTaste().equals("null"))) {
			casetobeinserted.setTaste(null);
		}
		if (casetobeinserted.getRinnesTest() != null
				&& (casetobeinserted.getRinnesTest().equals("unknown") || casetobeinserted
						.getRinnesTest().equals("null"))) {
			casetobeinserted.setRinnesTest(null);
		}
		if (casetobeinserted.getWebersTest() != null
				&& (casetobeinserted.getWebersTest().equals("unknown") || casetobeinserted
						.getWebersTest().equals("null"))) {
			casetobeinserted.setWebersTest(null);
		}
		if (casetobeinserted.getTaste() != null
				&& (casetobeinserted.getTaste().equals("unknown") || casetobeinserted
						.getTaste().equals("null"))) {
			casetobeinserted.setTaste(null);
		}
		if (casetobeinserted.getPharyngealReflex() != null
				&& (casetobeinserted.getPharyngealReflex().equals("unknown") || casetobeinserted
						.getPharyngealReflex().equals("null"))) {
			casetobeinserted.setPharyngealReflex(null);
		}
		if (casetobeinserted.getNasalRegurgitation() != null
				&& (casetobeinserted.getNasalRegurgitation().equals("unknown") || casetobeinserted
						.getNasalRegurgitation().equals("null"))) {
			casetobeinserted.setNasalRegurgitation(null);
		}
		if (casetobeinserted.getPalatalDysarthria() != null
				&& (casetobeinserted.getPalatalDysarthria().equals("unknown") || casetobeinserted
						.getPalatalDysarthria().equals("null"))) {
			casetobeinserted.setPalatalDysarthria(null);
		}
		if (casetobeinserted.getPatalElevation() != null
				&& (casetobeinserted.getPatalElevation().equals("unknown") || casetobeinserted
						.getPatalElevation().equals("null"))) {
			casetobeinserted.setPatalElevation(null);
		}
		if (casetobeinserted.getAssessmentOfLarynx() != null
				&& (casetobeinserted.getAssessmentOfLarynx().equals("unknown") || casetobeinserted
						.getAssessmentOfLarynx().equals("null"))) {
			casetobeinserted.setAssessmentOfLarynx(null);
		}
		if (casetobeinserted.getShoulderShrugging() != null
				&& (casetobeinserted.getShoulderShrugging().equals("unknown") || casetobeinserted
						.getShoulderShrugging().equals("null"))) {
			casetobeinserted.setShoulderShrugging(null);
		}
		if (casetobeinserted.getHeadRotation() != null
				&& (casetobeinserted.getHeadRotation().equals("unknown") || casetobeinserted
						.getHeadRotation().equals("null"))) {
			casetobeinserted.setHeadRotation(null);
		}
		if (casetobeinserted.getTongue() != null
				&& (casetobeinserted.getTongue().equals("unknown") || casetobeinserted
						.getTongue().equals("null"))) {
			casetobeinserted.setTongue(null);
		}
		if (casetobeinserted.getWasting() != null
				&& (casetobeinserted.getWasting().equals("unknown") || casetobeinserted
						.getWasting().equals("null"))) {
			casetobeinserted.setWasting(null);
		}
		if (casetobeinserted.getFasciculation() != null
				&& (casetobeinserted.getFasciculation().equals("unknown") || casetobeinserted
						.getFasciculation().equals("null"))) {
			casetobeinserted.setFasciculation(null);
		}
		if (casetobeinserted.getSkinLesions() != null
				&& (casetobeinserted.getSkinLesions().equals("unknown") || casetobeinserted
						.getSkinLesions().equals("null"))) {
			casetobeinserted.setSkinLesions(null);
		}
		if (casetobeinserted.getToneAtWrist() != null
				&& (casetobeinserted.getToneAtWrist().equals("unknown") || casetobeinserted
						.getToneAtWrist().equals("null"))) {
			casetobeinserted.setToneAtWrist(null);
		}
		if (casetobeinserted.getToneAtElbows() != null
				&& (casetobeinserted.getToneAtElbows().equals("unknown") || casetobeinserted
						.getToneAtElbows().equals("null"))) {
			casetobeinserted.setToneAtElbows(null);
		}
		if (casetobeinserted.getToneAtKness() != null
				&& (casetobeinserted.getToneAtKness().equals("unknown") || casetobeinserted
						.getToneAtKness().equals("null"))) {
			casetobeinserted.setToneAtKness(null);
		}
		if (casetobeinserted.getToneAtAnkles() != null
				&& (casetobeinserted.getToneAtAnkles().equals("unknown") || casetobeinserted
						.getToneAtAnkles().equals("null"))) {
			casetobeinserted.setToneAtAnkles(null);
		}
		if (casetobeinserted.getAnkleClonus() != null
				&& (casetobeinserted.getAnkleClonus().equals("unknown") || casetobeinserted
						.getAnkleClonus().equals("null"))) {
			casetobeinserted.setAnkleClonus(null);
		}
		if (casetobeinserted.getPower() != null
				&& (casetobeinserted.getPower().equals("unknown") || casetobeinserted
						.getPower().equals("null"))) {
			casetobeinserted.setPower(null);
		}
		if (casetobeinserted.getJawJerk() != null
				&& (casetobeinserted.getJawJerk().equals("unknown") || casetobeinserted
						.getJawJerk().equals("null"))) {
			casetobeinserted.setJawJerk(null);
		}
		if (casetobeinserted.getBicepsJerk() != null
				&& (casetobeinserted.getBicepsJerk().equals("unknown") || casetobeinserted
						.getBicepsJerk().equals("null"))) {
			casetobeinserted.setBicepsJerk(null);
		}
		if (casetobeinserted.getSupinatorJerk() != null
				&& (casetobeinserted.getSupinatorJerk().equals("unknown") || casetobeinserted
						.getSupinatorJerk().equals("null"))) {
			casetobeinserted.setSupinatorJerk(null);
		}
		if (casetobeinserted.getTricepsJerk() != null
				&& (casetobeinserted.getTricepsJerk().equals("unknown") || casetobeinserted
						.getTricepsJerk().equals("null"))) {
			casetobeinserted.setTricepsJerk(null);
		}
		if (casetobeinserted.getKneeJerk() != null
				&& (casetobeinserted.getKneeJerk().equals("unknown") || casetobeinserted
						.getKneeJerk().equals("null"))) {
			casetobeinserted.setKneeJerk(null);
		}
		if (casetobeinserted.getAnkleJerk() != null
				&& (casetobeinserted.getAnkleJerk().equals("unknown") || casetobeinserted
						.getAnkleJerk().equals("null"))) {
			casetobeinserted.setAnkleJerk(null);
		}
		if (casetobeinserted.getGornealAndPalatalReflex() != null
				&& (casetobeinserted.getGornealAndPalatalReflex().equals(
						"unknown") || casetobeinserted
						.getGornealAndPalatalReflex().equals("null"))) {
			casetobeinserted.setGornealAndPalatalReflex(null);
		}
		if (casetobeinserted.getCremastericReflex() != null
				&& (casetobeinserted.getCremastericReflex().equals("unknown") || casetobeinserted
						.getCremastericReflex().equals("null"))) {
			casetobeinserted.setCremastericReflex(null);
		}
		if (casetobeinserted.getPlantarReflex() != null
				&& (casetobeinserted.getPlantarReflex().equals("unknown") || casetobeinserted
						.getPlantarReflex().equals("null"))) {
			casetobeinserted.setPlantarReflex(null);
		}
		if (casetobeinserted.getSphinctericReflex() != null
				&& (casetobeinserted.getSphinctericReflex().equals("unknown") || casetobeinserted
						.getSphinctericReflex().equals("null"))) {
			casetobeinserted.setSphinctericReflex(null);
		}
		if (casetobeinserted.getSwallowing() != null
				&& (casetobeinserted.getSwallowing().equals("unknown") || casetobeinserted
						.getSwallowing().equals("null"))) {
			casetobeinserted.setSwallowing(null);
		}
		if (casetobeinserted.getMicturition() != null
				&& (casetobeinserted.getMicturition().equals("unknown") || casetobeinserted
						.getMicturition().equals("null"))) {
			casetobeinserted.setMicturition(null);
		}
		if (casetobeinserted.getDefecation() != null
				&& (casetobeinserted.getDefecation().equals("unknown") || casetobeinserted
						.getDefecation().equals("null"))) {
			casetobeinserted.setDefecation(null);
		}
		if (casetobeinserted.getFingerNoseTest() != null
				&& (casetobeinserted.getFingerNoseTest().equals("unknown") || casetobeinserted
						.getFingerNoseTest().equals("null"))) {
			casetobeinserted.setFingerNoseTest(null);
		}

		if (casetobeinserted.getDysdiadochokinesis() != null
				&& (casetobeinserted.getDysdiadochokinesis().equals("unknown") || casetobeinserted
						.getDysdiadochokinesis().equals("null"))) {
			casetobeinserted.setDysdiadochokinesis(null);
		}
		if (casetobeinserted.getFineMovements() != null
				&& (casetobeinserted.getFineMovements().equals("unknown") || casetobeinserted
						.getFineMovements().equals("null"))) {
			casetobeinserted.setFineMovements(null);
		}
		if (casetobeinserted.getHeelShinTest() != null
				&& (casetobeinserted.getHeelShinTest().equals("unknown") || casetobeinserted
						.getHeelShinTest().equals("null"))) {
			casetobeinserted.setHeelShinTest(null);
		}
		if (casetobeinserted.getPinprick() != null
				&& (casetobeinserted.getPinprick().equals("unknown") || casetobeinserted
						.getPinprick().equals("null"))) {
			casetobeinserted.setPinprick(null);
		}
		if (casetobeinserted.getTemperature() != null
				&& (casetobeinserted.getTemperature().equals("unknown") || casetobeinserted
						.getTemperature().equals("null"))) {
			casetobeinserted.setTemperature(null);
		}
		if (casetobeinserted.getLightTouch() != null
				&& (casetobeinserted.getLightTouch().equals("unknown") || casetobeinserted
						.getLightTouch().equals("null"))) {
			casetobeinserted.setLightTouch(null);
		}
		if (casetobeinserted.getVibrationSense() != null
				&& (casetobeinserted.getVibrationSense().equals("unknown") || casetobeinserted
						.getVibrationSense().equals("null"))) {
			casetobeinserted.setVibrationSense(null);
		}
		if (casetobeinserted.getJointPositionSense() != null
				&& (casetobeinserted.getJointPositionSense().equals("unknown") || casetobeinserted
						.getJointPositionSense().equals("null"))) {
			casetobeinserted.setJointPositionSense(null);
		}
		if (casetobeinserted.getTwoPointDiscrimination() != null
				&& (casetobeinserted.getTwoPointDiscrimination().equals(
						"unknown") || casetobeinserted
						.getTwoPointDiscrimination().equals("null"))) {
			casetobeinserted.setTwoPointDiscrimination(null);
		}
		if (casetobeinserted.getWalkingPattern() != null
				&& (casetobeinserted.getWalkingPattern().equals("unknown") || casetobeinserted
						.getWalkingPattern().equals("null"))) {
			casetobeinserted.setWalkingPattern(null);
		}
		if (casetobeinserted.getStandingWFTAndEyesClosed() != null
				&& (casetobeinserted.getStandingWFTAndEyesClosed().equals(
						"unknown") || casetobeinserted
						.getStandingWFTAndEyesClosed().equals("null"))) {
			casetobeinserted.setStandingWFTAndEyesClosed(null);
		}
		if (casetobeinserted.getWalkingHeelToToe() != null
				&& (casetobeinserted.getWalkingHeelToToe().equals("unknown") || casetobeinserted
						.getWalkingHeelToToe().equals("null"))) {
			casetobeinserted.setWalkingHeelToToe(null);
		}
		if (casetobeinserted.getJumpingAndHopping() != null
				&& (casetobeinserted.getJumpingAndHopping().equals("unknown") || casetobeinserted
						.getJumpingAndHopping().equals("null"))) {
			casetobeinserted.setJumpingAndHopping(null);
		}
		if (casetobeinserted.getBloodPressure() != null
				&& (casetobeinserted.getBloodPressure().equals("unknown") || casetobeinserted
						.getBloodPressure().equals("null"))) {
			casetobeinserted.setBloodPressure(null);
		}
		if (casetobeinserted.getPulse() != null
				&& (casetobeinserted.getPulse().equals("unknown") || casetobeinserted
						.getPulse().equals("null"))) {
			casetobeinserted.setPulse(null);
		}
		if (casetobeinserted.getDeepBreathsTest() != null
				&& (casetobeinserted.getDeepBreathsTest().equals("unknown") || casetobeinserted
						.getDeepBreathsTest().equals("null"))) {
			casetobeinserted.setDeepBreathsTest(null);
		}
		if (casetobeinserted.getHandgripTest() != null
				&& (casetobeinserted.getHandgripTest().equals("unknown") || casetobeinserted
						.getHandgripTest().equals("null"))) {
			casetobeinserted.setHandgripTest(null);
		}
		if (casetobeinserted.getValsalvaTest() != null
				&& (casetobeinserted.getValsalvaTest().equals("unknown") || casetobeinserted
						.getValsalvaTest().equals("null"))) {
			casetobeinserted.setValsalvaTest(null);
		}
		if (casetobeinserted.getDescription() != null
				&& (casetobeinserted.getDescription().equals("unknown") || casetobeinserted
						.getDescription().equals("null"))) {
			casetobeinserted.setDescription(null);
		}
		if (casetobeinserted.getSolution() != null
				&& (casetobeinserted.getSolution().equals("unknown") || casetobeinserted
						.getSolution().equals("null"))) {
			casetobeinserted.setSolution(null);
		}
		if (casetobeinserted.getManagement() != null
				&& (casetobeinserted.getManagement().equals("unknown") || casetobeinserted
						.getManagement().equals("null"))) {
			casetobeinserted.setManagement(null);
		}
	}

	public MySQLConnection getDbconn() {
		return dbconn;
	}

	public void setDbconn(MySQLConnection dbconn) {
		this.dbconn = dbconn;
	}
}