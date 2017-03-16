/**
 */
package scenario;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Phrase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scenario.Phrase#getValue <em>Value</em>}</li>
 *   <li>{@link scenario.Phrase#getBegin <em>Begin</em>}</li>
 *   <li>{@link scenario.Phrase#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see scenario.ScenarioPackage#getPhrase()
 * @model
 * @generated
 */
public interface Phrase extends EObject {
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * The default value is <code>""</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see scenario.ScenarioPackage#getPhrase_Value()
   * @model default=""
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link scenario.Phrase#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Begin</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Begin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Begin</em>' attribute.
   * @see #setBegin(int)
   * @see scenario.ScenarioPackage#getPhrase_Begin()
   * @model default="-1"
   * @generated
   */
  int getBegin();

  /**
   * Sets the value of the '{@link scenario.Phrase#getBegin <em>Begin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Begin</em>' attribute.
   * @see #getBegin()
   * @generated
   */
  void setBegin(int value);

  /**
   * Returns the value of the '<em><b>End</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' attribute.
   * @see #setEnd(int)
   * @see scenario.ScenarioPackage#getPhrase_End()
   * @model default="-1"
   * @generated
   */
  int getEnd();

  /**
   * Sets the value of the '{@link scenario.Phrase#getEnd <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' attribute.
   * @see #getEnd()
   * @generated
   */
  void setEnd(int value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getValue();'"
   * @generated
   */
  String toString();

} // Phrase
