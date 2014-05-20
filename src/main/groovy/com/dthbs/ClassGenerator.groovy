package com.dthbs;


import com.sun.tools.javac.Main
import groovy.text.SimpleTemplateEngine


public class ClassGenerator {
	static String className;
	String tmpClassPath = Constants.tmpClassPath
	String classTemplateName = "SimpleClass.template"
	
	public ClassGenerator(String className) {
		this.className = className
		File tmpClassDir = new File(tmpClassPath)
		if (!tmpClassDir.exists()) {
			tmpClassDir.mkdir()
		}
	}
	
	public createClass(Map params) {
		String clsTemplateResource = this.class.getResource("/${classTemplateName}").text
		
		SimpleTemplateEngine engine = new SimpleTemplateEngine()
		
		//Map b = [p: "com.mama", c: "MyClass"]
		String clsTemplate = engine.createTemplate(clsTemplateResource).make(params).toString()
		//String clsTemplate = template.toString()
		
        File classFile = new File("${tmpClassPath}/${className}.java")
		classFile.setText(clsTemplate)
		String[] s = ["-d", "${tmpClassPath}", "${tmpClassPath}/${className}.java"]
		Integer errCode = Main.compile(s)
	}	
}
