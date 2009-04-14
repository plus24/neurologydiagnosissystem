use ndsdb;


insert into NDS_CASE (CaseFirstName, CaseLastName, VisitDate, Address, PhoneNo, EmailId, Gender, Age, Occupation, Smoking, DrinkingAlcohol) values ("Ashok", "Sharma", "2009-01-10", "Kopundole", "01-55987634", "asharma@gmail.com", "Male", 45, "Teacher", "no","no");

insert into NDS_CASE (CaseFirstName, CaseLastName, VisitDate, Address, PhoneNo, Gender, Age, Occupation, Smoking, DrinkingAlcohol) values ("Binod", "Shrestha", "2009-02-01", "Bhaktpur", "01-6643420", "Male", 50, "Farmer", "yes","yes");

insert into NDS_CASE (CaseFirstName, CaseLastName, VisitDate, Address, PhoneNo, EmailId, Gender, Age, Occupation, Smoking, DrinkingAlcohol) values ("Bishal", "Kumar", "2009-01-20", "Rajbiraj", "031-535680", "bishal545@hotmail.com", "Male", 25, "Engineer", "no","no");

insert into NDS_CASE (CaseFirstName, CaseLastName, VisitDate, Address, PhoneNo, EmailId, Gender, Age, Occupation, Smoking, DrinkingAlcohol) values ("Laxmi", "Banstola", "2009-03-15", "Pokhara", "061-554375", "laxmi_bastola@gmail.com", "Male", 25, "Officer", "no","no");





insert into NDS_HMF (LevelOfConscious, BehaviorState, EmotionalState, Dysarthia, Memory, CaseId) values ("alert", "clean", "normal", "normal", "normal", 1);

insert into NDS_HMF (BehaviorState, EmotionalState, Dysarthia, FluencyAndProsody,  Repetition, Naming, Reading, Writing, CaseId) values ("clean", "depressed", "normal", "normal", "normal", "normal", "normal", "normal", 2);

insert into NDS_HMF (LevelOfConscious, BehaviorState, EmotionalState, Dysarthia, Memory, CaseId) values ("alert", "clean", "normal", "normal", "normal", 3);

insert into NDS_HMF (LevelOfConscious, BehaviorState, EmotionalState, Dysarthia, FluencyAndProsody, Repetition, Naming, Reading, Writing, Memory, Astereognosis, Agraphaesthesia, VisualAnosognosia, VisualIllusionsAndHallucinations, Prosopagnosia, ColourAgnosia, BalintsSyndrome, CaseId) values ("alert","clean","depressed","normal","normal","normal","normal","normal","normal","normal","normal","normal","present","present","present","present","present",4);





insert into NDS_CN (OcularMotilityTest, ShoulderShrugging, CaseId) values ("normal", "normal power", 1);

insert into NDS_CN (MovingFingerTest, RedPinConfrontation, BinocularTesting, Funduscopy, Diplopia, PupilaryLightReaction, Ophthalmic, Maxillary, Mandibular, CornealReflexes, Tongue, CaseId) values ("normal", "normal", "normal", "normal", "no", "normal", "normal", "normal", "normal", "present", "normal", 2);

insert into NDS_CN (OcularMotilityTest, ShoulderShrugging, CaseId) values ("normal", "normal power", 3);

insert into NDS_CN (Smell, VisualAcuity, MovingFingerTest, RedPinConfrontation, BinocularTesting, ColourVision, Funduscopy, OcularMotilityTest, Diplopia, PupilaryLightReaction, Ophthalmic, Maxillary, Mandibular, CornealReflexes, ClenchingOfTeeth, JewJerk, Sensory, Motor, RinnesTest, WebersTest, Taste, PharyngealReflex, NasalRegurgitation, PalatalDysarthria, PatalElevation, AssessmentOfLarynx, ShoulderShrugging, HeadRotation, Tongue, CaseId) values ("normal","normal","normal","normal","normal","normal","normal","normal","normal","normal","normal","normal","present","normal","present","normal","normal","normal","lateralized to normal ear","normal","normal","normal","normal","normal","normal","normal","normal","normal","normal",4);




insert into NDS_LT (ToneAtElbows, ToneAtKness, AnkleClonus, Power, JawJerk, BicepsJerk, SupinatorJerk, TricepsJerk, KneeJerk, AnkleJerk, GornealAndPalatalReflex, CremastericReflex, PlantarReflex, SphinctericReflex, Swallowing, Micturition, Defecation, Pinprick, Temperature, LightTouch, VibrationSense, JointPositionSense, TwoPointDiscrimination, CaseId) values ("spastic", "spastic", "spastic", "grade 3", "very brisk", "very brisk", "very brisk", "very brisk", "very brisk", "very brisk", "present", "present", "present", "present", "present", "present", "present","abnormal", "abnormal", "abnormal", "abnormal", "abnormal", "abnormal", 1);
							

insert into NDS_LT (Fasciculation, ToneAtWrist, ToneAtElbows, ToneAtKness, ToneAtAnkles, AnkleClonus, JawJerk, BicepsJerk, SupinatorJerk, TricepsJerk, KneeJerk, AnkleJerk, CremastericReflex, Pinprick, Temperature, VibrationSense, CaseId) values ("no", "spastic", "spastic", "spastic", "spastic", "spastic", "absent", "absent", "absent", "absent", "absent", "absent", "absent", "abnormal", "abnormal", "abnormal", 2);

insert into NDS_LT (Power, JawJerk, BicepsJerk, SupinatorJerk, TricepsJerk, KneeJerk, AnkleJerk, Pinprick, VibrationSense, CaseId) values ("grade 2","absent","absent","absent","absent","absent","absent","abnormal","abnormal",3);

insert into NDS_LT (ToneAtWrist, ToneAtElbows, ToneAtKness, ToneAtAnkles, AnkleClonus, Power, JawJerk, BicepsJerk, SupinatorJerk, TricepsJerk, KneeJerk, AnkleJerk, PlantarReflex, Pinprick, Temperature, LightTouch, VibrationSense, JointPositionSense, CaseId) values ("spastic","spastic","spastic","spastic","spastic","grade 2","brisk","brisk","brisk","brisk","brisk","brisk","present","abnormal","abnormal","abnormal","abnormal","abnormal",4);							







insert into NDS_ANS (BloodPressure, Pulse, DeepBreathsTest, CaseId) values ("abnormal", "abnormal", "abnormal", 2);






insert into NDS_SOLUTION (Description, Solution, Management, CaseId) values ("<p>The patient has 6-year history of rheumatoid arthritis. He had been treated with various anti-inflammatory drugs, but no steroids, in spite of which his condition steadily deteriorated. Three weeks before admission he developed an acute flare-up of disease activity, which necessitated hospitalization. At this stage he was still walking, although with difficulty, aided by crutches.</p>", "<p>Haematological investigations supported the diagnosis of active seropositive rheumatoid arthritis. The serum aldolase level was elevated at 64 units (normal 5 - 31 units).</p>", "<p>The patient was placed on a Stryker frame and skull traction was applied. Within hours his sensory state began to improve and soon he had regained normal skin sensation.
There was also improvement in the motor power in his arms, and his muscle spasm began to decrease. The skull traction was removed and the patient was fitted with a cervical brace. He was subsequently discharged in a wheelchair for further management on an outpatient basis.</p>
", 1);

insert into NDS_SOLUTION (Description, Solution, Management, CaseId) values ("<p>The patient underwent hiatal hernia repair in the 1980s; he also reported having hay fever and admitted to occasional cocaine use. For the previous 2 months, he had noted mild shortness of breath and chest tightness upon climbing stairs. However, he had not seen a physician for any of his symptoms.
He works as a technician for a local technology firm and reported no chemical exposures. He is married, and admitted to drinking alcohol occasionally and smoking crack cocaine intermittently. He has a remote history of alcohol abuse. He denied use of other illicit drugs or herbal medications. He has no known drug allergies and was taking no medication at the time of admission. 
</p>", "<p>The patient had a C2-C3 spinal cord ischemic infarct as shown on spinal MRI. The constellation of quadriparesis, spinothalamic sensory loss with sparing of posterior columns, and sphincter dysfunction is most suggestive of an anterior spinal cord syndrome. The areflexia may reflect spinal cord shock. (In subsequent days, the patient became hyperreflexic.) Given the association of the onset of symptoms with his cocaine use, the most likely etiology is cocaine-induced spinal cord infarct. Further work-ups for other etiologies proved negative.</p>", "<p>He was incubated for respiratory support and was admitted to the medical intensive care unit for over 8 days. He was later transferred to a rehab facility and has remained wheelchair-bound.</p>

", 2);

insert into NDS_SOLUTION (Description, Solution, Management, CaseId) values ("<p>MRI of the spinal cord, arranged acutely to exclude compressive or inflammatory disease. This proved normal. 
Lumbar puncture was undertaken for CSF analysis. CSF protein was elevated (1.49 g/l; normal range 0.1–0.45 g/l) with normal glucose (3.8 mmol/l; plasma glucose = 6.7 mmol/l). CSF cell count showed <5 red cells and 14 white cells (normal range <7). Cytology showed these cells to be lymphocytes and macrophages, but no neoplastic cells were seen. CSF oligoclonal band analysis showed a type 4 pattern with multiple matching bands, a finding consistent with systemic inflammation.
Routine blood tests showed normal haematological parameters and blood electrolytes. Liver-related enzymes (alkaline phosphatase, aspartate transaminase, gamma-glutamyltransferase) were elevated but with normal bilirubin and clotting parameters.</p>
", "<p>In light of the clinical, neurophysiological, and CSF findings, a provisional diagnosis of GBS was made.
Evidence-based treatment guidelines for GBS recommend either plasma exchange or intravenous immunoglobulin (IVIg) as the initial treatment of choice. Since the latter was more practical, the patient received a course of IVIg at 1 g/day for three consecutive days.</p>
", "<p>No neurological improvement was observed following treatment with IVIg. The patient developed a chest infection and died two weeks later. Permission for autopsy was not granted. The family gave consent for the publication of this case report.</p>", 3);


insert into NDS_SOLUTION (Description, Solution, CaseId) values ("<p>The patient’s haemogram, kidney function tests, liver function tests, blood sugar (fasting and postprandial) were normal. Antinuclear antibodies and rheumatoid factor were negative. S. calcium, magnesium and phosphorus levels were normal, and alkaline phosphatase level was raised.</p>", "<p>Many cases of fluorosis are minor enough not to need treatment or the fluorosis may occur only on the back teeth, where it can't be seen. More serious cases and cases involving the front teeth can be treated by removing the surface-stained areas through tooth whitening or other procedures. Severe cases of fluorosis can be covered with restorations, such as bonding, crowns or veneers.</p>", 4);
