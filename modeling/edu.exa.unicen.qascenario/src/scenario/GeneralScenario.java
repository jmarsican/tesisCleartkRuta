/**
 */
package scenario;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>General Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scenario.GeneralScenario#getQualityAttribute <em>Quality Attribute</em>}</li>
 *   <li>{@link scenario.GeneralScenario#getSource <em>Source</em>}</li>
 *   <li>{@link scenario.GeneralScenario#getStimulus <em>Stimulus</em>}</li>
 *   <li>{@link scenario.GeneralScenario#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link scenario.GeneralScenario#getArtifact <em>Artifact</em>}</li>
 *   <li>{@link scenario.GeneralScenario#getResponse <em>Response</em>}</li>
 *   <li>{@link scenario.GeneralScenario#getMeasure <em>Measure</em>}</li>
 *   <li>{@link scenario.GeneralScenario#getGeneratedScenarios <em>Generated Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @see scenario.ScenarioPackage#getGeneralScenario()
 * @model
 * @generated
 */
public interface GeneralScenario extends EObject {
	/**
	 * Returns the value of the '<em><b>Quality Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Attribute</em>' attribute.
	 * @see #setQualityAttribute(String)
	 * @see scenario.ScenarioPackage#getGeneralScenario_QualityAttribute()
	 * @model
	 * @generated
	 */
	String getQualityAttribute();

	/**
	 * Sets the value of the '{@link scenario.GeneralScenario#getQualityAttribute <em>Quality Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Attribute</em>' attribute.
	 * @see #getQualityAttribute()
	 * @generated
	 */
	void setQualityAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute list.
	 * @see scenario.ScenarioPackage#getGeneralScenario_Source()
	 * @model
	 * @generated
	 */
	EList<String> getSource();

	/**
	 * Returns the value of the '<em><b>Stimulus</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stimulus</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stimulus</em>' attribute list.
	 * @see scenario.ScenarioPackage#getGeneralScenario_Stimulus()
	 * @model
	 * @generated
	 */
	EList<String> getStimulus();

	/**
	 * Returns the value of the '<em><b>Environment</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Environment</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment</em>' attribute list.
	 * @see scenario.ScenarioPackage#getGeneralScenario_Environment()
	 * @model
	 * @generated
	 */
	EList<String> getEnvironment();

	/**
	 * Returns the value of the '<em><b>Artifact</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact</em>' attribute list.
	 * @see scenario.ScenarioPackage#getGeneralScenario_Artifact()
	 * @model
	 * @generated
	 */
	EList<String> getArtifact();

	/**
	 * Returns the value of the '<em><b>Response</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Response</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Response</em>' attribute list.
	 * @see scenario.ScenarioPackage#getGeneralScenario_Response()
	 * @model
	 * @generated
	 */
	EList<String> getResponse();

	/**
	 * Returns the value of the '<em><b>Measure</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' attribute list.
	 * @see scenario.ScenarioPackage#getGeneralScenario_Measure()
	 * @model
	 * @generated
	 */
	EList<String> getMeasure();

	/**
	 * Returns the value of the '<em><b>Generated Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link scenario.SpecificScenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generated Scenarios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generated Scenarios</em>' containment reference list.
	 * @see scenario.ScenarioPackage#getGeneralScenario_GeneratedScenarios()
	 * @model containment="true"
	 * @generated
	 */
	EList<SpecificScenario> getGeneratedScenarios();

} // GeneralScenario
