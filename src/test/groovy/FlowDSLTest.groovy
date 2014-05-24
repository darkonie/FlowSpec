import static org.junit.Assert.*;

import com.dthbs.*;
import org.junit.Test;


class FlowDSLTest extends GroovyTestCase{

	@Test
	public void test() {
		FlowDSL flow = new FlowDSL()
		String dsl = 'build("testjob"); build("AnotherJob")'
		flow.executeFlowScript(dsl)
		assert Delegator.calledMethodsMap["build"] == 2
	}

}
