package com.incquerylabs.v4md.test.snapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.testing.core.SnapshotHelper;
import org.eclipse.viatra.query.testing.core.api.JavaObjectAccess;

import com.google.common.collect.Maps;
import com.nomagic.uml2.ext.jmi.helpers.ModelHelper;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Type;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.ConnectableElement;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;
import com.nomagic.uml2.ext.magicdraw.metadata.UMLPackage.Literals;

public class TestSnapshotHelperFactory {
	private Map<EClass, Function<EObject, String>> snapshotStringFunctionMap;
	
	public Map<EClass, Function<EObject, String>> getSnapshotStringFunctionMap() {
		return snapshotStringFunctionMap;
	}

	public TestSnapshotHelperFactory() {
		this.snapshotStringFunctionMap = new HashMap<EClass, Function<EObject, String>>();
		this.snapshotStringFunctionMap.put(Literals.CONNECTOR, element -> {
			Connector connector = (Connector) element;
			ConnectableElement firstRole = ModelHelper.getFirstEnd(connector).getRole();
			ConnectableElement secondRole = ModelHelper.getSecondEnd(connector).getRole();
			String fqn1 = firstRole.getQualifiedName();
			String fqn2 = secondRole.getQualifiedName();
			return (fqn1.compareTo(fqn2) <= 0) ? String.format("%s <-> %s", fqn1, fqn2) : String.format("%s <-> %s", fqn2, fqn1);
		});
		this.snapshotStringFunctionMap.put(Literals.PORT, element -> {
			Port port = (Port) element;
			return port.getQualifiedName();
		});
		this.snapshotStringFunctionMap.put(Literals.PROPERTY, element -> {
			Property property = (Property) element;
			String qualifiedName = property.getQualifiedName();
			if (property.getName() == null || property.getName().isEmpty()) {
				return String.format("%s -> : %s", qualifiedName.substring(0, qualifiedName.length() - 2), property.getType().getName());
			} else {
				Type type = property.getType();
				String typeName = "Untyped";
				if(type != null) {
					typeName = type.getName();
				}
				
				return String.format("%s : %s", qualifiedName, typeName);
			}
		});
		this.snapshotStringFunctionMap.put(Literals.NAMED_ELEMENT, element -> {
			NamedElement namedElement = (NamedElement) element;
			return namedElement.getQualifiedName();
		});
	}
	
	public SnapshotHelper createSnapshotHelper(Map<EClass, Function<EObject, String>> snapshotStringFunctionMap) {
		return new SnapshotHelper(Maps.<String, JavaObjectAccess>newHashMap(), snapshotStringFunctionMap);
	}
	
	public SnapshotHelper createSnapshotHelper() {
		return createSnapshotHelper(snapshotStringFunctionMap);
	}
}
