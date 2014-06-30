package com.dthbs

import groovy.util.CliBuilder;
import org.apache.commons.cli.ParseException;


public class FlowSpecMain {
	public FlowSpecMain() {

	}
	
	public static void main(String[] args) {
		CliBuilder cli = new CliBuilder(usage: 'ls');
		cli.dsl(args:1, argName:'DslScript', 'Path to Build Flow DSL script');
		cli.h("Help")
		def options = cli.parse(args)

		if (options.h) {
			cli.usage();
		}

		// Run Build Flows cript
		if (options.dsl) {
			File dslFile = new File(options.dsl);
			FlowDSL flow = new FlowDSL();
			flow.executeFlowScript(dslFile.getText());
		}
		

	}
}
