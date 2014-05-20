import groovy.util.GroovyTestCase
import com.dthbs.*

class FlowSpecMainTest extends GroovyTestCase {
	void testCreateFlowSpecMainObject() {
		println FlowSpecMain.class
		FlowSpecMain flow = new FlowSpecMain()
		assert flow.class == FlowSpecMain.class
	}
}
