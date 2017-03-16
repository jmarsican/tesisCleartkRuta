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
 *   <li>{@link scenario.GeneralScenario#getDocumentLocation <em>Document Location</em>}</li>
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
   * Returns the value of the '<em><b>Source</b></em>' reference list.
   * The list contents are of type {@link scenario.Phrase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference list.
   * @see scenario.ScenarioPackage#getGeneralScenario_Source()
   * @model
   * @generated
   */
  EList<Phrase> getSource();

  /**
   * Returns the value of the '<em><b>Stimulus</b></em>' reference list.
   * The list contents are of type {@link scenario.Phrase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stimulus</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stimulus</em>' reference list.
   * @see scenario.ScenarioPackage#getGeneralScenario_Stimulus()
   * @model
   * @generated
   */
  EList<Phrase> getStimulus();

  /**
   * Returns the value of the '<em><b>Environment</b></em>' reference list.
   * The list contents are of type {@link scenario.Phrase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Environment</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Environment</em>' reference list.
   * @see scenario.ScenarioPackage#getGeneralScenario_Environment()
   * @model
   * @generated
   */
  EList<Phrase> getEnvironment();

  /**
   * Returns the value of the '<em><b>Artifact</b></em>' reference list.
   * The list contents are of type {@link scenario.Phrase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Artifact</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Artifact</em>' reference list.
   * @see scenario.ScenarioPackage#getGeneralScenario_Artifact()
   * @model
   * @generated
   */
  EList<Phrase> getArtifact();

  /**
   * Returns the value of the '<em><b>Response</b></em>' reference list.
   * The list contents are of type {@link scenario.Phrase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Response</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Response</em>' reference list.
   * @see scenario.ScenarioPackage#getGeneralScenario_Response()
   * @model
   * @generated
   */
  EList<Phrase> getResponse();

  /**
   * Returns the value of the '<em><b>Measure</b></em>' reference list.
   * The list contents are of type {@link scenario.Phrase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Measure</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Measure</em>' reference list.
   * @see scenario.ScenarioPackage#getGeneralScenario_Measure()
   * @model
   * @generated
   */
  EList<Phrase> getMeasure();

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

  /**
   * Returns the value of the '<em><b>Document Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Document Location</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Document Location</em>' attribute.
   * @see #setDocumentLocation(String)
   * @see scenario.ScenarioPackage#getGeneralScenario_DocumentLocation()
   * @model
   * @generated
   */
  String getDocumentLocation();

  /**
   * Sets the value of the '{@link scenario.GeneralScenario#getDocumentLocation <em>Document Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Document Location</em>' attribute.
   * @see #getDocumentLocation()
   * @generated
   */
  void setDocumentLocation(String value);

} // GeneralScenario
