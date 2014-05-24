package com.dthbs

import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer

class FlowDSL {
	CompilerConfiguration cc;
	ImportCustomizer ic;

	public FlowDSL() {
		// TODO Auto-generated constructor stub
		this.cc = new CompilerConfiguration();
		this.ic = new ImportCustomizer();
		cc.scriptBaseClass = ClosureScript.class.name;
	}
	
	private void executeFlowScript(String dsl) {
		this.cc.addCompilationCustomizers(this.ic);
		Delegator delegator = new Delegator();
		ClosureScript dslScript = (ClosureScript)new GroovyShell(getClass().getClassLoader(), new Binding(),this.cc).parse(dsl);
		dslScript.setDelegate(delegator);
		dslScript.run();
	}
}
