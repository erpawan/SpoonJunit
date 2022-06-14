import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtField;
import spoon.reflect.path.CtRole;
import spoon.reflect.visitor.filter.TypeFilter;

public class SpoonSample {
	
	static Launcher launcher = new Launcher();
	static CtModel model;
	

	public static void main(String[] args) {


		//launcher.addInputResource("D:\\POC - FILES\\JSQLParserDemo\\src\\main\\java\\ToolsQA\\JavaParser_DEMO\\CodeForJDBC.java");
		launcher.addInputResource("D:\\POC - FILES\\JSQLParserDemo\\src\\main\\java\\ToolsQA\\JavaParser_DEMO\\AIS_EXAMPLE.java");
		launcher.buildModel();
		model = launcher.getModel();
	}
	
	public void getGlobalFields(CtModel model) {
		for (CtField<?> ctField : model.getElements(new TypeFilter<>(CtField.class))) {
			System.out.print( ctField.getPath()+"\t\t");	
			System.out.print("\t"+ctField.getAssignment());    // CtField for GLOBAL_STATIC fields
			System.out.println();
		}
		
	}
	
	public void getLocalFields(CtModel model) {
	
	for (CtLocalVariable<?> variable : model.getElements(new TypeFilter<>(CtLocalVariable.class))) {
		//String fullPath=variable.getPath().toString();
		//System.out.println(methodName);
		//System.out.print( variable.getPath().toString().substring(variable.getPath().toString().indexOf("method"))+"\t\t");      
																// This is giving the
		System.out.print( variable.getPath()+"\t\t");			//scope name ex) from method, 
																//with method name etc..
		System.out.print("\t"+variable.getAssignment());
			System.out.println();
		}
}
}
		