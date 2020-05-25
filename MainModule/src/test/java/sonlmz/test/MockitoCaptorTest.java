package sonlmz.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MockitoCaptorTest {

    @Mock
    List mockedList;

    @Captor
    ArgumentCaptor argCaptor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void captorAnnotationTest() {
        mockedList.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());

        assertEquals("one", argCaptor.getValue());
    }



}
