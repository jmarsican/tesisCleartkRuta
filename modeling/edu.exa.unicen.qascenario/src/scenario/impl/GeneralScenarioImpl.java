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

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import scenario.GeneralScenario;
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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<String> source;

	/**
	 * The cached value of the '{@link #getStimulus() <em>Stimulus</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStimulus()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stimulus;

	/**
	 * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected EList<String> environment;

	/**
	 * The cached value of the '{@link #getArtifact() <em>Artifact</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifact()
	 * @generated
	 * @ordered
	 */
	protected EList<String> artifact;

	/**
	 * The cached value of the '{@link #getResponse() <em>Response</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponse()
	 * @generated
	 * @ordered
	 */
	protected EList<String> response;

	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected EList<String> measure;

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
	public EList<String> getSource() {
		if (source == null) {
			source = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.GENERAL_SCENARIO__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStimulus() {
		if (stimulus == null) {
			stimulus = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.GENERAL_SCENARIO__STIMULUS);
		}
		return stimulus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEnvironment() {
		if (environment == null) {
			environment = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT);
		}
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getArtifact() {
		if (artifact == null) {
			artifact = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.GENERAL_SCENARIO__ARTIFACT);
		}
		return artifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getResponse() {
		if (response == null) {
			response = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.GENERAL_SCENARIO__RESPONSE);
		}
		return response;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMeasure() {
		if (measure == null) {
			measure = new EDataTypeUniqueEList<String>(String.class, this, ScenarioPackage.GENERAL_SCENARIO__MEASURE);
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
				getSource().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.GENERAL_SCENARIO__STIMULUS:
				getStimulus().clear();
				getStimulus().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT:
				getEnvironment().clear();
				getEnvironment().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.GENERAL_SCENARIO__ARTIFACT:
				getArtifact().clear();
				getArtifact().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.GENERAL_SCENARIO__RESPONSE:
				getResponse().clear();
				getResponse().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.GENERAL_SCENARIO__MEASURE:
				getMeasure().clear();
				getMeasure().addAll((Collection<? extends String>)newValue);
				return;
			case ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS:
				getGeneratedScenarios().clear();
				getGeneratedScenarios().addAll((Collection<? extends SpecificScenario>)newValue);
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
		result.append(", source: ");
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
		result.append(')');
		return result.toString();
	}

} //GeneralScenarioImpl
