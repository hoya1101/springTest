package util;

import static org.junit.Assert.assertEquals;
import com.sap.MavenSandbox;

import org.junit.Test;

public class MavenSandboxTest {

 @Test  
 public void test() {
  MavenSandbox tool = new MavenSandbox();
  assertEquals(tool.hello(),"Hello world"); 
 }

}
