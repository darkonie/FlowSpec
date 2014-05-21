package com.dthbs

class Delegator {

	public Delegator() {
		// TODO Auto-generated constructor stub
	}
	
	def build(Map args, String jobName) {}
	def build(String jobName) {}
	def guard(guardedClosure) {}
	def ignore(Result result, closure) {}
	def retry(int attempts, worstAllowed='SUCCESS', retryClosure) {}
	def List<FlowState> parallel(Collection<? extends Closure> closures) {}
}
