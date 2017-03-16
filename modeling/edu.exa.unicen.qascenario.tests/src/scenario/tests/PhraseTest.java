/**
 */
package scenario.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import scenario.Phrase;
import scenario.ScenarioFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Phrase</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link scenario.Phrase#toString() <em>To String</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PhraseTest extends TestCase {

  /**
   * The fixture for this Phrase test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Phrase fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args) {
    TestRunner.run(PhraseTest.class);
  }

  /**
   * Constructs a new Phrase test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PhraseTest(String name) {
    super(name);
  }

  /**
   * Sets the fixture for this Phrase test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Phrase fixture) {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Phrase test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Phrase getFixture() {
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
    setFixture(ScenarioFactory.eINSTANCE.createPhrase());
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

  /**
   * Tests the '{@link scenario.Phrase#toString() <em>To String</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see scenario.Phrase#toString()
   * @generated
   */
  public void testToString() {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //PhraseTest
