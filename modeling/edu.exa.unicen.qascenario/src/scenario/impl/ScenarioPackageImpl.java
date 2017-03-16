/**
 */
package scenario.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import scenario.GeneralScenario;
import scenario.Phrase;
import scenario.ScenarioFactory;
import scenario.ScenarioPackage;
import scenario.SpecificScenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScenarioPackageImpl extends EPackageImpl implements ScenarioPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass generalScenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specificScenarioEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass phraseEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see scenario.ScenarioPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ScenarioPackageImpl() {
    super(eNS_URI, ScenarioFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ScenarioPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ScenarioPackage init() {
    if (isInited) return (ScenarioPackage)EPackage.Registry.INSTANCE.getEPackage(ScenarioPackage.eNS_URI);

    // Obtain or create and register package
    ScenarioPackageImpl theScenarioPackage = (ScenarioPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScenarioPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScenarioPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theScenarioPackage.createPackageContents();

    // Initialize created meta-data
    theScenarioPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theScenarioPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ScenarioPackage.eNS_URI, theScenarioPackage);
    return theScenarioPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGeneralScenario() {
    return generalScenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGeneralScenario_QualityAttribute() {
    return (EAttribute)generalScenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralScenario_Source() {
    return (EReference)generalScenarioEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralScenario_Stimulus() {
    return (EReference)generalScenarioEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralScenario_Environment() {
    return (EReference)generalScenarioEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralScenario_Artifact() {
    return (EReference)generalScenarioEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralScenario_Response() {
    return (EReference)generalScenarioEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralScenario_Measure() {
    return (EReference)generalScenarioEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGeneralScenario_GeneratedScenarios() {
    return (EReference)generalScenarioEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGeneralScenario_DocumentLocation() {
    return (EAttribute)generalScenarioEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecificScenario() {
    return specificScenarioEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificScenario_Source() {
    return (EAttribute)specificScenarioEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificScenario_Stimulus() {
    return (EAttribute)specificScenarioEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificScenario_Environment() {
    return (EAttribute)specificScenarioEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificScenario_Artifact() {
    return (EAttribute)specificScenarioEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificScenario_Response() {
    return (EAttribute)specificScenarioEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificScenario_Measure() {
    return (EAttribute)specificScenarioEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificScenario_QualityAttribute() {
    return (EAttribute)specificScenarioEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPhrase() {
    return phraseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPhrase_Value() {
    return (EAttribute)phraseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPhrase_Begin() {
    return (EAttribute)phraseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPhrase_End() {
    return (EAttribute)phraseEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getPhrase__ToString() {
    return phraseEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScenarioFactory getScenarioFactory() {
    return (ScenarioFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    generalScenarioEClass = createEClass(GENERAL_SCENARIO);
    createEAttribute(generalScenarioEClass, GENERAL_SCENARIO__QUALITY_ATTRIBUTE);
    createEReference(generalScenarioEClass, GENERAL_SCENARIO__SOURCE);
    createEReference(generalScenarioEClass, GENERAL_SCENARIO__STIMULUS);
    createEReference(generalScenarioEClass, GENERAL_SCENARIO__ENVIRONMENT);
    createEReference(generalScenarioEClass, GENERAL_SCENARIO__ARTIFACT);
    createEReference(generalScenarioEClass, GENERAL_SCENARIO__RESPONSE);
    createEReference(generalScenarioEClass, GENERAL_SCENARIO__MEASURE);
    createEReference(generalScenarioEClass, GENERAL_SCENARIO__GENERATED_SCENARIOS);
    createEAttribute(generalScenarioEClass, GENERAL_SCENARIO__DOCUMENT_LOCATION);

    specificScenarioEClass = createEClass(SPECIFIC_SCENARIO);
    createEAttribute(specificScenarioEClass, SPECIFIC_SCENARIO__SOURCE);
    createEAttribute(specificScenarioEClass, SPECIFIC_SCENARIO__STIMULUS);
    createEAttribute(specificScenarioEClass, SPECIFIC_SCENARIO__ENVIRONMENT);
    createEAttribute(specificScenarioEClass, SPECIFIC_SCENARIO__ARTIFACT);
    createEAttribute(specificScenarioEClass, SPECIFIC_SCENARIO__RESPONSE);
    createEAttribute(specificScenarioEClass, SPECIFIC_SCENARIO__MEASURE);
    createEAttribute(specificScenarioEClass, SPECIFIC_SCENARIO__QUALITY_ATTRIBUTE);

    phraseEClass = createEClass(PHRASE);
    createEAttribute(phraseEClass, PHRASE__VALUE);
    createEAttribute(phraseEClass, PHRASE__BEGIN);
    createEAttribute(phraseEClass, PHRASE__END);
    createEOperation(phraseEClass, PHRASE___TO_STRING);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(generalScenarioEClass, GeneralScenario.class, "GeneralScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGeneralScenario_QualityAttribute(), ecorePackage.getEString(), "qualityAttribute", null, 0, 1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralScenario_Source(), this.getPhrase(), null, "source", null, 0, -1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralScenario_Stimulus(), this.getPhrase(), null, "stimulus", null, 0, -1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralScenario_Environment(), this.getPhrase(), null, "environment", null, 0, -1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralScenario_Artifact(), this.getPhrase(), null, "artifact", null, 0, -1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralScenario_Response(), this.getPhrase(), null, "response", null, 0, -1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralScenario_Measure(), this.getPhrase(), null, "measure", null, 0, -1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGeneralScenario_GeneratedScenarios(), this.getSpecificScenario(), null, "generatedScenarios", null, 0, -1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGeneralScenario_DocumentLocation(), ecorePackage.getEString(), "documentLocation", null, 0, 1, GeneralScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specificScenarioEClass, SpecificScenario.class, "SpecificScenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpecificScenario_Source(), ecorePackage.getEString(), "source", null, 0, 1, SpecificScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecificScenario_Stimulus(), ecorePackage.getEString(), "stimulus", null, 0, 1, SpecificScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecificScenario_Environment(), ecorePackage.getEString(), "environment", null, 0, 1, SpecificScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecificScenario_Artifact(), ecorePackage.getEString(), "artifact", null, 0, 1, SpecificScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecificScenario_Response(), ecorePackage.getEString(), "response", null, 0, 1, SpecificScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecificScenario_Measure(), ecorePackage.getEString(), "measure", null, 0, 1, SpecificScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecificScenario_QualityAttribute(), ecorePackage.getEString(), "qualityAttribute", null, 0, 1, SpecificScenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(phraseEClass, Phrase.class, "Phrase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPhrase_Value(), ecorePackage.getEString(), "value", "", 0, 1, Phrase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPhrase_Begin(), ecorePackage.getEInt(), "begin", "-1", 0, 1, Phrase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPhrase_End(), ecorePackage.getEInt(), "end", "-1", 0, 1, Phrase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getPhrase__ToString(), ecorePackage.getEString(), "toString", 0, 1, IS_UNIQUE, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ScenarioPackageImpl
