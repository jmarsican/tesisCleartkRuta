/**
 */
package scenario.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scenario.GeneralScenario;
import scenario.Phrase;
import scenario.ScenarioPackage;
import scenario.SpecificScenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getQualityAttribute <em>Quality Attribute</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getSource <em>Source</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getStimulus <em>Stimulus</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getArtifact <em>Artifact</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getResponse <em>Response</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getGeneratedScenarios <em>Generated Scenarios</em>}</li>
 *   <li>{@link scenario.impl.GeneralScenarioImpl#getDocumentLocation <em>Document Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralScenarioImpl extends MinimalEObjectImpl.Container implements GeneralScenario {
  /**
   * The default value of the '{@link #getQualityAttribute() <em>Quality Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityAttribute()
   * @generated
   * @ordered
   */
  protected static final String QUALITY_ATTRIBUTE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQualityAttribute() <em>Quality Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityAttribute()
   * @generated
   * @ordered
   */
  protected String qualityAttribute = QUALITY_ATTRIBUTE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected EList<Phrase> source;

  /**
   * The cached value of the '{@link #getStimulus() <em>Stimulus</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStimulus()
   * @generated
   * @ordered
   */
  protected EList<Phrase> stimulus;

  /**
   * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnvironment()
   * @generated
   * @ordered
   */
  protected EList<Phrase> environment;

  /**
   * The cached value of the '{@link #getArtifact() <em>Artifact</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArtifact()
   * @generated
   * @ordered
   */
  protected EList<Phrase> artifact;

  /**
   * The cached value of the '{@link #getResponse() <em>Response</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponse()
   * @generated
   * @ordered
   */
  protected EList<Phrase> response;

  /**
   * The cached value of the '{@link #getMeasure() <em>Measure</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMeasure()
   * @generated
   * @ordered
   */
  protected EList<Phrase> measure;

  /**
   * The cached value of the '{@link #getGeneratedScenarios() <em>Generated Scenarios</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGeneratedScenarios()
   * @generated
   * @ordered
   */
  protected EList<SpecificScenario> generatedScenarios;

  /**
   * The default value of the '{@link #getDocumentLocation() <em>Document Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentLocation()
   * @generated
   * @ordered
   */
  protected static final String DOCUMENT_LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDocumentLocation() <em>Document Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDocumentLocation()
   * @generated
   * @ordered
   */
  protected String documentLocation = DOCUMENT_LOCATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GeneralScenarioImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ScenarioPackage.Literals.GENERAL_SCENARIO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQualityAttribute() {
    return qualityAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualityAttribute(String newQualityAttribute) {
    String oldQualityAttribute = qualityAttribute;
    qualityAttribute = newQualityAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.GENERAL_SCENARIO__QUALITY_ATTRIBUTE, oldQualityAttribute, qualityAttribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Phrase> getSource() {
    if (source == null) {
      source = new EObjectResolvingEList<Phrase>(Phrase.class, this, ScenarioPackage.GENERAL_SCENARIO__SOURCE);
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Phrase> getStimulus() {
    if (stimulus == null) {
      stimulus = new EObjectResolvingEList<Phrase>(Phrase.class, this, ScenarioPackage.GENERAL_SCENARIO__STIMULUS);
    }
    return stimulus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Phrase> getEnvironment() {
    if (environment == null) {
      environment = new EObjectResolvingEList<Phrase>(Phrase.class, this, ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT);
    }
    return environment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Phrase> getArtifact() {
    if (artifact == null) {
      artifact = new EObjectResolvingEList<Phrase>(Phrase.class, this, ScenarioPackage.GENERAL_SCENARIO__ARTIFACT);
    }
    return artifact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Phrase> getResponse() {
    if (response == null) {
      response = new EObjectResolvingEList<Phrase>(Phrase.class, this, ScenarioPackage.GENERAL_SCENARIO__RESPONSE);
    }
    return response;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Phrase> getMeasure() {
    if (measure == null) {
      measure = new EObjectResolvingEList<Phrase>(Phrase.class, this, ScenarioPackage.GENERAL_SCENARIO__MEASURE);
    }
    return measure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SpecificScenario> getGeneratedScenarios() {
    if (generatedScenarios == null) {
      generatedScenarios = new EObjectContainmentEList<SpecificScenario>(SpecificScenario.class, this, ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS);
    }
    return generatedScenarios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDocumentLocation() {
    return documentLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDocumentLocation(String newDocumentLocation) {
    String oldDocumentLocation = documentLocation;
    documentLocation = newDocumentLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.GENERAL_SCENARIO__DOCUMENT_LOCATION, oldDocumentLocation, documentLocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS:
        return ((InternalEList<?>)getGeneratedScenarios()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ScenarioPackage.GENERAL_SCENARIO__QUALITY_ATTRIBUTE:
        return getQualityAttribute();
      case ScenarioPackage.GENERAL_SCENARIO__SOURCE:
        return getSource();
      case ScenarioPackage.GENERAL_SCENARIO__STIMULUS:
        return getStimulus();
      case ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT:
        return getEnvironment();
      case ScenarioPackage.GENERAL_SCENARIO__ARTIFACT:
        return getArtifact();
      case ScenarioPackage.GENERAL_SCENARIO__RESPONSE:
        return getResponse();
      case ScenarioPackage.GENERAL_SCENARIO__MEASURE:
        return getMeasure();
      case ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS:
        return getGeneratedScenarios();
      case ScenarioPackage.GENERAL_SCENARIO__DOCUMENT_LOCATION:
        return getDocumentLocation();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ScenarioPackage.GENERAL_SCENARIO__QUALITY_ATTRIBUTE:
        setQualityAttribute((String)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__SOURCE:
        getSource().clear();
        getSource().addAll((Collection<? extends Phrase>)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__STIMULUS:
        getStimulus().clear();
        getStimulus().addAll((Collection<? extends Phrase>)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT:
        getEnvironment().clear();
        getEnvironment().addAll((Collection<? extends Phrase>)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__ARTIFACT:
        getArtifact().clear();
        getArtifact().addAll((Collection<? extends Phrase>)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__RESPONSE:
        getResponse().clear();
        getResponse().addAll((Collection<? extends Phrase>)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__MEASURE:
        getMeasure().clear();
        getMeasure().addAll((Collection<? extends Phrase>)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS:
        getGeneratedScenarios().clear();
        getGeneratedScenarios().addAll((Collection<? extends SpecificScenario>)newValue);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__DOCUMENT_LOCATION:
        setDocumentLocation((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ScenarioPackage.GENERAL_SCENARIO__QUALITY_ATTRIBUTE:
        setQualityAttribute(QUALITY_ATTRIBUTE_EDEFAULT);
        return;
      case ScenarioPackage.GENERAL_SCENARIO__SOURCE:
        getSource().clear();
        return;
      case ScenarioPackage.GENERAL_SCENARIO__STIMULUS:
        getStimulus().clear();
        return;
      case ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT:
        getEnvironment().clear();
        return;
      case ScenarioPackage.GENERAL_SCENARIO__ARTIFACT:
        getArtifact().clear();
        return;
      case ScenarioPackage.GENERAL_SCENARIO__RESPONSE:
        getResponse().clear();
        return;
      case ScenarioPackage.GENERAL_SCENARIO__MEASURE:
        getMeasure().clear();
        return;
      case ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS:
        getGeneratedScenarios().clear();
        return;
      case ScenarioPackage.GENERAL_SCENARIO__DOCUMENT_LOCATION:
        setDocumentLocation(DOCUMENT_LOCATION_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ScenarioPackage.GENERAL_SCENARIO__QUALITY_ATTRIBUTE:
        return QUALITY_ATTRIBUTE_EDEFAULT == null ? qualityAttribute != null : !QUALITY_ATTRIBUTE_EDEFAULT.equals(qualityAttribute);
      case ScenarioPackage.GENERAL_SCENARIO__SOURCE:
        return source != null && !source.isEmpty();
      case ScenarioPackage.GENERAL_SCENARIO__STIMULUS:
        return stimulus != null && !stimulus.isEmpty();
      case ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT:
        return environment != null && !environment.isEmpty();
      case ScenarioPackage.GENERAL_SCENARIO__ARTIFACT:
        return artifact != null && !artifact.isEmpty();
      case ScenarioPackage.GENERAL_SCENARIO__RESPONSE:
        return response != null && !response.isEmpty();
      case ScenarioPackage.GENERAL_SCENARIO__MEASURE:
        return measure != null && !measure.isEmpty();
      case ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS:
        return generatedScenarios != null && !generatedScenarios.isEmpty();
      case ScenarioPackage.GENERAL_SCENARIO__DOCUMENT_LOCATION:
        return DOCUMENT_LOCATION_EDEFAULT == null ? documentLocation != null : !DOCUMENT_LOCATION_EDEFAULT.equals(documentLocation);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (qualityAttribute: ");
    result.append(qualityAttribute);
    result.append(", documentLocation: ");
    result.append(documentLocation);
    result.append(')');
    return result.toString();
  }

} //GeneralScenarioImpl
