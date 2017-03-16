

/* First created by JCasGen Thu Oct 13 21:54:17 ART 2016 */
package uima.ruta.example.TestPerformance;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Type defined in uima.ruta.example.TestPerformance
 * Updated by JCasGen Thu Oct 13 21:54:17 ART 2016
 * XML source: /home/andresjoi/projects/tesisCleartkRuta/cleartk-ruta/descriptor/uima/ruta/example/TestPerformanceTypeSystem.xml
 * @generated */
public class TokenConstraint extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TokenConstraint.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected TokenConstraint() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TokenConstraint(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TokenConstraint(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TokenConstraint(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: pos

  /** getter for pos - gets pos
   * @generated
   * @return value of the feature 
   */
  public String getPos() {
    if (TokenConstraint_Type.featOkTst && ((TokenConstraint_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "uima.ruta.example.TestPerformance.TokenConstraint");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TokenConstraint_Type)jcasType).casFeatCode_pos);}
    
  /** setter for pos - sets pos 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPos(String v) {
    if (TokenConstraint_Type.featOkTst && ((TokenConstraint_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "uima.ruta.example.TestPerformance.TokenConstraint");
    jcasType.ll_cas.ll_setStringValue(addr, ((TokenConstraint_Type)jcasType).casFeatCode_pos, v);}    
   
    
  //*--------------*
  //* Feature: lemma

  /** getter for lemma - gets lemma
   * @generated
   * @return value of the feature 
   */
  public String getLemma() {
    if (TokenConstraint_Type.featOkTst && ((TokenConstraint_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "uima.ruta.example.TestPerformance.TokenConstraint");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TokenConstraint_Type)jcasType).casFeatCode_lemma);}
    
  /** setter for lemma - sets lemma 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLemma(String v) {
    if (TokenConstraint_Type.featOkTst && ((TokenConstraint_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "uima.ruta.example.TestPerformance.TokenConstraint");
    jcasType.ll_cas.ll_setStringValue(addr, ((TokenConstraint_Type)jcasType).casFeatCode_lemma, v);}    
  }

    