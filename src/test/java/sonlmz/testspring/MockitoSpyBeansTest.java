package sonlmz.testspring;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import sonlmz.service.Service01;
import sonlmz.service.Service02;
import sonlmz.service.Service03;
import sonlmz.service.Service04;
import sonlmz.service.impl.Service01Impl;
import sonlmz.service.impl.Service02Impl;
import sonlmz.service.impl.Service03Impl;
import sonlmz.service.impl.Service04Impl;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
public class MockitoSpyBeansTest {

    // Mock @AutoWire
    @SpyBean
    Service02Impl service02;

    // Mock @Resource
    @SpyBean
    Service03Impl service03;

    // Mock Injection (via constructor)
    @SpyBean
    Service04Impl service04;

    // Mock the main service because it's also a bean
    @SpyBean
    Service01Impl service01;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
        //service01 = new Service01Impl(service04);
    }

    @Test
    public void injectBeansTest()
    {

        // The getValue has not been overwritten at this stage, inherited from the original classes
        service01.One();
        Assertions.assertEquals("01", service01.getValue());
        Assertions.assertEquals("02", service02.getValue());
        Assertions.assertEquals("03", service03.getValue());
        Assertions.assertEquals("04", service04.getValue());

        // Define the method getValue for the Bean
        Mockito.when(service01.getValue()).thenReturn("fake 01");
        Mockito.when(service02.getValue()).thenReturn("fake 02");
        Mockito.when(service03.getValue()).thenReturn("fake 03");
        Mockito.when(service04.getValue()).thenReturn("fake 04");

        Mockito.doAnswer(test -> {
            System.out.println("Fake one: "
                    + service02.getValue() + " "
                    + service02.getValue() + " "
                    + service03.getValue() + " "
                    + service04.getValue());
            return null;
        }).when(service01).One();

        // Run again after the methods have been defined;
        service01.One();
        Assertions.assertEquals("fake 01", service01.getValue());
        Assertions.assertEquals("fake 02", service02.getValue());
        Assertions.assertEquals("fake 03", service03.getValue());
        Assertions.assertEquals("fake 04", service04.getValue());

    }

}
