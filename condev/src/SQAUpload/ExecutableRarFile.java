package SQAUpload;

import org.testng.TestNG;

public class ExecutableRarFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       TestNG testng=new TestNG();
       Class[] classes=new Class[] {CreateSQA.class};
       testng.setTestClasses(classes);
       testng.run();
       
	}

}
