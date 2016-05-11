/**
 */
package scenario;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see scenario.ScenarioFactory
 * @model kind="package"
 * @generated
 */
public interface ScenarioPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scenario";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://edu/exa/unicen/scenario";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.exa.unicen.scenario";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScenarioPackage eINSTANCE = scenario.impl.ScenarioPackageImpl.init();

	/**
	 * The meta object id for the '{@link scenario.impl.GeneralScenarioImpl <em>General Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scenario.impl.GeneralScenarioImpl
	 * @see scenario.impl.ScenarioPackageImpl#getGeneralScenario()
	 * @generated
	 */
	int GENERAL_SCENARIO = 0;

	/**
	 * The feature id for the '<em><b>Quality Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__QUALITY_ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Stimulus</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__STIMULUS = 2;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__ENVIRONMENT = 3;

	/**
	 * The feature id for the '<em><b>Artifact</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__ARTIFACT = 4;

	/**
	 * The feature id for the '<em><b>Response</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__RESPONSE = 5;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__MEASURE = 6;

	/**
	 * The feature id for the '<em><b>Generated Scenarios</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO__GENERATED_SCENARIOS = 7;

	/**
	 * The number of structural features of the '<em>General Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>General Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_SCENARIO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link scenario.impl.SpecificScenarioImpl <em>Specific Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scenario.impl.SpecificScenarioImpl
	 * @see scenario.impl.ScenarioPackageImpl#getSpecificScenario()
	 * @generated
	 */
	int SPECIFIC_SCENARIO = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Stimulus</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO__STIMULUS = 1;

	/**
	 * The feature id for the '<em><b>Environment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO__ENVIRONMENT = 2;

	/**
	 * The feature id for the '<em><b>Artifact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO__ARTIFACT = 3;

	/**
	 * The feature id for the '<em><b>Response</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO__RESPONSE = 4;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO__MEASURE = 5;

	/**
	 * The feature id for the '<em><b>Quality Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE = 6;

	/**
	 * The number of structural features of the '<em>Specific Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Specific Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SCENARIO_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link scenario.GeneralScenario <em>General Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Scenario</em>'.
	 * @see scenario.GeneralScenario
	 * @generated
	 */
	EClass getGeneralScenario();

	/**
	 * Returns the meta object for the attribute '{@link scenario.GeneralScenario#getQualityAttribute <em>Quality Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Attribute</em>'.
	 * @see scenario.GeneralScenario#getQualityAttribute()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EAttribute getGeneralScenario_QualityAttribute();

	/**
	 * Returns the meta object for the attribute list '{@link scenario.GeneralScenario#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Source</em>'.
	 * @see scenario.GeneralScenario#getSource()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EAttribute getGeneralScenario_Source();

	/**
	 * Returns the meta object for the attribute list '{@link scenario.GeneralScenario#getStimulus <em>Stimulus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stimulus</em>'.
	 * @see scenario.GeneralScenario#getStimulus()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EAttribute getGeneralScenario_Stimulus();

	/**
	 * Returns the meta object for the attribute list '{@link scenario.GeneralScenario#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Environment</em>'.
	 * @see scenario.GeneralScenario#getEnvironment()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EAttribute getGeneralScenario_Environment();

	/**
	 * Returns the meta object for the attribute list '{@link scenario.GeneralScenario#getArtifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Artifact</em>'.
	 * @see scenario.GeneralScenario#getArtifact()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EAttribute getGeneralScenario_Artifact();

	/**
	 * Returns the meta object for the attribute list '{@link scenario.GeneralScenario#getResponse <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Response</em>'.
	 * @see scenario.GeneralScenario#getResponse()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EAttribute getGeneralScenario_Response();

	/**
	 * Returns the meta object for the attribute list '{@link scenario.GeneralScenario#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Measure</em>'.
	 * @see scenario.GeneralScenario#getMeasure()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EAttribute getGeneralScenario_Measure();

	/**
	 * Returns the meta object for the containment reference list '{@link scenario.GeneralScenario#getGeneratedScenarios <em>Generated Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generated Scenarios</em>'.
	 * @see scenario.GeneralScenario#getGeneratedScenarios()
	 * @see #getGeneralScenario()
	 * @generated
	 */
	EReference getGeneralScenario_GeneratedScenarios();

	/**
	 * Returns the meta object for class '{@link scenario.SpecificScenario <em>Specific Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Scenario</em>'.
	 * @see scenario.SpecificScenario
	 * @generated
	 */
	EClass getSpecificScenario();

	/**
	 * Returns the meta object for the attribute '{@link scenario.SpecificScenario#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see scenario.SpecificScenario#getSource()
	 * @see #getSpecificScenario()
	 * @generated
	 */
	EAttribute getSpecificScenario_Source();

	/**
	 * Returns the meta object for the attribute '{@link scenario.SpecificScenario#getStimulus <em>Stimulus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stimulus</em>'.
	 * @see scenario.SpecificScenario#getStimulus()
	 * @see #getSpecificScenario()
	 * @generated
	 */
	EAttribute getSpecificScenario_Stimulus();

	/**
	 * Returns the meta object for the attribute '{@link scenario.SpecificScenario#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Environment</em>'.
	 * @see scenario.SpecificScenario#getEnvironment()
	 * @see #getSpecificScenario()
	 * @generated
	 */
	EAttribute getSpecificScenario_Environment();

	/**
	 * Returns the meta object for the attribute '{@link scenario.SpecificScenario#getArtifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact</em>'.
	 * @see scenario.SpecificScenario#getArtifact()
	 * @see #getSpecificScenario()
	 * @generated
	 */
	EAttribute getSpecificScenario_Artifact();

	/**
	 * Returns the meta object for the attribute '{@link scenario.SpecificScenario#getResponse <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response</em>'.
	 * @see scenario.SpecificScenario#getResponse()
	 * @see #getSpecificScenario()
	 * @generated
	 */
	EAttribute getSpecificScenario_Response();

	/**
	 * Returns the meta object for the attribute '{@link scenario.SpecificScenario#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure</em>'.
	 * @see scenario.SpecificScenario#getMeasure()
	 * @see #getSpecificScenario()
	 * @generated
	 */
	EAttribute getSpecificScenario_Measure();

	/**
	 * Returns the meta object for the attribute '{@link scenario.SpecificScenario#getQualityAttribute <em>Quality Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Attribute</em>'.
	 * @see scenario.SpecificScenario#getQualityAttribute()
	 * @see #getSpecificScenario()
	 * @generated
	 */
	EAttribute getSpecificScenario_QualityAttribute();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScenarioFactory getScenarioFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link scenario.impl.GeneralScenarioImpl <em>General Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scenario.impl.GeneralScenarioImpl
		 * @see scenario.impl.ScenarioPackageImpl#getGeneralScenario()
		 * @generated
		 */
		EClass GENERAL_SCENARIO = eINSTANCE.getGeneralScenario();

		/**
		 * The meta object literal for the '<em><b>Quality Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_SCENARIO__QUALITY_ATTRIBUTE = eINSTANCE.getGeneralScenario_QualityAttribute();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_SCENARIO__SOURCE = eINSTANCE.getGeneralScenario_Source();

		/**
		 * The meta object literal for the '<em><b>Stimulus</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_SCENARIO__STIMULUS = eINSTANCE.getGeneralScenario_Stimulus();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_SCENARIO__ENVIRONMENT = eINSTANCE.getGeneralScenario_Environment();

		/**
		 * The meta object literal for the '<em><b>Artifact</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_SCENARIO__ARTIFACT = eINSTANCE.getGeneralScenario_Artifact();

		/**
		 * The meta object literal for the '<em><b>Response</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_SCENARIO__RESPONSE = eINSTANCE.getGeneralScenario_Response();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERAL_SCENARIO__MEASURE = eINSTANCE.getGeneralScenario_Measure();

		/**
		 * The meta object literal for the '<em><b>Generated Scenarios</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERAL_SCENARIO__GENERATED_SCENARIOS = eINSTANCE.getGeneralScenario_GeneratedScenarios();

		/**
		 * The meta object literal for the '{@link scenario.impl.SpecificScenarioImpl <em>Specific Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scenario.impl.SpecificScenarioImpl
		 * @see scenario.impl.ScenarioPackageImpl#getSpecificScenario()
		 * @generated
		 */
		EClass SPECIFIC_SCENARIO = eINSTANCE.getSpecificScenario();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SCENARIO__SOURCE = eINSTANCE.getSpecificScenario_Source();

		/**
		 * The meta object literal for the '<em><b>Stimulus</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SCENARIO__STIMULUS = eINSTANCE.getSpecificScenario_Stimulus();

		/**
		 * The meta object literal for the '<em><b>Environment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SCENARIO__ENVIRONMENT = eINSTANCE.getSpecificScenario_Environment();

		/**
		 * The meta object literal for the '<em><b>Artifact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SCENARIO__ARTIFACT = eINSTANCE.getSpecificScenario_Artifact();

		/**
		 * The meta object literal for the '<em><b>Response</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SCENARIO__RESPONSE = eINSTANCE.getSpecificScenario_Response();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SCENARIO__MEASURE = eINSTANCE.getSpecificScenario_Measure();

		/**
		 * The meta object literal for the '<em><b>Quality Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE = eINSTANCE.getSpecificScenario_QualityAttribute();

	}

} //ScenarioPackage
