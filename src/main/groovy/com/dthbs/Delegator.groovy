package com.dthbs

class Delegator {
	private static final INSTANCE = new Delegator()
	static getInstance() { return INSTANCE }
	static Map calledMethodsMap = [:]
	private Delegator() {}
	
	def updateCalledMethodsMap(String methodName) {
		if(calledMethodsMap[methodName]) {
			calledMethodsMap[methodName]++;
		  }
		  else {
			calledMethodsMap[methodName] = 1
		  }
	}
	
	// Delegated methods
	def build(String jobName) {
		build([:], jobName);
	}
	
	def build(Map args, String jobName) {
		String methodName = Thread.currentThread().stackTrace[10].methodName;
		updateCalledMethodsMap(methodName);
		println "\nSchedule job $jobName";
		println "Build $jobName #${calledMethodsMap[methodName]} started";
		println "$jobName #${calledMethodsMap[methodName]} completed\n";
	}
	
	def guard(guardedClosure) {
		String methodName = Thread.currentThread().stackTrace[10].methodName;
		updateCalledMethodsMap(methodName);
	}
	
	def ignore(Result result, closure) {
		String methodName = Thread.currentThread().stackTrace[10].methodName;
		updateCalledMethodsMap(methodName);
	}
	
	def retry(int attempts, worstAllowed='SUCCESS', retryClosure) {
		String methodName = Thread.currentThread().stackTrace[10].methodName;
		updateCalledMethodsMap(methodName);
	}
	
	def List<FlowState> parallel(Collection<? extends Closure> closures) {
		String methodName = Thread.currentThread().stackTrace[10].methodName;
		updateCalledMethodsMap(methodName);
	}
}