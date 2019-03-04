package com.incquerylabs.v4md.test;

import java.io.File;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.junit.After;
import org.junit.Before;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.test.queries.PortConnections;
import com.incquerylabs.v4md.test.queries.PortConnections.Matcher;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.tests.MagicDrawTestCase;
import com.nomagic.magicdraw.tests.common.TestEnvironment;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector;

public class ModelUpdateTests extends MagicDrawTestCase {
			
	protected  Project project;
	protected static String projectToUse = "ConnectorRemoveTest.mdzip";
	private boolean printEnabled = true;

	@Before
    protected void setUpTest() throws Exception
    {
		project = loadProject(new File(TestEnvironment.getResourceDir(), projectToUse).getAbsolutePath());
		setSkipMemoryTest(true);
        super.setUpTest();
     }

	@After
	protected void tearDownTest() throws Exception {
		closeAllProjects();
		super.tearDownTest();
	}
	
	public void testListener() {
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		Matcher matcher = PortConnections.Matcher.on(adapter.getEngine());
		
		matcher.countMatches();
		EContentAdapter eAdapter = new EContentAdapter() {

			@Override
			public void notifyChanged(Notification notification) {
				if (printEnabled) System.out.println(notification);
			}
			
		};
		project.getPrimaryModel().eAdapters().add(eAdapter);
		
		final Connector connector = (Connector) project.getElementByID("_19_0_1_c0402f4_1551707958244_224488_42396");
		SessionManager.getInstance().executeInsideSession(project, "Modification", connector::dispose);
		
		printEnabled = false;
		project.getPrimaryModel().eAdapters().remove(eAdapter);
	}
	
	/* The following is the (simplified) event log of the executed test; notice that REMOVE and REMOVE_MANY statements related to the `end` feature of the connectors
	 * 
ENotificationImpl@742769a6 (eventType: SET, position: -1, notifier: ConnectorEndImpl@86b5c5e5, feature: (name: _connectorOfEnd), oldValue: ConnectorImpl@edd8f8a1, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@3ee25c86 (eventType: REMOVE, position: 1, notifier: ConnectorImpl@edd8f8a1, feature: (name: end), oldValue: ConnectorEndImpl@86b5c5e5, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@2a9a7bd9 (eventType: SET, position: -1, notifier: ConnectorEndImpl@b6c7fc52, feature: (name: _connectorOfEnd), oldValue: ConnectorImpl@edd8f8a1, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@5ec36136 (eventType: REMOVE, position: 0, notifier: ConnectorImpl@edd8f8a1, feature: (name: end), oldValue: ConnectorEndImpl@b6c7fc52, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@380d2b3c (eventType: REMOVE_MANY, position: -1, notifier: ConnectorImpl@edd8f8a1, feature: EReferenceImpl@2c95ac9e (name: end), oldValue: [ConnectorEndImpl@b6c7fc52, ConnectorEndImpl@86b5c5e5], newValue: null, isTouch: false, wasSet: true)

2019-03-04 15:33:48,174 [AWT-EventQueue-0] ERROR org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil.org.eclipse.viatra.query.runtime.api.ViatraQueryEngine.2068080930 - Error: trying to remove non-existing value ConnectorEndImpl@b6c7fc52 from the feature EReferenceImpl@2c95ac9e (name: end) of host object ConnectorImpl@edd8f8a1. This indicates some errors in underlying model representation.
2019-03-04 15:33:48,174 [AWT-EventQueue-0] ERROR org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil.org.eclipse.viatra.query.runtime.api.ViatraQueryEngine.2068080930 - Error: trying to remove non-existing value ConnectorEndImpl@86b5c5e5 from the feature EReferenceImpl@2c95ac9e (name: end) of host object ConnectorImpl@edd8f8a1. This indicates some errors in underlying model representation.

ENotificationImpl@21591e8d (eventType: SET, position: -1, notifier: InstanceSpecificationImpl@5c6cc46f, feature: EReferenceImpl@27eb3298 (name: stereotypedElement), oldValue: ConnectorEndImpl@86b5c5e5, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@58e4edcc (eventType: SET, position: -1, notifier: ConnectorEndImpl@86b5c5e5, feature: EReferenceImpl@5827af16 (name: appliedStereotypeInstance), oldValue: InstanceSpecificationImpl@5c6cc46f, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@252ab30b (eventType: SET, position: -1, notifier: SlotImpl@19b6d55d, feature: EReferenceImpl@35d6ca49 (name: owningInstance), oldValue: InstanceSpecificationImpl@5c6cc46f, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@5a5fb0ef (eventType: REMOVE, position: 0, notifier: InstanceSpecificationImpl@5c6cc46f, feature: EReferenceImpl@4108fa66 (name: slot), oldValue: SlotImpl@19b6d55d, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@189f7cc6 (eventType: REMOVE, position: 0, notifier: InstanceSpecificationImpl@5c6cc46f, feature: EReferenceImpl@4108fa66 (name: slot), oldValue: SlotImpl@19b6d55d, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@1cb1aaad (eventType: SET, position: -1, notifier: ElementValueImpl@983f8e60, feature: EReferenceImpl@5860f3d7 (name: owningSlot), oldValue: SlotImpl@19b6d55d, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@71aad914 (eventType: REMOVE, position: 0, notifier: SlotImpl@19b6d55d, feature: EReferenceImpl@1950e8a6 (name: value), oldValue: ElementValueImpl@983f8e60, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@4347aceb (eventType: REMOVE, position: 0, notifier: SlotImpl@19b6d55d, feature: EReferenceImpl@1950e8a6 (name: value), oldValue: ElementValueImpl@983f8e60, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@75eeb563 (eventType: REMOVE, position: 0, notifier: PropertyImpl@d27a9f1a, feature: EReferenceImpl@12dae582 (name: _elementValueOfElement), oldValue: ElementValueImpl@983f8e60, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@b306fc1 (eventType: SET, position: -1, notifier: ElementValueImpl@983f8e60, feature: EReferenceImpl@2187fff7 (name: element), oldValue: PropertyImpl@d27a9f1a, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@5be5ef77 (eventType: REMOVE, position: 0, notifier: PropertyImpl@9cdd769d, feature: EReferenceImpl@724f138e (name: _slotOfDefiningFeature), oldValue: SlotImpl@19b6d55d, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@325eeb5 (eventType: SET, position: -1, notifier: SlotImpl@19b6d55d, feature: EReferenceImpl@47289387 (name: definingFeature), oldValue: PropertyImpl@9cdd769d, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@747a42d6 (eventType: REMOVE, position: 0, notifier: StereotypeImpl@322e17fc, feature: EReferenceImpl@7829b776 (name: _instanceSpecificationOfClassifier), oldValue: InstanceSpecificationImpl@5c6cc46f, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@3aa48f46 (eventType: REMOVE, position: 0, notifier: InstanceSpecificationImpl@5c6cc46f, feature: EReferenceImpl@7e0aadd0 (name: classifier), oldValue: StereotypeImpl@322e17fc, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@4e4e5132 (eventType: REMOVE, position: 0, notifier: InstanceSpecificationImpl@5c6cc46f, feature: EReferenceImpl@7e0aadd0 (name: classifier), oldValue: StereotypeImpl@322e17fc, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@62b25e08 (eventType: REMOVE, position: 0, notifier: PortImpl@43d28c72, feature: EReferenceImpl@593e824f (name: end), oldValue: ConnectorEndImpl@86b5c5e5, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@4478cc7a (eventType: SET, position: -1, notifier: ConnectorEndImpl@86b5c5e5, feature: EReferenceImpl@3f23a3a0 (name: role), oldValue: PortImpl@43d28c72, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@5a38b50c (eventType: REMOVE, position: 0, notifier: PropertyImpl@d27a9f1a, feature: EReferenceImpl@72b16078 (name: _connectorEndOfPartWithPort), oldValue: ConnectorEndImpl@86b5c5e5, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@6643b8b8 (eventType: SET, position: -1, notifier: ConnectorEndImpl@86b5c5e5, feature: EReferenceImpl@25f7391e (name: partWithPort), oldValue: PropertyImpl@d27a9f1a, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@16f1f866 (eventType: REMOVE, position: 0, notifier: PortImpl@c74c01ea, feature: EReferenceImpl@593e824f (name: end), oldValue: ConnectorEndImpl@b6c7fc52, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@14e8fdde (eventType: SET, position: -1, notifier: ConnectorEndImpl@b6c7fc52, feature: EReferenceImpl@3f23a3a0 (name: role), oldValue: PortImpl@c74c01ea, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@709a5526 (eventType: REMOVE, position: 0, notifier: ClassImpl@6e968ce0, feature: EReferenceImpl@61bcd567 (name: ownedConnector), oldValue: ConnectorImpl@edd8f8a1, newValue: null, isTouch: false, wasSet: true)
ENotificationImpl@6931a19b (eventType: SET, position: -1, notifier: ConnectorImpl@edd8f8a1, feature: EReferenceImpl@2a76b80a (name: _structuredClassifierOfOwnedConnector), oldValue: ClassImpl@6e968ce0, newValue: null, isTouch: false, wasSet: true)

	 */
	
}
