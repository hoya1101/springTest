package test.java.com.sap;

import static org.junit.Assert.assertEquals;
import main.java.com.sap.MavenSandbox;

import org.junit.Test;

public class MavenSandboxTest {

	@Test  
	public void test() {
		MavenSandbox tool = new MavenSandbox();
		assertEquals(tool.hello(),"Hello world"); 
	}

}
