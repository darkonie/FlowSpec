package com.dthbs

import groovy.lang.Binding
import groovy.lang.Script;

abstract class ClosureClass extends Script {
	private GroovyObject delegate;

	public ClosureClass() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ClosureClass(Binding binding) {
		super(binding);
		// TODO Auto-generated constructor stub
	}
	
	public void setDelegate(GroovyObject delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invokeMethod(String name, Object args) {
		try {
			return delegate.invokeMethod(name,args);
		} catch (MissingMethodException mme) {
			return super.invokeMethod(name, args);
		}
	}
	
	@Override
	public Object getProperty(String property) {
		try {
			return delegate.getProperty(property);
		} catch (MissingPropertyException e) {
			return super.getProperty(property);
		}
	}

	@Override
	public void setProperty(String property, Object newValue) {
		try {
			delegate.setProperty(property,newValue);
		} catch (MissingPropertyException e) {
			super.setProperty(property,newValue);
		}
	}
}
