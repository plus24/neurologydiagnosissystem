USE ndsdb;

DROP TABLE IF EXISTS rulebase;
DROP TABLE IF EXISTS instruction;
DROP TABLE IF EXISTS coderesolver;

CREATE TABLE coderesolver (
	code int NOT NULL,
	text varchar (2000) NOT NULL,
	INDEX (code),
	PRIMARY KEY (code)
	);

CREATE TABLE instruction (
	instructionid int AUTO_INCREMENT NOT NULL,	
	infocode int NOT NULL,
	infotext varchar (14000) NOT NULL,
	PRIMARY KEY(instructionid),
	INDEX (instructionid),
	FOREIGN KEY(infocode) REFERENCES coderesolver(code)
	);

CREATE TABLE rulebase (
	ruleid int AUTO_INCREMENT NOT NULL,	
	rootnode boolean NOT NULL,	
	ifcode int NOT NULL,
	thencode int NOT NULL,
	leafnode boolean NOT NULL,
	PRIMARY KEY(ruleid),
	INDEX (ifcode),
	INDEX (thencode),
	FOREIGN KEY(ifcode) REFERENCES coderesolver(code),
	FOREIGN KEY(thencode) REFERENCES coderesolver(code) 
	);

-- level 1
insert into  coderesolver ( code, text) values (0, 'Root Node');

-- level 2 
insert into  coderesolver ( code, text) values (1, 'Pain');
insert into  coderesolver ( code, text) values (2, 'Alterations in Body Temperature');
insert into  coderesolver ( code, text) values (3, 'Nervous System Disfunction');
insert into  coderesolver ( code, text) values (4, 'Disorders of Eyes, Ears, Nose, and Throat');
insert into  coderesolver ( code, text) values (5, 'Alterations in Circulatory and Respiratory Functions');
insert into  coderesolver ( code, text) values (6, 'Alterations in Gastrointestinal Function');
insert into  coderesolver ( code, text) values (7, 'Alterations in Renal and Urinary Tract Function');
insert into  coderesolver ( code, text) values (8, 'Alterations in Sexual Function and Reproduction');
insert into  coderesolver ( code, text) values (9, 'Alterations in the Skin');
insert into  coderesolver ( code, text) values (10, 'Hematologic Alterations');

-- level 3
insert into  coderesolver ( code, text) values (101, 'Pain:Pathophysiology and Management');
insert into  coderesolver ( code, text) values (102, 'Chest Discomfort');
insert into  coderesolver ( code, text) values (103, 'Abdominal Pain');
insert into  coderesolver ( code, text) values (104, 'Headache');
insert into  coderesolver ( code, text) values (105, 'Back and Neck Pain');

insert into  coderesolver ( code, text) values (111, 'Fever and Hyperthermia');
insert into  coderesolver ( code, text) values (112, 'Fever and Rash');
insert into  coderesolver ( code, text) values (113, 'Atlas of Rashes Associated with Fever');
insert into  coderesolver ( code, text) values (114, 'Fever of Unknown Origin');
insert into  coderesolver ( code, text) values (115, 'Hypothermia and Frostbite');

insert into  coderesolver ( code, text) values (121, 'Syncope.');
insert into  coderesolver ( code, text) values (122, 'Dizziness and Vertigo');
insert into  coderesolver ( code, text) values (123, 'Weakness and Paralysis');
insert into  coderesolver ( code, text) values (124, 'Gait and Balance Disorder');
insert into  coderesolver ( code, text) values (125, 'Numbness, Tingling and Sensory Loss');
insert into  coderesolver ( code, text) values (126, 'Confusion and Delirium');
insert into  coderesolver ( code, text) values (127, 'Memory Loss');
insert into  coderesolver ( code, text) values (128, 'Aphasia, Memory Loss and Other facial cerebral disorders');
insert into  coderesolver ( code, text) values (129, 'Sleep Disorders');

insert into  coderesolver ( code, text) values (131, 'Disorders of the Eye');
insert into  coderesolver ( code, text) values (132, 'Disorders of Smell, Taste, and Hearing');
insert into  coderesolver ( code, text) values (133, 'Pharyngitis, Sinusitis, Otitis, and Other Upper');
insert into  coderesolver ( code, text) values (134, 'Respiratory Tract Infections');
insert into  coderesolver ( code, text) values (135, 'Oral Manifestations of Disease');
insert into  coderesolver ( code, text) values (136, 'Atlas of Oral Manifestations of Disease');

insert into  coderesolver ( code, text) values (141, 'Dyspnea and Pulmonary Edema');
insert into  coderesolver ( code, text) values (142, 'Cough and Hemoptysis');
insert into  coderesolver ( code, text) values (143, 'Hypoxia and Cyanosis');
insert into  coderesolver ( code, text) values (144, 'Approach to the Patient with a Heart Murmur');
insert into  coderesolver ( code, text) values (145, 'Palpitations');

insert into  coderesolver ( code, text) values (151, 'Dysphagia');
insert into  coderesolver ( code, text) values (152, 'Nausea, Vomiting, and Indigestion');
insert into  coderesolver ( code, text) values (153, 'Diarrhea and Constipation');
insert into  coderesolver ( code, text) values (154, 'Weight Loss');
insert into  coderesolver ( code, text) values (155, 'Gastrointestinal Bleeding');
insert into  coderesolver ( code, text) values (156, 'Jaundice');
insert into  coderesolver ( code, text) values (157, 'Abdominal Swelling and Ascites');

insert into  coderesolver ( code, text) values (161, 'Azotemia and Urinary Abnormalities');
insert into  coderesolver ( code, text) values (162, 'Atlas of Urinary Sediments and Renal Biopsies');
insert into  coderesolver ( code, text) values (163, 'Fluid and Electrolyte Disturbances');
insert into  coderesolver ( code, text) values (164, 'Hypercalcemia and Hypocalcemia');
insert into  coderesolver ( code, text) values (165, 'Acidosis and Alkalosis');

insert into  coderesolver ( code, text) values (171, 'Sexual Dysfunction');
insert into  coderesolver ( code, text) values (172, 'Hirsutism and Virilization');
insert into  coderesolver ( code, text) values (173, 'Menstrual Disorders and Pelvic Pain');

insert into  coderesolver ( code, text) values (181, 'Approach to the Patient with a Skin Disorder');
insert into  coderesolver ( code, text) values (182, 'Eczema, Psoriasis, Cutaneous Infections, Acne, and Other Common Skin Disorders');
insert into  coderesolver ( code, text) values (183, 'Skin Manifestations of Internal Disease');
insert into  coderesolver ( code, text) values (184, 'Immunologically Mediated Skin Diseases');
insert into  coderesolver ( code, text) values (185, 'Cutaneous Drug Reactions');
insert into  coderesolver ( code, text) values (186, 'Photosensitivity and Other Reactions to Light');
insert into  coderesolver ( code, text) values (187, 'Atlas of Skin Manifestations of Internal Disease');

insert into  coderesolver ( code, text) values (191, 'Anemia and Polycythemia');
insert into  coderesolver ( code, text) values (192, 'Bleeding and Thrombosis');
insert into  coderesolver ( code, text) values (193, 'Enlargement of Lymph Nodes and Spleen');
insert into  coderesolver ( code, text) values (194, 'Disorders of Granulocytes and Monocytes');
insert into  coderesolver ( code, text) values (195, 'Atlas of Hematology and Analysis of Peripheral Blood Smears');


-- level 4 - for weakness and paralysis
insert into  coderesolver ( code, text) values (201, 'Hemiparesis');
insert into  coderesolver ( code, text) values (202, 'Pareparesis');
insert into  coderesolver ( code, text) values (203, 'Quadriparesis or Generalized Weakness');
insert into  coderesolver ( code, text) values (204, 'Monoparesis');
insert into  coderesolver ( code, text) values (205, 'Distal Weakness');
insert into  coderesolver ( code, text) values (206, 'Proximal Weakness');
insert into  coderesolver ( code, text) values (207, 'Weakness in Restricted Distribution');


-- level 5 approach to the patient with neurologic disease
insert into  coderesolver ( code, text) values (301, 'The neurologic history');


-- level 6 begin neurologic examination
insert into  coderesolver ( code, text) values (401, 'Begin neurologic examination');


-- level 7 the neurologic examination
insert into  coderesolver ( code, text) values (501, 'Examine the Motor System of the Limbs and Trunk');
insert into  coderesolver ( code, text) values (502, 'Examine the Sensory System of the Limbs and Trunk');
insert into  coderesolver ( code, text) values (503, 'Examine Level of Consciuosness');
insert into  coderesolver ( code, text) values (504, 'Examine Cognitive Function');
insert into  coderesolver ( code, text) values (505, 'Examine Cranial Nerves');
insert into  coderesolver ( code, text) values (506, 'Examine Eye Movements and Pupils');
insert into  coderesolver ( code, text) values (507, 'Examine Trigeminal Nerve (V)');
insert into  coderesolver ( code, text) values (508, 'Examine Facial Nerve (V)');
insert into  coderesolver ( code, text) values (509, 'Examine Vestibulocochlear Nerve (VIII)');
insert into  coderesolver ( code, text) values (510, 'Examine Vagus Nerve (X)');
insert into  coderesolver ( code, text) values (511, 'Examine Glossopharyngeal Nerve (XII)');
insert into  coderesolver ( code, text) values (512, 'Examine Hypoglossal Nerve (XII)');
insert into  coderesolver ( code, text) values (513, 'Examine Accessory Nerve (XI)');
insert into  coderesolver ( code, text) values (514, 'Examine Stance and Gait');
insert into  coderesolver ( code, text) values (515, 'Examine Autonomic Nervous System');
insert into  coderesolver ( code, text) values (516, 'Skip to next level');


-- level 8 umn or lmn
insert into  coderesolver ( code, text) values (601, 'Upper Motor Neuron Signs');
insert into  coderesolver ( code, text) values (602, 'Lower Motor Neuron Signs or Myopathic Signs');


-- level 9 lesion in brain or spinal cord
insert into  coderesolver ( code, text) values (701, 'Lesion in Brain');
insert into  coderesolver ( code, text) values (702, 'Lesion in Spinal cord');


-- level 10 
-- level of leison in spinal cord
insert into  coderesolver ( code, text) values (800, 'Proceed for Etiological diagnosis');
-- gradual or sudden in brain
insert into  coderesolver ( code, text) values (810, 'Gradual Onset');
insert into  coderesolver ( code, text) values (811, 'Sudden Onset');


-- level 11
-- gradual or sudden in spinal cord
insert into  coderesolver ( code, text) values (910, 'Gradual Onset');
insert into  coderesolver ( code, text) values (911, 'Sudden Onset');
-- causes in brain
  -- 	cerebral causes when gradual
insert into  coderesolver ( code, text) values (920, 'Cerebral diplegia');
insert into  coderesolver ( code, text) values (921, 'Parasagittal meningiomia');
  -- 	cerebral causes when sudden
insert into  coderesolver ( code, text) values (931, 'Thrombosis of unpaired anterior cerebral artery');
insert into  coderesolver ( code, text) values (932, 'Superior sagittal sinus thrombosis');
insert into  coderesolver ( code, text) values (933, 'Bullet injury at paracentral lobule');


-- level 12 
--  compressive/non compressive for gradual onset in spinal cord
insert into  coderesolver ( code, text) values (1000, 'Compressive myelopathy');
insert into  coderesolver ( code, text) values (1001, 'Non-compressive myelopathy');
--  compressive/non compressive for sudden onset in spinal cord
insert into  coderesolver ( code, text) values (1010, 'Compressive myelopathy');
insert into  coderesolver ( code, text) values (1011, 'Non-compressive myelopathy');


-- level 13
-- sudden onset in spinal cord
	-- compressive
insert into  coderesolver ( code, text) values (1100, 'Injury to the spinal cord (fracture- dislocation or collapse of the vertebra)');
insert into  coderesolver ( code, text) values (1101, 'Prolapsed intervertebral disc (PID)');
insert into  coderesolver ( code, text) values (1102, 'Spinal epidural abscess');
	-- non compressive
insert into  coderesolver ( code, text) values (1110, 'Acute Transverse Myelitis');
insert into  coderesolver ( code, text) values (1111, 'Thrombosis of anterior spinal artery (myelomalacia)');
insert into  coderesolver ( code, text) values (1112, 'Haematomyelia (from arteriovenous malformations, angiomas, or endarteritis)');
insert into  coderesolver ( code, text) values (1113, 'Post-vaccinal');
insert into  coderesolver ( code, text) values (1114, 'Radiation myelpathy');
-- gradual onset on spinal cord
	-- compressive ( intra medullay or extramedullary)
insert into  coderesolver ( code, text) values (1120, 'Intramedullary');
insert into  coderesolver ( code, text) values (1121, 'Extramedullary');
	-- non compressive
insert into  coderesolver ( code, text) values (1130, 'Motor neurone disease(MND) eg. amyotrophic lateral sclerosis');
insert into  coderesolver ( code, text) values (1131, 'Multiple sclerosis');
insert into  coderesolver ( code, text) values (1132, 'Friedreichs ataxia');
insert into  coderesolver ( code, text) values (1133, 'Subacute combined degeneration');
insert into  coderesolver ( code, text) values (1134, 'Lathyrism');
insert into  coderesolver ( code, text) values (1135, 'Syringomyelia');
insert into  coderesolver ( code, text) values (1136, 'Hereditary spastic paraplegia');
insert into  coderesolver ( code, text) values (1137, 'Syphilitic meningomyelitis(rare)');
insert into  coderesolver ( code, text) values (1138, 'Tropical spastic paraplegia');


-- level 14 
-- extramedullary
insert into  coderesolver ( code, text) values (1200, 'Intradural');
insert into  coderesolver ( code, text) values (1201, 'Extradural');
-- intramedullary
insert into  coderesolver ( code, text) values (1210, 'Glioma');
insert into  coderesolver ( code, text) values (1211, 'Ependymoma');
insert into  coderesolver ( code, text) values (1212, 'Chordoma');


-- level 15
-- intradural diseases
insert into  coderesolver ( code, text) values (1300, 'Meningiomia');
insert into  coderesolver ( code, text) values (1301, 'Neurofibroma');
insert into  coderesolver ( code, text) values (1302, 'Patchy arachnoiditis (tuberclosis, syphilis)');
insert into  coderesolver ( code, text) values (1303, 'Arteriovenous malformations');
-- extradural diseases
insert into  coderesolver ( code, text) values (1310, 'Caries spine (Plott’s paraplegia)');
insert into  coderesolver ( code, text) values (1311, 'Myeloma, lymphomatous or metastatic deposits in the vertebra; osteomyelitis');
insert into  coderesolver ( code, text) values (1312, 'Patchy meningitis');
insert into  coderesolver ( code, text) values (1313, 'Prolapsed intervertebral disc (PID)');
insert into  coderesolver ( code, text) values (1314, 'Degenerative joint disease (spondylosis)');
insert into  coderesolver ( code, text) values (1315, 'Fracture or dislocation of the vertebra');
insert into  coderesolver ( code, text) values (1316, 'Extramedullary haematopoiesis in thalassaemia');
insert into  coderesolver ( code, text) values (1317, 'Spinal Epidural Abscess');


-- if 'begin diagnosis' -->
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 1, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 2, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 3, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 4, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 5, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 6, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 7, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 8, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 9, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (true, 0, 10, false );

-- if level 2-->
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1, 101, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1, 102, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1, 103, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1, 104, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1 ,105, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 2, 111, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 2, 112, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 2, 113, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 2, 114, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 2, 115, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 121, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 122, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 123, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 124, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 125, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 126, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 127, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 3, 128, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false,3, 129, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 4, 131, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 4, 132, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 4, 133, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 4, 134, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 4, 135, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 4, 136, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 5, 141, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 5, 142, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false,5, 143, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 5, 144, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 5, 145, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 6, 151, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 6, 152, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 6, 153, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 6, 154, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 6, 155, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 6, 156, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false,6, 157, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 7, 161, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 7, 162, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 7, 163, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 7, 164, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 7, 165, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 8, 171, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 8, 172, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 8, 173, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 9, 181, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 9, 182, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 9, 183, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 9, 184, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 9, 185, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 9, 186, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 9, 187, false );

insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 10, 191, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 10, 192, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 10, 193, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 10, 194, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 10, 195, false );

-- if weakness and paralysis
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 123, 201, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 123, 202, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 123, 203, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 123, 204, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 123, 205, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 123, 206, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 123, 207, false );

-- if quadriparesis and paraparesis then history
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 202, 301, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 203, 301, false );

-- if history then examination
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 301, 401, false );

-- if examination begins then show all examination
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 501, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 502, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 503, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 504, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 505, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 506, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 507, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 508, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 509, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 510, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 511, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 512, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 513, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 514, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 515, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 401, 516, false );


-- if examination complete then show umn or lmn
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 516, 601, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 516, 602, false );


-- if umn then brain or spinal cord lesion
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 601, 701, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 601, 702, false );


-- if brain lesion then gradual or sudden
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 701, 810, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 701, 811, false );
-- if spinal cord lesion then level of lesion
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 702, 800, false );


-- level 11
-- causes in brain
  -- 	cerebral causes when gradual
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 810, 920, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 810, 921, true );
  -- 	cerebral causes when sudden
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 811, 931, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 811, 932, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 811, 933, true );
-- gradual or sudden in spinal cord
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 800, 910, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 800, 911, true );


-- level 12 
--  compressive/non compressive for gradual onset in spinal cord
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 910, 1000, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 910, 1001, true );
--  compressive/non compressive for sudden onset in spinal cord
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 911, 1010, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 911, 1011, true );


-- level 13
-- sudden onset in spinal cord
	-- compressive
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1010, 1100, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1010, 1101, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1010, 1102, true );
	-- non compressive
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1011, 1110, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1011, 1111, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1011, 1112, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1011, 1113, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1011, 1114, true );
-- gradual onset on spinal cord
	-- compressive ( intra medullay or extramedullary)
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1000, 1120, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1000, 1121, true );
	-- non compressive
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1130, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1131, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1132, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1133, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1134, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1135, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1136, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1137, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1001, 1138, true );


-- level 14
-- intramedullary
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1120, 1210, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1120, 1211, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1120, 1212, false );

-- extramedullary
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1121, 1200, false );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1121, 1201, false );


-- level 15
-- intradural diseases
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1200, 1300, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1200, 1301, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1200, 1302, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1200, 1303, true );
-- extradural diseases
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1310, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1311, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1312, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1313, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1314, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1315, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1316, true );
insert into  rulebase (rootnode, ifcode, thencode, leafnode) values (false, 1201, 1317, true );

-- node info for quadriparesis
insert into  instruction (infocode, infotext) values (0, 'Begin Diagnosis');

insert into  instruction (infocode, infotext) values (3, '<ol>
<li>Syncope<br>
<p>Syncope is defined as  transient loss of consciousness due to reduced cerebral blood flow. Syncope is associated with postural collapse and spontaneous recovery. It may occur  suddenly, without warning, or may be preceded by symptoms of varying duration.  These include faintness or lightheadedness, &quot;dizziness&quot; without true  vertigo, a feeling of warmth, diaphoresis, nausea, and visual blurring  occasionally proceeding to blindness. These presyncopal symptoms may increase  in severity until loss of consciousness occurs or may resolve prior to loss of  consciousness if the cerebral ischemia is corrected. The differentiation of syncope from seizure is an important, sometimes difficult, diagnostic problem.<br>
Syncope may be benign when  it occurs as a result of normal cardiovascular reflex effects on heart rate and  vascular tone or malignant when due to a life-threatening arrhythmia. Syncope may occur as a single event or may be recurrent. Recurrent, unexplained syncope,  particularly in an individual with structural heart disease, is associated with  a high risk for death (40% mortality within 2 years).</p>
</li>
<li>Dizziness and Vertigo <br>
<p>Dizziness is a common and often vexing symptom. Patients use the  term to encompass a variety of sensations, including those that seem  semantically appropriate (e.g., lightheadedness, faintness, spinning,  giddiness, etc.) and those that are misleadingly inappropriate, such as mental  confusion, blurred vision, headache, or tingling. Moreover, some individuals  with gait disorders complain of dizziness despite the absence of vertigo or  other abnormal cephalic sensations. The causes include peripheral neuropathy,  myelopathy, spasticity, parkinsonian rigidity, and cerebellar ataxia. In this  context, the term <em>dizziness</em> is being used to describe disturbed  mobility. There may be mild associated lightheadedness, particularly with  impaired sensation from the feet or poor vision; this is known as <em>multiple-sensory-defect  dizziness</em> and occurs in elderly individuals who complain of dizziness only  during ambulation. Decreased position sense (secondary to neuropathy or  myelopathy) and poor vision (from cataracts or retinal degeneration) create an  overreliance on the aging vestibular apparatus. A less precise but sometimes  comforting designation to patients is <em>benign dysequilibrium of aging</em>.  Thus, a careful history is necessary to determine exactly what a patient who  states, Doctor, I am dizzy, is experiencing. After eliminating the  misleading symptoms or gait disturbance, dizziness usually means  either <em>faintness</em> (presyncope) or <em>vertigo</em> (an illusory or  hallucinatory sense of movement of the body or environment, most often a  feeling of spinning). 
Operationally, dizziness is classified into three  categories: (1) faintness, (2) vertigo, and (3) miscellaneous head sensations.</p>
<li>Weakness  and paralysis<br />
<p><em>Weakness</em> is a reduction in normal power of one or more muscles. Patients  may use the term differently; thus one or more specific examples of weakness  should be elicited during the history. Increased fatigability or limitation in  function due to pain is often confused with weakness by patients. <em>Increased  fatigability</em> is the inability to sustain the performance of an activity  that should be normal for a person of the same age, gender, and size.</p>
<p>Weakness is described commonly by severity and distribution.  Paralysis and the suffix &quot;-plegia&quot; indicate weakness that is so  severe that it is complete or nearly complete. &quot;Paresis&quot; refers to  weakness that is mild or moderate. The prefix &quot;hemi-&quot; refers to one  half of the body, &quot;para-&quot; to both legs, and &quot;quadri-&quot; to  all four limbs.</p>
</li>
<li>Gait and  balance disorders<br />
 <p> <em>Prevalence, morbidity and mortality</em><br />
  Gait  and balance problems  are common in the elderly and contribute to the risk of falls and injury. Gait  disorders have been described in 15% of individuals over the age of 65. By age  80, one person in four will use a mechanical aid to assist ambulation. Among  those 85 and older, the prevalence of gait abnormality approaches 40%. In  epidemiologic studies, gait disorders are consistently identified as a major  risk factor for fall and injury.<br />
A substantial number of older person report insecure balance and  experience falls and fear of falling. Prospective studies indicate that  20-30%of those over age 65 fall each year, and the proportion is even higher in  hospitalized elderly and nursing home patients. Each year 8% of individuals  &gt;75 suffer a serious fall –related injury. Hip fractures often result in hospitalization  and nursing home admission. For each person who is physically disabled, there  are others whose functional independence is constrained by anxiety and fear of  falling. Nearly one in five of elderly individuals voluntarily limit there  activity because of fear of falling. Whith loss of ambulation, there is a  diminished quality of life and increased morbidity and mortality.</p>
<p>Normal Sensation</p>
<p>Positive and Negative Phenomena<br />
  Abnormal sensory phenomena  may be divided into two categories, positive and negative. The prototypical  positive phenomenon is tingling (pins-and-needles), and the principal negative  phenomenon is numbness. In addition to tingling, positive sensory phenomena  include other altered sensations that are often described as pricking,  bandlike, lightning-like shooting feelings (lancinations), aching, knifelike,  twisting, drawing, pulling, tightening, burning, searing, electrical, or raw  feelings. These descriptors are frequently the actual words used by patients.  Such sensations may or may not be experienced as painful.</p>
</li>
<li>Numbness,  Tingling and Sensory Loss<br>
<p>Abnormal sensory phenomena may be divided into two categories, positive and  negative. The prototypical positive phenomenon is tingling (pins-and-needles), and the principal negative phenomenon is numbness. In  addition to tingling, positive sensory phenomena include other altered  sensations that are often described as pricking, bandlike, lightning-like  shooting feelings (lancinations), aching, knifelike, twisting, drawing,  pulling, tightening, burning, searing, electrical, or raw feelings. These  descriptors are frequently the actual words used by patients. Such sensations  may or may not be experienced as painful.</p>
<p>Positive phenomena usually result from trains of impulses  generated at a site or sites of lowered threshold or heightened excitability  along a sensory pathway, either peripheral or central. The nature and severity of  an abnormal sensation depend on the number, rate, timing, and distribution of  ectopic impulses and the type and function of nervous tissue in which they  arise. Because positive phenomena represent excessive activity in sensory pathways, they are not necessarily associated with any sensory deficit  (loss) upon examination.</p>
</li>
<li>Confusion and Delirium
<p><em>Confusion</em>,  a mental and behavioral state of reduced comprehension, coherence, and capacity  to reason, is one of the most common problems encountered in medicine,  accounting for a large number of emergency department visits, hospital admissions,  and inpatient consultations. <em>Delirium</em>, a term used to describe an acute  confusional state, remains a major cause of morbidity and mortality,  contributing billions of dollars yearly to health care costs in the United  States alone. Delirium often goes unrecognized despite clear evidence that it  is usually the cognitive manifestation of serious underlying medical or  neurologic illness.</p>
<p>Memory loss</p>
<p>Memory  allows us to store, retain, and retrieve information. These three processes  influence and are modified by the type of information that is to be remembered,  the duration of time over which it must be retained, and the way in which the  brain will use the information in the future. The neural circuits underlying  these processes are dynamic, reflecting the flexibility of memory itself. To  delineate the neural circuitry underlying it, it is helpful to break down  memory into simpler components.</p>
</li>
<li>Aphasia,  Memory Loss and Other facial cerebral disorders 
<p>Damage to any one of these components or to their interconnections  can give rise to language disturbances (<em>aphasia</em>). Aphasia should  be diagnosed only when there are deficits in the formal aspects of language  such as naming, word choice, comprehension, spelling, and syntax. Dysarthria  and mutism do not, by themselves, lead to a diagnosis of aphasia. The  language network shows a left hemisphere dominance pattern in the vast majority  of the population. In approximately 90% of right handers and 60% of left  handers, aphasia occurs only after lesions of the left hemisphere. In some  individuals no hemispheric dominance for language can be discerned, and in some  others (including a small minority of right handers) there is a right  hemisphere dominance for language. A language disturbance occurring after a  right hemisphere lesion in a right hander is called <em>crossed aphasia</em>.</p>
<p>Reactive depression is common in patients with higher cerebral dysfunction and should be treated. These patients may be sensitive to the usual  doses of antidepressants or anxiolytics and deserve a careful titration of  dosage. Brain damage may cause a dissociation between feeling states and their  expression, so that a patient who may superficially appear jocular could still  be suffering from an underlying depression that deserves to be treated. In many  cases, agitation may be controlled with reassurance. In other cases, treatment  with benzodiazepines or sedating antidepressants may become necessary. The use  of neuroleptics for the control of agitation should be reserved for refractory  cases since extrapyramidal side effects are frequent in patients with  coexisting brain damage.</p>
<li>Sleep  Disorders<br>
<p>Disturbed sleep is among the most frequent  health complaints physicians encounter. More than one-half of adults in the  United States experience at least intermittent sleep disturbances. For most, it is an occasional night of poor sleep and/or  daytime sleepiness. However, at least 15 to 20% of adults report chronic sleep disturbance or misalignment of circadian timing, which can lead to serious  impairment of daytime functioning. In addition, such problems may contribute to  or exacerbate medical or psychiatric conditions. Thirty years ago, many such  complaints were treated with hypnotic medications without further diagnostic  evaluation. Since then, a distinct class of sleep and  arousal disorders has been identified, and the field of sleep disorders medicine  is now an established clinical discipline</p>
</li>
</ol>');

insert into  instruction (infocode, infotext) values (203, '<p><strong>Approach  to the Patient with Neurologic Disease</strong><br />
  </p>
<p>Neurologic  diseases are common and costly. The proper approach to the patient with a  neurologic illness begins with the patient and focuses the clinical problem  first in anatomic and then in pathophysiologic terms; only then should a  specific diagnosis be entertained. This method ensures that should technology  is judiciously applied, a correct diagnosis is established in an efficient manner,  and treatment is promptly initiated.  </p>
<p><br />
  <strong>The  Neurologic Method </strong><br />
  </p>
<ol>
  <li><strong>Locate  the Lesion(s</strong>)</li>
  The first priority is to identify the region of the nervous  system that is likely to be responsible for the symptoms. Can the disorder be  mapped to one specific location , is it   multifocal, or is a diffuse process present?<br />
    The  first clues to defining the anatomic area of involvement appear in the history  , and examination is then directed to confirm or rule out these impressions and  to clarify uncertainities.<strong></strong><br />
  
  <li><strong>Define  the Pathophysiology</strong></li>
  Clues  to the pathophysiology of the disease process may also be present in the  history. Primary neuronal (grey matter) disorders may present as early  cognitive disturbances, movement disorders, or seizures, whereas white matter  involvement produces predominantly ”long tract”<br />
    Disorders of motor , sensory , visual, and  cerebellar pathways. Progressive and symmetric symptoms often have a metabolic  or degenerative origin; in such cases  lesions  are usually not sharply circumscribed.Thus, a patient with paraparesis and a  clear spinal cord sensory level is unlikely to have vitamin B12  deficiency as the explanation. A Lhermitte  symptom (electric shoch-like sensations evoked by neck flexion) is due to  ectopic impulse generation in white matter pathways and occurs with  demyelination in the cervical spinal cord; among many possible causes, this  symptom may indicate multiple sclerosis(MS) in a young adult or compressive cervical spondolysis in  an older person. Symptoms that worsen after exposure to heat or exercise may  indicate conduction block in demyelinated axons, as occurs in MS. A patient  with exercise or fatigue may have a disorder of neuromuscular transmission such  as myasthenia gravis. Slowly advancing visual scortoma with luminous edges,  termed <em>fotification spectra, </em>indicates  spreading cortical depression, typically with migraine.<br />
  ');

insert into  instruction (infocode, infotext) values (301, '<p>THE NEUROLOGIC HISTORY <br />
  </p>
<p>Attention to the description of the symptoms  experienced by the patient and substantiated by family members and others often  permits an accurate localization and determination of the probable cause of the  complaints, even before the neurologic examination is performed. The history  also helps to bring a focus to the neurologic examination that follows. Each  complaint should be pursued as far as possible to elucidate the location of the  lesion, the likely underlying pathophysiology, and potential etologies. For  example, a patient complains of weakness of the right arm. What are the  associated features? Does the patient have difficulty with brushing hair or  reaching upward (proximal) or buttoning buttons or opening a twist\top bottle  (distal)? Negative associations may also be crucial. A patient with a right  hemiparesis without a language deficit likely has a lesion (internal capsule,  brainstem, or spinal cord)different from that of a patient with a right  hemiparesis  and aphasia (left  hemiparesis).Other pertinent features of the history include the following:</p>
<ol>
  <li><em>Temporal course of the illness</em>:  It is important to determine the precise time of appearance and rate of  progression of the symptoms experienced by the patient. The rapid onset  of a neurologic complaint, occurring within  seconds or minutes ,usually indicates a vascular event, a seizure, or migraine.  The onset of sensory symptoms located in one extremity that spread over a few  seconds to adjacent portions of that extremity and then to the other regions of  the body suggests a seizure.</li>
  <li><em>Patient’s descriptions of the  complaint</em>: The same words often mean different things to  different patients.”Dizziness” may imply impending syncope, a sense of  disequilibrium, or true spinning vertigo. The interpretation of the true  meaning of the words used by patients to describe symptoms becomes even more  complex when there are differences in primary languages and cultures.</li>
  <li><em>Corroboration of the history by  others</em>: It is almost always helpful to obtain additional  information from family, friends, or others observers to corroborate or expand  the patient’s description.</li>
  <li><em>Family history</em>:  Many neurologic disorders have an underlying genetic component. More detailed  questions about family history are often necessary in polygenic disorders such  as MS, migraine, and many types of epilepsy.</li>
  <li><em>Medical illness</em>:  Many neurologic diseases occur in the context of  systemic disorders. Diabetes mellitus,  hypertension, and abnormalities of blood lipids predispose to cerebrovascular  disease. A solitary mass lesion in the brain may be an abcess in a patient with  a coagulopathy, a lymphoma or toxoplasmosis in a patient with underlying  cancer.</li>
  <li><em>Drug use and abuse and toxin exposure</em>:  It is essential to inquire about the history of drug use, both prescribed and  illcit. Aminoglycoside antibiotics may exacerbate symptoms of weakness in  patients with disorders of neuromuscular transmission, such as myasthenia gravis,  and may cause dizziness secondary to ototoxicity.</li>
  <li><em>Formulating an impression of the  patient</em>: Use the opportunity while taking the history to  form an impression of the patient. Is the information forthcoming, or does it  take a circuitous course? Is there evidence of anxiety, depression,  hypochondriasis? Are there any clues to defects in language, memory, insight,  or inappropriate behavior? The neurologic assessment begins as soon as the  patient comes into the room and the first introduction is made.</li>
</ol>');

insert into  instruction (infocode, infotext) values (516, '<p>  Weakness or paralysis is typically  accompanied by other neurologic abnormalities that help to indicate the site of  the responsible lesion. This include changes in tone, muscle bulk, muscle  stretch reflexes, and cutaneous reflexes.  <br />
</p>
<p><strong>Tone</strong>  is the resistance of a muscle to passive  stretch. Central nervous system (CNS) abnormalities that causes weakness  generally produce spasticity, an increase in tone associated with disease of  upper motor neurons. <strong>Spasticity</strong> is velocity-dependent, has a sudden release  after reaching a maximum (the “clasp-knife” phenomenon), and predominantly  affects the antigravity muscles (i.e.,upper-limb flexors and lower limb  extensors). Spasticity is distinct from rigidity and paratonia, two other types  of hypertonia. <strong>Rigidity</strong> is increased tone that is present throughout the range  of motion (a “lead pipe” or “plastic” stiffness) and affects flexors and  extensors equally; it sometimes has a cogwheel quality that is enhanced by  voluntary movement of the contra lateral limb (reinforcement). Rigidity occurs  with certain extrapyramidal disorders such as parkinson’s disease. Paratonia  (or gegenhalten) is increased tone that varies irregularly in a manner that may  seem related to the drgree of relaxation, is present throughout the range of  motion, and affect flexors and extensors equally; it usually results from  disease of the frontal lobes. Weakness with decreased tone (flaccidity) or  normal tone occurs with disorders motor units. A motor unit consists of a single  lower motor neuron and all of the muscle fibers that it innervates.</p>
<p>  Muscle bulk is generally unaffected  in patient with upper motor neuron lesions, although mild disuse atrophy may  eventually occur. By contrast, atrophy is often conspicuous when a lower motor  neuron lesion is responsible for weakness and may also occur with advanced  muscle disease.
  Muscle stretch (<strong>tendon</strong>) reflexes  are usually increased with upper motor neuron lesions, although they may be  decreased or absent for variable period immediately after onset of an acute  lesion. This is usually-but not invariably –accompanied by abnormalities of  coetaneous reflexes (such as superficial abdominals) and, in particular, by an  extensor plantar (babinski) response. The muscle stretch reflexes are depressed  in patients with lower motor neuron lesions when there is direct involvement of  specific reflex arcs.  The stretch  reflexes are generally preserved in patients with myopathic weakness except in  advanced stages, when they are sometimes attenuated. In disorders of affected  by preceding voluntary activity of affected muscles-such activity may lead to  enhancement of initially depressed reflexes in Lambert-Eaton myasthenic  syndrome and, conversely, to depression of initially normal reflexes in  myasthenia gravis.</p>
<p>  The distinction of neuropathic  (lower motor neuron) from myopathic weakness is sometimes difficult clinically,  although distal weakness is sometimes difficult clinically, although distal  weakness is likely to be  neuropathic and  symmetric proximal weakness myopathic. Fasciculation (visibale or palpable  twitch within a muscle due  to the  spontaneous discharge of a motor unit) and early atrophy indicate that weakness  is neuropathaic. </p>
<p><b>With the table provided below, determine the origin of the weakness.</b></br>
  </br>
</p>
<table id="formtable">  <tr>    <td><strong>Sign</strong></td>    <td><strong>Upper Motor Neuron</strong></td>    <td><strong>Lower Motor Neuron</strong></td>    <td><strong>Myopathic</strong></td>  </tr>  <tr>    <td>Atrophy</td>    <td>None</td>    <td>Severe</td>    <td>Mild</td>  </tr>  <tr>    <td>Fasciculations</td>    <td>None</td>    <td>Common</td>    <td>None</td>  </tr>  <tr>    <td>Tone</td>    <td>Spastic</td>    <td>Decreased</td>    <td>Normal/decreased</td>  </tr>  <tr>    <td>Distribution of Weakness</td>    <td>Pyramidal/regional</td>    <td>Distal/segmental</td>    <td>Proximal</td>  </tr>  <tr>    <td>Tendon reflexes</td>    <td>Hyperactive</td>    <td>Hypoactive/absent</td>    <td>Normal/hypoactive</td>  </tr>  <tr>    <td>Babinskis sign</td>    <td>Present</td>    <td>Absent</td>    <td>Absent</td>  </tr></table></br></br>
');
insert into  instruction (infocode, infotext) values (123, '<ol>
  <li><strong>Hemiparesis</strong> is weakness on one side of the body. Contrast with  Hemiplegia, which is total paralysis of the arm, leg, and trunk on the  same side of the body. Hemiparesis is generally caused by lesions of  the <a href="http://en.wikipedia.org/wiki/Corticospinal_tract" title="Corticospinal tract">corticospinal tract</a>, which runs down from the cortical <a href="http://en.wikipedia.org/wiki/Neuron" title="Neuron">neurons</a> of the frontal lobe to the motor neurons of the <a href="http://en.wikipedia.org/wiki/Spinal_cord" title="Spinal cord">spinal cord</a> (see the second paragraph of <a href="http://en.wikipedia.org/wiki/Amyotrophic_lateral_sclerosis" title="Amyotrophic lateral sclerosis">Amyotrophic lateral sclerosis</a>) and is responsible for the movements of the muscles of the body and its limbs.</li>
  <li><strong>Paraplegia</strong> is an impairment in motor and/or sensory function of the lower extremities. It is usually the result of <a href="http://en.wikipedia.org/wiki/Spinal_cord_injury" title="Spinal cord injury">spinal cord injury</a> or a <a href="http://en.wikipedia.org/wiki/Congenital" title="Congenital">congenital</a> condition such as <a href="http://en.wikipedia.org/wiki/Spina_bifida" title="Spina bifida">spina bifida</a> which affects the neural elements of the spinal canal. The area of the  spinal canal which is affected in paraplegia is either the thoracic,  lumbar, or sacral regions. If the arms are also affected by paralysis, <a href="http://en.wikipedia.org/wiki/Quadriplegia" title="Quadriplegia">quadriplegia</a> is the proper terminology.</li>
  <li><strong>Quadriplegia</strong>, also known as <strong>tetraplegia</strong>, is a <a href="http://en.wikipedia.org/wiki/Symptom" title="Symptom">symptom</a> in which a human experiences <a href="http://en.wikipedia.org/wiki/Paralysis" title="Paralysis">paralysis</a> affecting all four limbs, although not necessarily total paralysis or loss of function.</li>
</ol>');
insert into  instruction (infocode, infotext) values (702, '<p><strong>Determining the level  of the lesion:</strong>  The presence of a  horizontally define level below which sensory, motor, and autonomic function is  impaired is a hallmark of spinal cord disease. This sensory level is sought by  asking the patient to identify a pinprick or cold stimulus (e.g., a dry tuning  fork after immersion in cold water) applied to the proximal legs and lower  trunk and sequentially moved up toward the neck on each side. The sensory level  indicates damage to the spinothalamic tract one to two segments above the  perceived level of a unilateral spinal cord lesion and at the level of a  bilateral lesion. That is the result of the ascent of second-order sensory  fibers, which originate in the dorsal horn, proceed to cross anterior to the  central canal while ascending to join the opposite spinothalamic tract. Lesions  that transect the descending cortico-spinal and other motor tracts cause  paraplegia or quadriplegia, with the evolution over time of increased muscle  tone, heightened deep tendon reflexes, and Babinski signs (the upper motor  neuron syndrome). Such lesions also typically produce autonomic disturbances  consisting of absent sweating below the implicated cord level and bladder,  bowel, and sexual dysfunction.<br />
  The  uppermost  level of a spinal cord lesion  can also be localized by attention to the segmental signs corresponding to  disturbed motor or sensory innervations by an individual cord segment. A band  of altered sensation (hyperalgesia or hyperpathia) at the upper end of the  sensory disturbance faciculations or atrophy in muscles innervated by one or  several segment, or a muted or absen deep tendon reflex may be noted at this  level. These signs also occur with focal root or peripheral nerve disorders;  thus, segmental signs are most useful when they occur together with signs of  long tract damage. With severe and acute transverse lesions, the limbs  initially may be flaccid rather than spastic. This state of “spinal shock” lasts  for several days, rarely for weeks , and should not be mistaken for extensive  damage to many segments of the cord or for an acute polyneuropathy.</p>
<p><br />
  The  main features of transverse damage at each level of the spinal cord are spinal cord  are summarized below.</p>
<ul>
  <li><strong>Cervical cord : </strong>Upper  cervical cord lesions produce quadriplegia and weakness of the diaphragm.  Lesions at c4- c5 produce quadriplegia; at c5-c6, there is loss of power and  reflexes in the biceps; at c7 weakness is found only in finger and wrist  extensory and triceps;  and at C8, finger  and wrist flexion are impaired. Horner’s syndrome ( miosis, ptosis, and facial  hypohidrosis) may accompany a cervical cord level.</li>
  <li><strong>Thoracic cord: </strong>lesions  here are localized by the sensory level on the trunk and by the site of midline  back pain if it accompanies the syndrome. Useful markers for localization are  the nipples (T4) and umbilicus (T10). Leg weakness and disturbances of bladder  and bowel function accompany the paralysis. Lesions at T9-T10 paralyze the lower-but  not the upper-abdomainal muscles, resulting in upward movement of the umbilicus  when the abdominal wall contracts (beevor’s sign).</li>
  <li><strong>Lumbar cord: </strong>Lesion  at the L2-L4 spinal cord level cord levels paralyze flexion and adduction of  the thigh, weaken leg extension at the knee, and abolish the patellar reflex.  Lesion at L5-S1 paralyze only movements of the foot and ankle, flexion at the  knee, and extension of the thigh, and abolish the ankle jerks (S1).</li>
  <li><strong>Sacral Cord/Conus  medullaris:  </strong>The conus medullaris is  the tapered caudal termination of the spinal cord, comprising the lower sacral  and single coccygeal segments. The conus syndrome is distinctive, consisting of  bilateral saddle anesthesis (S3-S5), prominent bladder and bowel dysfunction  (urinary retention and incontinence with laxanal tone), and impotence. The  bulbocavernosus (s2-s4) and anal (S3-S5)reflexes are absent . muscle strength  is largely preserved. By contrast, lesions of the cauda equine, the cluster of  nerve roots derived from the lower cord, are characterized by low back and  radicular pain , asymmetric leg weakness and sensory loss, variable areflexia  in the lower extremities, and relative spring of bowel and bladder function.  Mass lesions in the lower spinal canal often produce a mixed clinical picture  in which elements of both cauda equine and conus medullaris syndromes coexist.  Cauda equine syndromes are also discussed in chapter 16.</li>
  </ul>');
insert into  instruction (infocode, infotext) values (910, '<p><strong>Distinguishing Compressive from Noncompressive Myelopathy</strong>:</p>
<p align="justify">The first priority is to exclude a treatable compression of the cord by mass. The common causes are tumor, epidural abscess or hematoma, herniated disc, or vertebral pathology. Epidural compression due to malignancy or abscess often causes warning signs of neck or back pain, bladder disturbances, and sensory symptoms that precede the development of paralysis. Spinal subluxation, hemorrhage, and compressive etiologies such as infraction are more likely to produce myelopathy without antecedent sysmptoms. MRI with gadolinium infusion, centered on the clinically suspected level, is the initial diagonstic procedure; in some cases it is appropriate to image the entire spine (cervical through sacral regions) to search for additional clinically sent lesions. Once compressive lesions have been excluded, noncompressive causes of acute myelopathy that are intrinsic to the cord are considered, primarily vascular, inflammatory, and infectious etiologies.</p>');
insert into  instruction (infocode, infotext) values (911, '<p><strong>Distinguishing Compressive from Noncompressive Myelopathy</strong>:</p>
<p align="justify">The first priority is to exclude a treatable compression of the cord by mass. The common causes are tumor, epidural abscess or hematoma, herniated disc, or vertebral pathology. Epidural compression due to malignancy or abscess often causes warning signs of neck or back pain, bladder disturbances, and sensory symptoms that precede the development of paralysis. Spinal subluxation, hemorrhage, and compressive etiologies such as infraction are more likely to produce myelopathy without antecedent sysmptoms. MRI with gadolinium infusion, centered on the clinically suspected level, is the initial diagonstic procedure; in some cases it is appropriate to image the entire spine (cervical through sacral regions) to search for additional clinically sent lesions. Once compressive lesions have been excluded, noncompressive causes of acute myelopathy that are intrinsic to the cord are considered, primarily vascular, inflammatory, and infectious etiologies.</p>');

insert into  instruction (infocode, infotext) values (601, '<p><strong>Distinguishing lesion in brain &amp;  lesion in spinal cord:</strong></p>
If upper motor neuron signs are associated with  drowsiness ,confusion,seizures,or other hemisphere signs ,MRI of the brain  should be undertaken.');

insert into  instruction (infocode, infotext) values (1000, '<p><strong>Distinguishing Intramedullary &amp; extramedularry</strong></p>
<p>The diagnosis of spinal  cord disorders frequently requires that <strong>intramedullary</strong> processes, which arise within the substance of the cord, be distinguished from <strong>extramedullary</strong> processes that compress the spinal cord or its vascular supply. Distinguishing  features are relative and serve only as rough guides to clinical decision  making. With extramedullary lesions, radicular pain is often prominent, and  there is early sacral sensory loss (lateral spinothalamic tract) and spastic  weakness in the legs (corticospinal tract) due to the superficial location of  these fibers in the lateral spinal cord, which renders them susceptible to  external compression. Intramedullary lesions tend to produce poorly localized  burning pain rather than radicular pain and spare sensation in the perineal and  sacral areas; corticospinal tract signs may appear late. With extramedullary  lesions, the distinction between extradural and intradural masses is important,  as the former are generally malignant and the latter benign; a long duration of  symptoms favors an intradural origin.</p>
<p>Several cranial nerves may be affected by the same disease  process. In this situation, the main clinical problem is to determine whether  the lesion lies within the brainstem or outside it. Lesions that lie on the  surface of the brainstem are characterized by involvement of adjacent cranial  nerves (often occurring in succession) and late and rather slight involvement  of the long sensory and motor pathways and segmental structures lying within  the brainstem. The opposite is true of <strong>intramedullary</strong>,  intrapontine, and intramesencephalic lesions. The <strong>extramedullary</strong> lesion  is more likely to cause bone erosion or enlargement of the foramens of exit of  cranial nerves. The intramedullary lesion involving cranial nerves often  produces a crossed sensory or motor paralysis (cranial nerve signs on one side  of the body and tract signs on the opposite side).</p>
');

insert into  instruction (infocode, infotext) values (1121, '<p><strong>Intradural  &amp; extradural:</strong><br>
  </p>
<p>With extramedullary lesions, the distinction between <strong>extradural</strong> and <strong>intradural</strong> masses  is important, as the former are generally malignant and the latter benign; a  long duration of symptoms favors an intradural origin.</p>
');










-- classical features of all diseases

-- acute transverse myeletis
insert into  instruction ( infocode, infotext) values (1110, '<p><strong>CLASSICAL  FEATURES OF ACUTE TRANSVERSE MYELITIS:</strong><br />
</p>
<p>Though a common cause of non-compressive  myelopathy acute onset total trasectionof the cord), clinically somewhat it  behaves like compressive variety.</p>
<ol>
  <li>Very often  follows a viral illness(neurotropic virus) or post-vaccinal.</li>
  <li>Onset is acute  or subacute(evolve over several days to 2-3 weeks).</li>
  <li>Fever may be  present before paralysis develops.</li>
  <li>Bladder involvement is early.</li>
  <li>Though behaves like compressive variety,  usually there is a absence of root pain, spinal tenderness or spinal  deformity.Back pain and progressive paraparesis are presenting  complaints.Girdle constriction at the level of lesion with zone of  hyperaesthesia just above may be obtained.Mid-thoracic region is the most  common site.</li>
  <li>Plantar response is extensor and there  is partial or complete sensory loss(all modalities), with a definite upper  level ortant point of difference with acute infective polyneuropathy where  these two features are,flexor and no demonstrabble sensory loss respectively).</li>
  <li>Majority(70%) recovers within 12 weeks. </li>
</ol>');

-- Meningiomia 
insert into  instruction ( infocode, infotext) values (1300, '<p><strong>Features of the  Meaningiama</strong></p>
<p>  Patients  experience different symptoms depending on the location of the tumor. Most  brain meningiomas are located either just below the top of the skull, or  between the two hemispheres of the brain. If the tumor is located in these  areas, symptoms include<u></u></p>
<ul type="disc">
  <li>headaches</li>
  <li>seizures</li>
  <li>dizziness</li>
  <li>hormone disorder in case of woman.</li>
  <li>problems with memory</li>
  <li>behavior changes</li>
  <li>protrusion of one or both <a href="http://www.answers.com/topic/eyeball" target="_top">eyeballs</a> (exophthalmos)</li>
</ul>
<p>More rarely, tumors are near sensory  areas of the brain such as the optic nerve or close to the ears. Patients with  these tumors experience vision or hearing losses.<br />
  Spinal meningiomas are usually found  in the spinal column between the neck and the abdomen. The most common symptoms  are:</p>
<ul type="disc">
  <li>pain</li>
  <li>weakness and stiffness of the arms and legs</li>
  <li>episodes of partial paralysis</li>
</ul>
<p>Meningiomas are classified into three  different grades depending upon the <a href="http://www.answers.com/topic/likelihood" target="_top">likelihood</a> of recurrence and aggressive growth:</p>
<ul type="disc">
  <li>Grade I: Low risk of recurrence and slow growth</li>
  <li>Grade II: Greater likelihood of recurrence and/or aggressive       growth</li>
  <li>Grade III: High recurrence rates and aggressive growth.</li>
</ul>');

-- neurofibroma
insert into  instruction ( infocode, infotext) values (1301, '<p><strong>Features of the neurofibroma</strong></p>
<p>  A <strong>neurofibroma</strong> is a benign <a href="http://www.answers.com/topic/nerve-sheath-tumor" target="_top">nerve  sheath tumor</a> in the peripheral nervous system. Usually found in individuals  with <a href="http://www.answers.com/topic/neurofibromatosis" target="_top">Neurofibromatosis</a> Type 1 (NF1), a <a href="http://www.answers.com/topic/genetic-disorder" target="_top">genetically-inherited disease</a>, they can result in a range of  symptoms from physical disfiguration and pain to cognitive disability<strong><u></u></strong></p>
<ol>
  <li>Neurofibromatosis is an autosomal dominant  disorder that affects the bone, the nervous system, soft tissue, and the skin.</li>
  <li>Headaches</li>
  <li>Nausea or Vomiting</li>
  <li>Facial or Muscle Weakness </li>
  <li>Man muscle change to elephant .</li>
  <li>genetic  disorder</li>
  <li>Pain in the Face or the Ears</li>
  <li>Problems with Vision</li>
  <li>A  Lump or Swelling Under the Skin caused by a Development of a Neurofibroma or  Schwannoma (Tumor on a Nerve).</li>
</ol>');

-- neurofibroma
insert into  instruction ( infocode, infotext) values (1302, '<p><strong>Features of the  patchy arachnoiditis:</strong></p>
<p>S<strong>yndrome</strong> </p>
<ul type="disc">
  <li>Pain: Low back &amp; radiating down both legs </li>
  <li>Weakness: One or multiple lumbar or sacral root       distribution </li>
  <li>Sensory loss: One or multiple lumbar or sacral root       distribution </li>
</ul>
<p><strong>Causes</strong> </p>
<ul type="disc">
  <li>Spinal surgery: Especially multiple </li>
  <li>Chemical </li>
  <ul type="circle">
    <li>Oil based radiographic contrast agents </li>
    <li>Spinal drugs: Anesthetics; Steroids; Amphotericin B;        Methotrexate </li>
  </ul>
  <li>Infections: Tuberculosis; Cryptococcosis; Syphilis;       Viral </li>
  <li>Trauma: Vertebral injuries; Disc herniation </li>
  <li>Spinal subarachnoid hemorrhage </li>
</ul>
<p>TB: symptoms</p>
<ul>
  <li>chest pain</li>
  <li>prolonged cough for more than three weeks</li>
  <li>coughing up blood, fever, chills, night sweats</li>
  <li>appetite loss, weight loss,  pallor and fatigue. </li>
  <li>Lung  pain. </li>
</ul>
');

-- arteriovenous malformations
insert into  instruction ( infocode, infotext) values (1303, '<p><strong>Features of the  arteriovenous malformations:</strong><br />
</p>
<ul type="disc">
  <li>Difficulties       with movement or coordination, including <a href="http://en.wikipedia.org/wiki/Muscle_weakness" title="Muscle weakness">muscle       weakness</a> and       even <a href="http://en.wikipedia.org/wiki/Paralysis" title="Paralysis">paralysis</a>;</li>
  <li>Headache:       a frequent symptom, probably due to pressure effects from the abnormal       blood vessels. AVMs are most likely to hemorrhage. If a hemorrhage occurs,       it produces a sudden, severe <a href="http://www.answers.com/topic/headache" target="_top">headache</a>.</li>
  <li>Migraine:       people with AVMs seem to be more prone to migraines than others.</li>
  <li><a href="http://en.wikipedia.org/wiki/Vertigo_%28medical%29" title="Vertigo (medical)">vertigo</a> (dizziness);</li>
  <li><a href="http://www.answers.com/topic/hydrocephalus" target="_top">Hydrocephalus</a>,  a <a href="http://www.answers.com/topic/swelling" target="_top">swelling</a> of  brain tissue caused by accumulated fluids, may develop.</li>
  <li>Difficulties       of speech (<a href="http://en.wikipedia.org/wiki/Dysarthria" title="Dysarthria">dysarthria</a>) and communication, such as <a href="http://en.wikipedia.org/wiki/Alogia" title="Alogia">alogia</a>;</li>
  <li>Difficulties       with everyday activities, such as <a href="http://en.wikipedia.org/wiki/Apraxia" title="Apraxia">apraxia</a>;</li>
  <li>Abnormal       sensations (numbness, tingling, or spontaneous <a href="http://en.wikipedia.org/wiki/Pain" title="Pain">pain</a>);</li>
  <li>Memory and       thought-related problems, such as <a href="http://en.wikipedia.org/wiki/Confusion" title="Confusion">confusion</a>, <a href="http://en.wikipedia.org/wiki/Dementia" title="Dementia">dementia</a> or <a href="http://en.wikipedia.org/wiki/Hallucination" title="Hallucination">hallucinations</a>.</li>
</ul>');

-- Degenerate Joint Disease
insert into  instruction ( infocode, infotext) values (1314, '<p><strong>Features of the DegenerateJointDisease</strong></p>
<p>  A <strong>DegenerateJointDisease</strong> is a benign <a href=": http://www.patient.co.uk/showdoc/27000885/0/"_top">nerve  sheath tumor</a> in the peripheral nervous system. Usually found in individuals  with <a href="http://www.answers.com/topic/neurofibromatosis" target="_top">Neurofibromatosis</a> Type 1 (NF1), a <a href="http://www.answers.com/topic/genetic-disorder" target="_top">genetically-inherited disease</a>, they can result in a range of  symptoms from physical disfiguration and pain to cognitive disability<strong><u></u></strong></p>
<ol>
  <li>Initially there may be joint stiffness, usually lasting more than 15 minutes. </li>
  <li>Pain on motion of the affected joint . </li>
  <li>Pain is not remain at night </li>
  <li>It worsens as the day progresses. </li>
  <li>The joint may feel warm. </li>
</ol>');

-- Fracture or dislocation of the vertebra
insert into  instruction ( infocode, infotext) values (1315, '
<p>  A <strong>Fracture or dislocation of the vertebra</strong></p>
<ol>
  <li>fracture are leading cause of death after heart disease, cancer, and stroke. </li>
  <li>fracture or dislocation of the vertebra includes back or neck pain, numbness, tingling, muscle spasm, weakness, bowel/bladder changes, and paralysis. </li>
  <li>loss of movement in the arms or legs. </li>
</ol>');

-- Extramedullary haematopoiesis in thalassaemia.

-- Spinal Epidural Abscess
insert into  instruction ( infocode, infotext) values (1102, '<p><strong>Features of Spinal Epidural Abscess </strong></p>
<p>A Spinal Epidural Abscess is a benign</p>
<ol>
  <li>Localized spinal pain(Localized back pain in most patients)
  <li>Radicular pain and paresthesias. 
  </li>
  <li>Muscular weakness, sensory loss, and sphincter dysfunction.
  </li>
  <li>Fever, present in only about one third of patients.
  </li>
  <li>Radiculopathy with radiating or lancinating pain, including truncal girdle pain.
  </li>
  <li>Spinal cord syndrome, typically involving paraparesis with prospective progression to paraplegia.
  </li>
  <li>Sphincter dysfunction, including incontinence or increased residual urine volumes.
  </li>
  <li>Headache and neck pain may be present, especially with cervical epidural abscesses. 
  </li>
</ol>');

-- Myeloma lymphomatous
insert into  instruction ( infocode, infotext) values (1311, '<p><strong>Features of Myeloma lymphomatous</strong></p>
<p>  A Myeloma lymphomatous is a benign </p>
<ol>
  <li>
  Seventy-five percent of patients present with bone pain frequently in the back, long bones, pelvis and skull.
  <li> Lower back pain is a common complaint.  
  <li> The risk of fractures increases, with compression fractures of the thoracic and lumbar vertebral bodies being quite common. 
  <li> Fifty percent of patients have radiologically detectable myeloma-related skeletal lesions at diagnosis.
  <li>Myeloma patients do tingling sensations and/or numbness in the hands and feet, and muscle weakness in the legs and arms.
  <li>Anemia commonly occurs in almost all multiple myeloma patients. Anemia can cause weakness, dizziness, shortness of breath, fatigue.
  <li> white blood cell counts are reduced.
  <li><b> Hyperviscosity occurs</b>
<p>&#149;&nbsp; causing mental or emotional injury </p>
    <p>&#149;&nbsp; Nose bleeding </p>
    <p>&#149;&nbsp; Hazy vision </p>
    <p>&#149;&nbsp; Headache </p>
    <p>&#149;&nbsp; Gastrointestinal bleeding </p>
    <p>&#149;&nbsp; Sleepiness. </p>
  </ol>');

-- Prolapsed intervertebral 
insert into  instruction ( infocode, infotext) values (1313, '<p><strong>Features of Prolapsed intervertebral disc</strong></p>
<p>  A <strong>Prolapsed intervertebral </strong> is a benign</strong></p><ol>
  <li>Back pain  (The pain is often severe, and usually comes on suddenly. The pain is usually eased by lying down flat, and is often made worse if you move your back, cough, or sneeze.) </li>
  <li>Nerve root pain </li>
  <li>The irritation or pressure on the nerve next to the spine may also cause pins and needles, numbness or weakness in part of a buttock, leg or foot. </li>
</ol>');

-- Caries Spine
insert into  instruction ( infocode, infotext) values (1310, '<p><strong>Features of Caries Spine</strong></p>
<p> Caries Spine </p>
<ol>
  <li> History of TB in the family </li>
  <li> Signs and symptoms consistent with tuberculosis .</li>
  <li> Clinical features of spinal cord compression.</li>
  <li> Complete or partial collapse of one or more vertebrae on X-ray spine.</li>
  <li> In duration of &gt; 10 mm with Tuberculin skin testing after 48 to 72 hours irrespective of prior Bacillus-Calemette-Guerin ( BCG).</li>
  <li> Chest x-ray (CXR) consistent with tuberculous infection of lungs.</li>
  <li> Magnetic resonance imaging (MRI) or CT spine showing destruction of intervertebral disc and adjoining vertebrae causing compression of spinal cord. </li>
</ol>');

-- Glioma
insert into  instruction ( infocode, infotext) values (1210, '<p><strong>Features of the Glioma</strong></p>
<p>A <strong>glioma </strong> is a type of cancer that starts in the brain or spine. It is called a glioma because it arises from glia cells. The most common site of gliomas is the brain. </p>
<p><strong>By type of cell </strong></p>
<p>Gliomas are named according to the specific type of cell they most closely resemble. The main types of gliomas are: </p>
<ol>
  <li><a href="http://en.wikipedia.org/wiki/Ependymoma">Ependymomas </a> — <a href="http://en.wikipedia.org/wiki/Ependymal_cell">ependymal cells </a></li>
  <li><a href="http://en.wikipedia.org/wiki/Astrocytoma">Astrocytomas </a> — <a href="http://en.wikipedia.org/wiki/Astrocyte">astrocytes </a> - Glioblastoma multiforme is the most common astrocytoma. </li>
  <li><a href="http://en.wikipedia.org/wiki/Oligodendroglioma">Oligodendrogliomas </a> — <a href="http://en.wikipedia.org/wiki/Oligodendrocyte">oligodendrocytes </a></li>
  <li>Mixed gliomas, such as <a href="http://en.wikipedia.org/wiki/Oligoastrocytomas">oligoastrocytomas </a>, contain cells from different types of glia. </li>
<p>Gliomas are further categorized according to their grade which is determined by pathologic evaluation of the tumor. </p>
<p>&#149;&nbsp; High grade. </p>
<p>&#149;&nbsp; Low grade. </p>
<h2>Symptoms </h2>
<li> The central nervous system is affected by glioma. </li>
<li> A brain glioma cause headaches, nausea and vomiting,seizures and carnial nerve disorders as a result of increased intracranial pressure. </li>
<li> A glioma of the optical nerve can cause visual loss. </li>
<li> Spinal cord gliomas can cause pain, weakness or numbness in the extremities. </li>
<li> Gliomas do not metastasize by the bloodstream but they can spread via the cerebrospinal flue and cause &quot;drop metastases&quot; to the spinal cord. </li>
</ol>');


-- ependymoma
insert into  instruction ( infocode, infotext) values (1211,'<p><strong>Features of Ependymoma</strong></p>
<p>An ependymoma is a rare type of primary brain tumor that develops from the ependymal cells lining the ventricles of the brain and the central canal of the spinal cord.
<p>Ependymomas can be found anywhere in the brain or spine but are usually located in the main part of the brain, the cerebrum and may spread from the brain to the spinal
 cord via the cerebrospinal flude. </p>
<p><strong>Causes and Symptoms </strong></p>
<ol>
  <li> Increased pressure within the skull. </li>
  <li> The ventricles of the brain causing a buildup of CSF or may be induced by swelling around the tumor itself. The increased pressure can cause headaches, vomiting and visual problems.</li>
  <li> Swelling of the optic nerve, rapid and jerky eye movements, neck pain and irritability. </li>
  <li> If located in the frontal lobe of the brain, ependymomas may cause mood swings, personality changes, and paralysis on one side of the body. </li>
  <li>If occurring on the temporal lobe temporal lobe of the brain, coordination, speech, and memory problems may result. </li>
  <li> If located on the parietal lobe of the brain, the condition may affect writing and related tasks. </li>
  <li>If located in the cerebellum, ependymomas may cause unsteady gait and problems with coordination and balance. </li>
</ol>');


-- Chordoma
insert into  instruction ( infocode, infotext) values (1212, '<p><strong>Features of the chordoma</strong></p>
<p>Chordoma is a primary malignant bone cancer that develops from remnants of embryonic notochord in the skull-base (head) and spine.</p>
<p><strong>Types of Chordoma </strong></p>
<p>There are three histological subtypes of chordoma: conventional (sometimes called classic), chondroid, and dedifferentiated. Chondroid chordomas tend to be less aggressive than conventional chordomas, while dedifferentiated chordomas are more aggressive, faster growing and more likely to metastasize. <br>
    <br>
  Chordomas are often confused with or misdiagnosed as chondrosarcomas, and vice versa.Both types of tumor can occur in the same locations and often look similar under a microscope. Generally, chondrosarcomas tend to be more responsive to radiation and have a better prognosis.[3] Therefore before proceeding with treatment, it is important to get multiple opinions on the pathological diagnosis from experienced pathologists who routinely see both types of tumors.</p>
<p><strong>Signs and Symptoms </strong></p>
<ol>
<li>The most common signs of chordoma are pain and neurological changes.</li>
<li>Skull base chordomas most often cause headache, neck pain, diplopia (double vision), or facial nerve palsy (paralysis of facial muscles).</li>
<li>Chordomas of the spine and sacrum can cause changes in bowel and/or bladder function, pain, aching, tingling, numbness, or weakness of the arms and legs.</li>
<li>Often sacral chordomas do not cause symptoms until the tumor is quite large and sometimes a lump is the first sign of a sacral chordoma.
</ol>');


insert into  instruction ( infocode, infotext) values (1112, '<p><strong>Features of Cerebral palsy</strong></p>
<p>Cerebral palsy is a group of disorders usually characterized by some  impairment in motor function, whether it is a slight limp, or an inability to  walk.&nbsp; Cerebral palsy is a type of movement disorder that is  non-progressive, meaning that the symptoms do not get worse over time.&nbsp; <br />
  Other movement disorders which may have similar symptoms of cerebral palsy  but are not CP are:&nbsp; <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/ataxia.html" title="Ataxia">Ataxia</a>, <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/blepharospasm.html" title="Blepharospasm">Blepharospasm</a>, <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/spasmodic.html" title="Dysphonia">Dysphonia</a>, Dystonic disorders, Gait disorders, <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/huntington.html" title="Huntingtons disease">Huntingtons disease</a> <a href= "http://www.cerebralpalsysource.com/About_CP/movement-disorders/myoclonus.html" title="Myoclonus">Myoclonus</a>, <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/parkinson.html" title="Parkinsons disease">Parkinsons disease</a>, <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/spasticity.html" title="Spasticity">Spasticity</a>, <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/tardive.html" title="Tardive dyskinesia">Tardive dyskinesia</a>, Tics and Tourette’s  syndrome, and <a href="http://www.cerebralpalsysource.com/About_CP/movement-disorders/tremor.html" title="Tremor">Tremor</a>.&nbsp; Some people with cerebral palsy exhibit signs  and symptoms of these other movement disorders, especially spasticity and  tremors.</p>
<p><br />
  Cerebral palsy is a type of movement disorder that affects muscle control  over motion and may not be apparent for a few years after birth.&nbsp; Some  sort of trauma to the brain usually causes the disorder before, during, or  shortly after birth.&nbsp; Some causes of cerebral palsy can be prevented and  they include jaundice, Rh incompatibility issues, or other medical mistakes.<br />
  Cerebral palsy affects muscle tissue due to its brain malfunction.&nbsp;  Some people with cerebral palsy have increased muscle tone, while others have a  decrease in muscle tone.&nbsp; Other persons with cerebral palsy have a type of  the movement disorder that fluctuates from increased to decreased muscle  tone.&nbsp; Often this disorder is most prominently obvious in the legs or the  arms.&nbsp; <br />
  The three main types of cerebral palsy are <a href="http://www.cerebralpalsysource.com/Types_of_CP/spastic_cp/index.html" title="spastic CP">spastic CP</a>, <a href="http://www.cerebralpalsysource.com/Types_of_CP/athetoid_cp/index.html" title="athetoid CP">athetoid CP</a>, and <a href="http://www.cerebralpalsysource.com/Types_of_CP/ataxic_cp/index.html" title="ataxic CP">ataxic CP</a>.&nbsp; There may be a type of cerebral palsy  that is a combination of two or three.&nbsp; Spasticity refers to the muscle  tissues being very stiff, and people with spastic cerebral palsy often have  difficulty walking or moving.&nbsp; Athetoid cerebral palsy is a type of  movement disorder that results in uncontrolled movements and tics.&nbsp; People  with ataxic cerebral palsy tend to be off-balance and have difficulty sensing  depth. <br />
  </p>
<p>Movement disorders such as cerebral palsy are not curable.&nbsp; The  symptoms of cerebral palsy, however, can be treated with long-term therapies  and other treatments such as adaptive equipment (computers, wheelchairs),  prescription drugs, and alternative healing options.&nbsp; As cerebral palsy  manifests itself as a movement disorder, the basic functioning of the person  with cerebral palsy is compromised.&nbsp; Each person with cerebral palsy has  his or her own individual symptoms and severities.&nbsp; </p>
<p><strong>Cerebral Palsy in Children</strong></p>
<p>Unfortunately, over the years there has not been a decline in the cases of  cerebral palsy in children. Every year about 8,000 babies and infants are  diagnosed with the condition. In addition, another 1,200 - 1,500 preschool age  children are recognized each year to have <a href="http://www.cerebralpalsysource.com/About_CP/index.html" title="cerebral palsy">cerebral palsy</a>. The instance of cerebral palsy in  children is rather significant, as one child in every 400 is affected. This is  largely the result of the increased survival rate of premature babies due to  medical advancements. However, there are several ways to <a href="http://www.cerebralpalsysource.com/About_CP/prevent_cp/index.html" title="prevent cerebral palsy">prevent cerebral palsy</a> in children and steps  that can be taken from conception all the way through childbirth.<br />
  </p>
<p>A good physician, the proper prenatal and neonatal procedures, and  acknowledging the risk factors will help lower the statistics of cerebral palsy  in children. A risk factor is a variable, not a cause of cerebral palsy, which,  when present, increases the chance of cerebral palsy. The presence of a risk  factor can be a caution for parents and physicians to be even more observant  during the development of an infant when looking for cerebral palsy in  children.<br />
  </p>
<p>During the birthing process, asphyxia, or lack of oxygen, is one risk factor  that can cause cerebral palsy in children. When brain cells are not getting  enough oxygen due to poor circulation, they may die. About 10% of newborns  known to have suffered asphyxia during birth develop cerebral palsy. A viral or  bacterial infection contracted by the mother can also damage the fetal brain.  Rubella, otherwise known as the German measles, toxoplasmosis (often contracted  through undercooked meat), cytomegalovirus (a herpes virus), and HIV are known  to cause brain-damaging infections cerebral palsy in children.<br />
  </p>
<p>Trauma to the infant’s head due to an automobile accident, physical abuse or  other such trauma to a pregnant mother or the infant can <a href="http://www.cerebralpalsysource.com/About_CP/causes_cp/index.html" title="cause cerebral palsy">cause cerebral palsy</a> in children as well. The  diet of a pregnant mother is also the diet of the fetus and newborn. Maternal  drug and alcohol use and malnutrition during pregnancy and during breastfeeding  can be factors related to cerebral palsy in children.</p>');


insert into  instruction ( infocode, infotext) values (1111, '<p><strong>Features of thrombosis of unpaired anterior cerebral artery:</strong><br>
</p>
<p>The azygos or undivided anterior  cerebral artery (ACA) is a rare variant, and aneurysms associated with this  variant are particularly rare. Most reported azygos ACA aneurysms are saccular. </p>');

insert into  instruction ( infocode, infotext) values (931, '<p><strong>Features of thrombosis of unpaired anterior cerebral artery:</strong><br>
</p>
<p>The azygos or undivided anterior  cerebral artery (ACA) is a rare variant, and aneurysms associated with this  variant are particularly rare. Most reported azygos ACA aneurysms are saccular. </p>');

insert into  instruction ( infocode, infotext) values (932, '<p><strong>Features of Superior  sagittal sinus thrombosis:</strong></p>
<p>  Superior sagittal sinus thrombosis is an uncommon  cerebrovascular accident that is frequently associated with diseases  that may contribute to the development of thrombosis through  hypercoagulability, stasis of the local blood stream, and  abnormalities of the vessel wall. In approximately 25% of cases  underlying diseases remain unrecognized.<br>
  </p>
<p>Superior sagittal sinus (SSS) thrombosis is an uncommon  cause of stroke. Presenting symptoms of raised intracranial pressure  may be followed by focal neurological deficits. The presence of  headache, hemiparesis, and focal epilepsy in a relatively young  patient is indicative of SSS thrombosis. The diagnosis is confirmed  by angiography, computed tomography (CT) scan, or magnetic resonance  imaging (MRI). The treatment of SSS thrombosis is not uniform, and  the role of anticoagulants remains controversial for fear of  provoking hemorrhagic cerebral infarctions. </p>
');

insert into  instruction ( infocode, infotext) values (1317, '<p><strong>Spinal  epidural abscess</strong> </p>
<p>      A spinal  epidural abscess threatens the spinal cord by compression and also by vascular  compromise. If untreated, an expanding sup-purative  infection in the spinal epidural space impinges on the spinal cord, producing  sensory symptoms and signs, motor dysfunction, and, ultimately, paralysis and  death. Intervention early in the course of the disease undoubtedly improves the  outcome. Frequently, the diagnosis is delayed because the initial presentation  may be back pain alone or radicular symptoms with a  chief complaint of chest pain or abdominal pain.  </p>
<p>S<strong>ymptoms</strong> </p>
<ul type="disc">
  <ol>
    <li>localized spinal pain(Localized back pain in most        patients ) </li>
    <li>radicular        pain and paresthesias </li>
    <li>muscular weakness, sensory loss, and sphincter        dysfunction </li>
    <li>Fever, present in only about one third of patients </li>
    <li>Radiculopathy        with radiating or lancinating pain, including truncal girdle pain </li>
    <li>Spinal cord syndrome, typically involving paraparesis with prospective progression to        paraplegia. </li>
    <li>Sphincter dysfunction, including incontinence or        increased residual urine volumes </li>
    <li>Headache and neck pain may be present, especially with        cervical epidural abscesses. </li>
  </ol>
</ul>
');

insert into  instruction ( infocode, infotext) values (1316, '<p><strong>Extramedullary</strong><strong> haematopoiesis in thalassaemia</strong> </p>
<p>Extramedullary haematopoiesis is sometimes encountered in severe anaemia. Rarely, it may cause neurological symptoms,  leading to spinal cord or cauda equina  compression. Three patients with thalassaemia intermedia, who developed neurological complications, are  described. </p>
<p>Types of thalassaemia </p>
<ol>
  <li>Alpha-thalassaemia</li>
  <li>Beta-thalassaemia   </li>
</ol>
');
