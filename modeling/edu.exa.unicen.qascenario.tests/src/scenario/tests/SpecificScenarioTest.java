/**
 */
package scenario.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import scenario.ScenarioFactory;
import scenario.SpecificScenario;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Specific Scenario</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificScenarioTest extends TestCase {

  /**
   * The fixture for this Specific Scenario test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecificScenario fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(SpecificScenarioTest.class);
  }

  /**
   * Constructs a new Specific Scenario test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecificScenarioTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Specific Scenario test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(SpecificScenario fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Specific Scenario test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecificScenario getFixture() {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception {
    setFixture(ScenarioFactory.eINSTANCE.createSpecificScenario());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception {
    setFixture(null);
  }

} //SpecificScenarioTest
