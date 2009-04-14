/**
 A <code>CaseFormController</code> object represents a page controller
 that handles the form to insert or modify a case.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ndsapp.domain.Case;
import ndsapp.repository.CaseDao;
import ndsapp.service.HybridExpertSystem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class CaseFormController extends SimpleFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private HybridExpertSystem es;
	private CaseDao cd;

	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors) throws ServletException {
		
		Map<String, Object> model = new LinkedHashMap<String, Object>();
		
		if(cd.getDbconn().connection == null){
			model.put("MessageToAdmin","Database connection could not be established.");
			return new ModelAndView("home", "model", model);			
		}

		Case c = (Case) command;
		String savecase = (String) request.getSession().getAttribute("savecase");
		if(savecase!=null && savecase.equals("yes")){
			es.processCaseRequest(c, false, true);
		}
		else{
			c.setAddress(null);
			c.setEmailId(null);
			c.setOccupation(null);
			c.setPhoneNo(null);
			es.processCaseRequest(c, true, false);
		}
		logger.info("Returning from CaseFormController to "	+ getSuccessView());
		return new ModelAndView("displaysimilarcases", "model", es.getESSolution());
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ServletException {

		Case newcase = new Case();
		newcase.setCaseFirstName("Priti");
		newcase.setCaseMiddleName("Kumari");
		newcase.setCaseLastName("Shrestha");
		newcase.setVisitDate("2009-1-1");
		newcase.setAddress("Kathmandu");
		newcase.setPhoneNo("9841439326");
		newcase.setEmailId("priti@gmail.com");
		newcase.setGender("female");
		newcase.setAge(25);
		newcase.setOccupation("Engineer");
		newcase.setSmoking("no");
		newcase.setDrinkingAlcohol("yes");
		
		newcase.setLevelOfConscious("alert");
		newcase.setBehaviorState("clean");
		newcase.setEmotionalState("normal");
		newcase.setDysarthia("normal");
		newcase.setFluencyAndProsody("unknown");
		newcase.setRepetition("unknown");
		newcase.setNaming("unknown");
		newcase.setReading("unknown");
		newcase.setWriting("unknown");
		newcase.setMemory("normal");
		newcase.setAstereognosis("unknown");
		newcase.setAgraphaesthesia("unknown");
		newcase.setVisualAnosognosia("unknown");
		newcase.setVisualIllusionsAndHallucinations("unknown");
		newcase.setProsopagnosia("unknown");
		newcase.setColourAgnosia("unknown");
		newcase.setBalintsSyndrome("unknown");
		newcase.setSmell("unknown");
		newcase.setVisualAcuity("unknown");
		newcase.setMovingFingerTest("unknown");
		newcase.setRedPinConfrontation("unknown");
		newcase.setBinocularTesting("unknown");
		newcase.setColourVision("unknown");
		newcase.setFunduscopy("unknown");
		newcase.setOcularMotilityTest("normal");
		newcase.setDiplopia("unknown");
		newcase.setPupilaryLightReaction("unknown");
		newcase.setOphthalmic("unknown");
		newcase.setMaxillary("unknown");
		newcase.setMandibular("unknown");
		newcase.setCornealReflexes("unknown");
		newcase.setClenchingOfTeeth("unknown");
		newcase.setJewJerk("unknown");
		newcase.setSensory("unknown");
		newcase.setMotor("unknown");
		newcase.setTaste("unknown");
		newcase.setRinnesTest("unknown");
		newcase.setWebersTest("unknown");
		newcase.setTaste("unknown");
		newcase.setPharyngealReflex("unknown");
		newcase.setNasalRegurgitation("unknown");
		newcase.setPalatalDysarthria("unknown");
		newcase.setPatalElevation("unknown");
		newcase.setAssessmentOfLarynx("unknown");
		newcase.setShoulderShrugging("normal power");
		newcase.setHeadRotation("unknown");
		newcase.setTongue("unknown");
		newcase.setWasting("unknown");
		newcase.setFasciculation("unknown");
		newcase.setSkinLesions("unknown");
		newcase.setToneAtWrist("unknown");
		newcase.setToneAtElbows("unknown");
		newcase.setToneAtKness("unknown");
		newcase.setToneAtAnkles("unknown");
		newcase.setAnkleClonus("unknown");
		newcase.setPower("unknown");
		newcase.setJawJerk("unknown");
		newcase.setBicepsJerk("unknown");
		newcase.setSupinatorJerk("unknown");
		newcase.setTricepsJerk("unknown");
		newcase.setKneeJerk("unknown");
		newcase.setAnkleJerk("unknown");
		newcase.setGornealAndPalatalReflex("unknown");
		newcase.setCremastericReflex("unknown");
		newcase.setPlantarReflex("unknown");
		newcase.setSphinctericReflex("unknown");
		newcase.setSwallowing("unknown");
		newcase.setMicturition("unknown");
		newcase.setDefecation("unknown");
		newcase.setFingerNoseTest("unknown");
		newcase.setDysdiadochokinesis("unknown");
		newcase.setFineMovements("unknown");
		newcase.setHeelShinTest("unknown");
		newcase.setPinprick("unknown");
		newcase.setTemperature("unknown");
		newcase.setLightTouch("unknown");
		newcase.setVibrationSense("unknown");
		newcase.setJointPositionSense("unknown");
		newcase.setTwoPointDiscrimination("unknown");
		newcase.setWalkingPattern("unknown");
		newcase.setStandingWFTAndEyesClosed("unknown");
		newcase.setWalkingHeelToToe("unknown");
		newcase.setJumpingAndHopping("unknown");
		newcase.setBloodPressure("unknown");
		newcase.setPulse("unknown");
		newcase.setDeepBreathsTest("unknown");
		newcase.setHandgripTest("unknown");
		newcase.setValsalvaTest("unknown");

		newcase.setSavecase("unchecked");
		
		newcase.setDescription(null);
		newcase.setManagement(null);
		newcase.setSolution(null);
		
		return newcase;
	}
		
	@SuppressWarnings("unchecked")
	protected Map referenceData(HttpServletRequest request) throws Exception {

		Map<String, Object> referenceDataMap = new LinkedHashMap<String, Object>();

		// HMF
		ArrayList<String> levelOfConsciouslist = new ArrayList<String>();
		levelOfConsciouslist.add("alert");
		levelOfConsciouslist.add("lethargic");
		levelOfConsciouslist.add("obtunded");
		levelOfConsciouslist.add("stuporous");
		levelOfConsciouslist.add("comatose");
		referenceDataMap.put("levelOfConscious", levelOfConsciouslist);

		ArrayList<String> behaviorStatelist = new ArrayList<String>();
		behaviorStatelist.add("clean");
		behaviorStatelist.add("agitated");
		behaviorStatelist.add("restless");
		referenceDataMap.put("behaviorState", behaviorStatelist);

		ArrayList<String> emotionalStatelist = new ArrayList<String>();
		emotionalStatelist.add("depressed");
		emotionalStatelist.add("elevated");
		emotionalStatelist.add("normal");
		emotionalStatelist.add("others");
		referenceDataMap.put("emotionalState", emotionalStatelist);

		ArrayList<String> dysarthialist = new ArrayList<String>();
		dysarthialist.add("bulbar palsy");
		dysarthialist.add("cerebellar dysarthia");
		dysarthialist.add("pseudo bulbar palsy");
		dysarthialist.add("pseudo bulbar palsy");
		dysarthialist.add("dysphonia");
		dysarthialist.add("normal");
		referenceDataMap.put("dysarthia", dysarthialist);

		ArrayList<String> fluencyAndProsodylist = new ArrayList<String>();
		fluencyAndProsodylist.add("normal");
		fluencyAndProsodylist.add("abnormal");
		fluencyAndProsodylist.add("unknown");
		referenceDataMap.put("fluencyAndProsody", fluencyAndProsodylist);

		ArrayList<String> repetitionlist = new ArrayList<String>();
		repetitionlist.add("normal");
		repetitionlist.add("abnormal");
		repetitionlist.add("unknown");
		referenceDataMap.put("repetition", repetitionlist);

		ArrayList<String> naminglist = new ArrayList<String>();
		naminglist.add("normal");
		naminglist.add("abnormal");
		naminglist.add("unknown");
		referenceDataMap.put("naming", naminglist);

		ArrayList<String> readinglist = new ArrayList<String>();
		readinglist.add("normal");
		readinglist.add("abnormal");
		readinglist.add("unknown");
		referenceDataMap.put("reading", readinglist);

		ArrayList<String> writinglist = new ArrayList<String>();
		writinglist.add("normal");
		writinglist.add("abnormal");
		writinglist.add("unknown");
		referenceDataMap.put("writing", writinglist);

		ArrayList<String> memorylist = new ArrayList<String>();
		memorylist.add("short term memory loss");
		memorylist.add("medium memory loss");
		memorylist.add("remote memory loss");
		memorylist.add("normal");
		referenceDataMap.put("memory", memorylist);

		ArrayList<String> astereognosislist = new ArrayList<String>();
		astereognosislist.add("normal");
		astereognosislist.add("abnormal");
		astereognosislist.add("unknown");
		referenceDataMap.put("astereognosis", astereognosislist);

		ArrayList<String> agraphaesthesialist = new ArrayList<String>();
		agraphaesthesialist.add("normal");
		agraphaesthesialist.add("abnormal");
		agraphaesthesialist.add("unknown");
		referenceDataMap.put("agraphaesthesia", agraphaesthesialist);

		ArrayList<String> visualAnosognosialist = new ArrayList<String>();
		visualAnosognosialist.add("present");
		visualAnosognosialist.add("absent");
		visualAnosognosialist.add("unknown");
		referenceDataMap.put("visualAnosognosia", visualAnosognosialist);

		ArrayList<String> visualIllusionsAndHallucinationslist = new ArrayList<String>();
		visualIllusionsAndHallucinationslist.add("present");
		visualIllusionsAndHallucinationslist.add("absent");
		visualIllusionsAndHallucinationslist.add("unknown");
		referenceDataMap.put("visualIllusionsAndHallucinations",
				visualIllusionsAndHallucinationslist);

		ArrayList<String> prosopagnosialist = new ArrayList<String>();
		prosopagnosialist.add("present");
		prosopagnosialist.add("absent");
		prosopagnosialist.add("unknown");
		referenceDataMap.put("prosopagnosia", prosopagnosialist);

		ArrayList<String> colourAgnosialist = new ArrayList<String>();
		colourAgnosialist.add("present");
		colourAgnosialist.add("absent");
		colourAgnosialist.add("unknown");
		referenceDataMap.put("colourAgnosia", colourAgnosialist);

		ArrayList<String> balintsSyndromelist = new ArrayList<String>();
		balintsSyndromelist.add("present");
		balintsSyndromelist.add("absent");
		balintsSyndromelist.add("unknown");
		referenceDataMap.put("balintsSyndrome", balintsSyndromelist);

		// The Cranial Nerve

		ArrayList<String> smelllist = new ArrayList<String>();
		smelllist.add("right unilateral loss");
		smelllist.add("left unilateral loss");
		smelllist.add("bilateral loss");
		smelllist.add("normal");
		smelllist.add("unknown");		
		referenceDataMap.put("smell", smelllist);

		ArrayList<String> visualAcuitylist = new ArrayList<String>();
		visualAcuitylist.add("normal");
		visualAcuitylist.add("abnormal");
		visualAcuitylist.add("unknown");
		referenceDataMap.put("visualAcuity", visualAcuitylist);

		ArrayList<String> movingFingerTestlist = new ArrayList<String>();
		movingFingerTestlist.add("normal");
		movingFingerTestlist.add("abnormal");
		movingFingerTestlist.add("unknown");
		referenceDataMap.put("movingFingerTest", movingFingerTestlist);

		ArrayList<String> redPinConfrontationlist = new ArrayList<String>();
		redPinConfrontationlist.add("normal");
		redPinConfrontationlist.add("abnormal");
		redPinConfrontationlist.add("unknown");
		referenceDataMap.put("redPinConfrontation", redPinConfrontationlist);

		ArrayList<String> binocularTestinglist = new ArrayList<String>();
		binocularTestinglist.add("normal");
		binocularTestinglist.add("abnormal");
		binocularTestinglist.add("unknown");
		referenceDataMap.put("binocularTesting", binocularTestinglist);

		ArrayList<String> colourVisionlist = new ArrayList<String>();
		colourVisionlist.add("normal");
		colourVisionlist.add("abnormal");
		colourVisionlist.add("unknown");
		referenceDataMap.put("colourVision", colourVisionlist);

		ArrayList<String> funduscopylist = new ArrayList<String>();
		funduscopylist.add("unknown");
		funduscopylist.add("grade 0");
		funduscopylist.add("grade 1");
		funduscopylist.add("grade 2");
		funduscopylist.add("grade 3");
		funduscopylist.add("grade 4");
		funduscopylist.add("grade 5");
		referenceDataMap.put("funduscopy", funduscopylist);

		ArrayList<String> ocularMotilityTestlist = new ArrayList<String>();
		ocularMotilityTestlist.add("abnormal levo depression");
		ocularMotilityTestlist.add("abnormal levo elevation");
		ocularMotilityTestlist.add("abnormal dextro depression");
		ocularMotilityTestlist.add("abnormal dextro elevation");
		ocularMotilityTestlist.add("abnormal abduction");
		ocularMotilityTestlist.add("normal");
		referenceDataMap.put("ocularMotilityTest", ocularMotilityTestlist);

		ArrayList<String> diplopialist = new ArrayList<String>();
		diplopialist.add("yes");
		diplopialist.add("no");
		diplopialist.add("unknown");
		referenceDataMap.put("diplopia", diplopialist);

		ArrayList<String> pupilaryLightReactionlist = new ArrayList<String>();
		pupilaryLightReactionlist.add("abnormal direct in left");
		pupilaryLightReactionlist.add("abnormal direct in right");
		pupilaryLightReactionlist.add("abnormal indirect in left");
		pupilaryLightReactionlist.add("abnormal indirect in right");
		pupilaryLightReactionlist.add("relative afferent pupilary defect (RAPD)");
		pupilaryLightReactionlist.add("normal");
		pupilaryLightReactionlist.add("unknown");
		referenceDataMap.put("pupilaryLightReaction", pupilaryLightReactionlist);

		ArrayList<String> ophthalmiclist = new ArrayList<String>();
		ophthalmiclist.add("normal");
		ophthalmiclist.add("abnormal");
		ophthalmiclist.add("unknown");
		referenceDataMap.put("ophthalmic", ophthalmiclist);

		ArrayList<String> maxillarylist = new ArrayList<String>();
		maxillarylist.add("normal");
		maxillarylist.add("abnormal");
		maxillarylist.add("unknown");
		referenceDataMap.put("maxillary", maxillarylist);

		ArrayList<String> mandibularlist = new ArrayList<String>();
		mandibularlist.add("normal");
		mandibularlist.add("abnormal");
		mandibularlist.add("unknown");
		referenceDataMap.put("mandibular", mandibularlist);

		ArrayList<String> cornealReflexeslist = new ArrayList<String>();
		cornealReflexeslist.add("present");
		cornealReflexeslist.add("absent");
		cornealReflexeslist.add("unknown");
		referenceDataMap.put("cornealReflexes", cornealReflexeslist);

		ArrayList<String> clenchingOfTeethlist = new ArrayList<String>();
		clenchingOfTeethlist.add("normal");
		clenchingOfTeethlist.add("abnormal");
		clenchingOfTeethlist.add("unknown");
		referenceDataMap.put("clenchingOfTeeth", clenchingOfTeethlist);

		ArrayList<String> jewJerklist = new ArrayList<String>();
		jewJerklist.add("present");
		jewJerklist.add("absent");
		jewJerklist.add("increased");
		jewJerklist.add("unknown");
		referenceDataMap.put("jewJerk", jewJerklist);

		ArrayList<String> sensorylist = new ArrayList<String>();
		sensorylist.add("normal");
		sensorylist.add("abnormal");
		sensorylist.add("unknown");
		referenceDataMap.put("sensory", sensorylist);

		ArrayList<String> motorlist = new ArrayList<String>();
		motorlist.add("lmn type");
		motorlist.add("umn type");
		motorlist.add("normal");
		motorlist.add("unknown");
		referenceDataMap.put("motor", motorlist);

		ArrayList<String> rinnesTestlist = new ArrayList<String>();
		rinnesTestlist.add("BC > AC in right ear");
		rinnesTestlist.add("BC > AC in left ear");
		rinnesTestlist.add("BC < AC in right ear");
		rinnesTestlist.add("BC < AC in left ear");
		rinnesTestlist.add("normal");
		rinnesTestlist.add("unknown");
		referenceDataMap.put("rinnesTest",rinnesTestlist);

		ArrayList<String> webersTestlist = new ArrayList<String>();
		webersTestlist.add("lateralized to normal ear");
		webersTestlist.add("lateralized to abnormal ear");
		webersTestlist.add("unknown");
		referenceDataMap.put("webersTest", webersTestlist);

		ArrayList<String> tastelist = new ArrayList<String>();
		tastelist.add("abnormal left");
		tastelist.add("abnormal right");
		tastelist.add("normal");
		tastelist.add("unknown");
		referenceDataMap.put("taste", tastelist);

		ArrayList<String> pharyngealReflexlist = new ArrayList<String>();
		pharyngealReflexlist.add("present");
		pharyngealReflexlist.add("absent");
		pharyngealReflexlist.add("unknown");
		referenceDataMap.put("pharyngealReflex", pharyngealReflexlist);

		ArrayList<String> nasalRegurgitationlist = new ArrayList<String>();
		nasalRegurgitationlist.add("normal");
		nasalRegurgitationlist.add("abnormal");
		nasalRegurgitationlist.add("unknown");
		referenceDataMap.put("nasalRegurgitation", nasalRegurgitationlist);

		ArrayList<String> palatalDysarthrialist = new ArrayList<String>();
		palatalDysarthrialist.add("normal");
		palatalDysarthrialist.add("abnormal");
		palatalDysarthrialist.add("unknown");
		referenceDataMap.put("palatalDysarthria", palatalDysarthrialist);

		ArrayList<String> patalElevationlist = new ArrayList<String>();
		patalElevationlist.add("normal");
		patalElevationlist.add("abnormal");
		patalElevationlist.add("unknown");
		referenceDataMap.put("patalElevation", patalElevationlist);

		ArrayList<String> assessmentOfLarynxlist = new ArrayList<String>();
		assessmentOfLarynxlist.add("normal");
		assessmentOfLarynxlist.add("abnormal");
		assessmentOfLarynxlist.add("unknown");
		referenceDataMap.put("assessmentOfLarynx", assessmentOfLarynxlist);

		ArrayList<String> shoulderShrugginglist = new ArrayList<String>();
		shoulderShrugginglist.add("normal power");
		shoulderShrugginglist.add("decreased power in left");
		shoulderShrugginglist.add("decreased power in right");
		shoulderShrugginglist.add("absent power in left");
		shoulderShrugginglist.add("absent power in right");
		shoulderShrugginglist.add("unknown");
		referenceDataMap.put("shoulderShrugging", shoulderShrugginglist);

		ArrayList<String> headRotationlist = new ArrayList<String>();
		headRotationlist.add("normal power");
		headRotationlist.add("decreased power in left");
		headRotationlist.add("decreased power in right");
		headRotationlist.add("absent power in left");
		headRotationlist.add("absent power in right");
		headRotationlist.add("unknown");
		referenceDataMap.put("headRotation", headRotationlist);

		ArrayList<String> tonguelist = new ArrayList<String>();
		tonguelist.add("normal");
		tonguelist.add("abnormal");
		tonguelist.add("unknown");
		referenceDataMap.put("tongue", tonguelist);

		// The Motor System of The Limbs and Trunk

		ArrayList<String> wastinglist = new ArrayList<String>();
		wastinglist.add("left arm");
		wastinglist.add("left forearm");
		wastinglist.add("left thigh");
		wastinglist.add("left leg");
		wastinglist.add("right arm");
		wastinglist.add("right forearm");
		wastinglist.add("right thigh");
		wastinglist.add("right leg");
		wastinglist.add("no");
		wastinglist.add("unknown");
		referenceDataMap.put("wasting", wastinglist);

		ArrayList<String> fasciculationlist = new ArrayList<String>();
		fasciculationlist.add("yes");
		fasciculationlist.add("no");
		fasciculationlist.add("unknown");
		referenceDataMap.put("fasciculation", fasciculationlist);

		ArrayList<String> skinLesionslist = new ArrayList<String>();
		skinLesionslist.add("yes");
		skinLesionslist.add("no");
		skinLesionslist.add("unknown");
		referenceDataMap.put("skinLesions", skinLesionslist);

		ArrayList<String> toneAtWristlist = new ArrayList<String>();
		toneAtWristlist.add("spastic");
		toneAtWristlist.add("decreased");
		toneAtWristlist.add("normal");
		toneAtWristlist.add("unknown");
		referenceDataMap.put("toneAtWrist", toneAtWristlist);

		ArrayList<String> toneAtElbowslist = new ArrayList<String>();
		toneAtElbowslist.add("spastic");
		toneAtElbowslist.add("decreased");
		toneAtElbowslist.add("normal");
		toneAtElbowslist.add("unknown");
		referenceDataMap.put("toneAtElbows", toneAtElbowslist);

		ArrayList<String> toneAtKnesslist = new ArrayList<String>();
		toneAtKnesslist.add("spastic");
		toneAtKnesslist.add("decreased");
		toneAtKnesslist.add("normal");
		toneAtKnesslist.add("unknown");
		referenceDataMap.put("toneAtKness", toneAtKnesslist);

		ArrayList<String> toneAtAnkleslist = new ArrayList<String>();
		toneAtAnkleslist.add("spastic");
		toneAtAnkleslist.add("decreased");
		toneAtAnkleslist.add("normal");
		toneAtAnkleslist.add("unknown");
		referenceDataMap.put("toneAtAnkles", toneAtAnkleslist);

		ArrayList<String> ankleClonuslist = new ArrayList<String>();
		ankleClonuslist.add("spastic");
		ankleClonuslist.add("decreased");
		ankleClonuslist.add("normal");
		ankleClonuslist.add("unknown");
		referenceDataMap.put("ankleClonus", ankleClonuslist);

		ArrayList<String> powerlist = new ArrayList<String>();
		powerlist.add("grade 0");
		powerlist.add("grade 1");
		powerlist.add("grade 2");
		powerlist.add("grade 3");
		powerlist.add("grade 4");
		powerlist.add("grade 5");
		powerlist.add("unknown");
		referenceDataMap.put("power", powerlist);

		ArrayList<String> jawJerklist = new ArrayList<String>();
		jawJerklist.add("absent");
		jawJerklist.add("present");
		jawJerklist.add("brisk");
		jawJerklist.add("very brisk");
		jawJerklist.add("clonus");
		jawJerklist.add("unknown");
		referenceDataMap.put("jawJerk", jawJerklist);

		ArrayList<String> bicepsJerklist = new ArrayList<String>();
		bicepsJerklist.add("absent");
		bicepsJerklist.add("present");
		bicepsJerklist.add("brisk");
		bicepsJerklist.add("very brisk");
		bicepsJerklist.add("clonus");
		bicepsJerklist.add("unknown");
		referenceDataMap.put("bicepsJerk", bicepsJerklist);

		ArrayList<String> supinatorJerklist = new ArrayList<String>();
		supinatorJerklist.add("absent");
		supinatorJerklist.add("present");
		supinatorJerklist.add("brisk");
		supinatorJerklist.add("very brisk");
		supinatorJerklist.add("clonus");
		supinatorJerklist.add("unknown");
		referenceDataMap.put("supinatorJerk", supinatorJerklist);

		ArrayList<String> tricepsJerklist = new ArrayList<String>();
		tricepsJerklist.add("absent");
		tricepsJerklist.add("present");
		tricepsJerklist.add("brisk");
		tricepsJerklist.add("very brisk");
		tricepsJerklist.add("clonus");
		tricepsJerklist.add("unknown");
		referenceDataMap.put("tricepsJerk", tricepsJerklist);

		ArrayList<String> kneeJerklist = new ArrayList<String>();
		kneeJerklist.add("absent");
		kneeJerklist.add("present");
		kneeJerklist.add("brisk");
		kneeJerklist.add("very brisk");
		kneeJerklist.add("clonus");
		kneeJerklist.add("unknown");
		referenceDataMap.put("kneeJerk", kneeJerklist);

		ArrayList<String> ankleJerklist = new ArrayList<String>();
		ankleJerklist.add("absent");
		ankleJerklist.add("present");
		ankleJerklist.add("brisk");
		ankleJerklist.add("very brisk");
		ankleJerklist.add("clonus");
		ankleJerklist.add("unknown");
		referenceDataMap.put("ankleJerk", ankleJerklist);

		ArrayList<String> gornealAndPalatalReflexlist = new ArrayList<String>();
		gornealAndPalatalReflexlist.add("present");
		gornealAndPalatalReflexlist.add("absent");
		gornealAndPalatalReflexlist.add("unknown");
		referenceDataMap.put("gornealAndPalatalReflex",
				gornealAndPalatalReflexlist);

		ArrayList<String> cremastericReflexlist = new ArrayList<String>();
		cremastericReflexlist.add("present");
		cremastericReflexlist.add("absent");
		cremastericReflexlist.add("unknown");
		referenceDataMap.put("cremastericReflex", cremastericReflexlist);

		ArrayList<String> plantarReflexlist = new ArrayList<String>();
		plantarReflexlist.add("present");
		plantarReflexlist.add("absent");
		plantarReflexlist.add("unknown");
		referenceDataMap.put("plantarReflex", plantarReflexlist);

		ArrayList<String> sphinctericReflexlist = new ArrayList<String>();
		sphinctericReflexlist.add("present");
		sphinctericReflexlist.add("absent");
		sphinctericReflexlist.add("unknown");
		referenceDataMap.put("sphinctericReflex", sphinctericReflexlist);

		ArrayList<String> swallowinglist = new ArrayList<String>();
		swallowinglist.add("present");
		swallowinglist.add("absent");
		swallowinglist.add("unknown");
		referenceDataMap.put("swallowing", swallowinglist);

		ArrayList<String> micturitionlist = new ArrayList<String>();
		micturitionlist.add("present");
		micturitionlist.add("absent");
		micturitionlist.add("unknown");
		referenceDataMap.put("micturition", micturitionlist);

		ArrayList<String> defecationlist = new ArrayList<String>();
		defecationlist.add("present");
		defecationlist.add("absent");
		defecationlist.add("unknown");
		referenceDataMap.put("defecation", defecationlist);

		ArrayList<String> fingerNoseTestlist = new ArrayList<String>();
		fingerNoseTestlist.add("normal");
		fingerNoseTestlist.add("abnormal");
		fingerNoseTestlist.add("unknown");
		referenceDataMap.put("fingerNoseTest", fingerNoseTestlist);

		ArrayList<String> dysdiadochokinesislist = new ArrayList<String>();
		dysdiadochokinesislist.add("normal");
		dysdiadochokinesislist.add("abnormal");
		dysdiadochokinesislist.add("unknown");
		referenceDataMap.put("dysdiadochokinesis", dysdiadochokinesislist);

		ArrayList<String> fineMovementslist = new ArrayList<String>();
		fineMovementslist.add("normal");
		fineMovementslist.add("abnormal");
		fineMovementslist.add("unknown");
		referenceDataMap.put("fineMovements", fineMovementslist);

		ArrayList<String> heelShinTestlist = new ArrayList<String>();
		heelShinTestlist.add("normal");
		heelShinTestlist.add("abnormal");
		heelShinTestlist.add("unknown");
		referenceDataMap.put("heelShinTest", heelShinTestlist);

		ArrayList<String> pinpricklist = new ArrayList<String>();
		pinpricklist.add("normal");
		pinpricklist.add("abnormal");
		pinpricklist.add("unknown");
		referenceDataMap.put("pinprick", pinpricklist);

		ArrayList<String> temperaturelist = new ArrayList<String>();
		temperaturelist.add("normal");
		temperaturelist.add("abnormal");
		temperaturelist.add("unknown");
		referenceDataMap.put("temperature", temperaturelist);

		ArrayList<String> lightTouchlist = new ArrayList<String>();
		lightTouchlist.add("normal");
		lightTouchlist.add("abnormal");
		lightTouchlist.add("unknown");
		referenceDataMap.put("lightTouch", lightTouchlist);

		ArrayList<String> vibrationSenselist = new ArrayList<String>();
		vibrationSenselist.add("normal");
		vibrationSenselist.add("abnormal");
		vibrationSenselist.add("unknown");
		referenceDataMap.put("vibrationSense", vibrationSenselist);

		ArrayList<String> jointPositionSenselist = new ArrayList<String>();
		jointPositionSenselist.add("normal");
		jointPositionSenselist.add("abnormal");
		jointPositionSenselist.add("unknown");
		referenceDataMap.put("jointPositionSense", jointPositionSenselist);

		ArrayList<String> twoPointDiscriminationlist = new ArrayList<String>();
		twoPointDiscriminationlist.add("normal");
		twoPointDiscriminationlist.add("abnormal");
		twoPointDiscriminationlist.add("unknown");
		referenceDataMap.put("twoPointDiscrimination",
				twoPointDiscriminationlist);

		// Gait and Stance

		ArrayList<String> walkingPatternlist = new ArrayList<String>();
		walkingPatternlist.add("normal fashion");
		walkingPatternlist.add("poor balance");
		walkingPatternlist.add("tendem walk");
		walkingPatternlist.add("unable to walk");
		referenceDataMap.put("walkingPattern", walkingPatternlist);

		ArrayList<String> standingWFTAndEyesClosedlist = new ArrayList<String>();
		standingWFTAndEyesClosedlist.add("positive");
		standingWFTAndEyesClosedlist.add("negative");
		standingWFTAndEyesClosedlist.add("unknown");
		referenceDataMap.put("standingWFTAndEyesClosed",
				standingWFTAndEyesClosedlist);

		ArrayList<String> walkingHeelToToelist = new ArrayList<String>();
		walkingHeelToToelist.add("able to walk on a line");
		walkingHeelToToelist.add("unable to walk on a line");
		walkingHeelToToelist.add("unknown");
		referenceDataMap.put("walkingHeelToToe", walkingHeelToToelist);

		ArrayList<String> jumpingAndHoppinglist = new ArrayList<String>();
		jumpingAndHoppinglist.add("yes");
		jumpingAndHoppinglist.add("no");
		jumpingAndHoppinglist.add("unknown");
		referenceDataMap.put("jumpingAndHopping", jumpingAndHoppinglist);

		// The Autonomic Nervous System

		ArrayList<String> bloodPressurelist = new ArrayList<String>();
		bloodPressurelist.add("normal");
		bloodPressurelist.add("abnormal");
		bloodPressurelist.add("unknown");
		referenceDataMap.put("bloodPressure", bloodPressurelist);

		ArrayList<String> pulselist = new ArrayList<String>();
		pulselist.add("normal");
		pulselist.add("abnormal");
		pulselist.add("unknown");
		referenceDataMap.put("pulse", pulselist);

		ArrayList<String> deepBreathsTestlist = new ArrayList<String>();
		deepBreathsTestlist.add("normal");
		deepBreathsTestlist.add("abnormal");
		deepBreathsTestlist.add("unknown");
		referenceDataMap.put("deepBreathsTest", deepBreathsTestlist);

		ArrayList<String> handgripTestlist = new ArrayList<String>();
		handgripTestlist.add("normal");
		handgripTestlist.add("abnormal");
		handgripTestlist.add("unknown");
		referenceDataMap.put("handgripTest", handgripTestlist);

		ArrayList<String> valsalvaTestlist = new ArrayList<String>();
		valsalvaTestlist.add("normal");
		valsalvaTestlist.add("abnormal");
		valsalvaTestlist.add("unknown");
		referenceDataMap.put("valsalvaTest", valsalvaTestlist);
		
		ArrayList<String> savecaselist = new ArrayList<String>();
		savecaselist.add("no");
		savecaselist.add("yes");
		
		return referenceDataMap;
}
	
	public void setEs(HybridExpertSystem es) {
		this.es = es;
	}

	public void setCd(CaseDao cd) {
		this.cd = cd;
	}
}