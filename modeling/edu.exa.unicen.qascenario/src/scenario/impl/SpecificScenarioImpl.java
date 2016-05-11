/**
 */
package scenario.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import scenario.ScenarioPackage;
import scenario.SpecificScenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scenario.impl.SpecificScenarioImpl#getSource <em>Source</em>}</li>
 *   <li>{@link scenario.impl.SpecificScenarioImpl#getStimulus <em>Stimulus</em>}</li>
 *   <li>{@link scenario.impl.SpecificScenarioImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link scenario.impl.SpecificScenarioImpl#getArtifact <em>Artifact</em>}</li>
 *   <li>{@link scenario.impl.SpecificScenarioImpl#getResponse <em>Response</em>}</li>
 *   <li>{@link scenario.impl.SpecificScenarioImpl#getMeasure <em>Measure</em>}</li>
 *   <li>{@link scenario.impl.SpecificScenarioImpl#getQualityAttribute <em>Quality Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificScenarioImpl extends MinimalEObjectImpl.Container implements SpecificScenario {
	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStimulus() <em>Stimulus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStimulus()
	 * @generated
	 * @ordered
	 */
	protected static final String STIMULUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStimulus() <em>Stimulus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStimulus()
	 * @generated
	 * @ordered
	 */
	protected String stimulus = STIMULUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnvironment() <em>Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected static final String ENVIRONMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected String environment = ENVIRONMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getArtifact() <em>Artifact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifact()
	 * @generated
	 * @ordered
	 */
	protected static final String ARTIFACT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArtifact() <em>Artifact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifact()
	 * @generated
	 * @ordered
	 */
	protected String artifact = ARTIFACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponse() <em>Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponse()
	 * @generated
	 * @ordered
	 */
	protected static final String RESPONSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResponse() <em>Response</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponse()
	 * @generated
	 * @ordered
	 */
	protected String response = RESPONSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final String MEASURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected String measure = MEASURE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.SPECIFIC_SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SPECIFIC_SCENARIO__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStimulus() {
		return stimulus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStimulus(String newStimulus) {
		String oldStimulus = stimulus;
		stimulus = newStimulus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SPECIFIC_SCENARIO__STIMULUS, oldStimulus, stimulus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvironment(String newEnvironment) {
		String oldEnvironment = environment;
		environment = newEnvironment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SPECIFIC_SCENARIO__ENVIRONMENT, oldEnvironment, environment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArtifact() {
		return artifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifact(String newArtifact) {
		String oldArtifact = artifact;
		artifact = newArtifact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SPECIFIC_SCENARIO__ARTIFACT, oldArtifact, artifact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponse(String newResponse) {
		String oldResponse = response;
		response = newResponse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SPECIFIC_SCENARIO__RESPONSE, oldResponse, response));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeasure() {
		return measure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasure(String newMeasure) {
		String oldMeasure = measure;
		measure = newMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SPECIFIC_SCENARIO__MEASURE, oldMeasure, measure));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE, oldQualityAttribute, qualityAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScenarioPackage.SPECIFIC_SCENARIO__SOURCE:
				return getSource();
			case ScenarioPackage.SPECIFIC_SCENARIO__STIMULUS:
				return getStimulus();
			case ScenarioPackage.SPECIFIC_SCENARIO__ENVIRONMENT:
				return getEnvironment();
			case ScenarioPackage.SPECIFIC_SCENARIO__ARTIFACT:
				return getArtifact();
			case ScenarioPackage.SPECIFIC_SCENARIO__RESPONSE:
				return getResponse();
			case ScenarioPackage.SPECIFIC_SCENARIO__MEASURE:
				return getMeasure();
			case ScenarioPackage.SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE:
				return getQualityAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScenarioPackage.SPECIFIC_SCENARIO__SOURCE:
				setSource((String)newValue);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__STIMULUS:
				setStimulus((String)newValue);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__ENVIRONMENT:
				setEnvironment((String)newValue);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__ARTIFACT:
				setArtifact((String)newValue);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__RESPONSE:
				setResponse((String)newValue);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__MEASURE:
				setMeasure((String)newValue);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE:
				setQualityAttribute((String)newValue);
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
			case ScenarioPackage.SPECIFIC_SCENARIO__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__STIMULUS:
				setStimulus(STIMULUS_EDEFAULT);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__ENVIRONMENT:
				setEnvironment(ENVIRONMENT_EDEFAULT);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__ARTIFACT:
				setArtifact(ARTIFACT_EDEFAULT);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__RESPONSE:
				setResponse(RESPONSE_EDEFAULT);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__MEASURE:
				setMeasure(MEASURE_EDEFAULT);
				return;
			case ScenarioPackage.SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE:
				setQualityAttribute(QUALITY_ATTRIBUTE_EDEFAULT);
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
			case ScenarioPackage.SPECIFIC_SCENARIO__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case ScenarioPackage.SPECIFIC_SCENARIO__STIMULUS:
				return STIMULUS_EDEFAULT == null ? stimulus != null : !STIMULUS_EDEFAULT.equals(stimulus);
			case ScenarioPackage.SPECIFIC_SCENARIO__ENVIRONMENT:
				return ENVIRONMENT_EDEFAULT == null ? environment != null : !ENVIRONMENT_EDEFAULT.equals(environment);
			case ScenarioPackage.SPECIFIC_SCENARIO__ARTIFACT:
				return ARTIFACT_EDEFAULT == null ? artifact != null : !ARTIFACT_EDEFAULT.equals(artifact);
			case ScenarioPackage.SPECIFIC_SCENARIO__RESPONSE:
				return RESPONSE_EDEFAULT == null ? response != null : !RESPONSE_EDEFAULT.equals(response);
			case ScenarioPackage.SPECIFIC_SCENARIO__MEASURE:
				return MEASURE_EDEFAULT == null ? measure != null : !MEASURE_EDEFAULT.equals(measure);
			case ScenarioPackage.SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE:
				return QUALITY_ATTRIBUTE_EDEFAULT == null ? qualityAttribute != null : !QUALITY_ATTRIBUTE_EDEFAULT.equals(qualityAttribute);
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
		result.append(" (source: ");
		result.append(source);
		result.append(", stimulus: ");
		result.append(stimulus);
		result.append(", environment: ");
		result.append(environment);
		result.append(", artifact: ");
		result.append(artifact);
		result.append(", response: ");
		result.append(response);
		result.append(", measure: ");
		result.append(measure);
		result.append(", qualityAttribute: ");
		result.append(qualityAttribute);
		result.append(')');
		return result.toString();
	}

} //SpecificScenarioImpl
