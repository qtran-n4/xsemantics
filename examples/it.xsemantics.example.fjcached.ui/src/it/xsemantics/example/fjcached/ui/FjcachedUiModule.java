/*
 * generated by Xtext
 */
package it.xsemantics.example.fjcached.ui;

import it.xsemantics.example.fjcached.ui.wizard.FjcachedProjectCreatorCustom;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.wizard.IProjectCreator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class FjcachedUiModule extends it.xsemantics.example.fjcached.ui.AbstractFjcachedUiModule {
	public FjcachedUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IProjectCreator> bindIProjectCreator() {
		return FjcachedProjectCreatorCustom.class;
	}
}