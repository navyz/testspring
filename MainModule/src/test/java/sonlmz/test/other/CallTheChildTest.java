package sonlmz.test.other;

import org.junit.Assert;
import org.junit.Test;
import sonlmz.other.UtilizeTheChild;


public class CallTheChildTest {

    @Test
    public void captorAnnotationTest() {
        String result = UtilizeTheChild.doSomthing();
        Assert.assertTrue(result.length() > 0);
    }
}
