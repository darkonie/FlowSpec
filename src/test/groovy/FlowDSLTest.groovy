import static org.junit.Assert.*;

import com.dthbs.FlowDSL
import org.junit.Test;


class FlowDSLTest extends GroovyTestCase{

	@Test
	public void test() {
		FlowDSL flow = new FlowDSL()
		String dsl = 'println "Hello World"'
		flow.executeFlowScript(dsl)
		assert 1 == 1
	}

}
