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
		//println options.dsl
		
		if(options.h || options.arguments().size() < 1) {
			cli.usage();
		}
	}
}
