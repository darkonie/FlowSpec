import groovy.util.GroovyTestCase
import com.dthbs.*

class ClassGeneratorTest extends GroovyTestCase {
	String className = "MyClass"
	
	void testClassGeneratorObject() {
		ClassGenerator cg = new ClassGenerator(className)
		assert cg.class == ClassGenerator.class
		cg.generateClass([p: "max.fax", c: "$className"])
		assert true == new File("${Constants.tmpClassPath}/${className}.java").exists()
		assert true == cg.cleanClass()
	}
}