package sonlmz.child.test;

import org.junit.Assert;
import org.junit.Test;
import sonlmz.child.Utils;

public class UtilTest {

    @Test
    public void captorAnnotationTest() {
        String result = Utils.beTested();
        Assert.assertTrue(result.length() > 0);
    }
}
