package com.incquerylabs.v4md;

import java.awt.Color;
import java.util.Objects;

import com.incquerylabs.v4md.ui.V4MDResourcesUtil;
import com.nomagic.annotation.Used;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.AbstractPropertyOptionsGroup;
import com.nomagic.magicdraw.properties.BooleanProperty;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.PropertyResourceProvider;
import com.nomagic.magicdraw.ui.notification.HRefRunnable;
import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;
import com.nomagic.magicdraw.ui.notification.config.NotificationViewConfig;

public class V4MDSpecificEnvironmentOptionsGroup extends AbstractPropertyOptionsGroup {

	private static final String V4MD_GROUP_ID = "V4MD";
	private static final String V4MD_GROUP_NAME = "VIATRA for MagicDraw";
	public static final String USE_EMPTY_QUERY_SCOPE_ID = "USE_EMPTY_QUERY_SCOPE";
	private static final String USE_EMPTY_QUERY_SCOPE_NAME = "Use empty query scope";
	private static final String USE_EMPTY_QUERY_SCOPE_DESCRIPTION = "For debugging purposes, this property disables the full featured VIATRA Query Scope and uses an empty implementation which always returns empty results. After changing the property, you have to reload the projects.";
	private static final String USE_EMPTY_QUERY_SCOPE_DESCRIPTION_ID = "USE_EMPTY_QUERY_SCOPE_DESCRIPTION_ID";
	private static final String USE_EMPTY_QUERY_SCOPE_NOTIFICATION_TITLE = "V4MD's empty scope is used";
	private static final String USE_EMPTY_QUERY_SCOPE_NOTIFICATION_MESSAGE = String.format("Currently, V4MD is disabled for debugging purposes. API is still working, but no calculation is executed using the VIATRA engine. All queries return empty set of matches. To enable V4MD, please go to the Options->Environment->%s and uncheck %s. After changing the property, you have to reload the projects.", V4MD_GROUP_NAME, USE_EMPTY_QUERY_SCOPE_NAME);

	public V4MDSpecificEnvironmentOptionsGroup() {
		super(V4MD_GROUP_ID);
	}

	public static V4MDSpecificEnvironmentOptionsGroup getCurrentGroup() {
		return (V4MDSpecificEnvironmentOptionsGroup) Application.getInstance().getEnvironmentOptions()
				.getGroup(V4MD_GROUP_ID);
	}

	public String getName() {
		return V4MD_GROUP_NAME;
	}

	@Override
	public void setDefaultValues() {
		super.setDefaultValues();
		setUseEmptyQueryScope(false);
	}

	@Used
	public boolean useEmptyQueryScope() {
		Property p = getProperty(USE_EMPTY_QUERY_SCOPE_ID);
		if (p == null)
			return false;
		
		Boolean returnValue = (Boolean) p.getValue();
		if (returnValue) {
			notifyWindow(V4MD_GROUP_ID, USE_EMPTY_QUERY_SCOPE_NOTIFICATION_TITLE, USE_EMPTY_QUERY_SCOPE_NOTIFICATION_MESSAGE);
		}
		
		return returnValue;
	}

	public void setUseEmptyQueryScope(boolean enabled) {
		final BooleanProperty emptyScopeProperty = new BooleanProperty(USE_EMPTY_QUERY_SCOPE_ID, enabled);
		emptyScopeProperty.setResourceProvider(new PropertyResourceProvider() {

			@Override
			public String getString(String key, Property property) {
				if (Objects.equals(USE_EMPTY_QUERY_SCOPE_ID, key))
					return USE_EMPTY_QUERY_SCOPE_NAME;
				if (Objects.equals(USE_EMPTY_QUERY_SCOPE_DESCRIPTION_ID, key))
					return USE_EMPTY_QUERY_SCOPE_DESCRIPTION;
				return key;
			}
		});

		emptyScopeProperty.setGroup("Debugging");
		setPropertyInvisible(USE_EMPTY_QUERY_SCOPE_ID, false);
		addProperty(emptyScopeProperty, USE_EMPTY_QUERY_SCOPE_DESCRIPTION_ID);		
	}

	private void notifyWindow(String id, String title, String text) {
		NotificationViewConfig config = new NotificationViewConfig();
		config.setBackgroundColor(Color.WHITE);
		config.setExpirationTime(60);

		NotificationManager.getInstance().showNotification(new Notification(id, title, text, new HRefRunnable[] {}), config);
	}
	
	@Override
	public javax.swing.Icon getGroupIcon() {
		return V4MDResourcesUtil.V4MD_ICON;
	}

}
