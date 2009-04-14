USE ndsdb;

DROP TABLE IF EXISTS NDS_HMF;
DROP TABLE IF EXISTS NDS_CN;
DROP TABLE IF EXISTS NDS_LT;
DROP TABLE IF EXISTS NDS_GS;
DROP TABLE IF EXISTS NDS_ANS;
DROP TABLE IF EXISTS NDS_SOLUTION;
DROP TABLE IF EXISTS NDS_CASE;

CREATE TABLE NDS_CASE (
	CaseId int AUTO_INCREMENT NOT NULL,
	CaseFirstName varchar (30) NOT NULL,
	CaseLastName varchar (30)  NULL,
	VisitDate date NULL,
	Address varchar(100) NULL,
	PhoneNo varchar(60) NULL,
	EmailId varchar(80)  NULL,
	Gender varchar (15)  NULL,
	Age int NULL,
	Occupation varchar(30) NULL,
	Smoking varchar(30) NULL,
	DrinkingAlcohol varchar(30) NULL,
	PRIMARY KEY (CaseId),
	INDEX (CaseId)	
);

CREATE TABLE NDS_HMF (
	HmfId int AUTO_INCREMENT NOT NULL,
	LevelOfConscious  varchar (30) NULL,	
	BehaviorState varchar (30) NULL,
	EmotionalState varchar (30) NULL,
	Dysarthia varchar (30) NULL,
	FluencyAndProsody  varchar (30)  NULL,
	Repetition varchar (30) NULL,
	Naming varchar (30) NULL,
	Reading varchar (30) NULL,
	Writing varchar (30) NULL,
	Memory varchar (30) NULL,
	Astereognosis varchar (30) NULL,
	Agraphaesthesia varchar (30) NULL,
	VisualAnosognosia varchar (30) NULL,
	VisualIllusionsAndHallucinations  varchar (30) NULL,
	Prosopagnosia varchar (30) NULL,
	ColourAgnosia  varchar (30) NULL,
	BalintsSyndrome  varchar (30) NULL,
	CaseId int NOT NULL,	
	PRIMARY KEY (HmfId),
	INDEX (HmfId),
	FOREIGN KEY(CaseId) REFERENCES NDS_CASE(CaseId) ON UPDATE CASCADE ON DELETE CASCADE
	
);

CREATE TABLE NDS_CN (
	CnId int AUTO_INCREMENT NOT NULL,
	Smell   varchar (30) NULL,	
	VisualAcuity   varchar (30) NULL,
	MovingFingerTest  varchar (30) NULL,
	RedPinConfrontation   varchar (30)  NULL,
	BinocularTesting    varchar (30) NULL,
	ColourVision    varchar (30) NULL,
	Funduscopy varchar (30) NULL,
	OcularMotilityTest varchar (30) NULL,
	Diplopia  varchar (30)  NULL,
	PupilaryLightReaction  varchar (30) NULL,
	Ophthalmic  varchar (30) NULL,
	Maxillary varchar (30) NULL,
	Mandibular  varchar (30) NULL,
	CornealReflexes   varchar (30) NULL,
	ClenchingOfTeeth   varchar (30) NULL,
	JewJerk  varchar(30) NULL,
	Sensory varchar (30) NULL,
	Motor  varchar (30) NULL,
	RinnesTest  varchar (30) NULL,
	WebersTest  varchar (30) NULL,
	Taste varchar (30) NULL,
	PharyngealReflex   varchar (30) NULL,
	NasalRegurgitation   varchar (30) NULL,
	PalatalDysarthria  varchar (30) NULL,
	PatalElevation   varchar (30) NULL,
	AssessmentOfLarynx    varchar (30) NULL,
	ShoulderShrugging  varchar (30) NULL,
	HeadRotation  varchar (30) NULL,
	Tongue  varchar (30) NULL,
	CaseId int NOT NULL,
	PRIMARY KEY (CnId),
	INDEX (CnId),
	FOREIGN KEY(CaseId) REFERENCES NDS_CASE(CaseId) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE NDS_LT (
	LtId int AUTO_INCREMENT NOT NULL,
	Wasting   varchar (30) NULL,	
	Fasciculation   varchar (30) NULL,
	SkinLesions   varchar (30) NULL,
	ToneAtWrist   varchar(30) NULL,
	ToneAtElbows  varchar (30) NULL,
	ToneAtKness   varchar (30) NULL,
	ToneAtAnkles    varchar (30) NULL,
	AnkleClonus  varchar (30) NULL,
	Power  varchar (30) NULL,
	JawJerk   varchar (30) NULL,
	BicepsJerk  varchar (30) NULL,
	SupinatorJerk  varchar (30) NULL,
	TricepsJerk    varchar (30) NULL,
	KneeJerk    varchar (30) NULL,
	AnkleJerk   varchar (30) NULL,
	GornealAndPalatalReflex    varchar (30) NULL,
	CremastericReflex   varchar (30) NULL,
	PlantarReflex   varchar (30) NULL,
	SphinctericReflex    varchar (30) NULL,	
	Swallowing   varchar (30) NULL,
	Micturition  varchar (30) NULL,
	Defecation   varchar (30)  NULL,
	FingerNoseTest     varchar (30) NULL,
	Dysdiadochokinesis varchar (30) NULL,
	FineMovements  varchar (30) NULL,
	HeelShinTest  varchar (30)  NULL,
	Pinprick varchar (30) NULL,
	Temperature varchar (30) NULL,
	LightTouch   varchar (30) NULL,
	VibrationSense    varchar (30) NULL,
	JointPositionSense    varchar (30) NULL,
	TwoPointDiscrimination   varchar(30) NULL,
	CaseId int NOT NULL,	
	PRIMARY KEY (LtId),
	INDEX (LtId),
	FOREIGN KEY(CaseId) REFERENCES NDS_CASE(CaseId) ON UPDATE CASCADE ON DELETE CASCADE
		
);

CREATE TABLE NDS_GS (
	GsId int AUTO_INCREMENT NOT NULL,
	WalkingPattern   varchar (30) NULL,	
	StandingWFTAndEyesClosed  varchar (30) NULL,
	WalkingHeelToToe  varchar (30) NULL,
	JumpingAndHopping   varchar (30)  NULL,
	CaseId int NOT NULL,	
	PRIMARY KEY (GsId),
	INDEX (GsId),
	FOREIGN KEY(CaseId) REFERENCES NDS_CASE(CaseId) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE NDS_ANS (
	AnsId int AUTO_INCREMENT NOT NULL,
	BloodPressure varchar (30) NULL,	
	Pulse varchar (30) NULL,
	DeepBreathsTest varchar (30) NULL,
	HandgripTest varchar (30)  NULL,
	ValsalvaTest varchar (30)  NULL,
	CaseId int NOT NULL,
	PRIMARY KEY (AnsId),
	INDEX (AnsId),
	FOREIGN KEY(CaseId) REFERENCES NDS_CASE(CaseId) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE NDS_SOLUTION (
	SolnId int AUTO_INCREMENT NOT NULL,
	Description varchar (1000) NULL,	
	Management varchar (1000) NULL,
	Solution varchar (1000) NULL,
	CaseId int NOT NULL,
	PRIMARY KEY (SolnId),
	INDEX (SolnId),
	FOREIGN KEY(CaseId) REFERENCES NDS_CASE(CaseId) ON UPDATE CASCADE ON DELETE CASCADE
);
