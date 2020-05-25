package sonlmz.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import sonlmz.service.Service01;
import sonlmz.service.Service02;
import sonlmz.service.Service03;
import sonlmz.service.Service04;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
public class MockitoMockBeansTest {

    // Mock @AutoWire
    @MockBean
    Service02 service02;

    // Mock @Resource
    @MockBean
    Service03 service03;

    // Mock Injection (via constructor)
    @MockBean
    Service04 service04;

    // Mock the main service because it's also a bean
    @MockBean
    Service01 service01;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
        //service01 = new Service01Impl(service04);
    }

    @Test
    public void injectBeansTest()
    {

        // The getValue has not been define at this stage, all return null
        service01.One();
        Assertions.assertEquals(null, service01.getValue());
        Assertions.assertEquals(null, service02.getValue());
        Assertions.assertEquals(null, service03.getValue());
        Assertions.assertEquals(null, service04.getValue());

        // Define the method getValue for the Bean
        Mockito.when(service01.getValue()).thenReturn("fake 01");
        Mockito.when(service02.getValue()).thenReturn("fake 02");
        Mockito.when(service03.getValue()).thenReturn("fake 03");
        Mockito.when(service04.getValue()).thenReturn("fake 04");

        // This method has not been defined those. So it does not thing.
        service01.One();
        Assertions.assertEquals("fake 01", service01.getValue());
        Assertions.assertEquals("fake 02", service02.getValue());
        Assertions.assertEquals("fake 03", service03.getValue());
        Assertions.assertEquals("fake 04", service04.getValue());

    }

}
