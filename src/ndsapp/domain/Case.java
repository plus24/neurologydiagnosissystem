/**
 A <code>Case</code> object represents a patient's case
 which holds all the information of the patient including all the symptoms.

 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     3.0
 */

package ndsapp.domain;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Case implements Serializable {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	private Integer caseId;
	private String caseFirstName;
	private String caseMiddleName;
	private String caseLastName;
	private String visitDate;
	private String address;
	private String phoneNo;
	private String emailId;
	private String gender;
	private Integer age;
	private String occupation;
	private String smoking;
	private String drinkingAlcohol;
	
	private Integer hmfId;	
	private String levelOfConscious;
	private String behaviorState;
	private String emotionalState;
	private String dysarthia;
	private String fluencyAndProsody;
	private String repetition;
	private String naming;
	private String reading;
	private String writing;
	private String memory;

	private String astereognosis;
	private String agraphaesthesia;
	private String visualAnosognosia;
	private String visualIllusionsAndHallucinations;
	private String prosopagnosia;
	private String colourAgnosia;
	private String balintsSyndrome;
	
	private Integer cnId;
	private String smell;	
	private String visualAcuity;
	private String movingFingerTest;
	private String redPinConfrontation;
	private String binocularTesting;
	private String colourVision;
	private String funduscopy;
	
	private String ocularMotilityTest;
	private String diplopia;
	private String PupilaryLightReaction;
	private String ophthalmic;
	private String maxillary;
	private String mandibular;
	private String cornealReflexes;
	private String clenchingOfTeeth;
	private String jewJerk;
	private String sensory;
	private String motor;
	private String taste;
	private String rinnesTest;
	private String webersTest;
	private String pharyngealReflex;
	private String nasalRegurgitation;
	private String palatalDysarthria;
	private String patalElevation;
	private String assessmentOfLarynx;
	private String shoulderShrugging;
	private String headRotation;	
	private String tongue;
	
	private Integer ltId;
	private String wasting;
	private String fasciculation;
	private String skinLesions;
	private String toneAtWrist;
	private String toneAtElbows;  
	private String toneAtKness;  
	private String toneAtAnkles; 
	private String ankleClonus;  
	private String power;  
	private String jawJerk;   
	private String bicepsJerk;  
	private String supinatorJerk; 
	private String tricepsJerk;   
	private String kneeJerk;    
	private String ankleJerk;   
	private String gornealAndPalatalReflex;   
	private String cremastericReflex; 
	private String plantarReflex;   
	private String sphinctericReflex;  
	private String swallowing;   
	private String micturition; 
	private String defecation;  
	private String fingerNoseTest;     
	private String dysdiadochokinesis;
	private String fineMovements;  
	private String heelShinTest;  
	private String pinprick; 
	private String temperature; 
	private String lightTouch;  
	private String vibrationSense;    
	private String jointPositionSense;    
	private String twoPointDiscrimination; 
	
	private Integer gsId;
	private String walkingPattern;  
	private String standingWFTAndEyesClosed;
	private String walkingHeelToToe;  
	private String jumpingAndHopping;   
	
	private Integer ansId;
	private String bloodPressure; 
	private String pulse; 
	private String deepBreathsTest;
	private String handgripTest; 
	private String valsalvaTest;
	
	private String savecase;
	private float similarity;
	
	private String description;
	private String solution;
	private String management;
	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseFirstName() {
		return caseFirstName;
	}
	public void setCaseFirstName(String caseFirstName) {
		this.caseFirstName = caseFirstName;
	}
	public String getCaseMiddleName() {
		return caseMiddleName;
	}
	public void setCaseMiddleName(String caseMiddleName) {
		this.caseMiddleName = caseMiddleName;
	}
	public String getTongue() {
		return tongue;
	}
	public void setTongue(String tongue) {
		this.tongue = tongue;
	}
	public String getCaseLastName() {
		return caseLastName;
	}
	public void setCaseLastName(String caseLastName) {
		this.caseLastName = caseLastName;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getDrinkingAlcohol() {
		return drinkingAlcohol;
	}
	public void setDrinkingAlcohol(String drinkingAlcohol) {
		this.drinkingAlcohol = drinkingAlcohol;
	}
	public Integer getHmfId() {
		return hmfId;
	}
	public void setHmfId(Integer hmfId) {
		this.hmfId = hmfId;
	}
	public String getLevelOfConscious() {
		return levelOfConscious;
	}
	public void setLevelOfConscious(String levelOfConscious) {
		this.levelOfConscious = levelOfConscious;
	}
	public String getBehaviorState() {
		return behaviorState;
	}
	public void setBehaviorState(String behaviorState) {
		this.behaviorState = behaviorState;
	}
	public String getEmotionalState() {
		return emotionalState;
	}
	public void setEmotionalState(String emotionalState) {
		this.emotionalState = emotionalState;
	}
	public String getDysarthia() {
		return dysarthia;
	}
	public void setDysarthia(String dysarthia) {
		this.dysarthia = dysarthia;
	}
	public String getFluencyAndProsody() {
		return fluencyAndProsody;
	}
	public void setFluencyAndProsody(String fluencyAndProsody) {
		this.fluencyAndProsody = fluencyAndProsody;
	}
	public String getRepetition() {
		return repetition;
	}
	public void setRepetition(String repetition) {
		this.repetition = repetition;
	}
	public String getNaming() {
		return naming;
	}
	public void setNaming(String naming) {
		this.naming = naming;
	}
	public String getReading() {
		return reading;
	}
	public void setReading(String reading) {
		this.reading = reading;
	}
	public String getWriting() {
		return writing;
	}
	public void setWriting(String writing) {
		this.writing = writing;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getAstereognosis() {
		return astereognosis;
	}
	public void setAstereognosis(String astereognosis) {
		this.astereognosis = astereognosis;
	}
	public String getAgraphaesthesia() {
		return agraphaesthesia;
	}
	public void setAgraphaesthesia(String agraphaesthesia) {
		this.agraphaesthesia = agraphaesthesia;
	}
	public String getVisualAnosognosia() {
		return visualAnosognosia;
	}
	public void setVisualAnosognosia(String visualAnosognosia) {
		this.visualAnosognosia = visualAnosognosia;
	}
	public String getVisualIllusionsAndHallucinations() {
		return visualIllusionsAndHallucinations;
	}
	public void setVisualIllusionsAndHallucinations(
			String visualIllusionsAndHallucinations) {
		this.visualIllusionsAndHallucinations = visualIllusionsAndHallucinations;
	}
	public String getProsopagnosia() {
		return prosopagnosia;
	}
	public void setProsopagnosia(String prosopagnosia) {
		this.prosopagnosia = prosopagnosia;
	}
	public String getColourAgnosia() {
		return colourAgnosia;
	}
	public void setColourAgnosia(String colourAgnosia) {
		this.colourAgnosia = colourAgnosia;
	}
	public String getBalintsSyndrome() {
		return balintsSyndrome;
	}
	public void setBalintsSyndrome(String balintsSyndrome) {
		this.balintsSyndrome = balintsSyndrome;
	}
	public Integer getCnId() {
		return cnId;
	}
	public void setCnId(Integer cnId) {
		this.cnId = cnId;
	}
	public String getSmell() {
		return smell;
	}
	public void setSmell(String smell) {
		this.smell = smell;
	}
	public String getVisualAcuity() {
		return visualAcuity;
	}
	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}
	public String getMovingFingerTest() {
		return movingFingerTest;
	}
	public void setMovingFingerTest(String movingFingerTest) {
		this.movingFingerTest = movingFingerTest;
	}
	public String getRedPinConfrontation() {
		return redPinConfrontation;
	}
	public void setRedPinConfrontation(String redPinConfrontation) {
		this.redPinConfrontation = redPinConfrontation;
	}
	public String getBinocularTesting() {
		return binocularTesting;
	}
	public void setBinocularTesting(String binocularTesting) {
		this.binocularTesting = binocularTesting;
	}
	public String getColourVision() {
		return colourVision;
	}
	public void setColourVision(String colourVision) {
		this.colourVision = colourVision;
	}
	public String getFunduscopy() {
		return funduscopy;
	}
	public void setFunduscopy(String funduscopy) {
		this.funduscopy = funduscopy;
	}
	public String getOcularMotilityTest() {
		return ocularMotilityTest;
	}
	public void setOcularMotilityTest(String ocularMotilityTest) {
		this.ocularMotilityTest = ocularMotilityTest;
	}
	public String getDiplopia() {
		return diplopia;
	}
	public void setDiplopia(String diplopia) {
		this.diplopia = diplopia;
	}
	public String getPupilaryLightReaction() {
		return PupilaryLightReaction;
	}
	public void setPupilaryLightReaction(String pupilaryLightReaction) {
		PupilaryLightReaction = pupilaryLightReaction;
	}
	public String getOphthalmic() {
		return ophthalmic;
	}
	public void setOphthalmic(String ophthalmic) {
		this.ophthalmic = ophthalmic;
	}
	public String getMaxillary() {
		return maxillary;
	}
	public void setMaxillary(String maxillary) {
		this.maxillary = maxillary;
	}
	public String getMandibular() {
		return mandibular;
	}
	public void setMandibular(String mandibular) {
		this.mandibular = mandibular;
	}
	public String getCornealReflexes() {
		return cornealReflexes;
	}
	public void setCornealReflexes(String cornealReflexes) {
		this.cornealReflexes = cornealReflexes;
	}
	public String getClenchingOfTeeth() {
		return clenchingOfTeeth;
	}
	public void setClenchingOfTeeth(String clenchingOfTeeth) {
		this.clenchingOfTeeth = clenchingOfTeeth;
	}
	public String getJewJerk() {
		return jewJerk;
	}
	public void setJewJerk(String jewJerk) {
		this.jewJerk = jewJerk;
	}
	public String getSensory() {
		return sensory;
	}
	public void setSensory(String sensory) {
		this.sensory = sensory;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getPharyngealReflex() {
		return pharyngealReflex;
	}
	public void setPharyngealReflex(String pharyngealReflex) {
		this.pharyngealReflex = pharyngealReflex;
	}
	public String getNasalRegurgitation() {
		return nasalRegurgitation;
	}
	public void setNasalRegurgitation(String nasalRegurgitation) {
		this.nasalRegurgitation = nasalRegurgitation;
	}
	public String getPalatalDysarthria() {
		return palatalDysarthria;
	}
	public void setPalatalDysarthria(String palatalDysarthria) {
		this.palatalDysarthria = palatalDysarthria;
	}
	public String getPatalElevation() {
		return patalElevation;
	}
	public void setPatalElevation(String patalElevation) {
		this.patalElevation = patalElevation;
	}
	public String getAssessmentOfLarynx() {
		return assessmentOfLarynx;
	}
	public void setAssessmentOfLarynx(String assessmentOfLarynx) {
		this.assessmentOfLarynx = assessmentOfLarynx;
	}
	public String getShoulderShrugging() {
		return shoulderShrugging;
	}
	public void setShoulderShrugging(String shoulderShrugging) {
		this.shoulderShrugging = shoulderShrugging;
	}
	public String getHeadRotation() {
		return headRotation;
	}
	public void setHeadRotation(String headRotation) {
		this.headRotation = headRotation;
	}
	public Integer getLtId() {
		return ltId;
	}
	public void setLtId(Integer ltId) {
		this.ltId = ltId;
	}
	public String getWasting() {
		return wasting;
	}
	public void setWasting(String wasting) {
		this.wasting = wasting;
	}
	public String getFasciculation() {
		return fasciculation;
	}
	public void setFasciculation(String fasciculation) {
		this.fasciculation = fasciculation;
	}
	public String getSkinLesions() {
		return skinLesions;
	}
	public void setSkinLesions(String skinLesions) {
		this.skinLesions = skinLesions;
	}
	public String getToneAtWrist() {
		return toneAtWrist;
	}
	public void setToneAtWrist(String toneAtWrist) {
		this.toneAtWrist = toneAtWrist;
	}
	public String getToneAtElbows() {
		return toneAtElbows;
	}
	public void setToneAtElbows(String toneAtElbows) {
		this.toneAtElbows = toneAtElbows;
	}
	public String getToneAtKness() {
		return toneAtKness;
	}
	public void setToneAtKness(String toneAtKness) {
		this.toneAtKness = toneAtKness;
	}
	public String getToneAtAnkles() {
		return toneAtAnkles;
	}
	public void setToneAtAnkles(String toneAtAnkles) {
		this.toneAtAnkles = toneAtAnkles;
	}
	public String getAnkleClonus() {
		return ankleClonus;
	}
	public void setAnkleClonus(String ankleClonus) {
		this.ankleClonus = ankleClonus;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getJawJerk() {
		return jawJerk;
	}
	public void setJawJerk(String jawJerk) {
		this.jawJerk = jawJerk;
	}
	public String getBicepsJerk() {
		return bicepsJerk;
	}
	public void setBicepsJerk(String bicepsJerk) {
		this.bicepsJerk = bicepsJerk;
	}
	public String getSupinatorJerk() {
		return supinatorJerk;
	}
	public void setSupinatorJerk(String supinatorJerk) {
		this.supinatorJerk = supinatorJerk;
	}
	public String getTricepsJerk() {
		return tricepsJerk;
	}
	public void setTricepsJerk(String tricepsJerk) {
		this.tricepsJerk = tricepsJerk;
	}
	public String getKneeJerk() {
		return kneeJerk;
	}
	public void setKneeJerk(String kneeJerk) {
		this.kneeJerk = kneeJerk;
	}
	public String getAnkleJerk() {
		return ankleJerk;
	}
	public void setAnkleJerk(String ankleJerk) {
		this.ankleJerk = ankleJerk;
	}
	public String getGornealAndPalatalReflex() {
		return gornealAndPalatalReflex;
	}
	public void setGornealAndPalatalReflex(String gornealAndPalatalReflex) {
		this.gornealAndPalatalReflex = gornealAndPalatalReflex;
	}
	public String getCremastericReflex() {
		return cremastericReflex;
	}
	public void setCremastericReflex(String cremastericReflex) {
		this.cremastericReflex = cremastericReflex;
	}
	public String getPlantarReflex() {
		return plantarReflex;
	}
	public void setPlantarReflex(String plantarReflex) {
		this.plantarReflex = plantarReflex;
	}
	public String getSphinctericReflex() {
		return sphinctericReflex;
	}
	public void setSphinctericReflex(String sphinctericReflex) {
		this.sphinctericReflex = sphinctericReflex;
	}
	public String getSwallowing() {
		return swallowing;
	}
	public void setSwallowing(String swallowing) {
		this.swallowing = swallowing;
	}
	public String getMicturition() {
		return micturition;
	}
	public void setMicturition(String micturition) {
		this.micturition = micturition;
	}
	public String getDefecation() {
		return defecation;
	}
	public void setDefecation(String defecation) {
		this.defecation = defecation;
	}
	public String getFingerNoseTest() {
		return fingerNoseTest;
	}
	public void setFingerNoseTest(String fingerNoseTest) {
		this.fingerNoseTest = fingerNoseTest;
	}
	public String getDysdiadochokinesis() {
		return dysdiadochokinesis;
	}
	public void setDysdiadochokinesis(String dysdiadochokinesis) {
		this.dysdiadochokinesis = dysdiadochokinesis;
	}
	public String getFineMovements() {
		return fineMovements;
	}
	public void setFineMovements(String fineMovements) {
		this.fineMovements = fineMovements;
	}
	public String getHeelShinTest() {
		return heelShinTest;
	}
	public void setHeelShinTest(String heelShinTest) {
		this.heelShinTest = heelShinTest;
	}
	public String getPinprick() {
		return pinprick;
	}
	public void setPinprick(String pinprick) {
		this.pinprick = pinprick;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getLightTouch() {
		return lightTouch;
	}
	public void setLightTouch(String lightTouch) {
		this.lightTouch = lightTouch;
	}
	public String getVibrationSense() {
		return vibrationSense;
	}
	public void setVibrationSense(String vibrationSense) {
		this.vibrationSense = vibrationSense;
	}
	public String getJointPositionSense() {
		return jointPositionSense;
	}
	public void setJointPositionSense(String jointPositionSense) {
		this.jointPositionSense = jointPositionSense;
	}
	public String getTwoPointDiscrimination() {
		return twoPointDiscrimination;
	}
	public void setTwoPointDiscrimination(String twoPointDiscrimination) {
		this.twoPointDiscrimination = twoPointDiscrimination;
	}
	public Integer getGsId() {
		return gsId;
	}
	public void setGsId(Integer gsId) {
		this.gsId = gsId;
	}
	public String getWalkingPattern() {
		return walkingPattern;
	}
	public void setWalkingPattern(String walkingPattern) {
		this.walkingPattern = walkingPattern;
	}
	public String getStandingWFTAndEyesClosed() {
		return standingWFTAndEyesClosed;
	}
	public void setStandingWFTAndEyesClosed(String standingWFTAndEyesClosed) {
		this.standingWFTAndEyesClosed = standingWFTAndEyesClosed;
	}
	public String getWalkingHeelToToe() {
		return walkingHeelToToe;
	}
	public void setWalkingHeelToToe(String walkingHeelToToe) {
		this.walkingHeelToToe = walkingHeelToToe;
	}
	public String getJumpingAndHopping() {
		return jumpingAndHopping;
	}
	public void setJumpingAndHopping(String jumpingAndHopping) {
		this.jumpingAndHopping = jumpingAndHopping;
	}
	public Integer getAnsId() {
		return ansId;
	}
	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getPulse() {
		return pulse;
	}
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	public String getDeepBreathsTest() {
		return deepBreathsTest;
	}
	public void setDeepBreathsTest(String deepBreathsTest) {
		this.deepBreathsTest = deepBreathsTest;
	}
	public String getHandgripTest() {
		return handgripTest;
	}
	public void setHandgripTest(String handgripTest) {
		this.handgripTest = handgripTest;
	}
	public String getValsalvaTest() {
		return valsalvaTest;
	}
	public void setValsalvaTest(String valsalvaTest) {
		this.valsalvaTest = valsalvaTest;
	}
	public String getSavecase() {
		return savecase;
	}
	public void setSavecase(String savecase) {
		this.savecase = savecase;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	public String getRinnesTest() {
		return rinnesTest;
	}
	public void setRinnesTest(String rinnesTest) {
		this.rinnesTest = rinnesTest;
	}
	public String getWebersTest() {
		return webersTest;
	}
	public void setWebersTest(String webersTest) {
		this.webersTest = webersTest;
	}
	public float getSimilarity() {
		return similarity;
	}
	public void setSimilarity(float f) {
		this.similarity = f;
	}

	
}