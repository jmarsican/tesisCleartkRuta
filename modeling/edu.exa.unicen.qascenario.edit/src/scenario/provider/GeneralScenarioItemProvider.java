/**
 */
package scenario.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import scenario.GeneralScenario;
import scenario.ScenarioFactory;
import scenario.ScenarioPackage;

/**
 * This is the item provider adapter for a {@link scenario.GeneralScenario} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneralScenarioItemProvider 
  extends ItemProviderAdapter
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GeneralScenarioItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addQualityAttributePropertyDescriptor(object);
      addSourcePropertyDescriptor(object);
      addStimulusPropertyDescriptor(object);
      addEnvironmentPropertyDescriptor(object);
      addArtifactPropertyDescriptor(object);
      addResponsePropertyDescriptor(object);
      addMeasurePropertyDescriptor(object);
      addDocumentLocationPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Quality Attribute feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addQualityAttributePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_qualityAttribute_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_qualityAttribute_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__QUALITY_ATTRIBUTE,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Source feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSourcePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_source_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_source_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__SOURCE,
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Stimulus feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addStimulusPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_stimulus_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_stimulus_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__STIMULUS,
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Environment feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addEnvironmentPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_environment_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_environment_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__ENVIRONMENT,
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Artifact feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addArtifactPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_artifact_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_artifact_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__ARTIFACT,
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Response feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addResponsePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_response_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_response_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__RESPONSE,
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Measure feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addMeasurePropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_measure_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_measure_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__MEASURE,
         true,
         false,
         false,
         null,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Document Location feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDocumentLocationPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_GeneralScenario_documentLocation_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_GeneralScenario_documentLocation_feature", "_UI_GeneralScenario_type"),
         ScenarioPackage.Literals.GENERAL_SCENARIO__DOCUMENT_LOCATION,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ScenarioPackage.Literals.GENERAL_SCENARIO__GENERATED_SCENARIOS);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns GeneralScenario.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/GeneralScenario"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object) {
    String label = ((GeneralScenario)object).getQualityAttribute();
    return label == null || label.length() == 0 ?
      getString("_UI_GeneralScenario_type") :
      getString("_UI_GeneralScenario_type") + " " + label;
  }
  

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(GeneralScenario.class)) {
      case ScenarioPackage.GENERAL_SCENARIO__QUALITY_ATTRIBUTE:
      case ScenarioPackage.GENERAL_SCENARIO__SOURCE:
      case ScenarioPackage.GENERAL_SCENARIO__STIMULUS:
      case ScenarioPackage.GENERAL_SCENARIO__ENVIRONMENT:
      case ScenarioPackage.GENERAL_SCENARIO__ARTIFACT:
      case ScenarioPackage.GENERAL_SCENARIO__RESPONSE:
      case ScenarioPackage.GENERAL_SCENARIO__MEASURE:
      case ScenarioPackage.GENERAL_SCENARIO__DOCUMENT_LOCATION:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ScenarioPackage.GENERAL_SCENARIO__GENERATED_SCENARIOS:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (ScenarioPackage.Literals.GENERAL_SCENARIO__GENERATED_SCENARIOS,
         ScenarioFactory.eINSTANCE.createSpecificScenario()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return ScenarioEditPlugin.INSTANCE;
  }

}
