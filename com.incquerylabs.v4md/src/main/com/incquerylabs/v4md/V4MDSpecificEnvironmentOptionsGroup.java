package com.incquerylabs.v4md;

import java.awt.Color;
import java.util.List;
import java.util.Objects;

import com.incquerylabs.v4md.ui.V4MDResourcesUtil;
import com.nomagic.annotation.Used;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.GUILog;
import com.nomagic.magicdraw.core.options.AbstractPropertyOptionsGroup;
import com.nomagic.magicdraw.core.options.EnvironmentOptions.EnvironmentChangeListener;
import com.nomagic.magicdraw.properties.BooleanProperty;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.PropertyResourceProvider;
import com.nomagic.magicdraw.ui.notification.HRefRunnable;
import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;
import com.nomagic.magicdraw.ui.notification.config.NotificationViewConfig;

public class V4MDSpecificEnvironmentOptionsGroup extends AbstractPropertyOptionsGroup implements EnvironmentChangeListener {

	private static final String V4MD_DEVELOPER_MODE_REQUIRED = "Developer Mode is required. ";
	private static final String V4MD_GROUP_DEBUGGING_NAME = "Debugging";
	private static final String V4MD_GROUP_ID = "V4MD";
	private static final String V4MD_GROUP_NAME = "V4MD";
	public  static final String USE_EMPTY_QUERY_SCOPE_ID = "USE_EMPTY_QUERY_SCOPE";
	private static final String USE_EMPTY_QUERY_SCOPE_NAME = "Disable Model Indexing";
	private static final String USE_EMPTY_QUERY_SCOPE_DESCRIPTION = "For debugging purposes, this property disables model indexing by V4MD and all queries will return an empty result. After changing the property, you have to reload the currently open projects.";
	private static final String USE_EMPTY_QUERY_SCOPE_DESCRIPTION_ID = "USE_EMPTY_QUERY_SCOPE_DESCRIPTION_ID";
	private static final String USE_EMPTY_QUERY_SCOPE_NOTIFICATION_TITLE = "V4MD's empty scope is used";
	private static final String USE_EMPTY_QUERY_SCOPE_NOTIFICATION_MESSAGE = String.format("Currently, model indexing by V4MD is disabled, and all queries return an empty result. To re-enable indexing, please go to the Options->Environment->%s and uncheck %s. After changing the property, you have to reload the currently open projects.", V4MD_GROUP_NAME, USE_EMPTY_QUERY_SCOPE_NAME);
	private static final String USE_EMPTY_QUERY_SCOPE_WARNING_ENABLED = "Model indexing by V4MD is disabled. This can cause unexpected behavior. This feature is only useful for performance analysis. Re-enable indexing if you don't know what you are doing!";
	private static final String USE_EMPTY_QUERY_SCOPE_WARNING_PROJECTS = "All open projects have to be reloaded to actually disable the model indexing by V4MD on these models!";
	
	private BooleanProperty emptyScopeProperty = new BooleanProperty(USE_EMPTY_QUERY_SCOPE_ID, false);
	
	public V4MDSpecificEnvironmentOptionsGroup() {
		super(V4MD_GROUP_ID);
		createUseEmptyQueryScope(false);

		Application.getInstance().getEnvironmentOptions().addEnvironmentChangeListener(this);
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
	}

	@Used
	public boolean useEmptyQueryScope() {
		if(!isDeveloper()) {
			return false; // This property is only available in Developer Mode.
		}
		
		Property p = getProperty(USE_EMPTY_QUERY_SCOPE_ID);
		if (p == null) {
			return false; // This property is not yet set.
		}
		
		Boolean returnValue = (Boolean) p.getValue();
		if (returnValue) {
			// If this property is active, we notify the user about it.
			notifyWindow(V4MD_GROUP_ID, USE_EMPTY_QUERY_SCOPE_NOTIFICATION_TITLE, USE_EMPTY_QUERY_SCOPE_NOTIFICATION_MESSAGE);
		}		
		return returnValue;
	}

	public void createUseEmptyQueryScope(boolean enabled) {
		emptyScopeProperty.setGroup(V4MD_GROUP_DEBUGGING_NAME);
		emptyScopeProperty.setEditable(isDeveloper());
		if(!isDeveloper()) {
			emptyScopeProperty.setNonEditableReason(V4MD_DEVELOPER_MODE_REQUIRED);
		}
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
		addProperty(emptyScopeProperty, USE_EMPTY_QUERY_SCOPE_DESCRIPTION_ID);		
	}

	private void notifyWindow(String id, String title, String text) {
		NotificationViewConfig config = new NotificationViewConfig();
		config.setBackgroundColor(Color.WHITE);
		config.setExpirationTime(60);

		NotificationManager.getInstance().showNotification(new Notification(id, title, text, new HRefRunnable[] {}), config);
	}
	
	@Override
	public void updateByEnvironmentProperties(List<Property> properties) {
		GUILog log = Application.getInstance().getGUILog();
		if(properties.stream().anyMatch(x -> x.getID().equals(USE_EMPTY_QUERY_SCOPE_ID))) {
			Property p = getProperty(USE_EMPTY_QUERY_SCOPE_ID);
			if((Boolean) p.getValue()) {
				log.showWarning(USE_EMPTY_QUERY_SCOPE_WARNING_ENABLED);
				if(Application.getInstance().getProject() != null) {
					log.showWarning(USE_EMPTY_QUERY_SCOPE_WARNING_PROJECTS);
				}
			}
		}
	}
	
	@Override
	public javax.swing.Icon getGroupIcon() {
		return V4MDResourcesUtil.V4MD_ICON;
	}
	
	private boolean isDeveloper() {
		return Boolean.getBoolean("DEVELOPER");
	}
}
